/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.logica;

import java.io.Serializable;

/**
 *
 * @author morei
 */
public class Card5 extends Card  implements Serializable{
    
    Card5()
    {
        setSerie(5);
    }
    
    
       @Override
       public void aconteceEventodiaum(GameData b )
    {
b.setPlayerPoint(3);
        b.setAttackDoori(+1);
        b.setAttackWall(+1);
        b.setAttackTower(+1);
    }
       @Override
    public void aconteceEventodiadois(GameData b )
    {
       b.setPlayerPoint(2);
        if(b.getEnemy().getPosicao("tower")==4)
        {
            
            b.getEnemy().setSiegeTower(false);
            b.getEnemy().move(0, "tower");
        }
        
        
    }
       @Override
    public void aconteceEventodiatres(GameData b )
    {
        if(b.getEnemy().getPosicao("trebuchet")!=3)
        {
         b.getEnemy().move(+1, "trebuchet");
        }
        b.setPlayerPoint(2);
       
    }
    @Override
      public void aplicaFigurasCartaum(GameData b)
    {
         setRam(true);
    }
    @Override
    public void aplicaFigurasCartadois(GameData b)
    {
         setRam(true);
        setLadders(true);
    }
    @Override
    public void aplicaFigurasCartatres(GameData b)
    {
         setLadders(true);
    }
    
    @Override
     public String toString(){
          String s  = " ";

        //System.out.println();
        s+="\n\tDay 1 \n\n\tVolley of Arrows:\n +1 to all attacks\n"
                + "\n\tDay 2\n\n\tCollapsed:\n Siege Tower removed from game if on starting space\n"
                + "\n\tDay 3\n\n\tRepaired Trebuchet:\n add +1 Trebuchet (max 3)\n +1 to Coupure Action\n";

        //System.out.println();
        return s;
    }
}
