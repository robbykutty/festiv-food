package org.hov.customlib;

import java.util.Random;

public class CodeGen 
{
	public String generateCode(int length)
	{	
		int no = 1;
		String randomNumber = null;	
		Random rand = new Random(); 
		while(length > 0)
		{
			no*=10;
			length--;
		}
        randomNumber = Integer.toString(rand.nextInt(no));	
		return randomNumber;
	}
}
