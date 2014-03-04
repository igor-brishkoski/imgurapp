package imgur.brishko.fundamentals;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class ImgurApp extends Application {

    private static final String TAG = ImgurApp.class.getSimpleName();

    private static SharedPreferences sharedPreferences;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        context = this;

        //set the page to 0 every time the user activates the app
        sharedPreferences.edit().putString(ImgurConstants.CURRENT_PAGE,"0").commit();

        //first time app activated, set the section and sorting to default
        if (sharedPreferences.getString(ImgurConstants.USER_SELECTED_SECTION, "").length() == 0) {
            sharedPreferences.edit()
                    .putString(ImgurConstants.USER_SELECTED_SECTION, ImgurConstants.IMGUR_SECTION_HOT)
                    .putString(ImgurConstants.USER_SELECTED_SORT, ImgurConstants.IMGUR_SORT_VIRAL)
                    .commit();
        }
    }

    /**
     * @return apps default SharedPrefrences
     */
    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    /**
     * @return the app Context
     */
    public static Context getContext() {
        return context;
    }
}
