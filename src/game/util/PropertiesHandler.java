/**
*
* @author DannyUfonek
*
*/
package game.util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler 
{
    public static void saveProperties(String[] args){
    	Properties prop = new Properties(prop defaults);

    	try {
    		//set the properties value
    		prop.setProperty("musicvolume", "100");
    		prop.setProperty("soundvolume", "100");
    		prop.setProperty("speechvolume", "100");
    		prop.setProperty("database", "localhost");
    		prop.setProperty("dbuser", "mkyong");
    		prop.setProperty("dbpassword", "password");
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("game.properties"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    }
    public static void loadProperties(){
    	Properties prop = new Properties();
 
    	try {
               //load a properties file
    		prop.load(new FileInputStream("game.properties"));
    		prop.list(System.out);
               //get the property value and print it out
/*    		System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));
 */
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
 
    }
}