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
import java.util.Properties;


public class PropertiesHandler 
{
	
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