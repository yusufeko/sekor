package com.example.ysfkp.sekor;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ysfkp.sekor.adapter.PremierAdapter;
import com.example.ysfkp.sekor.datalayer.Match;
import com.example.ysfkp.sekor.entity.MatchResult;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ligue1Fragment extends Fragment {


    public Ligue1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ligue1, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recLigue1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        new LoadMatchTask(recyclerView).execute();

        return v;
    }

    class LoadMatchTask extends AsyncTask<Void, Void, List<MatchResult>> {

        RecyclerView recyclerView;

        public LoadMatchTask(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        @Override
        protected List<MatchResult> doInBackground(Void... params) {
            // ambil data dari internet
            Match match = new Match("2017-05-12T12:00:00-03:00&to=2017-05-19T12:00:00-03:00", "47");

            List<MatchResult> list = match.getResult();

            return list;
        }

        @Override
        protected void onPostExecute(List<MatchResult> matchResults) {
            PremierAdapter adapter = new PremierAdapter(matchResults);
            recyclerView.setAdapter(adapter);
        }
    }

}
