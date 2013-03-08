/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.fighter;

import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import modele.fighters.Fighter;
import sdk_allfighters.tools.CaracteristiqueFactory;
import sdk_allfighters.tools.MyJTextField;

/**
 *
 * @author MyMac
 */
public class AF_PanelCaracteristiques extends JPanel {

    //private Fighter fighter;
    private AF_Frame frame;
    //
    //private JTextField jtf_name;
    //private JFormattedTextField jtf_speed, jtf_jump_force, jtf_life, jtf_power, jtf_force, jtf_resistance;

    //
    private ArrayList<MyJTextField> textFields = new ArrayList<MyJTextField>();
    //

    public AF_PanelCaracteristiques(AF_Frame frame) {
        this.frame = frame;

        this.setLayout(new GridLayout(7, 2));

        String patternName = "([a-z]|[A-Z]|[0-9]|-|_)*";
        String patternInteger = "[0-9]*";

        Fighter fighter = this.frame.getFighter();
        try {
            // -- NAME --
            textFields.add(CaracteristiqueFactory.getInstance().StringCaracteristique(this, Fighter.class, fighter, "Name",
                    Fighter.class.getMethod("setName", String.class), Fighter.class.getMethod("getName", null), patternName));

            // -- SPEED --
            textFields.add(CaracteristiqueFactory.getInstance().IntegerCaracteristique(this, Fighter.class, fighter, "Speed",
                    Fighter.class.getMethod("setSPEED", String.class), Fighter.class.getMethod("getSPEED", null), patternInteger));

            // -- JUMP_FORCE --
            textFields.add(CaracteristiqueFactory.getInstance().IntegerCaracteristique(this, Fighter.class, fighter, "Jump force",
                    Fighter.class.getMethod("setJUMP_FORCE", String.class), Fighter.class.getMethod("getJUMP_FORCE", null), patternInteger));

            // -- LIFE --
            textFields.add(CaracteristiqueFactory.getInstance().IntegerCaracteristique(this, Fighter.class, fighter, "Life",
                    Fighter.class.getMethod("setLife", String.class), Fighter.class.getMethod("getLife", null), patternInteger));

            // -- POWER --
            textFields.add(CaracteristiqueFactory.getInstance().IntegerCaracteristique(this, Fighter.class, fighter, "Power",
                    Fighter.class.getMethod("setPower", String.class), Fighter.class.getMethod("getPower", null), patternInteger));

            // -- FORCE --
            textFields.add(CaracteristiqueFactory.getInstance().IntegerCaracteristique(this, Fighter.class, fighter, "Force",
                    Fighter.class.getMethod("setForce", String.class), Fighter.class.getMethod("getForce", null), patternInteger));

            // -- RESISTANCE --
            textFields.add(CaracteristiqueFactory.getInstance().IntegerCaracteristique(this, Fighter.class, fighter, "Resistance",
                    Fighter.class.getMethod("setResistance", String.class), Fighter.class.getMethod("getResistance", null), patternInteger));

        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AF_PanelCaracteristiques.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AF_PanelCaracteristiques.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        JLabel name = new JLabel("Name : ");
        jtf_name = new JTextField();
        jtf_name.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent ce) {
                Fighter fighter = AF_PanelCaracteristiques.this.frame.getFighter();
                if (jtf_name.getText().matches("([a-z]|[A-Z]|[0-9]|-|_)*")) {
                    fighter.setName(jtf_name.getText());
                    jtf_name.setBackground(Color.WHITE);
                } else {
                    jtf_name.setBackground(Color.RED);
                }
            }
        });
*/
        /*
        JLabel speed = new JLabel("Speed : ");
        jtf_speed = new JFormattedTextField(NumberFormat.getIntegerInstance());

        JLabel jump_force = new JLabel("Jump force : ");
        jtf_jump_force = new JFormattedTextField(NumberFormat.getIntegerInstance());

        JLabel life = new JLabel("Life : ");
        jtf_life = new JFormattedTextField(NumberFormat.getIntegerInstance());

        JLabel power = new JLabel("Power : ");
        jtf_power = new JFormattedTextField(NumberFormat.getIntegerInstance());

        JLabel force = new JLabel("Force : ");
        jtf_force = new JFormattedTextField(NumberFormat.getIntegerInstance());

        JLabel resistance = new JLabel("Resistance : ");
        jtf_resistance = new JFormattedTextField(NumberFormat.getIntegerInstance());

        //this.add(name);
        //this.add(jtf_name);

        this.add(speed);
        this.add(jtf_speed);

        this.add(jump_force);
        this.add(jtf_jump_force);

        this.add(life);
        this.add(jtf_life);

        this.add(power);
        this.add(jtf_power);

        this.add(force);
        this.add(jtf_force);

        this.add(resistance);
        this.add(jtf_resistance);
*/
        //this.setBorder(new EmptyBorder(5,10,5,5));
        this.setBorder(BorderFactory.createTitledBorder(" Caractéristiques "));
    }
    /*
     * public AF_PanelCaracteristiques(Fighter fighter) { this(); this.fighter =
     * fighter; refresh(); }
     */

    public void refresh() {


        Fighter fighter = this.frame.getFighter();
        if (fighter == null) {
            return;
        }
        /*
        jtf_name.setText(fighter.getName());
        jtf_speed.setText("" + fighter.getSPEED());
        jtf_jump_force.setText("" + fighter.getJUMP_FORCE());
        jtf_life.setText("" + fighter.getLife());
        jtf_power.setText("" + fighter.getPower());
        jtf_force.setText("" + fighter.getForce());
        jtf_resistance.setText("" + fighter.getResistance());
        */

        for (MyJTextField jTextField : textFields) {
            jTextField.refresh();
        }

    }
}
