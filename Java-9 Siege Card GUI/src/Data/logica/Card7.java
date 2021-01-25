/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.logica;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Card7 extends Card implements Serializable{
    public Card7()
    {
        setSerie(7);
     
    }
    
    
    @Override
       public void aconteceEventodiaum(GameData b )
    {
        b.setPlayerPoint(2);
        b.setAttackDoori(1);
    }
    @Override
    public void aconteceEventodiadois(GameData b )
    {
      b.setPlayerPoint(2);
      b.setAttackTower(+1);
    }
    @Override
    public void aconteceEventodiatres(GameData b )
    {
       b.setPlayerPoint(3);
        b.setAttackDoori(+1);
        b.setAttackWall(+1);
        b.setDrmRally(+1);
        
    }
    @Override
      public void aplicaFigurasCartaum(GameData b)
    {
         setRam(true);
    }
    @Override
    public void aplicaFigurasCartadois(GameData b)
    {
          setTower(true);
    }
    @Override
    public void aplicaFigurasCartatres(GameData b)
    {
        setRam(true);
        setTower(true);
        setLadders(true);
    }
    
    @Override
     public String toString(){
          String s  = " ";

        //System.out.println();
        s+="\n\tDay 1 \n\n\tDetermined Enemy:\n -1 to Attacks on the Battering Ram\n"
                + "\n\tDay 2\n\n\tIron Shields:\n -1 to attacks on the Siege Tower\n"
                + "\n\tDay 3\n\n\tFaith:\n +1 to attacks on the Battering Ram, Ladders\n and Moral action\n";

        //System.out.println();
        return s;
    }
}
