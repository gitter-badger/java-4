// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.android.apps.syncslides;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.v.android.apps.syncslides.db.DB;
import io.v.android.apps.syncslides.model.Role;

public class SlideListFragment extends Fragment {
    private static final String DECK_ID_KEY = "deck_id";
    private static final String ROLE_KEY = "role";
    private static final String SLIDE_LIST_TITLE = "Pitch deck";
    private static final String TAG = "SlideList";

    /**
     * onCreate's savedInstanceState is always null when this fragment is restored from
     * the back stack. http://stackoverflow.com/a/11353470  Therefore, we need to keep
     * track of whether this fragment has already been initialized -- we don't want to
     * overwrite any changes.
     */
    private boolean mInitialized = false;
    private String mDeckId;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SlideListAdapter mAdapter;
    private Role mRole;

    /**
     * Returns a new instance of this fragment for the given deck.
     */
    public static SlideListFragment newInstance(String deckId, Role role) {
        SlideListFragment fragment = new SlideListFragment();
        Bundle args = new Bundle();
        args.putString(DECK_ID_KEY, deckId);
        args.putSerializable(ROLE_KEY, role);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // See comment at the top of fragment_slide_list.xml.
        ((PresentationActivity) getActivity()).setUiImmersive(false);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_slide_list, container, false);

        if (!mInitialized) {
            mInitialized = true;

            Bundle bundle = savedInstanceState;
            if (bundle == null) {
                bundle = getArguments();
            }
            mDeckId = bundle.getString(DECK_ID_KEY);
            Log.d(TAG, "onCreateView - Got deckId = " + mDeckId);

            mRole = (Role) bundle.get(ROLE_KEY);
        }

        // Clicking on the fab starts the presentation.
        final FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(
                R.id.play_presentation_fab);
        if (mRole == Role.BROWSER) {
            fab.setVisibility(View.VISIBLE);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRole = Role.PRESENTER;
                fab.setVisibility(View.INVISIBLE);
                PresentationActivity activity = (PresentationActivity) v.getContext();
                activity.startPresentation();
            }
        });

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.slide_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(container.getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        getActivity().setTitle(SLIDE_LIST_TITLE);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        DB db = DB.Singleton.get(getActivity().getApplicationContext());
        mAdapter = new SlideListAdapter(mRecyclerView, db, mDeckId);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stop();
        mAdapter = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DECK_ID_KEY, mDeckId);
        outState.putSerializable(ROLE_KEY, mRole);
    }
}
