/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.States;

import Data.logica.GameData;

/**
 *
 * @author Asus
 */
public class AwaitAction extends StateAdapter {

    public AwaitAction(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates selectArcherAttack() {
        return new AwaitSelectionArchersTrack(getGameData());
    }
 @Override
    public IStates drawCard() {
        return new AwaitDrawCard(getGameData());
    }

    @Override
    public IStates selectExtra() {
        return new AwaitExtraSelection(getGameData());
    }

    @Override
    public IStates selectBoilingWaterAttack() {
        return new AwaitSelectionBoilingWaterAttack(getGameData());
    }

    @Override
    public IStates goCloseCombat() {
        {
         getGameData().setDado(getGameData().getNumero());
      
        int dado = getGameData().getDado();
        int total = 0;
        String aux1 = " ";
        String aux2 = " ";
        String aux3 = " ";
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        int dado2 = 0;

        dado += getGameData().getDrmClose();

        if (getGameData().getEnemy().getPosicao("wall") == 0) {
            total++;
            aux1 = "wall";
            flag1 = 1;
        }
        if (getGameData().getEnemy().getPosicao("door") == 0) {
            total++;
            aux2 = "door";
            flag2 = 1;
        }
        if (getGameData().getEnemy().getPosicao("tower") == 0) {
            total++;
            aux3 = "tower";
            flag3 = 1;
        }

        if (total == 0) {
            return new AwaitAction(getGameData());
        }
        if (aux1.equals("wall")) {
            dado2 = dado;
            dado2 += getGameData().getAttackWall();
            if (getGameData().getEnemy().getWallnumber() < dado) {
                getGameData().getEnemy().move(+1, aux1);
                flag1 = 0;
            }
        }

        if (aux2.equals("door")) {
            dado2 = dado;
            dado2 += getGameData().getAttackDoori();
            if (getGameData().getEnemy().getDoornumber() < dado) {
                getGameData().getEnemy().move(+1, aux2);
                flag2 = 0;
            }

        }

        if (aux2.equals("tower")) {
            dado2 = dado;
            dado2 += getGameData().getAttackTower();
            if (getGameData().getEnemy().getTowernumber() < dado) {
                getGameData().getEnemy().move(+1, aux3);
                flag3 = 0;
            }
        }

        if (flag1 == 1) {
            dado2 = dado;
            dado2 += getGameData().getAttackWall();
            if (getGameData().getEnemy().getWallnumber() < dado) {
                getGameData().getEnemy().move(+1, aux1);
                flag1 = 0;
            }
        }

        if (flag2 == 1) {
            if (getGameData().getEnemy().getDoornumber() < dado) {
                dado2 = dado;
                dado2 += getGameData().getAttackDoori();
                getGameData().getEnemy().move(+1, aux2);
                flag2 = 0;
            }
        }
        if (flag3 == 1) {
            dado2 = dado;
            dado2 += getGameData().getAttackTower();
            if (getGameData().getEnemy().getTowernumber() < dado) {
                dado += getGameData().getAttackWall();
                getGameData().getEnemy().move(+1, aux3);
                flag3 = 0;
            }

        }

        if (dado == 1) {
            getGameData().getForte().move(-1, "morale");
        }
  getGameData().setDado(dado);
        int aux = getGameData().getPlayer().getActionPointAllowance() - 1;
        getGameData().getPlayer().setActionPointAllowance(aux);
        if (getGameData().getPlayer().getActionPointAllowance() <= 0) {
            return new AwaitDrawCard(getGameData());
        }
        getGameData().VerificaCombateArea();
        getGameData().verificaCirculo();
        return new AwaitAction(getGameData());
    } }

    @Override
    public IStates goCoupure() {
        getGameData().setDado(getGameData().getNumero());
        int dado = getGameData().getDado();
        dado += getGameData().getDrmCoupure();

        if (dado >= 5) {
            getGameData().getForte().move(+1, "wall");
        }

        
        getGameData().setDado(dado);
        int aux = getGameData().getPlayer().getActionPointAllowance() - 1;
        getGameData().getPlayer().setActionPointAllowance(aux);

        if (getGameData().getPlayer().getActionPointAllowance() <= 0) {

            return new AwaitDrawCard(getGameData());
        }

        getGameData().VerificaCombateArea();
        getGameData().verificaCirculo();
        return this;
    }

    @Override
    public IStates selectRallyTroops() {
        return new AwaitSelectionRallyTroops(getGameData());
    }

    @Override
    public IStates selectTunnelMovement() {
        return new AwaitSelectionTunnelMovement(getGameData());
    }

    @Override
    public IStates goSabotage() {

        getGameData().setDado(getGameData().getNumero());
        int total = getGameData().getDado();
        if (getGameData().getForte().getPosicao("tunnel") == 3) {

            total += getGameData().getDrmSabotage();

            if (total >= 5) {
                getGameData().getEnemy().move(-1, "trebuchet");
            }
            if (total == 1) {
                if (getGameData().getForte().getPosicao("raid") > 0) {
                    getGameData().getForte().move(0, "raid");
                }
                getGameData().getForte().move(0, "tunnel");
            }
        }
        getGameData().setDado(total);
        int aux = getGameData().getPlayer().getActionPointAllowance() - 1;
        getGameData().getPlayer().setActionPointAllowance(aux);

        if (getGameData().getPlayer().getActionPointAllowance() <= 0) {
            return new AwaitDrawCard(getGameData());
        }

        getGameData().VerificaCombateArea();
        getGameData().verificaCirculo();
        return new AwaitAction(getGameData());
    }

    @Override
    public IStates goSupplyRaid() {

        if (getGameData().getForte().getPosicao("tunnel") == 3) {

            int total = 0;

            getGameData().setDado(getGameData().getNumero());
            total = getGameData().getDado();
            total += getGameData().getDrmSupply();

            if (total >= 3) {
                getGameData().getForte().move(+1, "raid");

            }
            if (total >= 6) {
                getGameData().getForte().move(+1, "raid");
            }
            //total = 1;

            if (total == 1) {
                getGameData().getForte().move(0, "tunnel");
                getGameData().getForte().move(0, "raid");
            }
            getGameData().getPlayer().setActionPointAllowance(-1);
        getGameData().setDado(total);
        }
       
        int aux = getGameData().getPlayer().getActionPointAllowance() - 1;
        getGameData().getPlayer().setActionPointAllowance(aux);

        if (getGameData().getPlayer().getActionPointAllowance() <= 0) {

            return new AwaitDrawCard(getGameData());

        }

        getGameData().VerificaCombateArea();
        getGameData().verificaCirculo();

        return new AwaitAction(getGameData());
    }
}
