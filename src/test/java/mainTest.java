
import org.example.Carte;
import org.example.Lieu;
import org.example.Marcheur;
import org.example.Rue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

public class mainTest {
    @Test
    void bjarni_test() {
        var sekolintsika = new Lieu("Sekolintsika");
        var marais = new Lieu("Marais");
        var hei = new Lieu("HEI");
        var esti = new Lieu("ESTI");
        var pullman = new Lieu("Pullman");
        var boulevardDeLEurope = new Lieu("Boulevard De L'Europe");
        var nexta = new Lieu("Nexta");
        var balancoire = new Lieu("Balancoire");

        var bjarni = new Marcheur("Bjarni");
        var tana = new Carte(new HashSet<>(Set.of(
                new Rue(marais, sekolintsika),
                new Rue(sekolintsika, hei),
                new Rue("Rue Andriatsihoarana", hei, pullman),
                new Rue(hei, balancoire),
                new Rue(pullman, nexta),
                new Rue(pullman, balancoire),
                new Rue(balancoire, boulevardDeLEurope),
                new Rue(balancoire, esti),
                new Rue(boulevardDeLEurope, esti)
        )));

        var result = bjarni.marcher(tana, hei, esti);

        assertNotNull(result, "Le chemin ne doit pas être null");
        assertEquals(hei, result.get(0), "Le chemin doit commencer à HEI");
        assertEquals(esti, result.get(result.size() - 1), "Le chemin doit se terminer à ESTI");


        assertTrue(result.contains(pullman), "Le chemin doit contenir Pullman");
        assertTrue(result.contains(balancoire), "Le chemin doit contenir Balancoire");

        assertTrue(result.size() >= 3, "Le chemin doit contenir au moins trois lieux (HEI, un intermédiaire, ESTI)");


        assertEquals(hei, result.get(0), "Le premier lieu doit être HEI");
        assertEquals(esti, result.get(result.size() - 1), "Le dernier lieu doit être ESTI");


        result.forEach(System.out::println);
    }
}
