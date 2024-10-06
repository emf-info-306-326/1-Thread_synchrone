/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseRelais.ctrl;

import courseRelais.ihm.ItfIhmCtrl;
import courseRelais.wrk.ItfWrkCtrl;

/**
 *
 * @author waeberla
 */
public class Ctrl implements ItfCtrlIhm, ItfCtrlWrk {

    public void start() {
        pauseAffichage = false;
    }

    // Implémentation des méthodes de ItfCtrlWrk
    public void demarreThreads() {
        refIfm.afficheInfo("Les threads de l'application sont créés,startés et mis en pause");
        refWrk.demarreThreads();
    }

    public void detruitThreads() {
        refIfm.afficheInfo("Les threads de l'application sont détruits et disparaissent de la mémoire");
        refWrk.detruitThreads();
    }

    public void recoitDateCourante(String laDateCourante) {
        if (laDateCourante != null) {
            refIfm.afficheDateCourante(laDateCourante);
        }
    }

    public void recoitTempsChrono(String temps) {
        if (temps != null) {
            if (!pauseAffichage) {
                refIfm.afficheTempsChrono(temps);
            }
        }
    }

    public void recoitDistanceCoureur(int equipe, int coureur, int distance) {
        if (!pauseAffichage) {
            refIfm.afficheDistance(equipe, coureur, distance);
        }
    }

    public void coureurTermineCourse(int equipe, int coureur, String info) {
        refIfm.afficheDistance(equipe, coureur, 100);
        refIfm.afficheInfo("le coureur " + coureur + " de l'équipe " + equipe + " : " + info);
        refIfm.afficheFinCourseCoureur(equipe, coureur, info);
    }

    public void equipeArrive(int numero, String info) {
        refIfm.afficheFinCourseEquipe(numero, info);
    }

    public void finCourse() {
        refIfm.toggleBoutonStart(true);
        refIfm.afficheInfo("Fin de la course");
    }

    // Implémentation des méthodes de ItfCtrlIhm
    public void demarreCourse() {
        refWrk.demarreCourse();
        refIfm.toggleBoutonStart(false);
        refIfm.afficheInfo("La course commence");
        pauseAffichage = false;
    }

    public void pauseCourse() {
        pauseAffichage = !pauseAffichage;
    }
    // Getter et Setter

    public ItfIhmCtrl getRefIfm() {
        return refIfm;
    }

    public void setRefIfm(ItfIhmCtrl refIfm) {
        this.refIfm = refIfm;
    }

    public ItfWrkCtrl getRefWrk() {
        return refWrk;
    }

    public void setRefWrk(ItfWrkCtrl refWrk) {
        this.refWrk = refWrk;
    }
    private ItfIhmCtrl refIfm;
    private ItfWrkCtrl refWrk;
    private boolean pauseAffichage;
}
