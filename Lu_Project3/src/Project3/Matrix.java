


/**
* @file Matrix.java
* @brief a file for matrix modification
* @author Junyu Lu
* @date 2019/4/21
* @version 3
* 
*/



/**
 * 
 * @author Junyu Lu
 */
public class Matrix {
    MTRandom mt;
    double[][] matrix;
    int column, row;
    ///create an empty matrixs with 0 rows and 0 columns
    /**
    * create an empty matrix
    */
    public Matrix(){
        mt = new MTRandom();
        matrix= new double[0][0];
        column=0;
        row=0;
    }
      ///create an empty matrixs with given rows and columns
    public Matrix(int columns, int rows) {
        mt=new MTRandom();
        matrix = new double[columns][rows];
        column = columns;
        row = rows;
    }
    
    public void resizeMatrix(int columns,int rows){
        matrix= new double [columns][rows];
        column=columns;
        row=rows;
    }

    public void fillMatrix(double low, double high) {
        
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                double x = mt.nextDouble();
                double unit = Support.scale(x, low, high);
                matrix[i][j]=unit;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
    public double[] getArray(int col){
        
        return matrix[col];
        
    }
    
    public void setArray(int col,double[] x){
        matrix[col]=x.clone();
       
    }

}
