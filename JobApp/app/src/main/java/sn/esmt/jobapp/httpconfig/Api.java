package sn.esmt.jobapp.httpconfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/CVs/all")
    public Call<ArrayList<CVResponse>> all();
}
