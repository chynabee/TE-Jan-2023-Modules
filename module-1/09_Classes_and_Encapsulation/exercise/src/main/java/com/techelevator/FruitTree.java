package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;


    //Constructor
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;

    }

    //Getters
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    //Method Called
    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft > 0) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;

            return true;

        } else {
            return false;
        }
    }
}