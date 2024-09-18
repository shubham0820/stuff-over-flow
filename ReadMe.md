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
3) ref: diff b/w session & JWT: https://www.youtube.com/watch?v=fyTxwIa-1U0
4) Before JWT impl: Config Spring Security: https://www.youtube.com/watch?v=oeni_9g7too
   1) create securityConfig class as a Component
   2) create securityfilterchain meth having httpsecurity param
      1) disable csrf -> to make http stateless
      2) authorize the requests
      3) enable httpBasic instead of formLogin
      4) to make http stateless, add the session creation policy as StateLess
   3) create Authentication provider
      1) unauthenticated Obj -> Authentication provider -> authenticated Object
      2) we need to use a custom authentication provider if we need to use db
      3) Many authen.Prov. are there, one of them is DaoAuth.Provider which is used for DB
      4) set the password encoder for daoauthenticationprovider
      5) set the userdetailsservice
   4) create userdetailservice class to configure in authenticationprovider object
      1) implemnt loaduserbyusername function coming from userdetailservice interface & using user repo, find the user
      2) return the user
         1) loaduserbyusername returns userdetails interface object 
         2) hence we'll have to create class implementing userdetails
         3) while calling the above class, pass the user object such that the methods implemented by the class can have user object to return values 
4) Creating JWT Token
   1) create a claim object
   2) add the claim to JWT builder object
   3) claim has subject as username, issuedAT & expiryAt
   4) claim is needed to be signed with a key
   5) Key has to be created using KeyGenerator for Hmacsha256 algo
   6) Key may/maynot be base64 encoded
   