# tg-producer

tg-producer(Microservice used to create and update customer records)
Unit Test with Code coverge: 97%
DockerFile
Kubernetes Deployment and Service yaml files

API:
Method:Post
URL:http://localhost:8080/api/customer
Body:
{
"cust_id" :"1",
"cust_name":"cust1",
"cust_email":"abc1@gmail.com",
"cust_phone" :"12345",
"cust_mktng_preference" : "post"
}
