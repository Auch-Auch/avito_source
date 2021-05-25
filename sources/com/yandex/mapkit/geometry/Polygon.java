package com.yandex.mapkit.geometry;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class Polygon implements Serializable {
    private List<LinearRing> innerRings;
    private boolean innerRings__is_initialized = false;
    private NativeObject nativeObject;
    private LinearRing outerRing;
    private boolean outerRing__is_initialized = false;

    public Polygon() {
    }

    private native List<LinearRing> getInnerRings__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::geometry::Polygon";
    }

    private native LinearRing getOuterRing__Native();

    private native NativeObject init(LinearRing linearRing, List<LinearRing> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<LinearRing> getInnerRings() {
        if (!this.innerRings__is_initialized) {
            this.innerRings = getInnerRings__Native();
            this.innerRings__is_initialized = true;
        }
        return this.innerRings;
    }

    @NonNull
    public synchronized LinearRing getOuterRing() {
        if (!this.outerRing__is_initialized) {
            this.outerRing = getOuterRing__Native();
            this.outerRing__is_initialized = true;
        }
        return this.outerRing;
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

    public Polygon(@NonNull LinearRing linearRing, @NonNull List<LinearRing> list) {
        if (linearRing == null) {
            throw new IllegalArgumentException("Required field \"outerRing\" cannot be null");
        } else if (list != null) {
            this.nativeObject = init(linearRing, list);
            this.outerRing = linearRing;
            this.outerRing__is_initialized = true;
            this.innerRings = list;
            this.innerRings__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"innerRings\" cannot be null");
        }
    }

    private Polygon(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
