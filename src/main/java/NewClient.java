import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NewClient {
    public void addClient() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();;

        Session session = factory.getCurrentSession();
        Client client = null;
        
        try {
            session.getTransaction().begin();

            client = new Client();
            client.setCliName("Milos");
            client.setCliNo("0636426996");

            session.persist(client);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        assert client != null;
        System.out.println("Nom dernier client: " + client.getCliName());
    }
}