package Gioco;

import Gioco.Scacchi.*;
import Gioco.Scacchi.Pedine.*;

import java.util.*;

/**
 * *** @author sibbor
 la classe Scacchiera definisce il campo di gioco: una matrice di oggetti Pezzo, con misure variabili
 */
public class Scacchiera {
    
    public Pezzo[][] scacchiera; /*provare FINAL */
    public int width, height;
    public Set <Pezzo> PezziBianchi;
    public Set <Pezzo> PezziNeri;
    
    
    
    public Scacchiera(int h, int w){
        /*costruttore che inizializza una matrice height*width di oggetti Pezzo e memorizza le sue dimensioni */
        
        this.scacchiera = new Pezzo[h][w];
        /*for(int i = 0; i< 8; i++){
            for(int j = 0; j<8; j++){
                System.out.print(scacchiera[i][j]);
            }
            System.out.println(i);
        }*/
        this.height = h;
        this.width = w;
        this.PezziBianchi = new HashSet<>();
        this.PezziNeri = new HashSet<>();
        
    }
    
    public PedinaScacchi getPezzo(Casella c){
        /*getPezzo ritorna il pezzo di una casella*/
        
        return (PedinaScacchi) scacchiera[c.rowIndex][c.columnIndex];
    }
    
    public Integer getWidth(){ return width; } 
    
    
    public PedinaScacchi getPezzo(int traversa, int indice){
        /* getPezzo che prende i ninput gli indici di scacchiera */
        return (PedinaScacchi)scacchiera[traversa][indice];
    }
    
    /* metodo per settare null le caselle vuote+ */
    //-------inutilizzato---------
    public void setCasellaNull(int traversa, int indice){
        scacchiera[traversa][indice] = null;
    }
    
    
    public void inserisci(int traversa, int indice, PedinaScacchi p){
        /*metodo che inserisce un pezzo all'interno della scacchiera*/
        
        //System.out.println("entrato in inserisci");
        //devo controllare se posos aggiungere
        //controllare se sbrocca se gli passo NULL come Pezzo da mettere in scacchiera
        scacchiera[traversa][indice] = p;
        
        //private final Set <PedinaScacchi> PB = new HashSet<>();
        //Gioco.Scacchi.PartitaScacchi.PezziBianchi;
                
        
        try{
            if (p.getColore() == Colore.BIANCO) 
                 this.PezziBianchi.add(p);
            else  this.PezziNeri.add(p);
            p.setCasella(new Casella(traversa, indice));

        }catch(NullPointerException e){
            
        }
        //System.out.println(scacchiera[traversa][indice]);
        //System.out.println(p);
    }
    public void elimina(Casella c){
        /*metodo che elimina nu pezzo dalla scacchiera*/
        System.out.println("entrato in elimina");
        PedinaScacchi temp = this.getPezzo(c.rowIndex, c.columnIndex);
        this.inserisci(c.rowIndex, c.columnIndex, null);
        
        if (temp.getColore() == Colore.BIANCO) 
             this.PezziBianchi.remove(temp);
        else this.PezziNeri.remove(temp);
        temp.setCasella();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
        
    }
    
    public void sposta(Casella a, Casella da, PedinaScacchi p){
        /*metodo che sposta un pezzo tra due casella vuote*/
        
        scacchiera[a.rowIndex][a.columnIndex] = p;
        scacchiera[da.rowIndex][da.columnIndex] = null;
        p.setCasella(new Casella(a.rowIndex, a .columnIndex));
    }

        
    @Override
    public String toString() throws NullPointerException{
        String output = "";

        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                try{
                    output += this.getPezzo(i,j).getNome();
                }catch (NullPointerException e){
                    output += ".";
                }
            }
            output += "\\";
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
    
    /*
    //----- I METODI SEGUENTI NOPN DOVREBBERO PIU SAERVIRE IN QUANTO I PEZZI HANNO IL PUNTATORE ALLA CASELLA
    
    public Casella getCasella(Pezzo p, Colore c){
        //metodo che passandogli un pezzo ritorna "la" casella dove si trova il pezzo
        
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
        //return new Casella (8,8);

    }
   
    public Casella getRe(Colore color){
        //metodo che torna la casella dove si trova i re del colore passato
        
        for(int i = 0; i<this.width; i++){
            for (int j = 0; j< this.height; j++){
                try{
                    if(this.getPezzo(i,j) instanceof Re &&
                            this.getPezzo(i,j).getColore() == color)
                        return new Casella(i,j);
                }catch (NullPointerException e){}
            }
        }
       // return new Casella (8,8); 
    } */
}
