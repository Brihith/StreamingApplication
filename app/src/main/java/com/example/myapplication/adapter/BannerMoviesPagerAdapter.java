package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.MovieDetails;
import com.example.myapplication.R;
import com.example.myapplication.model.BannerMovies;

import java.util.List;

public class BannerMoviesPagerAdapter extends RecyclerView.Adapter<BannerMoviesPagerAdapter.BannerMoviesViewHolder> {

    private Context context;
    private List<BannerMovies> bannerMoviesList;

    public BannerMoviesPagerAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @NonNull
    @Override
    public BannerMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout, parent, false);
        return new BannerMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerMoviesViewHolder holder, int position) {
        BannerMovies bannerMovie = bannerMoviesList.get(position);
        Glide.with(context)
                .load(bannerMovie.getImageUrl())
                .into(holder.bannerImage);
    }

    @Override
    public int getItemCount() {
        return bannerMoviesList.size();
    }

    public class BannerMoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView bannerImage;

        public BannerMoviesViewHolder(View itemView) {
            super(itemView);
            bannerImage = itemView.findViewById(R.id.banner_image);
            bannerImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.banner_image) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    BannerMovies bannerMovie = bannerMoviesList.get(position);
                    String title = bannerMovie.getMovieName();
                    Intent i= new Intent(context, MovieDetails.class);
                    i.putExtra("movieID",bannerMoviesList.get(position).getId());
                    i.putExtra("movieName",bannerMoviesList.get(position).getMovieName());
                    i.putExtra("movieImageUrl",bannerMoviesList.get(position).getImageUrl());
                    i.putExtra("movieFile",bannerMoviesList.get(position).getFileUrl());
                    context.startActivity(i);

                }
            }
        }
    }
}
