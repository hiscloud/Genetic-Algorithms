

/**
 * @file Main.java
 * @brief main file of CS471 project2
 * @author Junyu Lu
 * @date 2019/4/21
 * @version 1
 *
 */
import java.io.*;

/**
 *
 * @author Junyu Lu
 */
public class Main {

    /**
     * Main method going into run()
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().run();

        //   for (int i=0;i<20;i++)
        // System.out.println(p0.getVector(0).clone()[i]);
    }

    /**
     * run() method to excute the project
     */
    private void run() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"));

            while (br.ready()) {
                Population p0 = new Population(br);

                p0.randomInit(-512, 512);

                switch (p0.alg) {
                    case 0:
                        GeneticAlgorithm G = new GeneticAlgorithm(p0, br);
                        bw.write(p0.f+1+",GA,");
                        bw.newLine();
                        for (int i = 0; i < p0.rep; i++) {
                             double startTime=System.currentTimeMillis();
                            Population p1=new Population(p0.solutions,p0.DIM);
                            
                            System.out.println(G.GA(p1,bw)); 
                            double time=System.currentTimeMillis()-startTime;
                            bw.write(","+time+",");
                            bw.newLine();
                            
                            
                        }
                        break;
                       
                    case 1:
                        DifferenialEvolution D = new DifferenialEvolution(p0, br);
                        bw.write(p0.f+1+",DE,"+D.s+",");
                        
                        for (int i = 0; i < p0.rep; i++) {
                            Population p1=new Population(p0.solutions,p0.DIM);
                            System.out.println(D.DE(p1,bw));
                            bw.write(i+1+",,,");
                        }
                        break;
                }
                
                bw.newLine();
                    
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("file not found" + e);
        }
    }
}
