package com.example.anna.recyclerviewanna;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> implements ItemTouchHelperAdapter
{


        private List<Movie> moviesList;
        public int rowType= 1;
    private Context context;


    public MoviesAdapter(List<Movie> moviesList) {this.moviesList = moviesList;}


        public class MyViewHolder extends RecyclerView.ViewHolder{
            public TextView title, year, genre;
            public ImageView img, eyeView;


            public MyViewHolder(View view)
            {
                super(view);
                title = (TextView) view.findViewById(R.id.title);
                genre = (TextView) view.findViewById(R.id.genre);
                year = (TextView) view.findViewById(R.id.year);
                img = (ImageView) view.findViewById(R.id.obraz);
                eyeView = (ImageView)view.findViewById(R.id.eye);

            }

        }



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView;
            if(rowType == 1)
            {
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_list_row, parent, false);
            }
            else
            {
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_list_rowb, parent, false);
            }


            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            Movie movie = moviesList.get(position);
            holder.title.setText(movie.getTitle());
            holder.genre.setText(movie.getGenre());
            holder.year.setText(movie.getYear());
            holder.img.setImageResource(movie.getImage());
            holder.eyeView.setImageResource(R.mipmap.eye_view);
            if(movie.isWatched)
                holder.eyeView.setVisibility(View.VISIBLE);
            else
                holder.eyeView.setVisibility(View.GONE);
            rowType = getItemViewType(position);
        }

        @Override
        public int getItemViewType(int position)
        {
            if (position%2 != 0)
                return 1;
            return 0;
        }

        @Override
        public int getItemCount() {
            return moviesList.size();
        }


    @Override
    public void onItemDismiss(int position)
    {
        moviesList.remove(position);
        notifyItemRangeRemoved(position,moviesList.size());
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @Override
    public boolean isWatched(int position)
    {
        if(moviesList.get(position).isWatched)
            return true;
        return false;
    }

    @Override
    public int listLength() {
        return moviesList.size();
    }


}

