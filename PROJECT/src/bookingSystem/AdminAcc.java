package bookingSystem;

public class AdminAcc extends UserAcc
{
	private String securityCode;
	
	public AdminAcc()
	{
		
	}

	public String getSecurityCode() 
	{
		return securityCode;
	}

	public void setSecurityCode(String securityCode) 
	{
		this.securityCode = securityCode;
	}
	
}
