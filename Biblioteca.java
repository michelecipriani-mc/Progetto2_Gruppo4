// Classe Biblioteca

// MEtodi : addUtente , addRisorsa , visualizzaUtenti , visualizzaInventario , cercaRisorsaPerTitolo
public class Biblioteca {

    // Variabili D istanza
    private String nome;
    private ArrayList<Risorsa> listaRisorse;
    private ArrayList<Utente> listaUtenti;

    // Costruttore
    public Biblioteca(String nome) {
        this.nome = nome;
        this.listaRisorse = new ArrayList<>();
        this.listaUtenti = new ArrayList<>();
    }

    // Getter del nome
    public String getNome() {
        return nome;
    }

    // Metodo per aggiungere uno studente
    public void addUtente(Utente utente) {
        // Controllo se l utente è null
        if (utente == null) {
            System.out.println("Errore: l'utente non può essere null.");
            return;
        }

        // Controllo duplicati in base a ID o nome
        for (Utente u : listaUtenti) {
            if (u.getId() == utente.getId() || u.getNome().equalsIgnoreCase(utente.getNome())) {
                System.out.println("Errore: utente gia presente.");
                return;
            }
        }
        listaUtenti.add(utente);
        System.out.println("Utente " + utente.getNome() + " aggiunto con successo.");
    }

    // Metodo per aggiungere una risorsa
    public void addRisorsa(Risorsa risorsa) {
        if (risorsa == null) {                          // se nulla errore
            System.out.println("Errore: la risorsa non può essere null.");
            return;
        }
        // Controllo duplicati per ID
        for (Risorsa r : listaRisorse) {
            if (r.getCodiceIdentificativo() == risorsa.getCodiceIdentificativo()) {
                System.out.println("Errore: Id risorsa già presente.");
                return;
            }
        }
        listaRisorse.add(risorsa);       // Aggiunge la risorsa se supre i controlli sopra
        System.out.println("Risorsa " + risorsa.getTitolo() + " aggiunta con successo.");
    }

    // Metodo per visualizzare gli utenti 
    public void visualizzaUtenti() {
        if (listaUtenti.isEmpty()) { // se la biblioteca è vuota messaggio di errore
            System.out.println("Nessun utente presente nella biblioteca.");
            return;
        }
        System.out.println("Utenti registrati nella biblioteca:");
        for (Utente u : listaUtenti) {                                      // altrimenti stampi gli utenti
            System.out.println("- Nome utente: " + u.getNome() + " ID: " + u.getId() + ")");
        }
    }

    // visualizza l invetario
    public void visualizzaInventario() {
        if (listaRisorse.isEmpty()) {            // se è vuoto errore nessuna risorsa disponibile
            System.out.println("Nessuna risorsa disponibile nella biblioteca.");
            return;
        }
        System.out.println("Inventario della biblioteca:");
        for (Risorsa r : listaRisorse) {
            r.visualizzaDettagli();              // altrimenti stampo tutte le info dell inventario
        }
    }

    // Metodo cercaRisorsaTitolo
    public void cercaRisorsaPerTitolo(String titolo) {
         for (Risorsa r : listaRisorse) {
            if (r.getTitolo().equalsIgnoreCase(titolo)) {    // se il nome coincide risorsa trovata
                r.visualizzaDettagli();                    // visualizzo i dettagli della risorsa
                return;
            }
        }
        System.out.println("Risorsa con titolo " + titolo + " non trovata.");
    }
}