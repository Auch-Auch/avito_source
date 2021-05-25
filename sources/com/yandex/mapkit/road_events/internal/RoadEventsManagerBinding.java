package com.yandex.mapkit.road_events.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.road_events.EntrySession;
import com.yandex.mapkit.road_events.EventInfoSession;
import com.yandex.mapkit.road_events.EventType;
import com.yandex.mapkit.road_events.FeedSession;
import com.yandex.mapkit.road_events.RoadEventSession;
import com.yandex.mapkit.road_events.RoadEventsManager;
import com.yandex.mapkit.road_events.VoteSession;
import com.yandex.runtime.NativeObject;
public class RoadEventsManagerBinding implements RoadEventsManager {
    private final NativeObject nativeObject;

    public RoadEventsManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.road_events.RoadEventsManager
    @NonNull
    public native EntrySession addComment(@NonNull String str, @NonNull String str2, @NonNull EntrySession.EntryListener entryListener);

    @Override // com.yandex.mapkit.road_events.RoadEventsManager
    @NonNull
    public native RoadEventSession addEvent(@NonNull EventType eventType, @NonNull String str, @NonNull Point point, @NonNull RoadEventSession.RoadEventListener roadEventListener);

    @Override // com.yandex.mapkit.road_events.RoadEventsManager
    @NonNull
    public native FeedSession comments(@NonNull String str);

    @Override // com.yandex.mapkit.road_events.RoadEventsManager
    @NonNull
    public native EventInfoSession requestEventInfo(@NonNull String str, @NonNull EventInfoSession.EventInfoListener eventInfoListener);

    @Override // com.yandex.mapkit.road_events.RoadEventsManager
    @NonNull
    public native VoteSession voteDown(@NonNull String str, @NonNull VoteSession.VoteListener voteListener);

    @Override // com.yandex.mapkit.road_events.RoadEventsManager
    @NonNull
    public native VoteSession voteUp(@NonNull String str, @NonNull VoteSession.VoteListener voteListener);
}
