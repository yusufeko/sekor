package com.example.ysfkp.sekor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ysfkp.sekor.R;
import com.example.ysfkp.sekor.entity.MatchResult;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ysfkp on 18/05/17.
 */

public class PremierAdapter extends RecyclerView.Adapter<PremierAdapter.PremierHolder> {

    List<MatchResult> teams;

    public PremierAdapter(List<MatchResult> teams) {
        this.teams = teams;
    }

    @Override
    public PremierHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.premier_item, parent, false);
        return new PremierHolder(view);
    }

    @Override
    public void onBindViewHolder(PremierHolder holder, int position) {
        MatchResult result = teams.get(position);
        //Log.i("item: ", teamName);
        holder.team1.setText(result.getTeam1());
        holder.score1.setText(result.getScore1());
        holder.team2.setText(result.getTeam2());
        holder.score2.setText(result.getScore2());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class PremierHolder extends RecyclerView.ViewHolder {

        public TextView team1;
        public TextView score1;
        public TextView team2;
        public TextView score2;

        public PremierHolder(View itemView) {
            super(itemView);
            team1 = (TextView) itemView.findViewById(R.id.txtTeamItem1);
            score1 = (TextView) itemView.findViewById(R.id.txtTeamScore1);
            team2 = (TextView) itemView.findViewById(R.id.txtTeamItem2);
            score2 = (TextView) itemView.findViewById(R.id.txtTeamScore2);
        }
    }
}
