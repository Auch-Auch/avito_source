package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.Map;
public class UserData implements Serializable {
    private Map<String, String> data;
    private boolean data__is_initialized = false;
    private NativeObject nativeObject;

    public UserData() {
    }

    private native Map<String, String> getData__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::map::UserData";
    }

    private native NativeObject init(Map<String, String> map);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized Map<String, String> getData() {
        if (!this.data__is_initialized) {
            this.data = getData__Native();
            this.data__is_initialized = true;
        }
        return this.data;
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

    public UserData(@NonNull Map<String, String> map) {
        if (map != null) {
            this.nativeObject = init(map);
            this.data = map;
            this.data__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"data\" cannot be null");
    }

    private UserData(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
