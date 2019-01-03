/*
 * Probando matrices numericas. 
 */
package matrices;

import javax.swing.JOptionPane;

/**
 *
 * @author cainu
 */
public class Matrices {

    public static void printMatrix(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" | ");
                System.out.print(matriz[i][j]);
                if (j == matriz[i].length - 1) {
                    System.out.print(" |");
                }

            }
            System.out.println("");

        }

    }

    /**
     *
     * a matrix will be symmetric if it is square and if it does not change when
     * changing its rows with issymetryc.
     *
     * @param matriz
     */
    public static void isSimetricMatrix(int[][] matriz) {
        boolean issymetryc = true;

        int rows = matriz.length;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (rows != matriz[i].length) {
                    issymetryc = false;
                }
            }

        }

        if (issymetryc) {
            int i = 0;
            while (i < matriz.length && issymetryc) {
                int j = 0;
                while (j < i && issymetryc) {
                    if (matriz[i][j] != matriz[j][i]) {
                        issymetryc = false;
                    }
                    j++;
                }
                i++;
            }
        }
        if (issymetryc) {
            System.out.println("Is Symmetric");
        } else {
            System.out.println("Not is Symmetric");
        }

    }

    public static void transposedmatrix(int[][] matriz) {
        int aux;
        System.out.println("Original Matrix: ");
        Matrices.printMatrix(matriz);
        System.out.println("Transposed Matrix: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                
                aux = matriz[i][j];
                matriz[i][j] = matriz[j][i];
                matriz[j][i] = aux;
            }

        }
        Matrices.printMatrix(matriz);

    }
    
    public static void AddandSubtractMatrix(int [][] matriz) {
        String [] buttoms = {"Add","Substract"};
        int rows, columns;
        int option = JOptionPane.showOptionDialog(null, 
                "Add or Substration?", "Select Operation", 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, buttoms,null);
        
        for (int i = 0; i< matriz.length; i++) {
            rows = 0;
            columns =0;
            for (int j = 0; j< matriz[i].length; j++) {
                if (option != 1) {
                    rows += matriz[i][j];
                    columns += matriz[j][i];

                } else {
                    rows -= matriz[i][j];
                    columns -= matriz[j][i];
                }               
            } System.out.println("\n Result of row: "+i+": "+rows);
            System.out.println("Result of columns: "+i+": "+columns);
            
        }
        
    } 

    public static void main(String[] args) {
        int symmetric[][] = {{0, 1, -2}, {1, 3, 0}, {-2, 0, 5}};
        int notsymmetric[][] = {{0, 1, 2}, {1, 3, 0}, {-2, 0, 5}};
        int notsymmetric2[][] = {{0, 1, -2}, {1, 3, 0}, {-2, 0, 0, 5}};
        int transposing[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        /*Matrices.printMatrix(symmetric);
        Matrices.isSimetricMatrix(symmetric);
        Matrices.isSimetricMatrix(notsymmetric);
        Matrices.isSimetricMatrix(notsymmetric2);
        Matrices.transposedmatrix(transposing); */
        Matrices.AddandSubtractMatrix(transposing);
    }

}
