package com.yandex.mapkit.traffic;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.EventType;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class RoadEventTapInfo implements Serializable {
    private String descriptionText;
    private boolean descriptionText__is_initialized = false;
    private String id;
    private boolean id__is_initialized = false;
    private NativeObject nativeObject;
    private EventType type;
    private boolean type__is_initialized = false;

    public RoadEventTapInfo() {
    }

    private native String getDescriptionText__Native();

    private native String getId__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::traffic::RoadEventTapInfo";
    }

    private native EventType getType__Native();

    private native NativeObject init(String str, String str2, EventType eventType);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized String getDescriptionText() {
        if (!this.descriptionText__is_initialized) {
            this.descriptionText = getDescriptionText__Native();
            this.descriptionText__is_initialized = true;
        }
        return this.descriptionText;
    }

    @NonNull
    public synchronized String getId() {
        if (!this.id__is_initialized) {
            this.id = getId__Native();
            this.id__is_initialized = true;
        }
        return this.id;
    }

    @NonNull
    public synchronized EventType getType() {
        if (!this.type__is_initialized) {
            this.type = getType__Native();
            this.type__is_initialized = true;
        }
        return this.type;
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

    public RoadEventTapInfo(@NonNull String str, @NonNull String str2, @NonNull EventType eventType) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"id\" cannot be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Required field \"descriptionText\" cannot be null");
        } else if (eventType != null) {
            this.nativeObject = init(str, str2, eventType);
            this.id = str;
            this.id__is_initialized = true;
            this.descriptionText = str2;
            this.descriptionText__is_initialized = true;
            this.type = eventType;
            this.type__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"type\" cannot be null");
        }
    }

    private RoadEventTapInfo(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
