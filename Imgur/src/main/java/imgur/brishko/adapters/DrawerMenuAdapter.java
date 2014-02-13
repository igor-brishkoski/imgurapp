package imgur.brishko.adapters;

import android.app.Activity;
import android.util.Log;
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
        /*
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
        */
        return convertView;
    }

    private void browseLayout(View convertView) {
        TextView mTvSection = (TextView) convertView.findViewById(R.id.tv_drawr_browse_section);
        TextView mTvSort = (TextView) convertView.findViewById(R.id.tv_drawr_browse_sort);

        mTvSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(((TextView)v).getText().toString()){
                    case " Top":
                        ((TextView)v).setText(" Viral");
                        ImgurApp.getSharedPreferences().edit().putString(ImgurConstants.USER_SELECTED_SECTION,ImgurConstants.IMGUR_SECTION_HOT).commit();
                        break;
                    case " Viral":
                        ((TextView)v).setText(" User");
                        ImgurApp.getSharedPreferences().edit().putString(ImgurConstants.USER_SELECTED_SECTION,ImgurConstants.IMGUR_SECTION_USER).commit();
                        break;
                    case " User":
                        ((TextView)v).setText(" Top");
                        ImgurApp.getSharedPreferences().edit().putString(ImgurConstants.USER_SELECTED_SECTION,ImgurConstants.IMGUR_SECTION_TOP).commit();
                        break;
                }
                Log.d(TAG,"https://api.imgur.com/3/gallery/"+ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SECTION,"")+
                        ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SORT,""));
            }
        });

        mTvSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((TextView)v).getText().toString()){
                    case " Popular":
                        ((TextView)v).setText(" New");
                        ImgurApp.getSharedPreferences().edit().putString(ImgurConstants.USER_SELECTED_SORT,ImgurConstants.IMGUR_SORT_DATE).commit();
                        break;
                    case " New":
                        ((TextView)v).setText(" Popular");
                        ImgurApp.getSharedPreferences().edit().putString(ImgurConstants.USER_SELECTED_SORT,ImgurConstants.IMGUR_SORT_VIRAL).commit();
                        break;
                }
                Log.d(TAG,"https://api.imgur.com/3/gallery/"+ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SECTION,"")+
                        ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SORT,""));
            }
        });
    }
}
