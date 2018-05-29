package com.example.anna.recyclerviewanna;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.List;

public interface ItemTouchHelperAdapter
{

    void onItemDismiss(int position);
    boolean isWatched(int position);
    int listLength();
}
