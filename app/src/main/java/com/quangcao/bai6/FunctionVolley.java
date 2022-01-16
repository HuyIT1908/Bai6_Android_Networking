package com.quangcao.bai6;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class FunctionVolley {

    public void insertVolley(Context context , TextView textView, String name , String price , String description){
        // 1. Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        // 2. URL ( API )
        String url = "https://polyprojects.herokuapp.com/api/add_products";
        // 3. Truyền tham số
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText( response.toString() );
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText( error.getMessage() );
                    }
                }
        )
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> stringMap = new HashMap<>();
                stringMap.put("name" , name);
                stringMap.put("price" , price);
                stringMap.put("description" , description);
                return stringMap;
            }
        };
        // 4. add request vào xử lí
        queue.add(stringRequest);
    }

    public void updateVolley(Context context , TextView textView, String id, String name , String price , String description){
        // 1. Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        // 2. URL ( API )
        String url = "https://polyprojects.herokuapp.com/api/update_products";
        // 3. Truyền tham số
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText( response.toString() );
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText( error.getMessage() );
                    }
                }
        )
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> stringMap = new HashMap<>();
                stringMap.put("id" , id);
                stringMap.put("name" , name);
                stringMap.put("price" , price);
                stringMap.put("description" , description);
                return stringMap;
            }
        };
        // 4. add request vào xử lí
        queue.add(stringRequest);
    }

    public void deleteVolley(Context context , TextView textView, String id){
        // 1. Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        // 2. URL ( API )
        String url = "https://polyprojects.herokuapp.com/api/delete_products";
        // 3. Truyền tham số
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText( response.toString() );
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText( error.getMessage() );
                    }
                }
        )
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> stringMap = new HashMap<>();
                stringMap.put("id" , id);
                return stringMap;
            }
        };
        // 4. add request vào xử lí
        queue.add(stringRequest);
    }

}
