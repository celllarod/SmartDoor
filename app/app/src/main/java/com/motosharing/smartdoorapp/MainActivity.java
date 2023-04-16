package com.motosharing.smartdoorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.motosharing.smartdoorapp.api.ApiAdapter;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button bt_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_open = findViewById(R.id.bt_open3);
        bt_open.setOnClickListener(view -> openDoor(view));
    }

    private void openDoor(View v) {
        Call<Boolean> call = ApiAdapter.getApiService().openDoor();
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                if (response.isSuccessful()) {
                    Log.d("OPEN", response.toString());
                    Toast exitoPresentacionToast = Toast.makeText(getApplicationContext(), "¡Puerta abierta durante 3 segundos!", Toast.LENGTH_LONG);
                    exitoPresentacionToast.setDuration(Toast.LENGTH_LONG);
                    exitoPresentacionToast.show();
                } else {
                    Log.d("ERROR", response.toString());
                    Toast errorPresentacionToast = Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG);
                    errorPresentacionToast.setDuration(Toast.LENGTH_LONG);
                    errorPresentacionToast.show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable t) {
                Log.d("ERROR", t.toString());
                Toast errorPresentacionToast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                errorPresentacionToast.setDuration(Toast.LENGTH_LONG);
                errorPresentacionToast.show();

            }
        });
    }
}