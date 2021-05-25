package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.Attribution;
import com.yandex.mapkit.Time;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class RoadEventMetadata implements Serializable {
    private Attribution.Author author;
    private boolean author__is_initialized = false;
    private Integer commentsCount;
    private boolean commentsCount__is_initialized = false;
    private String description;
    private boolean description__is_initialized = false;
    private String eventId;
    private boolean eventId__is_initialized = false;
    private Time modificationTime;
    private boolean modificationTime__is_initialized = false;
    private NativeObject nativeObject;
    private TimePeriod timePeriod;
    private boolean timePeriod__is_initialized = false;
    private List<EventType> types;
    private boolean types__is_initialized = false;

    public RoadEventMetadata() {
    }

    private native Attribution.Author getAuthor__Native();

    private native Integer getCommentsCount__Native();

    private native String getDescription__Native();

    private native String getEventId__Native();

    private native Time getModificationTime__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::road_events::RoadEventMetadata";
    }

    private native TimePeriod getTimePeriod__Native();

    private native List<EventType> getTypes__Native();

    private native NativeObject init(String str, String str2, List<EventType> list, TimePeriod timePeriod2, Time time, Integer num, Attribution.Author author2);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @Nullable
    public synchronized Attribution.Author getAuthor() {
        if (!this.author__is_initialized) {
            this.author = getAuthor__Native();
            this.author__is_initialized = true;
        }
        return this.author;
    }

    @Nullable
    public synchronized Integer getCommentsCount() {
        if (!this.commentsCount__is_initialized) {
            this.commentsCount = getCommentsCount__Native();
            this.commentsCount__is_initialized = true;
        }
        return this.commentsCount;
    }

    @Nullable
    public synchronized String getDescription() {
        if (!this.description__is_initialized) {
            this.description = getDescription__Native();
            this.description__is_initialized = true;
        }
        return this.description;
    }

    @NonNull
    public synchronized String getEventId() {
        if (!this.eventId__is_initialized) {
            this.eventId = getEventId__Native();
            this.eventId__is_initialized = true;
        }
        return this.eventId;
    }

    @NonNull
    public synchronized Time getModificationTime() {
        if (!this.modificationTime__is_initialized) {
            this.modificationTime = getModificationTime__Native();
            this.modificationTime__is_initialized = true;
        }
        return this.modificationTime;
    }

    @Nullable
    public synchronized TimePeriod getTimePeriod() {
        if (!this.timePeriod__is_initialized) {
            this.timePeriod = getTimePeriod__Native();
            this.timePeriod__is_initialized = true;
        }
        return this.timePeriod;
    }

    @NonNull
    public synchronized List<EventType> getTypes() {
        if (!this.types__is_initialized) {
            this.types = getTypes__Native();
            this.types__is_initialized = true;
        }
        return this.types;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        if (archive.isReader()) {
            this.nativeObject = loadNative(archive.add((ByteBuffer) null));
            return;
        }
        ByteBuffer.allocateDirect(10);
        archive.add(saveNative());
    }

    public RoadEventMetadata(@NonNull String str, @Nullable String str2, @NonNull List<EventType> list, @Nullable TimePeriod timePeriod2, @NonNull Time time, @Nullable Integer num, @Nullable Attribution.Author author2) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"eventId\" cannot be null");
        } else if (list == null) {
            throw new IllegalArgumentException("Required field \"types\" cannot be null");
        } else if (time != null) {
            this.nativeObject = init(str, str2, list, timePeriod2, time, num, author2);
            this.eventId = str;
            this.eventId__is_initialized = true;
            this.description = str2;
            this.description__is_initialized = true;
            this.types = list;
            this.types__is_initialized = true;
            this.timePeriod = timePeriod2;
            this.timePeriod__is_initialized = true;
            this.modificationTime = time;
            this.modificationTime__is_initialized = true;
            this.commentsCount = num;
            this.commentsCount__is_initialized = true;
            this.author = author2;
            this.author__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"modificationTime\" cannot be null");
        }
    }

    private RoadEventMetadata(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
