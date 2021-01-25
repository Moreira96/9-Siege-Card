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
public class AwaitSelectionTunnelMovement extends StateAdapter {
    
    public AwaitSelectionTunnelMovement(GameData gamedata)
    {
        super(gamedata);
    }
    
    @Override
 public  IStates goTunnelMovement(String opcao)
 
 
 {
   //  getGameData().validamovimento();
       System.out.println("ACTION POINTS"+getGameData().getPlayer().getActionPointAllowance() );
        boolean flag=false;
      if( getGameData().getForte().isCastle()==true)
      {
          getGameData().getForte().move(+1, "tunnel");
          int aux = getGameData().getPlayer().getActionPointAllowance()-1;
       getGameData().getPlayer().setActionPointAllowance(aux);
       
      if(opcao.equals("free"))
      {
          getGameData().getForte().move(+1, "tunnel");
      }
       else
          if(opcao.equals("fast"))
          {
              getGameData().getForte().move(+3, "tunnel");
             aux = getGameData().getPlayer().getActionPointAllowance()-1;
       getGameData().getPlayer().setActionPointAllowance(aux);
       
          }
       
      }
  
//        if(opcao.equals("free")){
//           flag =  getGameData().getForte().move(+1, "tunnel");    //Apenas um Movimento por Turno(Elixir Grátis)
//          //  return true;
//        }else
//        if(opcao.equals("fast")){
//            
//            do{
//                flag = getGameData().getForte().move(+1, "tunnel");
//            }while(flag != false);
//            // Custo 1 de Elixir
//         //   return true;
//        }else
//            if(opcao.equals("automatic"))   //Fim de Turno Free Elixir
//            {
//                do{
//                    if(getGameData().getForte().getTunnel() == 3)   //Se Tiver no Enemy Line é Capturado
//                      //  return true;
//                flag = getGameData().getForte().move(-1, "tunnel");  //Recua para o Forte
//            }while(flag != false);
//            } 
        
    //    return false; 
      
 
     if( getGameData().getPlayer().getActionPointAllowance()<= 0)
  {
      
      return new AwaitDrawCard(getGameData());
      
  }
    
getGameData().VerificaCombateArea();
      getGameData().verificaCirculo();
    
    return new AwaitAction(getGameData());
}       

}
