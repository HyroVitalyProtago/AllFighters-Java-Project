/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class MyJTextField<E> extends JFormattedTextField {

    private Fighter fighter;
    private Method refresh;

    public MyJTextField(Fighter fighter, Method refresh) {
        this.fighter = fighter;
        this.refresh = refresh;
    }

    public void refresh() {
        try {
            Object obj = refresh.invoke(fighter, null);
            this.setText(((E)obj).toString());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MyJTextField.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MyJTextField.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(MyJTextField.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
