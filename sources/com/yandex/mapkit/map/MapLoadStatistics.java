package com.yandex.mapkit.map;

import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class MapLoadStatistics implements Serializable {
    private long curZoomGeometryLoaded;
    private long curZoomLabelsLoaded;
    private long curZoomPlacemarksLoaded;
    private long delayedGeometryLoaded;
    private long fullyAppeared;
    private long fullyLoaded;
    private long geometryLoaded;
    private long labelsLoaded;
    private long modelsLoaded;
    private long placemarksLoaded;
    private int renderObjectCount;
    private int tileMemoryUsage;

    public MapLoadStatistics(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i, int i2) {
        this.curZoomGeometryLoaded = j;
        this.curZoomPlacemarksLoaded = j2;
        this.curZoomLabelsLoaded = j3;
        this.geometryLoaded = j4;
        this.delayedGeometryLoaded = j5;
        this.labelsLoaded = j6;
        this.placemarksLoaded = j7;
        this.modelsLoaded = j8;
        this.fullyLoaded = j9;
        this.fullyAppeared = j10;
        this.renderObjectCount = i;
        this.tileMemoryUsage = i2;
    }

    public long getCurZoomGeometryLoaded() {
        return this.curZoomGeometryLoaded;
    }

    public long getCurZoomLabelsLoaded() {
        return this.curZoomLabelsLoaded;
    }

    public long getCurZoomPlacemarksLoaded() {
        return this.curZoomPlacemarksLoaded;
    }

    public long getDelayedGeometryLoaded() {
        return this.delayedGeometryLoaded;
    }

    public long getFullyAppeared() {
        return this.fullyAppeared;
    }

    public long getFullyLoaded() {
        return this.fullyLoaded;
    }

    public long getGeometryLoaded() {
        return this.geometryLoaded;
    }

    public long getLabelsLoaded() {
        return this.labelsLoaded;
    }

    public long getModelsLoaded() {
        return this.modelsLoaded;
    }

    public long getPlacemarksLoaded() {
        return this.placemarksLoaded;
    }

    public int getRenderObjectCount() {
        return this.renderObjectCount;
    }

    public int getTileMemoryUsage() {
        return this.tileMemoryUsage;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.curZoomGeometryLoaded = archive.add(this.curZoomGeometryLoaded);
        this.curZoomPlacemarksLoaded = archive.add(this.curZoomPlacemarksLoaded);
        this.curZoomLabelsLoaded = archive.add(this.curZoomLabelsLoaded);
        this.geometryLoaded = archive.add(this.geometryLoaded);
        this.delayedGeometryLoaded = archive.add(this.delayedGeometryLoaded);
        this.labelsLoaded = archive.add(this.labelsLoaded);
        this.placemarksLoaded = archive.add(this.placemarksLoaded);
        this.modelsLoaded = archive.add(this.modelsLoaded);
        this.fullyLoaded = archive.add(this.fullyLoaded);
        this.fullyAppeared = archive.add(this.fullyAppeared);
        this.renderObjectCount = archive.add(this.renderObjectCount);
        this.tileMemoryUsage = archive.add(this.tileMemoryUsage);
    }

    public MapLoadStatistics() {
    }
}
