package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class CameraPosition implements Serializable {
    private float azimuth;
    private Point target;
    private float tilt;
    private float zoom;

    public CameraPosition(@NonNull Point point, float f, float f2, float f3) {
        if (point != null) {
            this.target = point;
            this.zoom = f;
            this.azimuth = f2;
            this.tilt = f3;
            return;
        }
        throw new IllegalArgumentException("Required field \"target\" cannot be null");
    }

    public float getAzimuth() {
        return this.azimuth;
    }

    @NonNull
    public Point getTarget() {
        return this.target;
    }

    public float getTilt() {
        return this.tilt;
    }

    public float getZoom() {
        return this.zoom;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.target = (Point) archive.add((Archive) this.target, false, (Class<Archive>) Point.class);
        this.zoom = archive.add(this.zoom);
        this.azimuth = archive.add(this.azimuth);
        this.tilt = archive.add(this.tilt);
    }

    public CameraPosition() {
    }
}
