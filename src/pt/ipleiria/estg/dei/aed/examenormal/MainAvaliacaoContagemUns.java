package pt.ipleiria.estg.dei.aed.examenormal;

public class MainAvaliacaoContagemUns {

    public MainAvaliacaoContagemUns() {
        int[][] matriz = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0}
        };

        System.out.println("Número de uns na matriz: " + getNumeroUns(matriz));
    }

    private int getNumeroUns(int[][] matriz) {
//        throw new RuntimeException("Por implementar.");
        int total = 0;

        for (int y = 0; y < matriz.length; y++)
            total += binarySearch(matriz[y], 0, matriz[y].length - 1);

        return total;
    }

    private int binarySearch(int[] row, int right, int left)
    {
        if (left < right) return 0;

        int mid = (right + left) / 2;

        if (row[mid] == 1)
        {
            if (mid == left || row[mid + 1] == 0)
                return mid + 1;

            return binarySearch(row, mid + 1, left);
        }

        return binarySearch(row, right, mid - 1);
    }

    public static void main(String[] args) {
        new MainAvaliacaoContagemUns();
    }
}








