package jack.weather.util;

/**
 * Created by 黄文杰 on 2016/6/8.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
