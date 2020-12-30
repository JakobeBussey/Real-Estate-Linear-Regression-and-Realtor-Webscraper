
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
 
public class GetRelator {
	
	static String dataLocation = new String("D://Downloads//Years.html");
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		// TODO Auto-generated method stub
		System.out.println("Get links press one, get houses press two");
		Scanner pp = new Scanner(System.in);
		int b = pp.nextInt();
	if(b == 1)
	{
		
		System.out.println("Hi there, name the ZIPCODE you'd like to check.");
		Scanner kb = new Scanner(System.in);
		String zip = kb.nextLine();
		
		System.out.println("ZIP: "+zip);
		
		String url = "https://www.realtor.com/realestateandhomes-search/"+zip+"/type-single-family-home/pg-1";

		int page = getNumberOfPages(url);
		if (page != 0)
		{
		
		Object[] hip = getAllHomeLinks(page,url);
		
		System.out.println(""); 
		System.out.println(""); 
		
		ArrayList<String> homeLinks = (ArrayList<String>) hip[0];
		ArrayList<String> homeTexts = (ArrayList<String>) hip[1];
		String doctext = (String) hip[2];
		
		ArrayList<House> houses = makeAllHomesSuper(homeTexts,homeLinks,doctext);
		String writedata = "";
		System.out.println("");
		System.out.println("");
		

		
		writeLinks(homeLinks);
		writeData(houses);
		}
		else
		{
			System.out.println("Oh no! You were caught as a bot. Wait for an hour and try again.");
		}

	}
	else if(b == 2)
	{
		ArrayList<String> homeLinks = getAllLinks("D:\\links.dat");
		ArrayList<House> houses = makeAllHouses(homeLinks);
	}
	else if(b == 3)
	{
		getAgeWithFile();
		//String ding = new String("Year Built</span><span class=\"jsx-488154125 value ellipsis\">");
		//System.out.println(ding.length());
		//System.out.println("The age: "+getAge("3bed 2.5bath 1,672sqft 8,712sqft lot 4705 Worchester Pl, Raleigh, NC 27604"));
		//JavaBot bot = new JavaBot();
		//bot.getCordsOfCursor();
		/*
		String str = new String (dataLocation);
		File file = new File(new String(str));
		System.out.println(file);
		Document doc = Jsoup.parse(file, "UTF-8");
		System.out.println(doc.toString());
		//getAgeWithComputer();
		 * 
		 */
	//	saveAgeWithComputer();
	//	int year = getAgeWithFile();
		
		//System.out.println("This is the year:"+year);
	}
	else if(b ==4)
	{
		System.out.println(getAddress("3+bed 2.5+bath 1,672sqft 8,712sqft lot 4705 Worchester Pl, Raleigh, NC 27604"));
		System.out.println(getBed("3+bed 2.5+bath 1,672sqft 8,712sqft lot 4705 Worchester Pl, Raleigh, NC 27604"));
		System.out.println(getBath("3bed 2.5bath 1,672sqft 8,712sqft lot 4705 Worchester Pl, Raleigh, NC 27604"));
		System.out.println(getZip("3bed 2.5bath 1,672sqft 8,712sqft lot 4705 Worchester Pl, Raleigh, NC 27604"));
		System.out.println(getSqft("3bed 2.5bath 1,672sqft 8,712sqft lot 4705 Worchester Pl, Raleigh, NC 27604"));
		System.out.println(getSqftLot("3bed 2.5bath 1,672sqft 8,712sqft lot 4705 Worchester Pl, Raleigh, NC 27604"));
	}
	else if(b == 5)
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard ();
		String str = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println(str);
		System.out.println(str.length());
	}
	}
	
	public static void saveAgeWithComputer(String url) throws InterruptedException, AWTException, FileNotFoundException
	{
		openInternet(url);
		Thread.sleep(3400);
		Robot rob = new Robot();
		rob.mouseMove(1546, 0);
	//	rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		Thread.sleep(3000);
		
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_S);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_S);
		
		Thread.sleep(2000);
		
	    Robot r = new Robot();
	    for (char c : "Years".toCharArray()) {
	        int code = KeyEvent.getExtendedKeyCodeForChar(c);
	        if (Character.isUpperCase(c))
	            r.keyPress(KeyEvent.VK_SHIFT);
	        r.keyPress(code);
	        r.keyRelease(code);
	        if (Character.isUpperCase(c))
	            r.keyRelease(KeyEvent.VK_SHIFT);
	    }
	    
	    rob.keyPress(KeyEvent.VK_ENTER);
	    rob.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(300);
	    
	    rob.keyPress(KeyEvent.VK_LEFT);
	    rob.keyRelease(KeyEvent.VK_LEFT);
	    
		Thread.sleep(300);
	    
	    rob.keyPress(KeyEvent.VK_ENTER);
	    rob.keyRelease(KeyEvent.VK_ENTER);
	    
	    File file = new File(dataLocation);
	    
	    while(!file.exists())
	    {
	    	Thread.sleep(1);
	    }
	    
	    
	    System.out.println("Finished saving it");
	    Thread.sleep(12500);
	    

		

	    /*
	    Thread.sleep(12000);
	    
	    
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_W);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_W);
		*/
		
	}
	
	public static void saveAgeWithComputer2(String url) throws InterruptedException, AWTException
	{
		openInternet(url);
		Thread.sleep(3000);
		Robot rob = new Robot();
		rob.mouseMove(1546, 0);
		rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		Thread.sleep(3500);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_S);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_S);
		
		Thread.sleep(2000);
		
	    Robot r = new Robot();
	    for (char c : "Years".toCharArray()) {
	        int code = KeyEvent.getExtendedKeyCodeForChar(c);
	        if (Character.isUpperCase(c))
	            r.keyPress(KeyEvent.VK_SHIFT);
	        r.keyPress(code);
	        r.keyRelease(code);
	        if (Character.isUpperCase(c))
	            r.keyRelease(KeyEvent.VK_SHIFT);
	    }
	    File file = new File(dataLocation);
	    file.delete();
	    
	    rob.keyPress(KeyEvent.VK_ENTER);
	    rob.keyRelease(KeyEvent.VK_ENTER);
