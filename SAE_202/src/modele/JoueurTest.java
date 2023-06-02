package modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {
    @Test
    void completerQueteGloutonne(){
        //Test 1 :
        Joueur joueur1 = new Joueur();
        Quete quete1 = new Quete("18|(16, 6)|((2, 16),)|1|100|vaincre Géant du feu");

        //on regarde si le joueur n'est pas déja sur la quete, si il n'est pas à la meme position, on le fait se déplacer (ça va augmenter le temps)
        while (joueur1.getPositionX() != quete1.getPos()[0] && joueur1.getPositionY() != quete1.getPos()[1]){
            joueur1.seDeplacerVers(quete1.getPos()[0],quete1.getPos()[1]);
        }

        //je j1 est sur la quete, il la complete donc
        joueur1.completerQueteGloutonne(quete1);

        assertEquals(100, joueur1.getExperience());
        assertEquals(16, joueur1.getPositionX());
        assertEquals(6, joueur1.getPositionY());
        assertEquals(23, joueur1.getTemps()); // le temps est de 23 car : (16-0)+(6-0)+1 = 23
        assertTrue(joueur1.queteCompleteeGloutonne(18));

        //Test 2 :
        Joueur joueur2 = new Joueur();
        Quete quete2 = new Quete("0|(5, 1)|((4,),)|8|650|explorer cascade de Irma Lenora");

        //on regarde si le joueur n'est pas déja sur la quete, si il n'est pas à la meme position, on le fait se déplacer (ça va augmenter le temps)
        while (joueur2.getPositionX() != quete2.getPos()[0] && joueur2.getPositionY() != quete2.getPos()[1]){
            joueur2.seDeplacerVers(quete2.getPos()[0],quete2.getPos()[1]);
        }

        //je j1 est sur la quete, il la complete donc
        joueur2.completerQueteGloutonne(quete2);

        assertEquals(0, joueur2.getExperience()); // comme c'est la quete 0, ca ne donne pas d'experience
        assertEquals(5, joueur2.getPositionX());
        assertEquals(1, joueur2.getPositionY());
        assertEquals(14, joueur2.getTemps()); // le temps est de 14 car : (5-0)+(1-0)+8
        assertTrue(joueur2.queteCompleteeGloutonne(0));
    }
}