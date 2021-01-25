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
public class  AwaitSelectionCloseCombat extends StateAdapter{
    
    public AwaitSelectionCloseCombat(GameData gamedata)
    {
        super(gamedata);
    }



@Override
public IStates goCloseCombat()
{
    
       int dado = getGameData().getNumero();
        int total  =0 ;
        String aux1= " "; 
        String aux2=" ";
        String aux3 = " "; 
        int flag1= 0 ;
        int flag2= 0 ;
        int flag3= 0 ;
        int dado2=0;
       // getGameData().validamovimento();
    //    System.out.println("\n asdnjk " + dado +"\n");
        
      System.out.println( " Dado " + dado + "\t"+ "DRMCLOSE "+getGameData().getDrmClose());
      dado+= getGameData().getDrmClose();
      
      System.out.println("Wall Bonus : " +getGameData().getAttackWall()+ "\n" + 
          "Door Bonus : " +getGameData().getAttackDoori()+ "\n" +
              "Tower Bonus : " +getGameData().getAttackTower()+ "\n");
        
         System.out.println("Wall Number : " +getGameData().getEnemy().getWallnumber()+ "\n" + 
          "Door Number : " +getGameData().getEnemy().getDoornumber()+ "\n" +
              "Tower Number : " +getGameData().getEnemy().getTowernumber()+ "\n");
        
        if(getGameData().getEnemy().getPosicao("wall") == 0)  
        {
            total++;
            aux1 = "wall";
            flag1= 1;
        }
        if( getGameData().getEnemy().getPosicao("door") == 0)
        {
            total++;
            aux2 = "door";
            flag2= 1 ;
        }
        if( getGameData().getEnemy().getPosicao("tower")==0)
        {
            total++;
            aux3 = "tower";
            flag3=1;
        }
        System.out.println("total -------> " + total );
   
        if( total == 0 )
        {
            return new AwaitAction(getGameData());
        }
        
 //HUGO TEM QUE SE QUESTIONAR ESTE RETUNR NULL
    System.out.println("DADO " + dado );
            if( aux1.equals("wall") )
        { 
        dado2 = dado;
             dado2+= getGameData().getAttackWall();
            if(getGameData().getEnemy().getWallnumber() < dado)
            {
                getGameData().getEnemy().move(+1, aux1);
                System.out.println("Ganhou no close combat");
                flag1= 0 ; 
            }
        }
     
         if( aux2.equals("door"))
        { 
            dado2 = dado;
             dado2+= getGameData().getAttackDoori();
                if(getGameData().getEnemy().getDoornumber() < dado)
            {
                getGameData().getEnemy().move(+1, aux2);
                System.out.println("Ganhou no close combat");
                flag2 = 0; 
            }
        
        }        
       
          if(aux2.equals("tower"))
         { 
             dado2 = dado;
              dado2 += getGameData().getAttackTower();
         if(getGameData().getEnemy().getTowernumber() < dado)
            {
                getGameData().getEnemy().move(+1, aux3);
                System.out.println("Ganhou no close combat");
                flag3= 0 ;
            }
         }
 
            
            
           
            
            
            
      if ( flag1 ==1)
      {          dado2  =dado;
           dado2+= getGameData().getAttackWall();
          if(getGameData().getEnemy().getWallnumber() < dado)
            {
                getGameData().getEnemy().move(+1, aux1);
                System.out.println("Ganhou no close combat");
                flag1= 0 ; 
               // return true; 
            }   
          
          
      }
        
            if ( flag2 ==1)
      {          
       if(getGameData().getEnemy().getDoornumber() < dado)
            {
                dado2 = dado; 
                 dado2+= getGameData().getAttackDoori();
                getGameData().getEnemy().move(+1, aux2);
                System.out.println("Ganhou no close combat");
                flag2 = 0; 
                //return true;
            }
          
          
      }
            if ( flag3 ==1)
               
      {           dado2 = dado ; 
          dado2 += getGameData().getAttackTower();
                 if(getGameData().getEnemy().getTowernumber() < dado)
            {
                 dado+= getGameData().getAttackWall();
                getGameData().getEnemy().move(+1, aux3);
                System.out.println("Ganhou no close combat");
                flag3= 0 ;
                //return true  ;
            }          
          
      }
  System.out.println("DADOoo " + dado  + "dado2 " + dado2);
      if( dado == 1)
      {
          getGameData().getForte().move(-1, "morale");
      }

 //     System.out.println(" ---->"+ getGameData().getAttackWall()+ " "+ getGameData().getAttackDoori()+ " " +getGameData().getAttackTower());
    
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
    
