//*******************************************************************************************************//
//Calculates the probability of 2 dies of varibale number of sides will combine to a particular value.   //
//There are 3 diffrent modes:                                                                            //
//Mode 0: Just does the calculations.                                                                    //
//Mode 1: Prints the probability array data.                                                             //
//Mode 2: Prints the raw count of values and the probability array data.                                 //
//By Jenna Marx                                                                                          //
//*******************************************************************************************************//
public class dieprobcalc {

	//Main for testing
	public static void main(String[] args) {
		double[] t1 = dieprobability(4,4,0);
		String s1 = printprobability(t1);
		System.out.println(s1);
		dieprobability(4,8,2);
	}
	
	//Calulates the probability
	//Input: Number of sides of first die, number of sides of second die, mode used
	//Outputs: Double array of probabilities. The first index is the probability of rolling snake eyes(2).
	public static double[] dieprobability(int a, int b, int mode)
	{
		//array [2,..,a*b]
		//Calculates total number of combinations for value
		int[] result = new int[a+b-1];
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<b;j++)
			{
				result[i+j] += 1;
			}
		}
		//Prints by mode 2
		if(mode > 1)
		{
			String s = "Results of " + Integer.toString(a) + "x" + Integer.toString(b) + "\n";
			for(int i=0;i<result.length;i++)
			{
				s += Integer.toString(i+2) + "-" + Integer.toString(result[i]) + "\n";
			}
			System.out.println(s);
		}
		//Calculates probability of value based on umber of combinations of that value
		double[] probabilitys = new double[a+b-1];
		double probability = (1.0/a)*(1.0/b); //Probability of getting any single combination of values.
		for(int j=0;j<result.length;j++)
		{
			probabilitys[j] = probability*result[j];
		}
		//Prints by mode 1 and 2
		if(mode > 0)
		{
			System.out.println(printprobability(probabilitys));
		}
		return probabilitys;
	}
	
	//Generates string containing the double array produces in previus methoed
	//pssss. it makes it pretty.
	public static String printprobability(double[] arg)
	{
		String toreturn = "Probability of\n";
		for(int i=0;i<arg.length;i++)
		{
			toreturn += Integer.toString(i+2) + "-" + Double.toString(arg[i]) + "\n";
		}
		return toreturn;
	}
}
