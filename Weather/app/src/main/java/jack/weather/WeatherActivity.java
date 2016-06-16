package jack.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import jack.weather.util.HttpCallbackListener;
import jack.weather.util.HttpUtil;
import jack.weather.util.Utility;

public class WeatherActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    private static final int REFRESH_COMPLETE = 0X110;

    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout refresh_layout;

    @Bind(R.id.tv_city)
    TextView tv_city;

    @Bind(R.id.tv_release)
    TextView tv_release;

    @Bind(R.id.tv_now_weather)
    TextView tv_now_weather;

    @Bind(R.id.tv_today_temp)
    TextView tv_today_temp;

    @Bind(R.id.tv_now_temp)
    TextView tv_now_temp;

    @Bind(R.id.tv_aqi)
    TextView tv_aqi;

    @Bind(R.id.tv_quality)
    TextView tv_quality;

    @Bind(R.id.tv_today_temp_a)
    TextView tv_today_temp_a;
    @Bind(R.id.tv_today_temp_b)
    TextView tv_today_temp_b;

    @Bind(R.id.tv_tomorrow)
    TextView tv_tomorrow;
    @Bind(R.id.tv_tomorrow_temp_a)
    TextView tv_tomorrow_temp_a;
    @Bind(R.id.tv_tomorrow_temp_b)
    TextView tv_tomorrow_temp_b;

    @Bind(R.id.tv_thirdDay)
    TextView tv_thirdDay;
    @Bind(R.id.tv_thirdDay_temp_a)
    TextView tv_thirdDay_temp_a;
    @Bind(R.id.tv_thirdDay_temp_b)
    TextView tv_thirdDay_temp_b;

    @Bind(R.id.tv_fourthDay)
    TextView tv_fourthDay;
    @Bind(R.id.tv_fourthDay_temp_a)
    TextView tv_fourthDay_temp_a;
    @Bind(R.id.tv_fourthDay_temp_b)
    TextView tv_fourthDay_temp_b;

    @Bind(R.id.tv_fifthDay)
    TextView tv_fifthDay;
    @Bind(R.id.tv_fifthDay_temp_a)
    TextView tv_fifthDay_temp_a;
    @Bind(R.id.tv_fifthDay_temp_b)
    TextView tv_fifthDay_temp_b;

    @Bind(R.id.tv_sixthDay)
    TextView tv_sixthDay;
    @Bind(R.id.tv_sixthDay_temp_a)
    TextView tv_sixthDay_temp_a;
    @Bind(R.id.tv_sixthDay_temp_b)
    TextView tv_sixthDay_temp_b;

    @Bind(R.id.tv_seventhDay)
    TextView tv_seventhDay;
    @Bind(R.id.tv_seventhDay_temp_a)
    TextView tv_seventhDay_temp_a;
    @Bind(R.id.tv_seventhDay_temp_b)
    TextView tv_seventhDay_temp_b;

    @Bind(R.id.tv_a_cold_index)
    TextView tv_a_cold_index;

    @Bind(R.id.tv_air_conditioning_index)
    TextView tv_air_conditioning_index;

    @Bind(R.id.tv_wind)
    TextView tv_wind;

    @Bind(R.id.tv_uv_index)
    TextView tv_uv_index;

    @Bind(R.id.tv_dressing_index)
    TextView tv_dressing_index;

    @Bind(R.id.iv_now_weather)
    ImageView iv_now_weather;

    @Bind(R.id.iv_today_weather)
    ImageView iv_today_weather;

    @Bind(R.id.iv_tomorrow_weather)
    ImageView iv_tomorrow_weather;

    @Bind(R.id.iv_thirdDay_weather)
    ImageView iv_thirdDay_weather;

    @Bind(R.id.iv_fourthDay_weather)
    ImageView iv_fourthDay_weather;

    @Bind(R.id.iv_fifthDay_weather)
    ImageView iv_fifthDay_weather;

    @Bind(R.id.iv_sixthDay_weather)
    ImageView iv_sixthDay_weather;

    @Bind(R.id.iv_seventhDay_weather)
    ImageView iv_seventhDay_weather;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this);
                    String countyName = prefs.getString("city_name", "");
                    if (!TextUtils.isEmpty(countyName)) {
                        queryWeatherInfo(countyName);
                    }
                    refresh_layout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        ButterKnife.bind(this);

        refresh_layout.setOnRefreshListener(this);
        refresh_layout.setColorSchemeColors(R.color.refresh);

        TextView cilck = (TextView) findViewById(R.id.tv_city);
        cilck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherActivity.this, ChooseAreaActivity.class);
                intent.putExtra("from_weather_activity", true);
                startActivity(intent);
                finish();
            }
        });

        TextView cilck1 = (TextView) findViewById(R.id.tv_release);
        cilck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherActivity.this, ChooseAreaActivity.class);
                intent.putExtra("from_weather_activity", true);
                startActivity(intent);
                finish();
            }
        });

        String CountyName = getIntent().getStringExtra("county_name");
        if (!TextUtils.isEmpty(CountyName)) {
            queryWeatherInfo(CountyName);
        } else {
            showWeather();
        }

    }

    /**
     * 根据传入的地址去向服务器天气信息。
     */
    private void queryWeatherInfo(String countyName) {
        String address = HttpUtil.encodeUrl("http://op.juhe.cn/onebox/weather/query?cityname="
                + countyName + "&key=ff84fdc0ab98bb6a0dc4fd085054e1ec");
        Log.d("Main", "----------->10" + address);
        queryFromServer(address);
    }

    private void queryFromServer(String address) {
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                Log.d(getClass().getName(), response);
                Utility.handleWeatherResponse(WeatherActivity.this, response);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showWeather();
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_release.setText("同步失败");
                    }
                });
            }
        });
    }

    /**
     * 从SharedPreferences文件中读取存储的天气信息，并显示到界面上。
     */
    private void showWeather() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        /**
         * 判断当前时间是否大于下午6点
         */
        if (Calendar.getInstance().getTime().getHours() - 18 > -12) {
            Log.d("-------->|", (Calendar.getInstance().getTime().getHours()) + "");
            int now = getResources().getIdentifier("d" + prefs.getString("img", ""), "drawable", "jack.weather");
            Log.d("-------->", now + "");
            Drawable img = getResources().getDrawable(now);
            iv_now_weather.setImageDrawable(img);

            int today = getResources().getIdentifier("d" + prefs.getString("img1_1", ""), "drawable", "jack.weather");
            Drawable img1_1 = getResources().getDrawable(today);
            iv_today_weather.setImageDrawable(img1_1);

            int tomorrow = getResources().getIdentifier("d" + prefs.getString("img2_1", ""), "drawable", "jack.weather");
            Log.d("-------->", tomorrow + "");
            Drawable img2_1 = getResources().getDrawable(tomorrow);
            iv_tomorrow_weather.setImageDrawable(img2_1);

            int thirdDay = getResources().getIdentifier("d" + prefs.getString("img3_1", ""), "drawable", "jack.weather");
            Log.d("-------->", thirdDay + "");
            Drawable img3_1 = getResources().getDrawable(thirdDay);
            iv_thirdDay_weather.setImageDrawable(img3_1);

            int fourthDay = getResources().getIdentifier("d" + prefs.getString("img4_1", ""), "drawable", "jack.weather");
            Log.d("-------->", fourthDay + "");
            Drawable img4_1 = getResources().getDrawable(fourthDay);
            iv_fourthDay_weather.setImageDrawable(img4_1);

            int fifthDay = getResources().getIdentifier("d" + prefs.getString("img5_1", ""), "drawable", "jack.weather");
            Log.d("-------->", fifthDay + "");
            Drawable img5_1 = getResources().getDrawable(fifthDay);
            iv_fifthDay_weather.setImageDrawable(img5_1);

            int sixthDay = getResources().getIdentifier("d" + prefs.getString("img6_1", ""), "drawable", "jack.weather");
            Log.d("-------->", sixthDay + "");
            Drawable img6_1 = getResources().getDrawable(sixthDay);
            iv_sixthDay_weather.setImageDrawable(img6_1);

            int seventhDay = getResources().getIdentifier("d" + prefs.getString("img7_1", ""), "drawable", "jack.weather");
            Log.d("-------->", seventhDay + "");
            Drawable img7_1 = getResources().getDrawable(seventhDay);
            iv_seventhDay_weather.setImageDrawable(img7_1);
        } else {
            int now = getResources().getIdentifier("n" + prefs.getString("img", ""), "drawable", "jack.weather");
            Log.d("-------->", now + "");
            Drawable img = getResources().getDrawable(now);
            iv_now_weather.setImageDrawable(img);

            int today = getResources().getIdentifier("n" + prefs.getString("img1_2", ""), "drawable", "jack.weather");
            Drawable img1_1 = getResources().getDrawable(today);
            iv_today_weather.setImageDrawable(img1_1);

            int tomorrow = getResources().getIdentifier("n" + prefs.getString("img2_2", ""), "drawable", "jack.weather");
            Log.d("-------->", tomorrow + "");
            Drawable img2_1 = getResources().getDrawable(tomorrow);
            iv_tomorrow_weather.setImageDrawable(img2_1);

            int thirdDay = getResources().getIdentifier("n" + prefs.getString("img3_2", ""), "drawable", "jack.weather");
            Log.d("-------->", thirdDay + "");
            Drawable img3_1 = getResources().getDrawable(thirdDay);
            iv_thirdDay_weather.setImageDrawable(img3_1);

            int fourthDay = getResources().getIdentifier("n" + prefs.getString("img4_2", ""), "drawable", "jack.weather");
            Log.d("-------->", fourthDay + "");
            Drawable img4_1 = getResources().getDrawable(fourthDay);
            iv_fourthDay_weather.setImageDrawable(img4_1);

            int fifthDay = getResources().getIdentifier("n" + prefs.getString("img5_2", ""), "drawable", "jack.weather");
            Log.d("-------->", fifthDay + "");
            Drawable img5_1 = getResources().getDrawable(fifthDay);
            iv_fifthDay_weather.setImageDrawable(img5_1);

            int sixthDay = getResources().getIdentifier("n" + prefs.getString("img6_2", ""), "drawable", "jack.weather");
            Log.d("-------->", sixthDay + "");
            Drawable img6_1 = getResources().getDrawable(sixthDay);
            iv_sixthDay_weather.setImageDrawable(img6_1);

            int seventhDay = getResources().getIdentifier("n" + prefs.getString("img7_2", ""), "drawable", "jack.weather");
            Log.d("-------->", seventhDay + "");
            Drawable img7_1 = getResources().getDrawable(seventhDay);
            iv_seventhDay_weather.setImageDrawable(img7_1);
        }
        tv_city.setText(prefs.getString("city_name", ""));
        tv_release.setText(prefs.getString("time", "") + "发布");
        tv_now_weather.setText(prefs.getString("info", ""));

        tv_today_temp.setText("↑ " + prefs.getString("week_temp_a", "") + "°" + " ↓" + prefs.getString("week_temp_b", "") + "°");
        tv_now_temp.setText(prefs.getString("temperature", "") + "°");

        tv_aqi.setText(prefs.getString("aqi", ""));
        tv_quality.setText(prefs.getString("quality", ""));

        tv_today_temp_a.setText(prefs.getString("week_temp_a", "") + "°");
        tv_today_temp_b.setText(prefs.getString("week_temp_b", "") + "°");

        tv_tomorrow.setText("星期" + prefs.getString("week1", ""));
        tv_tomorrow_temp_a.setText(prefs.getString("week1_temp_a", "") + "°");
        tv_tomorrow_temp_b.setText(prefs.getString("week1_temp_b", "") + "°");

        tv_thirdDay.setText("星期" + prefs.getString("week2", ""));
        tv_thirdDay_temp_a.setText(prefs.getString("week2_temp_a", "") + "°");
        tv_thirdDay_temp_b.setText(prefs.getString("week2_temp_b", "") + "°");

        tv_fourthDay.setText("星期" + prefs.getString("week3", ""));
        tv_fourthDay_temp_a.setText(prefs.getString("week3_temp_a", "") + "°");
        tv_fourthDay_temp_b.setText(prefs.getString("week3_temp_b", "") + "°");

        tv_fifthDay.setText("星期" + prefs.getString("week4", ""));
        tv_fifthDay_temp_a.setText(prefs.getString("week4_temp_a", "") + "°");
        tv_fifthDay_temp_b.setText(prefs.getString("week4_temp_b", "") + "°");

        tv_sixthDay.setText("星期" + prefs.getString("week5", ""));
        tv_sixthDay_temp_a.setText(prefs.getString("week5_temp_a", "") + "°");
        tv_sixthDay_temp_b.setText(prefs.getString("week5_temp_b", "") + "°");

        tv_seventhDay.setText("星期" + prefs.getString("week6", ""));
        tv_seventhDay_temp_a.setText(prefs.getString("week6_temp_a", "") + "°");
        tv_seventhDay_temp_b.setText(prefs.getString("week6_temp_b", "") + "°");

        tv_a_cold_index.setText(prefs.getString("tv_a_cold_index", ""));
        tv_air_conditioning_index.setText(prefs.getString("tv_air_conditioning_index", ""));
        tv_wind.setText(prefs.getString("tv_wind", ""));
        tv_uv_index.setText(prefs.getString("tv_uv_index", ""));
        tv_dressing_index.setText(prefs.getString("tv_dressing_index", ""));


    }

    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(REFRESH_COMPLETE,3000);
    }

}
