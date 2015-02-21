package Gioco.Scacchi.Pedine;

import Gioco.*;
import Gioco.Scacchi.*;
import Gioco.Colore.*;
import java.lang.Math.*;

/**
 *
 * @author Sibbor
 */
public class Pedone extends PedinaScacchi {
    
    

    public Pedone(Colore giocatore) {
        super(giocatore);
        //un controllo per le partite gia iniziate? distinto per ogni giocatore?
    }

    @Override
    public boolean puoiMuovere(Casella da, Casella a, Scacchiera s) {
        
        int da_r = da.rowIndex ;
        int da_c = da.columnIndex;
        int a_r = a.rowIndex;
        int a_c = a.columnIndex;
        /*
        System.out.println("entrato in puoi muovere pedone, caselle: "+da_r+","+da_c+" -- "+a_r+","+a_c);
        System.out.println("dar-ar: "+Math.abs(da_r - a_r)+" ac- da_c: "+ Math.abs(a_c - da_c));
        System.out.println("ar-dar: "+Math.abs(a_r - da_r)+" dac- a_c: "+ Math.abs(da_c - a_c));
        */
        if(direzioneGiocatore(da_r, a_r)){
            if( Math.abs(da_r - a_r) == 1 && Math.abs(a_c - da_c) == 1){
            //  MANGIA
                try{if (s.getPezzo(a).getColore().equals(this.getColore())) return false; 
                }catch(NullPointerException e){return false;} //non c'è nulla nella casella di destinazione
                System.out.println("Pedone mangia 1");
                return true;

            }else if(Math.abs(da_r - a_r) == 1 && a_c == da_c){
            // MUOVE DI UNA CASELLA
                if(s.getPezzo(a) != null) {
                    System.out.println("Pedone movimento singolo");
                    return false;} //per lo scacco non mi controlla le varie eccezioni
                return true;
              
            }else if(Math.abs(da_r - a_r) == 2 && a_c == da_c &&(da_r == 1||da_r ==6)){
                //movimento di due caselle
                    return true;
                    //nsalvare nello stato della partita la psossibilità di en passant
                    /* if a sinistra o destra dalla casella a, c'è un pedon eavversario*/
            }else{
                System.out.println("ELSE FINALE PEDONE");
                return false;
            }
        }else return false;
       
    }
    
    public boolean direzioneGiocatore(int da_r, int a_r){
        /*controlla che il pedone si stia muovendo nella direzione permessa al giocatore*/
        
        if(this.giocatore == Colore.BIANCO && da_r > a_r) return true;
        else if(this.giocatore == Colore.NERO && da_r < a_r) return true;
        else return false;
    }

    @Override
    public char getNome(){
        if(this.giocatore == Colore.BIANCO) return 'P';
                else return 'p';
    }

    
    
}
