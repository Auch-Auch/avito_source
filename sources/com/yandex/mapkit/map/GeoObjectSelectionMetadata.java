package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class GeoObjectSelectionMetadata implements Serializable {
    private String id;
    private boolean id__is_initialized = false;
    private String layerId;
    private boolean layerId__is_initialized = false;
    private NativeObject nativeObject;

    public GeoObjectSelectionMetadata() {
    }

    private native String getId__Native();

    private native String getLayerId__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::map::GeoObjectSelectionMetadata";
    }

    private native NativeObject init(String str, String str2);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized String getId() {
        if (!this.id__is_initialized) {
            this.id = getId__Native();
            this.id__is_initialized = true;
        }
        return this.id;
    }

    @NonNull
    public synchronized String getLayerId() {
        if (!this.layerId__is_initialized) {
            this.layerId = getLayerId__Native();
            this.layerId__is_initialized = true;
        }
        return this.layerId;
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

    public GeoObjectSelectionMetadata(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"id\" cannot be null");
        } else if (str2 != null) {
            this.nativeObject = init(str, str2);
            this.id = str;
            this.id__is_initialized = true;
            this.layerId = str2;
            this.layerId__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"layerId\" cannot be null");
        }
    }

    private GeoObjectSelectionMetadata(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
