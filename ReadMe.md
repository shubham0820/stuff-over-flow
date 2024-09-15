StackOverflow

Functionalities
- User login & registration
- Users CRU Questions
- Users CRUD Answers -> one user can create only 1 answer per question
- Users likes Answers
- Users dis-likes Answers
- Answers have Comments posted by users
- Answers are needed to be sorted on the basis of number of likes
Features:
- jwt authentication
- pagination
- sorting
- question & ans can may have images

Entities
- User
  - id
  - first & last name
  - userId(emailId), password
  - Reputation
  - Question
  - Answer
  - Comment
- Question
  - id
  - title
  - description
  - date-time
  - User
  - List<Answers>
- QuestionLikes
  - id
  - User
  - Question
- QuestionDislikes
  - id
  - User
  - Question
- Answer
  - id
  - date-time
  - Comment
  - User
  - Question
- Comment
  - id
  - date-time
  - User
  - Answer

Implementation Steps:
1) Configure DB setup in application.properties
2) Start configuring Entities
   1) DTO object is used to store data exposed at the api call
   2) Entity object is used to store data to be stored in the database
   3) Modelmapper should be defined as a bean
   4) Lombok Data is important for getter & setter for entity & corresponding DTO
   5) for doing a not-empty check at presentation layer, add spring boot starter validation
   6) also add @Valid annotation apart from @NotBlank etc
3) ref: https://www.youtube.com/watch?v=fyTxwIa-1U0
4) 
4) Before Creating JWT Token
   1) dsf
   2) 
4) Creating JWT Token
   1) create a claim object
   2) add the claim to JWT builder object
   3) claim has subject as username, issuedAT & expiryAt
   4) claim is needed to be signed with a key
   5) Key has to be created using KeyGenerator for Hmacsha256 algo
   6) Key may/maynot be base64 encoded
   7) 
   