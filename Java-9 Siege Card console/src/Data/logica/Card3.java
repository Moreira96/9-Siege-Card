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
public class Card3 extends Card implements Serializable{
    
    //private int DMR = 0;
    
    public Card3(){
       setSerie(3);
    }
    
    @Override
    public void aconteceEventodiaum(GameData b){
    
        b.setPlayerPoint(2); //setactionPoint(2);
        b.getEnemy().move(-1, "suplie");
    }
    
    @Override
    public void aconteceEventodiadois(GameData b){
   
        //Only raid and sabotage actions allowed this turn
      b.setPlayerPoint(2);//setactionPoint(2);

    }
    
    @Override
    public void aconteceEventodiatres(GameData b){
        
        //Perguntar 
        //DMR = 2;
       
        boolean flag= false;
        
        flag = b.verificaCirculo();
          
        if(flag==true)
        {
            if(b.getEnemy().isCirculoWall()==true)
            {

                b.setAttackWall(+2);
            }
            if(b.getEnemy().isCirculoDoor()==true)
            {
                b.setAttackDoori(+2);
            }
            if(b.getEnemy().isCirculoTower()==true)
            {
                b.setAttackTower(+2);
            }
                
        }
        
        
          
        b.setPlayerPoint(2);//setactionPoint(2);
        //Circle Spaces
    }
    @Override
      public void aplicaFigurasCartaum(GameData b)
    {
         setLadders(true);
       
    }
    @Override
    public void aplicaFigurasCartadois(GameData b)
    {
        setNone(true);
        
    }

 
    @Override
    public void aplicaFigurasCartatres(GameData b)
    {
         setLadders(true);
        setRam(true);
    }
    
    @Override
     public String toString(){
          String s  = " ";

        //System.out.println();
        s+="\n\tDay 1 \n\n\tSuplies Spoiled:\n Reduce Suplies by 1\n"
                + "\n\tDay 2\n\n\tBad Weather:\n Only Raid and Sabotage Actions allowed this turn\n"
                + "\n\tDay 3\n\n\tBoiling Oil:\n +2 to attacks on enemy units in circle spaces\n";

        //System.out.println();
        return s;
    }
}
