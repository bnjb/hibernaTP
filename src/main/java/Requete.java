import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Requete {
    SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void allCommandesClient(){
        try {
            session.getTransaction().begin();

            String sql = "SELECT co.ComId, co.comDate, co.comHeure FROM " + Commande.class.getName() + " co " +
                    "INNER JOIN "+ Client.class.getName() +" cl on cl.CliId = co.client " +
                    "WHERE cl.CliName = :cliName " +
                    "OR cl.CliNo = :CliNo";

            // Create Query object.
            Query<Commande> query = session.createQuery(sql, Commande.class);

            query.setParameter("cliName", "njbaaronsofiane");
            query.setParameter("cliNo", "0102030405");

            // Execute query.
            List<Commande> commandes = query.getResultList();

            for (Commande co : commandes) {
                System.out.println("liste commande du client " + co.getComDate() + " : "
                        + co.getComHeure());
            }

            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}