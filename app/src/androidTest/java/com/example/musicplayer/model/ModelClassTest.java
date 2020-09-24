package com.example.musicplayer.model;

import android.view.View;
import android.widget.TextView;

import androidx.test.rule.ActivityTestRule;

import com.example.musicplayer.R;
import com.example.musicplayer.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelClassTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;
    public ModelClass modelClass;

    @Before
    public void setUp() throws Exception {
        modelClass = new ModelClass();
        mainActivity = mainTestRule.getActivity();
    }

    @Test
    public void testSetMusicName() throws Exception{
        View view = mainActivity.findViewById(R.id.musicNameID);
        boolean result = modelClass.setMusicName((TextView) view);
        assertNotEquals(true,result);
    }

    @After
    public void tearDown() throws Exception {
        modelClass = null;
        mainActivity = null;
    }
}