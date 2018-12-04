package com.crazylemon.yantu.utils;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;


public class badi_map_ {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        String ak = "orsN0xHVa8H0VxcMWW0uGf03";
        String url = "http://api.map.baidu.com/geocoder/v2/?address=杭州市千岛湖&output=json&ak=" + ak;
        //1.地理编码服务，即根据地址来查经度纬度
        String return_value = Parser_Tool.do_get(url);
        System.out.println(return_value);
        // {"status":0,"result":{"location":{"lng":121.51996737545,"lat":31.308233584217},"precise":1,"confidence":80,"level":"\u5546\u52a1\u5927\u53a6"}}


        //2.逆地理编码,即根据经度纬度来查地址
//        String url2 = "http://api.map.baidu.com/geocoder/v2/?ak=" + ak + "&location=50.24135370562375,127.50735873052899&output=json&pois=1";
//        System.out.println(Parser_Tool.do_get(url2));
        // {"status":0,"result":{"location":{"lng":121.51996737545,"lat":31.308233429954},"formatted_address":"上海市杨浦区政通路177","business":"五角场,大学区,复旦大学","addressComponent":{"city":"上海市","district":"杨浦区","province":"上海市","street":"政通路","street_number":"177"},"pois":[{"addr":"政通路177","cp":"NavInfo","distance":"0.022361","name":"万达广场C座","poiType":"办公大厦,商务大厦","point":{"x":121.51996728562,"y":31.308233584217},"tel":"(021)61362818","uid":"18c7ec2a6c3b0e5e08ccddbe","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"76.894138","name":"麻辣风暴","poiType":"中餐馆,餐饮","point":{"x":121.51999558224,"y":31.308826030169},"tel":"(021)55663716","uid":"e7b540bd7d31784b4d6d4670","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"80.359847","name":"H&M","poiType":"服装鞋帽,购物","point":{"x":121.51968485837,"y":31.307663040014},"tel":"","uid":"badcec30996927a041ab9a26","zip":""},{"addr":"上海市杨浦区四平路2637号","cp":"mix","distance":"101.236603","name":"班尼路","poiType":"服装鞋帽,购物","point":{"x":121.51911075132,"y":31.307971259271},"tel":"","uid":"802871ea45db67f7704b87bc","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"103.612502","name":"特力屋","poiType":"家居建材,购物","point":{"x":121.51957508543,"y":31.307508698607},"tel":"(021)52191919","uid":"bfd5bcd746f798e551e5c581","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"103.612502","name":"复茂","poiType":"中餐馆,餐饮","point":{"x":121.51957508543,"y":31.307508698607},"tel":"","uid":"3c65d40795d0f74fefe4a523","zip":""},{"addr":"特力时尚汇5层","cp":"NavInfo","distance":"103.612502","name":"望湘园","poiType":"中餐馆,餐饮","point":{"x":121.51957508543,"y":31.307508698607},"tel":"(021)33620977","uid":"8889b451bdeb6544e111033f","zip":""},{"addr":"上海市杨浦区翔殷路1128号大西洋百货2楼(近国济路)","cp":"mix","distance":"130.818973","name":"艾格","poiType":"服装鞋帽,购物","point":{"x":121.5191145242,"y":31.307539242954},"tel":"","uid":"2d83695078e80ecf05fef54c","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"14.235832","name":"冠龙数码彩扩冲印","poiType":"快照冲印,摄影冲印,生活服务","point":{"x":121.52008792805,"y":31.308270067458},"tel":"","uid":"80d3f20fca4819726849f393","zip":""},{"addr":"上海市杨浦区","cp":"NavInfo","distance":"55.990822","name":"美卡拉","poiType":"服装鞋帽,购物","point":{"x":121.51972384483,"y":31.307855561471},"tel":"","uid":"f78e03f2963d1f271ee99941","zip":""}],"cityCode":289}}
    }
}