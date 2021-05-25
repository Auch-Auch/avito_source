package com.yandex.mapkit.offline_cache;

import androidx.annotation.NonNull;
import com.yandex.mapkit.LocalizedValue;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Region implements Serializable {
    private Point center;
    private String country;
    private int id;
    private String name;
    private long releaseTime;
    private LocalizedValue size;

    public Region(int i, @NonNull String str, @NonNull String str2, @NonNull Point point, @NonNull LocalizedValue localizedValue, long j) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"name\" cannot be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Required field \"country\" cannot be null");
        } else if (point == null) {
            throw new IllegalArgumentException("Required field \"center\" cannot be null");
        } else if (localizedValue != null) {
            this.id = i;
            this.name = str;
            this.country = str2;
            this.center = point;
            this.size = localizedValue;
            this.releaseTime = j;
        } else {
            throw new IllegalArgumentException("Required field \"size\" cannot be null");
        }
    }

    @NonNull
    public Point getCenter() {
        return this.center;
    }

    @NonNull
    public String getCountry() {
        return this.country;
    }

    public int getId() {
        return this.id;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public long getReleaseTime() {
        return this.releaseTime;
    }

    @NonNull
    public LocalizedValue getSize() {
        return this.size;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.id = archive.add(this.id);
        this.name = archive.add(this.name, false);
        this.country = archive.add(this.country, false);
        this.center = (Point) archive.add((Archive) this.center, false, (Class<Archive>) Point.class);
        this.size = (LocalizedValue) archive.add((Archive) this.size, false, (Class<Archive>) LocalizedValue.class);
        this.releaseTime = archive.add(this.releaseTime);
    }

    public Region() {
    }
}
