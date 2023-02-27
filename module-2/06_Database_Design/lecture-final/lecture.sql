
BEGIN TRANSACTION;

-- DROP the tables in the reverse order that you create them
-- bottom to top

DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS artist;

CREATE TABLE artist(

  --to create a column, we provide the column name, the data type, and any constraints
	-- all columns are comma separated
	artist_name varchar(100) NOT NULL,
	-- serial is an int but will automatically generate / increment for each new row
	artist_id serial,
	
	-- After we have declared all the columns, then we can specify our keys
	-- we name each constraint, for primary keys I normally put "pk_" followed by the table name
	CONSTRAINT pk_artist PRIMARY KEY (artist_id)
);


CREATE TABLE art(
	title varchar(150) NOT NULL,
	art_id serial PRIMARY KEY,
	list_price money,
	artist_id int,
	
	-- for foreign key constraint I say "fk_" followed by the table we are in and 
	-- then the table we reference
	CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE customer(
	customer_name varchar(100) NOT NULL,
	address varchar(500),
	phone varchar(20) UNIQUE, 
	customer_id serial,
	
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

CREATE TABLE purchase(
	purchase_date date DEFAULT(CURRENT_DATE),
	purchase_price money NOT NULL,
	customer_id int,
	art_id int,
	
	--Constraints
	CONSTRAINT pk_purchase PRIMARY KEY (customer_id, art_id),
	CONSTRAINT fk_purchase_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	CONSTRAINT fk_purchase_art FOREIGN KEY (art_id) REFERENCES art(art_id)
);





COMMIT ;

