import config.HibernateSessionFactoryUtil;
import config.JPAEntityManagerFactoryUtil;
import model.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HibernateHelloWorldTest {

    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    @BeforeEach
    public void clearTable() {
        session.getTransaction().begin();
        session.createQuery("DELETE FROM Message").executeUpdate();
        session.getTransaction().commit();
    }

    @Test
    public void checkPersistAndGet() {
        Transaction tx = session.beginTransaction();
        Message m = new Message();
        m.setText("hello from hibernate");
        session.save(m);
        tx.commit();

        List<Message> messages = session.createCriteria(Message.class).list();

        assertEquals(messages.size(), 1);
        assertEquals(messages.get(0).getText(), "hello from hibernate");

        session.close();
    }
}
