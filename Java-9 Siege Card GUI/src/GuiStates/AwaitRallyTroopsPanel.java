/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.ObservableGame;
import Data.States.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Asus
 */
public class AwaitRallyTroopsPanel extends JPanel implements Observer{
    private ObservableGame game;
    private JButton actual ;
    private JRadioButton escolhe1;
    private JRadioButton escolhe2;

    private ButtonGroup grupo ;
    
  public AwaitRallyTroopsPanel(ObservableGame game )
    {
        this.game = game;
        this.game.addObserver(this);
        
        
        setup();
        setLayout();
        
        update(game,this);
    //    System.out.println("gvvhbh" + game.getState());
        
        
    }

    
    private void setup() {
         setOpaque(false);
   
   actual = new JButton ( new ImageIcon((SiegePanel.getPeca().getScaledInstance(SiegePanel.getPeca().getWidth()/2,SiegePanel.getPeca().getHeight() ,Image.SCALE_SMOOTH))));
        actual.setBorder(BorderFactory.createEmptyBorder());
                actual.setContentAreaFilled(false);  
                
           escolhe1 = new JRadioButton ("Discurso");
                escolhe1.addActionListener(new escolhe1Listener());
        escolhe2 = new JRadioButton ("Supplie");
        escolhe2.addActionListener(new escolhe2Listener());
     
        grupo = new ButtonGroup();
                grupo.clearSelection();
                grupo.add(escolhe1);
                grupo.add(escolhe2);
    }

    private void setLayout() {
           setLayout( new BoxLayout(this,BoxLayout.X_AXIS));
        
        setLayout(new GridBagLayout());
          setPreferredSize(new Dimension(1920,1080));
           Box box = Box.createHorizontalBox();
    
    box.add(actual);
    box.add(Box.createHorizontalGlue());
    
    
    add(box) ;
    add(escolhe1);
    add(escolhe2);
  
    }
    
    @Override
    public void update(Observable o, Object arg) {
   int num  = game.getGameData().getCartaActua().getSerie();
      
        setVisible(game.getState() instanceof AwaitSelectionRallyTroops);
      
        if(game.getState() instanceof AwaitSelectionRallyTroops)
        {
            actual.setEnabled(true);
            ImageIcon  icon = new ImageIcon(SiegePanel.getCardparadesenhar(num).getScaledInstance(325,329 ,Image.SCALE_DEFAULT));
                actual.setIcon(icon);
                   actual.setBorder(BorderFactory.createEmptyBorder());
                actual.setContentAreaFilled(false);
        }
        else
            actual.setEnabled(false);
        
        
     
         repaint();
           grupo.clearSelection();
    }

    
    
