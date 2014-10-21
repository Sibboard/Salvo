package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;

/**
 *
 * @author sibbor
 */
public class Alfiere extends PedinaScacchi{

    public Alfiere(Giocatore colore) {
        super(colore);
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Giocatore getColore() {
        return this.colore;
    }
    
    @Override
    public char getNome(){
        if(this.getColore() == Giocatore.BIANCO) return 'B';
                else return 'b';
    }
    
}
