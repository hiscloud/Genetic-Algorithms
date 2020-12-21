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
public class GeneticAlgorithm {

    ///fields
    MTRandom mt;
    double[] O1, O2, P1, P2;
    int DIM;//read from a file, should be 30
    int NS;//number of solutions
    double boundLow, boundHigh, ER, CR;//elitisim rate,crossover rate
    int tmax, f;
    double mRange, mProbablility, mPrecision; //mutation

    public GeneticAlgorithm(Population p, BufferedReader br) {
        try {
            mt = new MTRandom();
            DIM = p.DIM;
            NS = p.solutions;
            f = p.f;
            boundLow = p.lowB;
            boundHigh = p.highB;
            tmax = p.gen;
            CR = p.CR;
            mProbablility = Double.valueOf(br.readLine());
            mRange = Double.valueOf(br.readLine());
            mPrecision = Double.valueOf(br.readLine());
            ER = Double.valueOf(br.readLine());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    //the functional algorithm
    public double GA(Population p,BufferedWriter bw) {
        double e = NS * ER;
        int Elitism = (int) e;//

        //Population p = new Population(NS);
        p.randomInit(boundLow, boundHigh);
        p.evaluate(0);

        for (int t = 0; t < tmax; t++) {
            Population pNew = new Population(NS, DIM);

            for (int s = 0; s < NS; s += 2) {
                select(p);
                crossover(P1, P2, CR);//O1,O2 stored in
                O1 = mutate(O1, boundLow, boundHigh);
                O2 = mutate(O2, boundLow, boundHigh);
                pNew.setVector(s, O1);
                pNew.setVector(s + 1, O2);

            }//end for s
            pNew.evaluate(0);
            pNew.getFitness();

            p.sortByCostAscending();
            pNew.sortByCostAscending();
            

            for (int s = 0; s < Elitism; s++) {

                pNew.setVector(NS - 1 - s, p.getVector(s)); //*
            }
            p.copy(pNew);

            p.evaluate(f);
            p.getFitness();
            try{
            bw.write(p.cost[0]+",");
            }catch(IOException ex){
            System.out.println(ex);
            }
             
        }//end for t
        
        return p.cost[0];
    }

    //sort solutions in each population by cost, so that minimal cost solutions come first
    public void reduce(Population Pop, Population newPop, int EliteSN) {
        Pop.sortByCostAscending();
        newPop.sortByCostAscending();
        for (int s = 0; s < EliteSN; s++) {
            newPop.setVector(NS - 1 - s, Pop.getVector(s)); //*
        }

    }

    public void select(Population Pop) {
        P1 = Pop.getVector(selectParent(Pop)).clone();
        P2 = Pop.getVector(selectParent(Pop)).clone();
    }

    public int selectParent(Population Pop) {//selection

        double r = Support.scale(mt.nextDouble(), 0, Pop.totalFitness);

        int s = 0;
        while (s < NS - 1 && r > 0) {
            r -= Pop.fitness[s];
            s += 1;
        }

        return s;

    }

    private double[] mutate(double[] s, double low, double high) {
        for (int i = 0; i < DIM; i++) {
            if (mt.nextDouble() < mProbablility) {
                double ran = Support.scale(mt.nextDouble(), -1, 1);
                s[i] += ran * (high - low) * mRange * Math.pow(2, (-1 * mt.nextDouble() * mPrecision));
                if (s[i] > boundHigh) {
                    s[i] = boundHigh;//bound
                }
            }
        }
        return s.clone();
    }

    private void crossover(double[] P1, double[] P2, double CR) {
        O1 = P1.clone();
        O2 = P2.clone();
        if (mt.nextDouble() < CR) {
            int d = mt.nextInt(DIM);
            System.arraycopy(P1, 0, O1, 0, d);
            System.arraycopy(P2, 0, O2, 0, d);
            System.arraycopy(P1, d, O2, d, DIM - d);
            System.arraycopy(P2, d, O1, d, DIM - d);
        }

    }

}//end class GA
