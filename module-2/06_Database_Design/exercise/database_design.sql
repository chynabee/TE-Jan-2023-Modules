-- PUT YOUR SQL TO GENERATE THE DATABASE HERE. MAKE SURE TO SAVE FREQUENTLY!

BEGIN TRANSACTION;

DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS member_event;
DROP TABLE IF EXISTS group_members;
DROP TABLE IF EXISTS interest_group;
DROP TABLE IF EXISTS members;


CREATE TABLE members (
	member_id serial PRIMARY KEY,
	last_name varchar(100) NOT NULL,
	first_name varchar(100) NOT NULL,
	email varchar(100),
	phone_number varchar(20),
	date_of_birth date,
	reminder_email boolean


);



CREATE TABLE interest_group (
	group_number serial PRIMARY KEY,
	group_name varchar (100) NOT NULL,
	number_of_members int NOT NULL



);

CREATE TABLE group_members (
	group_number int,
	member_id int,
	
	CONSTRAINT fk_group_members_members FOREIGN KEY (member_id) REFERENCES members(member_id),
	CONSTRAINT fk_group_members_interest_group FOREIGN KEY (group_number) REFERENCES interest_group(group_number)


);



CREATE TABLE member_event (
	member_id int,
	event_number int



);


CREATE TABLE events (
	event_number serial PRIMARY KEY,
	event_name varchar (100),
	description text,
	start_date_time TIMESTAMP,
	duration_in_minutes int,
	group_number int,
	
	
	CONSTRAINT fk_events_interest_group FOREIGN KEY (group_number) REFERENCES interest_group(group_number)
	

);

INSERT INTO members (last_name, first_name, email, phone_number, date_of_birth, reminder_email)
VALUES ('Broyles', 'Chyna', 'chynabroyles@gmail.com', '330-330-3300', '07/27/1988', true),
		('Brown', 'Alfreda', 'alfredabrown@gmail.com', '330-123-4567', '09/14/1963', false),
		('Scott', 'Callie', null, '330-234-1234', '10/08/2013', null),
		('Broyles-Garner', 'Carsen', 'cbg@gmail.com', null, '09/17/2011', false),
		('Broyles', 'LaMar', null, null, '03/25/1984', null),
		('Broyles', 'Joseph', null, null, null, null),
		('Combs', 'Sean', 'diddydirtymoney@gmail.com', '330-234-0998', null, true),
		('Love', 'Sherman', 'misterlove@gmail.com', '773-123-0099', '06/26/1988', true);


INSERT INTO interest_group (group_name, number_of_members)
VALUES ('Prestigious Pose Pros', 2),
		('BEE THE CHANGE', 3),
		('Tech READY', 4);
		
INSERT INTO events (event_name,description, start_date_time,duration_in_minutes, group_number)		
VALUES ('AfroTech', 'Black Professionals in Tech Networking Event', '11/01/2023 08:00:00', 240, 1),
		('A Night in Paris', 'Tech Ready Graduation and New Beginnings Celebration', '05/01/2023 20:00:00', 120, 3),
		('House Warming', 'Habitat for Humanity celebrates new homeowners', '09/23/2023 03:00:00', 300, 1),
		('Legends of the Streets Tour', '6 Legends in Entertainment perform together on one stage', '03/04/2023 19:00:00', 240, 2);



INSERT INTO member_event (member_id, event_number)
VALUES (1, 2);

INSERT INTO member_event (member_id, event_number)
VALUES (2, 1);

INSERT INTO member_event (member_id, event_number)
VALUES (3, 3);

INSERT INTO member_event (member_id, event_number)
VALUES (4, 4);

INSERT INTO member_event (member_id, event_number)
VALUES (1, 1), (1, 3), (1, 4);

INSERT INTO group_members(group_number,member_id)
VALUES (1, 1), (1, 5);

INSERT INTO group_members(group_number,member_id)
VALUES (2, 1), (2, 2), (2, 6);

INSERT INTO group_members(group_number,member_id)
VALUES (3, 1), (3, 5), (3, 6), (3, 7);



COMMIT;
