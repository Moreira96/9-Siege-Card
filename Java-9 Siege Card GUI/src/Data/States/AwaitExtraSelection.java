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

    public AwaitExtraSelection(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates goExtraEscolhe(String where) {

        
      
       if( where.toLowerCase().equals("morale"))
         
        {
            getGameData().getForte().move(-1, "morale");
            getGameData().getPlayer().adicionaActionPointAllowance(+1);
            getGameData().setPontoextra(false);
        }
else
            
            if(where.toLowerCase().equals("supplie"))
          //   if (getGameData().isPontoextra() == true)
            {
           
                getGameData().getForte().move(-1, "supplie");
            getGameData().getPlayer().adicionaActionPointAllowance(+1);
            getGameData().setPontoextra(false);
        }
     
       return new AwaitAction(getGameData());
    }


}
