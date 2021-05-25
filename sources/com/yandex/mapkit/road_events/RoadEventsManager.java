package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.road_events.EntrySession;
import com.yandex.mapkit.road_events.EventInfoSession;
import com.yandex.mapkit.road_events.RoadEventSession;
import com.yandex.mapkit.road_events.VoteSession;
public interface RoadEventsManager {
    @NonNull
    EntrySession addComment(@NonNull String str, @NonNull String str2, @NonNull EntrySession.EntryListener entryListener);

    @NonNull
    RoadEventSession addEvent(@NonNull EventType eventType, @NonNull String str, @NonNull Point point, @NonNull RoadEventSession.RoadEventListener roadEventListener);

    @NonNull
    FeedSession comments(@NonNull String str);

    @NonNull
    EventInfoSession requestEventInfo(@NonNull String str, @NonNull EventInfoSession.EventInfoListener eventInfoListener);

    @NonNull
    VoteSession voteDown(@NonNull String str, @NonNull VoteSession.VoteListener voteListener);

    @NonNull
    VoteSession voteUp(@NonNull String str, @NonNull VoteSession.VoteListener voteListener);
}
