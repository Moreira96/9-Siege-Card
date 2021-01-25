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
public class AwaitSelectionBoilingWaterAttack extends StateAdapter{
    
    public AwaitSelectionBoilingWaterAttack(GameData gamedata)
    {
        super(gamedata);
    }
    
  @Override
public IStates goBoilingWaterAttack(String opcao)
{
    
    //getGameData().validamovimento();
    if( getGameData().isBoiling()==true)
    {
        

      int dado = getGameData().getNumero();
        System.out.println(opcao + " " + dado);
          System.out.println(opcao + " " + dado + "\t"+ getGameData().getDrmBoiling());
      dado+= getGameData().getDrmBoiling();

      if( getGameData().getEnemy().getPosicao(opcao)!=1)
      {
          System.out.println("Nao ha ninguem");
          return new AwaitAction(getGameData());
      }
      
      if(opcao.toLowerCase().equals("wall"))
      {
           dado+= getGameData().getAttackWall();
          if( getGameData().getEnemy().getWallnumber() == dado )
          { 
              System.out.println("Boost a entrar");
                dado+=1;
          }   
        
          if(getGameData().getEnemy().getWallnumber() <  dado)
          {
          //    setAttack(2);
             
              getGameData().getEnemy().move(+2, opcao);
              //return true;
          }
      }
      else
      if(opcao.toLowerCase().equals("door"))
      {
           dado+= getGameData().getAttackDoori();
          if( getGameData().getEnemy().getDoornumber() == dado )
          {
              System.out.println("Boost a entrar");
                dado+=1;
          }
          if(getGameData().getEnemy().getDoornumber() <  dado)
          {
              //setAttack(2);
              System.out.println("Boost a entrar");
              getGameData().getEnemy().move(+2, opcao);
              //return true;
          }
      }
      else
      if(opcao.toLowerCase().equals("tower"))
      {
          //System.out.println("estou aqui"+ getGameData().getEnemy().getTowernumber());
           dado+= getGameData().getAttackTower();
          if( getGameData().getEnemy().getTowernumber() == dado )
          {
                dado+=1;
           System.out.println("Boost a entrar"+  dado);
             
          }
          if(getGameData().getEnemy().getTowernumber() <  dado)
          {             

              //setAttack(2);
              getGameData().getEnemy().move(+2, opcao);
              //System.out.println("Boost a entrar" + dado);
              //return true;
          }
      }

       if(dado == 1)
          {
              System.out.println("daodoo");
              getGameData().getForte().move(-1,"morale");
              //return true ; 
              
          }
       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
       getGameData().getPlayer().setActionPointAllowance(aux);
       

   getGameData().setBoiling(false);
    }
    
       if( getGameData().getPlayer().getActionPointAllowance()<= 0)
  {
      System.out.println("ABREEE NOVA CARTA");
      return new AwaitDrawCard(getGameData());
      
  }
    
    

    
    getGameData().VerificaCombateArea();
      getGameData().verificaCirculo();
    return new AwaitAction(getGameData());
}

   
}
