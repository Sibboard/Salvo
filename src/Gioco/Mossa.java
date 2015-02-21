package Gioco;

/**
 * questa classe serve a definire oggetti di tipo mossa c he sarranno memorizzati in una stack
 * per essere usati dal metodo ritira per vberificare lo scacco, ecc ecc
 *
 * @author sibbor
 */
public class Mossa {
    
    private static Casella a;
    private static Casella da;
    private static Pezzo pezzo_mangiato;
    private static Scacchiera scacchiera;
    private static Colore turno;
            
    /**
     *
     */
    public Mossa(Scacchiera s, Colore turno, Casella source, Casella dest){
        new Mossa(s, turno, source, dest, null);
    }
    
    public Mossa(Scacchiera s, Colore turno, Casella source, Casella dest,Pezzo pezzo){
        this.pezzo_mangiato = pezzo;
        this.da = source;
        this.a = dest;
        this.scacchiera = s;
        this.turno = turno; 
    }
    
    @Override
    public String toString(){
        //return("(Scacchiera: "+ scacchiera.toString()+" ,  Turno: "+ turno.toString()+" ,  Mossa: "+ da + "->"+a);
        return("(Scacchiera: .... ,  Turno: "+ turno.toString()+" ,  Mossa: "+ da + "->"+a);
    }
    
    //------- NON SERVONO SETTER E GETTER ?!?! ora 
    public Pezzo getPezzo_mangiato(){
        return this.pezzo_mangiato;
    }
    
    public void setPezzo_mangiato(Pezzo pezzo){
        this.pezzo_mangiato = pezzo;
    }
    
}
