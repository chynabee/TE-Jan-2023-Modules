package com.techelevator;

import java.util.ArrayList;
import java.util.List;

// this is what the Auction class would look like without inheritance
public class AuctionOld
{

	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;

	private boolean isReserveAuction;
	private int reservePrice = 0;
	private boolean isBuyoutAuction;
	private int buyoutPrice = 0;

	public AuctionOld(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}

	public AuctionOld(String itemForSale, boolean isReserveAuction, int reservePrice, boolean isBuyoutAuction, int buyoutPrice)
	{
		// if calling another constructor
		// this MUST be the first call in the function
		this(itemForSale);

		this.isReserveAuction = isReserveAuction;
		this.reservePrice = reservePrice;
	}
	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;

		if(isReserveAuction)
		{
			if (offeredBid.getBidAmount() >= reservePrice && offeredBid.getBidAmount() > currentHighBid.getBidAmount())
			{
				currentHighBid = offeredBid;
				isCurrentWinningBid = true;
			}
		}
		else if(isBuyoutAuction)
		{

		}
		else if (offeredBid.getBidAmount() > currentHighBid.getBidAmount())
		{
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}

		return isCurrentWinningBid;
	}

	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
}
