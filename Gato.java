/**
 * Archivo a modificar.
 * Modifica el código ASCII que representa a un camello y agrega una cola.
 * @author Fuentes Esquivel Elian Andrea 
 * @author Campos Mendoza Edgar Felipe       
 * @version 1.0                 
 * @date 14 oct
 *  2024.           
 */
import java.util.Scanner;

public class Gato {
    private char[][] tablero; // Tablero 3x3

    // Constructor por omisión, inicializa el tablero vacío con espacios
    public Gato() {
        tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Método para colocar una figura en el tablero, regresa true si la jugada es válida
    public boolean colocarFigura(int x, int y, char figura) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false; // Fuera de los límites del tablero
        }
        if (tablero[x][y] == ' ') {
            tablero[x][y] = figura; // Coloca la figura
            return true;
        } else {
            return false; // La posición ya está ocupada
        }
    }

    // Método que verifica si el juego ha terminado
    public boolean haTerminado() {
        // Verifica filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true; // Jugador ganó en una fila
            }
        }

        // Verifica columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                return true; // Jugador ganó en una columna
            }
        }

        // Verifica diagonales
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true; // Jugador ganó en la diagonal principal
        }
        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true; // Jugador ganó en la diagonal secundaria
        }

        // Verifica si el tablero está lleno (empate)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; // Aún hay casillas vacías
                }
            }
        }
        return true; // Empate
    }

    // Método para mostrar el resultado
    public void mostrarResultado() {
        // Verificar si hay un ganador
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                System.out.println("Felicidades jugador " + tablero[i][0] + ", ¡has ganado!");
                return;
            }
            if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                System.out.println("Felicidades jugador " + tablero[0][i] + ", ¡has ganado!");
                return;
            }
        }
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            System.out.println("Felicidades jugador " + tablero[0][0] + ", ¡has ganado!");
        } else if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            System.out.println("Felicidades jugador " + tablero[0][2] + ", ¡has ganado!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    // Método para mostrar el tablero en pantalla
    public void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    // Método main para ejecutar el juego
    public static void main(String[] args) {
        Gato juego = new Gato();
        Scanner scanner = new Scanner(System.in);
        char turno = 'X'; // Empieza el jugador 'X'

        while (!juego.haTerminado()) {
            juego.mostrarTablero();
            System.out.println("Jugador " + turno + ", ingresa la coordenada x y y (0-2):");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (juego.colocarFigura(x, y, turno)) {
                turno = (turno == 'X') ? 'O' : 'X'; // Cambia de turno
            } else {
                System.out.println("Movimiento inválido, intenta de nuevo.");
            }
        }

        juego.mostrarTablero();
        juego.mostrarResultado();
        scanner.close();
    }
}