/*
		Thread.sleep(300);
	    
	    rob.keyPress(KeyEvent.VK_LEFT);
	    rob.keyRelease(KeyEvent.VK_LEFT);
	    
		Thread.sleep(300);
	    
	    rob.keyPress(KeyEvent.VK_ENTER);
	    rob.keyRelease(KeyEvent.VK_ENTER);
*/
	    while(!file.exists())
	    {
	    	Thread.sleep(1);
	    }
	    	System.out.println("Finished saving it");
	    	Thread.sleep(4000);
	   /* 
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_W);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_W);
		*/
	}
	
	public static int getAgeWithFile() throws IOException
	{
		String str = new String (dataLocation);
		File file = new File(new String(str));
		System.out.println(file);
		Document document = Jsoup.parse(file, "UTF-8");
		//System.out.println(document.toString());
		
	//	System.out.println(document.toString());
		int invent = document.toString().indexOf("<span class=\"jsx-488154125 key\">Year Built</span>");
		String total = document.toString().substring(invent);
		
		String year = total.substring(60, total.length());
		
		System.out.println("--------------------------------------------");
		year = year.substring(year.indexOf("<"), year.length());
		year = year.substring(year.indexOf(">")+1, year.length());
		year = year.substring(0, year.indexOf("<"));
		System.out.println("This is the year: "+year);
		/*
		year = year.substring(0,year.indexOf("<"));
		System.out.println("Age:"+year);
		*/
		
		
		int age = Integer.parseInt(year);
		PrintWriter writer = new PrintWriter(file);
		writer.println("I finished");
		writer.close();
	    
		return age;
		
	}
	public static void getAgeWithComputer() throws InterruptedException, AWTException
	{
		Thread.sleep(3000);
		Robot rob = new Robot();
		rob.mouseMove(1546, 0);
		rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_SHIFT);
		rob.keyPress(KeyEvent.VK_I);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_SHIFT);
		rob.keyRelease(KeyEvent.VK_I);
		
		Thread.sleep(5500);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_F);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_F);
		
		Thread.sleep(200);
	    Robot r = new Robot();
	    for (char c : "Year Built".toCharArray()) {
	        int code = KeyEvent.getExtendedKeyCodeForChar(c);
	        if (Character.isUpperCase(c))
	            r.keyPress(KeyEvent.VK_SHIFT);
	        r.keyPress(code);
	        r.keyRelease(code);
	        if (Character.isUpperCase(c))
	            r.keyRelease(KeyEvent.VK_SHIFT);
	    }
	    
	    rob.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(200);
	    rob.keyRelease(KeyEvent.VK_ENTER);
	    
		rob.mouseMove(1764, 474);
		rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(100);
		rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		Thread.sleep(300);
		
		rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(100);
		rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		

		
		
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_C);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_C);
		
	/*
		rob.mouseMove(30, 563);
		rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(100);
		rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		Thread.sleep(1500);
		
		rob.mouseMove(254, 628);
		rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(100);
		rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		for(int i = 0; i < 20; i++)
		{
			rob.keyPress(KeyEvent.VK_BACK_SPACE);
			rob.keyRelease(KeyEvent.VK_BACK_SPACE);

		}
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		
		for(int i = 0; i < 4; i++)
		{
			rob.keyPress(KeyEvent.VK_LEFT);
			rob.keyRelease(KeyEvent.VK_LEFT);

		}
		
		for(int i = 0; i < 20; i++)
		{
			rob.keyPress(KeyEvent.VK_BACK_SPACE);
			rob.keyRelease(KeyEvent.VK_BACK_SPACE);

		}
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_S);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_S);
		*/
	}
	
	public static void writeData(ArrayList<House> houses) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\jzbus\\data.dat");
		PrintWriter writer = new PrintWriter(file);
		for(int i = 0; i < houses.size(); i++)
		{

			writer.println(houses.get(i));
		
		}
		writer.close();
		
	}

	public static House makeHouseFromText(String homeTexts, String documentText,int index, String link) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException
	{
	
		
		
		saveAgeWithComputer(link);
		
		File file = new File(new String(dataLocation));
		Document document = Jsoup.parse(file, "UTF-8");
		int invent = document.toString().indexOf("<span class=\"jsx-488154125 key\">Year Built</span>");
		
		if(invent == -1)
		{
			System.out.println("Oh no!");
			return makeHouseFromText(homeTexts,documentText,index,link);
		}
		else
		{
	//	String current = pushDocUp(documentText,index);
		double price = getPriceWithFile(document);
		//price = getPriceFromPage(document.toString());
		int age = getAgeWithFile();
		//int age = getAge(homeTexts,link);
		int zip = getZip(homeTexts);
		String address = getAddress(homeTexts);
		double bed = getBed(homeTexts);
		double bath = getBath(homeTexts);
		double sqft = getSqft(homeTexts);
		double sqftLot = getSqftLot(homeTexts);
		//finish address, bath, sqft lot
		
		
		
		return new House(address, zip, age, bed, bath, sqft, sqftLot, price);
		}
		
	}
	public static double getPriceWithFile(Document document) throws IOException
	{
		
		
		//System.out.println(document.toString());
		
	//	System.out.println(document.toString());
		int invent = document.toString().indexOf("<span class=\"jsx-4285822472 price\">");
		String total = document.toString().substring(invent);
		
		String price = total.substring(total.indexOf(">")+1, total.length());
		System.out.println("This is the price: "+price);
		price = price.substring(0, price.indexOf("<"));
		System.out.println("Now this is the price; "+price);
		price = price.replace("$", "");
		while(price.indexOf(",") != -1)
		{
			price = price.replace(",", "");
		}
		/*
		year = year.substring(0,year.indexOf("<"));
		System.out.println("Age:"+year);
		*/
		System.out.println("THis is the price: "+price);

	    
		return Double.parseDouble(price);
		
	}
	private static double getPriceFromPage(String string) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public static String getAddress(String homeTexts)
	{
		String pag = new String(homeTexts);
		pag = pag.substring(pag.indexOf("lot")+4, pag.length());
		pag = pag.substring(0,pag.lastIndexOf(" "));
		return pag;
	}
	public static double getBed(String homeTexts)
	{
		String pag = new String(homeTexts);
		pag = pag.substring(0,pag.indexOf("bed"));
		
		if(pag.indexOf("+") != -1) {
			pag = pag.replace("+", "");
		}
		return Double.parseDouble(pag);
	}
	
	public static double getSqft(String homeTexts)
	{
		String pag = new String(homeTexts);
		pag = pag.substring(pag.indexOf("bath")+5, pag.indexOf("sqft"));
		
		
		if(pag.indexOf("+") != -1) {
			pag = pag.replaceAll("+", "");
		}
		
		if(pag.indexOf(",") != -1) {
			pag = pag.replaceAll(",", "");
		}
		return Double.parseDouble(pag);
	}
	
	public static double getSqftLot(String homeTexts)
	{
		String pag = new String(homeTexts);
		if (pag.indexOf("acre lot") == -1)
		{
			pag = pag.substring(pag.indexOf("sqft")+5, pag.indexOf("sqft lot"));
		
			if(pag.indexOf("+") != -1) {
				pag = pag.replaceAll("+", "");
			}
			
			if(pag.indexOf(",") != -1) {
				pag = pag.replaceAll(",", "");
			}
			return Double.parseDouble(pag);
			
		}
		else
		{
			pag = pag.substring(pag.indexOf("sqft")+5, pag.indexOf("acre lot"));
			
			if(pag.indexOf("+") != -1) {
				pag = pag.replaceAll("+", "");
			}
			
			if(pag.indexOf(",") != -1) {
				pag = pag.replaceAll(",", "");
			}
			return House.convertAcreToSqft(Double.parseDouble(pag));
		}

	}
	
	
	public static double getBath(String homeTexts)
	{
		String pag = new String(homeTexts);
		pag = pag.substring(pag.indexOf(" ")+1, pag.indexOf("bath"));
		System.out.println(pag);
		if(pag.indexOf("+") != -1) {
			pag = pag.replace("+", "");
		}
		return Double.parseDouble(pag);
	}
	
	public static int getZip(String homeTexts)
	{
		String zip = new String(homeTexts);
		int end = zip.lastIndexOf(" ");
		zip = zip.substring(end + 1);
		return Integer.parseInt(zip);
	}
	public static double getPriceFromDoc(String docText)
	{
		String pag = new String(docText);
		int stop = pag.indexOf("<span data-label=\"pc-price\" class=");
		pag = pag.substring(stop,pag.length());
		stop = pag.indexOf(">") +1;
		pag = pag.substring(stop,pag.length());

		stop = pag.indexOf("<");
		pag = pag.substring(0, stop);
		System.out.println("This is pag:"+pag);

		
		return convertCashtoDouble(pag);
	}
	
	public static double convertCashtoDouble(String cash)
	{
		cash = cash.substring(1);
		cash = cash.replaceAll(",", "");
		return Double.parseDouble(cash);
	}
	
	public static String pushDocUp(String doctext, int index)
	{
		String pog = new String(doctext);
		for(int i = 0; i < index; i++)
		{
			int start = pog.indexOf("<span data-label=\"pc-price\" class=");
			pog = pog.substring(start,pog.length());
			int bel = pog.indexOf("</div>");
			pog = pog.substring(bel,pog.length());
		}
		
		return pog;
	}
	
	public static ArrayList<House> makeAllHomesSuper(ArrayList<String> homeTexts,ArrayList<String> link, String docText) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException
	{
		ArrayList<House> houses = new ArrayList<House>();
		
		for(int i = 0; i < homeTexts.size(); i++)
		{
			if((homeTexts.get(i).indexOf("lot") != -1) && (homeTexts.get(i).indexOf("bed") != -1) && (homeTexts.get(i).indexOf("bath") != -1) && (homeTexts.get(i).indexOf("sqft") != -1))
			{
				System.out.println((i+1)+" / "+(homeTexts.size()));
				houses.add(makeHouseFromText(homeTexts.get(i),docText,i,link.get(i)));
			}
		}
		return houses;
	}
	
	public static int getAge(String text,String url) throws IOException
	{
		
		int peep = text.indexOf("lot");
		String search = text.substring(peep+4,text.length());
		search = search + " year built";//" \"year built\"";
		System.out.println(search);
		int age = 0;
		String inital = "https://www.bing.com/search?q=";
		String bingsearch = inital+search;
		bingsearch = bingsearch.replaceAll(" ", "+");
		//System.out.println(bingsearch.charAt(68));
		//System.out.println(bingsearch.charAt(67));
		//Document document = Jsoup.connect(bingsearch).get();
		
		//System.out.println(document.toString());
		
		//int invent = document.toString().indexOf("Year built:</span>");
		//String total = document.toString().substring(invent);
		
		//System.out.println(total);
		
		openInternet(url);
		
		
		//Document doc = Jsoup.connect("https://duckduckgo.com/?q=4705+Worchester+Pl%2C+Raleigh%2C+NC+27604+year+built&t=h_&ia=maps").get();
		//System.out.println(doc);
		System.out.println("Please put in the year built");
		Scanner kb = new Scanner(System.in);
		age = kb.nextInt();
		age = 2020 - age;
		return age;
	}
	
	public static int getAge2(String text,String url) throws IOException, InterruptedException, AWTException, UnsupportedFlavorException
	{
		
		System.out.println("THis is the text: "+text);
		//System.out.println(bingsearch.charAt(68));
		//System.out.println(bingsearch.charAt(67));
		//Document document = Jsoup.connect(bingsearch).get();
		
		//System.out.println(document.toString());
		
		//int invent = document.toString().indexOf("Year built:</span>");
		//String total = document.toString().substring(invent);
		
		//System.out.println(total);
		
		//openInternet(url);
		int age = 0;
		String str = "";
		Robot rob = new Robot();
		while ( !( (str.length() == 16) && (str.indexOf("Year Built") != -1)) )
		{
			openInternet(url);
			getAgeWithComputer();
			
			//Document doc = Jsoup.connect("https://duckduckgo.com/?q=4705+Worchester+Pl%2C+Raleigh%2C+NC+27604+year+built&t=h_&ia=maps").get();
			//System.out.println(doc);

			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard ();

			str = (String) clipboard.getData(DataFlavor.stringFlavor);


			/*
			if(!( (str.length() == 16) && (str.indexOf("Year Built") != -1)))
			{
				rob.keyPress(KeyEvent.VK_CONTROL);
				rob.keyPress(KeyEvent.VK_SHIFT);
				rob.keyPress(KeyEvent.VK_I);
				
				rob.keyRelease(KeyEvent.VK_CONTROL);
				rob.keyRelease(KeyEvent.VK_SHIFT);
				rob.keyRelease(KeyEvent.VK_I);
				
				
				rob.keyPress(KeyEvent.VK_F5);
				rob.keyRelease(KeyEvent.VK_F5);

				
			}
			*/

		}
		str = str.substring(str.indexOf(":")+2);


		age = Integer.parseInt(str);
		age = 2020 - age;

		System.out.println("This should be the age: "+age);
		
		return age;
	}
	public static ArrayList<String> getAllLinks(String location) throws FileNotFoundException
	{
		ArrayList<String> links = new ArrayList<String>();
		File file = new File(location);
		Scanner fil = new Scanner(file);
		
		while (fil.hasNext())
		{
			links.add(fil.nextLine());
		}
		
		return links;
	}
	public static void writeLinks(ArrayList<String> links) throws FileNotFoundException
	{
		File file = new File("D:\\links.dat");
		PrintWriter writer = new PrintWriter(file);
		
		for (String link : links)
		{
			writer.println(link);
		}
		writer.close();
	}
	public static ArrayList<House> makeAllHouses(ArrayList<String> homeLinks) throws IOException, InterruptedException
	{
		ArrayList<House> houses = new ArrayList<House>();
		for(String s : homeLinks)
		{
			Random rand = new Random();
//			Thread.sleep(rand.nextInt(5000)+300);
			houses.add(makeHouseFromPage(s));
			
		}
		return houses;
	}
	public static House makeHouseFromPage(String url) throws IOException
	{
		 Map<String, String> cookies = Jsoup.connect(url).execute().cookies();
		   // System.out.println(cookies);
		   // Scanner kb = new Scanner(System.in);
		   // kb.nextLine();
		Document document = Jsoup.connect(url).cookies(cookies).get();
		
		System.out.println("");
		System.out.println("-------------------------------------------------------------");
		System.out.println("");
		System.out.println(document);
		int invent = document.toString().indexOf("\"price\":");
		String total = document.toString().substring(invent);
		

		
		String price = total.substring(0, total.indexOf(","));
		System.out.println("I hope this worked, should be the price:"+price);
		
		invent = document.toString().indexOf("Total Square Feet Living: ");
		
		if(invent == -1)
		{
			invent = document.toString().indexOf("\"sqft\":");
			total = document.toString().substring(invent);
			System.out.println("THIS IS THE TOTAL THING: "+total);
			String sqft = total.substring(total.indexOf(":")+1, total.indexOf(","));
				System.out.println("I hope this worked, should be the sqft:"+sqft);
		}
		else {
		total = document.toString().substring(invent);
		
		String sqft = total.substring(total.indexOf(": ")+2, total.indexOf("<"));
		
		System.out.println("I hope this worked, should be the sqft:"+sqft);
		}
		invent = document.toString().indexOf("Lot Size Square Feet: ");
		
		if (invent == -1)
		{
			return new House();
		}
			
		
		total = document.toString().substring(invent);
		
		String sqftlot = total.substring(total.indexOf(": ")+2, total.indexOf("<"));
		
			
		
		System.out.println("I hope this worked, should be the sqft lot:"+sqftlot);
		
		
		invent = document.toString().indexOf("<title>");
		total = document.toString().substring(invent);
		String address = total.substring(7, total.indexOf("|")-1);
		
		String zip = address.substring(address.lastIndexOf(",")+2, address.length());
		address = address.substring(0,address.lastIndexOf(","));
		
		System.out.println("This is the address: "+address);
		System.out.println("This is the zip: "+zip);
		
		invent = document.toString().indexOf("Year Built: ");
		total = document.toString().substring(invent);
		
		String year = total.substring(total.indexOf(": ")+2, total.indexOf("<"));
		
		invent = document.toString().indexOf("Bedrooms: ");
		total = document.toString().substring(invent);
		
		String bedroom = total.substring(total.indexOf(": ")+2, total.indexOf("<"));
		System.out.println("This is the Bedroom: "+bedroom);
		
		invent = document.toString().indexOf("Total Bathrooms: ");
		total = document.toString().substring(invent);
		
		String bathroom = total.substring(total.indexOf(": ")+2, total.indexOf("<"));
		System.out.println("This is the Bathroom: "+bathroom);
		
		
		invent = document.toString().indexOf("Property Age: ");
		total = document.toString().substring(invent);
		
		String age = total.substring(total.indexOf(": ")+2, total.indexOf("<"));
		System.out.println("This is the Property Age: "+age);
		
		
		return new House();
		
	}
	
	public static Object[] getAllHomeLinks(int pageNum, String url) throws IOException, InterruptedException
	{
		Object[] obs = new Object[3];
		ArrayList<String> homeLinks = new ArrayList<String>();
		ArrayList<String> homeTexts = new ArrayList<String>();
		Random rand = new Random();
		String fulldoc = new String("");
		for(int i = 1; i < pageNum+1; i++)
		{
			
			url = url.substring(0,url.length()-1);
			
		

			url = url + i;
			System.out.println("Test: "+url);
			java.util.concurrent.TimeUnit.SECONDS.sleep(rand.nextInt(6)+1);
			Document document = Jsoup.connect(url).get();
			fulldoc = fulldoc+ document.toString()+"\n";
			JEditorPane editor = new JEditorPane();
			editor.setContentType( "text/html" );    
			editor.setText( document.html() );
			
			/*
			JFrame p = new JFrame();
			p.add(editor);
			p.setSize(400,400);
			p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//			frame.setLayout(null);
			p.setVisible(true);
			
			*/
			Elements links = document.select("a[href]");
			boolean count = false;
			int weak = 0;
			
			for(Element link : links)
			{
				
				
				//openInternet(url);
				//System.out.println("I am at the begining");
			//	System.out.println("text: "+link.text()+"|link: "+link.attr("abs:href"));
				//System.out.println("I am at the end");

				if((link.text().length() > 1) && (link.attr("abs:href")).contains("realestateandhomes-detail") 
					&& !((link.attr("abs:href")).contains("?ex=")) ) 
				{
					System.out.println("text: "+link.text()+"|link: "+link.attr("abs:href"));
					Thread.sleep(rand.nextInt(1000)+300);
					homeLinks.add(link.attr("abs:href"));
					homeTexts.add(link.text());
					
					/**
					java.util.concurrent.TimeUnit.SECONDS.sleep(2);
					openInternet(link.attr("abs:href"));
					**/
				}
			}

		}
		obs[0] = homeLinks;
		obs[1] = homeTexts;
		obs[2] = fulldoc;
		return obs;
	}
	
	public static int getNumberOfPages(String url) throws IOException
	{
		
		Document document = Jsoup.connect(url).get();
		Elements links = document.select("a[href]");
		boolean count = false;
		int weak = 0;
		for(Element link : links)
		{
			
			
			//openInternet(url);
			//System.out.println("I am at the begining");
		//	System.out.println("text: "+link.text()+"|link: "+link.attr("abs:href"));
			//System.out.println("I am at the end");
			if (link.text().equals("1"))
			{
				count = true;
			}
			
			if (count == true)
			{
				if (link.text().equals("Next"))
				{
					return weak;
				}
				else
				{
					weak = Integer.parseInt(link.text());
				}
			}
		}
		//document.get
		return weak;
	}
	  public static void openInternet(String URL) {
		  String url = URL;

	      if(Desktop.isDesktopSupported()){
	          Desktop desktop = Desktop.getDesktop();
	          try {
	              desktop.browse(new URI(url));
	          } catch (IOException | URISyntaxException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	          }
	      }else{
	          Runtime runtime = Runtime.getRuntime();
	          try {
	              runtime.exec("xdg-open " + url);
	          } catch (IOException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	          }
	      }  
	  }

}
