package com.yandex.mapkit;

import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class TestStruct implements Serializable {
    private NativeObject nativeObject;
    private int value;
    private boolean value__is_initialized = false;

    public TestStruct() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::TestStruct";
    }

    private native int getValue__Native();

    private native NativeObject init(int i);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    public synchronized int getValue() {
        if (!this.value__is_initialized) {
            this.value = getValue__Native();
            this.value__is_initialized = true;
        }
        return this.value;
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

    public TestStruct(int i) {
        this.nativeObject = init(i);
        this.value = i;
        this.value__is_initialized = true;
    }

    private TestStruct(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
