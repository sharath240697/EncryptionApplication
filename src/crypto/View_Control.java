package crypto;

import java.io.File;
import java.util.Scanner;

public class View_Control {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			CESARCIPHER cesarcipherclass = new CESARCIPHER();
			DESAlgorithm desclass = new DESAlgorithm();

			int user_choice = 0;
			int key=0;
			boolean enc_result = false;
			boolean dec_result = false;

			System.out.println("HI.....This app is to encrypt your file");
			System.out.println("To ENCRYPT a file please enter valid path of a txt file or type exit to quit");
			String InputFilePath = "";
			while(!InputFilePath.toLowerCase().equals("exit"))
			{
				InputFilePath = sc1.nextLine();
				File InputFile = new File(InputFilePath);

				//System.out.println(InputFilePath);
				//System.out.println(InputFile.exists() && InputFile.isFile() );
				if(InputFile.exists() && InputFile.isFile() && !InputFilePath.toLowerCase().equals("exit"))
				{
					//System.out.println(InputFilePath);
					user_choice=0;
					while(user_choice!=7)
					{
						System.out.print("\033[H\033[2J");
						System.out.println("press numbers to enter your choice ");
						
						System.out.println("1.)Cesar cipher encryption(forward)"); 
						System.out.println("2.)Cesar cipher decryption(forward)"); 
						System.out.println("3.)Cesar cipher encryption(backward)");
						System.out.println("4.)Cesar cipher decrption(backward)");
						System.out.println("5.)DES encryption");
						System.out.println("6.)DES decryption");
						System.out.println(".7)Exit");	

						while(!(sc2.hasNextInt()) )
							sc2.next();
						while( user_choice == 0 || user_choice >7)
						{
							  user_choice = sc2.nextInt();
						}

						switch(user_choice)
						{
							case 1:
									System.out.println("Enter the key(greter>0)");
									key=0;
									while(!(sc1.hasNextInt()) )
										sc1.next();
									while(key== 0)
									{
										key = sc1.nextInt();
									}
									 enc_result = cesarcipherclass.cesarcipher(InputFilePath, key, Constants.CEASER_CYPHER_FWD_ENC);
									if(enc_result)
									{
										System.out.println("Encrypted successfully");
									}
									else
										System.out.println("Encryption failed");
									
										System.out.println("Enter 7 to go back");
									while(!(sc1.hasNextInt()) )
											sc1.next();
									while(user_choice!=7)
									{
										user_choice = sc1.nextInt();
									}
									break;

							case 2:
									System.out.println("Enter the key(greter>0)");
									key=0;
									while(!(sc1.hasNextInt()) )
										sc1.next();
									while(key== 0)
									{
										key = sc1.nextInt();
									}
									dec_result = cesarcipherclass.cesarcipher(InputFilePath, key, Constants.CEASER_CYPHER_FWD_DEC);
									if(dec_result)
									{
										System.out.println("Decrypted successfully");
									}
									else
									System.out.println("Decryption failed");
									
										System.out.println("Enter 7 to go back");
									while(!(sc1.hasNextInt()) )
											sc1.next();
									while(user_choice!=7)
									{
										user_choice = sc1.nextInt();
									}
									break;
									
							case 3:
									System.out.println("Enter the key(greter>0)");
									key=0;
									while(!(sc1.hasNextInt()) )
										sc1.next();
									while(key== 0)
									{
										key = sc1.nextInt();
									}
									 enc_result = cesarcipherclass.cesarcipher(InputFilePath, key, Constants.CEASER_CYPHER_BWD_ENC);
									if(enc_result)
									{
										System.out.println("Encrypted successfully");
									}
									else
										System.out.println("Encryption failed");
									
										System.out.println("Enter 7 to go back");
									while(!(sc1.hasNextInt()) )
											sc1.next();
									while(user_choice!=7)
									{
										user_choice = sc1.nextInt();
									}
									break;
							case 4:
									System.out.println("Enter the key(greter>0)");
									key=0;
									while(!(sc1.hasNextInt()) )
										sc1.next();
									while(key== 0)
									{
										key = sc1.nextInt();
									}
									dec_result = cesarcipherclass.cesarcipher(InputFilePath, key, Constants.CEASER_CYPHER_BWD_DEC);
									if(dec_result)
									{
										System.out.println("Decrypted successfully");
									}
									else
									System.out.println("Decryption failed");
									
										System.out.println("Enter 7 to go back");
									while(!(sc1.hasNextInt()) )
											sc1.next();
									while(user_choice!=7)
									{
										user_choice = sc1.nextInt();
									}
									break;

							case 5:
									try {
										desclass.encrypt(InputFilePath);
										System.out.println("Encripted successfully");
									} catch (Exception e) {
										//TODO: handle exception
										System.out.println("Encription failed");
									}																											
									System.out.println("Enter 7 to go back");
									while(!(sc1.hasNextInt()) )
											sc1.next();
									while(user_choice!=7)
									{
										user_choice = sc1.nextInt();
									}
									break;
							case 6:
									File keyfile = null;
									String keyfilepath = "null";
									System.out.println(keyfile==null || !keyfile.isFile() || !keyfile.exists());
									while((keyfile==null || !keyfile.isFile() || !keyfile.exists()) && !keyfilepath.equals("exit"))
									{
										if(keyfilepath.equals("null"))
											System.out.println("Enter the path of key file");
										else
										{
											System.out.println("Key file foesnt exist");
											System.out.println("Please enter valid path or type exit to go back");
										}
										keyfilepath = sc1.nextLine();
										keyfile = new File(keyfilepath);
									}		
									if(!keyfilepath.equals("exit") && !keyfilepath.equals("null"))
											{
												
												try {
													desclass.decrypt(keyfilepath, InputFilePath);
													System.out.println("Decripted successfully");
												
												} catch (Exception e) {
												
													System.out.println("Decription failed");
													//TODO: handle exception
												} catch (Throwable e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												System.out.println("Enter 7 to go back");
												while(!(sc1.hasNextInt()) )
														sc1.next();
												while(user_choice!=7)
													{
														user_choice = sc1.nextInt();
													}
											}
										else
										{
											user_choice = 0;
										}
																						
							default:
							if(user_choice!=7) {user_choice=0;}
							//else {InputFilePath ="exit";}
							break;
						}
					}
				}
				else
				{
					if(InputFilePath.toLowerCase().equals("exit"))
					{
						   System.out.println("Thank you for using the app");
					}
					else
					{
						if(user_choice==7)
						{
							System.out.println("Thank you for using the app");
							System.out.println("Please enter valid path of a txt file to use app again or type exit to quit");
						}
						else
						{
							System.out.println("File Path Inavalid");
						   	System.out.println("Please enter valid path of a txt file or type exit to quit");
						}
						   
					}
				}
			}		
		} catch (Exception e) {
			// TODO: handle exception
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
