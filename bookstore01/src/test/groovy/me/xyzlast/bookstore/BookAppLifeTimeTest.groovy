package me.xyzlast.bookstore

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by ykyoon on 12/18/13.
 */
@ContextConfiguration("classpath:applicationContext.xml")
class BookAppLifeTimeTest extends Specification {
    @Autowired
    ApplicationContext context;

    @Shared
    static List<BookApp> bookApps = new ArrayList<>()

    def "singleton type object 확인"() {
        println "singleton bookApp list : "
        bookApps.clear()
        when:
        (0..9).each {
            BookApp bookApp = context.getBean("bookApp-singleton")
            println bookApp
            if(!bookApps.contains(bookApp)) {
                bookApps.add(bookApp)
            }
        }
        then:
        bookApps.size() == 1
    }

    def "prototype type object 확인"() {
        println "prototype bookApp list : "
        bookApps.clear()
        when:
        (0..9).each {
            BookApp bookApp = context.getBean("bookApp-prototype")
            println bookApp
            if(!bookApps.contains(bookApp)) {
                bookApps.add(bookApp)
            }
        }
        then:
        bookApps.size() == 10
    }
}
