package ins.aitte.ReadWritetestdata;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ReadWritePropertyFile {
		public static void propRead() {
			try {
				FileReader read = new FileReader("C:\\Users\\Deepika Govind\\eclipse-workspace\\ApilrlBatch3\\src\\test\\resources\\loginDetails.properties");
				Properties prop = new Properties();
				prop.load(read);
				
				String username = prop.getProperty("username");
				System.out.println(username);
				String pass = prop.getProperty("password");
				System.out.println(pass);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void propRead(String key,String path) {
			try {
				FileReader read = new FileReader(path);
				Properties prop = new Properties();
				prop.load(read);			
				String username = prop.getProperty(key);
				System.out.println(username);			
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			String loctn="C:\\Users\\Deepika Govind\\eclipse-workspace\\ApilrlBatch3\\src\\test\\resources\\loginDetails.properties";
			propRead("username",loctn);
		}

	}



