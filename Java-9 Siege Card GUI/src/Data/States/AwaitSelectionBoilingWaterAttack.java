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
public class AwaitSelectionBoilingWaterAttack extends StateAdapter {

    public AwaitSelectionBoilingWaterAttack(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates goBoilingWaterAttack(String opcao) {

        if (getGameData().isBoiling() == true) {

          getGameData().setDado(getGameData().getNumero());

            int dado = getGameData().getDado();
            dado += getGameData().getDrmBoiling();

            if (getGameData().getEnemy().getPosicao(opcao) != 1) {

                return new AwaitAction(getGameData());
            }

            if (opcao.toLowerCase().equals("wall")) {
                dado += getGameData().getAttackWall();
                if (getGameData().getEnemy().getWallnumber() == dado) {

                    dado += 1;
                }

                if (getGameData().getEnemy().getWallnumber() < dado) {

                    getGameData().getEnemy().move(+2, opcao);

                }
            } else if (opcao.toLowerCase().equals("door")) {
                dado += getGameData().getAttackDoori();
                if (getGameData().getEnemy().getDoornumber() == dado) {
                    dado += 1;
                }
                if (getGameData().getEnemy().getDoornumber() < dado) {

                    getGameData().getEnemy().move(+2, opcao);

                }
            } else if (opcao.toLowerCase().equals("tower")) {
                dado += getGameData().getAttackTower();
                if (getGameData().getEnemy().getTowernumber() == dado) {
                    dado += 1;
                }
                if (getGameData().getEnemy().getTowernumber() < dado) {

                    getGameData().getEnemy().move(+2, opcao);
                }
            }

            if (dado == 1) {
                getGameData().getForte().move(-1, "morale");
            }
              getGameData().setDado(dado);
            int aux = getGameData().getPlayer().getActionPointAllowance() - 1;
            getGameData().getPlayer().setActionPointAllowance(aux);

            getGameData().setBoiling(false);
        }
        if (getGameData().getPlayer().getActionPointAllowance() <= 0) {

            return new AwaitDrawCard(getGameData());
        }

        getGameData().VerificaCombateArea();
        getGameData().verificaCirculo();
        return new AwaitAction(getGameData());
    }
}
