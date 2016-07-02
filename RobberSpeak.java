public class RobberSpeak
{
	//Translates "Robberspeak" (Rovarspraket)
	//DailyProgrammer Easy challenge #212
	public static void main(String[] args)
	{
		if(args.length < 2)
		{
			System.out.println("Invalid arguments. Provide a mode (e/d) and string.");
		}
		else if(args[0].equals("e"))
		{
			args[0] = "";
			for(String word : args)
			{
				System.out.print(encode(word) + " ");
			}
			System.out.print("\n");
		}
		else if(args[0].equals("d"))
		{
			args[0] = "";
			for(String word : args)
			{
				System.out.print(decode(word) + " ");
			}
			System.out.print("\n");
		}
	}

	public static String encode(String text)
	{
		char[] input = text.toCharArray();
		String output = "";
		for(char c : input)
		{
			if((""+c).matches("[^aeiou]") && Character.isLetter(c))
			{
				output = output + c + "o" + c;
			}
			else{output = output + c;}
		}
		return output;
	}

	public static String decode(String text)
	{
		char[] input = text.toCharArray();
		String output = "";
		for(int i = 0; i < input.length; i++)
		{
			if(i == 0)
			{
				output = output+input[i];
			}
			else if(i == input.length-1)
			{
				output = output+input[i];
			}
			else if(input[i] == 'o' && input[i-1] == input[i+1] && (""+input[i-1]).matches("[^aeiou]") && Character.isLetter(input[i-1]))
			{
				input[i+1] = ' ';
				i++;
			}
			else{output = output + input[i];}
		}
		return output;
	}
}