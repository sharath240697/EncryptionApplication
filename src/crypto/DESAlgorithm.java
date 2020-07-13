package crypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class DESAlgorithm {


  public void  encrypt(String source_file) throws Throwable {
    encryptOrDecrypt(null, source_file, Cipher.ENCRYPT_MODE);
   
    
	}

	public void decrypt(String key, String source_file) throws Throwable {
     encryptOrDecrypt(key, source_file, Cipher.DECRYPT_MODE);
  
  }
  
  public static void encryptOrDecrypt(String key,String source_file,int mode)  {

    System.out.println(source_file);
    System.out.println(mode);

		try {
      
		Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE
    String output_file_name = source_file.substring(0,source_file.length()-4);
    FileInputStream file_input_stream = new FileInputStream(source_file);
    FileOutputStream file_output_stream = null;
		if (mode == Cipher.ENCRYPT_MODE) {
      FileOutputStream   GeneratedkeyFile = new FileOutputStream(output_file_name+".key");
      SecretKey secretkey = KeyGenerator.getInstance("DES").generateKey();
      byte[] keyAsByte = secretkey.getEncoded();
      GeneratedkeyFile.write(keyAsByte);
      GeneratedkeyFile.close();
      System.err.println("secretkey");
      System.out.println(secretkey);
			cipher.init(Cipher.ENCRYPT_MODE, secretkey);
      CipherInputStream cis = new CipherInputStream(file_input_stream, cipher);
      String encrypted_file_name = output_file_name+"_desen.txt";
      file_output_stream = new FileOutputStream(encrypted_file_name);
      doCopy(cis, file_output_stream);
		} else{
      if (mode == Cipher.DECRYPT_MODE) {
        FileInputStream DESkeyFile = new FileInputStream(key);
        byte[] keyUsedforEnc = new byte[DESkeyFile.available()];
        DESkeyFile.read(keyUsedforEnc);
        SecretKey secretkey  = new SecretKeySpec(keyUsedforEnc, "DES");
        DESkeyFile.close();
        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        file_output_stream = new FileOutputStream(output_file_name.substring(0,output_file_name.length()-2)+"de.txt");
        CipherOutputStream cos = new CipherOutputStream(file_output_stream, cipher);
        doCopy(file_input_stream, cos);
      }
    } 
    } catch (Exception e) {
      e.printStackTrace();
    }
  
	}

	public static void doCopy(InputStream input_stream, OutputStream output_stream) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = input_stream.read(bytes)) != -1) {
			output_stream.write(bytes, 0, numBytes);
		}
		output_stream.flush();
		output_stream.close();
		input_stream.close();
	}
    
}