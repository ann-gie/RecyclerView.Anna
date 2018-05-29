package com.example.anna.recyclerviewanna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public class MovieDetailed extends AppCompatActivity
{

    float savedRating = 0.0f;
    MovieFragment movieFragment;



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detailed);

        if (savedInstanceState == null) {
            if (getFragmentManager().findFragmentByTag(getString(R.string.change_flag)) == null) {
                Bundle bundle = new Bundle();
                movieFragment = new MovieFragment();
                movieFragment.setRetainInstance(true);
                movieFragment.setArguments(bundle);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, movieFragment);
                fragmentTransaction.commit();
            }
        }
    }

    public String getMovieData()
    {
        Intent intent = getIntent();
        return intent.getStringExtra("title");
    }

    public String getMovieImg()
    {
        Intent intent = getIntent();
        return intent.getStringExtra("image");
    }

    public String getMovieDescription()
    {
        Intent intent = getIntent();
        return intent.getStringExtra("description");
    }

    public int[] getImages()
    {
        Intent intent = getIntent();
        return intent.getIntArrayExtra("imageArray");
    }

    public float getRating()
    {
        Intent intent = getIntent();
        return intent.getFloatExtra("rating", 0);
    }

    public String []getActors()
    {
        return getIntent().getStringArrayExtra("actorsArray");
    }

    public void settingRating(float rating)
    {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("rating", rating);
        setResult(Activity.RESULT_OK, resultIntent);
//        finish();
        savedRating = rating;
    }

}