import java.util.Arrays;

public class Lab02 {

    public static void nameDisplay() {
        System.out.println("Jerry");
    }

    /**
     * @param mat 
     */
    public static void matShow(int[][] mat) {
        
		for (int i = 0; i < mat.length; i++) {            
            for (int j = 0; j < mat[i].length; j++) {    
                System.out.print(mat[i][j] + " ");       
            }
            System.out.println("");
        }
    }

    /**
     * @param arr1
     * @param arr2
     * @return boolean
     */
    public static boolean arrEquals(int[] arr1, int arr2[]) {
        
		if (arr1.length != arr2.length) { 
            return false;
        }

        for (int i = 0; i < arr1.length; i++) { 
            if (arr1[i] != arr2[i]) {           
                return false;
            }
        }

        return true;                          
    }

    /**
     * @param mat1
     * @param mat2
     * @return boolean
     */
    public static boolean matEquals(int[][] mat1, int[][] mat2) {
        
		if (mat1.length != mat2.length) {
            return false;                
        }

        for (int i = 0; i < mat1.length; i++) {
            if (!arrEquals(mat1[i], mat2[i])) {
                return false;
            }
        }

        return true;                           
    }

    /**
     * @param arr
     * @return int
     */
    public static int arrSum(int[] arr) {
        
		int sum = 0;

        for (int i = 0; i < arr.length; i++) {  
            sum += arr[i];
        }
        
		return sum;
    }

    /**
     * @param mat
     * @return int
     */
    public static int matSum(int[][] mat) {
        
		int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            sum += arrSum(mat[i]);            
        }

        return sum;
    }

    /**
     * @param mat1
     * @param mat2
     * @return boolean
     */
    public static boolean matEqualD(int[][] mat1, int[][] mat2) {
        
		if (mat1.length != mat2.length) {
            return false;
        }

        for (int i = 0; i < mat1.length; i++) {       
            if (mat1[i].length != mat2[i].length) {   
                return false;                        
            }
        }

        return true;                                
    }

    /**
     * @param mat1    The first matrix.
     * @param mat2    The second matrix.
     * @return int[][]
     */
    public static int[][] matMult(int[][] mat1, int[][] mat2) {
        
		if (!matEqualD(mat1, mat2)) {                        
            System.out.println("The matrices do not have equal dimensions");
            return new int[mat1.length][];
        }

        int[][] C = new int[mat1.length][];                

        for (int i = 0; i < mat1.length; i++) {            
            C[i] = new int[mat1[i].length];                
            for (int j = 0; j < mat1[i].length; j++) {    
                C[i][j] = mat1[i][j] * mat2[i][j];        
            }
        }
        
		return C;                                        
    }

	/// Main to test
    public static void main(String[] args) {

        nameDisplay();
        System.out.println("");

        int[][] mat = {{11, 12, 13},
                {21, 22, 23, 24},
                {31, 32}
        };

        int[][] mat2 = {{11, 12, 13},
                {21, 22, 23, 24},
                {31, 33}
        };

        System.out.println("Mat:");
        matShow(mat);
        System.out.println("");
        System.out.println("Mat2:");
        matShow(mat2);

        System.out.println("Equal Matrices:" + matEquals(mat, mat2));

        int[] arr1 = {2, 3, 4, 5};
        int[] arr2 = {2, 3, 5, 4};
        int[][] C;
        System.out.println("");

        System.out.println("Arr1:" + Arrays.toString(arr1));
        System.out.println("Arr2:" + Arrays.toString(arr2));

        System.out.println("Equal Arrays:" + arrEquals(arr1, arr2));

        System.out.println("");
        System.out.println("Sum of Mat= " + matSum(mat));
        System.out.println("Sum of Mat2= " + matSum(mat2));
        System.out.println("");

        System.out.println("C: (Mat * Mat2)");
        C = matMult(mat, mat2);

        matShow(C);
    }
}
