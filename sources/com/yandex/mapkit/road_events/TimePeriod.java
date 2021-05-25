package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.Time;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class TimePeriod implements Serializable {
    private Time begin;
    private Time end;

    public TimePeriod(@NonNull Time time, @Nullable Time time2) {
        if (time != null) {
            this.begin = time;
            this.end = time2;
            return;
        }
        throw new IllegalArgumentException("Required field \"begin\" cannot be null");
    }

    @NonNull
    public Time getBegin() {
        return this.begin;
    }

    @Nullable
    public Time getEnd() {
        return this.end;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.begin = (Time) archive.add((Archive) this.begin, false, (Class<Archive>) Time.class);
        this.end = (Time) archive.add((Archive) this.end, true, (Class<Archive>) Time.class);
    }

    public TimePeriod() {
    }
}
