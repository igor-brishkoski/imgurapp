package imgur.brishko.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import imgur.brishko.R;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;
import imgur.brishko.util.TypeFacedTextView;


public class DrawerMenuAdapter extends BaseAdapter {

    private static final String TAG = DrawerMenuAdapter.class.getSimpleName();

    String[] menutItemsList;

    public DrawerMenuAdapter(int itemsResource) {
        menutItemsList = ImgurApp.getContext().getResources().getStringArray(itemsResource);
    }

    @Override
    public int getCount() {
        return menutItemsList.length;
    }

    @Override
    public Object getItem(int position) {
        return menutItemsList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ImgurApp.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_menu_item_layout, null);
        }
        TypeFacedTextView editText = (TypeFacedTextView) convertView.findViewById(R.id.drawer_custom_menu_item);
        editText.setText(menutItemsList[position]);

        //Log.d(TAG, menutItemsList[position]);

        //show/hide sign in/logout in the drawer menu whether the user is signed in or not
        if (ImgurApp.getSharedPreferences().getString(ImgurConstants.IMGUR_ACCESS_TOKEN, "").length() == 0) {
            if (menutItemsList[position].equalsIgnoreCase("Logout")) {
                editText.setVisibility(View.GONE);
            } else {
                editText.setVisibility(View.VISIBLE);
            }
        } else {
            if (menutItemsList[position].equalsIgnoreCase("Sign In")) {
                editText.setVisibility(View.GONE);
            } else {
                editText.setVisibility(View.VISIBLE);
            }


        }
        return convertView;
    }
}
