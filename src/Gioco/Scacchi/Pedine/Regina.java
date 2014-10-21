package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;

/**
 *
 * @author sibbor
 */
public class Regina extends PedinaScacchi{

    public Regina(Giocatore colore) {
        super(colore);
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        if(da.rowIndex == a.rowIndex && da.columnIndex != a.columnIndex ||
                da.columnIndex == a.columnIndex && da.rowIndex != a.rowIndex){
            return traiettoria(da, a, s);
        }
        return false;
    }

    @Override
    public Giocatore getColore() {
        return this.colore;
    }
    
    @Override
    public char getNome(){
        if(this.getColore() == Giocatore.BIANCO) return 'Q';
                else return 'q';
    }
    
    public boolean traiettoriaDiagonale(Casella da, Casella a, Scacchiera s){
           int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;

        if(si < di){// la casella di arrivo sta sotto a quella di partenza
            if (sj < dj){ // alla destra di quella di partenza
                for(int i = 1;i<(dj-sj);i++){
                    if(s.getPezzo(si+i, sj+i) != null && si+i == di && sj+i == dj){
                        return true;
                    }else if (s.getPezzo(si+i, sj+i) != null) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    
    
    public boolean traiettoria(Casella da, Casella a, Scacchiera s){
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;
        
        if(si == di){ //stessa colonna
            if(sj < dj){  //devo scendere
                for(int i = sj +1; i < dj; i++){
                    if (s.getPezzo(di, i) != null) return false;
                }
            }else{
                for(int i = sj -1; i > dj; i--){
                    if(s.getPezzo(di,i) != null) return false;
                }
            }
        } // fine controllo sulla stessa riga
        else if(sj == dj){
            if(si < di){  //devo scendere
                for(int i = si +1; i < di; i++){
                    if (s.getPezzo(i, dj) != null) return false;
                }
            }else{
                for(int i = si -1; i > di; i--){
                    if(s.getPezzo(i,dj) != null) return false;
                }
            }
        }
        return true;
    }
}
