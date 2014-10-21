package Gioco.Scacchi.Eccezioni;

/**
 *
 * @author Sibbor
 */
public class ReSottoScaccoException extends Exception {
    public ReSottoScaccoException(){
        super("Mossa non valida, il re è sotto scacco!");
    }
    
    
}
