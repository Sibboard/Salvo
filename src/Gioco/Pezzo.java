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
    
    public Giocatore getColore();
            /* ritorna il colore del pezzo che si vuole */
    
    //public rimuovi pedina??? mettere controllo sulla sufficienza dei pezzi da scacchiera
    
    public char getNome();
        /*ritorna il char che rappresenta il pezzo"*/
    
    @Override
    public String toString();
}
