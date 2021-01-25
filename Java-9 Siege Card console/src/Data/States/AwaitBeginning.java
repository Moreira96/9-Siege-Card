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
public class AwaitBeginning extends StateAdapter {
    
    public AwaitBeginning(GameData gamedata) 
    {
        super(gamedata);
    }
     @Override
    public IStates comeca()
    {
        
       
      //  getGameData().inicializaCartas();
        getGameData().setDia(1);
       
       // getGameData().getEnemy().move(-3,"tower");
                
         // getGameData().verificaCirculo();
   //System.out.println("Tamanho  1: "+  getGameData().getCards().size());
        
    //System.out.println("Forte " + getGameData().getForte().toString());
    //System.out.println("Enemy " + getGameData().getEnemy().toString()); 
//        
//getGameData().getForte().move(+3,"tunnel");
       //System.out.println("getPosicao "+ getGameData().getForte().getPosicao("tunnel"));
        return new AwaitDrawCard(getGameData()); 
    }
    
}
