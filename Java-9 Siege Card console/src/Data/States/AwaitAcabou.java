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
    
    public AwaitAcabou(GameData gamedata)
    {
        super(gamedata);
    }
    
    @Override
    public IStates gameOver ()
    {
          System.out.println("Forteeee " + getGameData().getForte().toString());
      System.out.println("Enemyyy " + getGameData().getEnemy().toString()); 
       
        setGameData(new GameData());
     return new AwaitBeginning(getGameData());
    }
    @Override
    public IStates victory () 
    {
      //  System.out.println("Os dias acabaram ,vitoria");
         setGameData(new GameData());
     return new AwaitBeginning(getGameData());
    }


    }

