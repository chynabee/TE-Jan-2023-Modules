-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT *
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT census_region, state_name
FROM state
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT * 
FROM park
ORDER BY area DESC
LIMIT 1;

SELECT MAX(area)
FROM park;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT *
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT *
FROM park
ORDER BY date_established ASC, park_name
LIMIT 20;

-- Or we can calculate an age using the built in CURRENT_DATE and we can divide by 365 to get the years
SELECT (CURRENT_DATE - date_established)/365 AS age, park_name
FROM park
ORDER BY age DESC, park_name
LIMIT 20;




-- CONCATENATING OUTPUTS

-- In java if I wanted to combine my first name "Christopher" and my last initial "G" 
-- then I would do something like firstName + " " + lastInitial
-- in SQL we don't use the +, instead we use ||
SELECT 'Christopher'||' '||'G';

-- All city names and their state abbreviation.
SELECT city_name || ' (' || state_abbreviation || ')' AS city_state
FROM city;

-- The all parks by name and date established.
SELECT park_name || ': ' || date_established
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || ' - ' || state_name AS region_state
FROM state
WHERE census_region IN ('West','Midwest')
ORDER BY region_state
;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_west_south_population
FROM state
WHERE census_region = 'West' OR census_region = 'South';
-- census_region IN ('West','South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(*)  -- count (*) will return the number of rows
FROM city
WHERE population >= 1000000;

-- The number of state nicknames.

SELECT COUNT(*) -- count(*) will count all the rows
FROM state;

SELECT COUNT(state_nickname)  -- count( column ) will count all the non-null values in that column
FROM state;

SELECT *
FROM state;

SELECT COUNT(DISTINCT census_region) -- if we want unique values from the column use DISTINCT 
FROM state;


-- The area of the smallest and largest parks.
SELECT MAX(area) AS largest, MIN(area) as smallest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.


-- Determine the average park area depending upon whether parks allow camping or not.


-- Sum of the population of cities in each state ordered by state abbreviation.


-- The smallest city population in each state ordered by city population.



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

