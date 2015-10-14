// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.android.apps.syncslides.db;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.common.collect.Lists;

import java.util.List;

import io.v.android.apps.syncslides.R;
import io.v.android.apps.syncslides.model.Deck;
import io.v.android.apps.syncslides.model.Listener;
import io.v.android.apps.syncslides.model.Slide;

/**
 * A fake implementation of DB for manual testing purposes.
 */
public class FakeDB implements DB {
    private static final int[] SLIDEDRAWABLES = new int[]{
            R.drawable.slide1_thumb,
            R.drawable.slide2_thumb,
            R.drawable.slide3_thumb,
            R.drawable.slide4_thumb,
            R.drawable.slide5_thumb,
            R.drawable.slide6_thumb,
            R.drawable.slide7_thumb,
            R.drawable.slide8_thumb,
            R.drawable.slide9_thumb,
            R.drawable.slide10_thumb,
            R.drawable.slide11_thumb
    };
    private final String[] SLIDENOTES = {
            "This is the teaser slide. It should be memorable and descriptive of what your " +
                    "company is trying to do", "",
            "The bigger the pain, the better",
            "How do you solve this problem? How is it better or different from existing solutions?",
            "Demo the product", "", "[REDACTED]",
            "They may have tractor traction, but we still have the competitive advantage",
            "I'm not a businessman. I'm a business, man", "There is no 'i' on this slide",
            "Sqrt(all evil)"};
    private static final String TAG = "FakeDB";
    private static final int[] THUMBS = {
            R.drawable.thumb_deck1,
            R.drawable.thumb_deck2,
            R.drawable.thumb_deck3
    };
    private static final String[] TITLES = {"deck 1", "deck 2", "deck 3"};

    private final Handler mHandler;
    private final Bitmap[] mThumbs;
    private final Bitmap[] mSlideImages;
    private List<CurrentSlideListener> mCurrentSlideListeners;
    private Thread mCurrentSlideWatcher;

    public FakeDB(Context context) {
        mHandler = new Handler(Looper.getMainLooper());
        mThumbs = new Bitmap[THUMBS.length];
        for (int i = 0; i < THUMBS.length; i++) {
            mThumbs[i] = BitmapFactory.decodeResource(context.getResources(), THUMBS[i]);
        }
        mSlideImages = new Bitmap[SLIDEDRAWABLES.length];
        for (int i = 0; i < SLIDEDRAWABLES.length; i++) {
            mSlideImages[i] =
                    BitmapFactory.decodeResource(context.getResources(), SLIDEDRAWABLES[i]);
        }
        mCurrentSlideListeners = Lists.newArrayList();
        mCurrentSlideWatcher = new Thread(new Runnable() {
            @Override
            public void run() {
                watchCurrentSlide();
            }
        });
        mCurrentSlideWatcher.start();
    }

    private static class FakeDeck implements Deck {
        private final String mTitle;
        private final Bitmap mThumb;
        private final String mDeckId;

        FakeDeck(Bitmap thumb, String title, String deckId) {
            mThumb = thumb;
            mTitle = title;
            mDeckId = deckId;
        }

        @Override
        public Bitmap getThumb() {
            return mThumb;
        }

        @Override
        public String getTitle() {
            return mTitle;
        }

        @Override
        public String getId() {
            return mDeckId;
        }

        @Override
        public Status getStatus() {
            return Status.IDLE;
        }
    }

    private static class FakeSlide implements Slide {
        private final String mSlideNotes;
        private final Bitmap mSlideImage;

        FakeSlide(Bitmap slideImage, String slideNotes) {
            mSlideImage = slideImage;
            mSlideNotes = slideNotes;
        }

        @Override
        public Bitmap getImage() {
            return mSlideImage;
        }

        @Override
        public String getNotes() {
            return mSlideNotes;
        }
    }

    private static class FakeDeckList implements DBList {
        private final Bitmap[] mThumbs;
        private final String[] mTitles;
        private Listener mListener;

        private FakeDeckList(Bitmap[] thumbs, String[] titles) {
            mThumbs = thumbs;
            mTitles = titles;
        }

        @Override
        public int getItemCount() {
            return mThumbs.length;
        }

        @Override
        public Deck get(int i) {
            return new FakeDeck(mThumbs[i], mTitles[i], String.valueOf(i));
        }

        @Override
        public void setListener(Listener listener) {
            assert mListener == null;
            mListener = listener;
        }

        @Override
        public void discard() {
            // Nothing to do.
        }
    }

    private static class FakeSlideList implements DBList {
        private final Bitmap[] mSlideImages;
        private final String[] mSlideNotes;

        private FakeSlideList(Bitmap[] slideImages, String[] slideNotes) {
            mSlideImages = slideImages;
            mSlideNotes = slideNotes;
        }

        @Override
        public int getItemCount() {
            return mSlideImages.length;
        }

        @Override
        public Slide get(int i) {
            return new FakeSlide(mSlideImages[i], mSlideNotes[i]);
        }

        @Override
        public void setListener(Listener listener) {

        }

        @Override
        public void discard() {

        }
    }


    @Override
    public void init(Activity activity) {
        // Nothing to do.
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        // Nothing to do.
        return false;
    }

    @Override
    public void askQuestion(String identity) {
        //TODO(afergan): send identity to syncbase
    }

    @Override
    public void getQuestionerList(String deckId, final QuestionerListener callback) {
        final String[] questionerList = new String[]{
                "Audience member #1", "Audience member #2", "Audience member #3"};
        // Run the callback asynchronously on the UI thread.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onChange(questionerList);
            }
        });
    }

    @Override
    public DBList<Deck> getDecks() {
        return new FakeDeckList(mThumbs, TITLES);
    }

    @Override
    public DBList<Slide> getSlides(String deckId) {
        // Always return the same set of slides no matter which deck was requested.
        return new FakeSlideList(mSlideImages, SLIDENOTES);
    }

    @Override
    public void createPresentation(String deckId, final Callback<CreatePresentationResult> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.done(new CreatePresentationResult("fakePresentationId", "sgname"));
            }
        });
    }

    @Override
    public void addCurrentSlideListener(CurrentSlideListener listener) {
        mCurrentSlideListeners.add(listener);
        // TODO(kash): It would be better to fire off a notification of the current
        // slide right away.  That requires storing the current slide in some
        // place that is accessible to the UI thread.  Too much work for now.
    }

    @Override
    public void removeCurrentSlideListener(CurrentSlideListener listener) {
        mCurrentSlideListeners.remove(listener);
    }

    @Override
    public void getSlides(String deckId, final Callback<Slide[]> callback) {
        final Slide[] slides = new Slide[mSlideImages.length];
        for (int i = 0; i < mSlideImages.length; i++) {
            slides[i] = new FakeSlide(mSlideImages[i], SLIDENOTES[i]);
        }
        // Run the callback asynchronously on the UI thread.
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.done(slides);
            }
        });
    }

    private void watchCurrentSlide() {
        try {
            int currentSlide = 0;
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                currentSlide = (currentSlide + 1) % mSlideImages.length;
                final int finalCurrentSlide = currentSlide;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        for (CurrentSlideListener listener : mCurrentSlideListeners) {
                            listener.onChange(finalCurrentSlide);
                        }
                    }
                });
            }
        } catch (InterruptedException e) {
            Log.e(TAG, "Current Slide Watcher interrupted " + e);
        }
    }
}
