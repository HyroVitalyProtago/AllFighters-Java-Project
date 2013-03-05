/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import development.XStreamer_Fighter;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class AF_MenuFichier extends JMenu {

    private AF_Frame frame;
    private JMenuItem enregistrer;

    public AF_MenuFichier(AF_Frame frame) {
        super("Fichier");
        this.add(new NouveauFighter());
        this.add(new Ouvrir());
        enregistrer = new Enregistrer();
        enregistrer.setEnabled(false);
        this.add(enregistrer);
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
                    JFileChooser chooser = new JFileChooser();
                    File defaultDirectory = new File("../SpriteAllFighters/TakeshiYamamoto/");
                    chooser.setCurrentDirectory(defaultDirectory);
                    chooser.setAcceptAllFileFilterUsed(false);
                    //FileNameExtensionFilter filter = new FileNameExtensionFilter("All Images", "png", "jpg", "gif", "jpeg", "afimg");
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("FIGHTER", "fighter");
                    chooser.addChoosableFileFilter(filter);

                    int returnVal = chooser.showOpenDialog(AF_MenuFichier.this.frame);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = chooser.getSelectedFile();

                        String name = file.getName();
                        /*
                         * String extension = name.substring(name.length() - 5,
                         * name.length());
                         *
                         * //System.out.println(extension); if
                         * (extension.equals("afimg")) { String absolutePath =
                         * file.getAbsolutePath(); String path =
                         * absolutePath.substring(0, absolutePath.length() - 6);
                         * AF_MenuFichier.this.frame.setImageI(path); } else {
                         * AF_MenuFichier.this.frame.setImage(file); }
                         *
                         */

                        AF_MenuFichier.this.frame.setFighter(new XStreamer_Fighter().load(file.getAbsolutePath()));
                        enregistrer.setEnabled(true);

                    } else {
                        System.out.println("Open command cancelled by user.");
                    }
                    //throw new UnsupportedOperationException("Not supported yet.");
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
                    Fighter fighter = AF_MenuFichier.this.frame.getFighter();
                    String path = AF_MenuFichier.this.frame.getPath();
                    if (fighter != null) {
                        if (path == null) {
                            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
                            File defaultDirectory = new File("../SpriteAllFighters/TakeshiYamamoto/");
                            chooser.setCurrentDirectory(defaultDirectory);

                            chooser.setAcceptAllFileFilterUsed(false);
                            chooser.addChoosableFileFilter(new FileFilter() {

                                @Override
                                public boolean accept(File file) {
                                    if (file.isDirectory()) return false;
                                    return file.getName().matches("([a-z]|[A-Z]|[0-9]|_|-)*.fighter");
                                }

                                @Override
                                public String getDescription() {
                                    return "Fighter";
                                }
                            });

                            chooser.setSelectedFile(new File(fighter.getName() + ".fighter"));

                            //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                            int returnVal = chooser.showSaveDialog(AF_MenuFichier.this.frame);
                            //System.out.println(chooser.getSelectedFile().getName());

                            if (returnVal == JFileChooser.APPROVE_OPTION) {
                                path = chooser.getSelectedFile().getAbsolutePath();

                                while (!chooser.getSelectedFile().getName().matches("([a-z]|[A-Z]|[0-9]|_|-)*.fighter")) {
                                    JOptionPane.showMessageDialog(frame,
                                        "Attention ! Le nom ne peut comporter que les lettres de l'alphabet, des chiffres ainsi que '_' et '-'.\n"
                                            + "L'extension doit être du type '.fighter'.",
                                        "Error of FileName or extension",
                                        JOptionPane.ERROR_MESSAGE);
                                    returnVal = chooser.showSaveDialog(AF_MenuFichier.this.frame);
                                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                                        path = chooser.getSelectedFile().getAbsolutePath();
                                    } else {
                                        return;
                                    }
                                }

                                try {
                                    //System.out.println(fighter);
                                    //System.out.println(path);
                                    new XStreamer_Fighter().save(fighter, path);
                                } catch (IOException ex) {
                                    Logger.getLogger(AF_MenuFichier.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    } else {
                        System.out.println("Impossible de sauvegarder un fighter NULL");
                    }
                }
            });
        }
    }

    class DialogNouveauFighter extends JDialog {

        private JTextField jtf;

        public DialogNouveauFighter() {

            JPanel mainPanel = new JPanel(new GridLayout(3, 1));
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
                        AF_MenuFichier.this.enregistrer.setEnabled(true);
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

            JPanel container = new JPanel(new GridLayout(1, 2));

            container.add(ok);
            container.add(annuler);
            mainPanel.add(container);

            this.add(mainPanel);

            this.pack();
            //this.setSize(300, 200);
            this.setLocationRelativeTo(null);

            this.setVisible(true);

        }
    }
}
