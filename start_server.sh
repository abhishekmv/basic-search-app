# change to project
#cd /Users/abhishekmv/Desktop/Abhishek/git/basic-search-app

# kill anything else on port 8080
#netstat -tenlp | grep :8080 | awk '{print $9}' | sed 's/\([0-9]*\).*/\1/' > server.pid
#kill -9 `cat server.pid`
#rm server.pid

# build jar
#mvn clean install tomee:exec

# debug mode 5005 port
mvn clean install tomee:debug

# run in background and save pid
java -jar target/ROOT-exec.jar
