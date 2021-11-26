package fr.zenity.academy.config;

import fr.zenity.academy.PageObjects.Page;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class PropertiesLoader {
    private final static String CONFIG_FILE = "config/%s.properties";
    /**
     * logger
     */
    private static final Logger LOG = Logger.getLogger(Page.class);

    private Properties prop   = new Properties();

    PropertiesLoader(String configFile){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(String.format(CONFIG_FILE,configFile)));
            LOG.info("le fichier de configuration a été charger correctement.");
            prop.load(reader);
        }catch (Exception e){
            LOG.error("le fichier de configuration n'a pas pu être charger.");
            e.printStackTrace();
        }
    }

    public String getProperty(String key){ return prop.getProperty(key); }

    public String getProperty(String key, String defaultValue ){ return prop.getProperty(key, defaultValue); }

    public Boolean getProperty(String key, Boolean defaultValue){
        return prop.getProperty(key)==null? defaultValue : Boolean.valueOf(prop.getProperty(key));
    }


    public void forEach(BiConsumer<String,String> biConsumer) {
        prop.forEach((Object key, Object value)->biConsumer.accept((String)key, (String)value));
    }

    public static PropertiesLoader of(String configFile){ return new PropertiesLoader(configFile); }


}
