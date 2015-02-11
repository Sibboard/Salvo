package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;

/**
 *
 * @author sibbor
 */
public class Re extends PedinaScacchi {
    
    private static boolean primamossa;

    public Re(Colore giocatore) {
        super(giocatore);
        primamossa = true;
    }
    
    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        int si, sj, di, dj; // s = source  d = destination
        si = da.rowIndex; sj = da.columnIndex; di = a.rowIndex; dj = a.columnIndex;
        System.out.println("entrato in puoimuovere___RE");
        if(primamossa){
            if (Math.abs(si-di)<= 1 && Math.abs(sj-dj) <= 1)
                return true;
        }
        return false;
    }

    @Override
    public char getNome(){
        if(this.giocatore == Colore.BIANCO) return 'K';
                else return 'k';
    }
    
}
