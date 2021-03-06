package me.xyzlast.bookstore;

import me.xyzlast.bookstore.dao.BookDaoImpl;
import me.xyzlast.bookstore.entities.Book;

import java.util.List;

/**
 * Created by ykyoon on 12/18/13.
 */
public class BookAppMain {
    public static void main(String[] args) throws Exception {
        System.out.println("start main app");

        Book book = new Book();
        book.setName("Spring 3.1");
        book.setAuthor("작가");
        book.setPublishDate(new java.util.Date());
        book.setComment("좋은 책입니다.");

        BookDaoImpl app = new BookDaoImpl();
        app.add(book);

        List<Book> books = app.getAll();
        for(Book b : books) {
            System.out.println(b);
        }
        return;
    }


    private int seq;
    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getString(String input) {
        String upperChar = input.substring(seq, seq + 1).toUpperCase();
        String firstSeq = input.substring(0, seq).toLowerCase();
        String lastSeq = input.substring(seq + 1).toLowerCase();

        return firstSeq + upperChar + lastSeq;
    }
}
