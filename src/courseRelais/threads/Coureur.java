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
public class Coureur extends SThread {
	private CourseEquipe courseEquipe;
	private int coureur;
	private int distance = 0;

	public Coureur(CourseEquipe courseEquipe, int coureur) {
		super("Coureur "+courseEquipe.getEquipe()+"-"+coureur);
		this.courseEquipe = courseEquipe;
		this.coureur = coureur;
	}
	
	@Override
	public void run(){
		setRunning(true);
		while(isRunning()){
			if(!isPaused()){
				distance += 1;
				courseEquipe.recoitDistanceCoureur(coureur, distance);
				pause(20 + (int)(Math.random() * 60));
			}else{
				pause(10);
			}
		}
		// End
	}	
}
