if [ -d "queuedata" ]
then
	echo "queuedata found."
else
	mkdir queuedata
fi
find queuedata -type f -exec rm {} \;

java -Dlog4j.configuration=log4j-sche.properties -cp ".:./rufodao_crawler-1.0-SNAPSHOT-jar-with-dependencies.jar" com.antbrains.rufodao.scheduler.SchedulerDriver --maxEntriesLocalHeap 1000000 --batchSize 1000 --maxQueueSize 50000  "jnp://10.26.161.20:1099" 10.26.161.20:3333 rufodao queuedata 22348 &
