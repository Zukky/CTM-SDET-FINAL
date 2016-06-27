package support;

public class URLs {

	public static final String baseURL = "https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TST";
	public static final String expectedBaseURL = "https://energy.comparethemarket.com/energy/v2/";
	public static final String yourEnergyWithBillURL = "https://energy.comparethemarket.com/energy/v2/yourEnergy";
	public static final String yourEnergyNoBillURL = "https://energy.comparethemarket.com/energy/v2/yourEnergyNoBill";
	public static final String yourPreferencesURL = "https://energy.comparethemarket.com/energy/v2/yourDetails";
	
	public String URLcheck = null;

	public void setURLtoYourEnergyWithBill(){
		URLcheck = yourEnergyWithBillURL;
	}
	public void setURLtoYourEnergyNoBill(){
		URLcheck = yourEnergyNoBillURL;
	}
	
}
