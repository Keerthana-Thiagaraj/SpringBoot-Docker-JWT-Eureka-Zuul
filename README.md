# HouseHold-Appliances- Spring-boot+Docker+Postgres

As a user, I want to be able to manage my household appliances so that I could properly document and maintain them. This application shows how to create a Spring Boot RESTful webservice application and deploy in Docker.

**STEPS:**

1. Clone the project https://github.com/Keerthana-Thiagaraj/HouseHold-Appliances.git
2. Install Docker by referring [here](https://www.docker.com/get-started)

   * Inorder to check the containers already running, run
    docker container list -a
   * To check all the images you have, run
    docker image list -a
3. Build using the below commands:

    mvn clean install
    mvn clean package
    
4. Lets build the docker image and run the container for our app by providing the below command.

   docker-compose build   
   
5. Bring the service up by executing the command

   docker-compose up  

**Test the application by using below Endpoints**

  * curl --location --request GET 'http://localhost:8080/appliances/' \
--header 'Content-Type: application/json' \
--data-raw ''

  * curl --location --request POST 'http://localhost:8080/appliances/' \
--header 'Content-Type: application/json' \
--data-raw '{

	"brand": "sony",
        "model": "S27",
        "status": "active"
}'

  * curl --location --request POST 'http://localhost:8080/appliances/update/2' \
--header 'Content-Type: application/json' \
--data-raw '{

	"brand": "panasonic",
        "model": "P1000",
        "status": "active"
}'

  * curl --location --request GET 'https://localhost:8080/appliances/search?search=%28serialnumber:3%29'
  
  * curl --location --request DELETE 'http://localhost:8080/appliances/delete/3'
