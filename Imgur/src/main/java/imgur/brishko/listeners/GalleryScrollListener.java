package imgur.brishko.listeners;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.AbsListView;

import imgur.brishko.fragments.MainPageGridFragment;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;


public class GalleryScrollListener implements AbsListView.OnScrollListener {

    private final String TAG = GalleryScrollListener.class.getSimpleName();

    Fragment fragment;
    SharedPreferences sharedPreferences;


    public GalleryScrollListener(Fragment fragment) {
        this.fragment = fragment;
        sharedPreferences = ImgurApp.getSharedPreferences();
        sharedPreferences.edit().putBoolean(ImgurConstants.LOADING,true).commit();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        Log.d(TAG, "firstVisibleItem = "+firstVisibleItem+"; totalItemCount = "+totalItemCount+"; visibleitems = "+visibleItemCount);

        if((firstVisibleItem+visibleItemCount)>totalItemCount-5 && totalItemCount!=0 && sharedPreferences.getBoolean(ImgurConstants.LOADING,false)){

            int page = Integer.parseInt(sharedPreferences.getString(ImgurConstants.CURRENT_PAGE,"0"));
            page += 1;
            sharedPreferences.edit()
                    .putBoolean(ImgurConstants.LOADING,false)
                    .putString(ImgurConstants.CURRENT_PAGE, Integer.toString(page))
                    .commit();

            Log.d(TAG,"ASYNCTASK FIRE");
            ((MainPageGridFragment)fragment).getGallery();

        }
    }
}
