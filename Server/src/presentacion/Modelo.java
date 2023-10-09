package presentacion;

import logica.Servidor;
import logica.Movimientos;

public class Modelo {

    private Servidor appServidor;
    private VistaTablero miVentana;
    private Movimientos movimientos;

    public VistaTablero getMiVentana() {
        if (miVentana == null) {
            miVentana = new VistaTablero(this);
        }
        return miVentana;
    }

    String[][] tablero;

    public String[] moverFicha(String[][] tablero, String posicion) {
        this.tablero = tablero;
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));

        String ficha = fichaDeLaCasilla(y, x);

        if (ficha.equals("A_peon")) {
            return movimientoPeonA(y, x);
        } else if (ficha.equals("B_peon")) {
            return movimientoPeonB(y, x);
        } else if (ficha.equals("A_caballo")) {
            return movimientoCaballoA(y, x);
        } else if (ficha.equals("B_caballo")) {
            return movimientoCaballoB(y, x);
        } else if (ficha.equals("A_torre")) {
            return movimientoTorreA(y, x);
        } else if (ficha.equals("B_torre")) {
            return movimientoTorreB(y, x);
        } else if (ficha.equals("A_alfil")) {
            return movimientoAlfilA(y, x);
        } else if (ficha.equals("B_alfil")) {
            return movimientoAlfilB(y, x);
        } else if (ficha.equals("A_reina")) {
            return movimientoReinaA(y, x);
        } else if (ficha.equals("B_reina")) {
            return movimientoReinaB(y, x);
        } else if (ficha.equals("A_rey")) {
            return movimientoReyA(y, x);
        } else if (ficha.equals("B_rey")) {
            return movimientoReyB(y, x);
        }
        return null;
    }

    public String fichaDeLaCasilla(int y, int x) {
        return tablero[y][x];
    }

    private String[] movimientoPeonA(int y, int x) {
        String posicionesPosibles = "";

        if (tablero[y - 1][x].equals("")) {
            posicionesPosibles += "" + (y - 1) + x + "_";
        }
        try {
            if (comprobarSiLaFichaEsnegra(y - 1, x + 1)) {
                posicionesPosibles += "" + (y - 1) + (x + 1) + "_";
            }
            if (comprobarSiLaFichaEsnegra(y - 1, x - 1)) {
                posicionesPosibles += "" + (y - 1) + (x - 1) + "_";
            }
        } catch (Exception ex) {
            System.err.println("ERRORSAZO");
        }

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");

        return arrayPosicionesPosibles;

    }

    private String[] movimientoPeonB(int y, int x) {
        String posicionesPosibles = "";

        if (tablero[y - 1][x].equals("")) {
            posicionesPosibles += "" + (y + 1) + x + "_";
        }
        try {
            if (comprobarSiLaFichaEsBlanca(y + 1, x + 1)) {
                posicionesPosibles += "" + (y + 1) + (x + 1) + "_";
            }
            if (comprobarSiLaFichaEsBlanca(y + 1, x - 1)) {
                posicionesPosibles += "" + (y + 1) + (x - 1) + "_";
            }
        } catch (Exception ex) {
            System.err.println("ERRORSAZO");
        }

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");

        return arrayPosicionesPosibles;

    }

    private String[] movimientoCaballoA(int y, int x) {
        String posicionesPosibles = "";
        try {
//Ariba Izquierda
            if (tablero[y - 2][x - 1].equals("") || comprobarSiLaFichaEsnegra(y - 2, x - 1)) {
                posicionesPosibles += "" + (y - 2) + "" + (x - 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            //Arriba Derecha
            if (tablero[y - 2][x + 1].equals("") || comprobarSiLaFichaEsnegra(y - 2, x - 1)) {
                posicionesPosibles += "" + (y - 2) + "" + (x + 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Abajo Izquierda
            if (tablero[y + 2][x - 1].equals("") || comprobarSiLaFichaEsnegra(y - 2, x - 1)) {
                posicionesPosibles += "" + (y + 2) + "" + (x - 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Abajo Derecha
            if (tablero[y + 2][x + 1].equals("") || comprobarSiLaFichaEsnegra(y - 2, x - 1)) {
                posicionesPosibles += "" + (y + 2) + "" + (x + 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Izquierda Arriba
            if (tablero[y - 1][x - 2].equals("") || comprobarSiLaFichaEsnegra(y - 1, x - 2)) {
                posicionesPosibles += "" + (y - 1) + "" + (x - 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Izquierda Abajo
            if (tablero[y + 1][x - 2].equals("") || comprobarSiLaFichaEsnegra(y + 1, x - 2)) {
                posicionesPosibles += "" + (y + 1) + "" + (x - 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            //  Derecha Arriba
            if (tablero[y - 1][x + 2].equals("") || comprobarSiLaFichaEsnegra(y - 1, x + 2)) {
                posicionesPosibles += "" + (y - 1) + "" + (x + 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Derecha Abajo
            if (tablero[y + 1][x + 2].equals("") || comprobarSiLaFichaEsnegra(y + 1, x + 2)) {
                posicionesPosibles += "" + (y + 1) + "" + (x + 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }

    private String[] movimientoCaballoB(int y, int x) {
        String posicionesPosibles = "";
        try {
            //Ariba Izquierda
            if (tablero[y - 2][x - 1].equals("") || comprobarSiLaFichaEsBlanca(y - 2, x - 1)) {
                posicionesPosibles += "" + (y - 2) + "" + (x - 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            //Arriba Derecha
            if (tablero[y - 2][x + 1].equals("") || comprobarSiLaFichaEsBlanca(y - 2, x - 1)) {
                posicionesPosibles += "" + (y - 2) + "" + (x + 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Abajo Izquierda
            if (tablero[y + 2][x - 1].equals("") || comprobarSiLaFichaEsBlanca(y - 2, x - 1)) {
                posicionesPosibles += "" + (y + 2) + "" + (x - 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Abajo Derecha
            if (tablero[y + 2][x + 1].equals("") || comprobarSiLaFichaEsBlanca(y - 2, x - 1)) {
                posicionesPosibles += "" + (y + 2) + "" + (x + 1) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Izquierda Arriba
            if (tablero[y - 1][x - 2].equals("") || comprobarSiLaFichaEsBlanca(y - 1, x - 2)) {
                posicionesPosibles += "" + (y - 1) + "" + (x - 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Izquierda Abajo
            if (tablero[y + 1][x - 2].equals("") || comprobarSiLaFichaEsBlanca(y + 1, x - 2)) {
                posicionesPosibles += "" + (y + 1) + "" + (x - 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            //  Derecha Arriba
            if (tablero[y - 1][x + 2].equals("") || comprobarSiLaFichaEsBlanca(y - 1, x + 2)) {
                posicionesPosibles += "" + (y - 1) + "" + (x + 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }
        try {
            // Derecha Abajo
            if (tablero[y + 1][x + 2].equals("") || comprobarSiLaFichaEsBlanca(y + 1, x + 2)) {
                posicionesPosibles += "" + (y + 1) + "" + (x + 2) + "_";
            }
        } catch (Exception e) {
            System.err.println("Error Caballo");
        }

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }

    private String[] movimientoTorreA(int y, int x) {
        String posicionesPosibles = "";
        int i;
        boolean seguir;
        // Movimiento Abajo
        seguir = true;
        i = y;
        do {
            i++;
            try {
                if (tablero[i][x].equals("")) {
                    posicionesPosibles += "" + i + x + "_";
                } else if (comprobarSiLaFichaEsnegra(i, x)) {
                    posicionesPosibles += "" + i + x + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsBlanca(i, x)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Arriba
        seguir = true;
        i = y;
        do {
            i--;
            try {
                if (tablero[i][x].equals("")) {
                    posicionesPosibles += "" + i + x + "_";
                } else if (comprobarSiLaFichaEsnegra(i, x)) {
                    posicionesPosibles += "" + i + x + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsBlanca(i, x)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Izquierda
        seguir = true;
        i = x;
        do {
            i--;
            try {
                if (tablero[y][i].equals("")) {
                    posicionesPosibles += "" + y + i + "_";
                } else if (comprobarSiLaFichaEsnegra(y, i)) {
                    posicionesPosibles += "" + y + i + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsBlanca(y, i)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Derecha
        seguir = true;
        i = x;
        do {
            i++;
            try {
                if (tablero[y][i].equals("")) {
                    posicionesPosibles += "" + y + i + "_";
                } else if (comprobarSiLaFichaEsnegra(y, i)) {
                    posicionesPosibles += "" + y + i + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsBlanca(y, i)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }

    private String[] movimientoTorreB(int y, int x) {
        String posicionesPosibles = "";
        int i;
        boolean seguir;
        // Movimiento Abajo
        seguir = true;
        i = y;
        do {
            i++;
            try {
                if (tablero[i][x].equals("")) {
                    posicionesPosibles += "" + i + x + "_";
                } else if (comprobarSiLaFichaEsBlanca(i, x)) {
                    posicionesPosibles += "" + i + x + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsnegra(i, x)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Arriba
        seguir = true;
        i = y;
        do {
            i--;
            try {
                if (tablero[i][x].equals("")) {
                    posicionesPosibles += "" + i + x + "_";
                } else if (comprobarSiLaFichaEsBlanca(i, x)) {
                    posicionesPosibles += "" + i + x + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsnegra(i, x)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Abajo
        seguir = true;
        i = x;
        do {
            i--;
            try {
                if (tablero[y][i].equals("")) {
                    posicionesPosibles += "" + y + i + "_";
                } else if (comprobarSiLaFichaEsBlanca(y, i)) {
                    posicionesPosibles += "" + y + i + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsnegra(y, i)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Derecha
        seguir = true;
        i = x;
        do {
            i++;
            try {
                if (tablero[y][i].equals("")) {
                    posicionesPosibles += "" + y + i + "_";
                } else if (comprobarSiLaFichaEsBlanca(y, i)) {
                    posicionesPosibles += "" + y + i + "_";
                    seguir = false;
                } else if (comprobarSiLaFichaEsnegra(y, i)) {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }

    private String[] movimientoAlfilA(int y, int x) {
        String posicionesPosibles = "";
        int i;
        boolean seguir;
        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i++;
            try {
                if (tablero[y + i][x + i].equals("")) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsnegra(y + i, x + i)) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i--;
            try {
                if (tablero[y + i][x + i].equals("")) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsnegra(y + i, x + i)) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i++;
            try {
                if (tablero[y - i][x + i].equals("")) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsnegra(y - i, x + i)) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i--;
            try {
                if (tablero[y - i][x + i].equals("")) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsnegra(y - i, x + i)) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }

    private String[] movimientoAlfilB(int y, int x) {
        String posicionesPosibles = "";
        int i;
        boolean seguir;
        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i++;
            try {
                if (tablero[y + i][x + i].equals("")) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsBlanca(y + i, x + i)) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i--;
            try {
                if (tablero[y + i][x + i].equals("")) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsBlanca(y + i, x + i)) {
                    posicionesPosibles += "" + (y + i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i++;
            try {
                if (tablero[y - i][x + i].equals("")) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsBlanca(y - i, x + i)) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        // Movimiento Der-Abajo
        seguir = true;
        i = 0;
        do {
            i--;
            try {
                if (tablero[y - i][x + i].equals("")) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                } else if (comprobarSiLaFichaEsBlanca(y - i, x + i)) {
                    posicionesPosibles += "" + (y - i) + (x + i) + "_";
                    seguir = false;
                } else {
                    seguir = false;
                }
            } catch (Exception ex) {
                seguir = false;
            }

        } while (seguir);

        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }

    private String[] movimientoReinaA(int y, int x) {
        String[] movimientoDiagonal = movimientoAlfilA(y, x);
        String[] movimientoRecto = movimientoTorreA(y, x);

        int numeroPosiciones = movimientoDiagonal.length + movimientoRecto.length;

        String[] movimientosReina = new String[numeroPosiciones];

        int n = 0;

        for (int i = 0; i < movimientoDiagonal.length; i++) {
            movimientosReina[n] = movimientoDiagonal[i];
            n++;
        }

        for (int i = 0; i < movimientoRecto.length; i++) {
            movimientosReina[n] = movimientoRecto[i];
            n++;
        }

        return movimientosReina;
    }

    private String[] movimientoReinaB(int y, int x) {
        String[] movimientoDiagonal = movimientoAlfilB(y, x);
        String[] movimientoRecto = movimientoTorreB(y, x);

        int numeroPosiciones = movimientoDiagonal.length + movimientoRecto.length;

        String[] movimientosReina = new String[numeroPosiciones];

        int n = 0;

        for (int i = 0; i < movimientoDiagonal.length; i++) {
            movimientosReina[n] = movimientoDiagonal[i];
            n++;
        }

        for (int i = 0; i < movimientoRecto.length; i++) {
            movimientosReina[n] = movimientoRecto[i];
            n++;
        }

        return movimientosReina;
    }

    private String[] movimientoReyA(int y, int x) {

        String posicionesPosibles = "";

        try {
            if (comprobarSiLaFichaEsBlanca(y - 1, x - 1) == false) {
                posicionesPosibles += "" + (y - 1) + "" + (x - 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsBlanca(y - 1, x) == false) {
                posicionesPosibles += "" + (y - 1) + "" + (x) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsBlanca(y - 1, x + 1) == false) {
                posicionesPosibles += "" + (y - 1) + "" + (x + 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsBlanca(y, x - 1) == false) {
                posicionesPosibles += "" + (y) + "" + (x - 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsBlanca(y, x + 1) == false) {
                posicionesPosibles += "" + (y) + "" + (x + 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsBlanca(y + 1, x - 1) == false) {
                posicionesPosibles += "" + (y + 1) + "" + (x - 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsBlanca(y + 1, x) == false) {
                posicionesPosibles += "" + (y + 1) + "" + (x) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsBlanca(y + 1, x + 1) == false) {
                posicionesPosibles += "" + (y + 1) + "" + (x + 1) + "_";
            }
        } catch (Exception ex) {
        }
        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }
    
        private String[] movimientoReyB(int y, int x) {

        String posicionesPosibles = "";

        try {
            if (comprobarSiLaFichaEsnegra(y - 1, x - 1) == false) {
                posicionesPosibles += "" + (y - 1) + "" + (x - 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsnegra(y - 1, x) == false) {
                posicionesPosibles += "" + (y - 1) + "" + (x) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsnegra(y - 1, x + 1) == false) {
                posicionesPosibles += "" + (y - 1) + "" + (x + 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsnegra(y, x - 1) == false) {
                posicionesPosibles += "" + (y) + "" + (x - 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsnegra(y, x + 1) == false) {
                posicionesPosibles += "" + (y) + "" + (x + 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsnegra(y + 1, x - 1) == false) {
                posicionesPosibles += "" + (y + 1) + "" + (x - 1) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsnegra(y + 1, x) == false) {
                posicionesPosibles += "" + (y + 1) + "" + (x) + "_";
            }
        } catch (Exception ex) {
        }

        try {
            if (comprobarSiLaFichaEsnegra(y + 1, x + 1) == false) {
                posicionesPosibles += "" + (y + 1) + "" + (x + 1) + "_";
            }
        } catch (Exception ex) {
        }
        String[] arrayPosicionesPosibles = posicionesPosibles.split("_");
        return arrayPosicionesPosibles;
    }

    private boolean comprobarSiLaFichaEsnegra(int x, int y) {
        if (!tablero[y][x].equals("")) {
            return (tablero[y][x].charAt(0) == 'B') ? true : false;
        }
        return false;
    }

    private boolean comprobarSiLaFichaEsBlanca(int x, int y) {
        if (!tablero[y][x].equals("")) {
            return (tablero[y][x].charAt(0) == 'A') ? true : false;
        }
        return false;
    }

    public Servidor getAppServidor() {
        if (appServidor == null) {
            appServidor = new Servidor();
        }
        return appServidor;
    }

    public void iniciarApp() {
        getMiVentana().setVisible(true);
        getMiVentana().setResizable(false);
    }

    public void iniciar() {
        getAppServidor().activar(true);
        // getAppServidor().escucharClientes();
        getAppServidor().activar(false);
    }
}
