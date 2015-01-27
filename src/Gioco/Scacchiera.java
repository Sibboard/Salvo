package Gioco;

import Gioco.Scacchi.*;
import Gioco.Scacchi.Pedine.*;

/**
 * *** @author sibbor
 la classe Scacchiera definisce il campo di gioco: una matrice di oggetti Pezzo, con misure variabili
 */
public class Scacchiera {
    
    private Pezzo[][] scacchiera; /*provare FINAL */
    public int width, height;
    
    
    
    public Scacchiera(int h, int w){
        /*costruttore che inizializza una matrice height*width di oggetti Pezzo e memorizza le sue dimensioni */
        
        scacchiera = new Pezzo[h][w];
        /*for(int i = 0; i< 8; i++){
            for(int j = 0; j<8; j++){
                System.out.print(scacchiera[i][j]);
            }
            System.out.println(i);
        }*/
        this.height = h;
        this.width = w;
    }
    
    public Pezzo getPezzo(Casella c){
        /*getPezzo ritorna il pezzo di una casella*/
        
        return scacchiera[c.rowIndex][c.columnIndex];
    }
    
    
    public Pezzo getPezzo(int traversa, int indice){
        /* getPezzo che prende i ninput gli indici di scacchiera */
        return scacchiera[traversa][indice];
    }
    
    /* metodo per settare null le caselle vuote+ */
    //-------inutilizzato---------
    public void setCasellaNull(int traversa, int indice){
        scacchiera[traversa][indice] = null;
    }
    
    //System.out.println(PezziNeri);
            //System.out.println(PezziBianchi);
    
    public void inserisci(int traversa, int indice, Pezzo p){
        /*metodo che inserisce un pezzo all'interno della scacchiera*/
        
        //System.out.println("entrato in inserisci");
        //devo controllare se posos aggiungere
        //controllare se sbrocca se gli passo NULL come Pezzo da mettere in scacchiera
        scacchiera[traversa][indice] = p;
        try{
            if (p.getColore() == Colore.BIANCO) 
                 Gioco.Scacchi.PartitaScacchi.PezziBianchi.add(p);
            else  Gioco.Scacchi.PartitaScacchi.PezziNeri.add(p);
        }catch(NullPointerException e){
            
        }
        //System.out.println(scacchiera[traversa][indice]);
        //System.out.println(p);
    }
    public void elimina(Casella c){
        /*metodo che elimina nu pezzo dalla scacchiera*/
        
        System.out.println("entrato in elimina");
        Pezzo temp = this.getPezzo(c.rowIndex, c.columnIndex);
        this.inserisci(c.rowIndex, c.columnIndex, null);
        
        if (temp.getColore() == Colore.BIANCO) 
             Gioco.Scacchi.PartitaScacchi.PezziBianchi.remove(temp);
        else Gioco.Scacchi.PartitaScacchi.PezziNeri.remove(temp);
 
    }
    
    public void sposta(Casella a, Casella da, Pezzo p){
        /*metodo che sposta un pezzo tra due casella vuote*/
        
        scacchiera[a.rowIndex][a.columnIndex] = p;
        scacchiera[da.rowIndex][da.columnIndex] = null;
    }

        
    @Override
    public String toString() throws NullPointerException{
        String output = "";

        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                //System.out.println("entrato  nel doppio ciclo in scacchiera.toString");
                //if(scacchiera[i][j] == null) output += ".";
                //else output += scacchiera[i][j].getNome();
                //output += scacchiera[i][j].getNome();
                //System.out.print(output);
                 /*
                if (this.getPezzo(i,j) != null){
                    output += this.getPezzo(i,j);
                }else{
                    output += ".";
                }
                */
                
                try{
                    output += this.getPezzo(i,j).getNome();
                }catch (NullPointerException e){
                    output += ".";
                }
                
            }
            output += "\n";
        }

        return output;
    }
    //GEtTraversa per stampare la scacchiera aggiungendo le lettere e i numeri (coordinate)
    
    public void toStringPartita(){
        //ciclo la stack di mmosse
        for(int i = 0; i<this.width; i++){
            for (int j = 0; j< this.height; j++){
                
            }
        }
    }
    
    public Casella getCasella(Pezzo p, Colore c){
        /*metodo che passandogli un pezzo ritorna "la" casella dove si trova il pezzo*/
        
        for(int i = 0; i<this.width; i++){
            for (int j = 0; j< this.height; j++){
                try{
                    if(this.getPezzo(i,j) instanceof p &&
                            this.getPezzo(i,j).getColore() == c)
                        //è sufficiente this.getpezzo == p ??????
                        return new Casella(i,j);
                }catch (NullPointerException e){}
            }
        }
        return new Casella (8,8);

    }
   
    public Casella getRe(Colore color){
        /*metodo che torna la casella dove si trova i re del colore passato*/
        
        for(int i = 0; i<this.width; i++){
            for (int j = 0; j< this.height; j++){
                try{
                    if(this.getPezzo(i,j) instanceof Re &&
                            this.getPezzo(i,j).getColore() == color)
                        return new Casella(i,j);
                }catch (NullPointerException e){}
            }
        }
        return new Casella (8,8);
    }
}
