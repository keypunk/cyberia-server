# Final commit hash
74b7117d65a6c28cf467441f358d802ddbd7ea0a (master-branch)

# Cyberia-Shop (Server)
Cyberia-Shop is an E-Commerce platform to buy and manage electronic products

## Features
- Functioning login/register service
- Functioning customer shop with local shopping cart persistence
- Functioning product management and employee management over RMI

## Features still missing
- Order table and order logic still missing
- Employee management functions still missing

## System prerequisites
- System with at least 4GB RAM (for modern operating system requirements)

## Software prerequisites
- At least Java SDK 19 or higher
- [A PostgresSQL Server](https://www.postgresql.org/download/)
- [Gradle build system](https://gradle.org/)

## Installing / Getting started

Before you start cloning the server repository, install the PostgresSQL server.  
  
IMPORTANT: Make sure the superuser "postgres" has the assigned password "1234" (You will be prompted to set a password for superuser "postgres").  
Once you finished the database setup, clone the server repository to your desired location or, alternatively, download the JAR-file from the 'Releases' section and follow the instructions there.    

```shell
git clone git@github.com:keypunk/cyberia-server.git
```  
Afterwards build the project
```shell
./gradlew build
```  
Let the Gradle build system download all the necessary libraries.    
Once the building and indexing is complete, you can run the server.  
```shell
./gradlew run
```  
# Now you can follow the [client instructions](https://github.com/keypunk/cyberia-client)
