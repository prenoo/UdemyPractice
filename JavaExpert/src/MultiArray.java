public class MultiArray {

    public static void main(String[] args) {

        int[][] data = {
                {40,2,3,12},
                {10,34,2,93,22,12},
                {8, 84, 3, 7, 12}
        };


        System.out.println("Number of rows: " + data.length);
        System.out.println("Number of columns: " + data[0].length); //only works if every row has the same column

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) { //data[i].length will work with different column numbers
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

    }
}
