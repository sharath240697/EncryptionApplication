package crypto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class CESARCIPHER 
{
  public boolean cesarcipher(String source_file, int key,String operation)
  {
	    BufferedReader br =null;
		BufferedWriter bw =null;
		File f1 = new File(source_file);
		File f2 = null;
		String line_from_file = "";
		String line="";
		try 
		{
			
			br = new BufferedReader(new FileReader(f1));
			ArrayList<String> line_holder_after_operation = new ArrayList<String>();
			while((line=br.readLine())!=null)
			{
				if(line.length()>0)
				{
					char[] c = line.toCharArray();
					switch(operation)
					{
						case Constants.CEASER_CYPHER_FWD_ENC:
						case Constants.CEASER_CYPHER_BWD_DEC:
									for(int i=0;i<c.length;i++)
									{
										c[i]+=key;
									}
									break;
						case Constants.CEASER_CYPHER_FWD_DEC:
						case Constants.CEASER_CYPHER_BWD_ENC:
									for(int i=0;i<c.length;i++)
									{
										c[i]-=key;
									}
									break;
						default: break;

					}
					line_from_file = new String(c);
					
				}
				
				
				line_holder_after_operation.add(line_from_file);
			}
			br.close();
			switch(operation)
					{
						case Constants.CEASER_CYPHER_FWD_ENC:
						case Constants.CEASER_CYPHER_BWD_ENC:
										f2 = new File(source_file.substring(0,source_file.length()-4)+"_encrypted.txt");
										System.out.println("Encrypted Output is saved in the file");
										System.out.println(f2.getAbsolutePath());										break;
						case Constants.CEASER_CYPHER_FWD_DEC:
						case Constants.CEASER_CYPHER_BWD_DEC:
										if(source_file.contains("encrypted"))
											{f2 = new File(source_file.substring(0,source_file.length()-13)+"_decrypted.txt");}
										else
											{f2 = new File(source_file.substring(0,source_file.length()-4)+"_decrypted.txt");}
											System.out.println("Decrypted Output is saved in the file");
											System.out.println(f2.getAbsolutePath());
										break;
						default: break;
					}
			
			
			
			//System.out.println(f2.exists()); //check again
			bw = new BufferedWriter(new FileWriter(f2));
			for(String line_from_line_holder: line_holder_after_operation)
			{
				bw.write(line_from_line_holder);
				bw.newLine();
			}
			bw.close();
			return true;
		} 
		catch (Exception e) 
		{
			if(br!=null && bw!=null)
			try 
			{
				br.close();
				bw.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
				}
			return false;
		}	
  }
}
