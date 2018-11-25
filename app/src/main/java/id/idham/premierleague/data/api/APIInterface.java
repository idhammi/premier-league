package id.idham.premierleague.data.api;

import id.idham.premierleague.BuildConfig;
import id.idham.premierleague.data.model.TeamResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("api/v1/json/" + BuildConfig.TSDB_API_KEY + "/lookup_all_teams.php")
    Call<TeamResponse> getListTeams(@Query("id") String id);

}
