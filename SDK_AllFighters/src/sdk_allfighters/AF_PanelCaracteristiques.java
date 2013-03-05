/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.Keymap;
import javax.swing.text.MaskFormatter;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class AF_PanelCaracteristiques extends JPanel {

    //private Fighter fighter;
    private AF_Frame frame;
    //
    private JTextField jtf_name;
    private JFormattedTextField jtf_speed, jtf_jump_force, jtf_life, jtf_power, jtf_force, jtf_resistance;

    public AF_PanelCaracteristiques(AF_Frame frame) {
        this.frame = frame;

        this.setLayout(new GridLayout(7,2));

        JLabel name = new JLabel("Name : ");
        jtf_name = new JTextField();

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

        this.add(name);
        this.add(jtf_name);

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

        //this.setBorder(new EmptyBorder(5,10,5,5));
        this.setBorder(BorderFactory.createTitledBorder(" Caractéristiques "));
    }
/*
    public AF_PanelCaracteristiques(Fighter fighter) {
        this();
        this.fighter = fighter;
        refresh();
    }
*/


    public void refresh() {
        Fighter fighter = this.frame.getFighter();
        if (fighter == null) return;
        jtf_name.setText(fighter.getName());
        jtf_speed.setText(""+fighter.getSPEED());
        jtf_jump_force.setText(""+fighter.getJUMP_FORCE());
        jtf_life.setText(""+fighter.getLife());
        jtf_power.setText(""+fighter.getPower());
        jtf_force.setText(""+fighter.getForce());
        jtf_resistance.setText(""+fighter.getResistance());
    }

}
