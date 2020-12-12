package com.example.knowthetrend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WomenFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private int[] images={R.drawable.ladiestops,R.drawable.ladiesshirts,R.drawable.ladiesethnic,R.drawable.ladiespant,R.drawable.ladiesfoorwear,R.drawable.ladiesaccessories};
    private  String[] text={"Tops", "Shirts", "Ethnic", "Pants/Jeans", "FootWear", "Accessories"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.women_fragment, container, false);
        toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Women Fashion");
        recyclerView=view.findViewById(R.id.womenList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        recyclerView.setAdapter(new ListAdapter(view.getContext(),images,text));
        return view;
    }
}
