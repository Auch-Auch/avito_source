package com.yandex.mapkit;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class RawTile implements Serializable {
    private String etag;
    private boolean etag__is_initialized = false;
    private NativeObject nativeObject;
    private byte[] rawData;
    private boolean rawData__is_initialized = false;
    private State state;
    private boolean state__is_initialized = false;
    private Version version;
    private boolean version__is_initialized = false;

    public enum State {
        OK,
        NOT_MODIFIED,
        ERROR
    }

    public RawTile() {
    }

    private native String getEtag__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::RawTile";
    }

    private native byte[] getRawData__Native();

    private native State getState__Native();

    private native Version getVersion__Native();

    private native NativeObject init(Version version2, String str, State state2, byte[] bArr);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized String getEtag() {
        if (!this.etag__is_initialized) {
            this.etag = getEtag__Native();
            this.etag__is_initialized = true;
        }
        return this.etag;
    }

    @NonNull
    public synchronized byte[] getRawData() {
        if (!this.rawData__is_initialized) {
            this.rawData = getRawData__Native();
            this.rawData__is_initialized = true;
        }
        return this.rawData;
    }

    @NonNull
    public synchronized State getState() {
        if (!this.state__is_initialized) {
            this.state = getState__Native();
            this.state__is_initialized = true;
        }
        return this.state;
    }

    @NonNull
    public synchronized Version getVersion() {
        if (!this.version__is_initialized) {
            this.version = getVersion__Native();
            this.version__is_initialized = true;
        }
        return this.version;
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

    public RawTile(@NonNull Version version2, @NonNull String str, @NonNull State state2, @NonNull byte[] bArr) {
        if (version2 == null) {
            throw new IllegalArgumentException("Required field \"version\" cannot be null");
        } else if (str == null) {
            throw new IllegalArgumentException("Required field \"etag\" cannot be null");
        } else if (state2 == null) {
            throw new IllegalArgumentException("Required field \"state\" cannot be null");
        } else if (bArr != null) {
            this.nativeObject = init(version2, str, state2, bArr);
            this.version = version2;
            this.version__is_initialized = true;
            this.etag = str;
            this.etag__is_initialized = true;
            this.state = state2;
            this.state__is_initialized = true;
            this.rawData = bArr;
            this.rawData__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"rawData\" cannot be null");
        }
    }

    private RawTile(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
