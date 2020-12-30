
public class House {
	private String address;
	private int zip;
	private int age;
	private double bedNumber;
	private double bathNumber;
	private double sqft;
	private double sqftLot;
	private double costOfHome;
	

	
	public House(String address, int zip, int age, double bedNumber, double bathNumber,
				 double sqft,	double sqftLot,	double costOfHome) 
	{
		this.address = new String(address);
		this.zip = zip;
		this.age = age;
		this.bedNumber = bedNumber;
		this.bathNumber = bathNumber;
		this.sqft = sqft;
		this.sqftLot = sqftLot;
		this.costOfHome = costOfHome;
	}
	
	public House() 
	{
		this.address = "default Home";
		this.age = 0;
		this.bedNumber = 0;
		this.bathNumber = 0;
		this.sqft = 0;
		this.sqftLot = 0;
		this.costOfHome = 0;
		this.zip = 0;
	}
	
	public String toString()
	{
		return bedNumber+" "+bathNumber+" "+sqft+" "+sqftLot+" "+zip+ " "+age+" "+ costOfHome+" "+"ad"+address+"adf";
	}
	
	public static double convertAcreToSqft(double acre)
	{
		
		return 43560*acre;
		
	}
}
