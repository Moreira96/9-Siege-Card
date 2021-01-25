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
public final class GameData implements Serializable {

    private List<Card> cards;
    private List<Card> jogadas;
    private Forte a;
    private EnemyStats e;
    private Player p;
    // private Actions actual = new Actions("");// new Actions("");
    private Card cartaActual = new Card();

    private int dia = 0;
    private int attack = 0;
    private int attackWall = 0;
    private int attackDoori = 0;
    private int attackTower = 0;
    private int drmArcher = 0;
    private int drmBoiling = 0;
    private int drmClose = 0;
    private int drmCoupure = 0;
    private int drmRally = 0;
    private int drmTunnel = 0;
    private int drmSupply = 0;
    private int drmSabotage = 0;
    private boolean endgame = false;
    private boolean extra = true;
    private boolean boiling = true;
    private boolean pontoextra = true;
    private int vitoria = 0;
    private boolean victory = false;
    private int dado;

    //private Guarda guarda = new Guarda();
    public GameData() {
        cards = new ArrayList<>();
        jogadas = new ArrayList<>();
        a = new Forte();
        e = new EnemyStats();
        p = new Player("Jogador1");

        inicializaCartas();

    }

    public List<Card> getJogadas() {
        return jogadas;
    }

    public void setJogadas(List<Card> jogadas) {
        this.jogadas = jogadas;
    }

    public int getNumero() {

        return (int) (Math.random() * 6) + 1;
    }

    public void inicializaCartas() {
        cards.add(new Card1());
        cards.add(new Card2());
        cards.add(new Card3());
        cards.add(new Card4());
        cards.add(new Card5());
        cards.add(new Card6());
        cards.add(new Card7());

    }

    public void baralha() {
        Collections.shuffle(cards);
    }

    public void remove(Card m) {

        if (getCards().contains(m)) {
            getCards().remove(m);
        } else {
            return;
        }

    }

    public void setcartaActual(Card a) {
        cartaActual = a;
        setPlayerPoint(a.getactionPoint());

        // TESTAR 
    }

    public void setAttack(int num) {
        this.attack = num;
    }

    public int getAttack() {
        return attack;
    }

    public Card getCartaActua() {
        return cartaActual;
    }

    public List<Card> getCards() {
        return cards;
    }

