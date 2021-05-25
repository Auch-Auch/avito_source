package com.yandex.mapkit.geometry;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Subpolyline implements Serializable {
    private PolylinePosition begin;
    private PolylinePosition end;

    public Subpolyline(@NonNull PolylinePosition polylinePosition, @NonNull PolylinePosition polylinePosition2) {
        if (polylinePosition == null) {
            throw new IllegalArgumentException("Required field \"begin\" cannot be null");
        } else if (polylinePosition2 != null) {
            this.begin = polylinePosition;
            this.end = polylinePosition2;
        } else {
            throw new IllegalArgumentException("Required field \"end\" cannot be null");
        }
    }

    @NonNull
    public PolylinePosition getBegin() {
        return this.begin;
    }

    @NonNull
    public PolylinePosition getEnd() {
        return this.end;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.begin = (PolylinePosition) archive.add((Archive) this.begin, false, (Class<Archive>) PolylinePosition.class);
        this.end = (PolylinePosition) archive.add((Archive) this.end, false, (Class<Archive>) PolylinePosition.class);
    }

    public Subpolyline() {
    }
}
