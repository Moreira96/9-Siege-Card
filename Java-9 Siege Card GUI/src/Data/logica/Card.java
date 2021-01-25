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
    
public class Card implements Serializable{
  //  private final int MAX = 3;
    private boolean show = false; 
    private  int serie = 0 ;
 
//    private int dia ;
    private int actionpointallowance=0 ;
    private boolean ladders = false;
    private boolean ram = false;
    private boolean tower = false;
   private boolean sword = false;
   private boolean none =false;
   private boolean trebuchet =false; 
   
   private String s;
    public Card ()
    {
    //    dia = 1;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.serie;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.serie != other.serie) {
            return false;
        }
        return true;
    }
   
     
    
    public void setactionPoint(int num)
    {
        actionpointallowance= num;
    }
    public int getactionPoint()
    {
        return actionpointallowance;
    }
    public boolean getShow()
    {
        return show;
    }
    
    public int getSerie()
    {
        return serie;
    }
    public void setSerie(int num)
    {
        serie = num ; 
    }
    public void aconteceEventodiaum(GameData b )
    {
        
    }
    public void aconteceEventodiadois(GameData b )
    {
        
    }
    public void aconteceEventodiatres(GameData b )
    {
        
    }
    public void aplicaFigurasCartaum(GameData b)
    {
        
    }
    public void aplicaFigurasCartadois(GameData b)
    {
        
    }
    public void aplicaFigurasCartatres(GameData b)
    {
        
    }
    public boolean isLadders() {
        return ladders;
    }

    public void setLadders(boolean ladders) {
        this.ladders = ladders;
    }

    public boolean isRam() {
        return ram;
    }

    public void setRam(boolean ram) {
        this.ram = ram;
    }

    public boolean isTower() {
        return tower;
    }

    public void setTower(boolean tower) {
        this.tower = tower;
    }

    public boolean isSword() {
        return sword;
    }

    public void setSword(boolean sword) {
        this.sword = sword;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public int getActionpointallowance() {
        return actionpointallowance;
    }

    public void setActionpointallowance(int actionpointallowance) {
        this.actionpointallowance = actionpointallowance;
    }

    public boolean isNone() {
        return none;
    }

    public void setNone(boolean none) {
        this.none = none;
    }

    public boolean isTrebuchet() {
        return trebuchet;
    }

    public void setTrebuchet(boolean trebuchet) {
        this.trebuchet = trebuchet;
    }

    public String toString(){
        return null;
        
    }
}


