package com.client.consumer;


import com.demo.sample.model.Product;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpClientProxy {
    OkHttpClient client;

    public OkHttpClientProxy() {
        client = new OkHttpClient();
    }

    public void post(String url, Product product) throws IOException {
        String jsonBody = String.format("{\"name\": \"%s\", \"description\": \"%s\", \"price\": \"%s\"}", product.getName(), product.getDescription(), product.getPrice());
        RequestBody requestBody = RequestBody.create(jsonBody, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            System.out.println("Response: " + responseBody);
        } else {
            System.err.println("Request failed: " + response.code() + " - " + response.message());
        }


    }
}
