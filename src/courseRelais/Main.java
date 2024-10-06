/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package courseRelais;

import courseRelais.ctrl.Ctrl;
import courseRelais.ihm.Ihm;
import courseRelais.wrk.Wrk;

/**
 *
 * @author waeberla
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ctrl ctrl = new Ctrl();
                Ihm ihm = new Ihm();
                Wrk wrk = new Wrk();
                ctrl.setRefIfm(ihm);
                ctrl.setRefWrk(wrk);
                ihm.setRefCtrl(ctrl);
                wrk.setRefCtrl(ctrl);
                ctrl.start();
            }
        });
    }

}
