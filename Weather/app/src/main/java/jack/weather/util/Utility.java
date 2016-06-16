package jack.weather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Set;

import jack.weather.bean.City;
import jack.weather.bean.County;
import jack.weather.bean.Province;
import jack.weather.bean.Weather;
import jack.weather.db.WeatherDB;


/**
 * Created by 黄文杰 on 2016/6/8.
 */
public class Utility {


    /**
     * 解析和处理服务器返回的省级数据
     */
    public synchronized static boolean handleProvinceResponse(WeatherDB weatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    weatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public synchronized static boolean handleCitiesResponse(WeatherDB weatherDB, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    weatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountiesResponse(WeatherDB weatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    weatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析服务器返回的JSON数据，并将解析出的数据存储到本地。
     */
    public static Weather handleWeatherResponse(Context context, String response) {
        Weather weather = JSON.parseObject(response, Weather.class);
        if (weather != null) {
            saveWeatherInfo(context, weather);
            return weather;
        }

      /*  Log.d("Main", "--------> cityName:" + cityName);
        Log.d("Main", "--------> cityCode:" + cityCode);
        Log.d("Main", "--------> temperature:" + temperature);
        Log.d("Main", "--------> info:" + info);
        Log.d("Main", "--------> time:" + time);*/
        return null;
    }

    private static void saveWeatherInfo(Context context, Weather weather) {

        String cityName;
        String time;
        String temperature;
        String info;
        String aqi;
        String quality;
        String week;
        String week1;
        String week2;
        String week3;
        String week4;
        String week5;
        String week6;
        String week_temp_a;
        String week1_temp_a;
        String week2_temp_a;
        String week3_temp_a;
        String week4_temp_a;
        String week5_temp_a;
        String week6_temp_a;
        String week_temp_b;
        String week1_temp_b;
        String week2_temp_b;
        String week3_temp_b;
        String week4_temp_b;
        String week5_temp_b;
        String week6_temp_b;
        String tv_a_cold_index;
        String tv_air_conditioning_index;
        String tv_wind;
        String tv_uv_index;
        String tv_dressing_index;
        String img;
        String img1_1;
        String img2_1;
        String img3_1;
        String img4_1;
        String img5_1;
        String img6_1;
        String img7_1;

        String img1_2;
        String img2_2;
        String img3_2;
        String img4_2;
        String img5_2;
        String img6_2;
        String img7_2;

        cityName = weather.getResult().getData().getRealtime().getCity_name();
        time = weather.getResult().getData().getRealtime().getTime();
        temperature = weather.getResult().getData().getRealtime().getWeather().getTemperature();
        info = weather.getResult().getData().getRealtime().getWeather().getInfo();
        aqi = weather.getResult().getData().getPm25().getPm25().getPm25();
        quality = weather.getResult().getData().getPm25().getPm25().getQuality();

        week = weather.getResult().getData().getWeather().get(0).getWeek();
        week1 = weather.getResult().getData().getWeather().get(1).getWeek();
        week2 = weather.getResult().getData().getWeather().get(2).getWeek();
        week3 = weather.getResult().getData().getWeather().get(3).getWeek();
        week4 = weather.getResult().getData().getWeather().get(4).getWeek();
        week5 = weather.getResult().getData().getWeather().get(5).getWeek();
        week6 = weather.getResult().getData().getWeather().get(6).getWeek();

        week_temp_a = weather.getResult().getData().getWeather().get(0).getInfo().getDay().get(2);
        week1_temp_a = weather.getResult().getData().getWeather().get(1).getInfo().getDay().get(2);
        week2_temp_a = weather.getResult().getData().getWeather().get(2).getInfo().getDay().get(2);
        week3_temp_a = weather.getResult().getData().getWeather().get(3).getInfo().getDay().get(2);
        week4_temp_a = weather.getResult().getData().getWeather().get(4).getInfo().getDay().get(2);
        week5_temp_a = weather.getResult().getData().getWeather().get(5).getInfo().getDay().get(2);
        week6_temp_a = weather.getResult().getData().getWeather().get(6).getInfo().getDay().get(2);

        week_temp_b = weather.getResult().getData().getWeather().get(0).getInfo().getNight().get(2);
        week1_temp_b = weather.getResult().getData().getWeather().get(1).getInfo().getNight().get(2);
        week2_temp_b = weather.getResult().getData().getWeather().get(2).getInfo().getNight().get(2);
        week3_temp_b = weather.getResult().getData().getWeather().get(3).getInfo().getNight().get(2);
        week4_temp_b = weather.getResult().getData().getWeather().get(4).getInfo().getNight().get(2);
        week5_temp_b = weather.getResult().getData().getWeather().get(5).getInfo().getNight().get(2);
        week6_temp_b = weather.getResult().getData().getWeather().get(6).getInfo().getNight().get(2);

        tv_a_cold_index = weather.getResult().getData().getLife().getInfo().getGanmao().get(0);
        tv_air_conditioning_index = weather.getResult().getData().getLife().getInfo().getKongtiao().get(0);
        tv_wind = weather.getResult().getData().getRealtime().getWind().getDirect() + " "
                + weather.getResult().getData().getRealtime().getWind().getPower();
        tv_uv_index = weather.getResult().getData().getLife().getInfo().getZiwaixian().get(0);
        tv_dressing_index = weather.getResult().getData().getLife().getInfo().getChuanyi().get(0);

        img = weather.getResult().getData().getRealtime().getWeather().getImg();
        img1_1 = weather.getResult().getData().getWeather().get(0).getInfo().getDay().get(0);
        img2_1 = weather.getResult().getData().getWeather().get(1).getInfo().getDay().get(0);
        img3_1 = weather.getResult().getData().getWeather().get(2).getInfo().getDay().get(0);
        img4_1 = weather.getResult().getData().getWeather().get(3).getInfo().getDay().get(0);
        img5_1 = weather.getResult().getData().getWeather().get(4).getInfo().getDay().get(0);
        img6_1 = weather.getResult().getData().getWeather().get(5).getInfo().getDay().get(0);
        img7_1 = weather.getResult().getData().getWeather().get(6).getInfo().getDay().get(0);

        img1_2 = weather.getResult().getData().getWeather().get(0).getInfo().getNight().get(0);
        img2_2 = weather.getResult().getData().getWeather().get(1).getInfo().getNight().get(0);
        img3_2 = weather.getResult().getData().getWeather().get(2).getInfo().getNight().get(0);
        img4_2 = weather.getResult().getData().getWeather().get(3).getInfo().getNight().get(0);
        img5_2 = weather.getResult().getData().getWeather().get(4).getInfo().getNight().get(0);
        img6_2 = weather.getResult().getData().getWeather().get(5).getInfo().getNight().get(0);
        img7_2 = weather.getResult().getData().getWeather().get(6).getInfo().getNight().get(0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean("city_selected", true);
        editor.putString("city_name", cityName);
        editor.putString("temperature", temperature);
        editor.putString("info", info);
        editor.putString("time", time);
        editor.putString("aqi", aqi);

        editor.putString("week", week);
        editor.putString("week1", week1);
        editor.putString("week2", week2);
        editor.putString("week3", week3);
        editor.putString("week4", week4);
        editor.putString("week5", week5);
        editor.putString("week6", week6);

        editor.putString("week_temp_a", week_temp_a);
        editor.putString("week1_temp_a", week1_temp_a);
        editor.putString("week2_temp_a", week2_temp_a);
        editor.putString("week3_temp_a", week3_temp_a);
        editor.putString("week4_temp_a", week4_temp_a);
        editor.putString("week5_temp_a", week5_temp_a);
        editor.putString("week6_temp_a", week6_temp_a);

        editor.putString("week_temp_b", week_temp_b);
        editor.putString("week1_temp_b", week1_temp_b);
        editor.putString("week2_temp_b", week2_temp_b);
        editor.putString("week3_temp_b", week3_temp_b);
        editor.putString("week4_temp_b", week4_temp_b);
        editor.putString("week5_temp_b", week5_temp_b);
        editor.putString("week6_temp_b", week6_temp_b);

        editor.putString("tv_a_cold_index", tv_a_cold_index);
        editor.putString("tv_air_conditioning_index", tv_air_conditioning_index);
        editor.putString("tv_wind", tv_wind);
        editor.putString("tv_uv_index", tv_uv_index);
        editor.putString("tv_dressing_index", tv_dressing_index);

        editor.putString("img", img);
        editor.putString("img1_1", img1_1);
        editor.putString("img2_1", img2_1);
        editor.putString("img3_1", img3_1);
        editor.putString("img4_1", img4_1);
        editor.putString("img5_1", img5_1);
        editor.putString("img6_1", img6_1);
        editor.putString("img7_1", img7_1);

        editor.putString("img1_2", img1_2);
        editor.putString("img2_2", img2_2);
        editor.putString("img3_2", img3_2);
        editor.putString("img4_2", img4_2);
        editor.putString("img5_2", img5_2);
        editor.putString("img6_2", img6_2);
        editor.putString("img7_2", img7_2);

        editor.putString("quality", quality);
        editor.putString("current_date", sdf.format(new Date()));
        editor.commit();

    }
}
