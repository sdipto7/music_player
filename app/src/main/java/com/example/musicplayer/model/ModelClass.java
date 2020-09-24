package com.example.musicplayer.model;

import android.media.MediaPlayer;
import android.widget.TextView;

import com.example.musicplayer.R;


public class ModelClass {
    public static int getTime(MediaPlayer mediaPlayer){
        return mediaPlayer.getDuration();
    }
    public static boolean setMusicName(TextView musicName){
        musicName.setText(R.string.song_name);
        return true;
    }
}
