/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.logica;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Asus
 */
public final class GameData implements Serializable{
    
    private List<Card> cards;
    private List<Card> jogadas;
    private Forte a; 
    private EnemyStats e; 
    private Player p;
   // private Actions actual = new Actions("");// new Actions("");
    private Card cartaActual = new Card();
    private int DRM = 0 ;
    private int dia =0 ; 
    private int attack=0;
    private int attackWall=0;
    private int attackDoori=0;
    private int attackTower=0;
    private int drmArcher= 0; 
    private int drmBoiling =0 ;
    private int drmClose= 0 ;
    private int drmCoupure= 0 ;
    private int drmRally= 0 ;
    private int drmTunnel= 0 ;
    private int drmSupply= 0 ;
    private int drmSabotage= 0 ;
    private boolean endgame= false; 
    private boolean extra = true ; 
    private boolean boiling =true; 
    private boolean pontoextra = true;
    private boolean closeWall = false; 
    private boolean closeDoor = false; 
            private boolean closeTower  = false; 
    private int vitoria =0  ; 
    private boolean victory= false;
    //private Guarda guarda = new Guarda();
    public GameData()
            {
                cards = new ArrayList<>();
                jogadas = new ArrayList<>();
                 a= new Forte();
                 e = new EnemyStats();
                 p =  new Player("Jogador1");     
                 
                 inicializaCartas();
                 
                 
            }

    public List<Card> getJogadas() {
        return jogadas;
    }

    public void setJogadas(List<Card> jogadas) {
        this.jogadas = jogadas;
    }
    
 
  public int getNumero()
    {
          
        return (int)(Math.random() * 6 )+1;
    }
     public int getDRM()
      {
          return DRM;
      }
      public void setDRM(int num)
      {
          DRM =  num ; 
      }
    public void inicializaCartas()
    {
       cards.add(new Card1());  
       cards.add(new Card2());
       cards.add(new Card3());
       cards.add(new Card4());
       cards.add(new Card5());
       cards.add(new Card6());
       cards.add(new Card7());
       
    }
    

    
    public void baralha ()
    {
        Collections.shuffle(cards);
    }
    public void remove ( Card m )
    {
      
        
        if( getCards().contains(m))
        {
            getCards().remove(m);
        }
        else
            return;
            
    }
    public void setcartaActual(Card a)
    {
        cartaActual=a ;
        setPlayerPoint(a.getactionPoint());
        
        // TESTAR 
    }
    
    public void setAttack(int num)
    {
        this.attack=num;
    }
    public int getAttack()
    {
        return attack;
    }
    public Card getCartaActua()
    {
        return cartaActual;
    }
    public List<Card> getCards() {
        return cards;
    }

    /**
     *
     * @param Cards
     */
    public void listaCard( List<Card> Cards )
    {
       for( Card card : jogadas)
       {
           System.out.println("Carta -> :" + card.getSerie() + card.toString());
       }
    
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }


    public Forte getForte() {
        return a;
    }

    public void setForte(Forte a) {
        this.a = a;
    }

    public EnemyStats getEnemy() {
        return e;
    }

    public void setEnemy(EnemyStats e) {
        this.e = e;
    }

    public Player getPlayer() {
        return p;
    }

    public void setPlayer(Player p) {
        this.p = p;
    }
    public void setPlayerPoint(int p)
    {
        this.p.setActionPointAllowance(p);
    }
    public Card  buscaCard(Card m)
    {
       // baralha();//
        for( Card a : cards)
        {
         if( m == null || a== null )
         {
          return null ;    
         }
         if(a.equals(m))
         {
             return a ;
         }
        }
        return null;
    }
    
    public void aplicaEventoCarta(Card m)
    {
        setcartaActual(m);
    
        if(dia==1)
        {
            m.aconteceEventodiaum(this);
           
        }
        else
            if(dia==2)
            {
                m.aconteceEventodiadois(this);
              //  System.out.println("se tudo corre bem,");
            }
        else
                if(dia==3)
                {
                    m.aconteceEventodiatres(this);
                }
        
        
    }
    
