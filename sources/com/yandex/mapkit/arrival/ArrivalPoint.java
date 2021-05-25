package com.yandex.mapkit.arrival;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.geometry.Direction;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class ArrivalPoint implements Serializable {
    private Direction direction;
    private String name;
    private Point point;

    public ArrivalPoint(@Nullable String str, @NonNull Point point2, @Nullable Direction direction2) {
        if (point2 != null) {
            this.name = str;
            this.point = point2;
            this.direction = direction2;
            return;
        }
        throw new IllegalArgumentException("Required field \"point\" cannot be null");
    }

    @Nullable
    public Direction getDirection() {
        return this.direction;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @NonNull
    public Point getPoint() {
        return this.point;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.name = archive.add(this.name, true);
        this.point = (Point) archive.add((Archive) this.point, false, (Class<Archive>) Point.class);
        this.direction = (Direction) archive.add((Archive) this.direction, true, (Class<Archive>) Direction.class);
    }

    public ArrivalPoint() {
    }
}
