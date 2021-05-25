package com.avito.android.avito_map.clustering.extra;

import com.avito.android.avito_map.clustering.extra.PointQuadTree.Item;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PointQuadTree<T extends Item> {
    public final Bounds a;
    public final int b;
    public Set<T> c;
    public List<PointQuadTree<T>> d;

    public interface Item {
        Point getPoint();
    }

    public PointQuadTree(double d2, double d3, double d4, double d5) {
        this(new Bounds(d2, d3, d4, d5));
    }

    public final void a(double d2, double d3, T t) {
        List<PointQuadTree<T>> list = this.d;
        if (list != null) {
            Bounds bounds = this.a;
            if (d3 < bounds.midY) {
                if (d2 < bounds.midX) {
                    list.get(0).a(d2, d3, t);
                } else {
                    list.get(1).a(d2, d3, t);
                }
            } else if (d2 < bounds.midX) {
                list.get(2).a(d2, d3, t);
            } else {
                list.get(3).a(d2, d3, t);
            }
        } else {
            if (this.c == null) {
                this.c = new HashSet();
            }
            this.c.add(t);
            if (this.c.size() > 50 && this.b < 40) {
                ArrayList arrayList = new ArrayList(4);
                this.d = arrayList;
                Bounds bounds2 = this.a;
                arrayList.add(new PointQuadTree(bounds2.minX, bounds2.midX, bounds2.minY, bounds2.midY, this.b + 1));
                List<PointQuadTree<T>> list2 = this.d;
                Bounds bounds3 = this.a;
                list2.add(new PointQuadTree<>(bounds3.midX, bounds3.maxX, bounds3.minY, bounds3.midY, this.b + 1));
                List<PointQuadTree<T>> list3 = this.d;
                Bounds bounds4 = this.a;
                list3.add(new PointQuadTree<>(bounds4.minX, bounds4.midX, bounds4.midY, bounds4.maxY, this.b + 1));
                List<PointQuadTree<T>> list4 = this.d;
                Bounds bounds5 = this.a;
                list4.add(new PointQuadTree<>(bounds5.midX, bounds5.maxX, bounds5.midY, bounds5.maxY, this.b + 1));
                Set<T> set = this.c;
                this.c = null;
                for (T t2 : set) {
                    a(t2.getPoint().x, t2.getPoint().y, t2);
                }
            }
        }
    }

    public void add(T t) {
        Point point = t.getPoint();
        if (this.a.contains(point.x, point.y)) {
            a(point.x, point.y, t);
        }
    }

    public final boolean b(double d2, double d3, T t) {
        List<PointQuadTree<T>> list = this.d;
        if (list != null) {
            Bounds bounds = this.a;
            if (d3 < bounds.midY) {
                if (d2 < bounds.midX) {
                    return list.get(0).b(d2, d3, t);
                }
                return list.get(1).b(d2, d3, t);
            } else if (d2 < bounds.midX) {
                return list.get(2).b(d2, d3, t);
            } else {
                return list.get(3).b(d2, d3, t);
            }
        } else {
            Set<T> set = this.c;
            if (set == null) {
                return false;
            }
            return set.remove(t);
        }
    }

    public final void c(Bounds bounds, Collection<T> collection) {
        if (this.a.intersects(bounds)) {
            List<PointQuadTree<T>> list = this.d;
            if (list != null) {
                for (PointQuadTree<T> pointQuadTree : list) {
                    pointQuadTree.c(bounds, collection);
                }
            } else if (this.c != null) {
                if (bounds.contains(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (T t : this.c) {
                    if (bounds.contains(t.getPoint())) {
                        collection.add(t);
                    }
                }
            }
        }
    }

    public void clear() {
        this.d = null;
        Set<T> set = this.c;
        if (set != null) {
            set.clear();
        }
    }

    public boolean remove(T t) {
        Point point = t.getPoint();
        if (this.a.contains(point.x, point.y)) {
            return b(point.x, point.y, t);
        }
        return false;
    }

    public Collection<T> search(Bounds bounds) {
        ArrayList arrayList = new ArrayList();
        c(bounds, arrayList);
        return arrayList;
    }

    public PointQuadTree(double d2, double d3, double d4, double d5, int i) {
        Bounds bounds = new Bounds(d2, d3, d4, d5);
        this.d = null;
        this.a = bounds;
        this.b = i;
    }

    public PointQuadTree(Bounds bounds) {
        this.d = null;
        this.a = bounds;
        this.b = 0;
    }
}
