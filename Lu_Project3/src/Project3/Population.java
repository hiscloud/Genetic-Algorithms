/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;

/**
 *
 * @author Junyu Lu
 */
public class Population {

    //field 
    Matrix mx;
    int solutions, DIM, f, rep, gen, alg;
    double totalFitness, lowB, highB, CR;
    double[] fitness;
    double[] cost;

    //methods
    public Population(BufferedReader br) throws IOException {
        try{
        f = Integer.valueOf(br.readLine())-1;//1-18
        rep = Integer.valueOf(br.readLine());
        DIM = Integer.valueOf(br.readLine());
        lowB = Double.valueOf(br.readLine());
        highB = Double.valueOf(br.readLine());
        solutions = Integer.valueOf(br.readLine());
        gen = Integer.valueOf(br.readLine());
        CR = Double.valueOf(br.readLine());
        alg = Integer.valueOf(br.readLine());
           
        
        }catch(IOException e ){
        System.out.println(e);
        }
        mx = new Matrix(solutions, DIM);
        cost = new double[solutions];
        
        fitness = new double[solutions];
        totalFitness = 0;

    }
    //use 
    public Population(int s,int d) {
        solutions=s;
        DIM=d;

        mx = new Matrix(solutions, DIM);
        cost = new double[solutions];
       
        fitness = new double[solutions];
        totalFitness = 0;
       

    }

//end of constructor
    public void randomInit(double boundLow, double boundHigh) {

        mx.fillMatrix(boundLow, boundHigh);

    }

    public void evaluate(int fType) {
        for (int i = 0; i < solutions; i++) {
            cost[i] = FunctionClass.Functions.values()[fType].function(mx.getArray(i), DIM);//

        }

    }

    public void copy(Population p) {
        for (int i = 0; i < p.mx.column; i++) {
            this.setVector(i, p.getVector(i).clone());
        }
        cost = p.cost.clone();
        fitness = p.fitness.clone();
    }

    public double[] getVector(int col) {
        return mx.getArray(col);
    }

    public void setVector(int col, double[] in) {
        mx.setArray(col, in);
    }

    void getFitness() {
        totalFitness = 0;
        for (int s = 0; s < solutions; s++) {
            if (cost[s] >= 0) {
                fitness[s] = 1 / (1 + cost[s]);
            } else {
                fitness[s] = 1 / (1 + Math.abs(cost[s]));
            }
            totalFitness += fitness[s];

        }
    }//end getFitness

    /**
     * Use hand writing selection sort to sort the cost and the matrix
     */
    public void sortByCostAscending() {
        for (int i = 0; i < cost.length; i++) {
            double min = Double.MAX_VALUE;

            int minInd = 0;
            for (int j = i; j < cost.length; j++) {
                if (cost[j] < min) {
                    min = cost[j];
                    minInd = j;

                }

            }
            //swap cost j and the first one
            double k = cost[i];
            cost[i] = cost[minInd];
            cost[minInd] = k;
            double[] kk = mx.matrix[i].clone();
            mx.matrix[i] = mx.matrix[minInd].clone();
            mx.matrix[minInd] = kk.clone();
        }
    }
}
