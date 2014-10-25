package Gioco;

/**
 *interfaccia di supporto per implenentare, nelle pedine che lo richiedono 
 * (regina, alfiere, torre, ..), un metodo che controlla se le caselle che
 * andrannao attraversate dalla pedina sono occupate
 * @author sibbor
 */
public interface Traiettoria {
    
    public boolean traiettoriaDiagonale(Casella da, Casella a, Scacchiera s);
    public boolean traiettoriaDritta(Casella da, Casella a, Scacchiera s);
    
}
