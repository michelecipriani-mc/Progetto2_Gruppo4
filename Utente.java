import java.util.ArrayList;

// Classe Utente

//Metodi : restituisci , prendiInPrestito
public class Utente {

    // Metodi d istanza 
    private String nome;
    private int id;
    private ArrayList<Risorsa> libriPresiInPrestito;

    private static int contatore = 0;       // Metodo statico per contare ogni utente creato

    public Utente(String nome) {
        contatore++;
        this.nome = nome;
        this.id = contatore; 
        this.libriPresiInPrestito = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static int getContatore() {
        return contatore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Metodo per restituire la risorsa
    public void restituisci(Risorsa risorsa) {
        if (libriPresiInPrestito.contains(risorsa)) {           // Controllo se nella libriPresiInPrestito è presente la risorsa passata
            risorsa.setDisponibile(true);               // imposto disponibilita su true perche viene tolta dalla lista utente
            libriPresiInPrestito.remove(risorsa);
            System.out.println("Hai restituito: " + risorsa.getTitolo());
        } else {
            System.out.println("Risorsa non presente nella lista.");
        }
    }

    // Prendi in prestito una risorsa se disponibile per id
    public void prendiInPrestito(ArrayList<Risorsa> catalogo, int id) {
        for (Risorsa r : catalogo) {
            if (r.getCodiceIdentificativo() == id) {                   // Controllo per id
                if (r.isDisponibile()) {
                    r.setDisponibile(false);         // se corrispondesetto la disponibilita su false perche il libro non è piu disponibile
                    libriPresiInPrestito.add(r);             // aggiungo la risorsa alla lista delle risorse prese in prestito             
                    System.out.println("Hai preso in prestito: " + r.getTitolo());
                } else {
                    System.out.println("Risorsa non disponibile.");     // Risorsa non disponibile
                }
                return;
            }
        }
        System.out.println("Risorsa con ID " + id + " non trovata.");
    }

}
