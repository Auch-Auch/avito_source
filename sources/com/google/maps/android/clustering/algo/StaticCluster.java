package com.google.maps.android.clustering.algo;

import a2.b.a.a.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    public final LatLng a;
    public final List<T> b = new ArrayList();

    public StaticCluster(LatLng latLng) {
        this.a = latLng;
    }

    public boolean add(T t) {
        return this.b.add(t);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StaticCluster)) {
            return false;
        }
        StaticCluster staticCluster = (StaticCluster) obj;
        if (!staticCluster.a.equals(this.a) || !staticCluster.b.equals(this.b)) {
            return false;
        }
        return true;
    }

    @Override // com.google.maps.android.clustering.Cluster
    public Collection<T> getItems() {
        return this.b;
    }

    @Override // com.google.maps.android.clustering.Cluster
    public LatLng getPosition() {
        return this.a;
    }

    @Override // com.google.maps.android.clustering.Cluster
    public int getSize() {
        return this.b.size();
    }

    public int hashCode() {
        return this.b.hashCode() + this.a.hashCode();
    }

    public boolean remove(T t) {
        return this.b.remove(t);
    }

    public String toString() {
        StringBuilder L = a.L("StaticCluster{mCenter=");
        L.append(this.a);
        L.append(", mItems.size=");
        L.append(this.b.size());
        L.append('}');
        return L.toString();
    }
}
