import DAO.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    /*Riga di codice necessaria per stabilire una connessione con il db
     * persistenceUnitName è il nome della unit messo nel file persistence.xml*/
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");

    public static void main(String[] args) {
        /*La factory permette di creare degli oggetti EntityManager che contengono
         * i metodi per manipolare il database (es.save)*/
        EntityManager em = emf.createEntityManager();

        EventoDAO ed = new EventoDAO(em);

        /*Evento ev = new Evento("quadri", "15-02-2020", "visita museo", TipoEvento.PUBBLICO, 100);
        ed.save(ev);*/

        ed.delete(1);
    }
}
