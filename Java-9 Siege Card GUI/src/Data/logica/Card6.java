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
public class Card6 extends Card implements Serializable{
    
    
    Card6()
    {
        setSerie(6);
    }
    
    
       @Override
       public void aconteceEventodiaum(GameData b)
    {
        //+1 to raid and sabotage actions
        b.setDrmSupply(1);
        b.setDrmSabotage(1);
        b.setPlayerPoint(3);
        
    }
       @Override
    public void aconteceEventodiadois(GameData b)
    {
        b.setDrmCoupure(1);
        b.setDrmSupply(1);
        b.setDrmSabotage(1);
        b.setPlayerPoint(3);
    }
       @Override
    public void aconteceEventodiatres(GameData b)
    {
        boolean flag = false;
        boolean flag2 = false; 
        flag = b.verificaCirculo();
b.setPlayerPoint(3);
   //     System.out.println("Circulo " +b.getEnemy().isCirculoDoor() );
        if(flag==true)
        {
            if(b.getEnemy().isCirculoWall()==true)
            {
                b.setAttackWall(+1);
            }
            if(b.getEnemy().isCirculoDoor()==true)
            {
                b.setAttackDoori(+1);
            }
            if(b.getEnemy().isCirculoTower()==true)
            {
                b.setAttackTower(+1);
            }
        }
   
        
        flag2= b.VerificaCombateArea();
       
        
        if( flag2==true)
        {
            if(b.getEnemy().isCombatWall()==true)
            {
                b.setAttackWall(+1);
            }
            if(b.getEnemy().isCombatDoor()==true)
            {
                b.setAttackDoori(+1);
            }
            if(b.getEnemy().isCombatTower()==true)
            {
                b.setAttackTower(+1);
            }
        }
      //    System.out.println("Close Combat " +b.getEnemy().isCombatDoor() );
    }
    @Override
      public void aplicaFigurasCartaum(GameData b)
    {
        setSword(true);
    }
    @Override
    public void aplicaFigurasCartadois(GameData b)
    {
        setLadders(true);
    }
    @Override
    public void aplicaFigurasCartatres(GameData b)
    {
        setRam((true));
        setTower(true);
    }
    
    @Override
     public String toString(){
          String s  = " ";

        //System.out.println();
        s+="\n\tDay 1 \n\n\tCover Of Darkness:\n +1 to Raid and Sabotage Actions\n"
                + "\n\tDay 2\n\n\tEnemy Fatigue:\n +1 to Coupure, Raid and Sabotage Ations\n"
                + "\n\tDay 3\n\n\tRally:\n +1 to attacks on Close Combat or Circle Spaces\n";

        //System.out.println();
        return s;
    }
}