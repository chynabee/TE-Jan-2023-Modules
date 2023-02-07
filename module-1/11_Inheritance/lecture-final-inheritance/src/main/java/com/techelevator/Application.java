package com.techelevator;


import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        Bid winningBid = generalAuction.getHighBid();
        System.out.println("WINNER: " + winningBid.getBidder());
        System.out.println("$" + winningBid.getBidAmount());

        System.out.println();
        System.out.println("All Bids");
        System.out.println("--------------");

        List<Bid> allBids = generalAuction.getAllBids();
        for(int i = 0; i < allBids.size(); i++)
        {
            Bid bid = allBids.get(i);
            System.out.println(bid.getBidder() + ": $" + bid.getBidAmount());
        }

        System.out.println();

        for(Bid bid : generalAuction.getAllBids())
        {
            System.out.println(bid.getBidder() + ": $" + bid.getBidAmount());
        }

        System.out.println();
        System.out.println();
        System.out.println("Reserve Auction");
        System.out.println("---------------");

        ReserveAuction reserveAuction = new ReserveAuction("TE Mug",20);
        reserveAuction.placeBid(new Bid("Christopher", 15));
        reserveAuction.placeBid(new Bid("Josh", 20));
        reserveAuction.placeBid(new Bid("Christopher", 25));

        System.out.println("Winner: " + reserveAuction.getHighBid().getBidder());
        System.out.println("Paid $" + reserveAuction.getHighBid().getBidAmount());
        System.out.println("Reserve Price: $" + reserveAuction.getReservePrice());


        System.out.println();
        System.out.println();
        System.out.println("Buyout Auction");
        System.out.println("---------------");

        BuyoutAuction buyoutAuction = new BuyoutAuction("TE Mug",20);
        buyoutAuction.placeBid(new Bid("Christopher", 15));
        buyoutAuction.placeBid(new Bid("Josh", 20));
        buyoutAuction.placeBid(new Bid("Christopher", 25));

        System.out.println("Winner: " + buyoutAuction.getHighBid().getBidder());
        System.out.println("Paid $" + buyoutAuction.getHighBid().getBidAmount());
        System.out.println("Buyout Price: $" + buyoutAuction.getBuyoutPrice());

        System.out.println();
        for(Bid bid : buyoutAuction.getAllBids())
        {
//            System.out.println(bid.getBidder() + " : $" + bid.getBidAmount());
            System.out.println(bid.toString());
        }
    }
}
