package com.example.pipeline.superensino3;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.MediaController;
import android.widget.VideoView;

public class TelaVideoPont extends AppCompatActivity {
    VideoView videoad;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_video_pont);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        videoad = (VideoView)findViewById(R.id.videoad);
        mediaController = new MediaController(this);

       String videopath2 = "android.resource://com.example.pipeline.superensino3/raw/virgula";
        Uri uri1 = Uri.parse(videopath2);
        videoad.setVideoURI(uri1);
        videoad.setMediaController(mediaController);
        videoad.requestFocus();
        mediaController.setAnchorView(videoad);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) videoad.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.heightPixels;
        params.leftMargin = 0;
        videoad.setLayoutParams(params);
        videoad.start();
    }
}
