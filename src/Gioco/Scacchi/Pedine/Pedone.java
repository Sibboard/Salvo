package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;
import Gioco.Colore.*;
import java.lang.Math.*;

/**
 *
 * @author Sibbor
 */
public class Pedone extends PedinaScacchi {
    
    private boolean doppio;
    

    public Pedone(Colore giocatore) {
        super(giocatore);
        doppio = true;
        //un controllo per le partite gia iniziate? distinto per ogni giocatore?
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        
        int da_r = da.rowIndex ;
        int da_c = da.columnIndex;
        int a_r = a.rowIndex;
        int a_c = a.columnIndex;
        
        if( Math.abs(da_r - a_r) == 1 && Math.abs(a_c - da_c) == 1){
        // se sta mangiando controllo che si muova nella direzione giusta
            if(direzioneGiocatore(da_r, a_r)) return true;
            else return false;
            
        }else if(Math.abs(da_r - a_r) == 1 && a_c == da_c){
        // se si sta muovendo di uno in avanti
            if(direzioneGiocatore(da_r, a_r)) return true;
            else return false;
            
        }else if(Math.abs(da_r - a_r) == 2 && a_c == da_c){
            if(this.doppio && direzioneGiocatore(da_r, a_r))
                //salvare nello stato della partita la psossibilità di en passant
                /* if a sinistra o destra dalla casella a, c'è un pedon eavversario*/
               
                return true;
            else return false;
            
        }else return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean direzioneGiocatore(int da_r, int a_r){
        /*controlla che il pedone si stia muovendo nella direzione permessa al giocatore*/
        
        if(this.getColore() == Colore.BIANCO && da_r > a_r) return true;
        else if(this.getColore() == Colore.NERO && da_r < a_r) return true;
        else return false;
    }

    @Override
    public Colore getColore() {
        return this.giocatore;
    }
    
    @Override
    public char getNome(){
        if(this.getColore() == Colore.BIANCO) return 'P';
                else return 'p';
    }

    
    
}
