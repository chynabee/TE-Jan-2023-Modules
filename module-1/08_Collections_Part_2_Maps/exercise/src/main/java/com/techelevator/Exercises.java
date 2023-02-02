package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

    /*1.
     * Given the name of an animal, return the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "Herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * animalGroupName("giraffe") → "Tower"
     * animalGroupName("") -> "unknown"
     * animalGroupName("walrus") -> "unknown"
     * animalGroupName("Rhino") -> "Crash"
     * animalGroupName("rhino") -> "Crash"
     * animalGroupName("elephants") -> "unknown"
     *
     */
    public String animalGroupName(String animalName) {

        Map<String, String> animalNames1 = new HashMap<>();

        animalNames1.put("rhino", "Crash");
        animalNames1.put("giraffe", "Tower");
        animalNames1.put("elephant", "Herd");
        animalNames1.put("lion", "Pride");
        animalNames1.put("crow", "Murder");
        animalNames1.put("pigeon", "kit");
        animalNames1.put("flamingo", "Pat");
        animalNames1.put("deer", "Herd");
        animalNames1.put("dog", "Pack");
        animalNames1.put("crocodile", "Float");

        if (animalName != null && animalNames1.containsKey(animalName.toLowerCase())) {
            return animalNames1.get(animalName.toLowerCase());


        }

        return "unknown";
    }

    /*2.
     * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
     * If the item is not on sale, return 0.00.
     *
     * If the item number is empty or null, return 0.00.
     *
     * "KITCHEN4001" -> 0.20
     * "GARAGE1070" -> 0.15
     * "LIVINGROOM"	-> 0.10
     * "KITCHEN6073" -> 0.40
     * "BEDROOM3434" -> 0.60
     * "BATH0073" -> 0.15
     *
     * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
     * should all return 0.20.
     *
     * isItOnSale("kitchen4001") → 0.20
     * isItOnSale("") → 0.00
     * isItOnSale("GARAGE1070") → 0.15
     * isItOnSale("dungeon9999") → 0.00
     *
     */
    public double isItOnSale(String itemNumber) {
        Map<String, Double> salePrice = new HashMap<>();

        salePrice.put("kitchen4001", 0.20);
        salePrice.put("garage1070", 0.15);
        salePrice.put("livingroom", 0.10);
        salePrice.put("kitchen6073", 0.40);
        salePrice.put("bedroom3434", 0.60);
        salePrice.put("bath0073", 0.15);

        if (itemNumber != null && salePrice.containsKey(itemNumber.toLowerCase())) {
            return salePrice.get(itemNumber.toLowerCase());
        }


        return 0.00;
    }

    /*3.
     * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
     * but only if Paul has less than $10s.
     *
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     *
     * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
     * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
     * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
     * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
     *
     */
    public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

        int peterMoney = peterPaul.get("Peter");
        int paulMoney = peterPaul.get("Paul");

        int halfOfPeterMoney = peterMoney / 2;
        int newPaulMoney = paulMoney + halfOfPeterMoney;


        if (peterMoney > 0 && paulMoney < 1000) {
            peterPaul.put("Paul", newPaulMoney);
            peterPaul.put("Peter", peterMoney - halfOfPeterMoney);


        }
        return peterPaul;

    }


    /*4.
     * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
     * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
     * current worth.
     *
     * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
     * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
     *
     */
    public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

        //if peter greater than 5000 && Paul greater than 10000
        int peterMoney = peterPaul.get("Peter");
        int paulMoney = peterPaul.get("Paul");
        int peterPartnerMoney = peterMoney / 4;
        int paulPartnerMoney = paulMoney / 4;
        int partnershipTotal = peterPartnerMoney + paulPartnerMoney;

        if (peterMoney >= 5000 && paulMoney >= 10000) {
            peterPaul.put("Peter", peterMoney - peterPartnerMoney);
            peterPaul.put("Paul", paulMoney - paulPartnerMoney);
            peterPaul.put("PeterPaulPartnership", partnershipTotal);
        }
        return peterPaul;


    }

    /*5.
     * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
     * there is a key of its first character with the value of its last character.
     *
     * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
     * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
     * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
     */
    public Map<String, String> beginningAndEnding(String[] words) {

        Map<String, String> beginEnd = new HashMap<>();

        for (String firstLast : words) {
            String firstLetter = firstLast.substring(0, 1);
            String lastLetter = firstLast.substring(firstLast.length() - 1);
            beginEnd.put(firstLetter, lastLetter);

        }

        return beginEnd;
    }

    /*6.
     * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
     * number of times that String appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
     * wordCount([]) → {}
     * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
     *
     */
    public Map<String, Integer> wordCount(String[] words) {

        Map<String, Integer> newWordCount = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (newWordCount.containsKey(words[i])) {
                Integer countNextOne = newWordCount.get(words[i]) + 1;
                newWordCount.put(words[i], countNextOne);
            } else {
                newWordCount.put(words[i], 1);
            }
        }


        return newWordCount;
    }

    /*7.
     * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
     * number of times that int appears in the array.
     *
     * ** The lesser known cousin of the the classic wordCount **
     *
     * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
     * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
     * intCount([]) → {}
     *
     */
    public Map<Integer, Integer> integerCount(int[] ints) {
        Map<Integer, Integer> integerCount = new HashMap<>();


        for (int newNumbers : ints) {
            if (!integerCount.containsKey(newNumbers)) {
                integerCount.put(newNumbers, 1);

            } else {
                int currentCount = integerCount.get(newNumbers);
                currentCount++;
                integerCount.put(newNumbers, currentCount);
            }
        }

        return integerCount;
    }

    /*8.
     * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
     * is true only if that String appears 2 or more times in the array.
     *
     * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
     * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     *
     */
    public Map<String, Boolean> wordMultiple(String[] words) {

        Map<String, Boolean> newMultWord = new HashMap<String, Boolean>();
        for (String multWord : words) {
            if (newMultWord.containsKey(multWord)) {
                newMultWord.put(multWord, true);
            } else newMultWord.put(multWord, false);
        }
        return newMultWord;
    }


    /*9.
     * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
     * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
     *
     * Unmatched keys and their int values in Map2 are simply added to Map1.
     *
     * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
     * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
     *
     */
    public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
                                                     Map<String, Integer> remoteWarehouse) {


        return null;
    }

    /*10.
     * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
     *
     * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
     * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
     *
     * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
     * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
     * end subString, which we don't count.
     *
     * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
     *
     * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
     *
     */
    public Map<String, Integer> last2Revisited(String[] words) {

        //Step 2: Declare the variable that we are going to return
        //it will always be the data type right before the method name
        Map<String, Integer> last2Map = new HashMap<>();


        //Step 3: Scan the problem for any keywords like "for, "for each", "if", and use those to help guide you
        //through the logic to solve the problem
        for (String word : words) {
            //String comes from info "last2Revisited(String) and words comes from "last2Revisited(String)[] "words")

            String last2char = word.substring(word.length() - 2); // look at the whole "word" then check last two
            int counter = 0; // establish a counter since we are counting

            //We have to use a normal for loop because we need to use the index to get our current letter
            //and the next letter
            for (int i = 0; i < word.length() - 2; i++) { //use -2 because we dont need to call the last two char since
                //we already called them up above in last2char

                String current2char = word.substring(i, i + 2);
                if (current2char.equals(last2char)) {
                    counter++; // we use counter++ to show the amount of times the string is shown
                }

            }

            last2Map.put(word, counter); //this will be what shows on the map to the right that we create
        }


            //Step 1: return the variable that we want to create
            return last2Map;

    }
}


