package Gioco.Eccezioni;

/**
 *
 * @author Sibbor
 */
public class CasellaVuotaException extends Exception {
    public CasellaVuotaException(){
        super("La casella scelta non contiene nessuna pedina, riprovare");
    }
}
