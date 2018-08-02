package com.example.vivianbabiryekulumba.townhall.network_service;

import com.example.vivianbabiryekulumba.townhall.models.ZipCode;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("ViviKulu/TownHall/master/commboard.json")
    Call<List<ZipCode>> getCommBoardData();
}
