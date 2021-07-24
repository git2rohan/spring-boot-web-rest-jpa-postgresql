create table book
(
	id serial primary key,
	book_title varchar(100),
	book_author varchar(100),
	book_genre varchar(50), 
	borrowers int

);

create table borrower
(
	user_id serial primary key,
	first_name varchar(100),
	last_name varchar(100)
);


alter table book
ADD CONSTRAINT borrowers
FOREIGN KEY (borrowers) REFERENCES borrower;


