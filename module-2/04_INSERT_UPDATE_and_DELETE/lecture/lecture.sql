-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
INSERT INTO park(park_name, date_established, area, has_camping)
VALUES ('Disneyland', '07/17/1955', 2.1, false);

SELECT *
FROM park;

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
INSERT INTO city(city_name, state_abbreviation, population, area)
VALUES ('Hawkins', 'IN', 30000, 38.1), ('Cicely', 'AK', 839, 11.4)

SELECT *
FROM city;

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
INSERT INTO park_state(park_id, state_abbreviation)
SELECT park_id, 'CA'
FROM park
WHERE park_name = 'Disneyland';

SELECT*
FROM park_state;

--If we want to get the id of the row we just created, we can use a keyword called RETURNING
--RETURNING is like a SELECT statement on the row you just inserted
INSERT INTO park(park_name, date_established, area, has_camping)
VALUES ('Bearland', '07/17/1955', 2.1, false) RETURNING park_id;



-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
--Always run a SELECT statement before an UPDATE- you can use the WHERE statement from that for your UPDATE
UPDATE state
SET state_nickname = 'The Happiest Place on Earth'
WHERE state_abbreviation = 'CA';

SELECT *
FROM state
WHERE state_abbreviation = 'CA';

-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population + 1000000
WHERE state_abbreviation = 'CA';

-- Change the capital of California to Anaheim.
UPDATE state
SET capital = (
	SELECT city_id
	FROM city
	WHERE city_name = 'Anaheim'
)
WHERE state_abbreviation = 'CA';

-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
UPDATE state
SET state_nickname = 'The Golden State',
	population = population - 1000000,
	capital = (
		SELECT city_id
		FROM city
		WHERE city_name = 'Sacramento'
	)
WHERE state_abbreviation = 'CA';


-- DELETE

-- Delete Hawkins, IN from the city table.- JUST CHANGE THE SELECT* TO DELETE
--*********ALWAYS RUN THE SELECT * FOR WHAT YOU WANT TO DELETE FIRST. THEN CHANGE IT TO DELETE**********
SELECT *
FROM city
WHERE city_name = 'Hawkins';

DELETE
FROM city
WHERE city_name = 'Hawkins';


-- Delete all cities with a population of less than 1,000 people from the city table.
SELECT * -- JUST CHANGE TO DELETE - SEE NEXT ENTRY
FROM city
WHERE population < 1000;

DELETE
FROM city
WHERE population < 1000;

-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
--THIS WONT WORK BECAUSE IT VIOLATES THE FOREIGN KEY CONSTRAINT AS WHAT A STATE_ABBREVIATION IS. XX IS NOT A REAL STATE ABBREVIATION
INSERT INTO city(city_name, state_abbreviation, population, area)
VALUES ('Hawkins', 'XX', 30000, 38.1), ('Cicely', 'AK', 839, 11.4)


-- Try deleting California from the state table.
SELECT *
FROM state
WHERE state_abbreviation = 'CA';

DELETE -- THIS WONT WORK BECAUSE AS LONG AS THERE ARE FK IN YOUR TABLE YOU WILL NOT BE ABLE TO DELETE A PK 
FROM state
WHERE state_abbreviation = 'CA';

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
DELETE
FROM park
WHERE park_name ='Disneyland';

DELETE
FROM park_state
WHERE park_id = 64;


-- CONSTRAINTS

-- NOT NULL constraint

-- Try adding Smallville, KS to the city table without specifying its population or area.

INSERT INTO city (city_name, state_abbreviation)
VALUES ('Smallville', 'KS')
--***ERROR:  null value in column "area" violates not-null constraint--check united states database query and you will see it doesnt allow NULL for area


-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (city_name, state_abbreviation, area)
VALUES ('Smallville', 'KS', 15);
--***after adding the area value, the population will default to 0 and you should be able to see this entry now since null factors were addressed

-- Retrieve the new record to confirm it has been given a default, non-null value for population.

SELECT *
FROM city
WHERE city_name = 'Smallville';


--SEE ABOVE

-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).

SELECT *
FROM state
WHERE state_abbreviation = 'CA';

UPDATE state
SET state_nickname = 'Vacationland'
WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).

UPDATE state
SET census_region = 'Southeast'
WHERE state_abbreviation = 'FL';

-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
BEGIN TRANSACTION;-- this will begin a transaction of what you want to delete or add

DELETE
FROM city
WHERE city_name = 'Smallville';

ROLLBACK;--this will undo the change you made within the transaction 

COMMIT;--only RUN COMMIT when you are sure you want to commit the changes. Once we commit, Smallville will be gone forever

--run this to see if the change was made
SELECT*
FROM city
WHERE city_name = 'Smallville';

-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
BEGIN TRANSACTION;

DELETE 
FROM park_state;--transaction will only run until ; --so if multiple semicolons, it will run individually to end of each ;
WHERE park_id = 64;

ROLLBACK;

COMMIT;

SELECT *
FROM park_state;

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
BEGIN TRANSACTION;

UPDATE city
SET state_abbreviation = 'TX';

ROLLBACK;

SELECT *
FROM city;
-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
