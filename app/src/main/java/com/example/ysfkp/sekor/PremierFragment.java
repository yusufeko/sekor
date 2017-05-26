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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PremierFragment extends Fragment {


    public PremierFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_premier, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recPremier);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        // do background request
        new LoadMatchTask(recyclerView).execute();

        // Inflate the layout for this fragment
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
            Match match = new Match("2017-05-12T12:00:00-03:00&to=2017-05-19T12:00:00-03:00", "2");

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
