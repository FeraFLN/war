/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.territorio.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author feraf
 */
public class Props {

    public static Properties getProperties(String path) {
        InputStream file = null;
        Properties properties = null;
        try {
            properties = new Properties();
            file = new FileInputStream(path);
            properties.load(file);
            file.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            //TODO treat exception
        } catch (IOException ex) {
            //TODO treat exception
            ex.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return properties;
    }
    public static Properties getProperties(PropFilesEnum path) {
        return getProperties(path.getPath());
    }
}
