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
public class AwaitSelectionArchersTrack  extends StateAdapter{
    
    public AwaitSelectionArchersTrack(GameData gamedata)
    {
        super(gamedata);
    }
    
    @Override
public IStates goArchersAttack(String opcao)
{
   // getGameData().validamovimento();
     int dado = getGameData().getNumero();
      System.out.println(opcao + "ola " + dado + "\t"+ getGameData().getDrmArcher());
     //validar dado para nao exceder 6!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      
      dado+= getGameData().getDrmArcher();
      
      System.out.println(opcao + " " + dado);

        if (opcao.toLowerCase().equals("wall")) 
        {
           
      dado+= getGameData().getAttackWall();
        System.out.println(opcao + " " + dado + getGameData().getAttackWall());
            if (dado > getGameData().getEnemy().getWallnumber()) {    // precisa de Recerber a Força do ataque inimigo

                //setAttack(1);
             getGameData().getEnemy().move(+1 , opcao);   
                System.out.println("wall recua  1");
//Move uma casa para trás;
               // return true;
            }
           

        } 
        
        else
            if (opcao.toLowerCase().equals("door"))
            {
                 System.out.println("getGameData().getAttackdoor()"+ " " + dado+ getGameData().getAttackDoori());
          
                  dado+= getGameData().getAttackDoori();
                
                  if (dado > getGameData().getEnemy().getDoornumber()) {
               // setAttack(1);
                
                
                getGameData().getEnemy().move(+1, opcao);
                System.out.println("door recua 1 ");
                //return true;
            }

        } else
                if (opcao.toLowerCase().equals("tower")) 
                {
                     dado+= getGameData().getAttackTower();
            if (dado > getGameData().getEnemy().getTowernumber()) {
                //setAttack(1);
            
                getGameData().getEnemy().move(+1 +getGameData().getDrmArcher(), opcao);
                System.out.println("torre recua 1 ");
             //   return true;
            }

        } 
        
           int aux = getGameData().getPlayer().getActionPointAllowance()-1;
       getGameData().getPlayer().setActionPointAllowance(aux);
    
 System.out.println("Forte " + getGameData().getForte().toString());
       System.out.println("Enemy " + getGameData().getEnemy().toString()); 
        //return false;
       System.out.println("points player :\t "+ getGameData().getPlayer().getActionPointAllowance());
   
//         System.out.println("forte \n" + getGameData().getForte().toString());
//      System.out.println("Enemy \n" + getGameData().getEnemy().toString()); 
//        
       if( getGameData().getPlayer().getActionPointAllowance()<= 0)
  {
      
      return new AwaitDrawCard(getGameData());
      
  }
    

    
    getGameData().VerificaCombateArea();
      getGameData().verificaCirculo();
        
    return new AwaitAction(getGameData());
}
    
}
