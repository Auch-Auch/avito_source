package com.yandex.mapkit.geometry;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class MultiPolygon implements Serializable {
    private NativeObject nativeObject;
    private List<Polygon> polygons;
    private boolean polygons__is_initialized = false;

    public MultiPolygon() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::geometry::MultiPolygon";
    }

    private native List<Polygon> getPolygons__Native();

    private native NativeObject init(List<Polygon> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<Polygon> getPolygons() {
        if (!this.polygons__is_initialized) {
            this.polygons = getPolygons__Native();
            this.polygons__is_initialized = true;
        }
        return this.polygons;
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

    public MultiPolygon(@NonNull List<Polygon> list) {
        if (list != null) {
            this.nativeObject = init(list);
            this.polygons = list;
            this.polygons__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"polygons\" cannot be null");
    }

    private MultiPolygon(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
