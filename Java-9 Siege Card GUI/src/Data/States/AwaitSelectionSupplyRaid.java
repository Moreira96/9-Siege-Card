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
public class AwaitSelectionSupplyRaid extends StateAdapter {

    public AwaitSelectionSupplyRaid(GameData gamedata) {
        super(gamedata);
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
            total = 1;

            if (total == 1) {
                getGameData().getForte().move(0, "tunnel");
                getGameData().getForte().move(0, "raid");
            }
            getGameData().setDado(total);
            getGameData().getPlayer().setActionPointAllowance(-1);
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
