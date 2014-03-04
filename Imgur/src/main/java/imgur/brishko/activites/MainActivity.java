package imgur.brishko.activites;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import imgur.brishko.R;
import imgur.brishko.adapters.DrawerMenuAdapter;
import imgur.brishko.fragments.MainPageGridFragment;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;
import imgur.brishko.interfaces.IRestartCallback;
import imgur.brishko.listeners.DrawerItemClickListener;
import imgur.brishko.listeners.ToggleButtonDrawer;
import imgur.brishko.login.RefreshAccessTokenTask;
import imgur.brishko.util.TypeFacedTextView;

public class MainActivity extends ActionBarActivity implements IRestartCallback, MainPageGridFragment.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    final int REQ_CODE_PICK_IMAGE = 1;

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    DrawerMenuAdapter mDrawerMenuAdapter;
    ToggleButtonDrawer toggleButtonDrawer;
    SharedPreferences sharedPreferences;
    MainPageGridFragment mainPageGridFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = ImgurApp.getSharedPreferences();

        //Initial setup of section and sort for the gallery


        //getting the actionbar title id so that we can change the font
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView m = (TextView) findViewById(titleId);
        TypeFacedTextView.AddRobotoFont(m);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerMenuAdapter = new DrawerMenuAdapter(R.array.drawable_items);
        toggleButtonDrawer = new ToggleButtonDrawer(this, mDrawerLayout, R.drawable.apptheme_ic_navigation_drawer, R.string.openDrawer, R.string.app_name);

        mDrawerList.setAdapter(mDrawerMenuAdapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener(MainActivity.this));
        mDrawerLayout.setDrawerListener(toggleButtonDrawer);

        mainPageGridFragment = MainPageGridFragment.newInstance();

        getFragmentManager().beginTransaction().replace(R.id.container_main, mainPageGridFragment).commit();

        getActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setHomeButtonEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //Catch if the toggle button for the drawer was pressed
        if (toggleButtonDrawer.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.action_upload) {
            pickImage();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //we can hide action menu here by checking if the
        //drawer is open or not
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        //has to be called for the togglebutton
        toggleButtonDrawer.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //has to be called for the togglebutton
        toggleButtonDrawer.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        //setting the menu after logging in
        //see if there is change in state and notify the adapter
        if (sharedPreferences.getBoolean(ImgurConstants.LOGGIN_IN_OUT, false)) {
            Log.d(TAG, "onResume restart");
            restartActivity();
            sharedPreferences.edit().putBoolean(ImgurConstants.LOGGIN_IN_OUT, false).commit();
        } else {
            new RefreshAccessTokenTask().execute();
        }
    }

    //restarting the activity on logout
    public void restartActivity() {
        this.finish();
        this.startActivity(getIntent());
    }

    public void pickImage() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, REQ_CODE_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case REQ_CODE_PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    startActivity(new Intent(this, SelectedImage.class).putExtra("imageUri", selectedImage));
                }
                break;
        }
    }

    //called when the user changed the browsing prefs in the drawer menu
    public void browsingPrefrencesChanged() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container_main, MainPageGridFragment.newInstance())
                .addToBackStack(null)
                .commit();
        sharedPreferences.edit().putBoolean(ImgurConstants.BROWSING_PREFS_CHANGED, false).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


