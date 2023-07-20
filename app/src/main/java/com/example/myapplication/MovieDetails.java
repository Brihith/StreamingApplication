package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class MovieDetails extends AppCompatActivity {
    ImageView movieImage;
    TextView movieName;
    Button playButton;

    String mName,mImage,mUrl,mId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movieImage = findViewById(R.id.movie_image);
        movieName = findViewById(R.id.movie_name);
        playButton = findViewById(R.id.play_button);
        mId = getIntent().getStringExtra("movieID");
        mName= getIntent().getStringExtra("movieName");
        mUrl=getIntent().getStringExtra("movieFile");
        mImage=getIntent().getStringExtra("movieImageUrl");

        Glide.with(this).load(mImage).into(movieImage);
        movieName.setText(mName);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MovieDetails.this, VideoPlayerActivity.class);
                i.putExtra("url",mUrl);
                startActivity(i);
            }
        });


    }
}