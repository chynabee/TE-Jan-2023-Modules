package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int playing = 3;
		int goHome = 2;
		int raccoons = playing - goHome;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int flowers = 5;
		int bees = 3;
		int lessBees = flowers - bees;


        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int lonelyPigeon = 1;
		int anotherPigeon = 1;
		int pigeonsEating = lonelyPigeon + anotherPigeon;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int owlsSitting = 3;
		int owlsJoining = 2;

		int owlsSiting = owlsSitting + owlsJoining;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int beaversWorking = 2;
		int beaversSwimming = 1;
		int beaversStillWorking = beaversWorking - beaversSwimming;


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int toucansSittingOnALimb = 2;
		int toucansJoiningOnALimb = 1;
		int totalToucansSittingOnALimb = toucansSittingOnALimb + toucansJoiningOnALimb;



        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int squirrelsInATree = 4;
		int numberOfNuts = 2;
		int numberOfSquirrelsOverNuts = squirrelsInATree - numberOfNuts;


        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarterFound = 0.25;
		double nickelFound = 0.05;
		double dimeFound = 0.10;
		double totalAmountOfMoneyFound = quarterFound + nickelFound + nickelFound + dimeFound;




        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int muffinsBakedInBriersClass = 18;
		int muffinsBakedInMacAdamsClass = 20;
		int muffinsBakedInFlanneryClass = 17;
		int totalMuffinsBaked = muffinsBakedInBriersClass + muffinsBakedInMacAdamsClass + muffinsBakedInFlanneryClass;


        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double costOfYoyo = 0.24;
		double costOfWhistle = 0.14;
		double totalMoneySpentOnToys = costOfYoyo + costOfWhistle;


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?

        */

		int inchesOfSnowHiltHouse = 29;
		int inchesofSnowSchool = 17;
		int differenceInInchesOfSnow = inchesOfSnowHiltHouse - inchesofSnowSchool;



        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */

		double amountOfMoney = 10.00;
		double amountOfMoneySpentOnToyTruck = 3.00;
		double amountOfMoneySpentOnPencilCase = 2.50;
		double totalAmountOfMoneyLeft = amountOfMoney - (amountOfMoneySpentOnToyTruck + amountOfMoneySpentOnPencilCase);


        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int marblesCollected = 16;
		int marblesLost = 7;
		int totalMarblesLeft = marblesCollected - marblesLost;


        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int totalSeashellsNeededInCollections = 25;
		int currentAmountOfSeashells = 19;
		int amountOfSeashellsNeeded = totalSeashellsNeededInCollections - currentAmountOfSeashells;




        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalBalloons = 17;
		int redBalloons = 8;
		int amountOfGreenBalloons = totalBalloons - redBalloons;



        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int booksOnTheShelf = 38;
		int additionalBooksOnTheShelf = 10;
		int totalBooksOnTheShelf = booksOnTheShelf + additionalBooksOnTheShelf;


        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int numberOfLegsBeesHave = 6;
		int numberofBees = 8;
		int totalAmountOfBeeLegs = numberOfLegsBeesHave * numberofBees;


        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double costOfIceCreamCone = 0.99;
		double amountOfIceCreamCones = 2;
		double totalCostOfIceCreamCones = costOfIceCreamCone * amountOfIceCreamCones;


        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int totalRocksNeededToComplete = 125;
		int totalRocks = 64;
		int amountOfRocksStillNeeded = totalRocksNeededToComplete - totalRocks;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int numberOfMarbles = 38;
		int numberOfMarblesLost = 15;
		int totalNumberOfMarbles = numberOfMarbles - numberOfMarblesLost;




        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int totalMilesDrivenToConcert = 78;
		int totalMilesDrivenToGas = 32;
		int totalMilesLeftToDrive = totalMilesDrivenToConcert - totalMilesDrivenToGas;


        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */

		int minutesSpentSaturdayMorning = 90;
		int minutesSpentSaturdayAfternoon = 45;
		int totalMinutesSpentShovelingSaturday = minutesSpentSaturdayMorning + minutesSpentSaturdayAfternoon;


        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		double costOfEachHotDog = 0.50;
		double amountOfHotDogs = 6;
		double totalAmountPaidForHotDogs = costOfEachHotDog * amountOfHotDogs;


        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		double totalAmountOfMoneyToSpend = 0.50;
		double costOfEachPencil = 0.07;
		int amountOfPencils  = (int)(totalAmountOfMoneyToSpend / costOfEachPencil);


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int totalNumberOfButterflies = 33;
		int orangeButterflies = 20;
		int amountOfRedButterflies = totalNumberOfButterflies - orangeButterflies;



        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?

        */
		 double totalAmountGiven = 1.00;
		 double costOfCandy = 0.54;
		 double amountOfChangeBack = totalAmountGiven - costOfCandy;


        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int numberOfTrees = 13;
		int numberOfTreesPlanted = 12;
		int totalNumberOfTrees = numberOfTrees + numberOfTreesPlanted;


        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int eachDayInHours = 24;
		int numberOfDays = 2;
		int totalNumberOfHours = eachDayInHours * numberOfDays;


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int numberOfCousins = 4;
		int piecesOfGum = 5;
		int totalAmountOfGumNeeded = numberOfCousins * piecesOfGum;


        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		double danTotalInCash = 3.00;
		double danTotalSpent = 1.00;
		double danTotalAmountLeft = danTotalInCash - danTotalSpent;


        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int totalBoatsOnLake = 5;
		int totalPeopleInEachBoat = 3;
		int totalPeopleOnLake = totalBoatsOnLake * totalPeopleInEachBoat;


        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int totalLegos = 380;
		int totalLegosLost = 57;
		int totalLegosLeft = totalLegos - totalLegosLost;


        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int totalMuffinsNeeded = 83;
		int totalMuffinsAlreadyBaked = 35;
		int totalMuffinsToBake = totalMuffinsNeeded - totalMuffinsAlreadyBaked;


        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willyTotalCrayons = 1400;
		int lucyTotalCrayons = 290;
		int totalCrayonsWillyHasMore = willyTotalCrayons - lucyTotalCrayons;


        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickersPerPage = 10;
		int amountOfPages = 22;
		int totalStickers = stickersPerPage * amountOfPages;


        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		double totalCupcakesToShare = 100.0;
		double numberOfChildren = 8.0;
		double totalCupcakesPerChild = totalCupcakesToShare/numberOfChildren;


        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */

		int totalCookiesToDistribute = 47;
		int totalCookiesInEachJar = 6;
		int totalCookiesNotInJar = totalCookiesToDistribute % totalCookiesInEachJar;


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */

		int totalPreparedCroissants = 59;
		int totalNeighbors = 8;
		int numberOfCroissantsPerNeighbor = totalPreparedCroissants % totalNeighbors;




        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int totalCookiesPerTray = 12;
		int totalCookiesToPrepare = 276;
		int totalTraysNeeded = totalCookiesToPrepare / totalCookiesPerTray;


        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int totalPretzelsMade = 480;
		int totalPretzelsPerServing = 12;
		int totalServingsOfPretzels = totalPretzelsMade/totalPretzelsPerServing;




        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int lemonCupcakesBaked = 53;
		int lemonCupcakesLeftHome = 2;
		int lemonCupcakesPerBox = 3;
		int boxesOfLemonCupcakesGivenAway = (lemonCupcakesBaked - lemonCupcakesLeftHome) / lemonCupcakesPerBox;


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int carrotSticksPrepared = 74;
		int peopleCarrotsSharedWith = 12;
		int carrotsLeftUneaten = carrotSticksPrepared % peopleCarrotsSharedWith;


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int totalTeddyBears = 98;
		int teddyBearsPerShelf = 7;
		int totalShelvesFilled = totalTeddyBears / teddyBearsPerShelf;


        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int picturesPerAlbum = 20;
		int totalPicturesCollected = 480;
		int totalAlbums = totalPicturesCollected / picturesPerAlbum;



        /* Exercise 48;

        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int tradingCardsCollected = 94;
		int cardsPerBox = 8;
		int boxesFilledWithCards = tradingCardsCollected / cardsPerBox;
		int remainderOfCards = tradingCardsCollected % cardsPerBox;


        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int booksToBeDistributed = 210;
		int totalShelvesForBooks = 10;
		int totalBooksPerShelf = booksToBeDistributed / totalShelvesForBooks;




        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		double totalBakedCroissants = 17.0;
		double guestsToServe = 7.0;
		double croissantsPerGuest = totalBakedCroissants / guestsToServe;




	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */

		double hoursBillTakesToPaintRoom = 1 / 2.15;
		double hoursJillTakesToPaintRoom = 1 / 1.90;
		double averageTakesBothToPaintOneRoom = hoursBillTakesToPaintRoom + hoursJillTakesToPaintRoom;
		double roomsToPaint = 5.0;
		double totalAmountOfTimeToPaintRooms = roomsToPaint / averageTakesBothToPaintOneRoom;

     

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */

		String firstName = "Grace";
		String lastName = "Hopper";
		String middleInitial = "B";
		String fullName = lastName + ", " + firstName + " " + middleInitial + ".";


	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */

		double trainTravelled = 537;
		double distanceBetween = 800;
		int percentageOfTrip = (int)((trainTravelled / distanceBetween)* 100.0);

	}

}
