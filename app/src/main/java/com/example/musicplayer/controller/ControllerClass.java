package com.example.musicplayer.controller;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

import com.example.musicplayer.R;

public class ControllerClass{

    public static void play(View view, Button playButton, MediaPlayer mediaPlayer) {
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            playButton.setBackgroundResource(R.drawable.pausebuttonimage);
        } else {
            mediaPlayer.pause();
            playButton.setBackgroundResource(R.drawable.playbuttonimage);
        }
    }
    public static boolean playing(View view){
        return true;
    }
    public static boolean paused(View view) { return true; }

}
