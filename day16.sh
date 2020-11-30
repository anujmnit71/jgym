git pull
cd src/main/java
javac -d ../../../out/production/jgym io/jgym/warmups/day16/*.java
cd ../../../
time java -showversion -cp out/production/jgym io/jgym/warmups/day16/IntListTest
