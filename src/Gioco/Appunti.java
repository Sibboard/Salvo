package Gioco;

/**
 *
 * @author Sibbor
 */
public class Appunti {
    
    /*
    cominciato materiale insufficiente
    --
    
    -- stack di pezzimangiati puo servire ad altro oltre a scoprire che è patta per materiale insufficiente??
    
    -- fare una funzione interpreta_fen separandola dal costruttore??
    
    
    --  aggiungere booleano nelle torri e nel re per arrocco---- NON DOVREBBE SERVIRE
    
    -- la stack delle mosse magari la faccio private (TODO implementare setter e getter)
        -- forse dovrebbe essere uno stack di coppie (stringa_fen, mossa)
    
    
    -- mettere public static TURNO in partita scacchi (provare)
    
    
    -- SET GET SCACCHIOERA???
 
    
    -- in muovi alla fine controlla: scacco\ pedone promozione\....ù
    
    
    ---RE
    
    ---PEDONI
    
    
    stofacendo sottoScacco() in Partitascacchi, però mi serve da fare getRe()in Scacchiera 
    che mi ritorna la posizione del re.. devo provare il puoi
    muovere() per i pezzi dell'avversario ma puoi muovere prende in input due 
    caselle e qui casca l'asino perchè io non ho le caselle associate ai pezzi
    
    dovro mettere una map di caselle
    
    controllare che  i pezzi non finiscano fuori dalla scacchiera, n la casellla
    
    ----------------------------------------
    MANCANO
    -pedoni
    
    - gestire INPUT: controlla la correttezza delle lettere, ma non se sono di più o di meno
    
    --gestione in pattaException dei vari tipi di patta
    -mettere turno dopo la scacchirea nella sampa
    -scacchiera.getCasella() controllare la condizione
    --controllare il fatto che il re puo muovere e mettersi sotto scacco quindi bisogna annullarne la mossa
        se implementoil ritira, poi posso 
    --i pezzi vanno aggiunti nei set() nel momento in cui vengono creati Pezzineri PezziBaicnhi
    
    ---IN MOSSA METTERE CHE È SOTTOSCACCO;
   
    --re che si mette sotto scacco da solo, re che si toglie dallo scacco (sottoScacco viene chiamato prima della mossa quindi
        se la mossa sarebbe stata che il re si toglieva dallo scacco viene sollevata comunque RESOTTOSCACCO
    
   OGGGI
    ---mettere i lcontrollo della promozione nella scacchiera: nello sposta metto controllo per instance of pedone e 1a/ultima riga
    ---in movimento pedone metto la chiamata per il passant
    --inmovimento re metto la chiamata per arrocco
    (le due precedenti chiamano un metodo fdi modifica FEN)
    
    ---creare un attributo static 
    
    ----commit
    -aggiunti 2 hashMap con i pezzi in gioco per ogni giocatore
    -togliere enum turno, lasciando giocatore, e mettere una variabile statica per tenere il turno
    --controllato doppio passo pedone
     --scacco iteratore su pezzi
    
    
    
    ---OGGI
    --modificare materiale insufficiente: aggiunta parametro turno, cerca negli hashSet le pedine e controlla 
    
    */
    
    
}
