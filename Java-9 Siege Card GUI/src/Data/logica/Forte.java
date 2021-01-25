/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.logica;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Filipe Ribeiro
 */
public class Forte implements Serializable {

    private int[] wall = new int[5];
    private int[] morale = new int[5];
    private int[] supplie = new int[5];
    private int[] raid = new int[3];
    private int[] tunel = new int[4];

    private boolean Castle = true;
    private int contaStatus = 0;

    Forte() {
//        preenchedados();

        for (int i = 0; i < wall.length; i++) {
            if (i == wall.length - 1) {
                wall[i] = 1;
                morale[i] = 1;
                supplie[i] = 1;

            } else {
                wall[i] = 0;
                morale[i] = 0;
                supplie[i] = 0;
            }
        }

        for (int i = 0; i < raid.length; i++) {
            if (i == 0) {
                raid[i] = 1;
            } else {
                raid[i] = 0;
            }

        }
        for (int i = 0; i < tunel.length; i++) {
            if (i == 0) {
                tunel[i] = 1;
            } else {
                tunel[i] = 0;
            }
        }
    }

    public boolean move(int quanto, String qual) {
        int index = 0;
        int total = 0;

        if (qual.isEmpty()) {
            System.out.println("vazio ");
            return false;
        }

        if (qual.toLowerCase().equals("wall")) {
            index = getPosicao("wall");
            total = 0;

            total = index + quanto;

            for (int i = 0; i < wall.length; i++) {
                if (wall[i] == 1) {
                    //    System.out.println("index" + index);
                    wall[i] = 0;
                }
                if (i == total) {
                    //         System.out.println("total "+ total + "i =  " + i );
                    wall[i] = 1;
                }
                if (total >= wall.length) {
                    wall[wall.length - 1] = 1;
                }
                if (total < 0) {
                    wall[0] = 1;
                }
            }
            return true;

        } else if (qual.toLowerCase().equals("morale")) {
            index = getPosicao("morale");
            total = 0;
            for (int i = 0; i < morale.length; i++) {
                if (morale[i] == 1) {
                    index = i;
                    //      System.out.println("encontro me aqui" + index);
                }

            }
            total = index + quanto;

            for (int i = 0; i < morale.length; i++) {
                if (morale[i] == 1) {
                    morale[i] = 0;
                }
                if (i == total) {
                    morale[i] = 1;
                }
                if (total >= morale.length) {
                    morale[morale.length - 1] = 1;
                }
                if (total < 0) {
                    morale[0] = 1;
                }

            }
            return true;

        } else if (qual.equals("supplie")) {
            index = getPosicao("supplie");
            total = 0;
            for (int i = 0; i < supplie.length; i++) {
                if (supplie[i] == 1) {
                    index = i;
                    //      System.out.println("encontro me aqui" + index);
                }

            }
            total = index + quanto;

            for (int i = 0; i < supplie.length; i++) {
                if (supplie[i] == 1) {
                    supplie[i] = 0;
                }
                if (i == total) {
                    supplie[i] = 1;
                }
                if (total >= supplie.length) {
                    supplie[supplie.length - 1] = 1;
                }
                if (total < 0) {
                    supplie[0] = 1;
                }
            }
            return true;

        } else if (qual.equals("tunnel")) {
            index = getPosicao("tunnel");
            total = 0;

            total = index + quanto;
            //   System.out.println("TOTAL" +total);

            if (quanto == 0) {
//System.out.println("index "+ index);
                for (int i = 0; i < tunel.length; i++) {

                    {
                        if (i == 0) {
                            tunel[i] = 1;
                        } else {

                            tunel[i] = 0;
                            //  return true ;
                        }
                    }
                }
            } else {
                for (int i = 0; i < tunel.length; i++) {
                    if (tunel[i] == 1) {
                        tunel[i] = 0;
                    }
                    if (i == total) {
                        tunel[i] = 1;
                    }
                    if (total >= tunel.length) {
                        tunel[tunel.length - 1] = 1;
                    }
                    if (total < 0) {
                        tunel[0] = 1;
                    }

                    if (i == 0 || i == tunel.length - 1) {
                        setCastle(true);
                    } else {
                        setCastle(false);
                    }
                }
            }
            return true;
        } else if (qual.toLowerCase().equals("raid")) {
            index = 0;
            //  int flag=0 ;
            index = getPosicao("raid");
            total = index + quanto;

            if (quanto == 0) {

                for (int i = 0; i < raid.length; i++) {

                    {
                        if (i == 0) {
                            raid[i] = 1;
                        } else {

                            raid[i] = 0;
                            //  return true ;
                        }
                    }
                }
            } else {
                for (int i = 0; i < raid.length; i++) {

                    if (raid[i] == 1) {
                        raid[i] = 0;
                    }

                    if (total == i) {
                        raid[i] = 1;
                    }

                    if (total >= raid.length) {
                        raid[raid.length - 1] = 1;
                    }
                    if (total < 0) {
                        raid[0] = 1;
                    }

                }
            }
            return true;

        }

        return false;

    }

