/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author morei
 */
package Data.logica;

import java.io.Serializable;

public class EnemyStats implements Serializable {

    private int[] wall = new int[5];
    private int[] door = new int[5];
    private int[] tower = new int[5];
    private int wallnumber = 2;
    private int doornumber = 3;
    private int towernumber = 4;

    private boolean circuloWall = false;
    private boolean circuloDoor = false;
    private boolean circuloTower = false;

    private boolean combatWall = false;
    private boolean combatDoor = false;
    private boolean combatTower = false;

    private int closeCombat = 0; // NUMERO DE PECAS DENTRO DO CLOSE COMBAT;
    private int[] trebuchet = new int[4];
    private boolean combatArea = false;
    private boolean siegeTower = true;  //Existe um Evento que remove esta Torre

    public EnemyStats() {

        for (int i = 0; i < wall.length; i++) {
            if (i == wall.length - 1) {
                wall[i] = 1;
                door[i] = 1;
                tower[i] = 1;
            } else {
                wall[i] = 0;
                door[i] = 0;
                tower[i] = 0;
            }
        }

        for (int i = 0; i < trebuchet.length; i++) {
            if (i == trebuchet.length - 1) {
                trebuchet[i] = 1;
            } else {
                trebuchet[i] = 0;
            }
        }
        for (int i = 0; i < trebuchet.length; i++) {
            //   System.out.println("asd " + trebuchet[i]);
        }
    }

    public void setCloseCombat(int num) {
        closeCombat += num;
        if (num == 0) {
            closeCombat = 0;
        }
    }

    public int getCloseCombat() {
        return closeCombat;
    }

    public void setSiegeTower(boolean t) {
        siegeTower = t;
    }

    public int getWallnumber() {
        return wallnumber;
    }

    public int getDoornumber() {
        return doornumber;
    }

    public int getTowernumber() {
        return towernumber;
    }

    public boolean isCombatArea() {
        return combatArea;
    }

    public boolean isSiegeTower() {
        return siegeTower;
    }

    public int getPosicao(String qual) {
        if (qual.toLowerCase().equals("trebuchet")) {
            int index = 0;
            for (int i = 0; i < trebuchet.length; i++) {
                if (trebuchet[i] == 1) {

                    index = i;
                }

            }

            return index;
        } else if (qual.toLowerCase().equals("wall")) {
            int index = 0;
            for (int i = 0; i < wall.length; i++) {
                if (wall[i] == 1) {
                    index = i;
                }

            }

            return index;
        } else if (qual.toLowerCase().equals("door")) {
            int index = 0;
            for (int i = 0; i < door.length; i++) {
                if (door[i] == 1) {
                    index = i;
                }

            }

            return index;
        } else if (qual.toLowerCase().equals("tower")) {
            int index = 0;
            for (int i = 0; i < tower.length; i++) {
                if (tower[i] == 1) {
                    index = i;
                }

            }

            return index;
        } else {
            return 0;
        }
    }

    public int getWall(int i) {
        return wall[i];
    }

    public int[] getDoor() {
        return door;
    }

    public int[] getTower() {
        return tower;
    }

    public int[] getTrebuchet() {
        return trebuchet;
    }

    public boolean getCombatArea() {
        return combatArea;
    }

