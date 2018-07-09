# iron-tracker-rest
Weight lifting app with a React client and RESTful web services.

If using Docker: 

Images are not in a repo so after building images need to change the image id in the compose file before running docker-compose up.

Also need to change the service url's to include "/iron". For some reason when running the app normally it can be accessed using "localhost:8080/workouts" etc but using Docker it need the name of the war file (iron) as well.

POSTGRES

App uses a docker postgres database, to start:

docker pull postgres

docker run -d -p 5432:5432 postgres

