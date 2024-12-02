package com.collince.rolexcore.util.storage.preference;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;



public class PreferenceOpenHelper {

    private static PreferenceOpenHelper INSTANCE;

    private static final Map<String, Preference> PREFERENCES = new HashMap<>();

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    private PreferenceOpenHelper() {
    }
    //========================================================

    //--------------------------------------------------------
    // Static methods
    //--------------------------------------------------------
    public static PreferenceOpenHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PreferenceOpenHelper();
        }

        return INSTANCE;
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    public Preference open(Context context, String name) {
        if (PREFERENCES.containsKey(name)) {
            return PREFERENCES.get(name);
        } else {
            Preference prefs = new Preference(context, name);
            PREFERENCES.put(name, prefs);
            return prefs;
        }
    }
    //========================================================

}
