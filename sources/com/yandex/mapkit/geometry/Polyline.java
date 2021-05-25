package com.yandex.mapkit.geometry;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class Polyline implements Serializable {
    private NativeObject nativeObject;
    private List<Point> points;
    private boolean points__is_initialized = false;

    public Polyline() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::geometry::Polyline";
    }

    private native List<Point> getPoints__Native();

    private native NativeObject init(List<Point> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<Point> getPoints() {
        if (!this.points__is_initialized) {
            this.points = getPoints__Native();
            this.points__is_initialized = true;
        }
        return this.points;
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

    public Polyline(@NonNull List<Point> list) {
        if (list != null) {
            this.nativeObject = init(list);
            this.points = list;
            this.points__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"points\" cannot be null");
    }

    private Polyline(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
