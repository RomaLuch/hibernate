import config.JPAEntityManagerFactoryUtil;
import model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JpaHelloWorldTest {

    EntityManager em = JPAEntityManagerFactoryUtil.getEntityManager();

    @BeforeEach
    public void clearTable() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query clearMessage = em.createQuery("DELETE FROM Message");
        clearMessage.executeUpdate();
        tx.commit();
    }

    @Test
    public void checkPersistAndGet() {
        Query msgGet = em.createQuery("select m from Message m");

        assertEquals(msgGet.getResultList().size(), 0);

        Message message = new Message();
        message.setText("Hello from JPA");

        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();

        List<Message> messageList = msgGet.getResultList();

        assertEquals(messageList.size(), 1);
        assertEquals(messageList.get(0).getText(), "Hello from JPA");
    }
}
