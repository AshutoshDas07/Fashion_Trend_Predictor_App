package com.example.knowthetrend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MenFragment extends Fragment {

    Toolbar toolbar;
    private RecyclerView recyclerView;
    private int[] images={R.drawable.menshirts1,R.drawable.mentshirts,R.drawable.menjackets, R.drawable.mwnethnicwear,R.drawable.menshoes3, R.drawable.mensjeans2};
    private  String[] text={"Shirts", "T shirts", "Jackets", "Ethnic Wear", "FootWear", "Jeans"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.men_fragment, container, false);
        toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Men Fashion");
        recyclerView=view.findViewById(R.id.menList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        recyclerView.setAdapter(new ListAdapter(view.getContext(),images,text));
        return view;
    }
}
