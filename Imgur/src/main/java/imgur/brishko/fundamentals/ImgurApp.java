package imgur.brishko.fundamentals;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ImgurApp extends Application {

    private static final String TAG = ImgurApp.class.getSimpleName();

    private static SharedPreferences sharedPreferences;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        context = this;

        if (sharedPreferences.getString(ImgurConstants.USER_SELECTED_SECTION, "").length() == 0) {
            sharedPreferences.edit()
                    .putString(ImgurConstants.USER_SELECTED_SECTION, ImgurConstants.IMGUR_SECTION_HOT)
                    .putString(ImgurConstants.USER_SELECTED_SORT, ImgurConstants.IMGUR_SORT_VIRAL)
                    .commit();
        }

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheSizePercentage(15).build();

        ImageLoader.getInstance().init(configuration);
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
