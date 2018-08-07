package com.example.vivianbabiryekulumba.townhall.network_service;

import com.example.vivianbabiryekulumba.townhall.models.CommBoard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("ViviKulu/TownHall/master/bx_comm_boards.json")
    Call<List<CommBoard>> getCommBoardData();
}
