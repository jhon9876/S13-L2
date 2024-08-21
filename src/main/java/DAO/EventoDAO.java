package DAO;

import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

// DAO (Data Access Object) è un Design Pattern. Questa classe ci serve per semplificare l'interazione con il database
// Semplificare nel senso di nascondere dei dettagli implementativi che in alcuni casi potrebbero essere anche ben complessi
// Nascondendoli forniamo a chi avrà bisogno di interagire con la tabella degli studenti, dei metodi pratici e semplici da utilizzare
// magari anche dotandoli di nomi appropriati e "parlanti"
public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    //I metodi save e delete hanno la necessità di essere incorporati in transazioni in maniera tale che se qualcosa va storto
    //nell operazioni di save e delete, tutte le operazioni vengano annullate.
    public void save(Evento evento) {
        // 1. Chiediamo all'entity manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();
        // 3. Aggiungiamo lo studente al Persistence Context (a questo step lo studente non è ancora salvato a db)

        em.persist(evento);

        // 4. Concludiamo la transazione (qua lo studente verrà effettivamente salvato)
        transaction.commit();

        System.out.println("L'evento " + " è stato creato correttamente");
    }

    public Evento getById(long eventoId) {
        Evento found = em.find(Evento.class, eventoId);

        return found;
    }

    public void delete(long eventoId) {
        // 0. Cerco lo studente nel db
        Evento found = this.getById(eventoId);
        // 1. Chiediamo all'entity manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // 2. Facciamo partire la transazione
        transaction.begin();
        // 3. Rimuoviamo lo studente dal Persistence Context (a questo step lo studente non è ancora stato rimosso effettivamente dal db)
        em.remove(found);
        // 4. Concludiamo la transazione (qua lo studente verrà effettivamente rimosso)
        transaction.commit();

        System.out.println("Lo studente con quell'Id è stato rimosso correttamente");
    }


}
