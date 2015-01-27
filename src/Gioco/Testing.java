package Gioco;

import Gioco.Eccezioni.*;
import Gioco.Scacchi.*;
import Gioco.Scacchi.Eccezioni.*;

/**
 *
 * @author Sibbor
 */
public class Testing {
    
        public static void main(String[] args) throws InputErratoException, 
                CasellaVuotaException, CasellaOccupataException,
                MossaIllegaleException, PattaException, TurnoErratoException {
            String print;
            /*COSTRUTTORE FEN PER NUOVA PARTITA
            PartitaScacchi p = new PartitaScacchi();
            System.out.println("partita creata");

            print = p.toString();
            System.out.println("terminata chiamata a toString");
            System.out.print(print);
            Casella da = new Casella(0,1);
            Casella a1 = new Casella(2,0);
            Casella a2 = new Casella(2,2);
            Casella a3 = new Casella(3,0);
            
            p.muovi(a1, da);
         
            System.out.print(p);
            //p.muovi(a2, a1);
            p.muovi(da, a1);
            System.out.print(p);
            p.muovi(a2,da);
            System.out.print(p);
            p.muovi(da, a2);
            System.out.print(p);
            p.muovi(a3, da);
            System.out.print(p);
            */
            
            PartitaScacchi p1 = new PartitaScacchi("1r6/1k6/8/P7/8/8/8/8 w ");
            //PartitaScacchi p1 = new PartitaScacchi("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w ");
            //Casella da3 = new Casella(0,1);
            //Casella a3 = new Casella(0,0);
            //p1.muovi(da3,a3);
            System.out.print(p1);
            Casella da = new Casella(3,0);
            Casella a = new Casella(2,0);
            p1.muovi(da, a);
            System.out.print(p1);
            //p1.muovi(a, da);
            //System.out.print(p1);
            Casella da2 = new Casella(0,0);
            Casella a2 = new Casella(0,6);
            p1.muovi(a, a2);
            System.out.print(p1);
            /*p1.muovi(a2, da);
            System.out.print(p1);
             */

            //print = p.toString();
            /*
            CICLO DEI MOVIMENTI DEL RE
            
            Casella da = new Casella(5,2);
            Casella a1 = new Casella(4,1);
            p.muovi(a1,da);
            System.out.print(p.toString());
            Casella a2 = new Casella(3,1);
            p.muovi(a2, a1);
            System.out.print(p.toString());
            Casella a4 = new Casella(2,2);
            p.muovi(a4,a2);
            System.out.print(p.toString());
            Casella a5 = new Casella(2,3);
            p.muovi(a5,a4);
            System.out.print(p.toString());
            Casella a6 = new Casella(3,4);
            p.muovi(a6, a5);
            System.out.print(p.toString());
            Casella a7 = new Casella(4,4);
            p.muovi(a7,a6);
            System.out.print(p.toString());
            Casella a8 = new Casella(5,3);
            p.muovi(a8,a7);
            System.out.print(p.toString());
            p.muovi(da,a8);
            System.out.print(p.toString());
            */
                    
            
            //COSTRUTTORE FFEN CON STRINGA
            /*
            PartitaScacchi pdue = new PartitaScacchi("r1bk2nr/p2p1pNp/n2B1Q2/1p1NP2P/6P1/3P4/P1P1K3/q5b1 w erf");
            System.out.println("partita 2 creata");

            print = p.toStringPartita();
            System.out.print("eseguitra 2 chiamata a toStringPartita");
            System.out.print(print); 
            */ 
            
             /* COSTRUTTORE ITA
            String[] partita = new String[8] ;
            partita = ["t.ar..ct", "p..p.pCp", "c..A.D..",".p.CP..P","......P.","...P....","P.P.R...","d.....A.","N"];
            PartitaScacchi pita;
            pita = new PartitaScacchi(["t.ar..ct", "p..p.pCp", "c..A.D..",".p.CP..P","......P.","...P....","P.P.R...","d.....A.","N"] );
            System.out.println("partita creata");
             */
            System.out.print("\n");
            System.out.print("G.G");
        }   
}
