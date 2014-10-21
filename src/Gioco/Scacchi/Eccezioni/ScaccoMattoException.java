package Gioco.Scacchi.Eccezioni;

/**
 *
 * @author Sibbor
 */
public class ScaccoMattoException extends Exception {
    public ScaccoMattoException(){
        super("Scacco Matto!");
    }
}
