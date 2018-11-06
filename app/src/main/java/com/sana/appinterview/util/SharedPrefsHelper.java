package com.sana.appinterview.util;

import android.content.SharedPreferences;

import java.util.Set;


/**
 * Created by S.Masoud on 2017/04/29.
 */


public class SharedPrefsHelper {

    private SharedPreferences mSharedPreferences;

    public SharedPrefsHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void putSet(String key, Set<String> value) {
        mSharedPreferences.edit().putStringSet(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, long value) {
        mSharedPreferences.edit().putLong(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public Set<String> getSet(String key, Set<String> defaultValue) {
        return mSharedPreferences.getStringSet(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public Long get(String key, long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }


    public void deleteSavedData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }
}