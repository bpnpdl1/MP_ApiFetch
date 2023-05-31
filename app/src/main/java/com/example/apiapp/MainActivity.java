package com.example.apiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchClubFromServer();
/*
        String jsonStr = "{\"club\":[" + "{\"clubname\":\"lod\",\"typ\":\"dance\",\"addrrss\":\"ktm\",\"fee\":1000}]}"
                + "{\"club\":[" + "{\"clubname\":\"lod\",\"typ\":\"dance\",\"addrrss\":\"ktm\",\"fee\":1000}]}";

        decodeJson(jsonStr);*/
    }

        public void decodeJson(String jsonStr){
            try{
                JSONObject jsonObject=new JSONObject(jsonStr);
                JSONArray clubArr=jsonObject.getJSONArray("club");
                JSONObject secondObj=clubArr.getJSONObject(1);
                String name=secondObj.getString("clubname");
                Log.v("Club name","Club name is"+name);


            } catch (JSONException e){
                throw  new RuntimeException(e);
            }

        }

        private  void fetchClubFromServer(){
        //Instantiate the RequestQue
            RequestQueue queue= Volley.newRequestQueue(this);

            //url for api

            String url="http://192.168.1.68:5000/api/clubs";

            //Request a string response from the provided URL
            StringRequest request=new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override

                        public void onResponse(String response) {
                            decodeJson(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("exception",error.toString());
                }
            });
            queue.add(request);

        }

}