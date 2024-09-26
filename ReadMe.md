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
   2) config securityConfig such that spring goes with flow defined in our class(config. EnableWebSecurity)
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
         3) while calling the above class, pass the user object such that the methods implemented by the class can 
         have user object to return values.
5) Configuring JWT Token
   1) add dependency of "JJWT" & "JJWT Impl" || "JJWT Jackson"
   2) create authenticationManager bean
   3) return the object of the same
   4) create verify user details method in user service
   5) create a claim hashmap object in the jwt service class
   6) add the claim to "JWT builder" object
   7) add the subject as username, issuedAT & expiryAt
   8) claim is needed to be signed with a key
      1) to create Key, create jwtService constructor
      2) create a KeyGenerator object with for HmacSHA256 algo
      3) store it in SecretKey object & encode it with Base64 Encoder in string format & assign it to the 
      global variable of secret key
      4) create a byte object & decode as bytes
      5) return the key using Key.hmacShaKeyFor method
6) Validating JWT Token
   1) By Default User Password Authentication filter works: https://youtu.be/oeni_9g7too?t=9582
   2) hence we need to pass jwt filter BEFORE that
   3) hence in the security config class, 
   add the meth of addfilterbefore & mention the jwtFilter & UserPasswordAuthentication filter
   4) create JWTFilter class which extends to OncePerFilterClass
   5) at server side we'll get "Bearer <token>", hence we'll have to extract the token
      1) from the request, check if the authorization header is provided
      2) check if the authorization header starts with "Bearer "
   6) extract username from the token
   7) if username is not null & the SecurityContextHolder class's authentication, then validate the token
   8) in token validation: 
      1) use jwtService to validateToken() -> need to validate using user data
      2) hence pass userDetails in the validate token meth
   9) if the token is validated, then
      1) send info to next filter -> UserPasswordAuthenticationToken
      2) need to send principal(userDetails), credentials(we can set null TODO), authorities(get from the userdetails object)
      3) with the authToken, also attach the request object using WebAuthenticationDetailsSource
      4) after the above, set the authentication token in the chain using SecurityContextHolder object
   10) Implement the extract username & validate token meth 