package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text)
	{
    	if(text.equals(""))
			{
    		return 0;
    	}
    	else if(text.contains(","))
			{
          if(text.contains("-"))
            {
							int[] numbs = getNegatives(text);
    					String str = "";
    					for(int num : numbs){
    							str = str + num + ",";
    					}

    					throw new IllegalArgumentException("Negatives not allowed: " + str);
            }
        return sum(splitNumbers(text));
    	}
    	else{
    		return 1;
    	}
  	}
//Add ends helpers begin.
		//Minus numbers not allowed.
		private static int[] getNegatives(String text)
		{
		  		String[] numbers = splitNumbers(text);
		  		int size = 0;
		  		for(String numb : numbers)
					{
		  			if(toInt(numb) < 0)
						{
		  				size++;
		  			}
		  		}
		  		int[] results = new int[size];
		  		int counter = 0;
		  		for(String number : numbers)
					{
		  			if(toInt(number) < 0)
						{
		  				results[counter] = toInt(number);
		  				counter++;
		  			}
		  		}
		  		return results;
		}

		//Cast to int.
  	private static int toInt(String number)
  	{
  		return Integer.parseInt(number);
  	}

		//Split numbers by ",".
  	private static String[] splitNumbers(String numbers)
		{
  		return numbers.split(",");
  	}
		//check if nuumber is greather than 1000.
		private static boolean checkSize(int number)
		{
			return !(number > 1000);
		}

		//Sum numbers
  	private static int sum(String[] numbers)
		{
  		int total = 0;
  		for(String number : numbers)
			{
				if(checkSize(toInt(number)))
				{
  				total += toInt(number);
				}
  		}
  		return total;
  	}

}
