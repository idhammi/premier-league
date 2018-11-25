package id.idham.premierleague.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import id.idham.premierleague.R;
import id.idham.premierleague.data.api.APIService;
import id.idham.premierleague.data.model.Team;
import id.idham.premierleague.ui.detail.DetailActivity;
import id.idham.premierleague.util.ItemClickSupport;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView rvTeams;
    private ProgressBar progress;
    private MainPresenter presenter;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("English Premiere League");

        rvTeams = findViewById(R.id.rv_team);
        progress = findViewById(R.id.pb_main);
        rvTeams.setHasFixedSize(true);
        presenter = new MainPresenter(this, new APIService());
        presenter.getTeamList("4328");
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showTeamList(final List<Team> data) {
        adapter = new MainAdapter(this);
        adapter.setListTeam(data);
        rvTeams.setLayoutManager(new GridLayoutManager(this, 2));
        rvTeams.setAdapter(adapter);

        ItemClickSupport.addTo(rvTeams).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("team", data.get(position));
                startActivity(i);
            }
        });
    }
}
