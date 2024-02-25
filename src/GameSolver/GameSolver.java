//IFT2015_TP2
//Jiadong Jin 20150692
package GameSolver;

import java.io.FileNotFoundException;

public class GameSolver {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "src/GameSolver/sample.txt";
        // Lire les matrices à partir du fichier
        int[][][] matrices = ReadMatrixFromFile.readMatricesFromFile(filePath);

        // Parcourir toutes les matrices
        for (int[][] matrix : matrices) {
            if (matrix != null) {
                // Résoudre le jeu pour chaque matrice
                System.out.println(solve(matrix));
                System.out.println();
            }
        }
    }

    private static int solve(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> zombies = new Queue<int[]>();

        // Initialiser la file d'attente avec les positions de tous les zombies
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 2) {
                    zombies.enqueue(new int[]{i, j});
                }
            }
        }

        // Effectuer une recherche en largeur à partir de la position de chaque zombie
        int iteration = 0;
        while (!zombies.isEmpty()) {
            // Afficher la matrice après chaque itération
            display(matrix);
            iteration++;
            int size = zombies.size();
            for (int i = 0; i < size; i++) {
                int[] point = zombies.dequeue();
                for (int j = 0; j < 4; j++) {
                    int new_x = point[0] + dx[j];
                    int new_y = point[1] + dy[j];
                    // Si la nouvelle position est valide et contient un humain, convertir l'humain en zombie
                    if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && matrix[new_x][new_y] == 1) {
                        matrix[new_x][new_y] = 2;
                        zombies.enqueue(new int[]{new_x, new_y});
                    }
                }
            }
        }

        // Vérifier s'il reste des humains
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 1) {
                    return -1;
                }
            }
        }

        // Retourner le nombre d'itérations nécessaires pour convertir tous les humains en zombies
        return iteration;
    }

    private static void display(int[][] matrix) {
        // Afficher la matrice
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
