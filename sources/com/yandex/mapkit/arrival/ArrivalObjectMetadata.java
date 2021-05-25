package com.yandex.mapkit.arrival;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class ArrivalObjectMetadata implements Serializable {
    private List<ArrivalPoint> arrivalPoints;
    private boolean arrivalPoints__is_initialized = false;
    private NativeObject nativeObject;

    public ArrivalObjectMetadata() {
    }

    private native List<ArrivalPoint> getArrivalPoints__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::arrival::ArrivalObjectMetadata";
    }

    private native NativeObject init(List<ArrivalPoint> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<ArrivalPoint> getArrivalPoints() {
        if (!this.arrivalPoints__is_initialized) {
            this.arrivalPoints = getArrivalPoints__Native();
            this.arrivalPoints__is_initialized = true;
        }
        return this.arrivalPoints;
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

    public ArrivalObjectMetadata(@NonNull List<ArrivalPoint> list) {
        if (list != null) {
            this.nativeObject = init(list);
            this.arrivalPoints = list;
            this.arrivalPoints__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"arrivalPoints\" cannot be null");
    }

    private ArrivalObjectMetadata(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
