package jack.weather.bean;

import java.util.List;

public class Weather {


    /**
     * reason : 成功
     * result : {"data":{"realtime":{"wind":{"windspeed":"25.0","direct":"南风","power":"3级","offset":null},"time":"15:00:00","weather":{"humidity":"77","img":"7","info":"小雨","temperature":"30"},"dataUptime":1465977747,"date":"2016-06-15","city_code":"101280302","city_name":"博罗","week":3,"moon":"五月十一"},"life":{"date":"2016-6-15","info":{"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]}},"weather":[{"date":"2016-06-15","info":{"night":["8","中雨","26","无持续风向","微风","19:10"],"day":["8","中雨","31","无持续风向","微风","05:37"]},"week":"三","nongli":"五月十一"},{"date":"2016-06-16","info":{"dawn":["8","中雨","26","无持续风向","微风","19:10"],"night":["9","大雨","24","无持续风向","微风","19:10"],"day":["9","大雨","29","无持续风向","微风","05:37"]},"week":"四","nongli":"五月十二"},{"date":"2016-06-17","info":{"dawn":["9","大雨","24","无持续风向","微风","19:10"],"night":["3","阵雨","25","无持续风向","微风","19:10"],"day":["9","大雨","30","无持续风向","微风","05:37"]},"week":"五","nongli":"五月十三"},{"date":"2016-06-18","info":{"dawn":["3","阵雨","25","无持续风向","微风","19:10"],"night":["1","多云","26","无持续风向","微风","19:11"],"day":["4","雷阵雨","32","无持续风向","微风","05:37"]},"week":"六","nongli":"五月十四"},{"date":"2016-06-19","info":{"dawn":["1","多云","26","无持续风向","微风","19:11"],"night":["1","多云","26","无持续风向","微风","19:11"],"day":["1","多云","34","无持续风向","微风","05:38"]},"week":"日","nongli":"五月十五"},{"date":"2016-06-20","info":{"night":["4","雷阵雨","26","东南风","微风","19:30"],"day":["4","雷阵雨","32","东南风","微风","07:30"]},"week":"一","nongli":"五月十六"},{"date":"2016-06-21","info":{"night":["4","雷阵雨","26","东南风","微风","19:30"],"day":["4","雷阵雨","32","东南风","微风","07:30"]},"week":"二","nongli":"五月十七"}],"pm25":{"key":"","show_desc":0,"pm25":{"curPm":"67","pm25":"15","pm10":"67","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年06月15日16时","cityName":"博罗"},"date":null,"isForeign":0}}
     * error_code : 0
     */

