
public class Bot extends Player
{
	private boolean easy;
	private boolean medium;
	private boolean hard;
	
	
	public Bot (int difficulty)
	{	
		setDifficulty(difficulty);
		System.out.println(getDifficulty());
	}
	
	
	public String getDifficulty ()
	{
		String difficulty = "invalid difficulty";
		if (easy)
		{
			difficulty = "easy";
		}
		if (medium)
		{
			difficulty = "medium";
		}
		if (hard)
		{
			difficulty = "hard";
		}
		return difficulty;
	}
	
	public void setDifficulty (int difficulty)
	{
		switch (difficulty)
		{
			case 0:  easy = true;
					 break;
			case 1:  medium = true;
					 break;
			case 2:  hard = true;
					 break;
		}
	}
}
