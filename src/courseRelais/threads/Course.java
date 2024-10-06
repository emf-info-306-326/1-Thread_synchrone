/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.threads;

import courseRelais.wrk.ItfWrkCourse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilles Waeber <moi@gilleswaeber.ch>
 */
public class Course extends SThread {
	private CourseEquipe[] courseEquipes;
	private ItfWrkCourse refWrk;
	private String temps;
		
	private Chrono chrono;
	
	public Course(ItfWrkCourse refWrk){
		super("Course");
		this.refWrk = refWrk;
		chrono = new Chrono(this);
		chrono.start();
		courseEquipes = new CourseEquipe[4];
		for (int i = 0; i < courseEquipes.length; i++) {
			courseEquipes[i] = new CourseEquipe(i, this);
			courseEquipes[i].start();
		}
	}
	
	@Override
	public void run(){
		setRunning(true);
		while(isRunning()){
			if(!isPaused()){
				pause(50);				
			}else{
				pause(10);
			}
		}
		// End
		chrono.setRunning(false);
		for (int i = 0; i < courseEquipes.length; i++) {
			courseEquipes[i].setRunning(false);
		}
		try {
			chrono.join();
			chrono = null;
			for (int i = 0; i < courseEquipes.length; i++) {
				courseEquipes[i].join();
				courseEquipes[i] = null;
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void demarrer(){
		setPaused(false);
		chrono.demarrer();
		for (CourseEquipe courseEquipe : courseEquipes) {
			courseEquipe.demarrer();
		}
	}

	void recoitDistanceCoureur(int equipe, int coureur, int distance) {
		refWrk.recoitDistanceCoureur(equipe, coureur, distance);
	}

	void coureurTermine(int equipe, int coureur) {
		refWrk.coureurTermine(equipe, coureur, temps);
	}

	void equipeTermine(int equipe) {
		refWrk.equipeArrive(equipe, temps);
		courseEquipes[equipe].setRunning(false);
		boolean end = true;
		for (CourseEquipe courseEquipe : courseEquipes) {
			if(courseEquipe.isRunning())end = false;
		}
		if(end){
			refWrk.finCourse();
			setRunning(false);
		}
	}

	void recoitTemps(String string) {
		temps = string;
		refWrk.recoitTemps(string);
	}
}
