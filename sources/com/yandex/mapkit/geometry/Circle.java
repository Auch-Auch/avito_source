package com.yandex.mapkit.geometry;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Circle implements Serializable {
    private Point center;
    private float radius;

    public Circle(@NonNull Point point, float f) {
        if (point != null) {
            this.center = point;
            this.radius = f;
            return;
        }
        throw new IllegalArgumentException("Required field \"center\" cannot be null");
    }

    @NonNull
    public Point getCenter() {
        return this.center;
    }

    public float getRadius() {
        return this.radius;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.center = (Point) archive.add((Archive) this.center, false, (Class<Archive>) Point.class);
        this.radius = archive.add(this.radius);
    }

    public Circle() {
    }
}
