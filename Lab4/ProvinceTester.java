
public class ProvinceTester 
{
	public static void main(String[] args)
	{
		Province ontario = new Province("Ontario",13600000,1076000);
		Province pei = new Province("PEI",146283,5660);
		
		// Expected Output:
		// Name: Ontario Population 13600000 Area 1076000.0 Density 12.639405204460967
		// Name: PEI Population 146283 Area 5660.0 Density 25.845053003533568 
		System.out.println("" + ontario.getProvinceStats() + " Density " + ontario.getPopulationDensity());
		System.out.println("" + pei.getProvinceStats() + " Density " + pei.getPopulationDensity());
	}
}
