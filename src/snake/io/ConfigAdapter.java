package snake.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import snake.Error;
import snake.SnakeGame;

/** 
 * 	@author Cedric	
 *	@version 1.0
 *	@category io
 **/

public class ConfigAdapter {
	
	private Properties configFile;
	private static ConfigAdapter instance;
	private static final String path;
	
	static {
		if (Installer.isInstalled())
			path = "data/config.cfg";
		else
			path = "/data/config.cfg";
	}
	
	private ConfigAdapter() {
		configFile = new Properties();
		try {
			if(Installer.isInstalled()) {
				configFile.load(new FileInputStream(new File(path)));
			} else {
				configFile.load(this.getClass().getResourceAsStream(path));
			}
		} catch(Exception exception) {
			for(StackTraceElement st : Thread.currentThread().getStackTrace())
				if (st.getClassName().contains("snake.io.Logger") || Thread.currentThread().getStackTrace()[2].getMethodName().contains("initLogger")) {
					exception.printStackTrace();
					return;
				}
			SnakeGame.log(Logger.LoggingType.ERROR.type + "An Error occured while loading the config!");
			String error = Error.printError(exception);
			SnakeGame.log(Logger.LoggingType.WARNING.type + "Exiting now...");
			JOptionPane.showMessageDialog(null, "An error occured while loading Config!\n\nError: " + error + "\n\nExiting...");
			System.exit(1);
		}
		instance = this;
	}
	
	private String getValue(String key) {
		return configFile.getProperty(key);
	}
	
	private boolean setValue(String key, String value) {
		configFile.setProperty(key, value);
		try {
			configFile.store(new FileOutputStream(new File(path)), null);
		} catch (IOException e) {
			String error = "";
			for(StackTraceElement s : e.getStackTrace()) {
				error += s.toString() + '\n';
			}
			SnakeGame.log(Logger.LoggingType.ERROR.type + "An Error occured while loading the config!");
			SnakeGame.log(Logger.LoggingType.ERROR.type + "Error: " + error);
			SnakeGame.log(Logger.LoggingType.WARNING.type + "Exiting now...");
			JOptionPane.showMessageDialog(null, "An error occured while setting new Config-String!\n\nError: " + error + "\n\nYou should consider to install the game.");
			return false;
		}
		instance = new ConfigAdapter();
		return Installer.isInstalled();
	}
	
	public static String getConfigString(String key) {
		if(!(Thread.currentThread().getStackTrace()[2].getClassName().contains("snake.io.Logger") || Thread.currentThread().getStackTrace()[2].getMethodName().contains("initLogger"))) SnakeGame.log(Logger.LoggingType.INFO.type + "Loading " + key + " from config");
		if(instance == null) new ConfigAdapter();
		return instance.getValue(key);
	}
	
	public static boolean setConfigString(String key, String value) {
		if(!(Thread.currentThread().getStackTrace()[2].getClassName().contains("snake.io.Logger") || Thread.currentThread().getStackTrace()[2].getMethodName().contains("initLogger"))) SnakeGame.log(Logger.LoggingType.INFO.type + "Setting " + key + " to " + value + " in config");
		if(instance == null) new ConfigAdapter();
		return instance.setValue(key, value);
	}
}
