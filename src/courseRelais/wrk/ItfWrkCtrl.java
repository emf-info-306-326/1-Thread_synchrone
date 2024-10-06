/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.wrk;

/**
 *
 * @author waeberg01
 */
public interface ItfWrkCtrl {
	void demarreThreads();
	void detruitThreads();
	void demarreHorloge();
	void recoitDateEtHeure(String laDateCourante);
	void prepareCourse();
	void demarreCourse();
}
