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
public class AwaitSelectionRallyTroops extends StateAdapter{
    
    
    public AwaitSelectionRallyTroops(GameData gamedata)
    {
        super(gamedata);
    }

    
      @Override

public IStates goRallyTroops(String opcao)
{
    
        int dado= getGameData().getNumero() ;

         
      //   getGameData().validamovimento();
        //Opcçao para usar suplies(-1) para dar (1+) DMR
        if(opcao.equals("supplies") && getGameData().isExtra() == true){           
            getGameData().getForte().move(-1, "supplie");
            getGameData().setDrmRally(+1);
            getGameData().setExtra(false);
        }
        
        dado+=getGameData().getDrmRally();
        System.out.println("\ndado "+ dado);
        
        if(dado >= 5)
        {
            getGameData().getForte().move(+1, "morale");
        }
    
    
    
        int aux = getGameData().getPlayer().getActionPointAllowance()-1;
        getGameData().getPlayer().setActionPointAllowance(aux);
        System.out.println("Player :: " +getGameData().getPlayer().getActionPointAllowance());
    
        getGameData().setDRM(0);

    if( getGameData().getPlayer().getActionPointAllowance()<= 0)
  {
      
      return new AwaitDrawCard(getGameData());
      
  }
    
getGameData().VerificaCombateArea();
      getGameData().verificaCirculo();
    
    
    return new AwaitAction(getGameData());
}
        

}
