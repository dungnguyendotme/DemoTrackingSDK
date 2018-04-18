package com.vietlinkads.demotrackingsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.vietlinkads.trak.view.TestView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private MixpanelAPI mixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String projectToken = "af95e72456cb848d3305e295b02b1a37"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
        mixpanel = MixpanelAPI.getInstance(this, projectToken);

        mixpanel.track("open app");


        Button buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mixpanel.track("click button A");
            }
        });


        Button buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("params0", "0");
                    jsonObject.put("params1", "1");
                } catch (JSONException e) {
                    e.printStackTrace();
                    jsonObject = null;
                }

                if (jsonObject != null)
                    mixpanel.track("click button B");
            }
        });

        LinearLayout llDemo = (LinearLayout) findViewById(R.id.llDemo);

        View v = new TestView(this);
        llDemo.addView(v);

    }

    @Override
    protected void onDestroy() {
        mixpanel.flush();
        super.onDestroy();
    }
}
