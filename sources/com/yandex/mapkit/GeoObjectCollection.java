package com.yandex.mapkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.geometry.BoundingBox;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.any.Collection;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class GeoObjectCollection implements Serializable {
    private BoundingBox boundingBox;
    private boolean boundingBox__is_initialized = false;
    private List<Item> children;
    private boolean children__is_initialized = false;
    private Collection metadataContainer;
    private boolean metadataContainer__is_initialized = false;
    private NativeObject nativeObject;

    public static class Item {
        private GeoObjectCollection collection;
        private GeoObject obj;

        @NonNull
        public static Item fromCollection(@NonNull GeoObjectCollection geoObjectCollection) {
            if (geoObjectCollection != null) {
                Item item = new Item();
                item.collection = geoObjectCollection;
                return item;
            }
            throw new IllegalArgumentException("Variant value \"collection\" cannot be null");
        }

        @NonNull
        public static Item fromObj(@NonNull GeoObject geoObject) {
            if (geoObject != null) {
                Item item = new Item();
                item.obj = geoObject;
                return item;
            }
            throw new IllegalArgumentException("Variant value \"obj\" cannot be null");
        }

        @Nullable
        public GeoObjectCollection getCollection() {
            return this.collection;
        }

        @Nullable
        public GeoObject getObj() {
            return this.obj;
        }
    }

    public GeoObjectCollection() {
    }

    private native BoundingBox getBoundingBox__Native();

    private native List<Item> getChildren__Native();

    private native Collection getMetadataContainer__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::GeoObjectCollection";
    }

    private native NativeObject init(BoundingBox boundingBox2, Collection collection, List<Item> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @Nullable
    public synchronized BoundingBox getBoundingBox() {
        if (!this.boundingBox__is_initialized) {
            this.boundingBox = getBoundingBox__Native();
            this.boundingBox__is_initialized = true;
        }
        return this.boundingBox;
    }

    @NonNull
    public synchronized List<Item> getChildren() {
        if (!this.children__is_initialized) {
            this.children = getChildren__Native();
            this.children__is_initialized = true;
        }
        return this.children;
    }

    @NonNull
    public synchronized Collection getMetadataContainer() {
        if (!this.metadataContainer__is_initialized) {
            this.metadataContainer = getMetadataContainer__Native();
            this.metadataContainer__is_initialized = true;
        }
        return this.metadataContainer;
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

    public GeoObjectCollection(@Nullable BoundingBox boundingBox2, @NonNull Collection collection, @NonNull List<Item> list) {
        if (collection == null) {
            throw new IllegalArgumentException("Required field \"metadataContainer\" cannot be null");
        } else if (list != null) {
            this.nativeObject = init(boundingBox2, collection, list);
            this.boundingBox = boundingBox2;
            this.boundingBox__is_initialized = true;
            this.metadataContainer = collection;
            this.metadataContainer__is_initialized = true;
            this.children = list;
            this.children__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"children\" cannot be null");
        }
    }

    private GeoObjectCollection(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
