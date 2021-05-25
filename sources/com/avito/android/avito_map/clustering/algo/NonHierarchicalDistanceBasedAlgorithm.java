package com.avito.android.avito_map.clustering.algo;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterItem;
import com.avito.android.avito_map.clustering.SphericalMercatorProjection;
import com.avito.android.avito_map.clustering.extra.PointQuadTree;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    public static final SphericalMercatorProjection e = new SphericalMercatorProjection(1.0d);
    public int b = 100;
    public final Collection<b<T>> c = new HashSet();
    public final PointQuadTree<b<T>> d = new PointQuadTree<>(0.0d, 1.0d, 0.0d, 1.0d);

    public static class b<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        public final T a;
        public final Point b;
        public final AvitoMapPoint c;
        public Set<T> d;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.avito_map.clustering.ClusterItem */
        /* JADX WARN: Multi-variable type inference failed */
        public b(ClusterItem clusterItem, a aVar) {
            this.a = clusterItem;
            AvitoMapPoint position = clusterItem.getPosition();
            this.c = position;
            this.b = NonHierarchicalDistanceBasedAlgorithm.e.latLngToPoint(position);
            this.d = Collections.singleton(clusterItem);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return ((b) obj).a.equals(this.a);
        }

        @Override // com.avito.android.avito_map.clustering.Cluster
        public Collection getItems() {
            return this.d;
        }

        @Override // com.avito.android.avito_map.clustering.extra.PointQuadTree.Item
        public Point getPoint() {
            return this.b;
        }

        @Override // com.avito.android.avito_map.clustering.Cluster
        public AvitoMapPoint getPosition() {
            return this.c;
        }

        @Override // com.avito.android.avito_map.clustering.Cluster
        public int getSize() {
            return 1;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void addItem(T t) {
        b<T> bVar = new b<>(t, null);
        synchronized (this.d) {
            this.c.add(bVar);
            this.d.add(bVar);
        }
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        for (T t : collection) {
            addItem(t);
        }
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void clearItems() {
        synchronized (this.d) {
            this.c.clear();
            this.d.clear();
        }
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f) {
        NonHierarchicalDistanceBasedAlgorithm<T> nonHierarchicalDistanceBasedAlgorithm = this;
        double d2 = 2.0d;
        double pow = (((double) nonHierarchicalDistanceBasedAlgorithm.b) / Math.pow(2.0d, (double) ((int) f))) / 256.0d;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (nonHierarchicalDistanceBasedAlgorithm.d) {
            Iterator<b<T>> it = nonHierarchicalDistanceBasedAlgorithm.c.iterator();
            while (it.hasNext()) {
                b<T> next = it.next();
                if (!hashSet.contains(next)) {
                    Point point = next.b;
                    double d3 = pow / d2;
                    double d4 = point.x;
                    double d5 = d4 - d3;
                    double d6 = d4 + d3;
                    double d7 = point.y;
                    Collection<b<T>> search = nonHierarchicalDistanceBasedAlgorithm.d.search(new Bounds(d5, d6, d7 - d3, d7 + d3));
                    if (search.size() == 1) {
                        hashSet2.add(next);
                        hashSet.add(next);
                        hashMap.put(next, Double.valueOf(0.0d));
                        d2 = 2.0d;
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
                                    it = it;
                                    hashSet = hashSet;
                                    pow = pow;
                                    next = next;
                                } else {
                                    ((StaticCluster) hashMap2.get(bVar)).remove(bVar.a);
                                }
                            }
                            hashMap.put(bVar, Double.valueOf(d11));
                            staticCluster.add(bVar.a);
                            hashMap2.put(bVar, staticCluster);
                            it = it;
                            hashSet = hashSet;
                            pow = pow;
                            next = next;
                        }
                        hashSet.addAll(search);
                        d2 = 2.0d;
                        nonHierarchicalDistanceBasedAlgorithm = this;
                        it = it;
                        pow = pow;
                    }
                }
            }
        }
        return hashSet2;
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public Collection<T> getItems() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.d) {
            for (b<T> bVar : this.c) {
                arrayList.add(bVar.a);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.b;
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void removeItem(T t) {
        b<T> bVar = new b<>(t, null);
        synchronized (this.d) {
            this.c.remove(bVar);
            this.d.remove(bVar);
        }
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void removeItems(Collection<T> collection) {
        synchronized (this.d) {
            for (T t : collection) {
                b<T> bVar = new b<>(t, null);
                this.c.remove(bVar);
                this.d.remove(bVar);
            }
        }
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i) {
        this.b = i;
    }
}
