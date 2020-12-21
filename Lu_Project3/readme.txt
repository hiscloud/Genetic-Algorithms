This is a program runs 18 functions in 2 different algorithms -- GA (Genetic Algorithm) and DE (Differential 
Author: Junyu Lu 41176974
CS471 

To run the code,complie the all code in src directory with javac(javac *.java), then run the main file with java(java Main).


Please ensure that the input file is inside src directory.


You can modify the input by writing following 5 data line by line, repeatedly(no spaces):

functiontype
repeat times
dimension
lower bound
upper bound
solution number
generations
CR probablility
0 for GA/ 1 for DE
GA:
mutation probablity
mutation range
mutation precision
elitism rate
DE:
scaling factor
strategy number

ex.
1
50
30
-512
512
200
100
0.8
1
1
7
1
50
30
-512
512
200
100
0.9
0
0.005
0.1
5
0.2





The output of the code will appear in the output.csv file as raw data.



The code of DE may be bad due to some array pointer issue that the author can't fix.
