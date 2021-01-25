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
public class AwaitDrawCard extends StateAdapter {

    public AwaitDrawCard(GameData gamedata) {
        super(gamedata);
    }

    @Override
    public IStates drawCard() {
      getGameData().baralha();
        getGameData().validamovimento();
        getGameData().verificaCirculo();
        getGameData().VerificaCombateArea();
        getGameData().ContaStatusTrack();
        getGameData().victoryorlosscheckpoint();
        
        if (getGameData().isEndgame() == true) {
            return new AwaitAcabou(getGameData());
        } else if (getGameData().isVictory() == true) {
            return new AwaitAcabou(getGameData());
        }
        getGameData().fimDia();
        getGameData().fimTurno();

        /// começa A nova Ronda!
        getGameData().EnemyLineCheck("");

        getGameData().setcartaActual((getGameData().getCards().get(0)));
        getGameData().adicionaCartaUsada(getGameData().getCartaActua());
        getGameData().remove(getGameData().getCartaActua());

        getGameData().aplicaFigurasCarta(getGameData().getCartaActua());
        if (getGameData().getCartaActua().isTrebuchet() != true) {
            if (getGameData().getCartaActua().isSword() == true) {

                getGameData().slowestUnitMovement();
            } else {
                getGameData().regularMovement();
            }
        }

        getGameData().validamovimento();
        getGameData().aplicaEventoCarta(getGameData().getCartaActua());

        getGameData().verificaCirculo();
        getGameData().VerificaCombateArea();
        getGameData().ContaStatusTrack();
   
        if (getGameData().getEndGame() == true) {
            return new AwaitAcabou(getGameData());
        }
        return new AwaitAction(getGameData());
    }
}
