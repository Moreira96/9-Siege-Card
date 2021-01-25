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
public class AwaitSelectionSupplyRaid extends StateAdapter{
    
   public AwaitSelectionSupplyRaid(GameData gamedata)
   {
       super(gamedata);
   }
   
   
   
   @Override
public IStates goSupplyRaid()
{
    
    if(getGameData().getForte().getPosicao("tunnel")==3)
    {
        
//        if(
//             (getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//             (getGameData().getCartaActua().getSerie()==2 && (getGameData().getDia()==2 ||getGameData().getDia()==3) )
//             
//             )
//     {
//         getGameData().setDrmSupply(1);
//     }
   //     getGameData().validamovimento();
        int total= 0; 
        
            total  =getGameData().getNumero();
            System.out.println( "dado " + total + "\t"+ getGameData().getDrmSupply());
            total += getGameData().getDrmSupply();
            
           
            if(total >= 3)
            {
                System.out.println("DADO3");
                getGameData().getForte().move(+1, "raid");
               
               // getGameData().getForte().move(+1, "raid");
 
            }
            if(total>=6)
            {
                System.out.println("DADO6");
            getGameData().getForte().move(+1, "raid");
                
            }
            total =1;
            System.out.println("Forte " + getGameData().getForte().toString());
       System.out.println("Enemy " + getGameData().getEnemy().toString());
            if(total== 1)
            {
                getGameData().getForte().move(0, "tunnel");
                getGameData().getForte().move(0,"raid");
            }
            System.out.println("Posiçao do raid:" + getGameData().getForte().getPosicao("raid"));
        getGameData().getPlayer().setActionPointAllowance(-1);
    }
     
    
    
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
