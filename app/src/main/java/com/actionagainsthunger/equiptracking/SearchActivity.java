package com.actionagainsthunger.equiptracking;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SearchActivity extends Activity  {

    private final String TAG = "EquipTracking";
    private final String APP_KEY;
    private final String APP_SECRET;

    // You don't need to change these, leave them alone.
    private final String ACCOUNT_PREFS_NAME = "prefs";
    private final String ACCESS_KEY_NAME = "ACCESS_KEY";
    private final String ACCESS_SECRET_NAME = "ACCESS_SECRET";

    private DropboxAPI<AndroidAuthSession> mApi;

    private Button logoutButton;
    private TextView notConnectedText;

    public SearchActivity(){
        Properties prop = new Properties();
        InputStream input = null;
        String appKey = "";
        String appSecret = "";

        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            appKey = prop.getProperty("appkey");
            appSecret = prop.getProperty("appsecret");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        APP_KEY = appKey;
        APP_SECRET = appSecret;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidAuthSession session = buildSession();
        mApi = new DropboxAPI<AndroidAuthSession>(session);
        setContentView(R.layout.activity_search);

        logoutButton = (Button)findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                logOut();
            }
        });
        logoutButton.setVisibility(isLoggedIn() ? View.VISIBLE : View.GONE);

        notConnectedText = (TextView)findViewById(R.id.not_connected_text);
        notConnectedText.setVisibility(!isLoggedIn() ? View.VISIBLE : View.GONE);

        if (!isLoggedIn())
            mApi.getSession().startOAuth2Authentication(SearchActivity.this);
        else
            loadAuth(session);
    }

    private boolean isLoggedIn() {
        return !getSharedPreferences(ACCOUNT_PREFS_NAME, 0).getString(ACCESS_SECRET_NAME, "").isEmpty();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AndroidAuthSession session = mApi.getSession();

        if (session.authenticationSuccessful()) {
            try {
                session.finishAuthentication();
                storeAuth(session);
                logoutButton.setVisibility(View.VISIBLE);
                notConnectedText.setVisibility(View.GONE);
            } catch (IllegalStateException e) {
                showToast("Couldn't authenticate with Dropbox:" + e.getLocalizedMessage());
                Log.i(TAG, "Error authenticating", e);
            }
        }
    }

    private void showToast(String msg) {
        Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        error.show();
    }

    private AndroidAuthSession buildSession() {
        AppKeyPair appKeyPair = new AppKeyPair(APP_KEY, APP_SECRET);

        AndroidAuthSession session = new AndroidAuthSession(appKeyPair);
        loadAuth(session);
        return session;
    }

    /**
     * Shows keeping the access keys returned from Trusted Authenticator in a local
     * store, rather than storing user name & password, and re-authenticating each
     * time (which is not to be done, ever).
     */
    private void storeAuth(AndroidAuthSession session) {
        String oauth2AccessToken = session.getOAuth2AccessToken();
        if (oauth2AccessToken != null) {
            SharedPreferences sharedPreferences = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
            SharedPreferences.Editor sharedPreferencesEdit = sharedPreferences.edit();
            sharedPreferencesEdit.putString(ACCESS_KEY_NAME, "oauth2:");
            sharedPreferencesEdit.putString(ACCESS_SECRET_NAME, oauth2AccessToken);
            sharedPreferencesEdit.commit();
            return;
        }
    }

    /**
     * Shows keeping the access keys returned from Trusted Authenticator in a local
     * store, rather than storing user name & password, and re-authenticating each
     * time (which is not to be done, ever).
     */
    private void loadAuth(AndroidAuthSession session) {
        SharedPreferences sharedPreferences = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        String key = sharedPreferences.getString(ACCESS_KEY_NAME, null);
        String secret = sharedPreferences.getString(ACCESS_SECRET_NAME, null);
        if (key == null || secret == null || key.length() == 0 || secret.length() == 0) return;

        if (key.equals("oauth2:")) {
            // If the key is set to "oauth2:", then we can assume the token is for OAuth 2.
            session.setOAuth2AccessToken(secret);
        }
    }

    private void logOut() {
        mApi.getSession().unlink();
        SharedPreferences sharedPreferences = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        SharedPreferences.Editor sharedPreferencesEdit = sharedPreferences.edit();
        sharedPreferencesEdit.clear();
        sharedPreferencesEdit.commit();
        logoutButton.setVisibility(View.GONE);
        notConnectedText.setVisibility(View.VISIBLE);
    }
}