   class escolhe1Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
           game.RallySelect("");
        }

       
    }
   
 class escolhe2Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
              game.RallySelect("supplies");
           
        }

       
    }
  class escolhe3Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            game.BoilingSelect("tower");
        }

       
    }
      @Override
    protected void paintComponent(Graphics g)
    {
           Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();
 
        super.paintComponent(g);
    
           g.drawImage(SiegePanel.getFundo(), 1,1,getWidth()-2,getHeight()-2, this);
 
  
      g.drawImage(SiegePanel.getIntro(),sizee.width/2-SiegePanel.getIntro().getWidth()/5, 10,SiegePanel.getIntro().getWidth()/3,SiegePanel.getIntro().getHeight()/3,this);
 
            
 g.drawImage(SiegePanel.getForte(),1150 , 750, SiegePanel.getForte().getWidth()/4,SiegePanel.getForte().getHeight()/4, this);
      
 g.drawImage(SiegePanel.getEnemy(),1000 , 750, SiegePanel.getEnemy().getWidth()/4,SiegePanel.getEnemy().getHeight()/4, this);
       //  g.drawImage(SiegePanel.getForte(), 90,15 , 500,500,this);
  
//FORTE//
//nao esquecer para baixo distancia de 38/ 27!!!!
 
 
 switch(game.getGameData().getForte().getPosicao("wall"))
 {
     case 0:         g.drawImage(SiegePanel.getPeca(),1193,861, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);   
      
         break;
     case 1: g.drawImage(SiegePanel.getPeca(),1155,834, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);   
      
         break;
     case 2:  g.drawImage(SiegePanel.getPeca(),1155,807, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 3:g.drawImage(SiegePanel.getPeca(),1155,780, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 4: g.drawImage(SiegePanel.getPeca(),1155,753, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         
         
 }
  switch(game.getGameData().getForte().getPosicao("morale"))
 {
     case 0: g.drawImage(SiegePanel.getPeca(),1193,861, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
                 
         break;
     case 1: g.drawImage(SiegePanel.getPeca(),1193,834, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         
         break;
     case 2: g.drawImage(SiegePanel.getPeca(),1193,807, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         
          break;
     case 3:g.drawImage(SiegePanel.getPeca(),1193,780, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         
          
         break;
     case 4:g.drawImage(SiegePanel.getPeca(),1193,753, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         
 }
   switch(game.getGameData().getForte().getPosicao("supplie"))
 {
     case 0:        
         g.drawImage(SiegePanel.getPeca(),1193,861, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         break;
     case 1:
         g.drawImage(SiegePanel.getPeca(),1231,834, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         break;
     case 2:
         g.drawImage(SiegePanel.getPeca(),1231,807, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         break;
     case 3:
         g.drawImage(SiegePanel.getPeca(),1231,780, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
         break;
     case 4 :   g.drawImage(SiegePanel.getPeca(),1231,753, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
      
         
         break ;

   }
 

   
   switch(game.getGameData().getForte().getPosicao("tunnel"))
 {
     case 0:        
         g.drawImage(SiegePanel.getPeca(),1152,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 1:
         g.drawImage(SiegePanel.getPeca(),1168,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 2:g.drawImage(SiegePanel.getPeca(),1184,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 3:g.drawImage(SiegePanel.getPeca(),1205,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
        
 }
   
       
   switch(game.getGameData().getEnemy().getPosicao("wall"))
 {
       
       
     case 0:  g.drawImage(SiegePanel.getPeca(),1047,747, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
 
         break;
     case 1:
           g.drawImage(SiegePanel.getPeca(),1008,774, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
 
         break;
     case 2:
           g.drawImage(SiegePanel.getPeca(),1008,801, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
 
         break;
     case 3:
           g.drawImage(SiegePanel.getPeca(),1008,828, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
 
         break;
     case 4:  g.drawImage(SiegePanel.getPeca(),1008,855, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);
 
         break;
      
 }
    switch(game.getGameData().getEnemy().getPosicao("door"))
 {
     case 0:
          g.drawImage(SiegePanel.getPeca(),1047,747, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 1:
          g.drawImage(SiegePanel.getPeca(),1047,774, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 2:
          g.drawImage(SiegePanel.getPeca(),1047,801, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 3:
          g.drawImage(SiegePanel.getPeca(),1047,828, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 4: g.drawImage(SiegePanel.getPeca(),1047,855, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
      
 }
 
   switch(game.getGameData().getEnemy().getPosicao("tower"))
 {
     case 0:    
          g.drawImage(SiegePanel.getPeca(),1047,747, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 1:
          g.drawImage(SiegePanel.getPeca(),1086,774, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 2:
          g.drawImage(SiegePanel.getPeca(),1086,801, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 3:
          g.drawImage(SiegePanel.getPeca(),1086,828, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 4:
          g.drawImage(SiegePanel.getPeca(),1086,855, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
      
 }
     switch(game.getGameData().getEnemy().getPosicao("trebuchet"))
 {
     case 0:
         break;
     case 1:g.drawImage(SiegePanel.getPeca(),1008,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 2:g.drawImage(SiegePanel.getPeca(),1047,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

         break;
     case 3:g.drawImage(SiegePanel.getPeca(),1086,890, SiegePanel.getPeca().getWidth()/3, SiegePanel.getPeca().getHeight()/3, this);

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
 
}
}
