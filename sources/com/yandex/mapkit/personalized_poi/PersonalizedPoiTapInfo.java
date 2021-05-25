package com.yandex.mapkit.personalized_poi;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class PersonalizedPoiTapInfo implements Serializable {
    private NativeObject nativeObject;
    private String placeholder;
    private boolean placeholder__is_initialized = false;

    public PersonalizedPoiTapInfo() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::personalized_poi::PersonalizedPoiTapInfo";
    }

    private native String getPlaceholder__Native();

    private native NativeObject init(String str);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized String getPlaceholder() {
        if (!this.placeholder__is_initialized) {
            this.placeholder = getPlaceholder__Native();
            this.placeholder__is_initialized = true;
        }
        return this.placeholder;
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

    public PersonalizedPoiTapInfo(@NonNull String str) {
        if (str != null) {
            this.nativeObject = init(str);
            this.placeholder = str;
            this.placeholder__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"placeholder\" cannot be null");
    }

    private PersonalizedPoiTapInfo(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
