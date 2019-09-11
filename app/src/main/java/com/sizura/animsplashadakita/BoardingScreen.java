package com.sizura.animsplashadakita;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BoardingScreen extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;


    private TextView[] ndots;
    private SliderAdapter sliderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding_screen);

        viewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.ll);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position) {

        ndots = new TextView[2];
        linearLayout.removeAllViews();

        for (int i = 0; i < ndots.length; i++) {

            ndots[i] = new TextView(this);
            ndots[i].setText(Html.fromHtml("&#8226;"));
            ndots[i].setTextSize(30);
            ndots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            linearLayout.addView(ndots[i]);
        }
        if (ndots.length > 0) {
            ndots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
