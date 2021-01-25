/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import SiegeUI.TextUI;
import java.io.IOException;
import Data.Game;

/**
 *
 * @author Asus
 */
public class TP {

    /**
     * @param args the command line arguments
     */
    
   public static void main(String[] args) throws IOException, ClassNotFoundException {
        TextUI textUI = new TextUI(new Game());
        textUI.run();
    }
    
}
