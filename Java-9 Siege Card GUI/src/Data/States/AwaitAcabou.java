/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.States;

import Data.logica.GameData;

/**
 *
 * @author Asus
 */
public class AwaitAcabou extends StateAdapter {

    public AwaitAcabou(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates gameOver() {

        setGameData(new GameData());
        return new AwaitBeginning(getGameData());
    }

    @Override
    public IStates victory() {
        setGameData(new GameData());
        return new AwaitBeginning(getGameData());
    }

}

