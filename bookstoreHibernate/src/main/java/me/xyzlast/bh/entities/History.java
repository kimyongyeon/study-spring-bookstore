package me.xyzlast.bh.entities;

import me.xyzlast.bh.constants.ActionType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ykyoon on 2/21/14.
 */
@Entity
@Table(name = "histories", schema = "", catalog = "bookstore")
public class History extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    @Basic
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "actionType")
    private ActionType actionType;
    @Basic
    @Column(name = "insertDate")
    private Timestamp insertDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        if (getId() != history.getId()) return false;
        if (actionType != history.actionType) return false;
        if (book != null ? !book.equals(history.book) : history.book != null) return false;
        if (user != null ? !user.equals(history.user) : history.user != null) return false;
        if (insertDate != null ? !insertDate.equals(history.insertDate) : history.insertDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + user.hashCode();
        result = 31 * result + book.hashCode();
        result = 31 * result + actionType.ordinal();
        result = 31 * result + (insertDate != null ? insertDate.hashCode() : 0);
        return result;
    }

    @PrePersist
    @PreUpdate
    public void setInsertProperties() {
        Date now = new Date();
        Timestamp time = new Timestamp(now.getTime());
        setInsertDate(time);
    }
}
