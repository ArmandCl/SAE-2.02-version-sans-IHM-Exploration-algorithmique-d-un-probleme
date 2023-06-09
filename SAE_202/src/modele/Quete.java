package modele;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Cette classe va être utilisée pour extraire des données relatives aux quêtes pour les rendre exploitables et plus lisibles / compréhensibles
 */

public class Quete {
    private int numero;
    private int[] pos = new int[2];
    private int[] precond = new int[4];
    private int duree;
    private int experience;
    private String intitule;

    /**
     * Methode constructeur de la classe Quete qui instancie les différents champs d'une certaine ligne
     *
     * @param ligne String La ligne dont on veut extraire des informations
     */
    public Quete(String ligne){
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()){
            this.numero = scanner.nextInt();

            String pos = scanner.next();
            this.pos = extraitPos(pos);

            String precond = scanner.next();
            this.precond = extraitPrecond(precond);

            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();


        }
    }

    /**
     * Permet d'extraire la position et de la ranger dans une tableau d'entiers
     *
     * @param position String La position que l'on veut extraire
     * @return tabpos int[] Le tableau avec la position
     */
    public int[] extraitPos(String position){
        int[] tabpos = new int[2];
        position = position.replace("(","");
        position = position.replace(")","");
        position = position.replace(" ","");
        Scanner sc = new Scanner(position).useDelimiter(",");
        int i = 0;
        while (sc.hasNext()){
            String extrait = sc.next();
            if (!extrait.equals(""))
                tabpos[i] = Integer.parseInt(extrait);
            i++;
        }
        return tabpos;
    }

    /**
     * Permet d'extraire la précondition et de la ranger dans un tableau d'entiers
     *
     * @param precond String La précondition que l'on veut extraire
     * @return tabPreconditions int[] Le tableau avec la précondition
     */
    public int[] extraitPrecond(String precond){
        int[] tabPreconditions = new int[4];
        precond = precond.replace("(","");
        precond = precond.replace(")","");
        precond = precond.replace(" ","");
        Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
        int i = 0;
        while (scanPrecondition.hasNext()){
            String extrait = scanPrecondition.next();
            if (!extrait.equals(""))
                tabPreconditions[i] = Integer.parseInt(extrait);
            i++;
        }
        return tabPreconditions;
    }

    /**
     * Affiche une ligne de quête de maniere lisible avec toutes les informations utiles
     *
     * @return String
     */
    public  String toString(){
        return  numero + " - "+ Arrays.toString(pos) + " - "+ Arrays.toString(precond) + " - " + duree + " - " + experience + " - " + intitule;
    }

    /**
     * Permet d'avoir le numero d'une quete
     *
     * @return numero int
     */
    public int getNumero(){

        return numero;

    }

    /**
     * Permet d'avoir la position d'une quete
     *
     * @return pos int[]
     */
    public int[] getPos(){

        return pos;

    }

    /**
     * Permet d'avoir la précondition d'une quete
     *
     * @return precond int[]
     */
    public int[] getPrecond(){

        return precond;

    }

    /**
     * permet d'avoir la durré d'une quete
     *
     * @return duree int
     */
    public int getDuree(){

        return duree;

    }

    /**
     * Permet d'avoir l'experience d'une quete
     *
     * @return experience int
     */
    public int getExperience(){

        return experience;

    }

    /**
     * Permet d'avoir l'intitulé d'une quete
     *
     * @return intitule String
     */
    public String getIntitule(){

        return intitule;

    }

}
