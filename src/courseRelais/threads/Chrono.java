/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.threads;

/**
 *
 * @author Gilles Waeber <moi@gilleswaeber.ch>
 */
public class Chrono extends SThread {
	private Course course;
	private long start;
	

	public Chrono(Course course) {
		super("Chrono");
		this.course = course;
	}
	
	public void demarrer(){
		start = System.currentTimeMillis();
		setPaused(false);
	}
	
	public void run(){
		setRunning(true);
		while(isRunning()){
			if(!isPaused()){
				int time = (int)(System.currentTimeMillis()-start)/10;
				int decimal = time%100;
				time /= 100;
				
				course.recoitTemps(""+time+"."+(decimal<10?"0":"")+decimal);
				pause(10);
			}else{
				pause(100);
			}
		}
	}
}
