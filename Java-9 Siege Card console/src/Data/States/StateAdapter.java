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

public class  StateAdapter implements IStates {
    
    private GameData gamedata;

    public StateAdapter(GameData gamedata)
    {
        this.gamedata= gamedata;
    }
    
    public GameData getGameData()
    {
        return gamedata;
    }
    public void setGameData( GameData gamedata)
    {
        this.gamedata= gamedata;
    }
    @Override
    public IStates comeca() {
     return this;    
    }


    @Override
    public IStates drawCard() {
    return this;   
    }

 

    @Override
    public IStates gameOver() {
    return this;   
    }

    @Override
    public IStates goArchersAttack(String opcao) {
    return this;
    }

    /**
     *
     * @return
     */
    @Override
    public IStates goBoilingWaterAttack(String opcao) {
    
        return this;
    }

  

    @Override
    public IStates goCoupure() {
     return this;
    }

    @Override
    public IStates goRallyTroops(String opcao) {
    
     return this;}

    @Override
    public IStates goTunnelMovement(String opcao) {
        
     return this;}

 
    @Override
    public IStates endofDay() {
   return this;    }

  
    @Override
    public IStates goSabotage() {
        return this;
    }

    @Override
    public IStates goSupplyRaid() {
  return this ; 
    }

    @Override
    public IStates goCloseCombat() {
   return this ;
    }

    @Override
    public IStates selectArcherAttack() {
    return this;}

    @Override
    public IStates selectBoilingWaterAttack() {
    return this;
    }

    @Override
    public IStates selectCloseCombat() {
   return this ;  }

    @Override
    public IStates selectCoupure() {
   return this ;  }

    @Override
    public IStates selectRallyTroops() {
 return this ;    }

    @Override
    public IStates selectTunnelMovement() {
   return this ;   }

    @Override
    public IStates selectSabotage() {
return this ;    }

    @Override
    public IStates selectSupplyRaid() {
 return this ;    }

    @Override
    public IStates selectExtra() {
    return this;}

    @Override
    public IStates goExtraMorale() {
    return this;}

    @Override
    public IStates goExtraSupplie() {
       return this;}

    @Override
    public IStates endTurn() {
    return this ;  }

    @Override
    public IStates victory() {
   return this;
    }

 
    
    
    
    
    
   
}
