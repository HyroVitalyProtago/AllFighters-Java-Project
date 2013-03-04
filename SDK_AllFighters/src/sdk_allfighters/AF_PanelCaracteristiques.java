/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import com.apple.laf.AquaBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class AF_PanelCaracteristiques extends JPanel {

    private Fighter fighter;
    //
    private JTextField jtf_name, jtf_speed, jtf_jump_force, jtf_life, jtf_power, jtf_force, jtf_resistance;

    public AF_PanelCaracteristiques() {

        this.setLayout(new GridLayout(7,2));

        JLabel name = new JLabel("Name : ");
        jtf_name = new JTextField();

        JLabel speed = new JLabel("Speed : ");
        jtf_speed = new JTextField();

        JLabel jump_force = new JLabel("Jump force : ");
        jtf_jump_force = new JTextField();

        JLabel life = new JLabel("Life : ");
        jtf_life = new JTextField();

        JLabel power = new JLabel("Power : ");
        jtf_power = new JTextField();

        JLabel force = new JLabel("Force : ");
        jtf_force = new JTextField();

        JLabel resistance = new JLabel("Resistance : ");
        jtf_resistance = new JTextField();

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

    public AF_PanelCaracteristiques(Fighter fighter) {
        this();
        this.fighter = fighter;
        refresh();
    }



    public void refresh() {
        if (this.fighter == null) return;
        jtf_name.setText(this.fighter.getName());
        jtf_speed.setText(""+this.fighter.getSPEED());
        jtf_jump_force.setText(""+this.fighter.getJUMP_FORCE());
        jtf_life.setText(""+this.fighter.getLife());
        jtf_power.setText(""+this.fighter.getPower());
        jtf_force.setText(""+this.fighter.getForce());
        jtf_resistance.setText(""+this.fighter.getResistance());
    }

}
