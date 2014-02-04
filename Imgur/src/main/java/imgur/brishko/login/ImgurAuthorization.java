package imgur.brishko.login;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;

public class ImgurAuthorization {

    private static final String TAG = ImgurAuthorization.class.getSimpleName();

    private static ImgurAuthorization INSTANCE;

    private ImgurAuthorization() {
    }

    public static ImgurAuthorization getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ImgurAuthorization();
        return INSTANCE;

    }

    public boolean isLoggedIn() {
        SharedPreferences prefs = ImgurApp.getSharedPreferences();
        return !TextUtils.isEmpty(prefs.getString(ImgurConstants.IMGUR_ACCESS_TOKEN, null));
    }


    //Adds client ID or Access Token to url when creating a connection to imgur
    //depending whether the user is logged in or not
    public void addToHttpURLConnection(HttpURLConnection conn) {
        SharedPreferences prefs = ImgurApp.getSharedPreferences();
        String accessToken = prefs.getString(ImgurConstants.IMGUR_ACCESS_TOKEN, null);

        if (!TextUtils.isEmpty(accessToken)) {
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        } else {
            conn.setRequestProperty("Authorization", "Client-ID " + ImgurConstants.IMGUR_CLIENT_ID);
        }
    }

    public void saveRefreshToken(String refreshToken, String accessToken, long expiresIn) {
        ImgurApp.getSharedPreferences()
                .edit()
                .putString(ImgurConstants.IMGUR_ACCESS_TOKEN, accessToken)
                .putString(ImgurConstants.IMGUR_REFRESH_TOKEN, refreshToken)
                .putLong(ImgurConstants.IMGUR_EXPIRES_IN, expiresIn)
                .commit();
    }

    public String requestNewAccessToken() {
        SharedPreferences prefs = ImgurApp.getSharedPreferences();
        String refreshToken = prefs.getString(ImgurConstants.IMGUR_REFRESH_TOKEN, null);

        if (refreshToken == null) {
            Log.w(TAG, "refresh token is null; cannot request access token. login first.");
            return null;
        }

        // clear previous access token
        prefs.edit().remove(ImgurConstants.IMGUR_ACCESS_TOKEN).commit();

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(ImgurConstants.IMGUR_ACCESS_TOKEN_URL).openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Client-ID " + ImgurConstants.IMGUR_CLIENT_ID);

            ArrayList<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair(ImgurConstants.IMGUR_REFRESH_TOKEN, refreshToken));
            nvps.add(new BasicNameValuePair("client_id", ImgurConstants.IMGUR_CLIENT_ID));
            nvps.add(new BasicNameValuePair("client_secret", ImgurConstants.IMGUR_CLIENT_SECRET));
            nvps.add(new BasicNameValuePair("grant_type", ImgurConstants.IMGUR_REFRESH_TOKEN));

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps);

            OutputStream out = conn.getOutputStream();
            entity.writeTo(out);
            out.flush();
            out.close();

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = conn.getInputStream();
                handleAccessTokenResponse(in);
                in.close();
            } else {
                Log.i(TAG, "responseCode=" + conn.getResponseCode());
                InputStream errorStream = conn.getErrorStream();
                StringBuilder sb = new StringBuilder();
                Scanner scanner = new Scanner(errorStream);
                while (scanner.hasNext()) {
                    sb.append(scanner.next());
                }
                Log.i(TAG, "error response: " + sb.toString());
                errorStream.close();
            }

            return prefs.getString(ImgurConstants.IMGUR_ACCESS_TOKEN, null);

        } catch (Exception ex) {
            Log.e(TAG, "Could not request new access token", ex);
            return null;
        } finally {
            try {
                conn.disconnect();
            } catch (Exception ignore) {
            }
        }
    }

    private void handleAccessTokenResponse(InputStream in) throws JSONException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            sb.append(scanner.next());
        }

        JSONObject root = new JSONObject(sb.toString());
        String accessToken = root.getString(ImgurConstants.IMGUR_ACCESS_TOKEN);
        String refreshToken = root.getString(ImgurConstants.IMGUR_REFRESH_TOKEN);
        long expiresIn = root.getLong(ImgurConstants.IMGUR_EXPIRES_IN);
        String tokenType = root.getString("token_type");
        String accountUsername = root.getString("account_username");

        ImgurApp.getSharedPreferences()
                .edit()
                .putString(ImgurConstants.IMGUR_ACCESS_TOKEN, accessToken)
                .putString(ImgurConstants.IMGUR_REFRESH_TOKEN, refreshToken)
                .putLong(ImgurConstants.IMGUR_EXPIRES_IN, expiresIn)
                .putString("token_type", tokenType)
                .putString("account_username", accountUsername)
                .commit();
    }

    public void logout() {
        ImgurApp.getSharedPreferences()
                .edit()
                .clear()
                .commit();
    }

}
