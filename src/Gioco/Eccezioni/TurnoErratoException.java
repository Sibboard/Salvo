package Gioco.Eccezioni;

/**
 *
 * @author Sibbor
 */
public class TurnoErratoException extends Exception {
    public TurnoErratoException(){
        super("Turno sbagliato, tocca a BIANCO/NERO");
        //prendere in input il turno attuale e scriverlo
    }
}
