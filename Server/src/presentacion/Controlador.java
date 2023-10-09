/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Estudiantes
 */
public class Controlador implements ActionListener {

    private String[][] tablero = new String[8][8];
    String[] posicionesPosibles;
    private char turnoJugador = 'A';
    private String posicionAntigua = null;
    private VistaTablero VistaTablero;
    private String posicionNueva = null;
    private String posicionActual;
    public static String fichaElegida;
    public static ImageIcon imagenElegida;

    public Controlador(VistaTablero athis) {
        iniciarTablero();
        VistaTablero = athis;
    }

    private void iniciarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = "";
            }
        }

        for (int i = 0; i < 8; i++) {
            tablero[1][i] = "B_peon";
            tablero[6][i] = "A_peon";
        }

        tablero[0][0] = "B_torre";
        tablero[0][1] = "B_caballo";
        tablero[0][2] = "B_alfil";
        tablero[0][3] = "B_reina";
        tablero[0][4] = "B_rey";
        tablero[0][5] = "B_alfil";
        tablero[0][6] = "B_caballo";
        tablero[0][7] = "B_torre";

        tablero[7][0] = "A_torre";
        tablero[7][1] = "A_caballo";
        tablero[7][2] = "A_alfil";
        tablero[7][3] = "A_reina";
        tablero[7][4] = "A_rey";
        tablero[7][5] = "A_alfil";
        tablero[7][6] = "A_caballo";
        tablero[7][7] = "A_torre";
    }

    private void cambiarFichas(String posAntigua, String posNueva) {
        cambiarEnString(posAntigua, posNueva);
        cambiarEnPantalla(posAntigua, posNueva);
    }

    private void cambiarEnString(String posAntigua, String posNueva) {
        int xA = Character.getNumericValue(posAntigua.charAt(1));
        int yA = Character.getNumericValue(posAntigua.charAt(0));

        int xN = Character.getNumericValue(posNueva.charAt(1));
        int yN = Character.getNumericValue(posNueva.charAt(0));

        tablero[yN][xN] = tablero[yA][xA];
        tablero[yA][xA] = "";
    }

    private void cambiarEnPantalla(String posAntigua, String posNueva) {
        boton(posNueva).setIcon(boton(posAntigua).getIcon());
        boton(posAntigua).setIcon(null);
    }

    private JButton boton(String posicion) {
        if (posicion.equals("00")) {
            return VistaTablero.c00;
        } else if (posicion.equals("01")) {
            return VistaTablero.c01;
        } else if (posicion.equals("02")) {
            return VistaTablero.c02;
        } else if (posicion.equals("03")) {
            return VistaTablero.c03;
        } else if (posicion.equals("04")) {
            return VistaTablero.c04;
        } else if (posicion.equals("05")) {
            return VistaTablero.c05;
        } else if (posicion.equals("06")) {
            return VistaTablero.c06;
        } else if (posicion.equals("07")) {
            return VistaTablero.c07;
        } else if (posicion.equals("10")) {
            return VistaTablero.c10;
        } else if (posicion.equals("11")) {
            return VistaTablero.c11;
        } else if (posicion.equals("12")) {
            return VistaTablero.c12;
        } else if (posicion.equals("13")) {
            return VistaTablero.c13;
        } else if (posicion.equals("14")) {
            return VistaTablero.c14;
        } else if (posicion.equals("15")) {
            return VistaTablero.c15;
        } else if (posicion.equals("16")) {
            return VistaTablero.c16;
        } else if (posicion.equals("17")) {
            return VistaTablero.c17;
        } else if (posicion.equals("20")) {
            return VistaTablero.c20;
        } else if (posicion.equals("21")) {
            return VistaTablero.c21;
        } else if (posicion.equals("22")) {
            return VistaTablero.c22;
        } else if (posicion.equals("23")) {
            return VistaTablero.c23;
        } else if (posicion.equals("24")) {
            return VistaTablero.c24;
        } else if (posicion.equals("25")) {
            return VistaTablero.c25;
        } else if (posicion.equals("26")) {
            return VistaTablero.c26;
        } else if (posicion.equals("27")) {
            return VistaTablero.c27;
        } else if (posicion.equals("30")) {
            return VistaTablero.c30;
        } else if (posicion.equals("31")) {
            return VistaTablero.c31;
        } else if (posicion.equals("32")) {
            return VistaTablero.c32;
        } else if (posicion.equals("33")) {
            return VistaTablero.c33;
        } else if (posicion.equals("34")) {
            return VistaTablero.c34;
        } else if (posicion.equals("35")) {
            return VistaTablero.c35;
        } else if (posicion.equals("36")) {
            return VistaTablero.c36;
        } else if (posicion.equals("37")) {
            return VistaTablero.c37;
        } else if (posicion.equals("40")) {
            return VistaTablero.c40;
        } else if (posicion.equals("41")) {
            return VistaTablero.c41;
        } else if (posicion.equals("42")) {
            return VistaTablero.c42;
        } else if (posicion.equals("43")) {
            return VistaTablero.c43;
        } else if (posicion.equals("44")) {
            return VistaTablero.c44;
        } else if (posicion.equals("45")) {
            return VistaTablero.c45;
        } else if (posicion.equals("46")) {
            return VistaTablero.c46;
        } else if (posicion.equals("47")) {
            return VistaTablero.c47;
        } else if (posicion.equals("50")) {
            return VistaTablero.c50;
        } else if (posicion.equals("51")) {
            return VistaTablero.c51;
        } else if (posicion.equals("52")) {
            return VistaTablero.c52;
        } else if (posicion.equals("53")) {
            return VistaTablero.c53;
        } else if (posicion.equals("54")) {
            return VistaTablero.c54;
        } else if (posicion.equals("55")) {
            return VistaTablero.c55;
        } else if (posicion.equals("56")) {
            return VistaTablero.c56;
        } else if (posicion.equals("57")) {
            return VistaTablero.c57;
        } else if (posicion.equals("60")) {
            return VistaTablero.c60;
        } else if (posicion.equals("61")) {
            return VistaTablero.c61;
        } else if (posicion.equals("62")) {
            return VistaTablero.c62;
        } else if (posicion.equals("63")) {
            return VistaTablero.c63;
        } else if (posicion.equals("64")) {
            return VistaTablero.c64;
        } else if (posicion.equals("65")) {
            return VistaTablero.c65;
        } else if (posicion.equals("66")) {
            return VistaTablero.c66;
        } else if (posicion.equals("67")) {
            return VistaTablero.c67;
        } else if (posicion.equals("70")) {
            return VistaTablero.c70;
        } else if (posicion.equals("71")) {
            return VistaTablero.c71;
        } else if (posicion.equals("72")) {
            return VistaTablero.c72;
        } else if (posicion.equals("73")) {
            return VistaTablero.c73;
        } else if (posicion.equals("74")) {
            return VistaTablero.c74;
        } else if (posicion.equals("75")) {
            return VistaTablero.c75;
        } else if (posicion.equals("76")) {
            return VistaTablero.c76;
        } else if (posicion.equals("77")) {
            return VistaTablero.c77;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (turnoJugador == 'A') {
            posicionActual = getBotonPosicionString(e.getSource());

            if (comprobarSiLaFichaEsBlanca(posicionActual)) {
                posicionAntigua = posicionActual;
            } else if (posicionAntigua != null) {
                posicionNueva = posicionActual;

                if (esPosibleEsteMovimiento(posicionAntigua, posicionNueva)) {
                    cambiarFichas(posicionAntigua, posicionNueva);
                    posicionNueva = null;
                    posicionAntigua = null;
                }
            }
        }
    }

    private boolean esPosibleEsteMovimiento(String posicionAntigua, String posicionNueva) {

        this.posicionesPosibles = VistaTablero.getModelo().moverFicha(tablero, posicionAntigua);

        for (int i = 0; i < this.posicionesPosibles.length; i++) {
            if (this.posicionesPosibles[i].equals(posicionNueva)) {
               // boton(this.posicionesPosibles[i]).setBackground(new java.awt.Color(176, 223, 198));
                return true;
            }
        }
        return false;

    }

    private String getBotonPosicionString(Object boton) {
        if (boton == VistaTablero.c00) {
            return "00";
        } else if (boton == VistaTablero.c01) {
            return "01";
        } else if (boton == VistaTablero.c02) {
            return "02";
        } else if (boton == VistaTablero.c03) {
            return "03";
        } else if (boton == VistaTablero.c04) {
            return "04";
        } else if (boton == VistaTablero.c05) {
            return "05";
        } else if (boton == VistaTablero.c06) {
            return "06";
        } else if (boton == VistaTablero.c07) {
            return "07";
        } else if (boton == VistaTablero.c10) {
            return "10";
        } else if (boton == VistaTablero.c11) {
            return "11";
        } else if (boton == VistaTablero.c12) {
            return "12";
        } else if (boton == VistaTablero.c13) {
            return "13";
        } else if (boton == VistaTablero.c14) {
            return "14";
        } else if (boton == VistaTablero.c15) {
            return "15";
        } else if (boton == VistaTablero.c16) {
            return "16";
        } else if (boton == VistaTablero.c17) {
            return "17";
        } else if (boton == VistaTablero.c20) {
            return "20";
        } else if (boton == VistaTablero.c21) {
            return "21";
        } else if (boton == VistaTablero.c22) {
            return "22";
        } else if (boton == VistaTablero.c23) {
            return "23";
        } else if (boton == VistaTablero.c24) {
            return "24";
        } else if (boton == VistaTablero.c25) {
            return "25";
        } else if (boton == VistaTablero.c26) {
            return "26";
        } else if (boton == VistaTablero.c27) {
            return "27";
        } else if (boton == VistaTablero.c30) {
            return "30";
        } else if (boton == VistaTablero.c31) {
            return "31";
        } else if (boton == VistaTablero.c32) {
            return "32";
        } else if (boton == VistaTablero.c33) {
            return "33";
        } else if (boton == VistaTablero.c34) {
            return "34";
        } else if (boton == VistaTablero.c35) {
            return "35";
        } else if (boton == VistaTablero.c36) {
            return "36";
        } else if (boton == VistaTablero.c37) {
            return "37";
        } else if (boton == VistaTablero.c40) {
            return "40";
        } else if (boton == VistaTablero.c41) {
            return "41";
        } else if (boton == VistaTablero.c42) {
            return "42";
        } else if (boton == VistaTablero.c43) {
            return "43";
        } else if (boton == VistaTablero.c44) {
            return "44";
        } else if (boton == VistaTablero.c45) {
            return "45";
        } else if (boton == VistaTablero.c46) {
            return "46";
        } else if (boton == VistaTablero.c47) {
            return "47";
        } else if (boton == VistaTablero.c50) {
            return "50";
        } else if (boton == VistaTablero.c51) {
            return "51";
        } else if (boton == VistaTablero.c52) {
            return "52";
        } else if (boton == VistaTablero.c53) {
            return "53";
        } else if (boton == VistaTablero.c54) {
            return "54";
        } else if (boton == VistaTablero.c55) {
            return "55";
        } else if (boton == VistaTablero.c56) {
            return "56";
        } else if (boton == VistaTablero.c57) {
            return "57";
        } else if (boton == VistaTablero.c60) {
            return "60";
        } else if (boton == VistaTablero.c61) {
            return "61";
        } else if (boton == VistaTablero.c62) {
            return "62";
        } else if (boton == VistaTablero.c63) {
            return "63";
        } else if (boton == VistaTablero.c64) {
            return "64";
        } else if (boton == VistaTablero.c65) {
            return "65";
        } else if (boton == VistaTablero.c66) {
            return "66";
        } else if (boton == VistaTablero.c67) {
            return "67";
        } else if (boton == VistaTablero.c70) {
            return "70";
        } else if (boton == VistaTablero.c71) {
            return "71";
        } else if (boton == VistaTablero.c72) {
            return "72";
        } else if (boton == VistaTablero.c73) {
            return "73";
        } else if (boton == VistaTablero.c74) {
            return "74";
        } else if (boton == VistaTablero.c75) {
            return "75";
        } else if (boton == VistaTablero.c76) {
            return "76";
        } else if (boton == VistaTablero.c77) {
            return "77";
        }
        return null;
    }

    private boolean comprobarSiLaFichaEsBlanca(String posicion) {
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        if (!tablero[y][x].equals("")) {
            return (tablero[y][x].charAt(0) == 'A') ? true : false;
        }
        return false;
    }

}
