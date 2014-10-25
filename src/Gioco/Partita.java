package Gioco;

import Gioco.Eccezioni.TurnoErratoException;
import Gioco.Scacchi.Eccezioni.PattaException;
import Gioco.Eccezioni.MossaIllegaleException;
import Gioco.Eccezioni.CasellaVuotaException;
import Gioco.Eccezioni.CasellaOccupataException;
import Gioco.Scacchi.Eccezioni.*;
/**
 *
 * @author Sibbor
 */
public interface Partita {
    
    public void muovi(Casella da, Casella a) throws CasellaVuotaException, 
            CasellaOccupataException, TurnoErratoException, ReSottoScaccoException,
            ScaccoMattoException, MossaIllegaleException, PattaException;
    
    public void abbandona();
    
    public void ritira();
    
    @Override
    public String toString();
    
    public String toStringPartita();
    
    
    
    
    
}


