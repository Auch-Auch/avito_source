package com.google.maps.android.clustering.algo;

import android.support.v4.util.LongSparseArray;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class GridBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {
    public final Set<T> a = Collections.synchronizedSet(new HashSet());

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void addItem(T t) {
        this.a.add(t);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        this.a.addAll(collection);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        this.a.clear();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(double d) {
        double d2;
        double ceil = (double) ((long) Math.ceil((Math.pow(2.0d, d) * 256.0d) / 100.0d));
        SphericalMercatorProjection sphericalMercatorProjection = new SphericalMercatorProjection(ceil);
        HashSet hashSet = new HashSet();
        LongSparseArray longSparseArray = new LongSparseArray();
        synchronized (this.a) {
            for (T t : this.a) {
                Point point = sphericalMercatorProjection.toPoint(t.getPosition());
                double d3 = point.x;
                long floor = (long) (Math.floor(point.y) + (Math.floor(d3) * ceil));
                StaticCluster staticCluster = (StaticCluster) longSparseArray.get(floor);
                if (staticCluster == null) {
                    d2 = ceil;
                    staticCluster = new StaticCluster(sphericalMercatorProjection.toLatLng(new com.google.maps.android.geometry.Point(Math.floor(point.x) + 0.5d, Math.floor(point.y) + 0.5d)));
                    longSparseArray.put(floor, staticCluster);
                    hashSet.add(staticCluster);
                } else {
                    d2 = ceil;
                }
                staticCluster.add(t);
                ceil = d2;
            }
        }
        return hashSet;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.a;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void removeItem(T t) {
        this.a.remove(t);
    }
}
