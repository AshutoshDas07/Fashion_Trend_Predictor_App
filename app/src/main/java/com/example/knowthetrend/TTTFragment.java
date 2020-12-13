package com.example.knowthetrend;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TTTFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private int[] images={R.drawable.menshirts1,R.drawable.mensjeans2,R.drawable.menshoes3,R.drawable.mwnethnicwear};
    private  String[] text={"Shirts", "Pants and Jeans", "Shoes", "Ethnic Wear"};
    Intent receivedIntent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.ttt_fragment, container, false);
        toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Top 10 Trending");
        receivedIntent=getActivity().getIntent();
        recyclerView=view.findViewById(R.id.tttlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        recyclerView.setAdapter(new ListAdapter(view.getContext(),images,text,receivedIntent));
        return view;
    }
}
