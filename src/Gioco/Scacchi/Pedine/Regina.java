package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;
import java.util.ArrayList;

/**
 *
 * @author sibbor
 */
public class Regina extends PedinaScacchi implements Traiettoria{

    public Regina(Colore giocatore) {
        super(giocatore);
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;
        
        if(si == di && sj != dj || sj == dj && si != di){
            return traiettoriaDritta(da, a, s);
        }else if (Math.abs(si-di) == Math.abs(sj-dj)){
            return traiettoriaDiagonale(da,a,s);
        }else return false;
    }
 
    @Override
    public char getNome(){
        if(this.giocatore == Colore.BIANCO) return 'Q';
                else return 'q';
    }
    
    @Override
    public boolean traiettoriaDritta(Casella da, Casella a, Scacchiera s){
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;

        int srcAsse = (si == di) ? sj : si;
        
        int destAsse = (sj == dj) ? di : dj;//invertito di:dj --->dj:di
        int destAsseMovimento = (sj == dj) ? dj : di;

        int max = Math.max(srcAsse, destAsse);
        int min = Math.min(srcAsse, destAsse);

        for(int i = min + 1; i < max; i++) {
            if((srcAsse == sj && s.getPezzo(destAsseMovimento, i) != null) ||
               (srcAsse == si && s.getPezzo(i,destAsseMovimento) != null)){
               return false;
            }
        }
        return true;
    }
    
    
    @Override
    public boolean traiettoriaDiagonale(Casella da, Casella a, Scacchiera s){
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;
        ArrayList<Integer> asseI = getRange(si, di);
        ArrayList<Integer> asseJ = getRange(sj, dj);

        for(int i =  0; i < asseI.size(); i++){
            if(s.getPezzo(asseI.get(i), asseJ.get(i)) != null) {
                //System.out.println(s.getPezzo(asseI.get(i), asseJ.get(i))+" casella: "+
                  //      s.getPezzo(asseI.get(i), asseJ.get(i)).getCasella());
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> getRange(int a, int b) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        
        if(a > b) for (int i = a-1; i > b; i--) res.add(i);
        else for(int i = a+1; i < b; i++) res.add(i);            
        return res;
    }
}
    
    