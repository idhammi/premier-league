package id.idham.premierleague.ui.main;

import id.idham.premierleague.data.api.APIService;
import id.idham.premierleague.data.model.TeamResponse;
import retrofit2.Call;
import retrofit2.Response;

public class MainPresenter {

    private MainView view;
    private APIService services;

    public MainPresenter(MainView view, APIService services) {
        this.view = view;
        this.services = services;
    }

    public void getTeamList(String id) {
        view.showLoading();
        services.getListTeams(id, new retrofit2.Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        view.showTeamList(response.body().getTeams());
                    }
                }

                view.hideLoading();
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                view.hideLoading();
            }
        });
    }
}