    /**
     *
     * @param Cards
     */
    public void listaCard(List<Card> Cards) {
        for (Card card : jogadas) {
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

    public void setPlayerPoint(int p) {
        this.p.setActionPointAllowance(p);
    }

    public Card buscaCard(Card m) {
        // baralha();//
        for (Card a : cards) {
            if (m == null || a == null) {
                return null;
            }
            if (a.equals(m)) {
                return a;
            }
        }
        return null;
    }

    public void aplicaEventoCarta(Card m) {
        setcartaActual(m);

        if (dia == 1) {
            m.aconteceEventodiaum(this);

        } else if (dia == 2) {
            m.aconteceEventodiadois(this);
            //  System.out.println("se tudo corre bem,");
        } else if (dia == 3) {
            m.aconteceEventodiatres(this);
        }

    }

    public void validamovimento() {
        
      getForte().setContaStatus(0);
      getEnemy().setCloseCombat(0);
        ContaCombateArea();
//        ContaStatusTrack();

    }

    public void aplicaFigurasCarta(Card m) {
        setcartaActual(m);

        if (dia == 1) {
            m.aplicaFigurasCartaum(this);
        } else if (dia == 2) {
            m.aplicaFigurasCartadois(this);
            //  System.out.println("se tudo corre bem,");
        } else if (dia == 3) {
            m.aplicaFigurasCartatres(this);
        }

    }

    public void ContaStatusTrack() {

        if (getForte().getPosicao("wall") == 0) {

            getForte().setContaStatus(+1);
        }
        if (getForte().getPosicao("morale") == 0) {

            getForte().setContaStatus(+1);
        }
        if (getForte().getPosicao("supplie") == 0) {

            getForte().setContaStatus(+1);
        }
        if (getForte().getContaStatus() == 0) {
            getForte().setContaStatus(0);

        }

        if (getForte().getContaStatus() == 2) {
            //    System.out.println("SOU EU QUE PONHO A TRUE" + getForte().getContaStatus());
            setEndGame(true);
        }
    }

    public void ContaCombateArea() {
        if (getEnemy().getPosicao("wall") == 0) {
            
                 getEnemy().setCloseCombat(+1);
            }
           
            
           

        
        if (getEnemy().getPosicao("door") == 0) 
            {
          
            getEnemy().setCloseCombat(+1);
            }
            
           
            
           
        
        if (getEnemy().getPosicao("tower") == 0) {
                getEnemy().setCloseCombat(+1);
                
            }
         
        
        if (getEnemy().getCloseCombat() == 3) {
            setEndGame(true);
        }
       
        //  getEnemy().
    }

    public boolean VerificaCombateArea() {
        int i = 0;

        if (getEnemy().getPosicao("wall") == 0) {
            i++;
            getEnemy().setCombatWall(true);
             getEnemy().setCirculoWall(false);
            getEnemy().setWallnumber(4);
            //return getEnemy().isCombatWall();
        }
        else
             getEnemy().setCombatDoor(false);
        if (getEnemy().getPosicao("door") == 0) {
            getEnemy().setCombatDoor(true);
            // System.out.println("XDCFGVHBJNKML,Ç");
            //   return getEnemy().isCombatDoor();
            i++;
            getEnemy().setDoornumber(4);
            
        }
        else
             getEnemy().setCombatDoor(false);
        if (getEnemy().getPosicao("tower") == 0) {
            getEnemy().setCombatTower(true);
              getEnemy().setCirculoTower(false);

            i++;
            getEnemy().setTowernumber(4);
        }
        else
             getEnemy().setCombatTower(false);
        if (i == 0) {
            getEnemy().setCombatWall(false);
            getEnemy().setCombatDoor(false);
            getEnemy().setCombatTower(false);
            // return false;
        }

        return true;
    }

    public void adicionaCartaUsada(Card usada) {
        jogadas.add(usada);
    }

    public void EnemyLineCheck(String opcao) {
        int total = 0;

        if (opcao.isEmpty()) {

            total = getNumero();
        } else if (opcao.equals("endday")) {
            total = 1;
        }
        if (getForte().getPosicao("tunnel") == 3) {
          
            if (total < 2) {
                System.out.println("tropas caçadas");
                getForte().move(0, "tunnel");
                getForte().move(-1, "morale");
                getForte().move(0, "raid");
            }
        }

    }

    public void victoryorlosscheckpoint() {
        if (getEnemy().getCloseCombat() == 2) {
            setEndGame(true);


        }
        if (getForte().getContaStatus() == 1) {

            setEndGame(true);
        }

        if (dia ==3&&vitoria >= 3) {
            setVictory(true);
        }

    }

    public boolean verificaCirculo() {
        int i = 0;
        if (getEnemy().getPosicao("wall") == 1) {
            i++;

            getEnemy().setCirculoWall(true);
            getEnemy().setCombatWall(false);
        }
        else
           getEnemy().setCirculoWall(false);
        if (getEnemy().getPosicao("door") == 1) {
            i++;
            getEnemy().setCirculoDoor(true);
            getEnemy().setCombatDoor(false);

        }
        else
             getEnemy().setCirculoDoor(false);
        if (getEnemy().getPosicao("tower") == 1) {
            i++;
            getEnemy().setCirculoTower(true);
             getEnemy().setCombatDoor(false);
            //return getEnemy().isCirculoTower();
        }
        else
             getEnemy().setCirculoTower(false);
        if (i == 0) {
            getEnemy().setCirculoWall(false);
            getEnemy().setCirculoDoor(false);
            getEnemy().setCirculoTower(false);
        }
        return true;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void fimTurno() {
        //dia++;
    
        victoryorlosscheckpoint();
        if (getEnemy().getPosicao("wall") != 0) {
            getEnemy().setWallnumber(2);
        }
        if (getEnemy().getPosicao("door") != 0) {
            getEnemy().setDoornumber(3);
        }
        if (getEnemy().getPosicao("tower") != 0) {
            getEnemy().setTowernumber(4);
        }
        
        getPlayer().setActionPointAllowance(0);
        this.drmArcher = 0;
        this.drmBoiling = 0;
        this.drmClose = 0;
        this.drmCoupure = 0;
        this.drmRally = 0;
        this.drmTunnel = 0;
        this.drmSupply = 0;
        this.drmSabotage = 0;
        setExtra(true);
        setBoiling(true);
        setPontoextra(true);
          getCartaActua().setLadders(false);
                getCartaActua().setTower(false);
                  getCartaActua().setRam(false);
             
        
    }

    public void fimDia() {
        if (getCards().isEmpty()) {
            for (Card car : jogadas) {
                cards.add(car);
            }

            //
            getJogadas().clear();
          //  System.out.println("A MUDAR DE DIA!");
            dia++;

            getForte().move(-1, "supplie");
           
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

    public void regularMovement() {

        if (getCartaActua().isLadders() == true)//&& getGameData().getCartaActua().isRam()==false &&getGameData().getCartaActua().isTower()==false )
        {
            getEnemy().move(-1, "wall");
        }
        if (getCartaActua().isRam() == true)//&& getGameData().getCartaActua().isLadders()==false  &&getGameData().getCartaActua().isTower()==false  )
        {
            getEnemy().move(-1, "door");
        }
        if (getCartaActua().isTower() == true)// && getGameData().getCartaActua().isRam()==false && getGameData().getCartaActua().isLadders()==false)
        {
            getEnemy().move(-1, "tower");
        }

    }

    public void slowestUnitMovement() {

        int minimo = 0;
        minimo = getEnemy().getPosicao("wall");
        getCartaActua().setLadders(true);
        if (minimo <= getEnemy().getPosicao("door")) {
            if (minimo == getEnemy().getPosicao("door")) {
                getCartaActua().setRam(true);
            } else {
                minimo = getEnemy().getPosicao("door");
                getCartaActua().setRam(true);
                getCartaActua().setLadders(false);
                getCartaActua().setTower(false);
            }
        }

        if (minimo <= getEnemy().getPosicao("tower")) {

            if (minimo == getEnemy().getPosicao("tower")) {
                getCartaActua().setTower(true);

            } else {
                minimo = getEnemy().getPosicao("tower");
                getCartaActua().setTower(true);
                getCartaActua().setRam(false);
                getCartaActua().setLadders(false);
            }
        }

        regularMovement();

    }

    public void trebuchetEffectonMovement() {

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

        endgame = b;
    }

    public boolean getEndGame() {
        return endgame;
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

    public int getDado() {
        return dado;
    }

    public void setDado(int Dado) {
        dado = Dado;
    }
}
