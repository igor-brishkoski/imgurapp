package imgur.brishko.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import imgur.brishko.R;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;
import imgur.brishko.models.BaseGalleryImage;
import imgur.brishko.models.BaseImage;
import imgur.brishko.models.GalleryAlbum;
import imgur.brishko.models.GalleryImage;

/**
 * Created by bri6ko on 2/12/14.
 */
public class GalleryAdapter extends BaseAdapter {

    private static final String TAG = GalleryAdapter.class.getSimpleName();
    List<BaseGalleryImage> baseGalleryImages;
    DisplayImageOptions imageOptions;


    public GalleryAdapter(List<BaseGalleryImage> baseGalleryImages) {
        this.baseGalleryImages = baseGalleryImages;
        imageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(false)
                .cacheOnDisc(false)
                .showImageForEmptyUri(R.drawable.ic_launcher)
                .showImageOnLoading(R.drawable.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .build();
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
        ImageView thumbnail = null;
        ImageView background = null;
        //check if the view is created
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) ImgurApp.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //if not apply correct image/album layout
            if (baseGalleryImages.get(position) instanceof GalleryImage) {
                convertView = layoutInflater.inflate(R.layout.gallery_image_item, null);
            } else {
                convertView = layoutInflater.inflate(R.layout.gallery_album_item, null);
            }
        }

        //set the thumbnail, ID for image, cover for Album
        //can;t set on clcik here, has to be on the gridview
        if (baseGalleryImages.get(position) instanceof GalleryImage) {
            setImageLayout(thumbnail, convertView, (GalleryImage) baseGalleryImages.get(position));
            background = (ImageView) convertView.findViewById(R.id.iv_gallery_image_item_back);
            if (background != null) {
                setBackgroundVoteColor(background, baseGalleryImages.get(position));
                Log.d(TAG, "NOOT NULL");
            }
        } else {
            setAlbumLayout(thumbnail, convertView, (GalleryAlbum) baseGalleryImages.get(position));
            background = (ImageView) convertView.findViewById(R.id.iv_gallery_album_item_back);
            if (background != null) {
                setBackgroundVoteColor(background, baseGalleryImages.get(position));
                Log.d(TAG, "NOOT NULL");
            }
        }

        //


        return convertView;
    }

    private void setImageLayout(ImageView thumbnail, View convertView, GalleryImage image) {
        thumbnail = (ImageView) convertView.findViewById(R.id.iv_gallery_image_item_thumb);
        //Picasso.with(ImgurApp.getContext()).load(ImgurConstants.IMGUR_URL + image.getId() + BaseImage.SMALL_SQUARE_THUMBNAIL + ".jpg").into(thumbnail);
        ImageLoader.getInstance().displayImage(ImgurConstants.IMGUR_URL + image.getId() + BaseImage.SMALL_SQUARE_THUMBNAIL + ".jpg", thumbnail);
    }

    private void setAlbumLayout(ImageView thumbnail, View convertView, GalleryAlbum album) {
        thumbnail = (ImageView) convertView.findViewById(R.id.iv_gallery_album_item_thumb);
        //Picasso.with(ImgurApp.getContext()).load(ImgurConstants.IMGUR_URL + album.getCover() + BaseImage.SMALL_SQUARE_THUMBNAIL + ".jpg").into(thumbnail);
        ImageLoader.getInstance().displayImage(ImgurConstants.IMGUR_URL + album.getCover() + BaseImage.SMALL_SQUARE_THUMBNAIL + ".jpg", thumbnail);
    }

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
