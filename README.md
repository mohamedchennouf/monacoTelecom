Run application with docker-compose: 

run "./install.sh" for build the images
run "docker-compose up" for run all containers


the application is basic, 
we have a supplier service that will send a full event, 
the consumer service will consume this event and launch a rest API to update the data in the service-management
