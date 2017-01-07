package com.example.psing.sherlocked2;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.common.api.GoogleApiClient;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    String VideoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView) findViewById(R.id.videoView);
        switch (SeasonActivity.Item) {
            case 0: {
                switch (EpisodeActivity.pos) {
                    case 0: {
                        VideoURL = "https://youtu.be/Nj7ZSUkTTVI";
                        break;
                    }
                    case 1: {
                        VideoURL = "https://youtu.be/y_GGbRkqqFg";
                        break;
                    }
                    case 2: {
                        VideoURL = "https://youtu.be/AviDWKhmVdU";
                        break;
                    }
                }
                break;
            }
            case 1: {
                switch (EpisodeActivity.pos) {
                    case 0: {
                        VideoURL = "https://youtu.be/E2MXppyXsUY";
                        break;
                    }
                    case 1: {
                        VideoURL = "https://youtu.be/bm78r2innnE";
                        break;
                    }
                    case 2: {
                        VideoURL = "https://youtu.be/eKRCt3yCXEA";
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (EpisodeActivity.pos) {
                    case 0: {
                        VideoURL = "https://youtu.be/O7cKIjNIPoY";
                        break;
                    }
                    case 1: {
                        VideoURL = "https://youtu.be/qtGf6RvjWE4";
                        break;
                    }
                    case 2: {
                        VideoURL = "https://youtu.be/xhjIsu7n6bI";
                        break;
                    }
                }
                break;
            }
        }
        MediaController mediacontroller = new MediaController(
                VideoActivity.this);
        mediacontroller.setAnchorView(videoView);
        // Get the URL from String VideoURL
        Uri video = Uri.parse(VideoURL);
        videoView.setMediaController(mediacontroller);
        videoView.setVideoURI(video);
        videoView.requestFocus();
        videoView.start();

    }
}
