package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;

/**
 *
 * @author Sibbor
 */
public class Torre extends PedinaScacchi implements Traiettoria {

    public Torre(Giocatore colore) {
        super(colore);
        //public boolean arrocco;
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(da.rowIndex == a.rowIndex && da.columnIndex != a.columnIndex ||
                da.columnIndex == a.columnIndex && da.rowIndex != a.rowIndex){
            return traiettoriaDritta(da, a, s);
        }
        return false;
    }

    @Override
    public Giocatore getColore() {
        return this.colore;
    }
    
    @Override
    public char getNome(){
        if(this.getColore() == Giocatore.BIANCO) return 'R';
                else return 'r';
    }
    
    @Override
    public boolean traiettoriaDritta(Casella da, Casella a, Scacchiera s){
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;

        int srcAsse = (si == di) ? sj : si;
        int destAsse = (sj == dj) ? di : dj;
        int destAsseMovimento = (sj == dj) ? dj : di;

        int max = Math.max(srcAsse, destAsse);
        int min = Math.min(srcAsse, destAsse);

        for(int i = min + 1; i < max; i++){
            if(srcAsse == si && s.getPezzo(destAsseMovimento, i) != null) {
               return false;
            }
            else if(srcAsse == sj && s.getPezzo(i,destAsseMovimento) != null) {
                return false;
            }
        }

        return true;
    }
    
    @Override
    public boolean traiettoriaDiagonale(Casella da, Casella a, Scacchiera s){
        return false;
    }

    
    //public boolean TraiettoriaDiagonale(Scacchiera s){
      //  return false;
    //}
}
