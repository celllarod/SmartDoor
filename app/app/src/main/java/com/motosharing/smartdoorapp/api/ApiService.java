package com.motosharing.smartdoorapp.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    // Abrir puerta
    @GET("/open")
    Call<Boolean> openDoor();
}
