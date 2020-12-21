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
public class DifferenialEvolution {

    //fields
    double F;
    double CR;
    int D, NP, Gmax, f, s;  //f is function type, s is strategy
    double boundLow, boundHigh;
    MTRandom mt;

    public DifferenialEvolution(Population p, BufferedReader br) {
        CR = p.CR;//0,1
        try {

            F = Double.valueOf(br.readLine());
            s = Integer.valueOf(br.readLine());
        } catch (IOException e) {
            System.out.print(e);
        }
        D = p.DIM;
        NP = p.solutions;
        Gmax = p.gen;
        f = p.f;
        mt = new MTRandom();

        boundLow = p.lowB;
        boundHigh = p.highB;
    }

    public double DE(Population p, BufferedWriter bw) {

        //  p = new Population(200);
        p.evaluate(f);
        for (int G = 0; G < Gmax; G++) {
            p.evaluate(f);
            p.sortByCostAscending();

            Population pNew = new Population(NP, D);
            pNew.randomInit(boundLow, boundHigh);
            for (int j = 0; j < NP; j++) {
                double[] newV;

                double[] oldV = p.getVector(j).clone();

                newV = mutation(j, p);

                if (FunctionClass.Functions.values()[f].function(newV, D) < FunctionClass.Functions.values()[f].function(oldV, D))//selection
                {
                    pNew.setVector(j, newV);
                } else {
                    pNew.setVector(j, oldV);
                }
            }//fill the new population
            p.copy(pNew);
            p.evaluate(f);

            p.sortByCostAscending();
            try {
                bw.write(p.cost[0] + ",");
            } catch (IOException e) {
                System.out.println(e+"output file not found");
            }
        }
        try {
                bw.newLine();
            } catch (IOException e) {
                System.out.println(e+"output file not found");
            }
        return p.cost[0];
    }

    private double[] mutation(int I, Population p) {
        double[] out = new double[D];
        for (int i = 0; i < D; i++) {
            out[i] = p.getVector(I)[i];
        }

        //  int j = mt.nextInt(D);
        for (int i = 0; i < D; i++) {
            int n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0;
            //generate 5 different numbers for mutation
            while (!(n1 != n2 && n1 != n3 && n1 != n4 && n1 != n5 && n2 != n3 && n2 != n4 && n2 != n5 && n3 != 4 && n3 != n5 && n4 != n5 && I != n1 && I != n2 && I != n3 && I != n4 && I != n5)) {
                n1 = mt.nextInt(NP);
                n2 = mt.nextInt(NP);
                n3 = mt.nextInt(NP);
                n4 = mt.nextInt(NP);
                n5 = mt.nextInt(NP);
            }

            switch (s) {
                case 1:
                    if (i < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(0)[i] + F * (p.getVector(n2)[i] - p.getVector(n3)[i]);
                    }
                    break;
                case 2:
                    if (i < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(n1)[i] + F * (p.getVector(n2)[i] - p.getVector(n3)[i]);
                    }
                    break;
                case 3:
                    if (i < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(I)[i] + mt.nextDouble() * (p.getVector(0)[i] - p.getVector(I)[i]) + F * (p.getVector(n1)[i] - p.getVector(n2)[i]);
                    }
                    break;
                case 4:
                    if (i < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(0)[i] + F * (p.getVector(n1)[i] + p.getVector(n2)[i] - p.getVector(n3)[i] - p.getVector(n4)[i]);
                    }
                    break;
                case 5:
                    if (i < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(n5)[i] + F * (p.getVector(n1)[i] + p.getVector(n2)[i] - p.getVector(n3)[i] - p.getVector(n4)[i]);
                    }
                case 6:
                    if (mt.nextDouble() < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(0)[i] + F * (p.getVector(n2)[i] - p.getVector(n3)[i]);
                    }
                    break;
                case 7:
                    if (mt.nextDouble() < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(n1)[i] + F * (p.getVector(n2)[i] - p.getVector(n3)[i]);
                    }
                    break;
                case 8:
                    if (mt.nextDouble() < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(I)[i] + mt.nextDouble() * (p.getVector(0)[i] - p.getVector(I)[i]) + F * (p.getVector(n1)[i] - p.getVector(n2)[i]);
                    }
                    break;
                case 9:
                    if (mt.nextDouble() < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(0)[i] + F * (p.getVector(n1)[i] + p.getVector(n2)[i] - p.getVector(n3)[i] - p.getVector(n4)[i]);
                    }
                    break;
                case 10:
                    if (mt.nextDouble() < CR) // System.out.println(n1);
                    {
                        out[i] = p.getVector(n5)[i] + F * (p.getVector(n1)[i] + p.getVector(n2)[i] - p.getVector(n3)[i] - p.getVector(n4)[i]);
                    }
                    break;
            }

            if (out[i] > boundHigh) {
                out[i] = boundHigh;
            }
            if (out[i] < boundLow) {
                out[i] = boundLow;
            }
        }

        return out.clone();
    }
}
