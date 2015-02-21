package test.Gioco.Scacchi.Pedine;
/*
import Gioco.Casella;
import Gioco.Eccezioni.*;
import Gioco.Pezzo;
import Gioco.Scacchi.Eccezioni.PattaException;
import Gioco.Scacchi.PartitaScacchi;
import Gioco.Scacchiera;
import test.junit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReginaTest {

    private PartitaScacchi p;
    private Casella da;
    private Casella a1, a2, a3, a4, a5, a6;

    private Pezzo regina;

    @Before
    public void createPartita() throws InputErratoException, PattaException, MossaIllegaleException, CasellaVuotaException, CasellaOccupataException, TurnoErratoException {
        p = new PartitaScacchi("8/1q4P1/8/8/8/1P6/6P1/8");
        da = new Casella(1,1);
        a1 = new Casella(5,1);
        a2 = new Casella(7,1);
        a3 = new Casella(1,5);
        a4 = new Casella(7,1);
        a5 = new Casella(5,5);
        a6 = new Casella(7,7);


    }

    @Test
    public void testPuoiMuovere() throws Exception {

        Scacchiera s = p.getScacchiera();
        System.out.print(s.toString());
        regina = s.getPezzo(da);

        // test orizzontale
        assertTrue(regina.puoiMuovere(da, a1, s));
        assertFalse(regina.puoiMuovere(da, a2, s));

        // test verticale
        assertTrue(regina.puoiMuovere(da, a3, s));
        assertFalse(regina.puoiMuovere(da, a4, s));

        // test diagonale
        assertTrue(regina.puoiMuovere(da, a5, s));
        assertFalse(regina.puoiMuovere(da, a6, s));
    }

}
*/
