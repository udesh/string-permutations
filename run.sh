#!/bin/sh
cp target/string-permutations-0.0.1-SNAPSHOT.jar .
mv string-permutations-0.0.1-SNAPSHOT.jar string-permutations.jar
java -jar string-permutations.jar input.txt
 
