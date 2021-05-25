package com.yandex.mapkit.atom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class AtomFeed implements Serializable {
    private List<Link> links;
    private boolean links__is_initialized = false;
    private NativeObject nativeObject;
    private String nextpage;
    private boolean nextpage__is_initialized = false;

    public AtomFeed() {
    }

    private native List<Link> getLinks__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::atom::Feed";
    }

    private native String getNextpage__Native();

    private native NativeObject init(String str, List<Link> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<Link> getLinks() {
        if (!this.links__is_initialized) {
            this.links = getLinks__Native();
            this.links__is_initialized = true;
        }
        return this.links;
    }

    @Nullable
    public synchronized String getNextpage() {
        if (!this.nextpage__is_initialized) {
            this.nextpage = getNextpage__Native();
            this.nextpage__is_initialized = true;
        }
        return this.nextpage;
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

    public AtomFeed(@Nullable String str, @NonNull List<Link> list) {
        if (list != null) {
            this.nativeObject = init(str, list);
            this.nextpage = str;
            this.nextpage__is_initialized = true;
            this.links = list;
            this.links__is_initialized = true;
            return;
        }
        throw new IllegalArgumentException("Required field \"links\" cannot be null");
    }

    private AtomFeed(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
