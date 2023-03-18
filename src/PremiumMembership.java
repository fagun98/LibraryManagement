// Base class of Membership with overriding all functionality of membership
public class PremiumMembership extends Membership{

	int returnDayLimit()
	{
		return 30;
	}
	
	boolean isPremium()
	{
		return true;
	}
}
