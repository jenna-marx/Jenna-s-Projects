//***********************************************************************************//
//Calculates the direction the robot is faceing based on the list of instructions.   //
//The Robot defaults to starting facing north.                                       //
//By Jenna Marx                                                                      //
//***********************************************************************************//
public class robot {

	//Main for testing
	public static void main(String[] args) {
		String t1 = turnRobot(new String[] {"L"});
		String t2 = turnRobot(new String[] {"L","L"});
		String t3 = turnRobot(new String[] {"R"});
		String t4 = turnRobot(new String[] {"L","R","R","R","R"});
		String t5 = turnRobot(new String[] {"L","L","L","L","L"});
		String t6 = turnRobot(new String[] {"R","R","R","R","R"});
		String t7 = turnRobot(new String[] {});
		//System.out.println(t5);
		System.out.println(t7);
	}

	//Default Shell Metheod
	public static String turnRobot(String[] instructions)
	{
		return turnRobot(instructions,"North")
	}

	//The metheod that clculates everything.
	//Translates direction to integer for eass of tracking
	//  0
	//  |
	//3-+-1
	//  |
	//  2
	public static String turnRobot(String[] instructions,String start)
	{
		//  0
		//  |
		//3-+-1
		//  |
		//  2

		//Sets inital direction.
		int direction = 0;
		switch (start){
		case "North": direction = 0;
		case "East": direction = 1;
		case "South": direction = 2;
		case "West": direction = 3;
		default: direction = 0;
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
				direction = (direction-1)%4;
			}
			else
			{
				direction = (direction+1)%4;
			}
		}

		//Translate back to direction
		switch (direction){
		case 0: return "North";
		case 1: return "East";
		case 2: return "South";
		case 3: return "West";
		default: return "Something went wrong";
		}
		//return "Hi there";
	}
}
