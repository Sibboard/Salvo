package Gioco;

/**
 *
 * @author sibbor
 l'interfaccia Pezzo fornisce una implementazione comune per i pezzi (eventualmente
 anche di altri giochi).
 */
public interface Pezzo {
        
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s);
        /* controllare sul sito il terrzo argomento*/
        /* controlla se la mossa scelta per il pezzo è legale */
    
    public Colore getColore();
            /* ritorna il colore del pezzo che si vuole */
    
    //public rimuovi pedina??? mettere controllo sulla sufficienza dei pezzi da scacchiera
    
    public char getNome();
        /*ritorna il char che rappresenta il pezzo"*/
    
    
    public Casella getCasella();
        /*ritorna la casella dove si trova il pezzo, metodo di servizio per le chiamate a puoi muovere */
    
    public void setCasella();
        /*cambia la casella doive si trova il pezzo */
    
    @Override
    public String toString();
}
