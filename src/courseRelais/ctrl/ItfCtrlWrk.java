/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.ctrl;

/**
 *
 * @author waeberla
 */
public interface ItfCtrlWrk {

    void recoitDateCourante(String laDateCourante);

    void recoitTempsChrono(String temps);

    void recoitDistanceCoureur(int equipe, int coureur, int distance);

    void coureurTermineCourse(int equipe, int coureur, String info);

    void equipeArrive(int numero, String info);

    void finCourse();

}
