StackOverflow

Functionalities
- User login & registration
- Users CRU Questions
- Users CRUD Answers
- Users likes Comments
- Users dis-likes Comments
- Posts are needed to be sorted on the basis of number of likes


Entities
- User
  - id
  - first & last name
  - userId(emailId), password
  - Question
  - Answer
  - Comment
  - Vote
- Question
  - id
  - title
  - description
  - date-time
  - Answer
- Answer
  - id
  - date-time
  - Comment
  - Votes
- Comment
  - id
  - date-time
  - User
- Vote
  - id
  - voteType
  - Comment
  - User
