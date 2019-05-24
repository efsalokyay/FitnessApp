package com.example.fitnessui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.PopupActivity;
import com.example.fitnessui.R;
import com.example.fitnessui.recyclerview.FitnessPictureAdapter;

import java.util.ArrayList;

public class FitnessPictures extends Fragment implements FitnessPictureAdapter.MyListener {

    private FitnessPictureAdapter fitnessPictureAdapter;
    private RecyclerView recyclerView;
    private ArrayList<FitnessMove> fitnessMoves;

    public static FitnessPictures newInstance() {
        return new FitnessPictures();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fitness_pictures, container, false);
        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity) getActivity(), this);

        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();
        recyclerView = rootView.findViewById(R.id.fragment_pictures_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        if (isAdded())
            recyclerView.setAdapter(fitnessPictureAdapter);

        getFitnessMoves(fitnessMoves);

        return rootView;
    }

    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoves) {

        for (int i = 0; i < 16; i++) {
            fitnessMoves.add(new FitnessMove("Fitness Move Name " + i,
                    "https://atilsamancioglu.com/wp-content/uploads/2018/06/fitness" + i + ".jpg",
                    "Fitness Move Description",
                    100));
        }
        return fitnessMoves;
    }

    @Override
    public void MyListener(FitnessMove fitnessMove) {
        Intent intent = PopupActivity.newIntent(getActivity(),fitnessMove);
        startActivity(intent);
    }
}
