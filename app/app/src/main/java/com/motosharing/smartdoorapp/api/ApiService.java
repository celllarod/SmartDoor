package com.motosharing.smartdoorapp.api;
import java.util.Base64;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    // Abrir puerta
    @GET("/open")
    Call<Boolean> openDoor();
}
