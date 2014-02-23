package imgur.brishko.util;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

import imgur.brishko.adapters.GalleryAdapter;
import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;
import imgur.brishko.models.BaseGalleryImage;
import imgur.brishko.models.GalleryAlbum;
import imgur.brishko.models.GalleryImage;

/**
 *
 */
public class GetGalleryTask extends AsyncTask<String, Void, Void> {
    private final String TAG = GetGalleryTask.class.getSimpleName();

    ArrayList<BaseGalleryImage> galleryImages;
    GalleryAdapter adapter;

    public GetGalleryTask(ArrayList<BaseGalleryImage> galleryImages, GalleryAdapter adapter) {
        this.galleryImages = galleryImages;
        this.adapter = adapter;
    }

    @Override
    protected Void doInBackground(String... imgur_url_endpoint) {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(imgur_url_endpoint[0]);
        setImgurHeader(get);

        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            Log.d(TAG, result);
            parseJsonResponse(result);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //for(BaseGalleryImage image : galleryImages)
        //Log.d(TAG,image.toString());

        adapter.refersh(galleryImages);
    }

    private void setImgurHeader(HttpGet get) {
        String accestoken = ImgurApp.getSharedPreferences().getString(ImgurConstants.IMGUR_ACCESS_TOKEN, "");

        if (accestoken.length() != 0) {
            get.setHeader("Authorization", "Bearer " + accestoken);
        } else {
            get.setHeader("Authorization", "Client-ID " + ImgurConstants.IMGUR_CLIENT_ID);
        }

    }

    private void parseJsonResponse(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        Gson gson = new Gson();
        //parsing the result to JsonObject
        JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonString);

        //check if the response was success, can fail on expired access token.
        if (jsonObject.get("success").toString().contains("true")) {
            //parse the data of images and albums as json array
            JsonArray jsonArray = jsonObject.getAsJsonArray("data");

            //JsonArray is array of JsonElements
            for (int i = 0; i < jsonArray.size(); i++) {
                //parse it to JsonObject so that we can check if it's album or image
                JsonObject curObject = jsonArray.get(i).getAsJsonObject();
                //Log.d("OBJECT",curObject.toString());
                //If it's an album
                if (curObject.get("is_album").toString().contains("true")) {
                    galleryImages.add(gson.fromJson(jsonArray.get(i), GalleryAlbum.class));
                } else { //If it's an image
                    galleryImages.add(gson.fromJson(jsonArray.get(i), GalleryImage.class));
                }
            }
        }
    }
}
