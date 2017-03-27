package com.example.nikola.assignmentprojectverison;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;

/**
 * Created by Nikola on 3/24/2017.
 */
public class MainActivity extends AppCompatActivity implements CustomVideoView.EventListener {


    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CustomVideoView videoView = (CustomVideoView) findViewById(R.id.video);
        videoView.setListener(this);
        final String VIDEO_PATH = "android.resource://com.example.nikola.assignmentprojectverison/";
        final int resource = R.raw.video;
        final String URI = VIDEO_PATH + resource;
        final Uri uri = Uri.parse(URI);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    public native String onPauseFromJNI();

    public native String onStartFromJNI();


    @Override
    public void onStartEvent() {
        showToast(onStartFromJNI());
    }

    @Override
    public void onPauseEvent() {
        showToast(onPauseFromJNI());
    }

    @Override
    public void onSeekEvent(int msec) {
        Toast.makeText(this, "skipped " + msec/1000 + " sec", Toast.LENGTH_SHORT).show();
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
