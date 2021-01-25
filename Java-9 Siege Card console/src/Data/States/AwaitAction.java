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
public class AwaitAction extends StateAdapter {
    
    
    public AwaitAction(GameData gamedata)
    {
    super(gamedata);
    }
    
    @Override
    public IStates selectArcherAttack()
    {
        
           
       
        return new AwaitSelectionArchersTrack(getGameData());
    }
    @Override 
      public   IStates selectExtra()
    {
        return new AwaitExtraSelection(getGameData());
    }
    @Override
    public IStates selectBoilingWaterAttack()
    {
     return new AwaitSelectionBoilingWaterAttack(getGameData());   
    }
    @Override
    public IStates selectCloseCombat()
            {
                return new AwaitSelectionCloseCombat(getGameData());
            }
    
    
    @Override
public IStates goCoupure()
{
    
    
     // getGameData().validamovimento();
        int dado = getGameData().getNumero(); 
//    if(
//           //  (getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//             (getGameData().getCartaActua().getSerie()==6 && getGameData().getDia()==2)
//             
//             )
//     {
//         getGameData().setDrmCoupure(+1);
//     }
      System.out.println("dado" + dado + "\t"+ getGameData().getDrmCoupure());
      dado+= getGameData().getDrmCoupure();
         System.out.println( dado);
        if(dado>= 5)
        {
            getGameData().getForte().move(+1, "wall");
           // return true;
        }
       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
       getGameData().getPlayer().setActionPointAllowance(aux);
    
    
    if( getGameData().getPlayer().getActionPointAllowance()< 0)
  {
      
      return new AwaitDrawCard(getGameData());
      
  }
    
    
    
    
    getGameData().VerificaCombateArea();
      getGameData().verificaCirculo();
    return this ;// new AwaitAction(getGameData());
}
        
    //    return new AwaitSelectionCoupure(getGameData());
    
    
    @Override
    public IStates selectRallyTroops()
    {
        return new AwaitSelectionRallyTroops(getGameData());
    }
    
    
    @Override
    public IStates selectTunnelMovement()
    {
      
        return new AwaitSelectionTunnelMovement(getGameData());
    }
    
    @Override 
        public IStates selectSupplyRaid()
    {
        return new AwaitSelectionSupplyRaid(getGameData());
    }
        
        @Override
        public IStates selectSabotage()
        {
            return new AwaitSelectionSabotage(getGameData());
        }
        
        
}
    
