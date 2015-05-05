#CmpE 273- Assignment 3
========================

Baseline repository for this assignment: [cmpe273-lab6](https://github.com/sithu/cmpe273-lab6)

## Steps to run the program

### Server side

1. cd to 'server' directory
2. type ' **mvn clean package**'
3. initiate server instances ( 3 in our case)
	* Initiate server A : type '**java -jar target/server-0.0.1-SNAPSHOT.jar server config/server_A_config.yml**'
	* Initiate server B : type '**java -jar target/server-0.0.1-SNAPSHOT.jar server config/server_B_config.yml**'
	* Initiate server C : type '**java -jar target/server-0.0.1-SNAPSHOT.jar server config/server_C_config.yml**'

	
### Client Side

1. cd to  'client' directory
2. type '**mvn clean package**'
3. initiate the client 
	* type '**java -jar target/client-0.0.1-SNAPSHOT.jar**'
