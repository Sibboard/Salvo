package Gioco.Scacchi;

import Gioco.Scacchi.Eccezioni.PattaException;
import Gioco.*;
import Gioco.Scacchi.*;
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
    private Stack <Mossa> history = new Stack();
    private static String posizione;
    public static Colore turno;
    private String enPassant;
    private String arrocco;
    private boolean scacco;
    public static Set <PedinaScacchi> PezziBianchi = new HashSet<>();
    public static Set <PedinaScacchi> PezziNeri = new HashSet<>();
    public static Set <PedinaScacchi> MaterialeInsufficiente = new HashSet<>();
    private Map <String, Integer> scacco_perpetuoB = new HashMap();
    private Map <String, Integer> scacco_perpetuoN = new HashMap();
    
    
   
    public PartitaScacchi() throws InputErratoException
    {
        /* costruttore senza argomenti
        chiama il costruttore con argomento la stringa in fen di una nuova partita */
        PartitaScacchi partita = new PartitaScacchi("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }
    
    public PartitaScacchi(String[] an) throws InputErratoException{
        /*costruttore che prende la notazione algebrica */
        
        for(int i=0; i<=7; i++){
            for(int j=0; j<=7; j++){
                
                char pedina = an[i].charAt(j);
                switch(pedina){
                    case 'T':
                       scacchiera.inserisci(i, j, new Torre(Colore.BIANCO)); break;
                    case 't':
                       scacchiera.inserisci(i, j, new Torre(Colore.NERO)); break;
                    
                    case 'C':
                        scacchiera.inserisci(i, j, new Cavallo(Colore.BIANCO)); break;
                    case 'c':
                        scacchiera.inserisci(i, j, new Cavallo(Colore.NERO)); break;

                    case 'A':
                        scacchiera.inserisci(i, j, new Alfiere(Colore.BIANCO)); break;
                    case 'a':
                        scacchiera.inserisci(i, j, new Alfiere(Colore.NERO)); break;

                    case 'D':
                        scacchiera.inserisci(i, j, new Regina(Colore.BIANCO)); break;
                    case 'd':
                        scacchiera.inserisci(i, j, new Regina(Colore.NERO)); break;

                    case 'R':
                        scacchiera.inserisci(i, j, new Re(Colore.BIANCO)); break;
                    case 'r':
                        scacchiera.inserisci(i, j, new Re(Colore.NERO)); break;

                    case 'P':
                        scacchiera.inserisci(i, j, new Pedone(Colore.BIANCO)); break;
                    case 'p':
                        scacchiera.inserisci(i, j, new Pedone(Colore.NERO)); break;

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
        posizione = fen_notation[0];//inizializzo la stringa della partita con quella in input
        //Partita[0] = fen_notation;//inizializzo la stringa della partita con quella in input
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
            //System.out.println(PezziNeri);
            //System.out.println(PezziBianchi);
            switch(pedina){
                
                case 'R':
                    scacchiera.inserisci(tra, ind, new Torre(Colore.BIANCO)); ind++; break;
                case 'r':
                    scacchiera.inserisci(tra, ind, new Torre(Colore.NERO)); ind++; break;
                     
                case 'N':
                    scacchiera.inserisci(tra, ind, new Cavallo(Colore.BIANCO)); ind++; break;
                case 'n':
                    scacchiera.inserisci(tra, ind, new Cavallo(Colore.NERO)); ind++; break;

                case 'B':
                    scacchiera.inserisci(tra, ind, new Alfiere(Colore.BIANCO)); ind++; break;
                case 'b':
                    scacchiera.inserisci(tra, ind, new Alfiere(Colore.NERO)); ind++; break;
                    
                case 'Q':
                    scacchiera.inserisci(tra, ind, new Regina(Colore.BIANCO)); ind++; break;
                case 'q':
                    scacchiera.inserisci(tra, ind, new Regina(Colore.NERO)); ind++; break;

                case 'K':
                    scacchiera.inserisci(tra, ind, new Re(Colore.BIANCO)); ind++; break;
                case 'k':
                    scacchiera.inserisci(tra, ind, new Re(Colore.NERO)); ind++; break;

                case 'P':
                    scacchiera.inserisci(tra, ind, new Pedone(Colore.BIANCO));  ind++; break;
                case 'p':
                    scacchiera.inserisci(tra, ind, new Pedone(Colore.NERO)); ind++; break;
                                   
                case '/':
                    tra ++; ind = 0; break;
                   
                default : 
                    throw new InputErratoException();
                     
                    
                   
                        //throw InputErratoException; break               
            } //end switch	
        }//end for sulla posizione dei pezzi
        
        // setto il turno 
        
        if ("w".equals(fen_notation[1]) || "W".equals(fen_notation[1])){
            this.turno = Colore.BIANCO;
        }else this.turno = Colore.NERO;
        
        if (Colore.BIANCO == turno){
        
        }
        
        // FEN_NOTATION[2] ARROCCO    TO DO--------NONONO
        // mettere booleani in re e toprre??
        
        //  FEN_NOTATION[3]  EN PASSANT    TO DO-----NONONNO
        
        //enPassant = fen_notation[3];
        
        //  FEN_NOTATION[4]   SEMIMOSSE EFFETTUATE TO DO  conto delle 50 mosse uguali----NONONON?????
        
        //  FEN_NOTATION[5] mosse effettuate dall'inizio della partita (d incrementare ogni volta che gioca il nero)----NONONONNO
        
        //--------- stampa della scacchiera popolata 
        /*
        System.out.println("Stampa della scacchiera popolata da PartitaScacchi");
        System.out.println("   A -B -C -D -E -F -G -H ");
        //System.out.println("--------------------------");
        for(int i = 0; i<scacchiera.height; i++){
            System.out.print(i+1);
            System.out.print(" |");
            for(int j = 0; j<scacchiera.width; j++){
                if (scacchiera.getPezzo(i,j) != null) {
                    System.out.print(scacchiera.getPezzo(i, j));
                }else{System.out.print(".");
                }
                System.out.print(" |");
                
            }
            System.out.println();
            
        }
        */

        //-------
        
        //System.out.print(scacchiera);
    }//end costruttore FEN

    @Override
    public String toString()throws NullPointerException{
        String output = "\n";
        for (int i = 0; i<scacchiera.height; i++){
            output += scacchiera.height - i + " |";    // PULIZIA DEL TO STRING
            for (int j = 0; j<scacchiera.width ; j++){
                
                try{
                    output += scacchiera.getPezzo(i,j).getNome();
                }catch (NullPointerException e){
                    output += ".";
                }
                output += " |";  // PULIZIA DEL TO STRING
            }
            output += "\n";
        } 
        output += "   A  B  C  D  E  F  G  H\nTurno: "+this.turno+"\n";
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
      
    public void muovi(Casella da, Casella a) throws CasellaVuotaException, CasellaOccupataException,
        MossaIllegaleException, PattaException, TurnoErratoException, ReSottoScaccoException /* ScaccoMattoException*/{
        /* muovi(da,a) deve controllare la legalità della mossa (turno, pezzo, 
        caselle) e in caso deve sollevare le giuste eccezioni */
        PedinaScacchi pezzo_da;
        PedinaScacchi pezzo_a;
        String partita = this.posizione; 
        
        System.out.println("INIZIO MOSSA: Da "+da+" ; A "+a+"Turno:"+turno );
        
        
        
        /* ORDINE DI CONTROLLLO
        casellaVota>turno>REsottoscacco>mossa illegale(puoi muovere)> casellaOccuopata>
        chiamata a puoimuovere > mossaillegale
        Pattaexception>scaccomatto??
        */
        //--------------- scacco check
        
        //--------------patta check
        // ripetizione di posizione
        // fare un metodo checkPatta() throws PattaExceptionche fa i controlli della patta
        //bisogna aggiungere 50 mosse
        
        
        /*  -sottoScacco()
            -checkpatta()
                --
        */
        
        checkPatta();
        
        
        if (this.sottoScacco()){
            this.scacco = true;
            throw new ReSottoScaccoException();
        }
        
        System.out.println("DOPO SOTTOSCACCO");
        System.out.println(this.turno);
        try{
            pezzo_da = scacchiera.getPezzo(da);
            if (da == a){
                System.out.println("MossaIllegale 1");
                throw new MossaIllegaleException();
            }
            /*if (pezzo instanceof Cavallo)
                System.out.print("''TTAPPOST");
            */
            if(!pezzo_da.getColore().toString().equals(this.turno.toString())){
                System.out.println(pezzo_da+" " +pezzo_da.getColore().toString() + " " +this.turno.toString());
                throw new TurnoErratoException();
            }
            //if scacco = true ->
            
            /* finora muovi ha controllato:
               -- Patta
               -- Scacco
               -- Movimento nella stessa casella
               -- Turno (si muove un pezzo dell'altro giocatore)
               -- 
            */
            if (pezzo_da.puoiMuovere(da, a, scacchiera) == true){
                try{
                    System.out.println("PuoiMuovere = true");
                    if (scacchiera.getPezzo(da).getColore() == scacchiera.getPezzo(a).getColore()){
                    throw new CasellaOccupataException();
                    }   
                }catch(NullPointerException e){}
                
                //if pezzo_da
                
            }else{
                //System.out.println(this);
                
                System.out.println("Muovi.PuoiMuovere = FALSE");
                throw new MossaIllegaleException();
            }
            
        }catch(NullPointerException e){
            throw new CasellaVuotaException();
        }
        
        /* arrivati a questo punto la mossa dovrebbe essere regolare e corretta e quindi deve
        essere eseguita dal programma, e salvata opportunamente in uno stack*/
        pezzo_da = scacchiera.getPezzo(da);
        pezzo_a = scacchiera.getPezzo(a);
        Mossa mossa = new Mossa(scacchiera,turno,da,a,pezzo_a);
                
        
        
        if( pezzo_a != null){
            mossa.setPezzo_mangiato(pezzo_a);
            scacchiera.elimina(a);
            //elimino il pezzo mangiato dagli insiemi di pezzi esistenti
        }
        
        //System.out.println(pezzo_da +" in "+ pezzo_da.getCasella());
        scacchiera.sposta(a, da, pezzo_da);
        //System.out.println("inserisci terminato correttamente");
        //System.out.println(pezzo_da +" spostato in "+ pezzo_da.getCasella());
        
        //if (pezzo_da.getNome() == 'p' && da.rowIndex == 6 && a.rowIndex == 7 && pezzo_a == null)
        
        history.push(mossa);
        //System.out.print(mossa);
        //System.out.println(PezziBianchi);
        
        //if (this.sottoScacco()) throw new ReSottoScaccoException();
        //System.out.println("DOPO SOTTOSCACCO");
        System.out.println("FINE MOSSA: Da "+da+" ; A "+a+"Turno era :"+turno );
        System.out.println(scacchiera);
        if (turno == Colore.NERO) turno = Colore.BIANCO;
        else turno = Colore.NERO;
        System.out.println(scacco_perpetuoB);
        System.out.println(this);
        
        //METTERE CONTROLLI PER DODDPIO PASSO PEDONE E ARROCCO?!?
        
    }
    
    public void ritira(){
        
    }
    
    public boolean sottoScacco(){
        /* metodo che ritorna true se trova che un pezzo del colore turno
        minaccia il re... deve essere chiamata ALL'INIZIO della mossa*/
            
        Iterator bianchi = PezziBianchi.iterator();
        Iterator neri = PezziNeri.iterator();
        //System.out.println(" entro in SOTTOSCACCO");
        switch (turno){
                case BIANCO:{ 
                    //System.out.print("Turno bianco ");
                    while(bianchi.hasNext()){
                        PedinaScacchi re_b = (PedinaScacchi) bianchi.next(); 
                        if (re_b instanceof Re){
                            //System.out.print(",ho trovato il re bianco in "+re_b.getCasella() );
                            while(neri.hasNext()){
                                //System.out.println("entro nel while sui neri");
                                PedinaScacchi pezzo = (PedinaScacchi) neri.next(); 
                                if(pezzo.puoiMuovere(pezzo.getCasella(), re_b.getCasella(), scacchiera)) {
                                    System.out.println("PUOIMUOVERE = TRUE;  SCACCO AL RE BIANCO");
                                    System.out.println(pezzo.toString()+ pezzo.getCasella());
                                    return true;
                                }
                                //else System.out.println("puoimuovere = false,"+pezzo.toString() +" check re bianco");
                            }
                            return false;
                        }                     
                    }
                }
                
                case NERO:{
                    while(neri.hasNext()){
                        PedinaScacchi re_n = (PedinaScacchi) neri.next(); 
                        if (re_n instanceof Re){
                            //System.out.println(",ho trovato il re nero in "+re_n.getCasella() );
                            while(bianchi.hasNext()){
                                PedinaScacchi pezzo = (PedinaScacchi) bianchi.next();
                                if(pezzo.puoiMuovere(pezzo.getCasella(), re_n.getCasella(), scacchiera)){
                                    System.out.println("PUOIMUOVERE = TRUE; SCACCO AL RE NERO");
                                    System.out.println(pezzo.toString()+ pezzo.getCasella());
                                    return true;
                                }
                                //else System.out.println("puoimuovere = false "+pezzo.toString()+" check re nero");
                            }
                            return false;
                        }
                        
                    }
                }
                default: return false;
        }  
    }
    
    public void checkPatta()throws PattaException{
        try{//ripetizionePosizione();
            materialeInsufficiente();
            stallo();
        }catch(PattaException e){
            throw new PattaException();
        }
    }
    
    public void stallo() throws PattaException{
        
    }
    
    public void ripetizionePosizione() throws PattaException{
        /*metodo che controlla se si verifica la ripetizione di posizione*/
    
        String partita = this.posizione;
        if (turno == Colore.BIANCO ){ 
            if(scacco_perpetuoB.containsKey(partita)){
                if(scacco_perpetuoB.get(partita) == 3 ){ 
                    System.out.println("pattaException perpetuo B");
                    throw new PattaException();
                }else{
                    int temp = scacco_perpetuoB.get(partita) + 1;
                    scacco_perpetuoB.put(partita, temp);
                }
            }else{scacco_perpetuoB.put(partita, 1);}
        }else{ //turno nero
            if(scacco_perpetuoN.containsKey(partita)){
                if(scacco_perpetuoN.get(partita) == 3 ){
                    System.out.println("pattaException perpetuo n");
                    throw new PattaException();
                }else{
                    int temp = scacco_perpetuoN.get(partita) + 1;
                    scacco_perpetuoN.put(partita, temp);
                }
            }else{scacco_perpetuoN.put(partita, 1);}
        } 
    }
        
    public void materialeInsufficiente() throws PattaException{
        /*metodo che controlla se si verifica la patta per materiale insufficiente*/
        
        
        /*posso crearmi una struttura contenente i pezzi necessari al continuamento e 
        fare un confronto con i set di pezzi in gioco, conme nell'esercizio sui vettori simili
        posso usare containsAll(collection c) */
        Iterator bianchi = PezziBianchi.iterator();
        Iterator neri = PezziNeri.iterator();
                
        /*      
        switch (turno){
                case BIANCO:{ 
                    if (PezziBianchi.size() >= 3) throw new PattaException();
                    while(bianchi.hasNext()){
                        Re Re_b = (Re) bianchi.next(); 
                        if (Re_b instanceof Re){
                            while(neri.hasNext()){
                                PedinaScacchi pezzo = (PedinaScacchi) neri.next();
                                if(pezzo.puoiMuovere(pezzo.getCasella(), Re_b.getCasella(), scacchiera))
                                   
                            }
                            ;
                        }                     
                    }
                }
                
                case NERO:{
                    while(neri.hasNext()){
                        Re Re_n = (Re) neri.next(); 
                        if (Re_n instanceof Re){
                            while(bianchi.hasNext()){
                                PedinaScacchi pezzo = (PedinaScacchi) bianchi.next();
                                if(pezzo.puoiMuovere(pezzo.getCasella(), Re_n.getCasella(), scacchiera))
                                   
                            }
                            
                        }
                        
                    }
                }
        }  
        
        
        */
        
        
        for(int i = 0; i<scacchiera.height; i++){
            for(int j = 0; j<scacchiera.width; j++){
                if (scacchiera.getPezzo(i,j) != null) {
                    
                }
            }
        }        
    }
    
    
    public void setPassant(Casella c){
        
    }
    
    public void pezzoRemove(Pezzo p, Set <Pezzo> P){
        /*rimuove i pezzi dai set dei pezzi in gioco*/
        P.remove(p);
    }
       
    public void SetScacchiera(){
         
    }
    public Scacchiera getScacchiera() {
        return scacchiera;
    }
    /*
    public void abbandona(){
        
    }
    
    public void ritira(){ //VOID??
    /*metodo che permette l'annullamento di una mossa
    sfruttare questo metodo per controllare lo scaccoal re*/
    //}
    
    
           
    
}
