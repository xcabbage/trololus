/**
*
* @author DannyUfonek & xCabbage & avatarXargo
*
*/
package game.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

//IMPORTANT: Vyzkou�ejte si to, m�lo by to hodit pr�zdnou konzoli, pop�. FileNotFound exception kdy� tam ten file nem�te

//KOMENTAR - DK 
// fajny ale ty cesty na ty I/O streamy dej obe do jednoho variablu co se bude inicializovat nahore at je to jednotne ovladany (konstanta)
// + ta cesta by mela bejt absolutni, ne v packagi, ale nekde venku ze hry: treba C://Users/<uzivatel>/myDocuments nebo tak 
//                                                    at to nedela bordel se syncem pres git kdyz to bude spustest vic lidi
//Koment - HP
//delam to dobre?

public class PropertiesHandler {
	static Path savedpropspath = Paths.get(System.getenv("APPDATA") + "\\TrololusGame\\game.properties"); 		//path to saved non-default props

	public static void init() throws IOException{

		// create and load default properties
		Properties defaultProps = new Properties();
		try {
			FileInputStream DIStream = new FileInputStream(savedpropspath.toString());
			defaultProps.load(DIStream);
//			defaultProps.list(System.out);
			DIStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			//create folder if it isn't found
			System.out.println("Creating new folder TrololusGame at " + savedpropspath);
			File dir = new File(System.getenv("APPDATA") + "\\TrololusGame");
			dir.mkdir();

			//if they are not found, set the default properties value
			defaultProps.setProperty("musicvolume", "100");
			defaultProps.setProperty("soundvolume", "100");
			defaultProps.setProperty("speechvolume", "100");
			defaultProps.setProperty("database", "localhost");
			defaultProps.setProperty("dbuser", "defaultuser");
			defaultProps.setProperty("graphicsquality", "high");
 
    		//save default properties to properties folder
			System.out.println("Writing new default properties to " + savedpropspath);
			File DPropsFile = new File(savedpropspath.toString());
			FileOutputStream fileOut = new FileOutputStream(DPropsFile);
			defaultProps.store(fileOut, "Default Game Properties");
			fileOut.close();
//			defaultProps.store(new FileOutputStream(defaultpath.toString()), null);
		}
		
		// create application properties with default
		Properties applicationProps = new Properties(defaultProps);

		// now load properties 
		// from last invocation
		FileInputStream IStream = new FileInputStream(savedpropspath.toString());
		try{
			applicationProps.load(IStream);
			System.out.println("Listing saved properties");
			applicationProps.list(System.out);
			IStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static void saveProperty(String[] args) throws IOException{
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