    public int[] getWall() {
        return wall;
    }

    public int[] getMorale() {
        return morale;
    }

    public int[] getSupplie() {
        return supplie;
    }

    public int[] getRaid() {
        return raid;
    }

    public int[] getTunel() {
        return tunel;
    }

    public int getPosicao(String qual) {

        if (qual.toLowerCase().equals("wall")) {
            int index = 0;
            for (int i = 0; i < wall.length; i++) {
                if (wall[i] == 1) {
                    index = i;
                }

            }

            return index;
        } else if (qual.toLowerCase().equals("morale")) {
            int index = 0;
            for (int i = 0; i < morale.length; i++) {
                if (morale[i] == 1) {
                    index = i;
                }

            }

            return index;
        } else if (qual.toLowerCase().equals("supplie")) {
            int index = 0;
            for (int i = 0; i < supplie.length; i++) {
                if (supplie[i] == 1) {
                    index = i;
                }

            }

            return index;
        } else if (qual.toLowerCase().equals("tunnel")) {
            int index = 0;
            for (int i = 0; i < tunel.length; i++) {
                if (tunel[i] == 1) {
                    index = i;
                }
            }

            return index;
        } else if (qual.toLowerCase().equals("raid")) {
            int index = 0;
            for (int i = 0; i < raid.length; i++) {
                if (raid[i] == 1) {
                    index = i;
                }

            }

            return index;

        }

        return 0;
    }

    public int getTunnel() {
        int index = 0;
        for (int i = 0; i < tunel.length; i++) {
            if (tunel[i] == 1) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        String s = "...";
        s += "\nWall \n";
        for (int pared : wall) {
            //   s+= "filipe"o

            s += pared + " ";
        }

        s += "\nMorale\n";
        for (int mor : morale) {

            s += mor + " ";
        }

        s += "\nSupplies \n";
        for (int supl : supplie) {
            s += supl + " ";
        }

        s += "\nRaid \n";
        for (int rai : raid) {

            s += rai + " ";
        }

        s += "\nTunel \n";
        for (int tun : tunel) {
            s += tun + " ";
        }

        return s;//, morale=" + Arrays.toString(morale) + ", supplie=" + Arrays.toString(supplie) + ", raid=" + Arrays.toString(raid) + ", tunel=" + Arrays.toString(tunel) + '}';
    }

    public boolean isCastle() {
        return Castle;
    }

    public void setCastle(boolean Castle) {
        this.Castle = Castle;
    }

    public int getContaStatus() {
        return contaStatus;
    }

    public void setContaStatus(int contaStatus) {
        this.contaStatus += contaStatus;

        if (contaStatus == 0) {
            this.contaStatus = 0;
        }
    }

}
