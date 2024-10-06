/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseRelais.ihm;

/**
 *
 * @author waeberla
 */
public interface ItfIhmCtrl {

    /**
     * Cette méthode affiche la date courante représentant l'horloge.
     * @param laDateCourante String
     */
    void afficheDateCourante(String laDateCourante);
/**
 * Cette méthode affiche le temps du chronomètre.
 * @param temps String la valeur du temps du chronomètre.
 */
    void afficheTempsChrono(String temps);

    /**
     * Cette méthode active ou désactive le bouton Start de la course.
     * La couleur est également changée.
     * @param on boolean. Si true le bouton est actif sinon desactivé.
     */
    void toggleBoutonStart(boolean on);

    /**
     * Cette méthode affiche la distance sur la progress bar représentant le coureur.
     * @param equipe int le numéro de l'équipe.
     * @param coureur int le numéro du coureur.
     * @param distance int la distance parcourue. (100 maximum)
     */
    void afficheDistance(int equipe, int coureur, int distance);

    /**
     * Cette méthode affiche l'arrivée du coureur représenté par son numéro ainsi
     * que son temps contenu dans le String info.
     * @param equipe int le numéro de l'équipe pour laquelle il faut faire ce traitement
     * @param coureur int le numéro du coureur pour lequel il faut faire ce traitement
     * @param info String le rang et le temps du coureur.
     */
    void afficheFinCourseCoureur(int equipe, int coureur, String info);

    /**
     * Cette méthode affiche l'arrivée de l'équipe représenté par son numéro ainsi
     * que son rang et de son temps contenu dans le String info.
     * @param equipe int le numéro de l'équipe pour laquelle il faut faire ce traitement
     * @param info String le rang et le temps de l'équipe.
     */
    void afficheFinCourseEquipe(int equipe, String info);
    /**
     * Cette méthode réactive le bouton start.
     */
    void afficheFinCourse();

    /**
     * Cette méthode affiche du texte dans la zone Informations sur la course.
     * @param info String l'information a écrire.
     */
    void afficheInfo(String info);

    /**
     * Cette méthode réinitialise le texte du coureur. Par exemple Coureur No 1
     * en lieu et place de "Coureur No 1 est arrivé : rang 2 : temps 00:26.345"
     */
    void initialiseTextCoureur();
}
