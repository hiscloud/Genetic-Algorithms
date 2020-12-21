

/**
 * @file Support.java
 * @brief a file for support tool for project2
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
public class Support {

    double a;
  
    int type, dimension, repeatTimes;//integers to be input
    double boundLow, boundHigh;//doubles to be input
    double startTime, finishTime, elapsedTime;//times
    File file;
    FileReader fr;
    BufferedWriter bw;
    BufferedReader br;
    Matrix mx;
    FunctionClass fc = new FunctionClass();
    double[] arg;//initialization arg to store the solution for optimal fitness
///consturctor
    
    public Support() throws IOException {
        //input
        file = new File("input.txt");
        fr = new FileReader(file);
        br = new BufferedReader(fr);

        bw = new BufferedWriter(new FileWriter("output.csv"));
        mx = new Matrix();
        fc = new FunctionClass();
       

    }





    ///This method is a support for MT, input a random double from 0 ot 1, return the correspoding random value from low to high
    public static double scale(double in, double low, double high) {
        return low + in * (high - low);
    }

    

}
