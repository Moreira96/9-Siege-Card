/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.ObservableGame;
import Data.States.AwaitAcabou;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class AwaitGameOverPanel extends JPanel implements Observer {
    
        private ObservableGame observablegame;
  
    private boolean on = false;

    private Som main;

    public AwaitGameOverPanel(ObservableGame observablegame) {
        this.observablegame = observablegame;

        this.observablegame.addObserver(this);

        main = new Som("sons/main.wav");

        setUp();
        setupLayout();

        update(observablegame, this);

    }

    private void setUp() {
        setOpaque(false);

    

    }

    private void setupLayout() {
        // setLayout(new GridBagLayout());
        //setBackground(Color.white);
  setLayout(new BorderLayout());
        // setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1920, 1080));
          }

    @Override
    public void update(Observable t, Object o) {
     
        setVisible(observablegame.getState() instanceof AwaitAcabou);
        
        if( observablegame.getState()instanceof AwaitAcabou)
        {
            System.exit(0);
  
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
        on = main.iniciar(on);
        g.drawImage(SiegePanel.getFundo(), 1, 1, getWidth() - 2, getHeight() - 2, this);
        g.drawImage(SiegePanel.getIntro(), sizee.width / 2 - SiegePanel.getIntro().getWidth() / 5, 10, SiegePanel.getIntro().getWidth() / 3, SiegePanel.getIntro().getHeight() / 3, this);
    }
}

