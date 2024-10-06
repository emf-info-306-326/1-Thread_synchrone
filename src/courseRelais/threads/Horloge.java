/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais.threads;

import courseRelais.wrk.ItfWrkCtrl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilles Waeber <moi@gilleswaeber.ch>
 */
public class Horloge extends SThread {
	private ItfWrkCtrl refWrk;
	private DateFormat df;

	public Horloge(ItfWrkCtrl refWrk) {
		super("Horloge");
		this.refWrk = refWrk;
		df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	}
	
	@Override
	public void run(){
		setRunning(true);
		while(isRunning()){
			if(!isPaused()){
				pause(500);
				refWrk.recoitDateEtHeure(df.format(new Date()));
			}else{
				pause(100);
			}
		}
	}
}
