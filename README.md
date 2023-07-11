# diagno

## About
laboratory management system is fully automated end to end appointment management system
for laboratory appointments.
The system has 3 roles
1. ADMIN
2. USER
3. LAB TECHNICIAN

Admin has bellow rights
- Manage Lab location
- Manage type of tests offered.
- Manage each appointment and change status.

User has permission to
- Schedule an appointment
- edit and reschedule appointments
- cancel appointments
- view the status of the appointments real time 
  - SCHEDULED
  - CHECKED_IN
  - SAMPLE_COLLECTED
  - RESULT_REVIEW
  - RESULT_READY

Finally, lab technician can find all the appointments and update the status 
based on the actions performed.

## Technologies Used

### Front End
- HTML, CSS, Thymeleaf, Javascript.
### Api
- Sprint Boot, Thymeleaf, Spring Security, Spring JPA.
### Back End
- MySQL

## Database Schema
![](../../OneDrive/Desktop/schema.png)
## How to login
1. Register user, for easiness a role is assigned for a user based on user email. 
   - If an email starts with prefix "admin", the user will be assigned to ADMIN role.
   - If a email starts with prefix "lt", the user will be assigned to Lab Technician role.
   - All normal user registration will be assigned default USER Role.



