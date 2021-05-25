package com.yandex.mapkit.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Location implements Serializable {
    private long absoluteTimestamp;
    private Double accuracy;
    private Double altitude;
    private Double altitudeAccuracy;
    private Double heading;
    private String indoorLevelId;
    private Point position;
    private long relativeTimestamp;
    private Double speed;

    public Location(@NonNull Point point, @Nullable Double d, @Nullable Double d2, @Nullable Double d3, @Nullable Double d4, @Nullable Double d5, @Nullable String str, long j, long j2) {
        if (point != null) {
            this.position = point;
            this.accuracy = d;
            this.altitude = d2;
            this.altitudeAccuracy = d3;
            this.heading = d4;
            this.speed = d5;
            this.indoorLevelId = str;
            this.absoluteTimestamp = j;
            this.relativeTimestamp = j2;
            return;
        }
        throw new IllegalArgumentException("Required field \"position\" cannot be null");
    }

    public long getAbsoluteTimestamp() {
        return this.absoluteTimestamp;
    }

    @Nullable
    public Double getAccuracy() {
        return this.accuracy;
    }

    @Nullable
    public Double getAltitude() {
        return this.altitude;
    }

    @Nullable
    public Double getAltitudeAccuracy() {
        return this.altitudeAccuracy;
    }

    @Nullable
    public Double getHeading() {
        return this.heading;
    }

    @Nullable
    public String getIndoorLevelId() {
        return this.indoorLevelId;
    }

    @NonNull
    public Point getPosition() {
        return this.position;
    }

    public long getRelativeTimestamp() {
        return this.relativeTimestamp;
    }

    @Nullable
    public Double getSpeed() {
        return this.speed;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.position = (Point) archive.add((Archive) this.position, false, (Class<Archive>) Point.class);
        this.accuracy = archive.add(this.accuracy, true);
        this.altitude = archive.add(this.altitude, true);
        this.altitudeAccuracy = archive.add(this.altitudeAccuracy, true);
        this.heading = archive.add(this.heading, true);
        this.speed = archive.add(this.speed, true);
        this.indoorLevelId = archive.add(this.indoorLevelId, true);
        this.absoluteTimestamp = archive.add(this.absoluteTimestamp);
        this.relativeTimestamp = archive.add(this.relativeTimestamp);
    }

    public Location() {
    }
}
