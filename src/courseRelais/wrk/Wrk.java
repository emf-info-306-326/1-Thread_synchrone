/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.wrk;

import courseRelais.threads.Course;
import courseRelais.threads.Horloge;
import courseRelais.ctrl.ItfCtrlWrk;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author waeberg01
 */
public class Wrk implements ItfWrkCourse, ItfWrkCtrl{
	private Horloge horloge;
	private Course course;
	private ItfCtrlWrk refCtrl;
	
	public Wrk(){
	}

	public void recoitTemps(String temps) {
		refCtrl.recoitTempsChrono(temps);
	}

	public void coureurTermine(int equipe, int numero, String info) {
		refCtrl.coureurTermineCourse(equipe+1, numero+1, info);
	}

	public void recoitDistanceCoureur(int equipe, int numero, int distance) {
		refCtrl.recoitDistanceCoureur(equipe+1, numero+1, distance);
	}

	public void finCourse() {
		refCtrl.finCourse();
	}

	public void equipeArrive(int numero, String info) {
		refCtrl.equipeArrive(numero, info);
	}

	public void demarreThreads() {
		detruitThreads();
		
		horloge = new Horloge(this);
		horloge.start();
		horloge.setPaused(false);
		
		course = new Course(this);
		course.start();
	}

	public void detruitThreads() {
		if(course != null){
			course.setRunning(false);
			try {
				course.join();
			} catch (InterruptedException ex) {
				Logger.getLogger(Wrk.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		course = null;
		if(horloge != null){
			horloge.setRunning(false);
			try {
				horloge.join();
			} catch (InterruptedException ex) {
				Logger.getLogger(Wrk.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		horloge = null;
		System.gc();
	}

	public void demarreHorloge() {
		//TODO : code Wrk.demarreHorloge
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void recoitDateEtHeure(String laDateCourante) {
		refCtrl.recoitDateCourante(laDateCourante);
	}

	public void prepareCourse() {
		//TODO : code Wrk.prepareCourse
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void demarreCourse() {
		course.demarrer();
	}

	public ItfCtrlWrk getRefCtrl() {
		return refCtrl;
	}

	public void setRefCtrl(ItfCtrlWrk refCtrl) {
		this.refCtrl = refCtrl;
	}
}
