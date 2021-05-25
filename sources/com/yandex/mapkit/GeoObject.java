package com.yandex.mapkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.geometry.BoundingBox;
import com.yandex.mapkit.geometry.Geometry;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.any.Collection;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
public class GeoObject implements Serializable {
    private List<String> aref;
    private boolean aref__is_initialized = false;
    private Map<String, Attribution> attributionMap;
    private boolean attributionMap__is_initialized = false;
    private BoundingBox boundingBox;
    private boolean boundingBox__is_initialized = false;
    private String descriptionText;
    private boolean descriptionText__is_initialized = false;
    private List<Geometry> geometry;
    private boolean geometry__is_initialized = false;
    private Collection metadataContainer;
    private boolean metadataContainer__is_initialized = false;
    private String name;
    private boolean name__is_initialized = false;
    private NativeObject nativeObject;

    public GeoObject() {
    }

    private native List<String> getAref__Native();

    private native Map<String, Attribution> getAttributionMap__Native();

    private native BoundingBox getBoundingBox__Native();

    private native String getDescriptionText__Native();

    private native List<Geometry> getGeometry__Native();

    private native Collection getMetadataContainer__Native();

    private native String getName__Native();

    public static String getNativeName() {
        return "yandex::maps::mapkit::GeoObject";
    }

    private native NativeObject init(String str, String str2, List<Geometry> list, BoundingBox boundingBox2, Map<String, Attribution> map, Collection collection, List<String> list2);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<String> getAref() {
        if (!this.aref__is_initialized) {
            this.aref = getAref__Native();
            this.aref__is_initialized = true;
        }
        return this.aref;
    }

    @NonNull
    public synchronized Map<String, Attribution> getAttributionMap() {
        if (!this.attributionMap__is_initialized) {
            this.attributionMap = getAttributionMap__Native();
            this.attributionMap__is_initialized = true;
        }
        return this.attributionMap;
    }

    @Nullable
    public synchronized BoundingBox getBoundingBox() {
        if (!this.boundingBox__is_initialized) {
            this.boundingBox = getBoundingBox__Native();
            this.boundingBox__is_initialized = true;
        }
        return this.boundingBox;
    }

    @Nullable
    public synchronized String getDescriptionText() {
        if (!this.descriptionText__is_initialized) {
            this.descriptionText = getDescriptionText__Native();
            this.descriptionText__is_initialized = true;
        }
        return this.descriptionText;
    }

    @NonNull
    public synchronized List<Geometry> getGeometry() {
        if (!this.geometry__is_initialized) {
            this.geometry = getGeometry__Native();
            this.geometry__is_initialized = true;
        }
        return this.geometry;
    }

    @NonNull
    public synchronized Collection getMetadataContainer() {
        if (!this.metadataContainer__is_initialized) {
            this.metadataContainer = getMetadataContainer__Native();
            this.metadataContainer__is_initialized = true;
        }
        return this.metadataContainer;
    }

    @Nullable
    public synchronized String getName() {
        if (!this.name__is_initialized) {
            this.name = getName__Native();
            this.name__is_initialized = true;
        }
        return this.name;
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

    public GeoObject(@Nullable String str, @Nullable String str2, @NonNull List<Geometry> list, @Nullable BoundingBox boundingBox2, @NonNull Map<String, Attribution> map, @NonNull Collection collection, @NonNull List<String> list2) {
        if (list == null) {
            throw new IllegalArgumentException("Required field \"geometry\" cannot be null");
        } else if (map == null) {
            throw new IllegalArgumentException("Required field \"attributionMap\" cannot be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("Required field \"metadataContainer\" cannot be null");
        } else if (list2 != null) {
            this.nativeObject = init(str, str2, list, boundingBox2, map, collection, list2);
            this.name = str;
            this.name__is_initialized = true;
            this.descriptionText = str2;
            this.descriptionText__is_initialized = true;
            this.geometry = list;
            this.geometry__is_initialized = true;
            this.boundingBox = boundingBox2;
            this.boundingBox__is_initialized = true;
            this.attributionMap = map;
            this.attributionMap__is_initialized = true;
            this.metadataContainer = collection;
            this.metadataContainer__is_initialized = true;
            this.aref = list2;
            this.aref__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"aref\" cannot be null");
        }
    }

    private GeoObject(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
