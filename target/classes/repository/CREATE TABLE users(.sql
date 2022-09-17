CREATE TABLE users(
  user_id serial UNIQUE PRIMARY KEY,
  name VARCHAR(15) NOT NULL,
  last_name VARCHAR (20) NOT NULL,
  email VARCHAR (30) NOT NULL SELECT * from users WHERE email ILIKE ?;,
  password VARCHAR (50) NOT NULL
);
CREATE TABLE tweets (
  tweet_id serial UNIQUE PRIMARY KEY,
  message VARCHAR(50),
  email VARCHAR (30),
  user_id INT,
  CONSTRAINT fk_user 
    FOREIGN KEY(user_id)
    REFERENCES Employee(user_id)
);
-- DROP TABLE users;