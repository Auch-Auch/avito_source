package com.yandex.mapkit;

import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class ZoomRange implements Serializable {
    private int zMax;
    private int zMin;

    public ZoomRange(int i, int i2) {
        this.zMin = i;
        this.zMax = i2;
    }

    public int getZMax() {
        return this.zMax;
    }

    public int getZMin() {
        return this.zMin;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.zMin = archive.add(this.zMin);
        this.zMax = archive.add(this.zMax);
    }

    public ZoomRange() {
    }
}
