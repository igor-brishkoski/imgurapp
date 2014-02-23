package imgur.brishko.listeners;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import imgur.brishko.activites.MainActivity;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;

/**
 * Class for tne drawer toggle button
 */
public class ToggleButtonDrawer extends ActionBarDrawerToggle {

    private static final String TAG = ToggleButtonDrawer.class.getSimpleName();

    Activity activity;
    int openDrawerResource;
    int closedDrawerResource;

    //The constructor needs to be called with super
    public ToggleButtonDrawer(Activity activity, DrawerLayout drawerLayout, int drawerImageRes, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes, closeDrawerContentDescRes);
        this.activity = activity;
        this.openDrawerResource = openDrawerContentDescRes;
        this.closedDrawerResource = closeDrawerContentDescRes;
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);

        if (activity.getActionBar() != null) {
            activity.getActionBar().setTitle(closedDrawerResource);
            activity.invalidateOptionsMenu();

            //check if the user has made changes in the browsing prefs and reload the fragment if so
            if (ImgurApp.getSharedPreferences().getBoolean(ImgurConstants.BROWSING_PREFS_CHANGED, false)) {
                ((MainActivity) activity).browsingPrefrencesChanged();
            }
        }

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);

        if (activity.getActionBar() != null) {
            activity.getActionBar().setTitle(openDrawerResource);
            activity.invalidateOptionsMenu();
        }
    }
}
