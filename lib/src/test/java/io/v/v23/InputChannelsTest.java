// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.v23;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import io.v.impl.google.ListenableFutureCallback;
import io.v.v23.rpc.Callback;
import io.v.v23.verror.EndOfFileException;
import io.v.v23.verror.VException;

import static com.google.common.truth.Truth.assertThat;
import static io.v.v23.VFutures.sync;

/**
 * Tests for static methods in {@link InputChannels} class.
 */
public class InputChannelsTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        V.init();
    }

    public void testTransform() throws Exception {
        {
            InputChannel<Long> chan = InputChannels.transform(
                    new ListInputChannel<>(null, 1, 2, 3, 4, 5),
                    new InputChannels.TransformFunction<Integer, Long>() {
                        @Override
                        public Long apply(Integer from) throws VException {
                            return (long) from + 1;
                        }
                    });
            VIterable<Long> it = InputChannels.asIterable(chan);
            assertThat(it).containsExactly(2l, 3l, 4l, 5l, 6l);
            assertThat(it.error()).isNull();
        }
        {
            VException error = new VException("boo");
            InputChannel<Long> chan = InputChannels.transform(
                    new ListInputChannel<>(error, 1, 2, 3, 4, 5),
                    new InputChannels.TransformFunction<Integer, Long>() {
                        @Override
                        public Long apply(Integer from) throws VException {
                            return (long) from + 1;
                        }
                    });
            VIterable<Long> it = InputChannels.asIterable(chan);
            assertThat(it).containsExactly(2l, 3l, 4l, 5l, 6l);
            assertThat(it.error()).isEqualTo(error);
        }
        {
            final VException error = new VException("boo");
            InputChannel<Long> chan = InputChannels.transform(
                    new ListInputChannel<>(error, 1, 2, 3, 4, 5),
                    new InputChannels.TransformFunction<Integer, Long>() {
                        @Override
                        public Long apply(Integer from) throws VException {
                            if (from > 3) {
                                throw error;
                            }
                            return (long) from + 1;
                        }
                    });
            VIterable<Long> it = InputChannels.asIterable(chan);
            assertThat(it).containsExactly(2l, 3l, 4l);
            assertThat(it.error()).isEqualTo(error);
        }
        {
            InputChannel<Integer> chan = InputChannels.transform(
                    new ListInputChannel<>(null, 1, 2, 3, 4, 5),
                    new InputChannels.TransformFunction<Integer, Integer>() {
                        @Override
                        public Integer apply(Integer from) throws VException {
                            return from == 3 ? null : from;
                        }
                    });
            VIterable<Integer> it = InputChannels.asIterable(chan);
            assertThat(it).containsExactly(1, 2, 4, 5);
            assertThat(it.error()).isNull();
        }
        {
            // Make sure a channel with lots of elements is handled correctly.
            final int numElems = 10000;
            Integer[] elems = new Integer[numElems];
            for (int i = 0; i < numElems; ++i) {
                elems[i] = i;
            }
            InputChannel<Integer> chan = InputChannels.transform(
                    new ListInputChannel<>(null, elems),
                    new InputChannels.TransformFunction<Integer, Integer>() {
                        @Override
                        public Integer apply(Integer from) throws VException {
                            return from;
                        }
                    });
            VIterable<Integer> it = InputChannels.asIterable(chan);
            assertThat(it).containsExactlyElementsIn(Arrays.asList(elems));
            assertThat(it.error()).isNull();
        }
    }

    public void testAsList() throws Exception {
        {
            InputChannel<Integer> chan = new ListInputChannel<>(null, 1, 2, 3, 4, 5);
            assertThat(sync(InputChannels.asList(chan))).containsExactly(1, 2, 3, 4, 5);
        }
        {
            VException error = new VException("boo");
            InputChannel<Integer> chan = new ListInputChannel<>(error, 1, 2, 3, 4, 5);
            try {
                sync(InputChannels.asList(chan));
                fail("Expected InputChannels.asList() to fail");
            } catch (VException e) {
                assertThat(e).isEqualTo(error);
            }
        }
        {
            final VException error = new VException("boo");
            InputChannel<Integer> chan = InputChannels.transform(
                    new ListInputChannel<>(error, 1, 2, 3, 4, 5),
                    new InputChannels.TransformFunction<Integer, Integer>() {
                        @Override
                        public Integer apply(Integer from) throws VException {
                            if (from > 2) {
                                throw error;
                            }
                            return from;
                        }
                    });
            try {
                sync(InputChannels.asList(chan));
                fail("Expected InputChannels.asList() to fail");
            } catch (VException e) {
                assertThat(e).isEqualTo(error);
            }
        }
        {
            // Make sure a channel with lots of elements is handled correctly.
            final int numElems = 10000;
            Integer[] elems = new Integer[numElems];
            for (int i = 0; i < numElems; ++i) {
                elems[i] = i;
            }
            InputChannel<Integer> chan = new ListInputChannel<>(null, elems);
            assertThat(sync(InputChannels.asList(chan))).isEqualTo(Arrays.asList(elems));
        }
    }

    public void testWithCallback() throws Exception {
        {
            InputChannel<Integer> chan = new ListInputChannel<>(null, 1, 2, 3, 4, 5);
            final AtomicInteger sum = new AtomicInteger(0);
            sync(InputChannels.withCallback(chan, new Callback<Integer>() {
                @Override
                public void onSuccess(Integer result) {
                    sum.addAndGet(result);
                }
                @Override
                public void onFailure(VException error) {
                    fail("Should never be called.");
                }
            }));
            assertThat(sum.get()).isEqualTo(15);
        }
        {
            final VException error = new VException("boo");
            InputChannel<Integer> chan = new ListInputChannel<>(error, 1, 2, 3, 4, 5);
            final AtomicInteger sum = new AtomicInteger(0);
            try {
                sync(InputChannels.withCallback(chan, new Callback<Integer>() {
                    @Override
                    public void onSuccess(Integer result) {
                        sum.addAndGet(result);
                    }
                    @Override
                    public void onFailure(VException e) {
                        fail("Should never be called.");
                    }
                }));
                fail("Expected InputChannels.withCallback() to fail");
            } catch (VException e) {
                assertThat(e).isEqualTo(error);
            }
            assertThat(sum.get()).isEqualTo(15);
        }
        {
            final int numElems = 10000;
            Integer[] elems = new Integer[numElems];
            for (int i = 0; i < numElems; ++i) {
                elems[i] = i;
            }
            InputChannel<Integer> chan = new ListInputChannel<>(null, elems);
            final AtomicInteger sum = new AtomicInteger(0);
            sync(InputChannels.withCallback(chan, new Callback<Integer>() {
                @Override
                public void onSuccess(Integer result) {
                    sum.addAndGet(result);
                }
                @Override
                public void onFailure(VException error) {
                    fail("Callback error: " + error);
                }
            }));
            assertThat(sum.get()).isEqualTo(numElems * (numElems - 1) / 2);
        }
    }

    public void testAsDone() throws Exception {
        {
            InputChannel<Integer> chan = new ListInputChannel<>(null, 1, 2, 3, 4, 5);
            sync(InputChannels.asDone(chan));
        }
        {
            VException error = new VException("boo");
            InputChannel<Integer> chan = new ListInputChannel<>(error, 1, 2, 3, 4, 5);
            try {
                sync(InputChannels.asDone(chan));
                fail("Expected InputChannels.asDone() to fail");
            } catch (VException e) {
                assertThat(e).isEqualTo(error);
            }
        }
        {
            // Make sure a channel with lots of elements is handled correctly.
            final int numElems = 10000;
            Integer[] elems = new Integer[numElems];
            for (int i = 0; i < numElems; ++i) {
                elems[i] = i;
            }
            InputChannel<Integer> chan = new ListInputChannel<>(null, elems);
            sync(InputChannels.asDone(chan));
        }
    }

    private static class ListInputChannel<T> implements InputChannel<T> {
        private static ExecutorService pool = Executors.newSingleThreadExecutor();
        private final List<T> input;
        private int index;
        private final VException error;

        @SafeVarargs
        ListInputChannel(VException error, T... elems) {
            this.input = Arrays.asList(elems);
            this.index = 0;
            this.error = error;
        }
        @Override
        public ListenableFuture<T> recv() {
            if (index >= input.size()) {
                return Futures.immediateFailedFuture(
                        error != null ? error : new EndOfFileException(null));
            }
            // We run the callback in a separate thread to make sure it's handled correctly.
            final ListenableFutureCallback<T> callback = new ListenableFutureCallback<>();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess(input.get(index++));
                }
            });
            return callback.getFuture();
        }
    }
}