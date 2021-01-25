/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.ObservableGame;
import Data.States.AwaitDrawCard;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class AwaitDrawCardPanel extends JPanel implements Observer {

    private JButton retirarCarta[];
   
    private JButton retiracarta;
    private JButton dado;
    private ObservableGame game;

    public AwaitDrawCardPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setUp();
        setLayout();

        update(game, this);
    }

    private void setUp() {

        retirarCarta = new JButton[7];
        for (int i = 0; i < game.getCards().size(); i++) {
            retirarCarta[i] = new JButton(new ImageIcon(SiegePanel.getCard().getScaledInstance(SiegePanel.getCard().getWidth() / 4, SiegePanel.getCard().getHeight() / 4, Image.SCALE_DEFAULT)));
            retirarCarta[i].setBorder(BorderFactory.createEmptyBorder());
            retirarCarta[i].setContentAreaFilled(false);

        }
          dado = new JButton(new ImageIcon((SiegePanel.getDado1().getScaledInstance(SiegePanel.getDado1().getWidth(), SiegePanel.getDado1().getHeight(), Image.SCALE_SMOOTH))));
        dado.setBorder(BorderFactory.createEmptyBorder());
        dado.setContentAreaFilled(false);
        
        //  forte = new JButton(new ImageIcon(SiegePanel.getForte().getScaledInstance(SiegePanel.getForte().getWidth()/4,SiegePanel.getForte().getHeight()/4 ,Image.SCALE_DEFAULT)));
        //enemy = new JButton(new ImageIcon(SiegePanel.getEnemy().getScaledInstance(SiegePanel.getEnemy().getWidth()/4,SiegePanel.getEnemy().getHeight()/4 ,Image.SCALE_DEFAULT)));
        retiracarta = new JButton("Retira Carta");
        retiracarta.addActionListener(new retirarCartaListener());
//    forte.setBorder(BorderFactory.createEmptyBorder());
//    forte.setContentAreaFilled(false);
//    enemy.setBorder(BorderFactory.createEmptyBorder());
//    enemy.setContentAreaFilled(false);

    }

    private void setLayout() {

        //  add(retiracarta,getComponentAt(1, 20));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        // setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1920, 1080));

        Box box = Box.createHorizontalBox();
        // box.add(Box.createHorizontalGlue());
        box.add(Box.createHorizontalGlue());
        for (int i = 0; i < game.getCards().size(); i++) {

            box.add(retirarCarta[i]);

        }
           box.add(dado);
        box.add(retiracarta);
     
        box.add(Box.createHorizontalGlue());

        add(box);

    }

    public void viraCartaqueSaiu() {

        
        if( game.getGameData().getCards().size()==0)
        {
             for (int i = 0; i < 7; i++) {
           ImageIcon icon7 = new ImageIcon(SiegePanel.getCard().getScaledInstance(SiegePanel.getCard().getWidth() / 4, SiegePanel.getCard().getHeight() / 4, Image.SCALE_DEFAULT));
           retirarCarta[i].setIcon(icon7);
           retirarCarta[i].setBorder(BorderFactory.createEmptyBorder());
            retirarCarta[i].setContentAreaFilled(false);

        }
        }else
             
        switch (game.getGameData().getCartaActual().getSerie()) {
            case (1):
     
                ImageIcon icon = new ImageIcon(SiegePanel.getCard1().getScaledInstance(157, 219, Image.SCALE_DEFAULT));
                retirarCarta[0].setIcon(icon);
                retirarCarta[0].setBorder(BorderFactory.createEmptyBorder());
                retirarCarta[0].setContentAreaFilled(false);

                break;

            case (2):
                ImageIcon icon2 = new ImageIcon(SiegePanel.getCard2().getScaledInstance(157, 219, Image.SCALE_DEFAULT));
                retirarCarta[1].setIcon(icon2);
                retirarCarta[1].setBorder(BorderFactory.createEmptyBorder());
                retirarCarta[1].setContentAreaFilled(false);

                break;

            case (3):
                ImageIcon icon3 = new ImageIcon(SiegePanel.getCard3().getScaledInstance(157, 219, Image.SCALE_DEFAULT));
                retirarCarta[2].setIcon(icon3);

                retirarCarta[2].setBorder(BorderFactory.createEmptyBorder());
                retirarCarta[2].setContentAreaFilled(false);

                break;

            case (4):
                ImageIcon icon4 = new ImageIcon(SiegePanel.getCard4().getScaledInstance(157, 219, Image.SCALE_DEFAULT));
                retirarCarta[3].setIcon(icon4);
                retirarCarta[3].setBorder(BorderFactory.createEmptyBorder());
                retirarCarta[3].setContentAreaFilled(false);
          //      System.out.println(" x--->" + retirarCarta[3].getWidth() + "y-->" + retirarCarta[3].getHeight());
                retirarCarta[3].setEnabled(true);
                break;//Imagem Certa

            case (5):
                ImageIcon icon5 = new ImageIcon(SiegePanel.getCard5().getScaledInstance(157, 219, Image.SCALE_DEFAULT));
                retirarCarta[4].setIcon(icon5);
                retirarCarta[4].setBorder(BorderFactory.createEmptyBorder());
                retirarCarta[4].setContentAreaFilled(false);//Imagem Certa

                break;

            case (6):
                ImageIcon icon6 = new ImageIcon(SiegePanel.getCard6().getScaledInstance(157, 219, Image.SCALE_DEFAULT));
                retirarCarta[5].setIcon(icon6);
                retirarCarta[5].setBorder(BorderFactory.createEmptyBorder());
                retirarCarta[5].setContentAreaFilled(false);

                break;

            case 7:
                ImageIcon icon7 = new ImageIcon(SiegePanel.getCard7().getScaledInstance(157, 219, Image.SCALE_DEFAULT));
                retirarCarta[6].setIcon(icon7);
                retirarCarta[6].setBorder(BorderFactory.createEmptyBorder());
                retirarCarta[6].setContentAreaFilled(false);

                break;
        }
       
    }

    @Override
    public void update(Observable o, Object arg) {

        viraCartaqueSaiu();
        setVisible(game.getState() instanceof AwaitDrawCard);

    }

    class retirarCartaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //   System.out.println("vou mandar sair a carta");

            // repaint();
            game.showCard();

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();
// g.drawImage(SiegePanel.getFundo(), 1,1,getWidth()-2,getHeight()-2, this);
// 
//  
//      g.drawImage(SiegePanel.getIntro(),sizee.width/2-SiegePanel.getIntro().getWidth()/5, 10,SiegePanel.getIntro().getWidth()/3,SiegePanel.getIntro().getHeight()/3,this);
//      
// g.drawImage(SiegePanel.getForte(),1150 , 750, SiegePanel.getForte().getWidth()/4,SiegePanel.getForte().getHeight()/4, this);
//      
// g.drawImage(SiegePanel.getEnemy(),1000 , 750, SiegePanel.getEnemy().getWidth()/4,SiegePanel.getEnemy().getHeight()/4, this);
//       //  g.drawImage(SiegePanel.getForte(), 90,15 , 500,500,this);
//  
////FORTE//
////nao esquecer para baixo distancia de 38/ 27!!!!
// g.drawImage(SiegePanel.getPeca(),1155,753, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
// g.drawImage(SiegePanel.getPeca(),1193,753, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
// g.drawImage(SiegePanel.getPeca(),1231,753, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
//
// g.drawImage(SiegePanel.getPeca(),1153,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
//
// 
// 
// //ENEMY//
// g.drawImage(SiegePanel.getPeca(),1008,855, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
// g.drawImage(SiegePanel.getPeca(),1047,855, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
// g.drawImage(SiegePanel.getPeca(),1086,855, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
//
////trabuco 
// g.drawImage(SiegePanel.getPeca(),1086,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
//
// 
// 
// 
//               Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();

        super.paintComponent(g);

        g.drawImage(SiegePanel.getFundo(), 1, 1, getWidth() - 2, getHeight() - 2, this);

        g.drawImage(SiegePanel.getIntro(), sizee.width / 2 - SiegePanel.getIntro().getWidth() / 5, 10, SiegePanel.getIntro().getWidth() / 3, SiegePanel.getIntro().getHeight() / 3, this);

        g.drawImage(SiegePanel.getForte(), 1150, 750, SiegePanel.getForte().getWidth() / 4, SiegePanel.getForte().getHeight() / 4, this);

        g.drawImage(SiegePanel.getEnemy(), 1000, 750, SiegePanel.getEnemy().getWidth() / 4, SiegePanel.getEnemy().getHeight() / 4, this);
        //  g.drawImage(SiegePanel.getForte(), 90,15 , 500,500,this);

