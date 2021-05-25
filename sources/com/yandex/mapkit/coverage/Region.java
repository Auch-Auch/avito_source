package com.yandex.mapkit.coverage;

import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Region implements Serializable {
    private int id;
    private int zoomMax;
    private int zoomMin;

    public Region(int i, int i2, int i3) {
        this.id = i;
        this.zoomMin = i2;
        this.zoomMax = i3;
    }

    public int getId() {
        return this.id;
    }

    public int getZoomMax() {
        return this.zoomMax;
    }

    public int getZoomMin() {
        return this.zoomMin;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.id = archive.add(this.id);
        this.zoomMin = archive.add(this.zoomMin);
        this.zoomMax = archive.add(this.zoomMax);
    }

    public Region() {
    }
}
