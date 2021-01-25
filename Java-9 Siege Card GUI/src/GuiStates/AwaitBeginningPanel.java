/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.ObservableGame;
import Data.States.AwaitBeginning;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class AwaitBeginningPanel extends JPanel implements Observer {

    private ObservableGame observablegame;
    private JButton startbotao;
    private JButton sair;
    private boolean on = false;

    private Som main;

    public AwaitBeginningPanel(ObservableGame observablegame) {
        this.observablegame = observablegame;

        this.observablegame.addObserver(this);

        main = new Som("sons/main.wav");

        setUp();
        setupLayout();

        update(observablegame, this);

    }

    private void setUp() {
        setOpaque(false);

        startbotao = new JButton("Novo Jogo");
       
        sair = new JButton("Sair");

        startbotao.addActionListener(new StartListener());
        sair.addActionListener(new SairListener());

    }

    private void setupLayout() {
        // setLayout(new GridBagLayout());
        //setBackground(Color.white);

        Box box = Box.createVerticalBox();
        setLayout(new GridBagLayout());
        // setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1920, 1080));

        box.add(startbotao);
 
        box.add(sair);
        box.add(Box.createHorizontalGlue());

        add(box);
    }

    @Override
    public void update(Observable t, Object o) {
        setVisible(observablegame.getState() instanceof AwaitBeginning);

    }

   

    class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            observablegame.start();
        }

    }

    class SairListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            observablegame.endOfGame();
   
        }
        
    }
    

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();

        super.paintComponent(g);
        on = main.loop(on);
        g.drawImage(SiegePanel.getFundo(), 1, 1, getWidth() - 2, getHeight() - 2, this);
        g.drawImage(SiegePanel.getIntro(), sizee.width / 2 - SiegePanel.getIntro().getWidth() / 5, 10, SiegePanel.getIntro().getWidth() / 3, SiegePanel.getIntro().getHeight() / 3, this);
    }
}
