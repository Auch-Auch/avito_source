package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class GeoObjectTags implements Serializable {
    private NativeObject nativeObject;
    private List<String> tags;
    private boolean tags__is_initialized = false;

    public GeoObjectTags() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::map::GeoObjectTags";
    }

    private native List<String> getTags__Native();

    private native NativeObject init(List<String> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<String> getTags() {
        if (!this.tags__is_initialized) {
            this.tags = getTags__Native();
            this.tags__is_initialized = true;
        }
        return this.tags;
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

    public GeoObjectTags(@NonNull List<String> list) {
        if (list != null) {
            this.nativeObject = init(list);
            this.tags = list;
            this.tags__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"tags\" cannot be null");
    }

    private GeoObjectTags(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
