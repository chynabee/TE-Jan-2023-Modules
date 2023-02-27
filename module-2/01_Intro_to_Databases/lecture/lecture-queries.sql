

-- SELECT
-- Use a SELECT statement to return a literal string
SELECT 'Hello World' AS greeting;

-- Use a SELECT statement to add two numbers together (and label the result "sum")
select 1+5 AS SUM, 'Hello World' as greeting;



-- SELECT ... FROM
-- Write queries to retrieve...

-- The names from all the records in the state table
select * 
from state;


-- The names and populations of all cities
select state_name, population
from state;


-- All columns from the park table
select * 
from park;



-- SELECT __ FROM __ WHERE
-- Write queries to retrieve...

-- The names of cities in California (CA)
select city_name
from city
where state_abbreviation = 'CA';

-- The names and state abbreviations of cities NOT in California
select city_name, state_abbreviation
from city
where state_abbreviation != 'CA';

select city_name, state_abbreviation
from city
where state_abbreviation <> 'CA';

-- The names and areas of cities smaller than 25 square kilometers 
SELECT * 
FROM CITY;

SELECT CITY_NAME, AREA
FROM CITY
WHERE AREA < 25;
-- The names from all records in the state table that have no assigned census region
SELECT *
FROM STATE;

SELECT * --keyword "all"
FROM STATE
WHERE CENSUS_REGION IS NULL;

-- The names and census regions from all records in the state table that have an assigned census region
select *
from state
where census_region is not null;


-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people
select *
from city;

select city_name, area, population
from city
where area < 25 and population > 100000;

-- The names and census regions of all states (and territories and districts) not in the Midwest region (including those that don't have any census region)
select *
from state;

select state_name, census_region
from state
where census_region != 'Midwest' or census_region is null;

-- The names, areas, and populations of cities in California (CA) or Florida (FL)
select *
from city;

select city_name, area, population
from city
where state_abbreviation = 'CA' or state_abbreviation = 'FL';

-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)
select city_name, area, population--IF WE ARE DOING A BUNCH OF "OR's" just create list using IN and put all date in ()
from city
where state_abbreviation IN ('CT', 'ME', 'MA', 'NH', 'RI', 'VT', 'NY');

--Everywhere that is NOT New England
select city_name, area, population--IF WE ARE DOING A BUNCH OF "OR's" just create list using IN and put all date in ()
from city
where state_abbreviation not IN ('CT', 'ME', 'MA', 'NH', 'RI', 'VT', 'NY');


-- SELECT statements involving math
-- Write a query to retrieve the names and areas of all parks in square METERS
-- (the values in the database are stored in square kilometers)
-- Label the second column "area_in_square_meters"

select park_name, (area * 1000000) as area_in_square_meters
from park;



-- All values vs. distinct values

-- Write a query to retrieve the names of all cities and notice repeats (like Springfield and Columbus)
select city_name
from city;

-- Do it again, but without the repeats (note the difference in row count)

select distinct city_name --distinct means no duplicates, no repeats
from city
order by city_name;

-- LIKE
-- Write queries to retrieve...

-- The names of all cities that begin with the letter "A"
select *
from city
where city_name like 'A%'; -- use % at the end when capturing begin with


-- The names of all cities that end with "Falls"
select *
from city
where city_name like '%Falls'; -- use % at the beginning when capturing end with

-- The names of all cities that contain a space
select *
from city
where city_name like '% %';

-- all the cities that have a y
select * 
from city
where city_name like '%y%'; -- anything within single quotes is going to be case sensitive

-- all the cities that have a Y
select * 
from city
where city_name like '%Y%'; -- anything within single quotes is going to be case sensitive


-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers
select park_name, area
from park
where area >= 100 and area <= 200; --can also be written as WHERE area BETWEEN 100 AND 200;


-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900
select *
from park
where date_established < '1/1/1900'; --can also be written as '1900-01-01';

--IF WE WANTED TO CHECK DATES BETWEEN 1800 AND 1900
select *
from park
where date_established BETWEEN '1800-01-01' AND '1900-01-01';

