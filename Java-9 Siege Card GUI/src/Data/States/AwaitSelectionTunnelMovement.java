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
public class AwaitSelectionTunnelMovement extends StateAdapter {

    public AwaitSelectionTunnelMovement(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates goTunnelMovement(String opcao) {
        boolean flag = false;
        if (getGameData().getForte().isCastle() == true) {
            int aux = getGameData().getPlayer().getActionPointAllowance() - 1;
            getGameData().getPlayer().setActionPointAllowance(aux);

            if (opcao.equals("free")) {
                getGameData().getForte().move(+1, "tunnel");
            } else if (opcao.equals("fast")) {
                getGameData().getForte().move(+3, "tunnel");
                aux = getGameData().getPlayer().getActionPointAllowance() - 1;
                getGameData().getPlayer().setActionPointAllowance(aux);
            }   
            else if(opcao.equals("automatic"))
                        {
                             aux = getGameData().getPlayer().getActionPointAllowance() - 1;
                getGameData().getPlayer().setActionPointAllowance(aux);
            
                            getGameData().getForte().move(0, "tunnel");
                            if(getGameData().getForte().getPosicao("raid")==1)
                            {
                                                  getGameData().getForte().move(+1, "supplie");
                            }
                            else
                             if(getGameData().getForte().getPosicao("raid")==2)
                            {
                                                  getGameData().getForte().move(+2, "supplie");
                            }
                            getGameData().getForte().move(0, "raid");
                            
                        }
            

        }

        if (getGameData().getPlayer().getActionPointAllowance() <= 0) {

            return new AwaitDrawCard(getGameData());

        }

        getGameData().VerificaCombateArea();
        getGameData().verificaCirculo();

        return new AwaitAction(getGameData());
    }

}
