/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.tools;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class CaracteristiqueFactory {

    private static CaracteristiqueFactory instance = new CaracteristiqueFactory();

    private CaracteristiqueFactory() {
    }

    public static CaracteristiqueFactory getInstance() {
        return instance;
    }

    public MyJTextField<String> StringCaracteristique(JPanel container, Object obj, String name, Method methodForChangeFighter, Method methodRefresh, String matchesOnCaretEvent) {
        JLabel label = new JLabel(name + " : ");
        MyJTextField<String> jtf = new MyJTextField<String>(obj, methodRefresh);
        CaretListener cl = new MyCaretListener<String>(jtf, obj,methodForChangeFighter, matchesOnCaretEvent);
        jtf.addCaretListener(cl);
        container.add(label);
        container.add(jtf);

        return jtf;
    }

    public MyJTextField<Integer> IntegerCaracteristique(JPanel container, Object obj, String name, Method methodForChangeFighter, Method methodRefresh, String matchesOnCaretEvent) {
        JLabel label = new JLabel(name + " : ");
        MyJTextField<Integer> jtf = new MyJTextField<Integer>(obj, methodRefresh);
        CaretListener cl = new MyCaretListener<Integer>(jtf, obj,methodForChangeFighter, matchesOnCaretEvent);
        jtf.addCaretListener(cl);
        container.add(label);
        container.add(jtf);

        return jtf;
    }

    class MyCaretListener<E> implements CaretListener {

        private JTextField jtf;
        private Object obj;
        private Method methodForChangeFighter;
        private String matchesOnCaretEvent;

        public MyCaretListener(JTextField jtf, Object obj, Method methodForChangeFighter, String matchesOnCaretEvent) {
            this.jtf = jtf;
            this.obj = obj;

            if (!methodExist(Fighter.class, methodForChangeFighter)) throw new IllegalArgumentException("La méthode demandée n'existe pas...");

            this.methodForChangeFighter = methodForChangeFighter;
            this.matchesOnCaretEvent = matchesOnCaretEvent;
        }

        private boolean methodExist(Class c, Method m) {
            for (Method method : c.getMethods()) {
                if (method.equals(m)) return true;
            }
            return false;
        }

        @Override
        public void caretUpdate(CaretEvent ce) {
            String text = this.jtf.getText();

            //System.out.println(text);

            if (!text.equals("") && text.matches(this.matchesOnCaretEvent)) {
                try {
                    methodForChangeFighter.invoke(obj, text);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(CaracteristiqueFactory.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(CaracteristiqueFactory.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(CaracteristiqueFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jtf.setBackground(Color.WHITE);
            } else {
                this.jtf.setBackground(Color.RED);
            }
        }
    }
}
