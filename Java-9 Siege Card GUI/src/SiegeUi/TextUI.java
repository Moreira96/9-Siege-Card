
package SiegeUI;

import Data.Game;
import Data.States.AwaitAcabou;
import Data.States.AwaitAction;
import Data.States.AwaitBeginning;
import Data.States.AwaitDrawCard;
import Data.States.AwaitExtraSelection;
import Data.States.AwaitSelectionArchersTrack;
import Data.States.AwaitSelectionBoilingWaterAttack;
import Data.States.AwaitSelectionCloseCombat;
import Data.States.AwaitSelectionRallyTroops;
import Data.States.AwaitSelectionTunnelMovement;
import Data.States.IStates;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author morei
 */
public class TextUI   {
    
    private Game game;
    private Boolean quit = false ;
            
    public TextUI(Game game){
        this.game = game;
    }
    
    public void uiAwaitBeginning() throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        String option, fileName;
        char c, op;
        int opcao;
        
        while(true){
            do{
                System.err.println("\t\t 9 Siege Card");
                System.out.println("\n0 - Sair");
                System.out.println("1 - Novo Jogo");
                System.out.println("2 - Continuar Jogo");
                System.out.print("\n > ");
                
                option = sc.next();
                
                if(option.length() >= 1){
                    c = option.charAt(0);
                } else{
                    c = ' ';
                }
                
            }while(c < '0' || c > '2');
            
            switch(c){
                
                case '0':
                    quit = true;
                    return;
                case '1':
                    System.out.println("\nInicio do Jogo\n");
                    game.startGame();
                    return;
                case '2':
                   game=(LeFicheiroTexto("guarda"));
                    System.out.println("Nome do Ficheiro: ");
                    return;
                default:
                    return;
            }
        }
    }
    
    public void uiAwaitDrawCard() throws IOException{
        Scanner sc = new Scanner(System.in);
        
        String option, fileName;
        char c;
  //     Guarda a = game.getDataGame().getGuarda();
        while (true) {
            do {
                System.out.println("\tForte\n" + game.getDataGame().getForte().toString() + "\n\n\tEnemy\n" + game.getDataGame().getEnemy().toString() + "\nAction Points :: " + game.getDataGame().getPlayer().getActionPointAllowance());
                System.out.println("\n0 - quit");
                System.out.println("1 - Retira Carta");
                System.out.println("2 - Gravar Jogo");
                System.out.print("\n > ");
        
                option = sc.next();
        
                if (option.length() >= 1) {
                        c = option.charAt(0);
                } else {
                        c = ' ';
                    }
            } while (c < '0' || c > '2');
            
            switch(c){
                case '0':
                    quit = true;
                    return;
                case '1':
                    game.showCard();
                    System.out.println("\n\tInfo carta:\n" + game.getDataGame().getCartaActua().toString());
                    return;
                case '2':
                    guardaFicheiroTexto("guarda");
                    quit = true;
                    return;
            }
        }
    }
    
        public void guardaFicheiroTexto( String nomefich) throws IOException
    {
        ObjectOutputStream out  = null;
        
     try 
       {
        out = new  ObjectOutputStream(new FileOutputStream(nomefich));
        out.writeObject(game);
        }finally{
    if(out!= null)
    
        {
            out.close();
        }
    
    }
    

    }
        
         public Game LeFicheiroTexto( String nomefich) throws IOException, ClassNotFoundException
         {
             Game gameaux;
             ObjectInputStream in = null;
             try
             {
                 in = new ObjectInputStream(new FileInputStream(nomefich));
                 gameaux = (Game)in.readObject();
                 
             }finally{
             if(in!= null)
                 in.close();
             }
             return gameaux;
                 }

    public void uiAwaitAction(){
        Scanner sc = new Scanner(System.in);
        char c, op;
        String option;
        
        System.out.println("\n\tForte\n" + game.getDataGame().getForte().toString() + "\n\n\tEnemy\n" + game.getDataGame().getEnemy().toString() + "\nAction Points :: " + game.getDataGame().getPlayer().getActionPointAllowance() + "\n");
                
        
        do{
            System.out.println("0 - Sair");
            System.out.println("1 - Archers Attack");
            System.out.println("2 - Boiling Water Attack");
            System.out.println("3 - Close Combat Attack");
            System.out.println("4 - Coupure");
            System.out.println("5 - Rally Troops");
            System.out.println("6 - Tunnel Movement");
            System.out.println("7 - Supply Raid");
            System.out.println("8 - Sabotage\n");
            System.out.println("9 - Additional Action Point");
            
            System.out.print(" > ");
            
            option = sc.next();
            
            if (option.length() >= 1) {
                    c = option.charAt(0);
                } else {
                    c = ' ';
                }
            
        }while(c < '0' || c > '9');
        
        switch(c){
            case '0':
                quit = true;
                return;
            case '1':
                game.Archers();
                return;
            case '2':
                game.Boiling();
                return;
            case '3':
                game.CloseCombat();
                return;
            case '4':
                game.Coupure();
                return;
            case '5':
                game.RallyTroops();
                return;
            case '6':
                game.RallyTroops();
                return;
            case '7':
                game.SupplyRaid();
                return;
            case '8':
                game.Sabotage();
                return;
            case '9':         
                game.Extra();
                return;
        }
    }
    
    public void uiSelectArcher(){
        Scanner sc = new Scanner(System.in);
        String option;
        char c;
        int opcao;
        
        do{
            System.out.println("1 - Wall");
            System.out.println("2 - Tower");
            System.out.println("3 - Door");
            
            System.out.print(" > ");
            
            option = sc.next();
            
            if (option.length() >= 1) {
                    c = option.charAt(0);
                } else {
                    c = ' ';
                }
            
        }while(c < '1' || c > '3');
        
        switch(c){
            case '1':
                game.ArchersSelect("wall");
                return;
            case '2':
                game.ArchersSelect("tower");
                return;
            case '3':
                game.ArchersSelect("door");
                return;        
        }
    }
    
    public void uiSelectBoilingWaterAttack(){
        Scanner sc = new Scanner(System.in);
        String option;
        char c;
        int opcao;
        
        do{
            System.out.println("1 - Wall");
            System.out.println("2 - Tower");
            System.out.println("3 - Door");
            
            System.out.print(" > ");
            
            option = sc.next();
            
            if (option.length() >= 1) {
                    c = option.charAt(0);
                } else {
                    c = ' ';
                }
            
        }while(c < '1' || c > '3');
        
        switch(c){
            case '1':
                game.BoilingSelect("wall");
                return;
            case '2':
                game.BoilingSelect("tower");
                return;
            case '3':
                game.BoilingSelect("door");
                return;        
        }
    }
    
    public void uiSelectCloseCombat(){
        
        game.CloseCombat();
    }
    
    public void uiSelectRallyTroops(){
        Scanner sc = new Scanner(System.in);
        String option;
        char c;
        
        do{
            System.out.println("1 - Discurso");
            System.out.println("2 - Usar suplimento");
            
            System.out.print(" > ");
            
            option = sc.next();
            
            if (option.length() >= 1) {
                    c = option.charAt(0);
                } else {
                    c = ' ';
                }
            
        }while(c < '1' || c > '3');
        
        switch(c){
            case '1':
                game.RallySelect("");
                return;
            case '2':
                game.RallySelect("supplies");
                return;      
        }
    }
    
    public void uiSelectTunnelMovement(){
        Scanner sc = new Scanner(System.in);
        String option;
        char c;
        int opcao;
        
        do{
            System.out.println("1 - Free Movement");
            System.out.println("2 - Fast Movement");
            System.out.println("3 - Automatic Movement");
            
            System.out.print(" > ");
            
            option = sc.next();
            
            if (option.length() >= 1) {
                    c = option.charAt(0);
                } else {
                    c = ' ';
                }
            
        }while(c < '1' || c > '3');
        
        switch(c){
            case '1':
                game.TunnelSelect("free");
                return;
            case '2':
                game.TunnelSelect("fast");
                return;  
            case '3':
                game.TunnelSelect("automatic");
        }
    }
    
    public void uiAwaitExtra(){
                Scanner sc = new Scanner(System.in);
        
        String option;
        char c;
       
        while (true) {
            do {
                System.out.println("\n0 - quit");
                System.out.println("1 - Usar pontos de Moral");
                System.out.println("2 - Usar Suplies");
                System.out.print("\n > ");
        
                option = sc.next();
        
                if (option.length() >= 1) {
                        c = option.charAt(0);
                } else {
                        c = ' ';
                    }
            } while (c < '0' || c > '2');
            
            switch(c){
                case '0':
                    quit = true;
                    return;
                case '1':
                //    game.ExtraSelect("1");
                    return;
                case '2':
                  //  game.ExtraSelect("2");
                    return;
            }
        }
    }
    
    public void uiEndOfGame() {

        int numLinhasCOnsola = 60;
    
        for (int i = 0; i < numLinhasCOnsola; i++) {
            System.out.print("*");
        }
        if(game.getDefeat()==true ){
            System.out.println("Derrota");
            game.endOfGame();
        }
        else
            if(game.getVictory()==true )
                {
                  System.out.println("VITORIA");
                  game.victory();
                }
    }
    
    
    public void run() throws IOException, ClassNotFoundException{
        
        while(!quit){
            
            IStates state = game.getState();
            
            if(state instanceof AwaitBeginning){
                uiAwaitBeginning();
            }else if(state instanceof AwaitDrawCard){
                uiAwaitDrawCard();
            }else if(state instanceof AwaitAction){
                uiAwaitAction();
            }else if(state instanceof AwaitSelectionArchersTrack){
                uiSelectArcher();
            }else if(state instanceof AwaitSelectionBoilingWaterAttack){
                uiSelectBoilingWaterAttack();
            }else if(state instanceof AwaitSelectionCloseCombat){
                uiSelectCloseCombat();
            }else if(state instanceof AwaitSelectionRallyTroops){
                uiSelectRallyTroops();
            }else if(state instanceof AwaitSelectionTunnelMovement){
                uiSelectTunnelMovement();
            }else if(state instanceof AwaitAcabou){
                uiEndOfGame();
            }else if(state instanceof AwaitExtraSelection){
              uiAwaitExtra();  
            }
            
        }
    }
}
