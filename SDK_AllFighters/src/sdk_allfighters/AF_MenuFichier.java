/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
                    throw new UnsupportedOperationException("Not supported yet.");
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
}
