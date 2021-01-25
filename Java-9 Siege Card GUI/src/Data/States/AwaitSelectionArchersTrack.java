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
public class AwaitSelectionArchersTrack extends StateAdapter {

    public AwaitSelectionArchersTrack(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates goArchersAttack(String opcao) {

        getGameData().setDado(getGameData().getNumero());
        int dado = getGameData().getDado();
        dado += getGameData().getDrmArcher();
      
        if (opcao.toLowerCase().equals("wall")) {

            dado +=getGameData().getAttackWall();
      
            if (dado > getGameData().getEnemy().getWallnumber()) {

                getGameData().getEnemy().move(+1, opcao);
            }
        } else if (opcao.toLowerCase().equals("door")) {

            dado += getGameData().getAttackDoori();
      
            if (dado > getGameData().getEnemy().getDoornumber()) {
                getGameData().getEnemy().move(+1, opcao);
            }
        } else if (opcao.toLowerCase().equals("tower")) {
            dado += getGameData().getAttackTower();
            if (dado > getGameData().getEnemy().getTowernumber()) {
      
                getGameData().getEnemy().move(+1 , opcao);
            }
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
    }
}
