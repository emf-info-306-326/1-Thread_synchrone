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
public interface ItfWrkCourse {
	void recoitTemps(String temps);
	void coureurTermine(int equipe, int numero, String info);
	void recoitDistanceCoureur(int equipe, int numero, int distance);
	void finCourse();
	void equipeArrive(int numero, String info);
}
