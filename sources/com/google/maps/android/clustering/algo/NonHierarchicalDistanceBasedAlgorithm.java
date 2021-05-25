package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {
    public static final int MAX_DISTANCE_AT_ZOOM = 100;
    public static final SphericalMercatorProjection c = new SphericalMercatorProjection(1.0d);
    public final Collection<b<T>> a = new ArrayList();
    public final PointQuadTree<b<T>> b = new PointQuadTree<>(0.0d, 1.0d, 0.0d, 1.0d);

    public static class b<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        public final T a;
        public final Point b;
        public final LatLng c;
        public Set<T> d;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.maps.android.clustering.ClusterItem */
        /* JADX WARN: Multi-variable type inference failed */
        public b(ClusterItem clusterItem, a aVar) {
            this.a = clusterItem;
            LatLng position = clusterItem.getPosition();
            this.c = position;
            this.b = NonHierarchicalDistanceBasedAlgorithm.c.toPoint(position);
            this.d = Collections.singleton(clusterItem);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return ((b) obj).a.equals(this.a);
        }

        @Override // com.google.maps.android.clustering.Cluster
        public Collection getItems() {
            return this.d;
        }

        @Override // com.google.maps.android.quadtree.PointQuadTree.Item
        public Point getPoint() {
            return this.b;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public LatLng getPosition() {
            return this.c;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public int getSize() {
            return 1;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void addItem(T t) {
        b<T> bVar = new b<>(t, null);
        synchronized (this.b) {
            this.a.add(bVar);
            this.b.add(bVar);
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        for (T t : collection) {
            addItem(t);
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        synchronized (this.b) {
            this.a.clear();
            this.b.clear();
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(double d) {
        NonHierarchicalDistanceBasedAlgorithm<T> nonHierarchicalDistanceBasedAlgorithm = this;
        double d2 = 2.0d;
        double pow = (100.0d / Math.pow(2.0d, (double) ((int) d))) / 256.0d;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (nonHierarchicalDistanceBasedAlgorithm.b) {
            Iterator<b<T>> it = nonHierarchicalDistanceBasedAlgorithm.a.iterator();
            while (it.hasNext()) {
                b<T> next = it.next();
                if (!hashSet.contains(next)) {
                    Point point = next.b;
                    double d3 = pow / d2;
                    double d4 = point.x;
                    double d5 = d4 - d3;
                    double d6 = d4 + d3;
                    double d7 = point.y;
                    Collection<b<T>> search = nonHierarchicalDistanceBasedAlgorithm.b.search(new Bounds(d5, d6, d7 - d3, d7 + d3));
                    if (search.size() == 1) {
                        hashSet2.add(next);
                        hashSet.add(next);
                        hashMap.put(next, Double.valueOf(0.0d));
                    } else {
                        StaticCluster staticCluster = new StaticCluster(next.a.getPosition());
                        hashSet2.add(staticCluster);
                        for (b<T> bVar : search) {
                            Double d8 = (Double) hashMap.get(bVar);
                            Point point2 = bVar.b;
                            Point point3 = next.b;
                            double d9 = point2.x - point3.x;
                            double d10 = point2.y - point3.y;
                            double d11 = (d10 * d10) + (d9 * d9);
                            if (d8 != null) {
                                if (d8.doubleValue() < d11) {
                                    hashSet2 = hashSet2;
                                    pow = pow;
                                    it = it;
                                    next = next;
                                } else {
                                    ((StaticCluster) hashMap2.get(bVar)).remove(bVar.a);
                                }
                            }
                            hashMap.put(bVar, Double.valueOf(d11));
                            staticCluster.add(bVar.a);
                            hashMap2.put(bVar, staticCluster);
                            hashSet2 = hashSet2;
                            pow = pow;
                            it = it;
                            next = next;
                        }
                        hashSet.addAll(search);
                        nonHierarchicalDistanceBasedAlgorithm = this;
                        hashSet2 = hashSet2;
                        pow = pow;
                        it = it;
                    }
                    d2 = 2.0d;
                }
            }
        }
        return hashSet2;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.b) {
            for (b<T> bVar : this.a) {
                arrayList.add(bVar.a);
            }
        }
        return arrayList;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void removeItem(T t) {
        b<T> bVar = new b<>(t, null);
        synchronized (this.b) {
            this.a.remove(bVar);
            this.b.remove(bVar);
        }
    }
}
