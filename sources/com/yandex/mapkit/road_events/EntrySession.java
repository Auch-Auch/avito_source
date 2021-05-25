package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface EntrySession {

    public interface EntryListener {
        void onEntryError(@NonNull Error error);

        void onEntryReceived(@NonNull Entry entry);
    }

    void cancel();

    void retry(@NonNull EntryListener entryListener);
}
