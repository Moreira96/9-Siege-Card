/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.Files.FileUtility;
import Data.Game;
import javax.swing.JFrame;
import Data.ObservableGame;
import Data.States.IStates;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Asus
 */

public class SiegeFrame extends JFrame implements Observer {

    private ObservableGame observablegame;
    private SiegePanel siegepanel;
    private JMenuItem newObjJMI;

    public SiegeFrame(ObservableGame obgame) {
        super("9 Siege Card");

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

//        setLayout(new BorderLayout());
        this.observablegame = obgame;
        System.out.println("as" + screen.height + "\t " + screen.width);

        //  setContentPane(new JLabel(new ImageIcon(siegepanel.getFundo().getScaledInstance(screen.width-500, screen.height-500, getWidth()))));
        Container cp = getContentPane();
        menus();
        siegepanel = new SiegePanel(obgame);

        cp.add(siegepanel, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //  setUndecorated(true);

        setBounds(0, 0, screen.height - 20, screen.width);
        setLocation(1, 1);
        // setSize(500,500); 
        // setMinimumSize(new Dimension(200,200));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();

    }

    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }

    protected void paintComponent(Graphics g) {
    }

    private void menus() {        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // game menu
        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        
//        JMenuItem newObjJMI = new JMenuItem("Stop");
        newObjJMI = new JMenuItem("Stop");
        newObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newObjJMI.setMnemonic(KeyEvent.VK_S); 
        JMenuItem readObjJMI = new JMenuItem("Load");
        readObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        
        JMenuItem saveObjJMI = new JMenuItem("Save");
        saveObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
        JMenuItem exitJMI = new JMenuItem("Exit");
        exitJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        gameMenu.add(newObjJMI);
        gameMenu.add(readObjJMI);
        gameMenu.add(saveObjJMI);
        gameMenu.addSeparator();    
        gameMenu.add(exitJMI);
        menuBar.add(gameMenu);
                
        newObjJMI.addActionListener(new NewObjMenuBarListener());
        readObjJMI.addActionListener(new LoadObjMenuBarListener());
        saveObjJMI.addActionListener(new SaveObjMenuBarListener());
        exitJMI.addActionListener(new ExitListener());

        
        // help menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem helpContentJMI = new JMenuItem("Creditos");
        helpContentJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));

        JMenuItem aboutJMI = new JMenuItem("About");
        aboutJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
       
        helpMenu.add(helpContentJMI);
        helpMenu.add(aboutJMI);
        menuBar.add(helpMenu);
      
        helpContentJMI.addActionListener(new HelpContentListener());
        aboutJMI.addActionListener(new AboutListener());
        
    }
    class NewObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             observablegame.endOfGame();
        }
    }
    
    class LoadObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showOpenDialog(SiegeFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();             
                try{
                    Game stateMachineGame = 
                            (Game)FileUtility.retrieveGameFromFile(file);
                    if(stateMachineGame != null){
                        observablegame.setGameData(stateMachineGame);
                    }
                }catch(IOException | ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(SiegeFrame.this, "Operation failed: \r\n\r\n" + e);
                }
          
            } else {
                System.out.println("Operation canceled ");
            }
        }
    }

    class SaveObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showSaveDialog(SiegeFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try{
                    FileUtility.saveGameToFile(file, observablegame.getGame());
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(SiegeFrame.this, "Operation failed: \r\n\r\n" + e);
                }
            } else {
                System.out.println("Operation canceled ");
            }
        }
    }


    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class HelpContentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(SiegeFrame.this,
                    "Ainda Indisponivel\n",
                    "Creditos ", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class AboutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(SiegeFrame.this,
                    "\tAdvanced Programming course\n\t 9 Siege Game!!!\nOne does not Simply...",
                    "About", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
