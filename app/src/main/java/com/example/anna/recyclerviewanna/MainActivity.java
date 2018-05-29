package com.example.anna.recyclerviewanna;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static com.example.anna.recyclerviewanna.R.id.genre;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private int lastClickedPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prepareMovieData();



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {


                Movie movie = movieList.get(position);
                lastClickedPosition = position;
//                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MovieDetailed.class);
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("description",movie.getDescription());
                intent.putExtra("year",movie.getYear());
                intent.putExtra("image",Integer.toString(movie.getImage()));
                intent.putExtra("rating", movie.getRating());
                intent.putExtra("position",position);
                intent.putExtra("imageArray",movie.getImgs());
                intent.putExtra("actorsArray",movie.getActors());


                startActivityForResult(intent,0);

            }

            @Override
            public void onLongClick(View view, int position) {

                Movie movie = movieList.get(position);
//                Toast.makeText(getApplicationContext(), movie.getTitle() + " LONG!", Toast.LENGTH_SHORT).show();
                if(!movie.isWatched)
                {
                    ImageView eyea = (ImageView)view.findViewById(R.id.eye);
                    eyea.setVisibility(View.VISIBLE);
                    movie.watched();
                }
                else
                {
                    ImageView eyea = (ImageView)view.findViewById(R.id.eye);
                    eyea.setVisibility(View.GONE);
                    movie.notWatched();
                }
            }
        }));

        ItemTouchHelper.Callback callback =
                new SimpleItemTouchHelperCallback(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }



    private void prepareMovieData() {
        String actorSet[] = new String[10];
        actorSet[0]= "Brad Pitt";
        actorSet[1]= "Johnny Depp";
        actorSet[2]= "Arnold Schwarzenegger";
        actorSet[3]= "Sylvester Stallone";
        actorSet[4]= "Kevin Costner";
        actorSet[5]= "Robert Redford";
        actorSet[6]= "Leonardo DiCaprio";
        actorSet[7]= "Jack Nicholson";
        actorSet[8]= "Marlon Brando";
        actorSet[9]= "Clint Eastwood";

        int imageSet1[] = new int[9];
        imageSet1[0] = R.mipmap.scene10;
        imageSet1[1] = R.mipmap.scene9;
        imageSet1[2] = R.mipmap.scene7;
        imageSet1[3] = R.mipmap.scene6;
        imageSet1[4] = R.mipmap.scene10;
        imageSet1[5] = R.mipmap.scene1;
        imageSet1[6] = R.mipmap.actor4;
        imageSet1[7] = R.mipmap.actor7;
        imageSet1[8] = R.mipmap.actor3;

        int imageSet2[] = new int[9];
        imageSet2[0] = R.mipmap.scene6;
        imageSet2[1] = R.mipmap.scene1;
        imageSet2[2] = R.mipmap.scene2;
        imageSet2[3] = R.mipmap.scene8;
        imageSet2[4] = R.mipmap.scene7;
        imageSet2[5] = R.mipmap.scene10;
        imageSet2[6] = R.mipmap.actor0;
        imageSet2[7] = R.mipmap.actor4;
        imageSet2[8] = R.mipmap.actor2;
        int imageSet3[] = new int[9];
        imageSet3[0] = R.mipmap.scene10;
        imageSet3[1] = R.mipmap.scene6;
        imageSet3[2] = R.mipmap.scene9;
        imageSet3[3] = R.mipmap.scene2;
        imageSet3[4] = R.mipmap.scene5;
        imageSet3[5] = R.mipmap.scene7;
        imageSet3[6] = R.mipmap.actor1;
        imageSet3[7] = R.mipmap.actor6;
        imageSet3[8] = R.mipmap.actor9;

        int imageSet4[] = new int[9];
        imageSet4[0] = R.mipmap.scene4;
        imageSet4[1] = R.mipmap.scene10;
        imageSet4[2] = R.mipmap.scene2;
        imageSet4[3] = R.mipmap.scene7;
        imageSet4[4] = R.mipmap.scene1;
        imageSet4[5] = R.mipmap.scene3;
        imageSet4[6] = R.mipmap.actor4;
        imageSet4[7] = R.mipmap.actor8;
        imageSet4[8] = R.mipmap.actor1;

        int imageSet5[] = new int[9];
        imageSet5[0] = R.mipmap.scene6;
        imageSet5[1] = R.mipmap.scene10;
        imageSet5[2] = R.mipmap.scene2;
        imageSet5[3] = R.mipmap.scene9;
        imageSet5[4] = R.mipmap.scene1;
        imageSet5[5] = R.mipmap.scene7;
        imageSet5[6] = R.mipmap.actor5;
        imageSet5[7] = R.mipmap.actor7;
        imageSet5[8] = R.mipmap.actor3;

        int imageSet6[] = new int[9];
        imageSet6[0] = R.mipmap.scene3;
        imageSet6[1] = R.mipmap.scene7;
        imageSet6[2] = R.mipmap.scene9;
        imageSet6[3] = R.mipmap.scene10;
        imageSet6[4] = R.mipmap.scene2;
        imageSet6[5] = R.mipmap.scene4;
        imageSet6[6] = R.mipmap.actor6;
        imageSet6[7] = R.mipmap.actor0;
        imageSet6[8] = R.mipmap.actor2;


        String  actorSet1[] = new String[3];
        actorSet1[0]=actorSet[4];
        actorSet1[1]=actorSet[7];
        actorSet1[2]=actorSet[3];
        String actorSet2[] = new String[3];
        actorSet2[0]=actorSet[0];
        actorSet2[1]=actorSet[4];
        actorSet2[2]=actorSet[2];
        String actorSet3[] = new String[3];
        actorSet3[0]=actorSet[1];
        actorSet3[1]=actorSet[6];
        actorSet3[2]=actorSet[9];
        String actorSet4[] = new String[3];
        actorSet4[0]=actorSet[4];
        actorSet4[1]=actorSet[8];
        actorSet4[2]=actorSet[1];
        String actorSet5[] = new String[3];
        actorSet5[0]=actorSet[5];
        actorSet5[1]=actorSet[7];
        actorSet5[2]=actorSet[3];
        String actorSet6[] = new String[3];
        actorSet6[0]=actorSet[6];
        actorSet6[1]=actorSet[0];
        actorSet6[2]=actorSet[2];

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015",R.mipmap.one,"opis filmu 1",imageSet2, actorSet2);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family","2015",R.mipmap.two,"opis filmu 2",imageSet3, actorSet3);
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015",R.mipmap.three,"opis filmu 3",imageSet4, actorSet4);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015",R.mipmap.four,"opis filmu 4",imageSet5, actorSet5);
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015",R.mipmap.five,"opis filmu 5",imageSet6, actorSet6);
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015",R.mipmap.six,"opis filmu 6",imageSet1, actorSet1);
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009",R.mipmap.seven,"opis filmu 7",imageSet4, actorSet4);
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009",R.mipmap.eight,"opis filmu 8",imageSet3, actorSet3);
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014",R.mipmap.nine,"opis filmu 9",imageSet5, actorSet5);
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008",R.mipmap.ten,"opis filmu 10",imageSet1, actorSet1);
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986",R.mipmap.eleven,"opis filmu 11",imageSet1, actorSet1);
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000",R.mipmap.twelve,"opis filmu 12",imageSet6, actorSet6);
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985",R.mipmap.thirteen,"opis filmu 13",imageSet5, actorSet5);
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981",R.mipmap.fourteen,"opis filmu 14",imageSet4, actorSet4);
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965",R.mipmap.fifteen,"opis filmu 15",imageSet2, actorSet2);
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014",R.mipmap.sixteen,"opis filmu 16",imageSet3, actorSet3);
        movieList.add(movie);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
                if (resultCode == Activity.RESULT_OK) {
                    Float returnValue = data.getFloatExtra("rating",0);
                    movieList.get(lastClickedPosition).setRating(returnValue);

                }

    }
}
