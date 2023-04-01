package com.motosharing.smartdoorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.motosharing.smartdoorapp.api.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button bt_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_open = findViewById(R.id.bt_open);
        bt_open.setOnClickListener(view -> openDoor(view));


    }

    private void openDoor(View v) {
        Call<Boolean> call = ApiAdapter.getApiService().openDoor();
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                if (response.isSuccessful()) {
                    Log.d("OPEN", response.toString());
                } else {

                }
            }
            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable t) {
                Log.d("ERROR", t.toString());
            }
        });
    }
}