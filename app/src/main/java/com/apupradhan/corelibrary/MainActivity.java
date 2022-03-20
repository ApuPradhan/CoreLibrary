package com.apupradhan.corelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Test.NamasteWorld(this);

        JSONObject jOBJ = CoreHelper.readDummyResponse(this, "source.json");
        Log.d("tag", String.valueOf(jOBJ));
    }
}