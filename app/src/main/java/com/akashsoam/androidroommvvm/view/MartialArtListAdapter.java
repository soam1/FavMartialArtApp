package com.akashsoam.androidroommvvm.view;

import android.os.PowerManager;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.akashsoam.androidroommvvm.room_database.MartialArt;

public class MartialArtListAdapter extends ListAdapter<MartialArt, MartialArtViewHolder> {
    protected MartialArtListAdapter(@NonNull DiffUtil.ItemCallback<MartialArt> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MartialArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MartialArtViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MartialArtViewHolder holder, int position) {
        MartialArt currentMartialArtObject = getItem(position);
        holder.bind(currentMartialArtObject.getmFavMartialArt());
    }

    public static class MartialArtDiff extends DiffUtil.ItemCallback<MartialArt> {
        @Override
        public boolean areContentsTheSame(@NonNull MartialArt oldItem, @NonNull MartialArt newItem) {
            return oldItem.getmFavMartialArt().equalsIgnoreCase(newItem.getmFavMartialArt());
        }

        @Override
        public boolean areItemsTheSame(@NonNull MartialArt oldItem, @NonNull MartialArt newItem) {
            return oldItem == newItem;
        }
    }
}
