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

//IMPORTANT: Vyzkoušejte si to, mìlo by to hodit prázdnou konzoli, popø. FileNotFound exception když tam ten file nemáte

//KOMENTAR - DK 
// fajny ale ty cesty na ty I/O streamy dej obe do jednoho variablu co se bude inicializovat nahore at je to jednotne ovladany (konstanta)
// + ta cesta by mela bejt absolutni, ne v packagi, ale nekde venku ze hry: treba C://Users/<uzivatel>/myDocuments nebo tak 
//                                                    at to nedela bordel se syncem pres git kdyz to bude spustest vic lidi
//Koment - HP
//delam to dobre?

public class PropertiesHandler {
	static Path savedpropspath = Paths.get(System.getenv("APPDATA") + "\\TrololusGame\\game.properties"); 		//path to saved non-default props
	static Properties prop = new Properties();
	 
	public static void init() throws IOException{

		// create and load default properties
		Properties defaultProps = new Properties();
		try {
			FileInputStream DIStream = new FileInputStream(savedpropspath.toString());
			defaultProps.load(DIStream);
//			defaultProps.list(System.out);

			DIStream.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Could not find properties; creating default.");
			
			//create folder if it isn't found
			System.out.println("Creating new folder TrololusGame at " + savedpropspath);
			File dir = new File(System.getenv("APPDATA") + "\\TrololusGame");
			dir.mkdir();

			//if they are not found, set the default properties value
			defaultProps.setProperty("musicvolume", "0.18f");
			defaultProps.setProperty("soundvolume", "1f");
			defaultProps.setProperty("speechvolume", "100");
			defaultProps.setProperty("database", "localhost");
			defaultProps.setProperty("dbuser", "defaultuser");
			defaultProps.setProperty("graphicsquality", "high");
			defaultProps.setProperty("fontGreatHeader", "Basica v.2012");
			
			defaultProps.setProperty("fontNormalHeader","Freedom");
			defaultProps.setProperty("fontEntry","Complex");
			defaultProps.setProperty("fontText","Orena");
			
 
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
			
			
			IStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		prop.load( new FileInputStream(savedpropspath.toString()));
		
		
	}
	
	public static  String getProperty(String key){
		return prop.getProperty(key);
	}
	
	public static void saveProperty(String propname, String propvalue) throws IOException{

    	
    	Properties prop = new Properties();
    	
    	try {
    	
        	
//    		set the properties value
        	prop.load(new FileInputStream(new File(savedpropspath.toString())));
        	
        	
        	
    		prop.put(propname, propvalue);
  
        	
    		
    		//save properties to project root folder

    		prop.store(new FileOutputStream(savedpropspath.toString()), null);
    		
 
    	} 
    	catch (IOException ex) {
    		ex.printStackTrace();
    		PropertiesHandler.init();
    		FileInputStream IStream = new FileInputStream(savedpropspath.toString());
        	FileOutputStream OStream = new FileOutputStream(savedpropspath.toString());
    		//set the properties value
        	prop.load(IStream);
    		prop.setProperty(propname, propvalue);
    		System.out.println("Listing new saved Properties");
    		prop.list(System.out);
    		prop.store(OStream, "Non-Default PRops");
        }
    	reloadProperties();
    }
	
	static void reloadProperties(){
		try {
			prop.load( new FileInputStream(savedpropspath.toString()));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
    public static void loadProperties() throws FileNotFoundException{
    	
    	FileInputStream IStream = new FileInputStream(new File(savedpropspath.toString()));
    	prop = new Properties();
    	
    	try {
               //load a properties file
    		prop.load(IStream);
    		
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