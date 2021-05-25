package com.yandex.mapkit.traffic;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class TrafficLevel implements Serializable {
    private TrafficColor color;
    private boolean color__is_initialized = false;
    private int level;
    private boolean level__is_initialized = false;
    private NativeObject nativeObject;

    public TrafficLevel() {
    }

    private native TrafficColor getColor__Native();

    private native int getLevel__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::traffic::TrafficLevel";
    }

    private native NativeObject init(TrafficColor trafficColor, int i);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized TrafficColor getColor() {
        if (!this.color__is_initialized) {
            this.color = getColor__Native();
            this.color__is_initialized = true;
        }
        return this.color;
    }

    public synchronized int getLevel() {
        if (!this.level__is_initialized) {
            this.level = getLevel__Native();
            this.level__is_initialized = true;
        }
        return this.level;
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

    public TrafficLevel(@NonNull TrafficColor trafficColor, int i) {
        if (trafficColor != null) {
            this.nativeObject = init(trafficColor, i);
            this.color = trafficColor;
            this.color__is_initialized = true;
            this.level = i;
            this.level__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"color\" cannot be null");
    }

    private TrafficLevel(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