//FORTE//
//nao esquecer para baixo distancia de 38/ 27!!!!
        switch (game.getGameData().getForte().getPosicao("wall")) {
            case 0:
                g.drawImage(SiegePanel.getPeca(), 1193, 861, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1155, 834, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1155, 807, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1155, 780, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 4:
                g.drawImage(SiegePanel.getPeca(), 1155, 753, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

        }
        switch (game.getGameData().getForte().getPosicao("morale")) {
            case 0:
                g.drawImage(SiegePanel.getPeca(), 1193, 861, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1193, 834, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1193, 807, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1193, 780, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 4:
                g.drawImage(SiegePanel.getPeca(), 1193, 753, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

        }
        switch (game.getGameData().getForte().getPosicao("supplie")) {
            case 0:
                g.drawImage(SiegePanel.getPeca(), 1193, 861, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);
                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1231, 834, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);
                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1231, 807, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);
                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1231, 780, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);
                break;
            case 4:
                g.drawImage(SiegePanel.getPeca(), 1231, 753, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;

        }

        switch (game.getGameData().getForte().getPosicao("tunnel")) {
            case 0:
                g.drawImage(SiegePanel.getPeca(), 1152, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1168, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1184, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1205, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;

        }

        switch (game.getGameData().getEnemy().getPosicao("wall")) {

            case 0:
                g.drawImage(SiegePanel.getPeca(), 1047, 747, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1008, 774, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1008, 801, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1008, 828, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 4:
                g.drawImage(SiegePanel.getPeca(), 1008, 855, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;

        }

        switch (game.getGameData().getEnemy().getPosicao("door")) {
            case 0:
                g.drawImage(SiegePanel.getPeca(), 1047, 747, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1047, 774, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1047, 801, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1047, 828, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 4:
                g.drawImage(SiegePanel.getPeca(), 1047, 855, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;

        }

        switch (game.getGameData().getEnemy().getPosicao("tower")) {
            case 0:
                g.drawImage(SiegePanel.getPeca(), 1047, 747, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1086, 774, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1086, 801, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1086, 828, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 4:
                g.drawImage(SiegePanel.getPeca(), 1086, 855, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;

        }
        switch (game.getGameData().getEnemy().getPosicao("trebuchet")) {
            case 0:
                break;
            case 1:
                g.drawImage(SiegePanel.getPeca(), 1008, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 2:
                g.drawImage(SiegePanel.getPeca(), 1047, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
            case 3:
                g.drawImage(SiegePanel.getPeca(), 1086, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);

                break;
        }
     switch(game.getGameData().getForte().getPosicao("raid"))
        {
            case 0://920
                  g.drawImage(SiegePanel.getPeca(), 1235, 920, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);
              
                break;
            case 1:
                  g.drawImage(SiegePanel.getPeca(), 1235, 890, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);
              
                        break;
            case 2:
                  g.drawImage(SiegePanel.getPeca(), 1235, 865, SiegePanel.getPeca().getWidth() / 3, SiegePanel.getPeca().getHeight() / 3, this);
              
                break;
        }
    
    
        switch (game.getGameData().getDado()) {

            case 1:
                ImageIcon icon1 = new ImageIcon(SiegePanel.getDado1().getScaledInstance(SiegePanel.getDado1().getWidth(), SiegePanel.getDado1().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon1);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);
                break;

            case 2:
                ImageIcon icon2 = new ImageIcon(SiegePanel.getDado2().getScaledInstance(SiegePanel.getDado2().getWidth(), SiegePanel.getDado2().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon2);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);

                break;

            case 3:
                ImageIcon icon3 = new ImageIcon(SiegePanel.getDado3().getScaledInstance(SiegePanel.getDado3().getWidth(), SiegePanel.getDado3().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon3);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);

                break;

            case 4:
                ImageIcon icon4 = new ImageIcon(SiegePanel.getDado4().getScaledInstance(SiegePanel.getDado4().getWidth(), SiegePanel.getDado4().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon4);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);

                break;

            case 5:
                ImageIcon icon5 = new ImageIcon(SiegePanel.getDado5().getScaledInstance(SiegePanel.getDado5().getWidth(), SiegePanel.getDado5().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon5);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);

                break;

            case 6:
                ImageIcon icon6 = new ImageIcon(SiegePanel.getDado6().getScaledInstance(SiegePanel.getDado6().getWidth(), SiegePanel.getDado6().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon6);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);

                break;
                
            default :
                ImageIcon icon7 = new ImageIcon(SiegePanel.getDado6().getScaledInstance(SiegePanel.getDado6().getWidth(), SiegePanel.getDado6().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon7);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);
                break;

        }
    }
    

}
