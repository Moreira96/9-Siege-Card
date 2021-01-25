/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.States;

import Data.logica.GameData;
import GuiStates.SiegePanel;

/**
 *
 * @author Asus
 */
public class AwaitBeginning extends StateAdapter {

    public AwaitBeginning(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates comeca() {

        getGameData().setDia(1);
        
   
        
        return new AwaitDrawCard(getGameData());
    }
    @Override
    public IStates gameOver()
    {
        return new AwaitAcabou(getGameData());
    }
}
