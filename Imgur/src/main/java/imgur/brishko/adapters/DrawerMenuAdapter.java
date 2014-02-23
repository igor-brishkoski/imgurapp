package imgur.brishko.adapters;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        TypeFacedTextView editText = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ImgurApp.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            switch (position) {
                case 0:
                    convertView = inflater.inflate(R.layout.drawer_browse, null);
                    TextView mTvBrowse = (TextView) convertView.findViewById(R.id.tv_drawr_browse_browse);
                    mTvBrowse.setText(menutItemsList[position]);
                    browseLayout(convertView);
                    break;
                default:
                    convertView = inflater.inflate(R.layout.drawer_menu_item_layout, null);
                    editText = (TypeFacedTextView) convertView.findViewById(R.id.drawer_custom_menu_item);
                    editText.setText(menutItemsList[position]);

                    //Seting the login / logut button in the drawer whether the user is logged in or not
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

            }
        }

        return convertView;
    }

    //setting up the browse prefrences in the drawer menu
    private void browseLayout(View convertView) {
        TextView mTvSection = (TextView) convertView.findViewById(R.id.tv_drawr_browse_section);
        TextView mTvSort = (TextView) convertView.findViewById(R.id.tv_drawr_browse_sort);

        String sec = ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SECTION, "");
        String sort = ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SORT, "");

        if(sec.length()!=0 && sort.length()!=0){
            mTvSection.setText(" "+ sec.substring(0,1).toUpperCase()+sec.substring(1,sec.length()-1));
            mTvSort.setText(" "+ sort.substring(0,1).toUpperCase()+sort.substring(1,sort.length()-1));
        }

        //selection setup
        mTvSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = "";
                switch (((TextView) v).getText().toString()) {
                    case " Top":
                        ((TextView) v).setText(" Hot");
                        selection = ImgurConstants.IMGUR_SECTION_HOT;
                        break;
                    case " Hot":
                        ((TextView) v).setText(" User");
                        selection = ImgurConstants.IMGUR_SECTION_USER;
                        break;
                    case " User":
                        ((TextView) v).setText(" Top");
                        selection = ImgurConstants.IMGUR_SECTION_TOP;
                        break;
                }
                putSelection(selection);

            }
        });
        //sort setup
        mTvSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sort = "";
                switch (((TextView) v).getText().toString()) {
                    case " Viral":
                        ((TextView) v).setText(" Time");
                        sort = ImgurConstants.IMGUR_SORT_DATE;
                        break;
                    case " Time":
                        ((TextView) v).setText(" Viral");
                        sort = ImgurConstants.IMGUR_SORT_VIRAL;
                        break;
                }
                putSort(sort);
            }
        });


    }

    //puting the changes in prefrences
    private void putSelection(String selection) {
        ImgurApp.getSharedPreferences().edit()
                .putString(ImgurConstants.USER_SELECTED_SECTION, selection)
                .putBoolean(ImgurConstants.BROWSING_PREFS_CHANGED, true)
                .commit();
    }

    //puting the changes in prefrences
    private void putSort(String sort) {
        ImgurApp.getSharedPreferences().edit()
                .putString(ImgurConstants.USER_SELECTED_SORT, sort)
                .putBoolean(ImgurConstants.BROWSING_PREFS_CHANGED, true)
                .commit();
    }
}
