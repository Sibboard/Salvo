package Gioco;

/**
 * @author sibbor
 * La classe Casella definisce una vera e propria casella della scacchiera. 
 * vengono inizializzati gli indicidi riga e colonna della casella
 * 
 * 
 * COME LINKARE LA CASELLA AL PEZZO CHE CONTIENE ATTUALMENTE?? NECESSARIO??
 */

public class Casella {
    
    //rendere private queste variabili? oi addirittura final??
    public int rowIndex;
    public int columnIndex;
    
    public Casella(int r, int c){
        /*il costruttore prende in input gli indici della casella nella scacchiera e li memorizza
        */
        this.rowIndex = r;
        this.columnIndex = c;
    }
    
    @Override
    public String toString(){
        return ("("+this.rowIndex+","+this.columnIndex+")");
    }
    
    //public static void inserisci(Casella c, Pezzo p){
        //TODO
    
}
