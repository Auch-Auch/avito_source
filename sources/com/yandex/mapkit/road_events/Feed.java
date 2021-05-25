package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.mapkit.atom.AtomFeed;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class Feed implements Serializable {
    private AtomFeed atomFeed;
    private boolean atomFeed__is_initialized = false;
    private List<Entry> entries;
    private boolean entries__is_initialized = false;
    private NativeObject nativeObject;

    public Feed() {
    }

    private native AtomFeed getAtomFeed__Native();

    private native List<Entry> getEntries__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::road_events::Feed";
    }

    private native NativeObject init(AtomFeed atomFeed2, List<Entry> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized AtomFeed getAtomFeed() {
        if (!this.atomFeed__is_initialized) {
            this.atomFeed = getAtomFeed__Native();
            this.atomFeed__is_initialized = true;
        }
        return this.atomFeed;
    }

    @NonNull
    public synchronized List<Entry> getEntries() {
        if (!this.entries__is_initialized) {
            this.entries = getEntries__Native();
            this.entries__is_initialized = true;
        }
        return this.entries;
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

    public Feed(@NonNull AtomFeed atomFeed2, @NonNull List<Entry> list) {
        if (atomFeed2 == null) {
            throw new IllegalArgumentException("Required field \"atomFeed\" cannot be null");
        } else if (list != null) {
            this.nativeObject = init(atomFeed2, list);
            this.atomFeed = atomFeed2;
            this.atomFeed__is_initialized = true;
            this.entries = list;
            this.entries__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"entries\" cannot be null");
        }
    }

    private Feed(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
