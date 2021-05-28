public class Array2D {
    public static void main(String[] args) {
        double[][] grid = {
                {0.1, 0.2, 0.3, 0.5},
                {1.1, 1.2, 1.3, 1.5},
                {3.1, 3.2, 3.3, 3.5}
        };

        System.out.print("{");
        for(int r = 0; r < grid.length; r++) {
            System.out.print("{");
            for(int c = 0; c < grid[r].length; c++) {
                grid[r][c] *= 2.0;
                System.out.print(grid[r][c]);

                if(c == grid.length) {
                    System.out.print("}");
                } else {
                    System.out.print(", ");
                }
            }

            if(r < grid.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");

        String[][] words = {
                {"this", "that"},
                {"and", "the"},
                {"other", "thing"}
        };

        for (String[] word : words) {
            for (String s : word) {
                System.out.println(s + ": " + s.length());
            }
        }



    }
}