    //Move Recebe numero de casas a mover(avancar e recuar) e String com o nome do 'Caminho';
    public boolean move(int quanto, String qual) {

        int index = 0;
        int total;

        if (qual.isEmpty()) {
            System.out.println("vazio ");
            return false;
        }

        if (qual.toLowerCase().equals("wall")) {
            index = getPosicao("wall");
            total = index + quanto;
            //     System.out.println("total " + total +"= +index "+ index +" +quanto"+ quanto);

            for (int i = 0; i < wall.length; i++) {

                if (wall[i] == 1) {
                    wall[i] = 0;
                }

                if (total == i) {
                    wall[i] = 1;
                }

                if (total >= wall.length) {
                    wall[wall.length - 1] = 1;
                }
                if (total < 0) {
                    wall[0] = 1;
                }

            }

            if (total == 1) {
                System.out.println("Circulo");

            }

            if (total == 0) {

                setWallnumber(4);

                //   System.out.println(" \n Hugo " + wallnumber + "\n");
            }
            if (total != 0) {
                setWallnumber(2);
                //System.out.println(" \n Filipe " + wallnumber + "\n");
            }
            //  System.out.println("cheguei aqui");
            return true;
        } else if (qual.toLowerCase().equals("door".toLowerCase())) {
            index = 0;
            total = 0;
            index = getPosicao("door");

            total = index + quanto;

            for (int i = 0; i < door.length; i++) {
                if (door[i] == 1) {
                    door[i] = 0;
                }
                if (i == total) {
                    door[i] = 1;
                    //  System.out.println("estou a entrar aqui" +i);
                }
                if (total >= door.length) {
                    door[door.length - 1] = 1;
                }
                if (total < 0) {
                    door[0] = 1;
                }
            }
            if (total == 1) {
                System.out.println("Circulo");

            }

            if (total == 0) {

                setDoornumber(4);

            }
            if (total != 0) {
                setDoornumber(3);
              
                //   System.out.println(" \n Filipe " + doornumber + "\n");
            }
            return true;
        } else if (qual.equals("tower".toLowerCase())) {
            if (siegeTower == false) //Caso a Torre seja Removida
            {
                for (int i = 0; i < tower.length; i++) {
                    tower[i] = 0;
                }
                return false;
            }
            index = getPosicao("tower");
            total = 0;

            total = index + quanto;

            for (int i = 0; i < tower.length; i++) {
                if (tower[i] == 1) {
                    tower[i] = 0;
                }
                if (i == total) {
                    tower[i] = 1;
                }

                if (total >= tower.length) {
                    tower[tower.length - 1] = 1;
                }
                if (total < 0) {
                    tower[0] = 1;
                }
            }
            if (total == 1) {
                System.out.println("Circulo");

            }

            if (total == 0) {

                setTowernumber(4);

                // System.out.println(" \n Hugo " + towernumber + "\n");
            }
            if (total != 0) {
                setTowernumber(4);
                
                // System.out.println(" \n Filipe " + towernumber + "\n");
            }
            return true;
        } else if (qual.toLowerCase().equals("trebuchet")) {
            index = getPosicao("trebuchet");
            total = index + quanto;
            //System.out.println("total " + total +"= +index "+ index +" +quanto"+ quanto);

            for (int i = 0; i < trebuchet.length; i++) {

                if (trebuchet[i] == 1) {
                    trebuchet[i] = 0;
                }

                if (total == i) {
                    trebuchet[i] = 1;
                }
                if (total >= trebuchet.length) {
                    trebuchet[trebuchet.length - 1] = 1;
                }
                if (total < 0) {
                    trebuchet[0] = 1;
                }

            }

            return true;

        }
        return false;
    }

    @Override
    public String toString() {

        String s = "...";
        s += "\nWall \n";
        for (int pared : wall) {
            //   s+= "filipe";
            s += pared + " ";
        }

        s += "\nDoor\n";
        for (int dor : door) {
            s += dor + " ";
        }

        s += "\nTower \n";
        for (int tow : tower) {
            s += tow + " ";
        }

        s += "\nTRABUCOS \n";
        for (int tre : trebuchet) {

            s += tre + " ";
        }

        return s;//, morale=" + Arrays.toString(morale) + ", supplie=" + Arrays.toString(supplie) + ", raid=" + Arrays.toString(raid) + ", tunel=" + Arrays.toString(tunel) + '}';
    }

    public void setWallnumber(int wallnumber) {
        this.wallnumber = wallnumber;
    }

    public void setDoornumber(int doornumber) {
        this.doornumber = doornumber;
    }

    public void setTowernumber(int towernumber) {
        this.towernumber = towernumber;
    }

    public void adicionaWallNumero(int numb) {
        this.wallnumber += numb;
    }

    public void adicionaDoorNumero(int numb) {
        this.doornumber += numb;
    }

    public void adicionaTowerNumero(int numb) {
        this.towernumber += numb;
    }

    public boolean isCirculoWall() {
        return circuloWall;
    }

    public void setCirculoWall(boolean circuloWall) {
        this.circuloWall = circuloWall;
    }

    public boolean isCirculoDoor() {
        return circuloDoor;
    }

    public void setCirculoDoor(boolean circuloDoor) {
        this.circuloDoor = circuloDoor;
    }

    public boolean isCirculoTower() {
        return circuloTower;
    }

    public void setCirculoTower(boolean circuloTower) {
        this.circuloTower = circuloTower;
    }

    public boolean isCombatWall() {
        return combatWall;
    }

    public void setCombatWall(boolean combatWall) {
        this.combatWall = combatWall;
    }

    public boolean isCombatDoor() {
        return combatDoor;
    }

    public void setCombatDoor(boolean combatDoor) {
        this.combatDoor = combatDoor;
    }

    public boolean isCombatTower() {
        return combatTower;
    }

    public void setCombatTower(boolean combatTower) {
        this.combatTower = combatTower;
    }

}
