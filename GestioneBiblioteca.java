
import java.util.Scanner;

public class GestioneBiblioteca {
    public static void main(String[] args) {
        // dichiaro uno Scanner per interi e uno per le stringhe
        Scanner myScannerInt = new Scanner(System.in);
        Scanner myScannerStr = new Scanner(System.in);
        // Inizializzo un utente a null per verificare l'effettivo login dell'utente
        Utente utente = null;
        boolean loggato = false;
        Biblioteca biblioteca = new Biblioteca("Biblioteca");

        // finche l'utente non è loggato gli chiedo di loggarsi o registrarsi
        while (utente == null) {
            // Menù Login/Register
            System.out.println("===ACCESSO LIBRERIA===");
            System.out.println("1 - Login/Register");
            System.out.println("2 - Esci");
            System.out.println("Selezionare un operazione: ");
            // registro l'input
            int sceltaUser = myScannerInt.nextInt();

            switch (sceltaUser) {
                // Login/Register
                case 1:
                    // chiedo userName
                    System.out.println("Inserisci Username: ");
                    // salvo l'input nella variabile
                    String nome = myScannerStr.nextLine();
                    // Creo l'oggetto utente
                    utente = new Utente(nome);
                    biblioteca.addUtente(utente);
                    loggato = true;
                    break;
                // Esci
                case 2:
                    // messaggio di uscita
                    System.out.println("Login o Register non effettuato!");
                    break;
                default:
                    System.out.println("Scelta non valida..");
                    break;
            }

        }

        // finchè l'utente resterà loggato avrà la visibilità del menù
        while (loggato) {
            // menù loggato
            System.out.println("===MENU' PRINCIPALE===");
            System.out.println("1 - Aggiungi nuova risorsa");
            System.out.println("2 - Visualizza tutta la libreria");
            System.out.println("3 - Prendi in prestito libro");
            System.out.println("4 - Restituisci libro");
            System.out.println("5 - Logout");
            // chiedo la selezione
            System.out.println("Selezionare un operazione: ");
            // registro l'input
            int sceltaMenu = myScannerInt.nextInt();

            switch (sceltaMenu) {
                // Aggiungo nuova risorsa
                case 1:
                    System.out.println("Che tipo di risorsa vuoi inserire? (Libro / Ebook / Rivista)");
                    String tipo = myScannerStr.nextLine().toLowerCase();
                    // se inserisco un libro procedo con il primo if
                    if (tipo.equals("libro")) {
                        System.out.println("Inserisci titolo:");
                        String titolo = myScannerStr.nextLine();
                        System.out.println("Inserisci anno di publicazione:");
                        int pubblicazione = myScannerInt.nextInt();
                        System.out.println("Inserisci autore:");
                        String autore = myScannerStr.nextLine();
                        Libro libro = new Libro(titolo, pubblicazione, autore);
                        biblioteca.addRisorsa(libro);
                        // se inserisco un ebook procedo con il secondo if
                    } else if (tipo.equals("ebook")) {
                        System.out.println("Inserisci titolo:");
                        String titolo = myScannerStr.nextLine();
                        System.out.println("Inserisci anno di publicazione:");
                        int pubblicazione = myScannerInt.nextInt();
                        System.out.println("Inserisci formato:");
                        String formato = myScannerStr.nextLine();
                        Ebook ebook = new Ebook(titolo, pubblicazione, formato);
                        biblioteca.addRisorsa(ebook);

                    } else if (tipo.equals("rivista")) {
                        System.out.println("Inserisci titolo:");
                        String titolo = myScannerStr.nextLine();
                        System.out.println("Inserisci anno di publicazione:");
                        int pubblicazione = myScannerInt.nextInt();
                        System.out.println("Inserisci numero rivista:");
                        int numero = myScannerInt.nextInt();
                        Rivista rivista = new Rivista(titolo, pubblicazione, numero);
                        biblioteca.addRisorsa(rivista);

                    }
                    break;
                case 2:
                    // stampo tutta la libreria
                    System.out.println("===BIBLIOTECA===");
                    biblioteca.visualizzaInventario();
                    break;
                case 3:
                    // prendi in prestito un libro
                    System.out.println("Inserisci codice ID: "); // chiedo codice libro
                    int codiceID = myScannerInt.nextInt(); // inizializzo la variabile
                    utente.prendiInPrestito(biblioteca.getListaRisorse(), codiceID); // richiamo la funzione
                    break;
                case 4:
                    // Restituisco libro
                    System.out.println("Inserisci codice ID: "); // chiedo codice libro
                    int idRestituito = myScannerInt.nextInt(); // inizializzo la variabile
                    utente.restituisci(idRestituito); // chiamo metodoper la restituzione
                    break;
                // Esci
                case 5:
                    // messaggio di uscita
                    System.out.println("Arrivederci!");
                    loggato = false;
                    break;
                default:
                    System.out.println("Scelta non valida..");
                    break;
            }

        }
        // chiusura scanner
        myScannerStr.close();
        myScannerInt.close();
    }
}
