package Git;

//*************************************************************************************//
//Calculates the direction the robot is facing based on the list of instructions.      //
//The Robot defaults to starting facing north and stopping 4 times around the circle.  //
//By Jenna Marx                                                                        //
//*************************************************************************************//
public class robotv3 {

	//Main for testing
	public static void main(String[] args) {
		/*
		String t1 = turnRobot(new String[] {"L"});
		String t2 = turnRobot(new String[] {"L","L"});
		String t3 = turnRobot(new String[] {"R"});
		String t4 = turnRobot(new String[] {"L","R","R","R","R"});
		String t5 = turnRobot(new String[] {"L","L","L","L","L"});
		String t6 = turnRobot(new String[] {"R","R","R","R","R"});
		String t7 = turnRobot(new String[] {});
		//System.out.println(t5);
		//System.out.println(t1);
		*/
		String t8 = turnRobot(new String[] {"R"},"North");
		String t9 = turnRobot(new String[] {"L","L","L"},3);
		String t10 = turnRobot(new String[] {"R"},"East",8);
		System.out.println(t9);
		System.out.println(t10);
	}

	//Default Shell Method.
	public static String turnRobot(String[] instructions)
	{   
		return turnRobot(instructions,"North",4);
	}
	
	//Secondary Shell Method.
	public static String turnRobot(String[] instructions,String start)
	{
		return turnRobot(instructions,start,4);
	}
	
	//Third Variation.
	public static String turnRobot(String[] instructions,int stops)
	{
		return turnRobot(instructions,"North",stops);
	}

	//The method that calculates everything.
	//Translates direction to integer for ease of tracking.
	//  0
	//  |
	//3-+-1
	//  |
	//  2
	public static String turnRobot(String[] instructions,String start, int stops)
	{
		//  0
		//  |
		//3-+-1
		//  |
		//  2

		//Sets inital direction.
		double direction = 0.0;
		//Sets list of direction and value pairs. Uses custom class at bottom of file.
		Pair[] directions = new Pair[] {new Pair("North",0.0),new Pair("North Northeast",0.25),new Pair("Northeast",0.5),new Pair("East Northeast",0.75),
			new Pair("East",1.0),new Pair("East Southeast",1.25),new Pair("Southeast",1.5),new Pair("South Southeast",1.75),new Pair("South",2.0),
			new Pair("South Southwest",2.25),new Pair("Southwest",2.5),new Pair("West Southwest",2.75),new Pair("West",3.0),new Pair("West Northwest",3.25),
			new Pair("Northwest",3.5),new Pair("North Northwest",3.75)};

		//Sets starting direction.
		for(int i=0;i<directions.length;i++)
		{
			if(start.equals(directions[i].cardinal))
			{
				direction = directions[i].value;
			}
		}

		//Iterate threw list
		for(int i=0;i<instructions.length;i++)
		{
			if(instructions[i] == "L")
			{
				if(direction==0)
				{
					direction+=4;
				}
				direction = (direction-(4.0/stops))%4.0;
			}
			else
			{
				direction = (direction+(4.0/stops))%4.0;
			}
		}

		//Translate back to closest direction
		if(4.0-direction <= 0.125)
		{
			return directions[0].cardinal;
		}
		for(int i=0;i<directions.length;i++)
		{
			if(Math.abs(direction-directions[i].value) <= 0.125)
			{
				return directions[i].cardinal;
			}
		}
		return "Something went wrong";
		//return "Hi there";
	}

	//Custom Pair class.
	public static class Pair{
		public String cardinal;
		public double value;

		public Pair(String arg1, double arg2)
		{
			cardinal = arg1;
			value = arg2;
		}
		
		public String toString()
		{
			return "(" + cardinal + "," + Double.toString(value) + ")";
		}
	}
}
