package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;
import Gioco.Giocatore.*;
import java.lang.Math.*;

/**
 *
 * @author Sibbor
 */
public class Pedone extends PedinaScacchi {
    
    private boolean doppio;
    

    public Pedone(Giocatore colore) {
        super(colore);
        
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        
        int da_r = da.rowIndex ;
        int da_c = da.columnIndex;
        int a_r = a.rowIndex;
        int a_c = a.columnIndex;
        
        if( Math.abs(da_r - a_r) == 1 && Math.abs(a_c - da_c) == 1){
        // se sta mangiando controllo che si muova nella direzione giusta
            if(this.getColore() == Giocatore.BIANCO && da_r > a_r) return true;
            else if(this.getColore() == Giocatore.NERO && da_r < a_r) return true;
            else return false;
            
        }else if(Math.abs(da_r - a_r) == 1 && a_c == da_c){
        // se si sta muovendo di uno in avanti
            if(this.getColore() == Giocatore.BIANCO && da_r > a_r) return true;
            else if(this.getColore() == Giocatore.NERO && da_r < a_r) return true;
            else return false;
            
        }else if(Math.abs(da_r - a_r) == 2 && a_c == da_c){
           // if(doppio){
             //   FIIIIX
            return true;
        }
        
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean direzioneGiocatore(int da_r, int a_r){
        if(this.getColore() == Giocatore.BIANCO && da_r > a_r) return true;
        else if(this.getColore() == Giocatore.NERO && da_r < a_r) return true;
        else return false;
    }

    @Override
    public Giocatore getColore() {
        return this.colore;
    }
    
    @Override
    public char getNome(){
        if(this.getColore() == Giocatore.BIANCO) return 'P';
                else return 'p';
    }

    
    
}
