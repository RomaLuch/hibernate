import config.JPAEntityManagerFactoryUtil;
import model.Message;

import javax.persistence.EntityManager;

public class MainJPA {
    public static void main(String[] args) throws Exception {

        EntityManager em = JPAEntityManagerFactoryUtil.getEntityManager();

        em.getTransaction().begin();

        Message message = new Message();
        message.setText("Hello from JPA");

        em.persist(message);
        em.getTransaction().commit();
    }
}
