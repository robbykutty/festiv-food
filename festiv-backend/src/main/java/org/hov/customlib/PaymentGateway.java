package org.hov.customlib;

public class PaymentGateway 
{
	//Pay with InstaMojo Gateway
	public boolean payByInstaMojo()
	{	
		try
		{
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}	
	
	//Pay with PayTM Gateway
	public boolean payByPayTM()
	{	
		try
		{
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
