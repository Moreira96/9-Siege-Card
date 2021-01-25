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
public class Card4 extends Card implements Serializable {
    
       Card4()
    {
        setSerie(4);
    }
    
    
       @Override
       public void aconteceEventodiaum(GameData b)
    {
       b.setPlayerPoint(2);
        //+1 to raid and sabotage actions
        b.getForte().move(-1, "morale");
        
        
    }
       @Override
    public void aconteceEventodiadois(GameData b )
    {
b.setPlayerPoint(2);
        b.setAttackDoori(+1);
        
        
    }
       @Override
    public void aconteceEventodiatres(GameData b )
    {
        //Perguntar
     b.setPlayerPoint(3);
        b.setAttackTower(1);
    }
    
       @Override
      public void aplicaFigurasCartaum(GameData b)
    {
         setLadders(true);
        setTower(true);
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
           setTower(true);
    }
    
    @Override
     public String toString(){
          String s  = " ";

        //System.out.println();
        s+="\n\tDay 1 \n\n\tDeath of a Leader:\n Reduce Moral by 1\n"
                + "\n\tDay 2\n\n\tGate Fortified:\n +1 to attacks on the Battering Ram\n"
                + "\n\tDay 3\n\n\tFlaming Arrows:\n +1 to attacks on the Siege Engine\n";

        //System.out.println();
        return s;
    }
    
}
