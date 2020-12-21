

/**
 * @file FunctionClass.java
 * @brief a file for functions
 * @author Junyu Lu
 * @date 2019/4/21
 * @version 1
 *
 */


/**
 * Function class with enum of 18 functions and the function method. Each enum
 * has a function related to its function name.
 *
 * @author Junyu Lu
 */
public class FunctionClass {

    /**
     * An enum type. 
     * 18 enums named with its related function.
     */
    public enum Functions {
        
        schwefel1 {
            @Override
            public double function(double[] x, int d) {
                double fx;
                //
                fx = 418.9829 * d;
                //
                for (int i = 0; i < x.length; i++) {
                    fx -= -x[i] * Math.sin(Math.sqrt(Math.abs(x[i])));//−xi·sin(√|xi|)
                }
                return fx;
            }

        },/*!< Enum value schwefel1. */ 
        deJong2 {
            @Override
            public double function(double[] x, int d) {
                double fx;
                //
                fx = 0;
                //
                for (int i = 0; i < d; i++) {
                    fx += x[i] * x[i];
                }
                return fx;
            }

        },/*!< Enum value deJong2. */ 
        rosenbrocksSaddle3 {
            @Override
            public double function(double[] x, int d) {
                double fx;
                //
                fx = 0;
                //
                for (int i = 0; i < d - 1; i++) {
                    fx += 100 * (x[i] * x[i] - x[i + 1]) * (x[i] * x[i] - x[i + 1]) + (1 - x[i]) * (1 - x[i]);
                }
                return fx;
            }
        },/*!< Enum value rosenbrcksSaddle3. */ 
        rastrigin4 {
            @Override
            public double function(double[] x, int d) {
                double fx;
                //
                fx = 0;
                //
                for (int i = 0; i < d - 1; i++) {
                    fx += (x[i] * x[i]) - 10 * Math.cos(2 * Math.PI * x[i]);
                }
                fx *= 10;
                return fx;
            }
        },/*!< Enum value rastrigin4. */ 
        griewangk5 {
            @Override
            public double function(double[] x, int d) {
                double fx, product;
                //
                fx = 1;
                product = 1;
                //
                for (int i = 0; i < d; i++) {
                    fx += x[i] * x[i] / 4000;
                    product *= Math.cos(x[i] / Math.sqrt(i + 1));//(i+1)here equals i in the math function
                }
                fx -= product;
                return fx;
            }
        },/*!< Enum value griewangk5. */ 
        sineEnvelopeSineWave6 {

            @Override
            public double function(double[] x, int d) {
                double fx;
                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx -= 0.5 + Math.sin((x[i] * x[i] + x[i + 1] * x[i + 1] - 0.5) * (x[i] * x[i] + x[i + 1] * x[i + 1] - 0.5)) / (1 + 0.001 * (x[i] * x[i] + x[i + 1] * x[i + 1])) / (1 + 0.001 * (x[i] * x[i] + x[i + 1] * x[i + 1]));
                }

                return fx;
            }
        },/*!< Enum value sinEnvelopSinWave6. */ 
        stretchedVSineWave7 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx += Math.sqrt(Math.sqrt(x[i] * x[i] + x[i + 1] * x[i + 1])) * Math.sin(50 * Math.pow((x[i] * x[i] + x[i + 1] * x[i + 1]), 1 / 10) * 50 * Math.pow((x[i] * x[i] + x[i + 1] * x[i + 1]), 1 / 10) + 1);
                }

                return fx;
            }
        },/*!< Enum value stretchedVSinWave7. */ 
        ackleysOne8 {

            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx += 1 / Math.pow(Math.E, 0.2) * Math.sqrt(x[i] * x[i] + x[i + 1] * x[i + 1]) + 3 * (Math.cos(2 * x[i]) + Math.sin(2 * x[i + 1]));
                }

                return fx;
            }
        },/*!< Enum value ackleysOne8. */ 
        ackleysTwo9 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx += 20 + Math.E - (20 / Math.exp(0.2 * Math.sqrt((x[i] * x[i] + x[i + 1] * x[i + 1]) / 2))) - Math.exp(0.5 * (Math.cos(2 * Math.PI * x[i]) + Math.cos(2 * Math.PI * x[i])));
                }

                return fx;
            }
        },/*!< Enum value ackleysTwo9. */ 
        eggHoloder10 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx += -x[i] * Math.sin(Math.sqrt(Math.abs(x[i] - x[i + 1] - 47))) - (x[i + 1] + 47) * Math.sin(Math.sqrt(Math.abs(x[i + 1] + 47 + x[i] / 2)));
                }

                return fx;
            }
        },/*!< Enum value eggHolder10. */ 
        rana11 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx += x[i] * Math.sin(Math.sqrt(Math.abs(x[i + 1] - x[i] + 1))) * Math.cos(Math.sqrt(Math.abs(x[i + 1] + x[i] + 1))) - (x[i + 1] + 1) * Math.cos(Math.sqrt(Math.abs(x[i + 1] - x[i] + 1))) * Math.sin(Math.sqrt(Math.abs(x[i + 1] + x[i] + 1)));
                }

                return fx;
            }
        },/*!< Enum value rana11. */ 
        pathological12 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx += 0.5 + ((Math.sin(Math.sqrt(100 * x[i] * x[i] + x[i + 1] * x[i + 1]) * Math.sqrt(100 * x[i] * x[i] + x[i + 1] * x[i + 1])) - 0.5) / (1 + 0.001 * (x[i] * x[i] - 2 * x[i] * x[i + 1] + x[i + 1] * x[i + 1]) * (x[i] * x[i] - 2 * x[i] * x[i + 1] + x[i + 1] * x[i + 1])));
                }

                return fx;
            }
        },/*!< Enum value pathological12. */ 
        michalewicz13 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d; i++) {
                    fx -= Math.sin(x[i]) * Math.pow(Math.sin((i + 1) * x[i] * x[i] / Math.PI), 20);
                }

                return fx;
            }
        },/*!< Enum value michalewicz13. */ 
        masterCosineWave14 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {
                    fx -= Math.exp(-1 / 8 * (x[i] * x[i] + x[i + 1] * x[i + 1] + 0.5 * x[i + 1] * x[i])) * Math.cos(4 * Math.sqrt(x[i] * x[i] + x[i + 1] * x[i + 1] + 0.5 * x[i + 1] * x[i]));
                }

                return fx;
            }
        },/*!< Enum value masterCosineWave14. */ 
        quartic15 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d; i++) {
                    fx += (i + 1) * x[i] * x[i] * x[i] * x[i];//(i+1)here equals i in the math function
                }

                return fx;
            }
        },/*!< Enum value quartic15. */ 
        levy16 {
            @Override
            public double function(double[] x, int d) {
                double fx, wi, wn;
                wi = 1 + (x[0] - 1) / 4;//w1
                wn = 1 + (x[d - 1] - 1) / 4;//wn  //x[d-1] here is xn in the Math function
                //
                fx = Math.sin(Math.PI * wi);

                //
                for (int i = 0; i < d - 1; i++) {
                    wi = 1 + (x[i] - 1) / 4;
                    fx += (wi - 1) * (wi - 1) * (1 + 10 * Math.sin((Math.PI * wi + 1) * (Math.PI * wi + 1))) + (wn - 1) * (wn - 1) * (1 + Math.sin(2 * Math.PI * wn) * Math.sin(2 * Math.PI * wn));
                }

                return fx;
            }
        },/*!< Enum value levy16. */ 
        step17 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {

                    fx += (Math.abs(x[i]) + 0.5) * (Math.abs(x[i]) + 0.5);
                }

                return fx;
            }
        },/*!< Enum value step17. */ 
        alpine18 {
            @Override
            public double function(double[] x, int d) {
                double fx;

                //
                fx = 0;

                //
                for (int i = 0; i < d - 1; i++) {

                    fx += Math.abs(x[i] * Math.sin(x[i]) + 0.1 * x[i]);
                }

                return fx;
            }
        };/*!< Enum value alpine18. */ 

        /**
         * the abstract 
         * @param x input vector
         * @param d dimension of the input vector
         * @return output of the function as a double value
         */
        public abstract double function(double[] x, int d);
    }

}///End of class
