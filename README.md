#CmpE 273- Assignment 3
========================

Baseline repository for this assignment: [cmpe273-lab6](https://github.com/sithu/cmpe273-lab6)

## Steps to run the program

Windows:

We will need 4 cmd (command line shells).
3 for running 3 server instances.
1 for running 1 client instance.

### Server side (3 cmd shells)
0. open 3 cmds. cmd(1),cmd(2),cmd(3)
1. cd to 'server' directory in all three of these
2. type ' **mvn clean package**' in either one of it.
3. initiate server instances ( 3 in our case)
	* Initiate server A in cmd(1): type '**java -jar target/server-0.0.1-SNAPSHOT.jar server config/server_A_config.yml**'
	* Initiate server B in cmd(2): type '**java -jar target/server-0.0.1-SNAPSHOT.jar server config/server_B_config.yml**'
	* Initiate server C in cmd(3): type '**java -jar target/server-0.0.1-SNAPSHOT.jar server config/server_C_config.yml**'


### Client Side
0. Open cmd(4)
1. cd to  'client' directory
2. type '**mvn clean package**'
3. initiate the client
	* type '**java -jar target/client-0.0.1-SNAPSHOT.jar**'
