package Gioco;

import java.util.Scanner;

import Gioco.*;
import Gioco.Scacchi.*;
import Gioco.Eccezioni.*;
import Gioco.Scacchi.Eccezioni.PattaException;
import Gioco.Scacchi.Eccezioni.ReSottoScaccoException;
import java.util.Arrays;


/**
 *
 * @author sibbor
 */
public class Menu {
    Scanner s;
    PartitaScacchi p;
    public Menu(){
         s = new Scanner(System.in);
        //mi serve una variabile per memorizzare lo stato della partita
        
    }
          
    public void Opener() throws InputErratoException, CasellaVuotaException, 
            CasellaOccupataException, MossaIllegaleException, PattaException, 
            TurnoErratoException, ReSottoScaccoException{
        
        //s.useDelimiter("");
        
        Integer[] mossa;
                
        System.out.println("Grazie per aver scelto il gioco degli scacchi!");
        System.out.println("Inserire N per una nuova partita oppure I per "
                    + "immettere la stringa di una partita già cominciata");
        String input = s.nextLine();
        if (input.charAt(0)=='N' || input.charAt(0) =='n')
            p = new PartitaScacchi();
        else p = new PartitaScacchi("r7/8/8/8/8/8/PPPPPPPP/3Q1B2 w");
        System.out.println("creata partita in menu");
        System.out.println(p);
        //input = s.next();
        while(!input.equals("quit")){
            //System.out.println(p);          
            input = s.nextLine().toUpperCase();
            if (input.equals("R")){
                p.ritira();
                continue;
            }
            System.out.println("sasdfa" + input);
            while(true){
                try{
                    mossa = parserMossa(input);
                    break;
                    
                }catch (InputErratoException e){
                    System.out.println("Inserire la mossa nel formato A2-A3 o a2 a3");
                }catch (NullPointerException e){
                    System.out.println("Inserire la mossa nel formato A2-A3 o a2 a3 NULLPOINTER");
                }
                
            }
            System.out.println(Arrays.toString(mossa) + "WWWWW");
            try{
                p.muovi(new Casella(mossa[1],mossa[0]), new Casella(mossa[3], mossa[2]));
                
            }catch(ReSottoScaccoException e){
                System.out.println("Mossa non valida: il re "+p.turno+" è sotto scacco,ritirare!");                
            }catch(TurnoErratoException e){
                System.out.println("Il Turno è del "+p.turno+", ritirare!");                
            }catch(MossaIllegaleException e){
                System.out.println("Mossa non valida, ritirare!");
            }/* catch(NullPointerException e){
                System.out.println("Inserire la mossa nel formato A2-A3 o a2 a3 NULLPOINTER 22");

                
            }*/

            

        }
    }
    
    public Integer[] parserMossa(String input)throws InputErratoException {
        char digit;
        boolean primo = true;
        Integer[] out = new Integer[6];
        int k = 0;
        
        if (input.length() > 5) 
            throw new InputErratoException();  //SISTEMARE
        
        for(int i=0; i<input.length();i++){
            digit = input.charAt(i);
           
            if (i == 2) {
                primo = false;
                continue;
            }
            if (Character.isDigit(digit)){
                int indice = Character.getNumericValue(digit);
                if (primo && i == 1)  out[k] = 8 - indice;
                else if (!primo && i == 4) out[k] = 8 - indice; 
                //else System.out.println("digit"+primo +" "+ i +" " + digit);
            }else if(Character.isAlphabetic(digit)){
                if (primo && i==0 ) out[k] = (int) digit - (int)'A';
                else if (!primo && i==3) out[k] = (int) digit - (int)'A';
                //else System.out.println("alpha"+primo +" "+ i +" " + digit);
            }
            k++;
            //System.out.println("ITERAZIONE"+i +" " + digit+ " " + out[k]);
        }              
        return out;
    }
    
}
