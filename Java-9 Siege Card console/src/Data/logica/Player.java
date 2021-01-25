/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Player implements Serializable {
    
    
    private String name ; 
    private boolean win; 
//    private List <Actions> accoes = new ArrayList<Actions>();
    private int ActionPointAllowance=0 ; 
    //private
    
    Player(String nome)
    {
        this.name = name ; 
        win  = false ; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getActionPointAllowance() {
        return ActionPointAllowance;
    }

    public void setActionPointAllowance(int ActionPointAllowance) {
        this.ActionPointAllowance = ActionPointAllowance;
    }
    public void adicionaActionPointAllowance(int num)
    {
       
        this.ActionPointAllowance+= num ; 
   
   //         this.ActionPointAllowance = 0  ; 
    }


    
    
    
    
    
}
