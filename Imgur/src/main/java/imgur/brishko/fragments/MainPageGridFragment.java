package imgur.brishko.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import imgur.brishko.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import imgur.brishko.adapters.GalleryAdapter;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;
import imgur.brishko.models.BaseGalleryImage;
import imgur.brishko.models.GalleryAlbum;
import imgur.brishko.models.GalleryImage;
import imgur.brishko.util.GetGalleryTask;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainPageGridFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainPageGridFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class MainPageGridFragment extends Fragment implements OnRefreshListener {
    private final String TAG = MainPageGridFragment.class.getSimpleName();

    private PullToRefreshLayout pullToRefreshLayout;
    private OnFragmentInteractionListener mListener;
    private GridView gridView;
    private GalleryAdapter galleryAdapter;

    //TESST
    ArrayList<BaseGalleryImage> images;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainPageGridFragment.
     */
    public static MainPageGridFragment newInstance() {
        MainPageGridFragment fragment = new MainPageGridFragment();

        return fragment;
    }
    public MainPageGridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TEST
        images = new ArrayList<>();
        galleryAdapter = new GalleryAdapter(new ArrayList<BaseGalleryImage>());

        String section = ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SECTION,"");
        String sort = ImgurApp.getSharedPreferences().getString(ImgurConstants.USER_SELECTED_SORT, "");
        new GetGalleryTask(images, galleryAdapter).execute(ImgurConstants.IMGUR_BASE_API_ENDP+ImgurConstants.IMGUR_GALLERY_URL+section+sort);
        Log.d(TAG,ImgurConstants.IMGUR_BASE_API_ENDP+ImgurConstants.IMGUR_GALLERY_URL+section+sort);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,null);

        if(view != null){
            pullToRefreshLayout = (PullToRefreshLayout) view.findViewById(R.id.carddemo_extra_ptr_layout);
            gridView = (GridView) view.findViewById(R.id.gv_frg_main_galleryGrid);
            gridView.setAdapter(galleryAdapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(),images.get(position).getId(),Toast.LENGTH_SHORT).show();
                }
            });
        }


        ActionBarPullToRefresh.from(getActivity()).allChildrenArePullable()
                .listener(this)
                .setup(pullToRefreshLayout);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentSelectedImageListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onRefreshStarted(View view) {
        Toast.makeText(getActivity(),"Refresher",Toast.LENGTH_SHORT).show();
        //pullToRefreshLayout.setRefreshComplete();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
