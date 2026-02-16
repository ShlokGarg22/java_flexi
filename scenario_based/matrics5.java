public class SpiralSimple {
    public static void main(String[] args) {

        int n = 5;
        int[][] matrix = new int[n][n];

        int row = 0, col = 0;
        String direction = "right";

        for (int num = 1; num <= n * n; num++) {

            matrix[row][col] = num;

            // Check next move
            if (direction.equals("right")) {
                if (col + 1 == n || matrix[row][col + 1] != 0) {
                    direction = "down";
                    row++;
                } else {
                    col++;
                }
            }

            else if (direction.equals("down")) {
                if (row + 1 == n || matrix[row + 1][col] != 0) {
                    direction = "left";
                    col--;
                } else {
                    row++;
                }
            }

            else if (direction.equals("left")) {
                if (col - 1 < 0 || matrix[row][col - 1] != 0) {
                    direction = "up";
                    row--;
                } else {
                    col--;
                }
            }

            else if (direction.equals("up")) {
                if (row - 1 < 0 || matrix[row - 1][col] != 0) {
                    direction = "right";
                    col++;
                } else {
                    row--;
                }
            }
        }

        // Print
        for (int[] r : matrix) {
            for (int val : r)
                System.out.printf("%3d ", val);
            System.out.println();
        }
    }
}
