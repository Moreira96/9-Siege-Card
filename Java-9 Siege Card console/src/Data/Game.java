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


/**
 *
 * @author morei
 */
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
       setState(getState().drawCard());;
    }
    
    public List<Card> getCards(){
        return gameData.getCards();
    }
    
    public void startGame(){
        setState(getState().comeca());
    }
    public void extras()
    {
     //   setState(getState().selectExtra(num))
    }
//    public boolean isCardsEmpty(){
//        return gameData.isCardsEmpty();
//    }
//    
//    public int getActionPlayer(){
//        return gameData.getActionPlayer();
//    }
//    
//    public void setActionPlayer(int op){
//        gameData.setActionPlayer;
//    }
    
}
