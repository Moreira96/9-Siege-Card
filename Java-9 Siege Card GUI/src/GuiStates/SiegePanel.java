/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class SiegePanel extends JPanel implements Observer {

    private ObservableGame observablegame;
    private int serieactual;

    public SiegePanel(ObservableGame obgame) {

        this.observablegame = obgame;
        this.observablegame.addObserver(this);

        setup();
        setupLayout();
        update(obgame, null);

    }
    static private BufferedImage intro = null;
    static private BufferedImage card = null;
    static private BufferedImage card1 = null;
    static private BufferedImage card2 = null;
    static private BufferedImage card3 = null;
    static private BufferedImage card4 = null;
    static private BufferedImage card5 = null;
    static private BufferedImage card6 = null;
    static private BufferedImage card7 = null;
    static private BufferedImage forte = null;
    static private BufferedImage enemy = null;
    static private BufferedImage fundo = null;
    static private BufferedImage peca = null;
    static private BufferedImage temp = null;

    static private BufferedImage dado1 = null;
    static private BufferedImage dado2 = null;
    static private BufferedImage dado3 = null;
    static private BufferedImage dado4 = null;
    static private BufferedImage dado5 = null;
    static private BufferedImage dado6 = null;
    static private BufferedImage num1 = null;
    static private BufferedImage num3 = null;
    static private BufferedImage num2 = null;

    private AwaitBeginningPanel awaitbeginningpanel;
    private AwaitDrawCardPanel awaitdrawcardpanel;
    private AwaitActionPanel awaitactionpanel;
    private AwaitArchersLocationPanel awaitarcherslocationpanel;
    private AwaitBoilingWaterLocationPanel awaitboilingwaterlocationpanel;
    private AwaitRallyTroopsPanel awaitrallytroopspanel;
    private AwaitTunnelMovementPanel awaittunnelmovementpanel;
    private AwaitExtraSelectionPanel awaitextraselectionpanel;
    private AwaitGameOverPanel awaitacaboupanel;
    static {
        try {

            intro = ImageIO.read(Resources.getResourceFile("image/intro.png"));
            card = ImageIO.read(Resources.getResourceFile("image/Card.png"));
            card1 = ImageIO.read(Resources.getResourceFile("image/Card1.png"));
            card2 = ImageIO.read(Resources.getResourceFile("image/Card2.png"));
            card3 = ImageIO.read(Resources.getResourceFile("image/Card3.png"));
            card4 = ImageIO.read(Resources.getResourceFile("image/Card4.png"));
            card5 = ImageIO.read(Resources.getResourceFile("image/Card5.png"));
            card6 = ImageIO.read(Resources.getResourceFile("image/Card6.png"));
            card7 = ImageIO.read(Resources.getResourceFile("image/Card7.png"));
            forte = ImageIO.read(Resources.getResourceFile("image/Forte.png"));
            enemy = ImageIO.read(Resources.getResourceFile("image/Enemy.png"));
            fundo = ImageIO.read(Resources.getResourceFile("image/fundo.jpg"));
            peca = ImageIO.read(Resources.getResourceFile("image/peca.png"));
            dado1 = ImageIO.read(Resources.getResourceFile("image/1.png"));
            dado2 = ImageIO.read(Resources.getResourceFile("image/2.png"));
            dado3 = ImageIO.read(Resources.getResourceFile("image/3.png"));
            dado4 = ImageIO.read(Resources.getResourceFile("image/4.png"));
            dado5 = ImageIO.read(Resources.getResourceFile("image/5.png"));
            dado6 = ImageIO.read(Resources.getResourceFile("image/6.png"));
            num1 = ImageIO.read(Resources.getResourceFile("image/1.jpg"));
            num2 = ImageIO.read(Resources.getResourceFile("image/2.jpg"));
            num3 = ImageIO.read(Resources.getResourceFile("image/3.jpg"));
            

        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }

    public static BufferedImage getPeca() {
        return peca;
    }

    public static BufferedImage getDado1() {
        return dado1;
    }

    public static BufferedImage getDado2() {
        return dado2;
    }

    public static BufferedImage getDado3() {
        return dado3;
    }

    public static BufferedImage getDado4() {
        return dado4;
    }

    public static BufferedImage getDado5() {
        return dado5;
    }

    public static BufferedImage getDado6() {
        return dado6;
    }
    
    public static BufferedImage getNum1(){
        return num1;
    }
    public static BufferedImage getNum2(){
        return num2;
    }
    public static BufferedImage getNum3(){
        return num3;
    }

    public static BufferedImage getCardparadesenhar(int num) {
        switch (num) {
            case 1:
                temp = card1;
                break;
            case 2:
                temp = card2;
                break;
            case 3:
                temp = card3;
                break;
            case 4:
                temp = card4;
                break;
            case 5:
                temp = card5;
                break;
            case 6:
                temp = card6;
                break;
            case 7:
                temp = card7;
                break;

        }
        if (temp == null) {
            System.out.println("VAZIOOOOO");
        }
        return temp;

    }

    public static BufferedImage getIntro() {
        return intro;
    }

    public static BufferedImage getCard() {
        return card;
    }

    public static BufferedImage getCard1() {
        return card1;
    }

    public static BufferedImage getCard2() {
        return card2;
    }

    public static BufferedImage getCard3() {
        return card3;
    }

    public static BufferedImage getCard4() {
        return card4;
    }

    public static BufferedImage getCard5() {
        return card5;
    }

    public static BufferedImage getCard6() {
        return card6;
    }

    public static BufferedImage getCard7() {
        return card7;
    }

    public static BufferedImage getForte() {
        return forte;
    }

    public static BufferedImage getEnemy() {
        return enemy;
    }

    public static BufferedImage getFundo() {
        return fundo;
    }

    private void setup() {
        awaitbeginningpanel = new AwaitBeginningPanel(observablegame);
        awaitdrawcardpanel = new AwaitDrawCardPanel(observablegame);
        awaitactionpanel = new AwaitActionPanel(observablegame);
        awaitarcherslocationpanel = new AwaitArchersLocationPanel(observablegame);
        awaitboilingwaterlocationpanel = new AwaitBoilingWaterLocationPanel(observablegame);
        awaitrallytroopspanel = new AwaitRallyTroopsPanel(observablegame);
        awaittunnelmovementpanel = new AwaitTunnelMovementPanel(observablegame);
        awaitextraselectionpanel = new AwaitExtraSelectionPanel(observablegame);
        awaitacaboupanel  = new AwaitGameOverPanel(observablegame);
               
    }

    private void setupLayout() {
        JPanel center = new JPanel();
        center.add(awaitbeginningpanel);
        center.add(awaitdrawcardpanel);
        center.add(awaitactionpanel);
        center.add(awaitarcherslocationpanel);
        center.add(awaitboilingwaterlocationpanel);
        center.add(awaitrallytroopspanel);
        center.add(awaittunnelmovementpanel);
        center.add(awaitextraselectionpanel);
        center.add(awaitacaboupanel);
        add(center, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

}
