/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import Data.Game;
import java.io.IOException;
import Data.ObservableGame;
import GuiStates.SiegeFrame;

/**
 *
 * @author Asus
 */
public class TP {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    
   public static void main(String[] args) throws IOException, ClassNotFoundException {
//        TextUI textUI = new TextUI(new Game());
//        textUI.run();
        Game game = new Game();
       ObservableGame ob = new ObservableGame(game);     
        new  SiegeFrame(ob);
         
    }
    
}
