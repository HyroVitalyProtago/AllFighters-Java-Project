/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.Format;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class AF_MenuFichier extends JMenu {

    private AF_Frame frame;

    public AF_MenuFichier(AF_Frame frame) {
        super("Fichier");
        this.add(new NouveauFighter());
        this.add(new Ouvrir());
        this.add(new Enregistrer());
        this.frame = frame;
    }

    public class NouveauFighter extends JMenuItem {

        public NouveauFighter() {
            super("Nouveau Fighter");
            this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            this.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    //throw new UnsupportedOperationException("Not supported yet.");

                    System.out.println("Nouveau Fighter");

                    /*
                     * JDialog dialog = new JDialog(AF_MenuFichier.this.frame,
                     * "Nouveau Fighter", true); dialog.add(new JLabel("Saisir
                     * le nom du Fighter : ")); JTextField jtf = new
                     * JTextField(); dialog.add(jtf); dialog.setVisible(true);
                     */

                    //Custom button text
                    /*
                     * Object[] options = {"OK", "Annuler"}; int n =
                     * JOptionPane.showOptionDialog(frame, "Saisir le nom du
                     * Fighter : ", "Nouveau Fighter",
                     * JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                     * null, options, options[0]);
                     *
                     */
                    //AF_MenuFichier.this.frame.setFighter(new Fighter());

                    JDialog dialog = new DialogNouveauFighter();

                }
            });
        }
    }

    public class Ouvrir extends JMenuItem {

        public Ouvrir() {
            super("Ouvrir");
            this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            this.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
//                    JFileChooser chooser = new JFileChooser();
//                    File defaultDirectory = new File("../SpriteAllFighters/TakeshiYamamoto/");
//                    chooser.setCurrentDirectory(defaultDirectory);
//                    chooser.setAcceptAllFileFilterUsed(false);
//                    FileNameExtensionFilter filter = new FileNameExtensionFilter("All Images", "png", "jpg", "gif", "jpeg", "afimg");
//                    chooser.addChoosableFileFilter(filter);
//
//                    int returnVal = chooser.showOpenDialog(AF_MenuFichier.this.frame);
//
//                    if (returnVal == JFileChooser.APPROVE_OPTION) {
//                        File file = chooser.getSelectedFile();
//
//                        String name = file.getName();
//                        String extension = name.substring(name.length() - 5, name.length());
//
//                        //System.out.println(extension);
//                        if (extension.equals("afimg")) {
//                            String absolutePath = file.getAbsolutePath();
//                            String path = absolutePath.substring(0, absolutePath.length() - 6);
//                            AF_MenuFichier.this.frame.setImageI(path);
//                        } else {
//                            AF_MenuFichier.this.frame.setImage(file);
//                        }
//                    } else {
//                        System.out.println("Open command cancelled by user.");
//                    }
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            });
        }
    }

    public class Enregistrer extends JMenuItem {

        public Enregistrer() {
            super("Enregistrer");
            this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            this.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    //if (!AF_MenuFichier.this.frame.enregistrer()) {
                    //AF_MenuFichier.this.accessibleContext.setPath();
                    //}
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            });
        }
    }

    class DialogNouveauFighter extends JDialog {

        private JTextField jtf;

        public DialogNouveauFighter() {

            JPanel mainPanel = new JPanel(new GridLayout(3,1));
            mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            this.setTitle("Nouveau Fighter");
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            this.setResizable(false);
            this.setModal(true);

            mainPanel.add(new JLabel("Saisir le nom du Fighter : "));
            jtf = new JTextField();
            mainPanel.add(jtf);

            JButton ok = new JButton("OK");
            ok.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    String text = DialogNouveauFighter.this.jtf.getText();
                    if (text.matches("([a-z]|[A-Z])*")) {
                        System.out.println("Création du nouveau fighter...");
                        AF_MenuFichier.this.frame.setFighter(new Fighter(text));
                        DialogNouveauFighter.this.dispose();
                    } else {
                        System.out.println("/!\\ Seul les caractères de l'alphabet [a-z] sont acceptés.");
                    }
                }
            });

            JButton annuler = new JButton("Annuler");
            annuler.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    DialogNouveauFighter.this.dispose();
                }
            });

            JPanel container = new JPanel(new GridLayout(1,2));

            container.add(ok);
            container.add(annuler);
            mainPanel.add(container);

            this.add(mainPanel);

            this.pack();
            this.setLocationRelativeTo(null);

            this.setVisible(true);

        }
    }
}