    private String reason;
    /**
     * data : {"realtime":{"wind":{"windspeed":"25.0","direct":"南风","power":"3级","offset":null},"time":"15:00:00","weather":{"humidity":"77","img":"7","info":"小雨","temperature":"30"},"dataUptime":1465977747,"date":"2016-06-15","city_code":"101280302","city_name":"博罗","week":3,"moon":"五月十一"},"life":{"date":"2016-6-15","info":{"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]}},"weather":[{"date":"2016-06-15","info":{"night":["8","中雨","26","无持续风向","微风","19:10"],"day":["8","中雨","31","无持续风向","微风","05:37"]},"week":"三","nongli":"五月十一"},{"date":"2016-06-16","info":{"dawn":["8","中雨","26","无持续风向","微风","19:10"],"night":["9","大雨","24","无持续风向","微风","19:10"],"day":["9","大雨","29","无持续风向","微风","05:37"]},"week":"四","nongli":"五月十二"},{"date":"2016-06-17","info":{"dawn":["9","大雨","24","无持续风向","微风","19:10"],"night":["3","阵雨","25","无持续风向","微风","19:10"],"day":["9","大雨","30","无持续风向","微风","05:37"]},"week":"五","nongli":"五月十三"},{"date":"2016-06-18","info":{"dawn":["3","阵雨","25","无持续风向","微风","19:10"],"night":["1","多云","26","无持续风向","微风","19:11"],"day":["4","雷阵雨","32","无持续风向","微风","05:37"]},"week":"六","nongli":"五月十四"},{"date":"2016-06-19","info":{"dawn":["1","多云","26","无持续风向","微风","19:11"],"night":["1","多云","26","无持续风向","微风","19:11"],"day":["1","多云","34","无持续风向","微风","05:38"]},"week":"日","nongli":"五月十五"},{"date":"2016-06-20","info":{"night":["4","雷阵雨","26","东南风","微风","19:30"],"day":["4","雷阵雨","32","东南风","微风","07:30"]},"week":"一","nongli":"五月十六"},{"date":"2016-06-21","info":{"night":["4","雷阵雨","26","东南风","微风","19:30"],"day":["4","雷阵雨","32","东南风","微风","07:30"]},"week":"二","nongli":"五月十七"}],"pm25":{"key":"","show_desc":0,"pm25":{"curPm":"67","pm25":"15","pm10":"67","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年06月15日16时","cityName":"博罗"},"date":null,"isForeign":0}
     */

    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * realtime : {"wind":{"windspeed":"25.0","direct":"南风","power":"3级","offset":null},"time":"15:00:00","weather":{"humidity":"77","img":"7","info":"小雨","temperature":"30"},"dataUptime":1465977747,"date":"2016-06-15","city_code":"101280302","city_name":"博罗","week":3,"moon":"五月十一"}
         * life : {"date":"2016-6-15","info":{"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]}}
         * weather : [{"date":"2016-06-15","info":{"night":["8","中雨","26","无持续风向","微风","19:10"],"day":["8","中雨","31","无持续风向","微风","05:37"]},"week":"三","nongli":"五月十一"},{"date":"2016-06-16","info":{"dawn":["8","中雨","26","无持续风向","微风","19:10"],"night":["9","大雨","24","无持续风向","微风","19:10"],"day":["9","大雨","29","无持续风向","微风","05:37"]},"week":"四","nongli":"五月十二"},{"date":"2016-06-17","info":{"dawn":["9","大雨","24","无持续风向","微风","19:10"],"night":["3","阵雨","25","无持续风向","微风","19:10"],"day":["9","大雨","30","无持续风向","微风","05:37"]},"week":"五","nongli":"五月十三"},{"date":"2016-06-18","info":{"dawn":["3","阵雨","25","无持续风向","微风","19:10"],"night":["1","多云","26","无持续风向","微风","19:11"],"day":["4","雷阵雨","32","无持续风向","微风","05:37"]},"week":"六","nongli":"五月十四"},{"date":"2016-06-19","info":{"dawn":["1","多云","26","无持续风向","微风","19:11"],"night":["1","多云","26","无持续风向","微风","19:11"],"day":["1","多云","34","无持续风向","微风","05:38"]},"week":"日","nongli":"五月十五"},{"date":"2016-06-20","info":{"night":["4","雷阵雨","26","东南风","微风","19:30"],"day":["4","雷阵雨","32","东南风","微风","07:30"]},"week":"一","nongli":"五月十六"},{"date":"2016-06-21","info":{"night":["4","雷阵雨","26","东南风","微风","19:30"],"day":["4","雷阵雨","32","东南风","微风","07:30"]},"week":"二","nongli":"五月十七"}]
         * pm25 : {"key":"","show_desc":0,"pm25":{"curPm":"67","pm25":"15","pm10":"67","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年06月15日16时","cityName":"博罗"}
         * date : null
         * isForeign : 0
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * wind : {"windspeed":"25.0","direct":"南风","power":"3级","offset":null}
             * time : 15:00:00
             * weather : {"humidity":"77","img":"7","info":"小雨","temperature":"30"}
             * dataUptime : 1465977747
             * date : 2016-06-15
             * city_code : 101280302
             * city_name : 博罗
             * week : 3
             * moon : 五月十一
             */

            private RealtimeBean realtime;
            /**
             * date : 2016-6-15
             * info : {"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]}
             */

            private LifeBean life;
            /**
             * key :
             * show_desc : 0
             * pm25 : {"curPm":"67","pm25":"15","pm10":"67","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"}
             * dateTime : 2016年06月15日16时
             * cityName : 博罗
             */

            private Pm25Bean pm25;
            private Object date;
            private int isForeign;
            /**
             * date : 2016-06-15
             * info : {"night":["8","中雨","26","无持续风向","微风","19:10"],"day":["8","中雨","31","无持续风向","微风","05:37"]}
             * week : 三
             * nongli : 五月十一
             */

            private List<WeatherBean> weather;

            public RealtimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealtimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public Object getDate() {
                return date;
            }

            public void setDate(Object date) {
                this.date = date;
            }

            public int getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(int isForeign) {
                this.isForeign = isForeign;
            }

            public List<WeatherBean> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBean> weather) {
                this.weather = weather;
            }

            public static class RealtimeBean {
                /**
                 * windspeed : 25.0
                 * direct : 南风
                 * power : 3级
                 * offset : null
                 */

                private WindBean wind;
                private String time;
                /**
                 * humidity : 77
                 * img : 7
                 * info : 小雨
                 * temperature : 30
                 */

                private WeatherBean weather;
                private int dataUptime;
                private String date;
                private String city_code;
                private String city_name;
                private int week;
                private String moon;

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public WeatherBean getWeather() {
                    return weather;
                }

                public void setWeather(WeatherBean weather) {
                    this.weather = weather;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getCity_code() {
                    return city_code;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public String getMoon() {
                    return moon;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public static class WindBean {
                    private String windspeed;
                    private String direct;
                    private String power;
                    private Object offset;

                    public String getWindspeed() {
                        return windspeed;
                    }

                    public void setWindspeed(String windspeed) {
                        this.windspeed = windspeed;
                    }

                    public String getDirect() {
                        return direct;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public Object getOffset() {
                        return offset;
                    }

                    public void setOffset(Object offset) {
                        this.offset = offset;
                    }
                }

                public static class WeatherBean {
                    private String humidity;
                    private String img;
                    private String info;
                    private String temperature;

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }
                }
            }

            public static class LifeBean {
                private String date;
                private InfoBean info;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    private List<String> kongtiao;
                    private List<String> yundong;
                    private List<String> ziwaixian;
                    private List<String> ganmao;
                    private List<String> xiche;
                    private List<String> wuran;
                    private List<String> chuanyi;

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public List<String> getWuran() {
                        return wuran;
                    }

                    public void setWuran(List<String> wuran) {
                        this.wuran = wuran;
                    }

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }
                }
            }

            public static class Pm25Bean {
                private String key;
                private int show_desc;
                /**
                 * curPm : 67
                 * pm25 : 15
                 * pm10 : 67
                 * level : 2
                 * quality : 良
                 * des : 今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。
                 */

                private Pm25Bean1 pm25;
                private String dateTime;
                private String cityName;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public int getShow_desc() {
                    return show_desc;
                }

                public void setShow_desc(int show_desc) {
                    this.show_desc = show_desc;
                }

                public Pm25Bean1 getPm25() {
                    return pm25;
                }

                public void setPm25(Pm25Bean1 pm25) {
                    this.pm25 = pm25;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public static class Pm25Bean1 {
                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int level;
                    private String quality;
                    private String des;

                    public String getCurPm() {
                        return curPm;
                    }

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public String getDes() {
                        return des;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }
                }
            }

            public static class WeatherBean {
                private String date;
                private InfoBean info;
                private String week;
                private String nongli;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getNongli() {
                    return nongli;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public static class InfoBean {
                    private List<String> night;
                    private List<String> day;

                    public List<String> getNight() {
                        return night;
                    }

                    public void setNight(List<String> night) {
                        this.night = night;
                    }

                    public List<String> getDay() {
                        return day;
                    }

                    public void setDay(List<String> day) {
                        this.day = day;
                    }
                }
            }
        }
    }
}