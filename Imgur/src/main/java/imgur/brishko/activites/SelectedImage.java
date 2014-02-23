package imgur.brishko.activites;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import imgur.brishko.R;
import imgur.brishko.fragments.SelectedImageFragment;
import imgur.brishko.fragments.SelectedImageFragment.OnFragmentSelectedImageListener;
import imgur.brishko.util.TypeFacedTextView;

public class SelectedImage extends Activity implements OnFragmentSelectedImageListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_image);

        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView m = (TextView) findViewById(titleId);
        TypeFacedTextView.AddRobotoFont(m);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container_selcted_image, SelectedImageFragment.newInstance((Uri) getIntent().getParcelableExtra("imageUri")))
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.selected_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Interaction with SelectedImageFragment
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
