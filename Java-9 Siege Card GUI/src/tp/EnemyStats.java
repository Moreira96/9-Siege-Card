/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author morei
 */
package tp;

public class EnemyStats {
    
    private int[] wall = new int[5];
    private int[] door = new int[5];
    private int[] tower = new int[5];
    
    private int[] trebuchet = new int[3];
    private boolean combatArea = false;
    private boolean siegeTower = true;  //Existe um Evento que remove esta Torre
    
    public EnemyStats(){
        
        for(int i = 0; i < 5; i++){
            if(i == 4){
                wall[i] = 1;
                door[i] = 1;
                tower[i] = 1;
            }else
             wall[i] = 0;
             door[i] = 0;
             tower[i] = 0;
        }
        
         for(int i = 0; i < 3; i++){
            if(i == 2){
                trebuchet[i] = 1;
            }
            trebuchet[i] = 0;
         }
    }
    
    public int getWall(int i){
        return wall[i];
    }
    
    public int[] getDoor(){
        return door;
    }
    
    public int[] getTower(){
        return tower;
    }
    
    public int[] getTrebuchet(){
        return trebuchet;
    }
    
    public boolean getCombatArea(){
        return combatArea;
    }
    
    //Move Recebe numero de casas a mover(avancar e recuar) e String com o nome do 'Caminho';
    boolean move(int quanto, String qual) {
        
        int index = 0 ;
        int total;
        
        if(qual.isEmpty())
        {
            System.out.println("vazio ");
            return false;
        }
        
         if(qual.toLowerCase().equals("wall"))
        {
        for( int i =  0 ; i  < wall.length; i++)
        {
            if( wall[i] == 1 )
            {
                index= i ;                       
            }
            
        }
        
        total =  index+quanto; 
        if(total >= wall.length || total <= 0)
            {
                System.out.println("demais"  ); 
               return false;
            }
        
        for(int i = 0 ; i< wall.length ;i++)
        {
         
                if(wall[i] == 1)
                {
                   wall[i] = 0;
                }
                
                if( total == i )
                {
                    wall[i]= 1;               
                }   
        }
            return true;
        }
         
        else
            if(qual.toLowerCase().equals("door".toLowerCase()))
            {
                index= 0 ; 
                total = 0;
                for(int i = 0 ; i< door.length; i++)
                {
                    if(door[i] == 1)
                    {
                    index = i;
                    }
                }
                
                total = index+ quanto;
                if( total >= door.length || total<= 0)
                {
                    return false;
                }
                for( int i = 0 ; i< door.length; i++)
                {
                    if(door[i] == 1)
                        door[i] = 0;
                    if(i == total)
                        door[i] = 1;
                  
                }
                return true;
            }
            
        else
             if(qual.equals("tower".toLowerCase()))
             {
                 if(siegeTower == false)    //Caso a Torre seja Removida
                     return false;
                 
                index= 0 ; 
                total = 0;
                for(int i = 0 ; i< tower.length; i++)
                {
                    if(tower[i] == 1)
                    {
                    index = i;
                    }
                }
                
                total = index+ quanto;
                if( total >= tower.length || total<= 0)
                {
                    return false;
                }
                for( int i = 0 ; i< tower.length; i++)
                {
                    if(tower[i] == 1)
                        tower[i] = 0;
                    if(i == total)
                        tower[i] = 1;
                  
                }
                return true;
            }
        return true;

    }
}
