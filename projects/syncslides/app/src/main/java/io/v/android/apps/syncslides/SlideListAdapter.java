// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.android.apps.syncslides;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SlideListAdapter extends RecyclerView.Adapter<SlideListAdapter.ViewHolder>
        implements DB.Listener {
    private static final String TAG = "SlideListAdapter";
    private final DB.SlideList mSlides;
    private final RecyclerView mRecyclerView;

    public SlideListAdapter(RecyclerView recyclerView, DB db, String deckId) {
        mRecyclerView = recyclerView;
        mSlides = db.getSlides(deckId);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slide_card, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mRecyclerView.getChildAdapterPosition(v);
                PresentationActivity activity = (PresentationActivity)v.getContext();
                activity.jumpToSlide(position);
            }
        });
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        DB.Slide slide = mSlides.getSlide(i);
        holder.mNotes.setText(slide.getNotes());
        holder.mImage.setImageBitmap(slide.getImage());
    }

    @Override
    public int getItemCount() {
        return mSlides.getItemCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImage;
        public final TextView mNotes;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.slide_card_image);
            mNotes = (TextView) itemView.findViewById(R.id.slide_card_notes);
        }
    }
}