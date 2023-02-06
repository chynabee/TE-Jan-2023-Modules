package com.techelevator;

public class BuyoutAuction extends Auction
{
    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice)
    {
        super(itemForSale);

        this.buyoutPrice = buyoutPrice;
    }

    public int getBuyoutPrice()
    {
        return this.buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid)
    {
        Bid newBid = offeredBid;

        // if bid is too high, change bid amount to buyout price
        if(offeredBid.getBidAmount() > buyoutPrice)
        {
            newBid = new Bid(offeredBid.getBidder(), buyoutPrice);
        }

        return super.placeBid(newBid);
    }
}
