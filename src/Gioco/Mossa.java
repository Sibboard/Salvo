package Gioco;

/**
 * questa classe serve a definire oggetti di tipo mossa c he sarranno memorizzati in una stack
 * per essere usati dal metodo ritira per vberificare lo scacco, ecc ecc
 *
 * @author sibbor
 */
public class Mossa {
    
    Casella a;
    Casella da;
    private boolean pezzo_mangiato;
    
    /**
     *
     */
    public Mossa(Scacchiera s, Colore turno, Casella source, Casella dest){
        //this.turno = turnoin; me lo passa perchè salvarlo
        
        try{
            if(s.getPezzo(a).getColore() != s.getPezzo(da).getColore() && s.getPezzo(a) != null){
                this.pezzo_mangiato = true;
            }else this.pezzo_mangiato = false;
        }catch (NullPointerException e){
            
            
        }
          
        
        this.da = source;
        this.a = dest;
        
    }
    
    
    //------- NON SERVONO SETTER E GETTER ?!?! ora 
    public boolean getPezzo_mangiato(){
        return this.pezzo_mangiato;
    }
    public void setPezzo_mangiato(boolean value){
        this.pezzo_mangiato = value;
    }
    
}
