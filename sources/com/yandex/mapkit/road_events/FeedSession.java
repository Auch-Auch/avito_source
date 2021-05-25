package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface FeedSession {

    public interface FeedListener {
        void onFeedError(@NonNull Error error);

        void onFeedReceived(@NonNull Feed feed);
    }

    void cancel();

    void fetchNextPage(@NonNull FeedListener feedListener);

    boolean hasNextPage();
}
