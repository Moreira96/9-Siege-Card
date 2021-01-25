/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.logica;
import Data.logica.GameData;
import java.io.Serializable;
/**
 *
 * @author Asus
 */
public class Card2 extends Card implements Serializable{
    
    Card2()
    {
        setSerie(2);
    }
    
    
    
       @Override
       public void aconteceEventodiaum(GameData b)
    {//ILLNESS
     //REDUCES MORALE BY 1
     //REDUCES MORALE BY 1
    
     
        b.setPlayerPoint(2);

        b.getForte().move(-1,"morale");
        b.getForte().move(-1,"supplie");
        
    }
       @Override
    public void aconteceEventodiadois(GameData b )
    {//Guards Distracted

        b.setPlayerPoint(2);
    b.setDrmSabotage(1);
        b.setDrmRally(1);
    }
       @Override
    public void aconteceEventodiatres(GameData b )
    {//TREBUCHET ATTACK
        
        int total= 0 ;  
    
        //actpointallowance = 2;
        b.setPlayerPoint(1);//setactionPoint(1);
        if( (b.getEnemy().getPosicao("trebuchet") == 3))
        {
            b.getForte().move(-2,"wall");
        }
        else
             if( (b.getEnemy().getPosicao("trebuchet") == 2))
        {
            b.getForte().move(-1,"wall");
        }
             else{
                 total = b.getNumero();
                
         if( (b.getEnemy().getPosicao("trebuchet") == 0)&& total >= 4)
        {
            b.getForte().move(-1,"wall");
        }
             }
    }
    
    
    @Override
   public void aplicaFigurasCartaum(GameData b)
    {
       setTower(true);
    }
    @Override
    public void aplicaFigurasCartadois(GameData b)
    {
        setSword(true);
    }
    @Override
    public void aplicaFigurasCartatres(GameData b)
    {
        setTrebuchet(true);
    }
    
    @Override
     public String toString(){
          String s  = " ";

        //System.out.println();
        s+="\n\tDay 1 \n\n\tIlness:\n Reduce Morale by 1\n Reduce Supplies by 1\n"
                + "\n\tDay 2\n\n\tGuards Distracted:\n +1 to Sabotage Action\n +1 to Morale Action\n"
                + "\n\tDay 3\n\n\tTrebuchet Attack:\n 3 Trebuchet - 2 Damage to Wall\n"
                + " 2 Trebuchet - 1 Damage to Wall\n 1 Trebuchet - 1 Damage to Wall on D6 roll of 6 or 5 or 4\n";

        //System.out.println();
        return s;
    }
 
}
