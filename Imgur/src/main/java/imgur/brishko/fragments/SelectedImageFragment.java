package imgur.brishko.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import imgur.brishko.R;
import imgur.brishko.util.BitmapUtils;
import imgur.brishko.util.ImgurUploadTask;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link imgur.brishko.fragments.SelectedImageFragment.OnFragmentSelectedImageListener} interface
 * to handle interaction events.
 * Use the {@link SelectedImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SelectedImageFragment extends Fragment {
    //TODO Add Parametars to POST request
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String IMAGE_URI = "imageUri";

    private Uri imageUri;
    private ImageView selectedImage;
    TextView uploadedImageURL;
    ProgressBar progressBar;


    private OnFragmentSelectedImageListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param imageUri Uri to the selected Image.
     *
     * @return A new instance of fragment SelectedImageFragment.
     */

    public static SelectedImageFragment newInstance(Uri imageUri) {
        SelectedImageFragment fragment = new SelectedImageFragment();
        Bundle args = new Bundle();
        args.putParcelable(IMAGE_URI, imageUri);

        fragment.setArguments(args);
        return fragment;
    }
    public SelectedImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageUri = getArguments().getParcelable(IMAGE_URI);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_selected_image,null);
        selectedImage = (ImageView) view.findViewById(R.id.iv_selected_image_view);
        uploadedImageURL = (TextView) view.findViewById(R.id.tv_selected_image_uploaded_url);
        setBitmap(selectedImage);
        progressBar = (ProgressBar) view.findViewById(R.id.pb_selected_image);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new ImgurTask(imageUri,getActivity()).execute();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentSelectedImageListener) activity;
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
    public interface OnFragmentSelectedImageListener {

        public void onFragmentInteraction(Uri uri);
    }

    public void setBitmap(ImageView selectedImage){
        selectedImage.setImageBitmap(BitmapUtils.decodeSampledBitmapFromUri(imageUri, 400, 400));
    }

    class ImgurTask extends ImgurUploadTask{
        Activity activity;
        public ImgurTask(Uri imageUri, Activity activity) {
            super(imageUri, activity);
            this.activity = activity;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            activity.getActionBar().setTitle(activity.getString(R.string.uploaded));
            //Copy the url directly do clipboard
            ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("uploadedImageURL","http://www.imgur.com/" + s);
            clipboardManager.setPrimaryClip(clip);

            uploadedImageURL.setText("http://www.imgur.com/" + s);
            Toast.makeText(activity.getBaseContext(),"Copied to clipboard "+"http://www.imgur.com/" + s,Toast.LENGTH_SHORT).show();
        }
    }

}


