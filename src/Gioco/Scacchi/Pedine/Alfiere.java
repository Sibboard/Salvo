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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //check se la mossa è legale
        return Traiettoria(da,a,s);
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
    public boolean Traiettoria(Casella da, Casella a, Scacchiera s){
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
        if(a > b) {
            for (int i = b; i < a; i++) {
                res.add(i);
            }
        }
        else {
            for(int i = a; i < b; i++) {
                res.add(i);
            }
        }
        return res;
    }

}
    
    

