package Gioco;
import Gioco.Scacchi.*;

/**
 * questa classe serve a definire oggetti di tipo mossa che saranno memorizzati in una stack
 * per essere usati dal metodo ritira per vberificare lo scacco, ecc ecc
 *
 * @author sibbor
 */
public class Mossa {
    
    private PartitaScacchi partita;
    private Casella a;
    private Casella da;
    private Pezzo pezzo;
    private Pezzo pezzo_mangiato;
    private Scacchiera scacchiera;
    private Colore turno;
            
    /**
     *
     */
    public Mossa(PartitaScacchi p, Colore turno, Casella source, Casella dest){
        new Mossa(p, turno, source, dest, null);
    }
    
    public Mossa(PartitaScacchi p, Colore turno, Casella source, Casella dest, Pezzo pezzo){
        this.pezzo_mangiato = pezzo;
        this.da = source;
        this.a = dest;
        this.scacchiera = p.scacchiera;
        this.turno = turno;
        this.pezzo = scacchiera.getPezzo(da);
        this.partita = p;
    }
    
    @Override
    public String toString(){
        //return("(Scacchiera: "+ scacchiera.toString()+" ,  Turno: "+ turno.toString()+" ,  Mossa: "+ da + "->"+a);
        return("(Scacchiera: .... ,  Turno: "+ turno.toString()+" ,  Mossa: "+ da + "->"+a);
    }
    
    //------- NON SERVONO SETTER E GETTER ?!?! ora 
    
    public PartitaScacchi getPartitaScacchi(){
        return this.partita;
    }
    
    public Scacchiera getScacchiera(){
        return this.scacchiera;
    }
    
    public PedinaScacchi getPezzo(){
        return (PedinaScacchi)this.pezzo;
    }
    public PedinaScacchi getPezzo_mangiato(){
        return (PedinaScacchi)this.pezzo_mangiato;
    }
    
    public void setPezzo_mangiato(Pezzo pezzo){
        this.pezzo_mangiato = pezzo;
    }
    
    public Casella getCasellaA(){
        return this.a;
    }
    
    public Casella getCasellaDa(){
        return this.da;
    }
    
    public Colore getTurno(){
        return this.turno;
    }
    
   
}
