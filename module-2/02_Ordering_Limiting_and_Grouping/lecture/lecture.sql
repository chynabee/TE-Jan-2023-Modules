-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
select state_name, population
from state
order by population desc;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
select state_name, census_region
from state
order by state_name, census_region desc;

-- The biggest park by area
select park_name, area
from park
order by area desc;


-- LIMITING RESULTS

-- The 10 largest cities by populations
select *
from city
order by population desc
limit 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
select * 
from park
order by date_established, park_name
limit 20;

select CURRENT_DATE - date_established as age, park_name
from park
order by age desc, park_name
limit 20;

--or we can calculate an age using the built in current date we can divide by 365 to get the years
select (current_date - date_established)/365 as age, park_name
from park
order by age desc, park_name
limit 20;


-- CONCATENATING OUTPUTS

--in java if I wanted to combine my first name "Chyna" and my last inital "B", 
--then i would do something like firstName + " " + lastInitial
--in SQL we dont use the +, instead we use ||
select 'Chyna'|| ' '|| 'B';


-- All city names and their state abbreviation.
select city_name || ' ('|| state_abbreviation || ')' as city_state
from city;

-- The all parks by name and date established.
select park_name|| ': ' ||date_established as parks_date
from park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
select census_region || ' - ' || state_name as region_state
from state
where census_region IN ('West', 'Midwest')					
order by region_state;

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
select avg(population) as avg_state_population
from state;

-- Total population in the West and South census regions
select sum (population) as total_west_south_population
from state
where census_region In ('West', 'South');

-- The number of cities with populations greater than 1 million
select count(*) --count(*) will return the number of rows
from city
where population > 1000000;

-- The number of state nicknames.
SELECT COUNT (*)--WILL COUNT ALL THE ROWS INCLUDING NULL RESULTS
FROM STATE;

select COUNT (state_nickname) -- COUNT (column_name) will count all the non-null values in that column
from state;

-- The area of the smallest and largest parks.
select MAX (area) as largest, MIN (area) as smallest
from park;

-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
select state_abbreviation, count(*) as num_cities
from city
group by state_abbreviation
order by num_cities desc;

-- Determine the average park area depending upon whether parks allow camping or not.
select has_camping, avg(area) as avg_park_area
from park
group by has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
select state_abbreviation, sum(population) as total_population
from city
group by state_abbreviation
order by state_abbreviation;

-- The smallest city population in each state ordered by city population.
select city_name, state_abbreviation, MIN (population) as smallest_city_population
from city
group by city_name, state_abbreviation
order by smallest_city_population;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
select *
from city
order by city_name
offset 0 rows fetch next 10 rows only;

--can also be entered as below
select *
from city
order by city_name
offset 0 limit 10;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
select COUNT(*) AS num_cities, (SELECT state_name FROM state WHERE state_abbreviation = c.state_abbreviation)
from city AS c
group by state_abbreviation
order by num_cities;

-- Include the names of the smallest and largest parks
select park_name, area
from park p, --we dont have to use the as in tables
	(
		SELECT MIN (area) as smallest, MAX (area) as largest
		from park
	) as largest_smallest
WHERE p.area = largest_smallest.smallest OR p.area = largest_smallest.largest;	

-- List the capital cities for the states in the Northeast census region.

