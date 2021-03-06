package com.hypodiabetic.happ.integration.nsclient;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Tim on 10/08/2016.
 * Taken from https://github.com/MilosKozak/AndroidAPS/blob/master/app/src/main/java/info/nightscout/client/data/NSSgv.java
 */

/**
 *
 * {"mgdl":105,"mills":1455136282375,"device":"xDrip-BluetoothWixel","direction":"Flat","filtered":98272,"unfiltered":98272,"noise":1,"rssi":100}
 */
public class NSSgv {
    private JSONObject data;

    public NSSgv(JSONObject obj) {
        this.data = obj;
    }

    private String getStringOrNull(String key) {
        String ret = null;
        if (data.has(key)) {
            try {
                ret = data.getString(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    private Integer getIntegerOrNull(String key) {
        Integer ret = null;
        if (data.has(key)) {
            try {
                ret = data.getInt(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    private Long getLongOrNull(String key) {
        Long ret = null;
        if (data.has(key)) {
            try {
                ret = data.getLong(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    public JSONObject getData () { return data; }
    public Integer getMgdl () { return getIntegerOrNull("mgdl"); }
    public Integer getFiltered () { return getIntegerOrNull("filtered"); }
    public Integer getUnfiltered () { return getIntegerOrNull("unfiltered"); }
    public Integer getNoise () { return getIntegerOrNull("noise"); }
    public Integer getRssi () { return getIntegerOrNull("rssi"); }
    public Long getMills () { return getLongOrNull("mills"); }
    public String getDevice () { return getStringOrNull("device"); }
    public String getDirection () { return getStringOrNull("direction"); }

}
