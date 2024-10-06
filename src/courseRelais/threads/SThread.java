/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilles Waeber <moi@gilleswaeber.ch>
 */
public class SThread extends Thread {
	private volatile boolean running = false;
	private volatile boolean paused = true;
	
	public SThread(){
	}
	public SThread(String nom){
		super(nom);
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
	public void pause(int millis){
		try {
			sleep(millis);
		} catch (InterruptedException ex) {
			Logger.getLogger(SThread.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
