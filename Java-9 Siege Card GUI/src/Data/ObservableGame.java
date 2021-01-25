/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.States.IStates;
import Data.logica.Card;
import Data.logica.GameData;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Asus
 */
public class ObservableGame  extends Observable{
    
    private Game game;
    
    
    public ObservableGame(Game game)
    {
        this.game =game ;
    }

    public GameData getGameData()
    {
        return game.getDataGame();
    } 
    public Game getGame()
    {
        return game ;
    }
    public void setGameData(Game game)
    {
        this.game = game;
        
        setChanged();
        notifyObservers();           
    }

    public IStates getState()
    {
        return game.getState();
        
    }
    
    public void setState(IStates state){
        this.game.setState(state);
        setChanged();
        notifyObservers();
    }
    
    public void endOfGame(){
        game.endOfGame();
        setChanged();
        notifyObservers();
    }
    
    public void victory(){
        game.victory();;
        
        setChanged();
        notifyObservers();
    }
    
    public void showCard(){
        game.showCard();;
        
        setChanged();
        notifyObservers();
    }
     
    public List<Card> getCards()
    {
        return game.getCards();
    }

    public void  start()
    {
        game.startGame();
        
        setChanged();
        notifyObservers();
    }

    public void Archers() {
        game.Archers();
        setChanged();
        notifyObservers();
    }

    public void Boiling() {
        game.Boiling();
        setChanged();
        notifyObservers();
    }

    public void CloseCombat() {
        game.CloseCombat();
        setChanged();
        notifyObservers();
    }

    public void Coupure() {
        game.Coupure();
        setChanged();
        notifyObservers();
    }

    public void RallyTroops() {
        game.RallyTroops();
        setChanged();
        notifyObservers();
    }

    public void TunnelMovement() {
        game.TunnelMovement();
        setChanged();
        notifyObservers();
    }

    public void SupplyRaid() {
        game.SupplyRaid();
        setChanged();
        notifyObservers();
    }

    public void Sabotage() {
        game.Sabotage();
        setChanged();
        notifyObservers();
    }

    public void Extra() {
        game.Extra();
        setChanged();
        notifyObservers();
    }

    public void ArchersSelect(String where) {
        game.ArchersSelect(where);
        setChanged();
        notifyObservers();
    }

    public void BoilingSelect(String where) {
        game.BoilingSelect(where);
        setChanged();
        notifyObservers();
    }

    public void RallySelect(String where) {
        game.RallySelect(where);
        setChanged();
        notifyObservers();
    }

    public void TunnelSelect(String where) {
        game.TunnelSelect(where);
        setChanged();
        notifyObservers();
    }
    public void ExtraSelection(String where)
    {
        game.SelectExtra(where);
        setChanged();
        notifyObservers();
    }
    public boolean getVictory(){
       return game.getDataGame().isVictory();
    }
    
    public boolean getDefeat(){
        return game.getDataGame().isEndgame();
    }
}
