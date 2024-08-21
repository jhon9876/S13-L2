package entities;

import jakarta.persistence.*;

@Entity /*Stiamo dichiarando che vogliamo che questa classe sia mappata ad una specifica tabella nel db*/
@Table(name = "evento") /*utile per personalizzare il nome della tabella*/
public class Evento {
    @Id /*indica quale attributo sarà la chiave primaria*/
    @GeneratedValue /*serve per dire al database di gestire automaticamente il valore degli id*/
    private long id;

    @Column(name = "titolo") /*utile per gestire il nome delle colonne e per aggiungere vincoli*/
    private String titolo;

    @Column(name = "dataevento")
    private String dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipoevento")
    /*Gli enum di default vengono trattati come interi nella tabella del db. Se voglio che essi
     * vengano rappresentati come testo devo usare @Enumarated*/
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "numero_max_partecipanti")
    private long numeroMaxPartecipanti;

    /*Ci deve essere obbligatoriamente un costruttore vuoto.*/
    public Evento() {
    }

    public Evento(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento='" + dataEvento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public long getNumeroMaxPartecipanti() {
        return numeroMaxPartecipanti;
    }
}
