package com.yandex.runtime.internal.test_support;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class TestStructure implements Serializable {
    private boolean b;
    private boolean b__is_initialized = false;
    private List<Integer> intVector;
    private boolean intVector__is_initialized = false;
    private long interval;
    private boolean interval__is_initialized = false;
    private NativeObject nativeObject;
    private String optionalText;
    private boolean optionalText__is_initialized = false;
    private String text;
    private boolean text__is_initialized = false;
    private long timestamp;
    private boolean timestamp__is_initialized = false;

    public TestStructure() {
    }

    private native boolean getB__Native();

    private native List<Integer> getIntVector__Native();

    private native long getInterval__Native();

    public static String getNativeName() {
        return "yandex::maps::runtime::internal::test_support::TestStructure";
    }

    private native String getOptionalText__Native();

    private native String getText__Native();

    private native long getTimestamp__Native();

    private native NativeObject init(boolean z, String str, String str2, List<Integer> list, long j, long j2);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    public synchronized boolean getB() {
        if (!this.b__is_initialized) {
            this.b = getB__Native();
            this.b__is_initialized = true;
        }
        return this.b;
    }

    @NonNull
    public synchronized List<Integer> getIntVector() {
        if (!this.intVector__is_initialized) {
            this.intVector = getIntVector__Native();
            this.intVector__is_initialized = true;
        }
        return this.intVector;
    }

    public synchronized long getInterval() {
        if (!this.interval__is_initialized) {
            this.interval = getInterval__Native();
            this.interval__is_initialized = true;
        }
        return this.interval;
    }

    @Nullable
    public synchronized String getOptionalText() {
        if (!this.optionalText__is_initialized) {
            this.optionalText = getOptionalText__Native();
            this.optionalText__is_initialized = true;
        }
        return this.optionalText;
    }

    @NonNull
    public synchronized String getText() {
        if (!this.text__is_initialized) {
            this.text = getText__Native();
            this.text__is_initialized = true;
        }
        return this.text;
    }

    public synchronized long getTimestamp() {
        if (!this.timestamp__is_initialized) {
            this.timestamp = getTimestamp__Native();
            this.timestamp__is_initialized = true;
        }
        return this.timestamp;
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

    public TestStructure(boolean z, @NonNull String str, @Nullable String str2, @NonNull List<Integer> list, long j, long j2) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"text\" cannot be null");
        } else if (list != null) {
            this.nativeObject = init(z, str, str2, list, j, j2);
            this.b = z;
            this.b__is_initialized = true;
            this.text = str;
            this.text__is_initialized = true;
            this.optionalText = str2;
            this.optionalText__is_initialized = true;
            this.intVector = list;
            this.intVector__is_initialized = true;
            this.interval = j;
            this.interval__is_initialized = true;
            this.timestamp = j2;
            this.timestamp__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"intVector\" cannot be null");
        }
    }

    private TestStructure(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
