StackOverflow

Functionalities
- User login & registration
- Users CRU Questions
- Users CRUD Answers
- Users likes Answers
- Users dis-likes Answers
- Answers have Comments posted by users
- Answers are needed to be sorted on the basis of number of likes


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
  - likes<User>
  - dislikes<User>
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
   