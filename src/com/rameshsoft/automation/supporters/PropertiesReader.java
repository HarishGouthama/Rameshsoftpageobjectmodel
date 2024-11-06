package com.rameshsoft.automation.supporters;

import java.io.*;
import java.util.*;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;

public class PropertiesReader {

    private String filePath;
    private Properties properties;

    public PropertiesReader(String filePath) throws IOException {
        this.filePath = filePath;
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        }
    }

    public String getValue(String key) throws FrameworkException {
        checkProperties();
        return properties.getProperty(key);
    }

    public String getValue(String key, String defaultValue) throws FrameworkException {
        checkProperties();
        return properties.getProperty(key, defaultValue);
    }

    public void writeKeyValue(String key, String value) throws FrameworkException, IOException {
        checkProperties();
        properties.setProperty(key, value);
        saveProperties();
    }

    public void deleteKey(String key) throws FrameworkException, IOException {
        checkProperties();
        properties.remove(key);
        saveProperties();
    }

    public void replaceKeyValue(String key, String value) throws FrameworkException, IOException {
        checkProperties();
        properties.replace(key, value);
        saveProperties();
    }

    public Set<String> getAllKeys() throws FrameworkException {
        checkProperties();
        return properties.stringPropertyNames();
    }

    public List<String> getAllValues() {
        List<String> listValues = new ArrayList<>();
        for (String key : properties.stringPropertyNames()) {
            listValues.add(properties.getProperty(key));
        }
        return listValues;
    }

    public Map<String, String> getKeysValues() {
        Map<String, String> map = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            map.put(key, properties.getProperty(key));
        }
        return map;
    }

    private void checkProperties() throws FrameworkException {
        if (properties == null) {
            throw new FrameworkException("Properties object is pointing to null");
        }
    }

    private void saveProperties() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            properties.store(fileOutputStream, "File is saved successfully");
        }
    }
}
