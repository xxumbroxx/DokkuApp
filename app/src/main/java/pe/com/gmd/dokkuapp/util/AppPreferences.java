package pe.com.gmd.dokkuapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by glarab on 01/06/16.
 * Clase para gestionar las preferencias de la app
 */

public class AppPreferences {

	//archivo de preferencias
	private static final String PREF_NAME = "gmd_app_name";
	//declarar constantes finales llaves de preferenceias
	public static final String PREF_ISUSERLOGGED = "IsUserLogged";
	public static final String PREF_USERID = "UserId";
	public static final String BACKFROMBACKGROUND = "frombackground";
	public static final String PREF_SOCKET_TIMEOUT = "SocketTimeout";
	public static final String FLAG_ONBOARDING = "flag_onboarding";
	public static final String USER_FB_TOKEN ="usuario_fb_to" ;
	public static final String USER_MAIL ="usuario_mail" ;

	public static AppPreferences appPreferences;
	public Context context;
	public SharedPreferences sharedPreferences;
	
	public static AppPreferences getInstance(final Context context){
		if (appPreferences==null){
			appPreferences = new AppPreferences(context);
		}
		return appPreferences;
	}

	public Boolean isOnBordingVisto(){
		boolean booIsOnboarding = sharedPreferences.getBoolean(FLAG_ONBOARDING, false);
		return booIsOnboarding;
	}
	
	public AppPreferences(final Context context){
		this.context = context;
		sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		
	}
	public boolean _IsLogged(){
		boolean booIsLogged = sharedPreferences.getBoolean(PREF_ISUSERLOGGED, false);
		return booIsLogged;
	}


	public int _loadUserId(){
		int intUserId = sharedPreferences.getInt(PREF_USERID, -1);
		return intUserId;
	}

	public String _EmailLogin(){
		String mail = sharedPreferences.getString(USER_MAIL, null);
		return mail;
	}

	public String token(){
		String token = sharedPreferences.getString(USER_FB_TOKEN, null);
		return token;
	}

	public int _loadSocketTimeout(){
		int intUserId = sharedPreferences.getInt(PREF_SOCKET_TIMEOUT, Constants.DEFAULT_SOCKET_TIMEOUT);
		return intUserId;
	}

	public Boolean _IsBackFromBackground() {
        return sharedPreferences.getBoolean(BACKFROMBACKGROUND, false);
    }


	//Guardar preferencias
	public void savePreference(final String strPrefKey, final Object objPrefValue){
		SharedPreferences.Editor editor = sharedPreferences.edit();
		if (objPrefValue instanceof String) {
			editor.putString(strPrefKey, (String) objPrefValue);
        } else if (objPrefValue instanceof Boolean) {
        	editor.putBoolean(strPrefKey, (Boolean) objPrefValue);
        } else if (objPrefValue instanceof Integer) {
        	editor.putInt(strPrefKey, (Integer) objPrefValue);
        } else if (objPrefValue instanceof Long) {
        	editor.putLong(strPrefKey, (Long) objPrefValue);
        } else if (objPrefValue instanceof Float) {
        	editor.putFloat(strPrefKey, (Float) objPrefValue);
        }
		

		editor.commit();
	}


	/**
	 * Guardar y recuperar preferencaias por activity
	 * @param context
	 * @param key
	 * @param defaultValue
     * @return
     */




}
