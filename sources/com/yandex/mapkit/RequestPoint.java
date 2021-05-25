package com.yandex.mapkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class RequestPoint implements Serializable {
    private NativeObject nativeObject;
    private Point point;
    private String pointContext;
    private boolean pointContext__is_initialized = false;
    private boolean point__is_initialized = false;
    private RequestPointType type;
    private boolean type__is_initialized = false;

    public RequestPoint() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::RequestPoint";
    }

    private native String getPointContext__Native();

    private native Point getPoint__Native();

    private native RequestPointType getType__Native();

    private native NativeObject init(Point point2, RequestPointType requestPointType, String str);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized Point getPoint() {
        if (!this.point__is_initialized) {
            this.point = getPoint__Native();
            this.point__is_initialized = true;
        }
        return this.point;
    }

    @Nullable
    public synchronized String getPointContext() {
        if (!this.pointContext__is_initialized) {
            this.pointContext = getPointContext__Native();
            this.pointContext__is_initialized = true;
        }
        return this.pointContext;
    }

    @NonNull
    public synchronized RequestPointType getType() {
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

    public RequestPoint(@NonNull Point point2, @NonNull RequestPointType requestPointType, @Nullable String str) {
        if (point2 == null) {
            throw new IllegalArgumentException("Required field \"point\" cannot be null");
        } else if (requestPointType != null) {
            this.nativeObject = init(point2, requestPointType, str);
            this.point = point2;
            this.point__is_initialized = true;
            this.type = requestPointType;
            this.type__is_initialized = true;
            this.pointContext = str;
            this.pointContext__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"type\" cannot be null");
        }
    }

    private RequestPoint(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
