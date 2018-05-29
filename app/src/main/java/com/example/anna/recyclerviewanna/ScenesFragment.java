package com.example.anna.recyclerviewanna;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ScenesFragment extends Fragment
{
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_scenes, container, false);

        image1 = (ImageView) view.findViewById(R.id.img1);
        image2 = (ImageView) view.findViewById(R.id.img2);
        image3 = (ImageView) view.findViewById(R.id.img3);
        image4 = (ImageView) view.findViewById(R.id.img4);
        image5 = (ImageView) view.findViewById(R.id.img5);
        image6 = (ImageView) view.findViewById(R.id.img6);
        setImages();

        return view;
    }

    private void setImages() {
        MovieDetailed activity = (MovieDetailed) getActivity();
        int images[] = activity.getImages();
        image1.setImageDrawable(getResources().getDrawable(images[0]));
        image2.setImageDrawable(getResources().getDrawable(images[1]));
        image3.setImageDrawable(getResources().getDrawable(images[2]));
        image4.setImageDrawable(getResources().getDrawable(images[3]));
        image5.setImageDrawable(getResources().getDrawable(images[4]));
        image6.setImageDrawable(getResources().getDrawable(images[5]));
    }
}