    public void validamovimento()
    {
       ContaCombateArea();
       ContaStatusTrack();
      
        
    }
    public void aplicaFigurasCarta(Card m)
    {
        setcartaActual(m);
        
        if(dia==1)
        {
            m.aplicaFigurasCartaum(this);
        }
        else
            if(dia==2)
            {
                m.aplicaFigurasCartadois(this);
              //  System.out.println("se tudo corre bem,");
            }
        else
                if(dia==3)
                {
                    m.aplicaFigurasCartatres(this);
                }
        
        
    }
    public void ContaStatusTrack()
    {  
      
         if(getForte().getPosicao("wall")==0)
        {
            
            getForte().setContaStatus(+1);
        }
        if(getForte().getPosicao("morale")==0)
        {
           
         getForte().setContaStatus(+1);
        }
        if(getForte().getPosicao("supplie")==0)
        {
           
             getForte().setContaStatus(+1);
        }
        if( getForte().getContaStatus() == 0 )
        {
            getForte().setContaStatus(0);
            
        }
       
        if( getForte().getContaStatus() == 2)
        {
        //    System.out.println("SOU EU QUE PONHO A TRUE" + getForte().getContaStatus());
            setEndGame(true);
        }
    }
    public void ContaCombateArea()
    {
        if(getEnemy().getPosicao("wall")==0)
        {
            if( isCloseWall()== false)
            {
            getForte().move(-1, "morale");
            setCloseWall(true);
            }
            getEnemy().setCloseCombat(+1);
           
        }
        if(getEnemy().getPosicao("door")==0)
        {  if( isCloseDoor()== false)
            {
            getForte().move(-1, "morale");
            setCloseDoor(true);
            
            }
         getEnemy().setCloseCombat(+1);
        }
        if(getEnemy().getPosicao("tower")==0)
        {
           if( isCloseTower()== false)
            {
            getForte().move(-1, "morale");
            setCloseTower(true);
            }
            getEnemy().setCloseCombat(+1);
        }
         if( getEnemy().getCloseCombat() == 3)
          {
              setEndGame (true);
          }
      //  getEnemy().
    }
    
   public boolean VerificaCombateArea()
    {
        int i = 0 ;
  
   if(getEnemy().getPosicao("wall")==0)
        {
            i++;
            getEnemy().setCombatWall(true);
            getEnemy().setWallnumber(4);
            //return getEnemy().isCombatWall();
        }
         if(getEnemy().getPosicao("door")==0)
        {getEnemy().setCombatDoor(true);
           // System.out.println("XDCFGVHBJNKML,Ç");
         //   return getEnemy().isCombatDoor();
        i++;
        getEnemy().setDoornumber(4);
        }
          if(getEnemy().getPosicao("tower")==0)
        {getEnemy().setCombatTower(true);
           // return getEnemy().isCombatTower();
        i++;
        getEnemy().setTowernumber(4);
        }
         if( i == 0 )
          {
              getEnemy().setCombatWall(false);
              getEnemy().setCombatDoor(false);
              getEnemy().setCombatTower(false);
             // return false;
          }
        
         
            System.out.println("ESTAO " + i + " NO CLOSE COMBAT");
    return true;
    }
    public void adicionaCartaUsada(Card usada)
    {
        jogadas.add(usada);
    }
    public void EnemyLineCheck(String opcao)
    {
        int total = 0 ;
                 
if (opcao.isEmpty())
{
    

        total = getNumero();
 }
else
    if(opcao.equals("endday"))
    {
        total =1 ;
    }
        if(getForte().getPosicao("tunnel")==3)
        { System.out.println("\nDADO ENEMYLINECHECK : "+ total);
            if(total  <2){
                getForte().move(0,"tunnel");
                getForte().move(-1, "morale");
                getForte().move(0, "raid");
            }
            }
      
    }
    public void victoryorlosscheckpoint() 
    {
        if(getEnemy().getCloseCombat()==2)
        {
            setEndGame(true);
            System.out.println(" dois no close combat ->Perdeu");
        
        }
        if(getForte().getContaStatus()==1)
        {
            System.out.println("UM dos Status tracks esta a 0 ");
            setEndGame(true);
        }
        
        if( vitoria == 3)
        {
            setVictory(true);
        }
        
    }
   
