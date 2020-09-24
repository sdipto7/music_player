package com.example.musicplayer.controller;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.musicplayer.R;
import com.example.musicplayer.model.ModelClass;
import com.example.musicplayer.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerClassTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;
    public ControllerClass controllerClass;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainTestRule.getActivity();
        controllerClass = new ControllerClass();
    }

    @Test
    public void testPlay() throws Exception{
        View view = mainActivity.findViewById(R.id.positionBarID);
        boolean result = controllerClass.playing(view);
        assertEquals(true,result);
    }

    @Test
    public void testPaused() throws Exception{
        View view = mainActivity.findViewById(R.id.positionBarID);
        boolean result = controllerClass.paused(view);
        assertEquals(true,result);
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
        controllerClass = null;
    }
}