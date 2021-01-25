/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.States.AwaitBeginning;
import Data.States.IStates;
import Data.logica.Card;
import Data.logica.GameData;
import java.io.Serializable;

import java.util.List;

public class Game  implements Serializable {
    
    private GameData gameData;
    private IStates state;
    
    public Game(){
        gameData = new GameData();
        state = new AwaitBeginning(gameData);
    }
  
    public GameData getDataGame(){
        return gameData;
    }
    
    public void setGameData(){
        this.gameData = gameData;
    }
    
    public IStates getState(){
        return state;
    }
    
    public void setState(IStates state){
        this.state = state;
    }
    
    public void endOfGame(){
        setState(getState().gameOver());
    }
    public void victory()
    {
        setState(getState().victory());
    }
    public void baralhaCartas(){
        gameData.baralha();
    }
    
    public void showCard(){
       setState(getState().drawCard());
    }
    
    public List<Card> getCards(){
        return gameData.getCards();
    }
    
    public void startGame(){
        setState(getState().comeca());
    }
    
   
    public void Archers(){
        setState(getState().selectArcherAttack());
    }
    
    public void Boiling(){
        setState(getState().selectBoilingWaterAttack());
    }
    
    public void CloseCombat(){
        setState(getState().goCloseCombat());
    }
    
    public void Coupure(){
        setState(getState().goCoupure());
    }
    
    public void RallyTroops(){
        setState(getState().selectRallyTroops());
    }
    
    public void TunnelMovement(){
        setState(getState().selectTunnelMovement());
    }
    
    public void SupplyRaid(){
        setState(getState().goSupplyRaid());
    }
    
    public void Sabotage(){
        setState(getState().goSabotage());
    }
    
    public void Extra(){
        setState(getState().selectExtra());
    }
    
    public void ArchersSelect(String where){
        if("wall".equals(where))
            setState(getState().goArchersAttack("wall"));
        if("tower".equals(where))
            setState(getState().goArchersAttack("tower"));
        if("door".equals(where))
            setState(getState().goArchersAttack("door"));
    }
    
    public void BoilingSelect(String where){
        if("wall".equals(where))
            setState(getState().goBoilingWaterAttack("wall"));
        if("tower".equals(where))
            setState(getState().goBoilingWaterAttack("tower"));
        if("door".equals(where))
            setState(getState().goBoilingWaterAttack("door"));
    }
    
    public void RallySelect(String where){
        if("".equals(where))
            setState(getState().goRallyTroops(""));
        if("supplies".equals(where))
            setState(getState().goRallyTroops("supplies"));
    }
    
    public void TunnelSelect(String where){
        if("free".equals(where))
            setState(getState().goTunnelMovement("free"));
        if("fast".equals(where))
            setState(getState().goTunnelMovement("fast"));
        if("automatic".equals(where))
            setState(getState().goTunnelMovement("automatic"));
    }
    
    public void SelectExtra(String where){
        if("morale".equals(where))
            setState(getState().goExtraEscolhe("morale"));
        if("supplie".equals(where))
            setState(getState().goExtraEscolhe("supplie"));
        
    }
    
    public boolean getVictory(){
       return getDataGame().isVictory();
    }
    
    public boolean getDefeat(){
        return getDataGame().isEndgame();
    }
    
}