    public boolean verificaCirculo()
    {
        int i = 0 ; 
        if(getEnemy().getPosicao("wall")==1)
        {
            i++;
            
            getEnemy().setCirculoWall(true);
             setCloseWall(false);
            
             
          // System.out.println("\n\t\tcirculo:" + getEnemy().isCirculoWall()+"\n\n");
            //return getEnemy().isCirculoWall();
        }
         if(getEnemy().getPosicao("door")==1)
        {i++; 
            getEnemy().setCirculoDoor(true);
            setCloseDoor(false);
            //return getEnemy().isCirculoDoor();
        }
          if(getEnemy().getPosicao("tower")==1)
        {i++;
            getEnemy().setCirculoTower(true);
            setCloseTower(false);
            //return getEnemy().isCirculoTower();
        }
          if( i  == 0 )
          {
                getEnemy().setCirculoWall(false);
                getEnemy().setCirculoDoor(false);
                getEnemy().setCirculoTower(false);
              System.out.println("Nao ha ninguem no circulo!");
              //return false;
          }
    return true;
    }
    
      //ArchersAttack qwe = new ArchersAttack(nome);
    //  actual = new ArchersAttack(nome);
     
       
       
     
//      public void aplicaAccao(Actions a,String onde)
//   {
//      //ArchersAttack qwe = new ArchersAttack(nome);
//    //  actual = new ArchersAttack(nome);
//     
//       
//       
//      // actual = buscaAccao(a);
//        setActual(buscaAccao(a)); 
//      
//      if(getCartaActua().getSerie()==2 )
//      {
//            if (getActual().equals(new RallyTroops("RallyTroops"))) {
//                setDRM(+1);
//                System.out.println("O MEU DRM É" + DRM + "\n" );
//                actual.aconteceAccaoForte(this);
//                setDRM(0);
//            }
//      }
//      if(getCartaActua().getSerie()==3)
//      {
//         
//           if(!(getActual().equals(new RallyTroops("RallyTroops"))))
//              System.out.println("Ola");
//              
//          
//         
//      }
//     
//       actual.aconteceAccao(this,onde );
//     
//      //qwe.aconteceAccao(this, nome);
//     
//   }
//      //qwe.aconteceAccao(this, nome);
    
      

       
   
   


    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
  
    public void fimTurno()
    {
        //dia++;
        setDRM(0);
        if( getEnemy().getPosicao("wall")!= 0)
        {
            getEnemy().setWallnumber(2);
        }
        if( getEnemy().getPosicao("door")!= 0)
        {
         getEnemy().setDoornumber(3);
        }
        if( getEnemy().getPosicao("tower")!= 0)
        {
            getEnemy().setTowernumber(4);
        }
        
        
        
       
        this.drmArcher= 0; 
        this.drmBoiling =0 ;
        this.drmClose= 0 ;
        this.drmCoupure= 0 ;
        this.drmRally= 0 ;
        this.drmTunnel= 0 ;
        this.drmSupply= 0 ;
        this.drmSabotage= 0 ;
        setExtra(true);
        setBoiling(true);
        setPontoextra(true);
        
        
        
    }

    public void fimDia()
    {
        if (getCards().isEmpty() )
        {
           for( Card car: jogadas)
           {
               cards.add(car);
           }
            
        //
            
            
            
            getJogadas().clear();
         System.out.println(" TAMANHO CARTAS : "+ getCards().size() +" TAMANHO JOGADAS: "+ getJogadas().size());
      
        
        dia++;
        
        getForte().move(-1, "supplie");
        System.out.println("You must feed your people");
        EnemyLineCheck("endday");
        vitoria++;
         }
               
    }
    public int getAttackWall() {
        return attackWall;
    }

    public void setAttackWall(int attackWall) {
        this.attackWall = attackWall;
    }

    public int getAttackDoori() {
        return attackDoori;
    }

    public void setAttackDoori(int attackDoori) {
        this.attackDoori = attackDoori;
    }

    public int getAttackTower() {
        return attackTower;
    }

