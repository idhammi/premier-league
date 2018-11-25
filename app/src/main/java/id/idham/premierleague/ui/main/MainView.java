package id.idham.premierleague.ui.main;

import java.util.List;

import id.idham.premierleague.data.model.Team;

public interface MainView {
    void showLoading();

    void hideLoading();

    void showTeamList(List<Team> data);
}
