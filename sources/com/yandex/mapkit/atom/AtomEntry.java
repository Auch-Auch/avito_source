package com.yandex.mapkit.atom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.Attribution;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class AtomEntry implements Serializable {
    private Attribution attribution;
    private boolean attribution__is_initialized = false;
    private Author author;
    private boolean author__is_initialized = false;
    private String id;
    private boolean id__is_initialized = false;
    private List<Link> links;
    private boolean links__is_initialized = false;
    private NativeObject nativeObject;
    private String updateTime;
    private boolean updateTime__is_initialized = false;

    public AtomEntry() {
    }

    private native Attribution getAttribution__Native();

    private native Author getAuthor__Native();

    private native String getId__Native();

    private native List<Link> getLinks__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::atom::Entry";
    }

    private native String getUpdateTime__Native();

    private native NativeObject init(String str, String str2, Author author2, Attribution attribution2, List<Link> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @Nullable
    public synchronized Attribution getAttribution() {
        if (!this.attribution__is_initialized) {
            this.attribution = getAttribution__Native();
            this.attribution__is_initialized = true;
        }
        return this.attribution;
    }

    @NonNull
    public synchronized Author getAuthor() {
        if (!this.author__is_initialized) {
            this.author = getAuthor__Native();
            this.author__is_initialized = true;
        }
        return this.author;
    }

    @Nullable
    public synchronized String getId() {
        if (!this.id__is_initialized) {
            this.id = getId__Native();
            this.id__is_initialized = true;
        }
        return this.id;
    }

    @NonNull
    public synchronized List<Link> getLinks() {
        if (!this.links__is_initialized) {
            this.links = getLinks__Native();
            this.links__is_initialized = true;
        }
        return this.links;
    }

    @Nullable
    public synchronized String getUpdateTime() {
        if (!this.updateTime__is_initialized) {
            this.updateTime = getUpdateTime__Native();
            this.updateTime__is_initialized = true;
        }
        return this.updateTime;
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

    public AtomEntry(@Nullable String str, @Nullable String str2, @NonNull Author author2, @Nullable Attribution attribution2, @NonNull List<Link> list) {
        if (author2 == null) {
            throw new IllegalArgumentException("Required field \"author\" cannot be null");
        } else if (list != null) {
            this.nativeObject = init(str, str2, author2, attribution2, list);
            this.id = str;
            this.id__is_initialized = true;
            this.updateTime = str2;
            this.updateTime__is_initialized = true;
            this.author = author2;
            this.author__is_initialized = true;
            this.attribution = attribution2;
            this.attribution__is_initialized = true;
            this.links = list;
            this.links__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"links\" cannot be null");
        }
    }

    private AtomEntry(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