    public void setAttackTower(int attackTower) {
        this.attackTower = attackTower;
    }
    
    
    
  
    public void  regularMovement()
    {
        System.out.println("REGULAR MOVEMENT");
        if(getCartaActua().isLadders()==true )//&& getGameData().getCartaActua().isRam()==false &&getGameData().getCartaActua().isTower()==false )
        {
            getEnemy().move(-1, "wall");
        }
         if(getCartaActua().isRam()==true )//&& getGameData().getCartaActua().isLadders()==false  &&getGameData().getCartaActua().isTower()==false  )
        {
            getEnemy().move(-1, "door");
        }
          if(getCartaActua().isTower()==true)// && getGameData().getCartaActua().isRam()==false && getGameData().getCartaActua().isLadders()==false)
        {
            getEnemy().move(-1, "tower");
        }
        
        
        
        
        
    }
    
   
    public void slowestUnitMovement()
    {
        System.out.println("SLOW MOVEMENT");
        int minimo = 0 ; 
        minimo = getEnemy().getPosicao("wall");
               getCartaActua().setLadders(true);
        if(minimo <= getEnemy().getPosicao("door"))
        {
            if(minimo==getEnemy().getPosicao("door"))
            {
               getCartaActua().setRam(true);
            }else{
            minimo =  getEnemy().getPosicao("door");
          getCartaActua().setRam(true);
          getCartaActua().setLadders(false);
            getCartaActua().setTower(false);
            }
        }
       
            if(minimo <= getEnemy().getPosicao("tower"))
        {
            
            
          
            if(minimo==getEnemy().getPosicao("tower"))
            {
         getCartaActua().setTower(true);
            
            } else
            {minimo = getEnemy().getPosicao("tower");
           getCartaActua().setTower(true);
            getCartaActua().setRam(false);
            getCartaActua().setLadders(false);
            }
        }
      
        
        
        regularMovement();
       
    
    
    }
    
   
    public void trebuchetEffectonMovement()
    {
        
        System.out.println("Nao é permitido enemy movements");
      
    }
      public int getDrmArcher() {
        return drmArcher;
    }

    public void setDrmArcher(int drmArcher) {
        this.drmArcher += drmArcher;
    }

    public int getDrmBoiling() {
        return drmBoiling;
    }

    public void setDrmBoiling(int drmBoiling) {
        this.drmBoiling += drmBoiling;
    }

    public int getDrmClose() {
        return drmClose;
    }

    public void setDrmClose(int drmClose) {
        this.drmClose += drmClose;
    }

    public int getDrmCoupure() {
        return drmCoupure;
    }

    public void setDrmCoupure(int drmCoupure) {
        this.drmCoupure += drmCoupure;
    }

    public int getDrmRally() {
        return drmRally;
    }

    public void setDrmRally(int drmRally) {
        this.drmRally += drmRally;
    }

    public int getDrmTunnel() {
        return drmTunnel;
    }

    public void setDrmTunnel(int drmTunnel) {
        this.drmTunnel += drmTunnel;
    }

    public int getDrmSupply() {
        return drmSupply;
    }

    public void setDrmSupply(int drmSupply) {
        this.drmSupply += drmSupply;
    }

    public int getDrmSabotage() {
        return drmSabotage;
    }

    public void setDrmSabotage(int drmSabotage) {
        this.drmSabotage += drmSabotage;
    }

    public void setEndGame(boolean b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        endgame=b ;
    }
    public boolean getEndGame()
    {
        return endgame ; 
    }

    public Forte getA() {
        return a;
    }

    public void setA(Forte a) {
        this.a = a;
    }

    public EnemyStats getE() {
        return e;
    }

    public void setE(EnemyStats e) {
        this.e = e;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Card getCartaActual() {
        return cartaActual;
    }

    public void setCartaActual(Card cartaActual) {
        this.cartaActual = cartaActual;
    }

    public boolean isEndgame() {
        return endgame;
    }

    public void setEndgame(boolean endgame) {
        this.endgame = endgame;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public boolean isBoiling() {
        return boiling;
    }

    public void setBoiling(boolean boiling) {
        this.boiling = boiling;
    }

    public boolean isPontoextra() {
        return pontoextra;
    }

    public void setPontoextra(boolean pontoextra) {
        this.pontoextra = pontoextra;
    }

    public boolean isCloseWall() {
        return closeWall;
    }

    public void setCloseWall(boolean closeWall) {
        this.closeWall = closeWall;
    }

    public boolean isCloseDoor() {
        return closeDoor;
    }

    public void setCloseDoor(boolean closeDoor) {
        this.closeDoor = closeDoor;
    }

    public boolean isCloseTower() {
        return closeTower;
    }

    public void setCloseTower(boolean closeTower) {
        this.closeTower = closeTower;
    }

    public int getVitoria() {
        return vitoria;
    }

    public void setVitoria(int vitoria) {
        this.vitoria = vitoria;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }


}