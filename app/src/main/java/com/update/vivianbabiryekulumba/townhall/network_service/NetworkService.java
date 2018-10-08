package com.update.vivianbabiryekulumba.townhall.network_service;

import com.update.vivianbabiryekulumba.townhall.models.CommBoard;
import com.update.vivianbabiryekulumba.townhall.models.VolunteerDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("ViviKulu/TownHall/master/bx_comm_boards.json")
    Call<List<CommBoard>> getBxCommBoardData();

    @GET("ViviKulu/TownHall/master/bk_comm_boards.json")
    Call<List<CommBoard>> getBkCommBoardData();

    @GET("ViviKulu/TownHall/master/man_comm_boards.json")
    Call<List<CommBoard>> getMxCommBoardData();

    @GET("ViviKulu/TownHall/master/queens_comm_boards.json")
    Call<List<CommBoard>> getQuCommBoardData();

    @GET("ViviKulu/TownHall/master/staten_island_comm_boards.json")
    Call<List<CommBoard>> getStatCommBoardData();

    @GET("id/n4ac-3636.json")
    Call<List<VolunteerDetails>> getVolunteerDetailsData();

    @GET("resource/67g2-p84d.json")
    Call<List<CommBoard>> getServiceFragDomain();


}
