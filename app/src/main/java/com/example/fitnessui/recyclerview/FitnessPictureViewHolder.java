package com.example.fitnessui.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FitnessPictureViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    ProgressBar progressBar;

    public FitnessPictureViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.recyclerview_fitnesspictures_list_imageview);
        progressBar = itemView.findViewById(R.id.recyclerview_fitnesspictures_list_progressbar);
    }

    public void getMoves(Context context, FitnessMove fitnessMove) {
        itemView.setTag(fitnessMove);
        Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
