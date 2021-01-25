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
public class AwaitDrawCard  extends StateAdapter {
    
    public AwaitDrawCard(GameData gamedata)
    {
        super(gamedata);
    }
    
    
    @Override
   public IStates drawCard()
   {
      getGameData().victoryorlosscheckpoint();
      if( getGameData().isEndgame() == true)
            return new AwaitAcabou(getGameData());
      else
          if(getGameData().isVictory() == true)
              return new AwaitAcabou (getGameData());
    getGameData().fimDia();
    getGameData().fimTurno();
    
    
    
    /// começa A nova Ronda!
    getGameData().EnemyLineCheck("");
     
    
    
        
    
  //  getGameData().baralha();
     getGameData().setcartaActual((getGameData().getCards().get(5)));
       System.out.println("Tamanho Inicial jogadas : "+  getGameData().getJogadas().size());
     
      System.out.println("Tamanho  inicial cartas: "+  getGameData().getCards().size());
     getGameData().adicionaCartaUsada(getGameData().getCartaActua());
     getGameData().remove(getGameData().getCartaActua());
      System.out.println("Tamanho  final jogadas: "+  getGameData().getJogadas().size());
   System.out.println("Tamanho  final cartas: "+  getGameData().getCards().size());
      //   System.out.println("vou listar" + getGameData().getCartaActua() + "\n" +" tamanho " + getGameData().getJogadas().size());
    //getGameData().listaCard(getGameData().getJogadas());
    
    //getGameData().fimDia();
   getGameData().aplicaFigurasCarta(getGameData().getCartaActua());
     if(getGameData().getCartaActua().isTrebuchet()!=true)
     {
      
        if(getGameData().getCartaActua().isSword()==true)
         {
             
             getGameData().slowestUnitMovement();
         }
         else
             getGameData().regularMovement();
     }
     else
     {
         System.out.println("Nao da para usar movimento");
     }
       getGameData().validamovimento();
         getGameData().aplicaEventoCarta(getGameData().getCartaActua());
  
    getGameData().verificaCirculo();
     getGameData().VerificaCombateArea();
       System.out.println("Perdi? " + getGameData().getEndGame());
     if(getGameData().getEndGame()==true)
     {
     return new AwaitAcabou(getGameData());
     }
       System.out.println("\n dia " + getGameData().getDia());
      System.out.println("\n serie da carta :: " + getGameData().getCartaActua().getSerie());
      
    
       
       
    
       
       
       return new AwaitAction(getGameData());
   }
   
 
   
   
  
}
