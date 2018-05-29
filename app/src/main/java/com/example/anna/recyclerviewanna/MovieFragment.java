package com.example.anna.recyclerviewanna;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieFragment extends Fragment
{
    RatingBar ratingBar;
    TextView textDescription;
    ImageView imageViewDescription;
    TextView titleDescription;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater
                .inflate(R.layout.fragment_movie_descritpion, container, false);


        ratingBar= (RatingBar) view.findViewById(R.id.ratingBar);
        textDescription= (TextView) view.findViewById(R.id.description);
        imageViewDescription= (ImageView) view.findViewById(R.id.obraz);
        titleDescription= (TextView) view.findViewById(R.id.title);
        addListenerOnRatingBar(view);


        MovieDetailed activity = (MovieDetailed) getActivity();
        titleDescription.setText(activity.getMovieData());
        imageViewDescription.setImageResource(Integer.parseInt(activity.getMovieImg()));
        textDescription.setText(activity.getMovieDescription());
        ratingBar.setRating(activity.getRating());

        imageViewDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle outBundle1 = new Bundle();
                Bundle outBundle2 = new Bundle();
                outBundle2.putStringArray(getResources().getString(R.string.actorsArr), getArguments().getStringArray(getResources().getString(R.string.actorsArr)));
                outBundle2.putIntArray(getResources().getString(R.string.imgsArr), getArguments().getIntArray(getResources().getString(R.string.imgsArr)));
                outBundle1.putIntArray(getResources().getString(R.string.imgsArr), getArguments().getIntArray(getResources().getString(R.string.imgsArr)));
                ScenesFragment imagesFragment = new ScenesFragment();
                ActorsFragment actorFragment = new ActorsFragment();
                imagesFragment.setArguments(outBundle1);
                actorFragment.setArguments(outBundle2);
                actorFragment.setArguments(outBundle2);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, imagesFragment).addToBackStack("tag");
                fragmentTransaction.add(R.id.fragment_container2, actorFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    public void addListenerOnRatingBar(View v) {

        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                if (fromUser)
                {
                    MovieDetailed activity = (MovieDetailed) getActivity();
                    activity.settingRating(rating);
                }

            }
        });
    }


}
