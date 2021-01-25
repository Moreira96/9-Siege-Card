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
public class AwaitSelectionSabotage extends StateAdapter {
    
    
    public AwaitSelectionSabotage (GameData gamedata)
    {
        super(gamedata);
    }
    @Override 
        
        
public IStates  goSabotage()
{
  //  getGameData().validamovimento();
    System.out.println("gosabotage");
    
    int total = getGameData().getNumero() ; 
    if(getGameData().getForte().getPosicao("tunnel")==3)
    {
       
//        
//    if(
//             (getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//           ||  (getGameData().getCartaActua().getSerie()==6 &&( getGameData().getDia()==2 ||getGameData().getDia()==1))
//             
//             )
//     {
//         getGameData().setDrmSabotage(1);
//     }
         System.out.println("dado "+ total   + "\t"+ getGameData().getDrmSabotage()+"total = ");
        total += getGameData().getDrmSabotage()  ; 
        System.out.println("total " + total);
        if(total  >= 5)
        {
             getGameData().getEnemy().move(-1, "trebuchet");
                    
        }
        if(total == 1)
        {
            if(getGameData().getForte().getPosicao("raid")>0)
            {
                getGameData().getForte().move(0, "raid");
            }
            getGameData().getForte().move(0, "tunnel");
            
        }
        //pode usar sabotage quando carrega supplies;
    
    }
    
    //getGameData().setDRM(0);
       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
       getGameData().getPlayer().setActionPointAllowance(aux);
      
    if( getGameData().getPlayer().getActionPointAllowance()<= 0)
  {
      
      return new AwaitDrawCard(getGameData());
      
  }
    
getGameData().VerificaCombateArea();
      getGameData().verificaCirculo();
    
    return new AwaitAction(getGameData());
}
}
