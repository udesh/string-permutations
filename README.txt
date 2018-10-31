Please follow these steps to run this program in linux based environment.

1. Build the project using maven 
   mvn clean install
   target/string-permutations-0.0.1-SNAPSHOT.jar file should be generated.
2. Run run.sh in the terminal
   sh run.sh

If this command throw errors follow these steps.

Copy generated target/string-permutations-0.0.1-SNAPSHOT.jar to the root folder which has input.tx and rename it to string-permutations.jar
Execute the jar using below command

java -jar string-permutations.jar input.txt 

input.txt - input text file full path
