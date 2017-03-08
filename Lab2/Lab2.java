import java.util.Random;
import java.util.Scanner;
import java.lang.Math;


/**
 * Created by usmannoor on 22/02/2017.
 */


public class Lab2 {

    //Iterative multiplication
    public static int[][] matrixMultiply(int a[][], int b[][], int w, int x, int y, int z)
    //arguments: a = 1st matrix, b = 2nd matrix, w = row of 1st, x = col of 1st, y = row of 2nd, z = col of 2nd
    {
        int sum = 0;
        int multiply[][] = new int[w][z];   //creating new array to store the result and return
        if (x != y)     //checking if the matrices can be multiplied
        {
            System.out.println("ERROR! These Matrices Can't be Multiplied!");
            return null;
        } else {
            for (int c = 0; c < w; c++) //main loops for multiplication
            {
                for (int d = 0; d < z; d++) {
                    
                    for (int k = 0; k < y; k++) {
                        sum = sum + a[c][k] * b[k][d];
                    }
                    
                    multiply[c][d] = sum;
                    sum = 0;
                }
            }
        }
        return multiply; //returning result
    }


    //Strassen multiplication

    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] R = new int[n][n];
        /* base case */
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            /**
             M1 = (A11 + A22)(B11 + B22)
             M2 = (A21 + A22) B11
             M3 = A11 (B12 - B22)
             M4 = A22 (B21 - B11)
             M5 = (A11 + A12) B22
             M6 = (A21 - A11) (B11 + B12)
             M7 = (A12 - A22) (B21 + B22)
             **/

            int[][] M1 = multiply(add(A11, A22), add(B11, B22));
            int[][] M2 = multiply(add(A21, A22), B11);
            int[][] M3 = multiply(A11, sub(B12, B22));
            int[][] M4 = multiply(A22, sub(B21, B11));
            int[][] M5 = multiply(add(A11, A12), B22);
            int[][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int[][] M7 = multiply(sub(A12, A22), add(B21, B22));

            /**
             C11 = M1 + M4 - M5 + M7
             C12 = M3 + M5
             C21 = M2 + M4
             C22 = M1 - M2 + M3 + M6
             **/
            int[][] C11 = add(sub(add(M1, M4), M5), M7);
            int[][] C12 = add(M3, M5);
            int[][] C21 = add(M2, M4);
            int[][] C22 = add(sub(add(M1, M3), M2), M6);

            /** join 4 halves into one result matrix **/
            join(C11, R, 0, 0);
            join(C12, R, 0, n / 2);
            join(C21, R, n / 2, 0);
            join(C22, R, n / 2, n / 2);
        }
        /** return result **/
        return R;
    }

    /**
     * Function to sub two matrices
     *
     * @param A
     * @param B
     * @return
     **/
    public int[][] sub(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    /**
     * Function to add two matrices
     *
     * @param A
     * @param B
     * @return
     **/
    public int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    /**
     * Function to split parent matrix into child matrices
     *
     * @param P
     * @param C
     * @param iB
     * @param jB
     **/
    public void split(int[][] P, int[][] C, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }

    /**
     * Function to join child matrices into parent matrix
     *
     * @param C
     * @param P
     * @param iB
     * @param jB
     **/
    public void join(int[][] C, int[][] P, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }
    
    //calculates the order of the matrix to be formed if provided matrix is not 2^n
    public static int order_calculater(int r1, int r2, int c1, int c2){
        int max = 0;
        if (r1 > max) {
            max = r1;
        }
        if (r2 > max) {
            max = r2;
        }
        if (c1 > max) {
            max = c1;
        }
        if (c2 > max) {
            max = c2;
        }
        int order = 0;
        double temp1 = Math.log(max) / Math.log(2);
        int temp2 = (int) (Math.log(max) / Math.log(2));
        if ((temp2 % temp1) == 0) {
            order = temp2;
        } else {
            order = temp2 + 1;
        }
        order = (int) Math.pow(2, order);
        return order;
    }

    /**
     * Main function
     *
     * @param args
     **/
    public static void main(String[] args) {
        Lab2 s = new Lab2();
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Num of Rows of Matrix 1:");
        int r1 = scan.nextInt();
        System.out.println("Enter Num of Columns of Matrix 1:");
        int c1 = scan.nextInt();
        System.out.println("Enter Num of Rows of Matrix 2:");
        int r2 = scan.nextInt();
        System.out.println("Enter Num of Columns of Matrix 2:");
        int c2 = scan.nextInt();

        int[][] m1 = new int[r1][c1];
        int[][] m2 = new int[r2][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                m1[i][j] = rand.nextInt(10) + 1;
            }
        }

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                m2[i][j] = rand.nextInt(10) + 1;
            }
        }

        int order = order_calculater(r1, r2, c1, c2);

        System.out.println("\n Order of the padded matrices will be: " + order);

        //making new matrices of of the order calculated
        int[][] mat1 = new int[order][order];
        int[][] mat2 = new int[order][order];
        //copying the original matrices to new matrices
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                mat1[i][j] = m1[i][j];
            }
        }

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                mat2[i][j] = m2[i][j];
            }
        }


        System.out.println("\nPadded Matrix A is: ");
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print(mat1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nPadded Matrix B is: ");
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print(mat2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
