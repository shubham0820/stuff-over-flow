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
  - Likes
  - Dislikes
- Question
  - id
  - title
  - description
  - date-time
  - User
  - Answer
  - Likes
  - Dislikes
- Answer
  - id
  - date-time
  - Comment
  - User
  - Likes
  - Dislikes
- Comment
  - id
  - date-time
  - User
  - Answer
- Like
  - id
  - User
  - Answer
  - Question
