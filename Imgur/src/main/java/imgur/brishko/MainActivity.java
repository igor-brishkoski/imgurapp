package imgur.brishko;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import imgur.brishko.adapters.DrawerMenuAdapter;
import imgur.brishko.listeners.ToggleButtonDrawer;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ToggleButtonDrawer toggleButtonDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int titleId = getResources().getIdentifier("action_bar_title", "id","android");
        TextView m = (TextView)findViewById(titleId);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"robotoregular.ttf");
        m.setTypeface(typeface);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        toggleButtonDrawer = new ToggleButtonDrawer(this, mDrawerLayout, R.drawable.ic_drawer2, R.string.openDrawer, R.string.app_name);

        mDrawerList.setAdapter(new DrawerMenuAdapter(R.array.drawable_items));
        mDrawerLayout.setDrawerListener(toggleButtonDrawer);

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
        if (id == R.id.action_settings) {
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
    }
}
