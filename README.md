# lead-management-service

This service manages leads. 

## API'S 

#### POST  http://localhost:9090/leads

##### RequestBody:

{
	"leadId": "5678",
	"firstName": "Vineet",
	"middleName": "Shashank",
	"lastName": "Jadhav",
	"mobileNumber": "8877887788",
	"gender": "Male",
	"dob": "1-10-1999",
	"email": "v@gmail.com"
}

#### GET  http://localhost:9090/leads/by-mobilenumber/{mobileNumber}
