

public class Main {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 0},
                {0, 0, 1}
        };

        SurvivalGame game = new SurvivalGame(grid);
        int iterations = game.play();
        System.out.print("Nombre d'itérations nécessaires pour infecter toutes les personnes non immunisées : " + iterations);
    }


}