//public IStates g
//@OverrideoArchersAttack(String opcao)
//{
//     int dado = getGameData().getNumero();
//      System.out.println(opcao + " " + dado + "\t"+ getGameData().getDRM());
//     //validar dado para nao exceder 6!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//      
//      dado+= getGameData().getDRM() ;
//      
//      System.out.println(opcao + " " + dado);
//
//        if (opcao.toLowerCase().equals("wall")) 
//        {
//            System.out.println("wallll");
//            if (dado > getGameData().getEnemy().getWallnumber()) {    // precisa de Recerber a Força do ataque inimigo
//
//                //setAttack(1);
//                int x=0;
//                if(getGameData().getEnemy().isCirculoWall()==true )
//                {
//                    x=1;
//                    getGameData().getEnemy().move(getGameData().getAttackWall(), opcao);
//                }
//                else
//                {
//                    x=2;
//                    getGameData().getEnemy().move(+1, opcao);
//               
//                }
//                    
//                
//                System.out.println("wall recua  "+ x);
////Move uma casa para trás;
//               // return true;
//            }
//           
//
//        } 
//        
//        else
//            if (opcao.toLowerCase().equals("door"))
//            {
//
//            if (dado > getGameData().getEnemy().getDoornumber()) {
//               // setAttack(1);
//                
//                if(getGameData().getEnemy().isCirculoDoor()==true )
//                {
//                    getGameData().getEnemy().move(getGameData().getAttackDoori(), opcao);
//                }
//                getGameData().getEnemy().move(+1, opcao);
//                System.out.println("door recua 1 ");
//                //return true;
//            }
//
//        } else
//                if (opcao.toLowerCase().equals("tower")) 
//                {
//            if (dado > getGameData().getEnemy().getTowernumber()) {
//                //setAttack(1);
//                if(getGameData().getEnemy().isCirculoTower()==true )
//                {
//                    getGameData().getEnemy().move(getGameData().getAttackTower(), opcao);
//                }
//                getGameData().getEnemy().move(+2, opcao);
//                System.out.println("torre recua 1 ");
//             //   return true;
//            }
//
//        } 
//        
//           int aux = getGameData().getPlayer().getActionPointAllowance()-1;
//       getGameData().getPlayer().setActionPointAllowance(aux);
//    
// System.out.println("forte \n" + getGameData().getForte().toString());
//       System.out.println("Enemy \n" + getGameData().getEnemy().toString()); 
//        //return false;
//       System.out.println("points player :\t "+ getGameData().getPlayer().getActionPointAllowance());
//   
//       
//       if( getGameData().getPlayer().getActionPointAllowance()<= 0)
//  {
//      
//      return new AwaitDrawCard(getGameData());
//      
//  }
//    
//    
//    else
//    
//    
//    return new AwaitAction(getGameData());
//}
//@Override
//public IStates goBoilingWaterAttack(String opcao)
//{
//    
//      int dado = getGameData().getNumero();
//        System.out.println(opcao + " " + dado);
//        
//      dado+= getGameData().getDRM();
//       System.out.println(opcao + " +" + dado);
//      if( getGameData().getEnemy().getPosicao(opcao)!=1)
//      {
//          System.out.println("Nao ha ninguem");
//          return null;
//      }
//      
//      if(opcao.toLowerCase().equals("wall"))
//      {
//           
//          if( getGameData().getEnemy().getWallnumber() == dado )
//          { 
//              System.out.println("Boost a entrar");
//                dado+=1;
//          }
//          if(getGameData().getEnemy().getWallnumber() <  dado)
//          {
//          //    setAttack(2);
//              getGameData().getEnemy().move(+2, opcao);
//              //return true;
//          }
//      }
//      else
//      if(opcao.toLowerCase().equals("door"))
//      {
//          
//          if( getGameData().getEnemy().getDoornumber() == dado )
//          {
//              System.out.println("Boost a entrar");
//                dado+=1;
//          }
//          if(getGameData().getEnemy().getDoornumber() <  dado)
//          {
//              //setAttack(2);
//              System.out.println("Boost a entrar");
//              getGameData().getEnemy().move(+2, opcao);
//              //return true;
//          }
//      }
//      else
//      if(opcao.toLowerCase().equals("tower"))
//      {
//          System.out.println("estou aqui"+ getGameData().getEnemy().getTowernumber());
//          
//          if( getGameData().getEnemy().getTowernumber() == dado )
//          {
//                dado+=1;
//           System.out.println("Boost a entrar"+  dado);
//             
//          }
//          if(getGameData().getEnemy().getTowernumber() <  dado)
//          {             
//
//              //setAttack(2);
//              getGameData().getEnemy().move(+2, opcao);
//              //System.out.println("Boost a entrar" + dado);
//              //return true;
//          }
//      }
//
//       if(dado == 1)
//          {
//              System.out.println("daodoo");
//              getGameData().getForte().move(-1,"morale");
//              //return true ; 
//              
//          }
//       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
//       getGameData().getPlayer().setActionPointAllowance(aux);
//       
//System.out.println("forte \n" + getGameData().getForte().toString());
//       System.out.println("Enemy \n" + getGameData().getEnemy().toString());
// System.out.println("points player :\t "+ getGameData().getPlayer().getActionPointAllowance());
//   
//       
//       if( getGameData().getPlayer().getActionPointAllowance()<= 0)
//  {
//      System.out.println("ABREEE NOVA CARTA");
//      return new AwaitDrawCard(getGameData());
//      
//  }
//    
//    
//    else
//    
//    
//    return new AwaitAction(getGameData());
//}


