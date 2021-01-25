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
public class AwaitExtraSelection extends StateAdapter {
    
    public AwaitExtraSelection (GameData gamedata)
    {
        super(gamedata);
    }
    
 @Override
    public IStates goExtraMorale()
    {
        System.out.println("getforça "+ getGameData().getEnemy().getWallnumber());
       if(getGameData().isPontoextra() == true)
        {
    getGameData().getForte().move(-1, "morale");
    getGameData().getPlayer().adicionaActionPointAllowance(+1);
       getGameData().setPontoextra(false);
   
        }
      
            return new AwaitAction(getGameData());
    }
   @Override
    public IStates goExtraSupplie()
    {
if(getGameData().isPontoextra() == true)
        {
    getGameData().getForte().move(-1, "supplie");
    getGameData().getPlayer().adicionaActionPointAllowance(+1);
       getGameData().setPontoextra(false);
   
    } 
return new AwaitAction(getGameData());
    }
}