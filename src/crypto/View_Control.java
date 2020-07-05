package crypto;

import java.io.File;
import java.util.Scanner;

public class View_Control {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			
			int user_choice = 0;
			
			System.out.println("HI.....This app is to encrypt your file");
			System.out.println("To ENCRYPT a file please enter valid path of a txt file or type exit to quit");
			String InputFilePath = "";
			while(!InputFilePath.toLowerCase().equals("exit"))
			{
				InputFilePath = sc1.nextLine();
				File InputFile = new File(InputFilePath);
				
				if(InputFile.exists() && InputFile.isFile() && InputFilePath.toLowerCase().equals("exit"))
				{
					System.out.println(InputFilePath);
				}
				else
				{
					if(InputFilePath.toLowerCase().equals("exit"))
					{
						   System.out.println("Thank you for using the app");
					}
					else
					{
						   System.out.println("File Path Inavalid");
						   System.out.println("Please enter valid path of a txt file or type exit to quit");

					}
				}
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
