package Gioco.Scacchi;

import Gioco.Scacchi.Eccezioni.PattaException;
import Gioco.*;
//import Gioco.Turno;  non necessario??
import Gioco.Eccezioni.*;
import Gioco.Scacchi.Pedine.*;
import Gioco.Scacchi.Eccezioni.*;
import java.util.*;


/**
 *
 * @author sibbor
 * PartitaScacchi deve memorizare una posizione del gioco verificare la legalità 
    delle mosse, dovrà  dovrà saper leggere una posizione, una sequenza
    di mosse, stampare la posizione corrente, e la sequenza di mosse giocate
 */

public class PartitaScacchi {
    
    public static Scacchiera scacchiera;
    private Turno turno;
    public Stack <Mossa> history = new Stack();
    private String Partita;
    private Map <String, Integer> scacco_perpetuoB = new HashMap();
    private Map <String, Integer> scacco_perpetuoN = new HashMap();
    
   
    public PartitaScacchi() throws InputErratoException
    {
        /* costruttore senza argomenti
        chiama il costruttore con argomento la stringa in fen di una nuova partita */
        PartitaScacchi Partita = new PartitaScacchi("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }
    
    public PartitaScacchi(String[] s) throws InputErratoException{
        /*costruttore che prende la notazione "italiana" */
        
        for(int i=0; i<=7; i++){
            for(int j=0; j<=7; j++){
                
                char pedina = s[i].charAt(j);
                switch(pedina){
                    case 'T':
                       scacchiera.inserisci(i, j, new Torre(Giocatore.BIANCO)); break;
                    case 't':
                       scacchiera.inserisci(i, j, new Torre(Giocatore.NERO)); break;
                    
                    case 'C':
                        scacchiera.inserisci(i, j, new Cavallo(Giocatore.BIANCO)); break;
                    case 'c':
                        scacchiera.inserisci(i, j, new Cavallo(Giocatore.NERO)); break;

                    case 'A':
                        scacchiera.inserisci(i, j, new Alfiere(Giocatore.BIANCO)); break;
                    case 'a':
                        scacchiera.inserisci(i, j, new Alfiere(Giocatore.NERO)); break;

                    case 'D':
                        scacchiera.inserisci(i, j, new Regina(Giocatore.BIANCO)); break;
                    case 'd':
                        scacchiera.inserisci(i, j, new Regina(Giocatore.NERO)); break;

                    case 'R':
                        scacchiera.inserisci(i, j, new Re(Giocatore.BIANCO)); break;
                    case 'r':
                        scacchiera.inserisci(i, j, new Re(Giocatore.NERO)); break;

                    case 'P':
                        scacchiera.inserisci(i, j, new Pedone(Giocatore.BIANCO)); break;
                    case 'p':
                        scacchiera.inserisci(i, j, new Pedone(Giocatore.NERO)); break;

                    case '.':
                        scacchiera.inserisci(i, j, null); break;
                        // da vedere
                    
                    default :
                        throw new InputErratoException();
                        



                    }
            }
        }
    }
    public PartitaScacchi(String fen) throws InputErratoException {
        /* costruttore che prende la stringa in notazione fen e crea la partita*/
        
        scacchiera = new Scacchiera(8,8);
        String[] fen_notation = fen.split(" ");
        Partita = fen_notation[0]; //inizializzo la stringa della partita con quella in input
        //Partita[0] = fen_notation; //inizializzo la stringa della partita con quella in input
        int tra = 0; int ind = 0;
        
        /*ciclo che parsa la prima parte della notazione fen, quella che 
        rappresenta la scacchiera
        */
        for(int i=0; i < fen_notation[0].length(); i++){
            char pedina = fen_notation[0].charAt(i);
            //System.out.print(pedina);
            if(Character.isDigit(pedina)){ 
                int spaces = Character.getNumericValue(pedina);
                //System.out.print("dabade");
                
                /* ciclo per popolare le caselle vuote della scacchiera */
                for(int empty=0; empty < spaces; empty++){
                    scacchiera.inserisci(tra, ind, null);
                    //System.out.print(scacchiera.getPezzo(tra, ind));
                    ind++; //incremento l'indice nella traversa
                }
                continue;
            }
                    
            switch(pedina){
                
                case 'R':
                    scacchiera.inserisci(tra, ind, new Torre(Giocatore.BIANCO)); ind++; break;
                case 'r':
                    scacchiera.inserisci(tra, ind, new Torre(Giocatore.NERO)); ind++; break;
                     
                case 'N':
                    scacchiera.inserisci(tra, ind, new Cavallo(Giocatore.BIANCO)); ind++; break;
                case 'n':
                    scacchiera.inserisci(tra, ind, new Cavallo(Giocatore.NERO)); ind++; break;

                case 'B':
                    scacchiera.inserisci(tra, ind, new Alfiere(Giocatore.BIANCO)); ind++; break;
                case 'b':
                    scacchiera.inserisci(tra, ind, new Alfiere(Giocatore.NERO)); ind++; break;
                    
                case 'Q':
                    scacchiera.inserisci(tra, ind, new Regina(Giocatore.BIANCO)); ind++; break;
                case 'q':
                    scacchiera.inserisci(tra, ind, new Regina(Giocatore.NERO)); ind++; break;

                case 'K':
                    scacchiera.inserisci(tra, ind, new Re(Giocatore.BIANCO)); ind++; break;
                case 'k':
                    scacchiera.inserisci(tra, ind, new Re(Giocatore.NERO)); ind++; break;

                case 'P':
                    scacchiera.inserisci(tra, ind, new Pedone(Giocatore.BIANCO)); ind++; break;
                case 'p':
                    scacchiera.inserisci(tra, ind, new Pedone(Giocatore.NERO)); ind++; break;
                                   
                case '/':
                    tra ++; ind = 0; break;
                   
                default : 
                    throw new InputErratoException();
                     
                    
                   
                        //throw InputErratoException; break               
            } //end switch	
        }//end for sulla posizione dei pezzi
        
        // setto il turno
        /*
        if ("w".equals(fen_notation[1]) || "W".equals(fen_notation[1])){
            turno = Turno.BIANCO;
        }else turno = Turno.NERO;
        */
        // FEN_NOTATION[2] ARROCCO    TO DO--------NONONO
        // mettere booleani in re e toprre??
        
        //  FEN_NOTATION[3]  EN PASSANT    TO DO-----NONONNO
        
        //  FEN_NOTATION[4]   SEMIMOSSE EFFETTUATE TO DO  conto delle 50 mosse uguali----NONONON?????
        
        //  FEN_NOTATION[5] mosse effettuate dall'inizio della partita (d incrementare ogni volta che gioca il nero)----NONONONNO
        
        //--------- stampa della scacchiera popolata 
        
        System.out.println("Stampa della scacchiera popolata da PartitaScacchi");
        System.out.println("  |A |B |C |D |E |F |G |H ");
        //System.out.println("--------------------------");
        for(int i = 0; i<8; i++){
            System.out.print(i+1);
            System.out.print(" |");
            for(int j = 0; j<8; j++){
                if (scacchiera.getPezzo(i,j) != null) {
                    System.out.print(scacchiera.getPezzo(i, j));
                }else{System.out.print(".");
                }
                System.out.print(" |");
                
            }
            System.out.println();
            
        }
        //-------
        
        //System.out.print(scacchiera);
    }//end costruttore FEN

    @Override
    public String toString()throws NullPointerException{
        String output = "";
        //System.out.println("Entrato in PartitaScacchi.toString, ora eseguo chiamata a scacchiera.toString");
        //System.out.println("   |A |B |C |D |E |F |G |H ");
        for (int i = 0; i<8; i++){
            output += i+1;    // PULIZIA DEL TO STRING
            for (int j = 0; j<8; j++){
                //System.out.println("DOPPIO FOR");
                
                try{
                    output += scacchiera.getPezzo(i,j).getNome();
                }catch (NullPointerException e){
                    output += ".";
                }
                //output += " |";  // PULIZIA DEL TO STRING
                /*if(scacchiera.getPezzo(i,j) != null){
                    System.out.println("IF DEL TOSTRING");
                    output += scacchiera.getPezzo(i, j).getNome();
                }else{ 
                    
                }*/
            }
            output += "\n";
        }
        /*
        try{
            return scacchiera.toString();
        }catch(NullPointerException e ){
            return "Non sono riuscito a ritornare scacchiera.toString";
                    
        }
        */
        return output;
    }
    
    public String toStringPartita() throws NullPointerException{
        /*genera una stringa contenente ,la posizione iniziale, e le mosse effettuate*/
        //System.out.println(scacchiera.height);
        System.out.println("entrato PartitaScacchi.toStringPartita");
        String output = "";
        
        /*
        try{
            return scacchiera.toString();
        }catch(NullPointerException e){
            System.out.println("nullpointerEXCEPTION cathcata in TOSTRINGPARTITA");
            return "return del to string";
        }
        //System.out.print(scacchiera);
        //return("g");
        
        */
        
        /*
        for (int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                System.out.println("DOPPIO FOR");
                if(scacchiera[i][j] != null){
                    System.out.println("IF DEL TOSTRING");
                    output += scacchiera.getPezzo(i, j).getNome();
                }else{ 
                    output += (".");
                }
            }
        }
        */
        return output;
        
    } // end TOSTRING
    
    
    public void SetScacchiera(){
         
    }

    public Scacchiera getScacchiera() {
        return scacchiera;
    }
    
    public void ripetizione_posizione() throws PattaException{
        String partita = this.Partita;
        if (turno == Turno.BIANCO ){ 
            if(scacco_perpetuoB.containsKey(partita)){
                if(scacco_perpetuoB.get(partita) == 3 ){ throw new PattaException();
                }else{
                    int temp = scacco_perpetuoB.get(partita) + 1;
                    scacco_perpetuoB.put(partita, temp);
                }
            }else{scacco_perpetuoB.put(partita, 1);}
        }else{ //turno nero
            if(scacco_perpetuoN.containsKey(partita)){
                if(scacco_perpetuoN.get(partita) == 3 ){ throw new PattaException();
                }else{
                    int temp = scacco_perpetuoN.get(partita) + 1;
                    scacco_perpetuoN.put(partita, temp);
                }
            }else{scacco_perpetuoN.put(partita, 1);}
        }
    }
            
    
    public void muovi(Casella da, Casella a) throws CasellaVuotaException, CasellaOccupataException,
        MossaIllegaleException, PattaException, TurnoErratoException /*ReSottoScaccoException, ScaccoMattoException*/{
        /* muovi(da,a) deve controllare la legalità della mossa (turno, pezzo, 
        caselle) e in caso deve sollevare le giuste eccezioni */
        Pezzo pezzo_da;
        Pezzo pezzo_a;
        String partita = this.Partita; 
        
        
        
        /* ORDINE DI CONTROLLLO
        casellaVota>turno>REsottoscacco>mossa illegale(puoi muovere)> casellaOccuopata>
        chiamata a puoimuovere > mossaillegale
        Pattaexception>scaccomatto??
        */
        //--------------- scacco check
        
        //--------------patta check
        // ripetizione di posizione
        
        try{
            ripetizione_posizione();
        }catch(PattaException e){
            throw new PattaException();
        }
        
        
        try{
            pezzo_da = scacchiera.getPezzo(da);
            if (da == a){
                throw new MossaIllegaleException();
            }
            /*if (pezzo instanceof Cavallo)
                System.out.print("''TTAPPOST");
            */
            if(!pezzo_da.getColore().equals(turno)){  // verificare che FUNZIONI
                throw new TurnoErratoException();
            }
            //if scacco = true ->
            
            if (pezzo_da.puoiMuovere(da, a, scacchiera) == true){
                try{
                    if (scacchiera.getPezzo(da).getColore() == scacchiera.getPezzo(a).getColore()){
                    throw new CasellaOccupataException();
                    }   
                }catch(NullPointerException e){
                    // nothing to do  here
                }
                
            }else{
                throw new MossaIllegaleException();
            }
            
        }catch(NullPointerException e){
            throw new CasellaVuotaException();
        }
        
        /* arrivati a questo punto la mossa dovrebbe essere regolare e corretta e quindi deve
        essere eseguita dal programma, e salvata opportunamente in uno stack*/
        
        Mossa mossa = new Mossa(scacchiera,turno,da,a);
        
        //una stack di pezzi mangiati?
        pezzo_da = scacchiera.elimina(da);
        pezzo_a = scacchiera.elimina(a);
        

        if( pezzo_a != null){
            mossa.setPezzo_mangiato(true);
            //StackPezziMangiati.push(pezzo_a)
        }
        scacchiera.inserisci(a.rowIndex, a.columnIndex, pezzo_da);
        System.out.println("inserisci terminato correttamente");
        
        history.push(mossa);
        

        /*eccezioni ==
        CasellaVuotaException : sollevata se la casella da è vuota;
        
        CasellaOccupataException : sollevata se la casella a è già occupata da 
        un pezzo del colore che stamuovendo;
        
        TurnoErratoException : solleva4ta se la casella da contiene un pezzo di 
        colore diverso rispetto al giocatore di turno
        
        ReSottoScaccoException : sollevata se la mossa non è possibile in quanto 
        il Re del colore che ha mosso risulta essere sotto scacco dopo l’esecuzione della mossa;
        
        ScaccoMattoException : sollevata se si riscontra che la partita finisce a 
        causa di uno scacco matto 
        
        MossaIllegaleException : sollevata in ogni altro caso di mossa illegale 
        (esempio: la casella a non è raggiungibile dal pezzo che si trova nella casella da);
        
        PattaException : sollevata se si riscontra che la partita finisce a causa 
        di patta; L’eccezione dovrà recare informazioni approposito del motivo per
        cui si è avuta una situazione di patta. Considerate almeno i casi di stallo 
        (la sua verifica è analoga allo scacco matto), materiale insufficiente
        per vincere e la regola delle 50 mosse. Lasciamo agli esperti scacchisti 
        e programmatori intraprendenti l’implementazione della ripetizione delle posizioni.
       
        */
        
        
    }
    /*
    public void updatePartita(Scacchiera s){
        for(int riga : s){
            for(int colonna : s[riga])

        }
    }*/
    
    
    public void abbandona(){
        
    }
    
    public void ritira(){ /* VOID?? */
    /*metodo che permette l'annullamento di una mossa*/
    /*sfruttare questo metodo per controllare lo scaccoal re*/
    }
    
    //public String toString(){
        /*genera come output una stringa chestampa la posizione corrente, e a chi tocca muovere*/
        
    //}
    
}
