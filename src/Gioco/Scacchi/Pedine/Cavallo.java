package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;

/**
 * * @author sibbor
 * questa classe implementa il cavallo. 
 */
public class Cavallo extends PedinaScacchi{
    
    public Cavallo(Colore giocatore){
        super(giocatore);
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int si, sj, di, dj;
        si = da.rowIndex;
        sj = da.columnIndex;
        di = a.rowIndex;
        dj = a.columnIndex;
               
        if ((Math.abs(si-di) == 1 && Math.abs(sj-dj) == 2) ||
                (Math.abs(si-di) == 2 && Math.abs(sj-dj) == 1)){
            return true;
        }else return false;
    }

    @Override
    public Colore getColore() {
        return this.giocatore;
    }
    
    @Override
    public char getNome(){
        if(this.getColore() == Colore.BIANCO) return 'N';
                else return 'n';
    }
        
}
