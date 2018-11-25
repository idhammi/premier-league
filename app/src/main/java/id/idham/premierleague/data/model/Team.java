package id.idham.premierleague.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Team implements Parcelable {
    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
    @SerializedName("idTeam")
    private String teamId;
    @SerializedName("strTeam")
    private String teamName;
    @SerializedName("strTeamBadge")
    private String teamBadge;
    @SerializedName("intFormedYear")
    private String teamFormedYear;
    @SerializedName("strManager")
    private String teamManager;
    @SerializedName("strStadium")
    private String teamStadium;
    @SerializedName("strDescriptionEN")
    private String teamDesc;
    @SerializedName("strTeamJersey")
    private String teamJersey;
    @SerializedName("strStadiumThumb")
    private String teamStadiumPhoto;
    @SerializedName("strWebsite")
    private String teamWebsite;

    protected Team(Parcel in) {
        teamId = in.readString();
        teamName = in.readString();
        teamBadge = in.readString();
        teamFormedYear = in.readString();
        teamManager = in.readString();
        teamStadium = in.readString();
        teamDesc = in.readString();
        teamJersey = in.readString();
        teamStadiumPhoto = in.readString();
        teamWebsite = in.readString();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamBadge() {
        return teamBadge;
    }

    public void setTeamBadge(String teamBadge) {
        this.teamBadge = teamBadge;
    }

    public String getTeamFormedYear() {
        return teamFormedYear;
    }

    public void setTeamFormedYear(String teamFormedYear) {
        this.teamFormedYear = teamFormedYear;
    }

    public String getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(String teamManager) {
        this.teamManager = teamManager;
    }

    public String getTeamStadium() {
        return teamStadium;
    }

    public void setTeamStadium(String teamStadium) {
        this.teamStadium = teamStadium;
    }

    public String getTeamDesc() {
        return teamDesc;
    }

    public void setTeamDesc(String teamDesc) {
        this.teamDesc = teamDesc;
    }

    public String getTeamJersey() {
        return teamJersey;
    }

    public void setTeamJersey(String teamJersey) {
        this.teamJersey = teamJersey;
    }

    public String getTeamStadiumPhoto() {
        return teamStadiumPhoto;
    }

    public void setTeamStadiumPhoto(String teamStadiumPhoto) {
        this.teamStadiumPhoto = teamStadiumPhoto;
    }

    public String getTeamWebsite() {
        return teamWebsite;
    }

    public void setTeamWebsite(String teamWebsite) {
        this.teamWebsite = teamWebsite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(teamId);
        dest.writeString(teamName);
        dest.writeString(teamBadge);
        dest.writeString(teamFormedYear);
        dest.writeString(teamManager);
        dest.writeString(teamStadium);
        dest.writeString(teamDesc);
        dest.writeString(teamJersey);
        dest.writeString(teamStadiumPhoto);
        dest.writeString(teamWebsite);
    }
}