//@Override 
//        
//        
//public IStates  goSabotage()
//{
//    
//    
//    
//    int total = 0 ; 
//    if(getGameData().getForte().getPosicao("tunnel")==3)
//    {
//        total = getGameData().getNumero()  ; 
//    if(
//             (getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//           ||  (getGameData().getCartaActua().getSerie()==6 &&( getGameData().getDia()==2 ||getGameData().getDia()==1))
//             
//             )
//     {
//         getGameData().setDRM(1);
//     }
//        
//        
//        if(total  >= 5)
//        {
//             getGameData().getEnemy().move(-1, "trebuchets");
//                    
//        }
//        //pode usar sabotage quando carrega supplies;
//    
//    }
//    
//    getGameData().setDRM(0);
//       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
//       getGameData().getPlayer().setActionPointAllowance(aux);
//    
//    if( getGameData().getPlayer().getActionPointAllowance()<= 0)
//  {
//      
//      return new AwaitDrawCard(getGameData());
//      
//  }
//    
//    
//    else
//    
//    
//    return new AwaitAction(getGameData());
//}
//@Override
//
//public IStates goRallyTroops()
//{
//     if(
//             (getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//             //(getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//             
//             )
//     {
//         getGameData().setDRM(1);
//     }
//        int dado= getGameData().getNumero() ;
//       
//        System.out.println("dado "+ dado + "getDrm()"+ getGameData().getDRM());
//         dado+=getGameData().getDRM();
//           System.out.println("\ndado "+ dado);
//        //Opcçao para usar suplies(-1) para dar (1+) DMR
//        
//        if(dado >= 5)
//        {
//            getGameData().getForte().move(+1, "morale");
//            System.out.println("Moral aumenta 1\n");
//         //   return true;
//        }
//    
//    
//    
//       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
//       getGameData().getPlayer().setActionPointAllowance(aux);
//    System.out.println("Player :: " +getGameData().getPlayer().getActionPointAllowance());
//    
//             getGameData().setDRM(0);
//
//    if( getGameData().getPlayer().getActionPointAllowance()<= 0)
//  {
//      
//      return new AwaitDrawCard(getGameData());
//      
//  }
//    
//    
//    else
//    
//    
//    return new AwaitAction(getGameData());
//}
//        
//@Override
//public IStates goCoupure()
//{
//    
//    
//      
//        int dado = getGameData().getNumero(); 
//    if(
//           //  (getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//             (getGameData().getCartaActua().getSerie()==6 && getGameData().getDia()==2)
//             
//             )
//     {
//     }
//        System.out.println( dado);
//      dado+= getGameData().getDRM();
//         System.out.println( dado);
//        if(dado>= 5)
//        {
//            getGameData().getForte().move(+1, "wall");
//           // return true;
//        }
//       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
//       getGameData().getPlayer().setActionPointAllowance(aux);
//    
//    
//    if( getGameData().getPlayer().getActionPointAllowance()< 0)
//  {
//      
//      return new AwaitDrawCard(getGameData());
//      
//  }
//    
//    
//    else
//    
//    
//    return new AwaitAction(getGameData());
//}


