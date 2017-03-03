package com.romerock.modules.android.admob;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.img_logo_romerock)
    ImageView img_logo_romerock;
    @BindView(R.id.follow_twitter)
    ImageView followTwitter;
    @BindView(R.id.follow_gitHub)
    ImageView followGitHub;
    @BindView(R.id.follow_facebook)
    ImageView followFacebook;

    @BindView(R.id.btn_detect)
    Button btnDetect;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.admob_simple_banner)
    AdView admobSimpleBanner;
    private InterstitialAd mInterstitialAd;
    private Typeface font;
    private String android_id, deviceId;
    private  AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, 0, 0);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        WebView view = new WebView(this);
        view.setVerticalScrollBarEnabled(false);
        view.setBackgroundColor(getResources().getColor(R.color.drawable));
        ((RelativeLayout) findViewById(R.id.relContent)).addView(view);
        view.loadData(getString(R.string.thank_you), "text/html; charset=utf-8", "utf-8");
        font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        deviceId = TestDevice(android_id).toUpperCase();
        admobSimpleBanner.loadAd(new AdRequest.Builder().build());



    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(deviceId)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    @OnClick({R.id.img_logo_romerock, R.id.follow_twitter, R.id.follow_gitHub, R.id.follow_facebook, R.id.btn_detect})
    public void onClick(View view) {
        String url = "";
        switch (view.getId()) {
            case R.id.img_logo_romerock:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.romerock_page))));
                break;
            case R.id.follow_facebook:
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.follow_us_facebook_profile)));
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.follow_us_facebook))));
                }
                break;
            case R.id.follow_gitHub:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.follow_us_git_hub))));
                break;
            case R.id.follow_twitter:
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.follow_us_twitter_profile)));
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.follow_us_twitter))));
                }
                break;
            case R.id.btn_detect:
                mInterstitialAd = new InterstitialAd(MainActivity.this);
                mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
                adRequest = new AdRequest.Builder()
                        .addTestDevice(deviceId)
                        .build();

                mInterstitialAd.loadAd(adRequest);
                mInterstitialAd.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        displayInterstitial();
                    }
                });


                break;

        }
    }


    private void displayInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    public static final String TestDevice(final String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
        }
        return "";
    }
}
