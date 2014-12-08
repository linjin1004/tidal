package com.tada.taiwantidal;

import android.app.Application;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by LinJin on 2014/12/7.
 */
public class TidalUtil extends Application {

    String cityName = "cityName";
    String townName = "townName";
    String towns = "towns";
    String id = "id";

    private static JSONArray allPlacesJSONArray = new JSONArray();

    @Override
    public void onCreate()
    {
        super.onCreate();

        Log.i("tidal chart", "create");
        JSONObject cityJSONObject = new JSONObject();
        JSONArray townsJSONArray = new JSONArray();
        JSONObject townJSONObject = new JSONObject();

        //keelung
        try {
            townJSONObject.put(townName,"zhongzheng");
            townJSONObject.put(id,"001701");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"zhongshan");
            townJSONObject.put(id,"001705");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"anle");
            townJSONObject.put(id,"001706");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"keelung");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // new_taipei
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"gongliao");
            townJSONObject.put(id,"500026");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"ruifang");
            townJSONObject.put(id,"500012");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"wanli");
            townJSONObject.put(id,"500028");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"jinshan");
            townJSONObject.put(id,"500027");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"shimen");
            townJSONObject.put(id,"500022");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"sanzhi");
            townJSONObject.put(id,"500021");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"tamsui");
            townJSONObject.put(id,"500010");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"bali");
            townJSONObject.put(id,"500023");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"linkou");
            townJSONObject.put(id,"500017");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"new_taipei");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // taoyuan
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"luzhu");
            townJSONObject.put(id,"000305");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"dayuan");
            townJSONObject.put(id,"000306");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"guanyin");
            townJSONObject.put(id,"000312");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xinwu");
            townJSONObject.put(id,"000311");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"dayuan");
            townJSONObject.put(id,"000306");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"taoyuan");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // hsinchu_county
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xinfeng");
            townJSONObject.put(id,"000406");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"zhubei");
            townJSONObject.put(id,"000401");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"hsinchu_county");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // hsinchu_city
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"north");
            townJSONObject.put(id,"001802");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xiangshan");
            townJSONObject.put(id,"001803");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"hsinchu_city");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // miaoli
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"zhunan");
            townJSONObject.put(id,"000504");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"houlong");
            townJSONObject.put(id,"000506");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"tongxiao");
            townJSONObject.put(id,"000503");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"yuanli");
            townJSONObject.put(id,"000502");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"miaoli");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // taichung
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"dajia");
            townJSONObject.put(id,"600011");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"da_an");
            townJSONObject.put(id,"600022");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"qingshui");
            townJSONObject.put(id,"600012");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"wuqi");
            townJSONObject.put(id,"600014");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"longjing");
            townJSONObject.put(id,"600025");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"taichung");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // changhua
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"shengang");
            townJSONObject.put(id,"000705");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xianxi");
            townJSONObject.put(id,"000704");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"lukang");
            townJSONObject.put(id,"000702");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"fuxing");
            townJSONObject.put(id,"000706");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"fangyuan");
            townJSONObject.put(id,"000723");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"dacheng");
            townJSONObject.put(id,"000724");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"changhua");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // yunlin
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"mailiao");
            townJSONObject.put(id,"000913");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"taixi");
            townJSONObject.put(id,"000916");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"sihu");
            townJSONObject.put(id,"000918");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"kouhu");
            townJSONObject.put(id,"000919");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"yunlin");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // chiayi
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"dongshi");
            townJSONObject.put(id,"001009");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"budai");
            townJSONObject.put(id,"001003");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"chiayi");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // tainan
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"beimen");
            townJSONObject.put(id,"700017");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"jiangjun");
            townJSONObject.put(id,"700016");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"qigu");
            townJSONObject.put(id,"700015");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"annan");
            townJSONObject.put(id,"700035");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"anping");
            townJSONObject.put(id,"700036");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"south");
            townJSONObject.put(id,"700033");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"tainan");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // kaohsiung
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"qieding");
            townJSONObject.put(id,"400026");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"yong_an");
            townJSONObject.put(id,"400027");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"mituo");
            townJSONObject.put(id,"400028");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"ziguan");
            townJSONObject.put(id,"400029");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"nanzi");
            townJSONObject.put(id,"400400");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"zuoying");
            townJSONObject.put(id,"400300");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"gushan");
            townJSONObject.put(id,"400200");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"qijin");
            townJSONObject.put(id,"401000");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"qianzhen");
            townJSONObject.put(id,"400900");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xiaogang");
            townJSONObject.put(id,"401100");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"linyuan");
            townJSONObject.put(id,"400013");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"kaohsiung");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // pingtung
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xinyuan");
            townJSONObject.put(id,"001317");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"donggang");
            townJSONObject.put(id,"001303");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"liuqiu");
            townJSONObject.put(id,"001322");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"linbian");
            townJSONObject.put(id,"001319");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"jiadong");
            townJSONObject.put(id,"001321");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"fangliao");
            townJSONObject.put(id,"001316");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"fangshan");
            townJSONObject.put(id,"001325");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"checheng");
            townJSONObject.put(id,"001323");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"manzhou");
            townJSONObject.put(id,"001324");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"mudan");
            townJSONObject.put(id,"001333");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"hengchun");
            townJSONObject.put(id,"001304");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"pingtung");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // taitung
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"beinan");
            townJSONObject.put(id,"001404");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"donghe");
            townJSONObject.put(id,"001407");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"chenggong");
            townJSONObject.put(id,"001402");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"taitung_taitung");
            townJSONObject.put(id,"001401");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"changbin");
            townJSONObject.put(id,"001408");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"daren");
            townJSONObject.put(id,"001415");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"dawu");
            townJSONObject.put(id,"001410");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"taimali");
            townJSONObject.put(id,"001409");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"ludao");
            townJSONObject.put(id,"001411");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"lanyu");
            townJSONObject.put(id,"001416");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"taitung");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // hualien
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"fengbin");
            townJSONObject.put(id,"001508");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"shoufeng");
            townJSONObject.put(id,"001506");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"ji_an");
            townJSONObject.put(id,"001505");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"hualien_hualien");
            townJSONObject.put(id,"001501");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xincheng");
            townJSONObject.put(id,"001504");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xiulin");
            townJSONObject.put(id,"001511");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"hualien");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // yilan
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"nan_ao");
            townJSONObject.put(id,"000212");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"su_ao");
            townJSONObject.put(id,"000203");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"wujie");
            townJSONObject.put(id,"000209");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"zhuangwei");
            townJSONObject.put(id,"000206");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"toucheng");
            townJSONObject.put(id,"000204");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"yilan");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // lienchiang
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"dongyin");
            townJSONObject.put(id,"900704");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"beigan");
            townJSONObject.put(id,"900702");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"nangan");
            townJSONObject.put(id,"900701");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"juguang");
            townJSONObject.put(id,"900703");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"lienchiang");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // kinmen
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"jinning");
            townJSONObject.put(id,"902004");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"jincheng");
            townJSONObject.put(id,"902001");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"lieyu");
            townJSONObject.put(id,"902005");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"jinhu");
            townJSONObject.put(id,"902003");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"jinsha");
            townJSONObject.put(id,"902002");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"wuqiu");
            townJSONObject.put(id,"902006");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"kinmen");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

            // penghu
            townsJSONArray = new JSONArray();
            cityJSONObject = new JSONObject();
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"magong");
            townJSONObject.put(id,"001601");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"huxi");
            townJSONObject.put(id,"001602");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"baisha");
            townJSONObject.put(id,"001603");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"xiyu");
            townJSONObject.put(id,"001604");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"wang_an");
            townJSONObject.put(id,"001605");
            townsJSONArray.put(townJSONObject);
            townJSONObject = new JSONObject();
            townJSONObject.put(townName,"qimei");
            townJSONObject.put(id,"001606");
            townsJSONArray.put(townJSONObject);

            cityJSONObject.put(cityName,"penghu");
            cityJSONObject.put(towns, townsJSONArray);
            allPlacesJSONArray.put(cityJSONObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONArray getAllPalces(){
        return allPlacesJSONArray;
    }

    public JSONArray getTowns(int cityIndex){
        JSONArray townsArray = new JSONArray();
        JSONObject cityObject = new JSONObject();
        try {
            cityObject = allPlacesJSONArray.getJSONObject(cityIndex);
            townsArray = cityObject.getJSONArray(towns);
        } catch (JSONException e) {
            Log.i("TaiwanTidal", "tidalIdChart.getTowns error:" + e.toString());
        }
        return townsArray;
    }
}
