package imgur.brishko.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import imgur.brishko.R;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;
import imgur.brishko.models.BaseGalleryImage;
import imgur.brishko.models.BaseImage;
import imgur.brishko.models.GalleryAlbum;
import imgur.brishko.models.GalleryImage;

public class GalleryAdapter extends BaseAdapter {

    private static final String TAG = GalleryAdapter.class.getSimpleName();
    List<BaseGalleryImage> baseGalleryImages;

    public GalleryAdapter(List<BaseGalleryImage> baseGalleryImages) {
        this.baseGalleryImages = baseGalleryImages;
    }

    @Override
    public int getCount() {
        return baseGalleryImages.size();
    }

    @Override
    public Object getItem(int position) {
        return baseGalleryImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseGalleryImage baseGalleryImage = baseGalleryImages.get(position);
        View mainView = convertView;
        //check if the view is created
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) ImgurApp.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            mainView = layoutInflater.inflate(R.layout.gallery_image_item,null);
        }

        ImageView pic = (ImageView) mainView.findViewById(R.id.iv_gallery_image_item_thumb);
        ImageView backg = (ImageView) mainView.findViewById(R.id.iv_gallery_image_item_back);
        String url = "";

        if(baseGalleryImage instanceof GalleryImage){
            url = ImgurConstants.IMGUR_URL + baseGalleryImage.getId() + BaseImage.SMALL_SQUARE_THUMBNAIL + ".jpg";
        }else
        {
            url = ImgurConstants.IMGUR_URL + ((GalleryAlbum)baseGalleryImage).getCover() + BaseImage.SMALL_SQUARE_THUMBNAIL + ".jpg";
        }

        //setting the picture in the main gallery
        Ion.with(pic)
                .placeholder(R.drawable.ic_launcher)
                .error(R.drawable.ic_launcher)
                .load(url);

        //setting the color of the backgroun
        setBackgroundVoteColor(backg,baseGalleryImage);

        return mainView;
    }

    //if the image is upvoted by the user is green, if downvoted is red and if neutral is dark grey
    private void setBackgroundVoteColor(ImageView imageView, BaseGalleryImage image) {
        if (image.getVote() != null) {
            switch (image.getVote()) {
                case "up":
                    imageView.setBackgroundColor(ImgurApp.getContext().getResources().getColor(R.color.imgur_green));
                    break;
                case "down":
                    imageView.setBackgroundColor(ImgurApp.getContext().getResources().getColor(R.color.imgur_red));
                    break;
            }
        } else {
            imageView.setBackgroundColor(ImgurApp.getContext().getResources().getColor(R.color.imgur_dark_grey));
        }
    }

    public void refersh(ArrayList<BaseGalleryImage> images) {
        //baseGalleryImages.clear();
        baseGalleryImages.addAll(images);
        notifyDataSetChanged();
    }
}
