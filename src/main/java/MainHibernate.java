import config.HibernateSessionFactoryUtil;
import model.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainHibernate {
    public static void main(String[] args) throws Exception {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Message m = new Message();
        m.setText("hello");
        session.save(m);
        tx.commit();
        session.close();
    }
}
