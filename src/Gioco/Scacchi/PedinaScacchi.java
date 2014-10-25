package Gioco.Scacchi;
import Gioco.Pezzo;
import Gioco.*;


/**
 * @author sibbor
 la questa classe impleenta l'interfaccia Pezzo da cui riceve i metodi da implementare
 */
public abstract class PedinaScacchi implements Pezzo {
    
    public final Giocatore colore;
    
    public PedinaScacchi (Giocatore color){
        this.colore = color;
    }
       
    @Override
    public String toString(){
        try{
            String  output = "";
            return output += this.getNome();
        }catch (NullPointerException e){
            return ".";
        }
            
    }
    
    //public abstract boolean traiettoriaOccupata(Casella a , Casella da);
    // metodo per la traiettoria TODO
    
    
    // ma è brutto fare classi astratte i pezzi che non implementano alcuni metodi?
}
