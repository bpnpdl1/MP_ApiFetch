package com.example.apiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       recyclerView=findViewById(R.id.recycleview);
        volleyRequest();

    }
    public void volleyRequest(){
      /// Instantiate the Request Queue
        RequestQueue queue= Volley.newRequestQueue(this);

        //Url for localhost

        String url="https://demo3206135.mockable.io/clubs";

        //Request a string response from the provided url

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //passing data for decoding

                decodeJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //displaying error response message

                Log.d("Exception",error.toString());
            }

    });

        //add the request to the request Queue
        queue.add(stringRequest);
    }

    public void decodeJson(String response){
        try{
            ArrayList<ClubModal> data=new ArrayList<>();
            JSONObject result=new JSONObject(response);
            JSONArray array=result.getJSONArray("clubs");

            for (int i=0;i<array.length();i++){
                //fetching the row

                JSONObject club=array.getJSONObject(i);
                int cid=club.getInt("id");
                String clubname=club.getString("clubname");
                String clubtype=club.getString("type");
                String clubaddress=club.getString("address");
                int clubentryfee=club.getInt("fee");

                Log.v("rerere",clubname);


                ClubModal clubModal=new ClubModal(cid,clubname,clubaddress,clubtype,clubentryfee);
                data.add(clubModal);

                layoutManager=new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerAdapter=new ClubRecyclerAdapter(HomeActivity.this,data);
                recyclerView.setAdapter(recyclerAdapter);




            }

        } catch (JSONException e) {
            Log.d("Exception ",e.toString());
        }
    }

}