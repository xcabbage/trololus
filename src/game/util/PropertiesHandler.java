/**
*
* @author DannyUfonek & xCabbage & avatarXargo
*
*/
package game.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

//IMPORTANT: Vyzkoušejte si to, mìlo by to hodit prázdnou konzoli, popø. FileNotFound exception když tam ten file nemáte

public class PropertiesHandler
{
	public static void init() throws FileNotFoundException{
		Path savedinputpath = Paths.get(System.getProperty("user.home") + "\\AppData\\TrololusGame\\game.properties"); 		//path to saved non-default props
		Path defaultpath = Paths.get(System.getProperty("user.home") + "\\AppData\\TrololusGame\\gamedefault.properties");	//path to saved default props
		FileInputStream IStream = new FileInputStream(savedinputpath.toString());
		FileInputStream DIStream = new FileInputStream(defaultpath.toString());
		
		// create and load default properties
		Properties defaultProps = new Properties();
		try {
			defaultProps.load(DIStream);
			DIStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		//	System.out.println("Writing default props to " + System.getProperty("user.home") + "\\AppData\\TrololusGame\\gamedefault.properties");
			
		}
		
		// create application properties with default
		Properties applicationProps = new Properties(defaultProps);

		// now load properties 
		// from last invocation
		IStream = new FileInputStream(savedinputpath.toString());
		try{
			applicationProps.load(IStream);
			IStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void saveProperties(String[] args) throws IOException{
    	FileOutputStream OStream = new FileOutputStream("user.home/AppData/Trololus/game.properties");//*
    	
    	Properties prop = new Properties();
    	//KOMENTAR - DK 
    	// fajny ale ty cesty na ty I/O streamy dej obe do jednoho variablu co se bude inicializovat nahore at je to jednotne ovladany (konstanta)
    	// + ta cesta by mela bejt absolutni, ne v packagi, ale nekde venku ze hry: treba C://Users/<uzivatel>/myDocuments nebo tak 
    	//                                                    at to nedela bordel se syncem pres git kdyz to bude spustest vic lidi
    	//Koment - HP
    	//delam to dobre?
    	
    	
    	try {
    		//set the properties value
    		prop.setProperty("musicvolume", "100");
    		prop.setProperty("soundvolume", "100");
    		prop.setProperty("speechvolume", "100");
    		prop.setProperty("database", "localhost");
    		prop.setProperty("dbuser", "defaultuser");
    		prop.setProperty("graphicsquality", "high");
 
    		//save properties to project root folder
    		prop.store(OStream, null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    }
    public static void loadProperties() throws FileNotFoundException{
    	FileInputStream IStream = new FileInputStream("user.home/AppData/Trololus/game.properties");//*
    	
    	Properties prop = new Properties();
 
    	try {
               //load a properties file
    		prop.load(IStream);
    		prop.list(System.out);
               //get the property value and print it out
    		System.out.println(prop.getProperty("musicvolume"));
            System.out.println(prop.getProperty("soundvolume"));
            System.out.println(prop.getProperty("speechvolume"));
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("graphicsquality"));

    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
 
    }
    
}