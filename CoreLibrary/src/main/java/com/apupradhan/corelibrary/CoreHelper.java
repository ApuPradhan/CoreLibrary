package com.apupradhan.corelibrary;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CoreHelper {

    /*pass parameter like (MainActivity.this, "source.json")*/
    public static JSONObject readDummyResponse(Context ctx, String assetsFileName) {
        InputStream inputStream = null;
        try {
            inputStream = ctx.getAssets().open(assetsFileName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        JSONObject jsonObject = null;
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            StringBuffer buffer = new StringBuffer();
            String statement;
            try {
                while ((statement = reader.readLine()) != null) {
                    if (statement.trim().length() > 0) {
                        buffer.append(statement);
                    }
                }
            } catch (IOException e1) { // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (buffer.length() > 0) {
                try {
                    jsonObject = new JSONObject(buffer.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return (JSONObject) jsonObject;
    }
}
