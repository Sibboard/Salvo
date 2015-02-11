package Gioco.Scacchi;
import Gioco.Pezzo;
import Gioco.*;


/**
 * @author sibbor
 la questa classe impleenta l'interfaccia Pezzo da cui riceve i metodi da implementare
 */
public class PedinaScacchi implements Pezzo {
    
    protected final Colore giocatore;
    private Casella casella;   //la casella dove si trova il pezzo
    
    public PedinaScacchi (Colore giocatore){
        this.giocatore = giocatore;
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
    
    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        return this.puoiMuovere(da,a,s);
    }
    
    //--------SETTER e GETTER per gli attributi del pezzo-------//
    
    @Override
    public Colore getColore(){
        return this.giocatore;
    } 

    @Override
    public Casella getCasella(){
        return this.casella;
        
    }
    
    @Override
    public void setCasella(){
        this.casella = null;
    }
    
    //overload per quando devo spostare un pezzo e gli cambio  
    public void setCasella(Casella in){
        this.casella = in;
    }

    @Override
    public char getNome() {
        return this.getNome();
    }
    

}
