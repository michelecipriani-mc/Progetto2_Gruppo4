abstract class Risorsa {
    // Attributi per tutte le condivisi con tutte le "Risorse"
    protected String titolo;
    protected int annoPubblicazione;
    protected int codiceIdentificato;
    private static int contatoreRisorse = 0; // Contatore per tenere traccia del numero di risorse create
    protected boolean disponibile = true; // Indica se la risorsa è disponibile

    // Inizio metodi getter e setter
    // Questi metodi sono utilizzati per accedere e modificare gli attributi della
    // classe
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getCodiceIdentificato() {
        return codiceIdentificato;
    }

    public void setCodiceIdentificato(int codiceIdentificato) {
        this.codiceIdentificato = codiceIdentificato;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    // Fine metodi getter e setter
    // Costruttore della classe Risorsa
    public Risorsa(String titolo, int annoPubblicazione) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        contatoreRisorse++;
        this.codiceIdentificato = contatoreRisorse; // Genera un codice identificativo unico
    }

    public void visualizzaDettagli() {// metodo che stampa i dettagli della risorsa super()
        System.out.println("Titolo: " + titolo);
        System.out.println("Anno di pubblicazione: " + annoPubblicazione);
        System.out.println("Codice identificativo: " + codiceIdentificato);
    }
}

class Libro extends Risorsa {
    private String autore;

    // Inizio metodi getter e setter specifici per la classe Libro
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    // Fine metodi getter e setter specifici per la classe Libro
    // Costruttore della classe Libro che chiama il costruttore della superclasse
    // Risorsa
    public Libro(String titolo, int annoPubblicazione, String autore) {
        super(titolo, annoPubblicazione);
        this.autore = autore;
    }

    // Metodo che visualizza i dettagli del libro, inclusi quelli della superclasse
    @Override // Override indica che questo metodo sta sovrascrivendo un metodo della
              // superclasse "Risorsa""
    public void visualizzaDettagli() {
        super.visualizzaDettagli();
        System.out.println("Autore: " + autore);
    }
}

class Rivista extends Risorsa {
    private int numeroRivista;

    // Inizio metodi getter e setter specifici per la classe Rivista
    public int getNumeroRivista() {
        return numeroRivista;
    }

    public void setNumeroRivista(int numeroRivista) {
        this.numeroRivista = numeroRivista;
    }

    // Fine metodi getter e setter specifici per la classe Rivista
    // Costruttore della classe Rivista che chiama il costruttore della superclasse
    // Risorsa
    public Rivista(String titolo, int annoPubblicazione, int numeroRivista) {
        super(titolo, annoPubblicazione);
        this.numeroRivista = numeroRivista;
    }

    // Metodo che visualizza i dettagli del Rivista, inclusi quelli della
    // superclasse
    @Override // Override indica che questo metodo sta sovrascrivendo un metodo della
              // superclasse "Risorsa""
    public void visualizzaDettagli() {
        super.visualizzaDettagli();
        System.out.println("Numero rivista : " + numeroRivista);
    }
}

class Ebook extends Risorsa {
    private String formato;

    // Inizio metodi getter e setter specifici per la classe Ebook
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        // validazione formato ebook
        if (formato.equalsIgnoreCase("PDF") || formato.equalsIgnoreCase("EPUB") || formato.equalsIgnoreCase("MOBI")) {
            this.formato = formato;
        } else {
            throw new IllegalArgumentException("Formato non valido. Deve essere PDF, EPUB o MOBI.");
        }
    }

    // Fine metodi getter e setter specifici per la classe Ebook
    // Costruttore della classe Ebook che chiama il costruttore della superclasse
    // Risorsa
    public Ebook(String titolo, int annoPubblicazione, String formato) {
        super(titolo, annoPubblicazione);
        setFormato(formato);
        // Utilizzo del metodo setter per validare il formato
    }

    // Metodo che visualizza i dettagli del Ebook, inclusi quelli della superclasse
    @Override // Override indica che questo metodo sta sovrascrivendo un metodo della
              // superclasse "Risorsa""
    public void visualizzaDettagli() {
        super.visualizzaDettagli();
        System.out.println("Autore: " + formato);
    }
}
