package com.example.method_channel_sample;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.JSONUtil;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);

      new MethodChannel(getFlutterView(), "flutter.native/helper").setMethodCallHandler(
              (call, result) -> {

                  Log.d("Bwolf" , "Teste");
                  // Note: this method is invoked on the main thread.
                  if (call.method.equals("foo")) {

                      java.util.HashMap  hashMap = (java.util.HashMap)call.arguments;

                      ArrayList<String> lista = (ArrayList<String>) hashMap.get("alunos");

                      Log.d("Bwolf" ,lista.get(0));

                      Log.d("Bwolf" ,hashMap.get("title").toString());

                      if (true) {
                          result.success("foo");
                      } else {
                          result.error("UNAVAILABLE", "Battery level not available.", null);
                      }

                  } else {
                      result.notImplemented();
                  }
              });

  }
    public Map<String, Object> getMap(Object o){
        Map<String, Object> result = new HashMap<>();
        Field[] declaredFields = o.getClass().getDeclaredFields();

        for (Field a : declaredFields ) {
            Log.d("GetMap" , a.toString());
        }

        for (Field field : declaredFields) {
            try {
                result.put(field.getName(), field.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
