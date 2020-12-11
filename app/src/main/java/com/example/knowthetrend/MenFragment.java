package com.example.knowthetrend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MenFragment extends Fragment {

    private RecyclerView recyclerView;
    private int[] images={R.drawable.menshirts1,R.drawable.mensjeans2,R.drawable.menshoes3,R.drawable.mwnethnicwear};
    private  String[] text={"Shirts", "Pants and Jeans", "Shoes", "Ethnic Wear"};
    private ListAdapter listAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.men_fragment, container, false);
        recyclerView=view.findViewById(R.id.menList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        recyclerView.setAdapter(new ListAdapter(view.getContext(),images,text));
        return view;
    }
}
