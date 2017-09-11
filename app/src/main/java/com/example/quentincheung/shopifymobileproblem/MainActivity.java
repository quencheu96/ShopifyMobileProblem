package com.example.quentincheung.shopifymobileproblem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textOne) TextView textOne;
    @BindView(R.id.textTwo) TextView textTwo;
    @BindView(R.id.button) Button button;

    String url = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6";
    private RequestQueue requestQueue;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        requestQueue = Volley.newRequestQueue(this);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchPosts();
            }
        });
    }

    private void fetchPosts() {
        StringRequest request = new StringRequest(Request.Method.GET, url, onPostsLoaded, onPostsError);
        requestQueue.add(request);

    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            TotalOrders orders = gson.fromJson(response, TotalOrders.class);
            double totalSpent =0;
            int total=0;
            for (int x = 0;x<orders.getOrders().size();x++){
                Order current = orders.getOrders().get(x);
                Customer cust = current.getCustomer();
                if (cust!=null && cust.getFirstName().equals("Napoleon") && cust.getLastName().equals("Batz")){
                    totalSpent += current.getTotalPrice();
                }
                for (int y = 0;y<current.getItems().size();y++){
                    LineItems item = current.getItems().get(y);
                    if (item.name.equals("Awesome Bronze Bag")){
                        total += item.getQuantity();
                        break;
                    }
                }
            }
            textOne.setText("Amount spent by Napolean: "+ Double.toString(totalSpent));
            textTwo.setText("Total Number of Awesome Bronze Bags sold: "+ total);
        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

}
