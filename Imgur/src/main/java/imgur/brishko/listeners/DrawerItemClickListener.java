package imgur.brishko.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import imgur.brishko.activites.MainActivity;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.interfaces.IRestartCallback;
import imgur.brishko.login.ImgurAuthorization;
import imgur.brishko.login.LoginActivity;

/**
 * On Drawer Item clicked listener applied to the listview associated with the drawer.
 */
public class DrawerItemClickListener implements ListView.OnItemClickListener {

    private static final String TAG = DrawerItemClickListener.class.getSimpleName();

    Context mContext;
    private IRestartCallback restartCallback;

    public DrawerItemClickListener(Activity activity) {
        restartCallback = (IRestartCallback) activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mContext = ImgurApp.getContext();

        //adding flag to the intent for calling outside of an activity
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        switch (position) {
            case 0: {

                break;
            }
            case 1: {

                break;
            }
            case 2: {

                break;
            }
            case 3: {

                break;
            }
            case 4: {

                break;
            }
            case 5: {
                ImgurAuthorization.getInstance().logout();
                restartCallback.restartActivity();
                break;
            }
            case 6: {
                //Login Activity

                ((MainActivity) restartCallback).startActivityForResult(intent.setClass(mContext, LoginActivity.class), 2);
                break;
            }
            default:
                break;
        }
        Log.d(TAG, view.toString() + "; POS = " + position + " ID=" + id);
    }
}
