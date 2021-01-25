/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.ObservableGame;
import Data.States.AwaitAction;
import com.sun.java.accessibility.util.AWTEventMonitor;
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
public class AwaitActionPanel extends JPanel implements Observer {

    private ObservableGame game;
    private JButton actual;
    private JRadioButton escolhe1;
    private JRadioButton escolhe2;
    private JRadioButton escolhe3;
    private JRadioButton escolhe4;
    private JRadioButton escolhe5;
    private JRadioButton escolhe6;
    private JRadioButton escolhe7;
    private JRadioButton escolhe8;
    private JRadioButton escolhe9;
    private JButton dado;
    private ButtonGroup grupo;
    private JRadioButton escolheB;
    private JButton action1;
   

    public AwaitActionPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setup();
        setLayout();

        update(game, this);
        //    System.out.println("gvvhbh" + game.getState());

    }

    private void setup() {
        setOpaque(false);

        actual = new JButton(new ImageIcon((SiegePanel.getPeca().getScaledInstance(SiegePanel.getPeca().getWidth() / 2, SiegePanel.getPeca().getHeight(), Image.SCALE_SMOOTH))));
        actual.setBorder(BorderFactory.createEmptyBorder());
        actual.setContentAreaFilled(false);
        dado = new JButton(new ImageIcon((SiegePanel.getDado1().getScaledInstance(SiegePanel.getDado1().getWidth(), SiegePanel.getDado1().getHeight(), Image.SCALE_SMOOTH))));
        dado.setBorder(BorderFactory.createEmptyBorder());
        dado.setContentAreaFilled(false);
        action1 = new JButton(new ImageIcon((SiegePanel.getNum1().getScaledInstance(SiegePanel.getDado1().getWidth(), SiegePanel.getDado1().getHeight(), Image.SCALE_SMOOTH))));
        action1.setBorder(BorderFactory.createEmptyBorder());
        action1.setContentAreaFilled(false);
        escolhe1 = new JRadioButton("ArchersAttack");
        escolhe2 = new JRadioButton("BoillingWatterAttack");
        escolhe3 = new JRadioButton("Close Combat Attack ");
        escolhe4 = new JRadioButton("Coupure");
        escolhe5 = new JRadioButton("Rally Troops ");
        escolhe6 = new JRadioButton("Tunnel Movement");
        escolhe7 = new JRadioButton("Supply Raid ");
        escolhe8 = new JRadioButton("Sabotage");
        escolhe9 = new JRadioButton("Extra");
        escolheB = new JRadioButton("Retirar Carta");
        escolhe1.addActionListener(new escolhe1Listener());
        escolhe2.addActionListener(new escolhe2Listener());
        escolhe3.addActionListener(new escolhe3Listener());
        escolhe4.addActionListener(new escolhe4Listener());
        escolhe5.addActionListener(new escolhe5Listener());
        escolhe6.addActionListener(new escolhe6Listener());
        escolhe7.addActionListener(new escolhe7Listener());
        escolhe8.addActionListener(new escolhe8Listener());
        escolhe9.addActionListener(new escolhe9Listener());
        escolheB.addActionListener(new escolheBListener());

        grupo = new ButtonGroup();
        grupo.clearSelection();

        grupo.add(escolhe1);
        grupo.add(escolhe2);
        grupo.add(escolhe3);
        grupo.add(escolhe4);
        grupo.add(escolhe5);
        grupo.add(escolhe6);
        grupo.add(escolhe7);
        grupo.add(escolhe8);
        grupo.add(escolhe9);
        grupo.add(escolheB);
    }

    private void setLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1920, 1080));

        Box box = Box.createHorizontalBox();
        box.add(action1);
        
        box.add(actual);
        box.add(dado);
        box.add(Box.createHorizontalGlue());

        add(box);
        add(escolhe1);
        add(escolhe2);
        add(escolhe3);
        add(escolhe4);
        add(escolhe5);
        add(escolhe6);
        add(escolhe7);
        add(escolhe8);
        add(escolhe9);
        add(escolheB);
    }

    @Override
    public void update(Observable o, Object arg) {

        int num = game.getGameData().getCartaActua().getSerie();

        setVisible(game.getState() instanceof AwaitAction);

        if (game.getState() instanceof AwaitAction) {
            ImageIcon icon = new ImageIcon(SiegePanel.getCardparadesenhar(num).getScaledInstance(325, 329, Image.SCALE_DEFAULT));

            actual.setIcon(icon);
            actual.setBorder(BorderFactory.createEmptyBorder());
            actual.setContentAreaFilled(false);
        }

        escolheMenuaApresentar();

        grupo.clearSelection();
        repaint();
    }

    private void escolheMenuaApresentar() {

        //System.out.println(" " + game.getGameData().getEnemy().getCloseCombat());
        game.getGameData().validamovimento();//

        if (game.getGameData().getForte().getPosicao("tunnel") != 3) {

            escolhe6.setVisible(true);
            escolhe7.setVisible(false);
            escolhe8.setVisible(false);
        } else {
            escolhe6.setVisible(true);
            escolhe7.setVisible(true);
            escolhe8.setVisible(true);
        }

//                System.out.println("(game.getGameData().getEnemy().isCirculoWall()\n"+
//                (game.getGameData().getEnemy().isCirculoWall())+
//                        "\n(game.getGameData().getEnemy().isCirculoDoor()\n"+
//                
//                        (game.getGameData().getEnemy().isCirculoDoor())+
//                "\n(game.getGameData().getEnemy().isCirculoTower()\n"+
//                                (game.getGameData().getEnemy().isCirculoTower()));
        if (((game.getGameData().getEnemy().isCirculoWall() == true)
                || (game.getGameData().getEnemy().isCirculoDoor() == true)
                || (game.getGameData().getEnemy().isCirculoTower() == true)) && (game.getGameData().isBoiling() == true)) {
            escolhe2.setVisible(true);
        } else {
            escolhe2.setVisible(false);
        }

        if (game.getGameData().getForte().getPosicao("wall") == 4) {
            escolhe4.setVisible(false);
        } else {
            escolhe4.setVisible(true);

        }

        if (game.getGameData().getForte().getPosicao("morale") == 4) {
            escolhe5.setVisible(false);
        } else {
            escolhe5.setVisible(true);
        }

        if (game.getGameData().isPontoextra() == false) {
            escolhe9.setEnabled(false);
        }
        escolhe1.setVisible(true);
        if (game.getGameData().getEnemy().getCloseCombat() >= 1) {
            System.out.println("ESTOU NO CLOSECOMBAT");
            escolhe3.setVisible(true);
            escolhe1.setVisible(false);
            escolhe2.setVisible(false);
            escolhe4.setVisible(false);
            escolhe5.setVisible(false);
            escolhe6.setVisible(false);
            escolhe7.setVisible(false);
            escolhe8.setVisible(false);
            escolhe9.setVisible(false);

        } else {
            escolhe3.setVisible(false);

        }

    }

    class escolhe1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.Archers();

        }

    }

    class escolheBListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            game.showCard();

        }

    }

    class escolhe2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.Boiling();
            //System.out.println("--->" +game.getState());
        }

    }

    class escolhe3Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.CloseCombat();

        }

    }

    class escolhe4Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.Coupure();

        }

    }

    class escolhe5Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.RallyTroops();

        }

    }

    class escolhe6Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.TunnelMovement();

        }

    }

    class escolhe7Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.SupplyRaid();

        }

    }

    class escolhe8Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.Sabotage();

        }

    }

    class escolhe9Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.Extra();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();

        super.paintComponent(g);
        g.drawImage(SiegePanel.getFundo(), 1, 1, getWidth() - 2, getHeight() - 2, this);

        g.drawImage(SiegePanel.getIntro(), sizee.width / 2 - SiegePanel.getIntro().getWidth() / 5, 10, SiegePanel.getIntro().getWidth() / 3, SiegePanel.getIntro().getHeight() / 3, this);

        g.drawImage(SiegePanel.getForte(), 1150, 750, SiegePanel.getForte().getWidth() / 4, SiegePanel.getForte().getHeight() / 4, this);

        g.drawImage(SiegePanel.getEnemy(), 1000, 750, SiegePanel.getEnemy().getWidth() / 4, SiegePanel.getEnemy().getHeight() / 4, this);
        //  g.drawImage(SiegePanel.getForte(), 90,15 , 500,500,this);
        //System.out.println("Points " + game.getGameData().getPlayer().getActionPointAllowance());

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
switch (game.getGameData().getPlayer().getActionPointAllowance()) {
            case 1://920
       ImageIcon icon1 = new ImageIcon(SiegePanel.getNum1().getScaledInstance(SiegePanel.getDado1().getWidth(), SiegePanel.getDado1().getHeight(), Image.SCALE_DEFAULT));
                action1.setIcon(icon1);
                action1.setBorder(BorderFactory.createEmptyBorder());
                action1.setContentAreaFilled(false);
                break;
            case 2:
              ImageIcon icon2 = new ImageIcon(SiegePanel.getNum2().getScaledInstance(SiegePanel.getDado1().getWidth(), SiegePanel.getDado1().getHeight(), Image.SCALE_DEFAULT));
                action1.setIcon(icon2);
                action1.setBorder(BorderFactory.createEmptyBorder());
                action1.setContentAreaFilled(false);
                break;
            case 3:
            ImageIcon icon3 = new ImageIcon(SiegePanel.getNum3().getScaledInstance(SiegePanel.getDado1().getWidth(), SiegePanel.getDado1().getHeight(), Image.SCALE_DEFAULT));
                action1.setIcon(icon3);
                action1.setBorder(BorderFactory.createEmptyBorder());
                action1.setContentAreaFilled(false);
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

        switch (game.getGameData().getForte().getPosicao("raid")) {
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

            default:
                ImageIcon icon7 = new ImageIcon(SiegePanel.getDado6().getScaledInstance(SiegePanel.getDado6().getWidth(), SiegePanel.getDado6().getHeight(), Image.SCALE_DEFAULT));
                dado.setIcon(icon7);
                dado.setBorder(BorderFactory.createEmptyBorder());
                dado.setContentAreaFilled(false);
                break;

        }

        //ENEMY//
//trabuco 
    }

}
