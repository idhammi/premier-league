package id.idham.premierleague.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import id.idham.premierleague.R;
import id.idham.premierleague.data.model.Team;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvFormedYear, tvDesc, tvManager, tvStadium;
    private ImageView ivStadium, ivBadge, ivJersey;
    private Button btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Team team = getIntent().getParcelableExtra("team");

        tvName = findViewById(R.id.tv_team_name);
        tvFormedYear = findViewById(R.id.tv_team_year);
        tvDesc = findViewById(R.id.tv_team_desc);
        tvManager = findViewById(R.id.tv_team_manager);
        tvStadium = findViewById(R.id.tv_team_stadium);
        ivStadium = findViewById(R.id.iv_team_stadium);
        ivBadge = findViewById(R.id.iv_team_badge);
        ivJersey = findViewById(R.id.iv_team_jersey);
        btnWebsite = findViewById(R.id.btn_website);

        tvName.setText(team.getTeamName());
        tvFormedYear.setText(team.getTeamFormedYear());
        tvDesc.setText(team.getTeamDesc());
        tvManager.setText(team.getTeamManager());
        tvStadium.setText(team.getTeamStadium());

        Glide.with(this).load(team.getTeamStadiumPhoto())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivStadium);
        Glide.with(this).load(team.getTeamBadge())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivBadge);
        Glide.with(this).load(team.getTeamJersey())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivJersey);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(team.getTeamWebsite());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void openUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + url));
        startActivity(i);
    }
}
