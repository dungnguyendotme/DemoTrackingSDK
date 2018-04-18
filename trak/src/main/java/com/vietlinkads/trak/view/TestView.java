package com.vietlinkads.trak.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.vietlinkads.trak.R;

/**
 * Todo
 * <p>
 * Created by Administrator on 18/04/2018.
 */
public class TestView extends LinearLayout {

    public TestView(Context context) {
        super(context);
        initialize(context);
    }

    private void initialize(Context context) {
        inflate(context, R.layout.test_view, this);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

}