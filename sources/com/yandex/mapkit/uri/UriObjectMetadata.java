package com.yandex.mapkit.uri;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class UriObjectMetadata implements Serializable {
    private NativeObject nativeObject;
    private List<Uri> uris;
    private boolean uris__is_initialized = false;

    public UriObjectMetadata() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::uri::UriObjectMetadata";
    }

    private native List<Uri> getUris__Native();

    private native NativeObject init(List<Uri> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<Uri> getUris() {
        if (!this.uris__is_initialized) {
            this.uris = getUris__Native();
            this.uris__is_initialized = true;
        }
        return this.uris;
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

    public UriObjectMetadata(@NonNull List<Uri> list) {
        if (list != null) {
            this.nativeObject = init(list);
            this.uris = list;
            this.uris__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"uris\" cannot be null");
    }

    private UriObjectMetadata(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
