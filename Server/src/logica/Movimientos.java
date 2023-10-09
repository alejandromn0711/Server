/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Estudiantes
 */
public class Movimientos {

    String[][] tablero;

    public String[] moverFicha(String[][] tablero, String posicion) {
        this.tablero = tablero;
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));

        String ficha = fichaDeLaCasilla(x, y);

        if (ficha.equals("A_peon")) {

        }
        return movimientoPeonA(y, x);
    }

    public String fichaDeLaCasilla(int x, int y) {
        return tablero[y][y];
    }

    private String[]  movimientoPeonA(int y, int x) {
        String posicionesPosibles = "";

        if (tablero[y - 1][x].equals("")) {
            posicionesPosibles += "" + (y - 1) + x + "_";
        }
        try {
            if (comprobarSiLaFichaEsnegra(y - 1, x + 1)) {
                posicionesPosibles += "" + (y - 1) + (x + 1) + "_";
            }
            if (comprobarSiLaFichaEsnegra(y - 1, x + 1)) {
                posicionesPosibles += "" + (y - 1) + (x - 1) + "_";
            }
        } catch (Exception ex) {
            System.out.println("ERRORSAZO");
        }

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");

        return arrayPosicionesPosibles;

    }

    private boolean comprobarSiLaFichaEsnegra(int x, int y) {
        if (!tablero[y][x].equals("")) {
            return (tablero[y][x].charAt(0) == 'A') ? true : false;
        }
        return false;
    }

}
