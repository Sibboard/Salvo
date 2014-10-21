package Gioco.Scacchi.Eccezioni;

/**
 *
 * @author Sibbor
 */
public class PattaException extends Exception {
    public PattaException(){
        super("La partita è finita in parità");
        // aggiungere il motivo della parità:stallo, ripetizione, 50 mosse, pezi insuff...
    }
}
