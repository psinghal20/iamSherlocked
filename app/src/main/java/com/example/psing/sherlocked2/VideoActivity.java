package com.example.psing.sherlocked2;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    String VideoURL;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private YouTubePlayerView youTubeView;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        // Initializing video player with developer key
        youTubeView.initialize(config.DEVELOPER_KEY, this);
        switch (SeasonActivity.Item) {
            case 0: {
                switch (EpisodeActivity.pos) {
                    case 0: {
                        VideoURL = "Nj7ZSUkTTVI";
                        break;
                    }
                    case 1: {
                        VideoURL = "y_GGbRkqqFg";
                        break;
                    }
                    case 2: {
                        VideoURL = "AviDWKhmVdU";
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

    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.loadVideo(VideoURL);

            // Hiding player controls
            player.setPlayerStyle(PlayerStyle.CHROMELESS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(config.DEVELOPER_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

}
