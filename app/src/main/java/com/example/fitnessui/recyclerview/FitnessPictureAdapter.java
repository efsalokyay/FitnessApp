package com.example.fitnessui.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.R;

import java.util.ArrayList;

public class FitnessPictureAdapter extends RecyclerView.Adapter<FitnessPictureViewHolder> implements View.OnClickListener {

    private ArrayList<FitnessMove> fitnessMoves;
    private LayoutInflater layoutInflater;
    private AppCompatActivity appCompatActivity;
    private MyListener myListener;

    public FitnessPictureAdapter(AppCompatActivity appCompatActivity, MyListener myListener) {
        this.appCompatActivity = appCompatActivity;
        this.myListener = myListener;
        layoutInflater = appCompatActivity.getLayoutInflater();
        fitnessMoves = new ArrayList<>();
    }

    public ArrayList<FitnessMove> getFitnessMoves(){
        return fitnessMoves;
    }

    @NonNull
    @Override
    public FitnessPictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listView = layoutInflater.inflate(R.layout.recyclerview_fitnesspictures_list,viewGroup,false);
        listView.setOnClickListener(this);
        return new FitnessPictureViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessPictureViewHolder fitnessPictureViewHolder, int i) {
        fitnessPictureViewHolder.getMoves(appCompatActivity,fitnessMoves.get(i));
    }

    @Override
    public int getItemCount() {
        return fitnessMoves.size();
    }

    @Override
    public void onClick(View v) {
        //Tagleme işlemi FitnessMove da yapılıyorsa çalıştırsın.
        if (v.getTag() instanceof FitnessMove){
            FitnessMove fitnessMove = (FitnessMove) v.getTag();
            myListener.MyListener(fitnessMove);
        }
    }

    public interface MyListener {
        void MyListener(FitnessMove fitnessMove);

    }
}
