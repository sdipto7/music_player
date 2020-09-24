package com.example.musicplayer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.musicplayer.R;

import static com.example.musicplayer.controller.ControllerClass.*;
import static com.example.musicplayer.model.ModelClass.*;

public class MainActivity extends AppCompatActivity {

    protected Button playButton;
    protected SeekBar positionBar, volumeBar;
    protected TextView elapsedTime, remainingTime;
    protected MediaPlayer mediaPlayer;
    protected int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elapsedTime = (TextView) findViewById(R.id.elapsedTimeID);
        remainingTime = (TextView) findViewById(R.id.remainingTimeID);
        playButton = (Button) findViewById(R.id.playButtonID);
        volumeBar = (SeekBar) findViewById(R.id.volumeBarID);
        positionBar = (SeekBar) findViewById(R.id.positionBarID);

        mediaPlayer = MediaPlayer.create(this,R.raw.obosheshe);
        mediaPlayer.setLooping(true);
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(0.5f,0.5f);
        totalTime = getTime(mediaPlayer);

        positionBar.setMax(totalTime);
        //PositionBar position update
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b){
                            mediaPlayer.seekTo(i);
                            positionBar.setProgress(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );


        //VolumeBar update
        volumeBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b){
                        float volume = i/100f;
                        mediaPlayer.setVolume(volume,volume);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        //Updating positionBar and timeLabels
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(mediaPlayer != null){
                    try{
                        Message msg = new Message();
                        msg.what = mediaPlayer.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e){}
                }
            }
        }).start();

    }

    private Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            int currentPosition = msg.what;
            positionBar.setProgress(currentPosition);
            String elapsed = createTimeLabel(currentPosition);
            elapsedTime.setText(elapsed);

            String remaining = createTimeLabel(totalTime - currentPosition);
            remainingTime.setText("- " + remaining);
        }
    };

    public String createTimeLabel(int time){
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10){
            timeLabel += "0";
        }
        timeLabel += sec;
        return timeLabel;
    }

    public void playButtonClick(View view) {
        play(view, playButton, mediaPlayer);
    }

}