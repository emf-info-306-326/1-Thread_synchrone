/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.threads;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilles Waeber <moi@gilleswaeber.ch>
 */
public class CourseEquipe extends SThread {
	private Coureur[] c;
	private Course course;
	int equipe;
	private final int COUREURS = 4;

	public CourseEquipe(int equipe, Course course) {
		super("CourseEquipe "+equipe);
		
		this.equipe = equipe;
		this.course = course;
		
		c = new Coureur[COUREURS];
		for (int i = 0; i < c.length; i++) {
			c[i] = new Coureur(this,i);
			c[i].start();
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
		// END
		synchronized(c){
			for (Coureur coureur : c) {
				if (coureur != null) {
					coureur.setRunning(false);
				}
			}
			try {
				for (int i = 0; i < c.length; i++) {
					if(c[i] != null)c[i].join();
					c[i] = null;
				}
			} catch (InterruptedException ex) {
				Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public int getEquipe() {
		return equipe;
	}
	
	public void demarrer(){
		setPaused(false);
		c[0].setPaused(false);
	}
	
	public void recoitDistanceCoureur(int coureur, int distance){
		if(distance>=100){
			course.coureurTermine(equipe, coureur);
			synchronized(c){
				c[coureur].setRunning(false);
				if(coureur < COUREURS - 1){
					c[coureur+1].setPaused(false);
				}else{
					course.equipeTermine(equipe);
				}
			}
		}else{
			course.recoitDistanceCoureur(equipe, coureur, distance);
		}
	}
}
