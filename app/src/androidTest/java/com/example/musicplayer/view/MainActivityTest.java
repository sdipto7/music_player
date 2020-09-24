package com.example.musicplayer.view;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.musicplayer.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainTestRule.getActivity();

    }

    @Test
    public void testMusicName() throws Exception{
        View view = mainActivity.findViewById(R.id.musicNameID);
        assertNotNull(view);
    }

    @Test
    public void testCreateTimeLabel(){
        String timeLabel = mainActivity.createTimeLabel(1000);
        assertNotEquals("01:00",timeLabel);
    }

    @Test
    public void testVolumeBar() throws Exception{
        View view = mainActivity.findViewById(R.id.volumeBarID);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}