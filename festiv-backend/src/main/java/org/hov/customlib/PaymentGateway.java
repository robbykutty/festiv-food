package org.hov.customlib;

public class PaymentGateway 
{
	PaymentGateway()
	{
		String transactionId = ""; 
		//transactionId = createTransaction();
	}
	
	public boolean paymentByInstaMojo()
	{	
		try
		{
			//instaMojo Logic

			//if (updateTransactionStatusSuccessById(transactionId))
			if(true)
			{
				return true;
			}
			else
			{
				return false;	
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception---<-This exception is hidden for security reasons");
			return false;
		}
		
	}
}
