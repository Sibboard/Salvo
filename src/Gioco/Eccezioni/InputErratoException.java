package Gioco.Eccezioni;

/**
 *
 * @author sibbor
 */
public class InputErratoException extends Exception{
    public InputErratoException(){
        super("Il formato della partita in input non è corretto, prego reinserirlo");
    }
}
