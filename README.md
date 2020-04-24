###  Ramadan

#### How to create a jar file

1- run `mvn clean compile assembly:single`

2- run the jar using `cd target` then `java -jar 'jar file name'`



##### Running the script on RasberryPi

Go in the BashRunner file and change the file location to `akoam-downloader/resources`

##### Running the script on mac

Go to the BashRunner file and change the file location to `resources` 


##### Adding new shows 
In the Script file add the link to the show in the urls object and the location to where the downloaded file should be saved

##### Driver location
The driver is on a docker with IP `http://172.16.1.165:5555/wd/hub`

