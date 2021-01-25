/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.States;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public interface IStates extends Serializable {
    IStates comeca();
    
    IStates drawCard();
   
    //IStates playAction();
//IStates interagePlayer();
    //IStates enemyMovementPhae();
    IStates selectExtra();
    IStates goExtraMorale();
    IStates goExtraSupplie();
    
    
    
    
    IStates selectArcherAttack();
    IStates goArchersAttack(String opcao);
    
    IStates selectBoilingWaterAttack();
    IStates goBoilingWaterAttack(String opcao);
   
    IStates selectCloseCombat();
    IStates goCloseCombat();
  
    IStates selectCoupure();
    IStates goCoupure();
    
    IStates selectRallyTroops();
    IStates goRallyTroops(String opcao);
   // IStates goCloseCombat(String opcao);
    IStates selectTunnelMovement();
    IStates goTunnelMovement(String opcao);
  // IStates onde();
  //  IStates goRallyTroops();
    IStates selectSabotage();
    IStates goSabotage();
  
    IStates selectSupplyRaid();
    IStates goSupplyRaid();
   
    IStates endTurn();
    IStates gameOver();
    IStates endofDay();
    IStates victory();
// IStates baralha();
}
