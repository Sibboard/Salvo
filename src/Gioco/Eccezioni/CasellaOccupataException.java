package Gioco.Eccezioni;

/**
 *
 * @author Sibbor
 */
public class CasellaOccupataException extends Exception {
    public CasellaOccupataException(){
        super("La casella di destinazione è occupata da un pezzo dello stesso colore, riprovare");
    }
    
}