//@Override
//public IStates goCloseCombat(String opcao)
//{
//    
//       int dado = getGameData().getNumero();
//        int total  =0 ;
//        String aux1= " "; 
//        String aux2=" ";
//        String aux3 = " "; 
//        int flag1= 0 ;
//        int flag2= 0 ;
//        int flag3= 0 ;
//        System.out.println("\n asdnjk " + dado +"\n");
//        
//         System.out.println(opcao + " " + dado);
//      dado+= getGameData().getDRM();
//        
//        if(getGameData().getEnemy().getPosicao("wall") == 0)  
//        {
//            total++;
//            aux1 = "wall";
//            flag1= 1;
//        }
//        if( getGameData().getEnemy().getPosicao("door") == 0)
//        {
//            total++;
//            aux2 = "door";
//            flag2= 1 ;
//        }
//        if( getGameData().getEnemy().getPosicao("tower")==0)
//        {
//            total++;
//            aux3 = "tower";
//            flag3=1;
//        }
//        System.out.println("total -------> " + total );
//   
//        if( total == 0 )
//        {
//            return null;
//        }
//        
// //HUGO TEM QUE SE QUESTIONAR ESTE RETUNR NULL
//    
//            if( aux1.equals("wall") )
//        {
//            if(getGameData().getEnemy().getWallnumber() < dado)
//            {
//                getGameData().getEnemy().move(+1, aux1);
//                System.out.println("Ganhou no close combat");
//                flag1= 0 ; 
//            }
//        }
//     
//         if( aux2.equals("door"))
//        { 
//                if(getGameData().getEnemy().getDoornumber() < dado)
//            {
//                getGameData().getEnemy().move(+1, aux2);
//                System.out.println("Ganhou no close combat");
//                flag2 = 0; 
//            }
//        
//        }        
//       
//          if(aux2.equals("tower"))
//         { 
//         if(getGameData().getEnemy().getTowernumber() < dado)
//            {
//                getGameData().getEnemy().move(+1, aux3);
//                System.out.println("Ganhou no close combat");
//                flag3= 0 ;
//            }
//         }
// 
//            
//            
//            
//            
//            
//            
//      if ( flag1 ==1)
//      {          
//          if(getGameData().getEnemy().getWallnumber() < dado)
//            {
//                getGameData().getEnemy().move(+1, aux1);
//                System.out.println("Ganhou no close combat");
//                flag1= 0 ; 
//               // return true; 
//            }   
//          
//          
//      }
//        
//            if ( flag2 ==1)
//      {          
//       if(getGameData().getEnemy().getDoornumber() < dado)
//            {
//                getGameData().getEnemy().move(+1, aux2);
//                System.out.println("Ganhou no close combat");
//                flag2 = 0; 
//                //return true;
//            }
//          
//          
//      }
//            if ( flag3 ==1)
//      {          
//                 if(getGameData().getEnemy().getTowernumber() < dado)
//            {
//                getGameData().getEnemy().move(+1, aux3);
//                System.out.println("Ganhou no close combat");
//                flag3= 0 ;
//                //return true  ;
//            }          
//          
//      }
//  
//      if( dado == 1)
//      {
//          getGameData().getForte().move(-1, "morale");
//      }
//
//       int aux = getGameData().getPlayer().getActionPointAllowance()-1;
//       getGameData().getPlayer().setActionPointAllowance(aux);
//    
//        if( getGameData().getPlayer().getActionPointAllowance()<= 0)
//  {
//      
//      return new AwaitDrawCard(getGameData());
//      
//  }
//    
//    
//    else
//    
//    
//    return new AwaitAction(getGameData());
//}
//    
    
    //return new AwaitAction(getGameData());
    

//@Override
//public IStates goSupplyRaid()
//{
//    
//    if(getGameData().getForte().getPosicao("tunnel")==3)
//    {
//        
//        if(
//         //    (getGameData().getCartaActua().getSerie()==2 && getGameData().getDia()==2)
//             (getGameData().getCartaActua().getSerie()==2 && (getGameData().getDia()==2 ||getGameData().getDia()==3) )
//             
//             )
//     {
//         getGameData().setDRM(1);
//     }
//        int total= 0; 
//        
//            total  = 4;//getGameData().getNumero();
//            System.out.println("dado "+ total );
//            if(total >= 3)
//            {
//                getGameData().getForte().move(+1, "raid");
//               
//                getGameData().getForte().move(+1, "raid");
// 
//            }
//            if(total==6)
//            {
//            getGameData().getForte().move(+1, "raid");
//                
//            }
//            
//        getGameData().getPlayer().setActionPointAllowance(-1);
//    }
//    
//    System.out.println("Posiçao do raid:" + getGameData().getForte().getPosicao("raid"));
//     System.out.println("forte \n" + getGameData().getForte().toString());
//       System.out.println("Enemy \n" + getGameData().getEnemy().toString()); 
// 
//          int aux = getGameData().getPlayer().getActionPointAllowance()-1;
//       getGameData().getPlayer().setActionPointAllowance(aux);
//    
//       
//       if( getGameData().getPlayer().getActionPointAllowance()<= 0)
//  {
//      
//      return new AwaitDrawCard(getGameData());
//      
//  }
//    
//    
//    else
//    
//    
//    return new AwaitAction(getGameData());
//}
//



