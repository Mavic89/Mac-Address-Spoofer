import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Spoofer {

	
	enum OperatingSystem{
		WINDOWS,
		LINUX
	}
	static OperatingSystem UserOS;
	static String os;
	
	
	Spoofer(String os) {
		this.os = os;
		if(os.toLowerCase().contains("win")) {
			
			UserOS = OperatingSystem.WINDOWS;
		}
		else if(os.toLowerCase().contains("lin")) {
			UserOS = OperatingSystem.LINUX;
		}
	}
	
	public String getMAC() {
		InetAddress localHost;
		byte[] hardwareAddress = null;
		
		try {
			localHost = InetAddress.getLocalHost();
			NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
			hardwareAddress = ni.getHardwareAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (SocketException e) {
			e.printStackTrace();
		}


		String[] hexadecimal = new String[hardwareAddress.length];
		for (int i = 0; i < hardwareAddress.length; i++) {
		    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
		}
		String macAddress = String.join("-", hexadecimal);
		return macAddress;
	}

	public static void changeMac() {
		if(UserOS == OperatingSystem.LINUX) {
			System.out.println("linux");
		}
		else if(UserOS == OperatingSystem.WINDOWS) {
			String MacAdr="74-CB-3E-2A-5B-F6";
			try {
				Runtime.getRuntime().exec("reg add HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Control\\Class\\{4D36E972-E325-11CE-BFC1-08002BE10318}\\0007 /t REG_SZ /v NetworkAddress /d " + MacAdr + " /f");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	public static String getDiskSerial() {
		Process process;
		if(UserOS == OperatingSystem.LINUX) {
			return "linux!!!!!!";
		}
		else if(UserOS == OperatingSystem.WINDOWS) {
		    try {
				process=Runtime.getRuntime().exec("WMIC diskdrive get serialnumber");
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
				StringBuilder CMDOUTPUT = new StringBuilder();
				String line;
				while ((line=stdInput.readLine()) != null) {
					CMDOUTPUT.append(line);
				}
				String[] outputArray =String.valueOf(CMDOUTPUT).split("\\s+");
				return outputArray[2];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//return drive;
		return "error";
		
	}*/
}
