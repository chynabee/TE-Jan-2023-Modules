package com.techelevator;

public class ReserveAuction extends Auction
{
    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice)
    {
        // call to super MUST be the first call
        super(itemForSale);

        this.reservePrice = reservePrice;
    }

    public int getReservePrice()
    {
        return reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid)
    {
        // make sure the big meet the CURRENT requirements
        if(offeredBid.getBidAmount() >= reservePrice)
        {
            // re-use the parent logic here
            return super.placeBid(offeredBid);
        }

        return false;
    }

}
