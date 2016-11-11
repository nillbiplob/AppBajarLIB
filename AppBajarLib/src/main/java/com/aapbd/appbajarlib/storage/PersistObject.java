package com.aapbd.appbajarlib.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class PersistObject {

	public static boolean contains(Context context, String key) {
		return getDefaultInstance(context).contains(key);
	}

	public static <T> T get(Context context, String key, Class<T> cls) {
		return getDefaultInstance(context).get(key, cls);
	}

	public static int getTotalObjectNumber(Context context, String key) {
		return getDefaultInstance(context).getInt(key);
	}

	public static void apply(Context context, String key, Object value) {
		getDefaultInstance(context).apply(key, value);
	}

	public static void commit(Context context, String key, Object value) {
		getDefaultInstance(context).commit(key, value);
	}

	public static void commitTotalObjectNumber(Context context, String key,
			int value) {
		getDefaultInstance(context).commitInt(key, value);
	}

	private static PersistObject getDefaultInstance(Context context) {
		final SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(context);
		return new PersistObject(sp);
	}

	private final Gson mGson;

	private final SharedPreferences mSharedPrefs;

	public PersistObject(SharedPreferences sharedPrefs) {
		mGson = new Gson();
		mSharedPrefs = sharedPrefs;
	}

	public boolean contains(String key) {
		return mSharedPrefs.contains(key);
	}

	public <T> T get(String key, Class<T> cls) {
		if (contains(key)) {
			return mGson.fromJson(mSharedPrefs.getString(key, null), cls);
		}

		try {
			return cls.newInstance();
		} catch (final Exception e) {
			throw new IllegalArgumentException(
					"class must have an empty constructor");
		}
	}

	public int getInt(String key) {
		if (contains(key)) {
			return mSharedPrefs.getInt(key, 0);
		}
		return 0;

	}

	public void apply(String key, Object value) {
		put(key, value).apply();
	}

	public void commit(String key, Object value) {
		put(key, value).commit();
	}

	/*
	 * store object number
	 */
	public void commitInt(String key, int value) {
		putInt(key, value).commit();
	}

	@SuppressLint("CommitPrefEdits")
	private Editor put(String key, Object value) {
		final Editor e = mSharedPrefs.edit();
		e.putString(key, mGson.toJson(value));
		return e;
	}

	@SuppressLint("CommitPrefEdits")
	private Editor putInt(String key, int value) {
		final Editor e = mSharedPrefs.edit();
		e.putInt(key, value);
		return e;
	}
}
