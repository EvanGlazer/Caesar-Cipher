public class CaesarCipher {
	static double[] table = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0, 0.2, 0.8, 4.0, 2.4, 6.7,
			7.5, 1.9, 0.1, 6.0, 6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};
	
	// converts to number
	static int let2nat(char c)
	{	
		int ascii = (int) c;
		int num = ascii -97;
		return num;
	}
	
	// converts to letter
	static char nat2let(int code)
	{
		char ascii = (char)(code + 97);
		return ascii;
	}
	
	// shift the characters
	static char shift(int shftAmt, char c)
	{
		int shift = (int) (c-97) + shftAmt;
		return nat2let(shift);
	}
	
	// deshift the characters
	static char deshift(int shftAmt, char c)
	{
		int shift = (int) (c-97) - shftAmt;
		return nat2let(shift);
	}
	
	// encodes string
	static String encode(int shftAmt, String str)
	{
		// gets each char on string and concerts and shifts
		char [] convert = new char[str.length()];
		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
		
			convert[i] = shift(3, c);
		}
		
		String output = new String(convert);
		
		return output;
	}
	
	// decodes string
	static String decode(int shftAmt, String str)
	{
		// gets each char on string and concerts and shifts
				char [] convert = new char[str.length()];
				for(int i=0; i<str.length(); i++)
				{
					char c = str.charAt(i);
				
					convert[i] = deshift(3, c);
				}
				
				String output = new String(convert);
				
				return output;

	}
	
	// calculates string length
	static int lowers(String str)
	{
		return str.length();
	}
	
	// calculates the number of a given character in a string
	static int count(char c, String str)
	{
		int counter = 0;
		// gets each char on string and concerts and shifts
		char [] convert = new char[str.length()];
		for(int i=0; i<str.length(); i++)
		{
			char c1 = str.charAt(i);
			if( c1 == c)
			{
				counter++;
			}
		}
		return counter;
	}
	
	static double percent(int num, int num2)
	{
		return (((double)num/(double)num2)*100);
	}
	
  static double[] freqs(String str) 
	{
		    double[] freqs = new double[26];
	        char[] strArray = str.toCharArray();
	        for (int i = 0; i < freqs.length; i++)
	        {
	            freqs[i] = percent(count(nat2let(i), str), str.length());
	        }
	        return freqs;
	}
	
  static double[] rotate(int n, double[] table)
	    {
	        for(int i = 0; i < n; i++)
	        {
	            double temp = table[0];
	            for (int j = 0; j < table.length - 1; j++)
	            {
	            	table[j] = table[j+1];
	            }
	            table[table.length - 1] = temp;
	        }
	        return table;
	    }

  static double chisqr(double[] os)
	    {
	        double sum = 0.0;
	        for (int i = 0; i < os.length; i++)
	        {
	            sum += Math.pow((os[i] - table[i]), 2) / table[i];
	        }
	        return sum;
	    }

 static int position(double a, double[] list)
	    {
	        for (int i = 0; i < list.length; i++)
	        {
	            if (list[i] == a)
	            {
	                return i;
	            }
	        }
	        return -1;
	    }

 static double findMinimum(double[] list)
	    {
	        double min = list[0];
	        for (int i = 1; i < list.length; i++)
	        {
	            if (min > list[i])
	            {
	            	min = list[i];
	            }
	        }
	            
	        return min;
	    }

 static String crack(String str)
	    {
	        double[] chisqrValues = new double[26];
	        for (int i = 0; i < chisqrValues.length; i++)
	        {
	            chisqrValues[i] = chisqr(rotate(i, freqs(str)));
	        }
	        
	        int shiftAmt = position(findMinimum(chisqrValues), chisqrValues);
	        return decode(shiftAmt, str);
	    }


	public static void main(String[] args)
	{
		
	}
	
	
	
	
	
	
}
