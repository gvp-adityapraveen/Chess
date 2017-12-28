package code.fun.chess.players;

public class Player {
	
	String nameOfThePlayer;
	int noOfMatchesPlayed;
	int noOfMatchesWon;
	int noOfMatchesLost;
	
	void getAddressDetails()
	{}
	
	void setAddressDetails()
	{}
	
	String getNameOfThePlayer()
	{
		return this.nameOfThePlayer;
	}
	
	void setNameOfThePlayer(String name)
	{
		this.nameOfThePlayer = name;
	}
	
	int getNoOfMatchesPlayed()
	{
		return this.noOfMatchesPlayed;
	}
	
	void setNoOfMatchesPlayed(int noOfMatches)
	{
		this.noOfMatchesPlayed = noOfMatches;
	}
	
	int getNoOfMatchesWon()
	{
		return this.noOfMatchesWon;
	}
	
	void setNoOfMatchesWon(int count)
	{
		this.noOfMatchesWon = count;
	}
	
	int getNoOfMatchesLost()
	{
		return this.noOfMatchesPlayed-this.noOfMatchesWon;
	}
	
	void setNoOfMatchesLost(int count)
	{
		this.noOfMatchesLost = count;
	}

}
