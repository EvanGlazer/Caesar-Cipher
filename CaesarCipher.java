
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
	
	static double percent(int num1, int num2)
	{
		return (((double)num1/(double)num2)*100);
	}
	static double[] freqs(String str) 
	{
		double[] freq = new double[str.length()];
		
		for(int i=0; i<str.length()-1; i++)
		{
			char c1 = str.charAt(i);
			//System.out.println(c1);
			char c2 = str.charAt(i+1);
			
			if(let2nat(c2) == 0)
			{
				freq[i] = (percent(let2nat(c2)+1, let2nat(c1)));	
				System.out.println("if: "+freq[i]);
				continue;
			}
			else if (let2nat(c1) == 0)
			{
				freq[i] = 0.0;
				System.out.println("else if: " + freq[i]);
				continue;
			}
			else
			{
				freq[i] = (percent(let2nat(c1), let2nat(c2)));	
				System.out.println("else : " + freq[i]);
				continue;
			}
			
		}
		
		return freq;
	}
	
	public static void main(String[] args)
	{
		System.out.println(let2nat('a'));
		System.out.println(nat2let(0));
		System.out.println(shift(3,'h'));
		System.out.println(encode(3,"haskellisfun"));
		System.out.println(decode(3, "kdvnhoolvixq"));
		System.out.println(lowers("haskellisfun"));
		System.out.println(count('s', "haskellisfun"));
		System.out.println(percent(2, 12));
		System.out.println(freqs("haskellisfun"));
	}
	
	
	
	
	
	
}
