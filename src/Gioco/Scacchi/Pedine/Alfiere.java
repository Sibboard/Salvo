package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;

import java.util.ArrayList;

/**
 *
 * @author sibbor
 */
public class Alfiere extends PedinaScacchi implements Traiettoria{

    public Alfiere(Giocatore colore) {
        super(colore);
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;
        
        if (Math.abs(si-di)== Math.abs(sj-dj)){
            return traiettoriaDiagonale(da,a,s);
        }else return false;
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

    @Override
    public boolean traiettoriaDiagonale(Casella da, Casella a, Scacchiera s){
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;
        ArrayList<Integer> asseI = getRange(si, di);
        ArrayList<Integer> asseJ = getRange(sj, dj);

        for(int i =  1; i < asseI.size(); i++){
            if(s.getPezzo(asseI.get(i), asseJ.get(i)) != null) {
                return false;
            }

        }
        
        return true;
    }

    private ArrayList<Integer> getRange(int a, int b) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int min = Math.min(a,b);
        int max = Math.max(a,b);

        for (int i = min; i < max; i++) {
            res.add(i);
        }

        return res;
    }
    
    @Override
    public boolean traiettoriaDritta(Casella da, Casella a, Scacchiera s){
        return false;
    }
}
    
    

