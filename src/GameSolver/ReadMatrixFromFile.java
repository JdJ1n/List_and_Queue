package GameSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMatrixFromFile {

    public static int[][][] readMatricesFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        int numOfMatrices = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            numOfMatrices++;
        }
        scanner.close();

        int[][][] matrices = new int[numOfMatrices][][];

        scanner = new Scanner(new File(filePath));
        for (int count = 0; count < numOfMatrices; count++) {
            if (!scanner.hasNextInt()) break;
            int rows = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int cols = scanner.nextInt();

            matrices[count] = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!scanner.hasNextInt()) break;
                    matrices[count][i][j] = scanner.nextInt();
                }
            }
        }
        scanner.close();

        return matrices;
    }
}

