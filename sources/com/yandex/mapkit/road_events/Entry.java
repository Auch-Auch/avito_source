package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.mapkit.atom.AtomEntry;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
public class Entry implements Serializable {
    private AtomEntry atomEntry;
    private boolean atomEntry__is_initialized = false;
    private TextEntry content;
    private boolean content__is_initialized = false;
    private NativeObject nativeObject;

    public Entry() {
    }

    private native AtomEntry getAtomEntry__Native();

    private native TextEntry getContent__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::road_events::Entry";
    }

    private native NativeObject init(AtomEntry atomEntry2, TextEntry textEntry);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized AtomEntry getAtomEntry() {
        if (!this.atomEntry__is_initialized) {
            this.atomEntry = getAtomEntry__Native();
            this.atomEntry__is_initialized = true;
        }
        return this.atomEntry;
    }

    @NonNull
    public synchronized TextEntry getContent() {
        if (!this.content__is_initialized) {
            this.content = getContent__Native();
            this.content__is_initialized = true;
        }
        return this.content;
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

    public Entry(@NonNull AtomEntry atomEntry2, @NonNull TextEntry textEntry) {
        if (atomEntry2 == null) {
            throw new IllegalArgumentException("Required field \"atomEntry\" cannot be null");
        } else if (textEntry != null) {
            this.nativeObject = init(atomEntry2, textEntry);
            this.atomEntry = atomEntry2;
            this.atomEntry__is_initialized = true;
            this.content = textEntry;
            this.content__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"content\" cannot be null");
        }
    }

    private Entry(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
