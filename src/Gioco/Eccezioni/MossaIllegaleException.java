package Gioco.Eccezioni;

/**
 *
 * @author Sibbor
 */
public class MossaIllegaleException extends Exception{
    public MossaIllegaleException(){
        super("Mossa non valida, riprovare");
    }
    
}
