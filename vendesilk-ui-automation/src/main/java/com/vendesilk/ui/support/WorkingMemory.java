package com.vendesilk.ui.support;

import java.util.HashMap;
import java.util.Map;

public class WorkingMemory {
    private static WorkingMemory instance = null;
    private Map<String, String> memory;
    private Map<String, String[]> memoryArray;

    //private static final Logger log = Logger.getLogger(WorkingMemory.class);

    private WorkingMemory() {
        memory = new HashMap<String, String>();
        memoryArray = new HashMap<String, String[]>();
    }

    public static synchronized WorkingMemory getInstance() {
        if (instance == null) {
            instance = new WorkingMemory();
        }
        return instance;
    }

    /**
     * Store given temporary value under hash-map
     * @param key
     * @param value
     */
    public synchronized void setMemory(String key, String value) {
        memory.put(key, value);
        //log.info("Memorizing the value'" + value + "' for the key: " + key);
    }

    /**
     * Store given temporary value under array-list
     * @param key
     * @param array
     */
    public synchronized void setMemoryArray(String key, String[] array) {
        memoryArray.put(key, array);
        //log.info("Memorizing array:" + key + "with values"+ Arrays.toString(array));
    }

    /**
     * Get stored value according to the given key from hash-map
     * @param key
     * @return String
     */
    public synchronized String getMemory(String key) {
        try {
            //log.info("Using the memorized value for the key " + key + ":"+ memory.get(key).toString());
            return memory.get(key).toString();
        } catch (Exception e) {
            //log.error("com.cambio.qa.utils.exception :", e);
            return null;
        }
    }

    /**
     * Get stored value according to the given key from array-list
     * @param key
     * @return String[]
     */
    public synchronized String[] getMemoryArray(String key) {
        String[] memArray = null;
        try {
            memArray = memoryArray.get(key);
            //log.info("Using the memorized array value for the key " + key+ ":" + memoryArray.get(key));
            return memArray;
        } catch (Exception e) {
            //log.error("com.cambio.qa.utils.exception :", e);
            return memArray;
        }

    }

}
