package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface VoteSession {

    public interface VoteListener {
        void onVoteCompleted();

        void onVoteError(@NonNull Error error);
    }

    void cancel();

    void retry(@NonNull VoteListener voteListener);
}
