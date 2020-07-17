//edit test
package YMDFrom;
import java.io.File;
import java.time.*;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class YMDFrom
{
	public static void main(String[] args)
	{
		Scanner src;
		if (args.length == 0) 
			src = getScanner();
		else
			src = getScanner(args[0]);
		int [] dmy = getDmy(src);
		int [] out = new int[3];
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int curMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int curDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		out[2] = Year.now().getValue() - dmy[2] + ((curMonth >= dmy[1] && curDay >= dmy[0]) ? 1 : 0) - 1;
		out[1] = 12 + curMonth - dmy[1] - ((curDay >= dmy[2]) ? 1 : 0);
		out[0] = curDay - dmy[0];
		
		System.out.print("[" + out[2] + " Years " + out[1] + " Months " + out[0] + " Days old]");
	}
	
	private static int[] getDmy(Scanner src) 
	{
		int [] out = new int[3];
		for (int i = 0; i < 3; i++)
		{
			String[] next =  src.nextLine().split(" ");
			out[i] = Integer.parseInt(next[0]);
		}
		return out;
	}

	public static Scanner getScanner()
	{
		return getScanner("./data");
	}
	
	public static Scanner getScanner(String loc)
	{
		try 
		{
			return new Scanner(new File(loc));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("there's no file at" + loc + "!");
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
}
