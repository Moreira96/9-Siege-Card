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
public class Card1 extends Card implements Serializable {
    
    //private int actpointallowance=0;
    private int total = 0 ;
    public Card1( )
    {
      setSerie(1);
    }
    
  
    
    
    @Override
    public void aconteceEventodiaum(GameData b )
    {
     
        b.setPlayerPoint(3);//setactionPoint(3);
        if( (b.getEnemy().getPosicao("trebuchet") == 3))
        {

            b.getForte().move(-2,"wall");
        }
        else
             if( (b.getEnemy().getPosicao("trebuchet") == 2))
        {
             b.getForte().move(-1,"wall");
        }
        else
             {
                 total = b.getNumero();
         if( (b.getEnemy().getPosicao("trebuchet") == 0)&& ((total == 4)||(total == 5)|| total == 6))
        {
          b.getForte().move(-1,"wall");
        }
             }
              
        
    }
    @Override
    public void aconteceEventodiadois(GameData b )
    {
 
     //   b.getCartaActua().setSword(true);
        b.setPlayerPoint(2);//setactionPoint(2);
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
         if( (b.getEnemy().getPosicao("trebuchet") == 0)&& (total >=4))
        {
           b.getForte().move(-1,"wall");
        }
             }
    }
    
    @Override
    public void aconteceEventodiatres(GameData b )
    {
       
       //    actpointallowance = 1;
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
         if( (b.getEnemy().getPosicao("trebuchet") == 0)&& ((total >=4)))
        {
             b.getForte().move(-1,"wall");
        }
             }
    }
    
    
    
    @Override
        public void aplicaFigurasCartaum(GameData b)
    {
          setTrebuchet(true);
    }
    @Override
    public void aplicaFigurasCartadois(GameData b)
    {
         setTrebuchet(true);
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
        s+="\n\tTrebuchet Attack: \n\n\tDay 1\n 3 Trebuchet - 2 Damage to Wall\n 2 Trebuchet - 1 Damage to Wall\n 1 Trebuchet - 1 Damage to Wall on D6 roll of 6 or 5 or 4\n"
                + "\n\tDay 2\n 3 Trebuchet - 2 Damage to Wall\n 2 Trebuchet - 1 Damage to Wall\n 1 Trebuchet - 1 Damage to Wall on D6 roll of 6 or 5 or 4\n"
                + "\n\tDay 3\n 3 Trebuchet - 2 Damage to Wall\n 1"
                + "2 Trebuchet - 1 Damage to Wall\n 1 Trebuchet - 1 Damage to Wall on D6 roll of 6 or 5 or 4\n";

        //System.out.println();
        return s;
    }
    
    
}
