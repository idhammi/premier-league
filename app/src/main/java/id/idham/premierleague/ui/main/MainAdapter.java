package id.idham.premierleague.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

import id.idham.premierleague.R;
import id.idham.premierleague.data.model.Team;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CardViewViewHolder> {
    private List<Team> listTeam;
    private Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    public List<Team> getListTeam() {
        return listTeam;
    }

    public void setListTeam(List<Team> listTeam) {
        this.listTeam = listTeam;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        Team team = getListTeam().get(position);

        Glide.with(context)
                .load(team.getTeamBadge())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imgPhoto);

        holder.tvName.setText(team.getTeamName());
    }

    @Override
    public int getItemCount() {
        return getListTeam().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.text_item_name);
        }
    }
}
