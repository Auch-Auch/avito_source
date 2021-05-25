package com.google.maps.android.clustering.algo;

import android.support.v4.util.LruCache;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class PreCachingAlgorithmDecorator<T extends ClusterItem> implements Algorithm<T> {
    public final Algorithm<T> a;
    public final LruCache<Integer, Set<? extends Cluster<T>>> b = new LruCache<>(5);
    public final ReadWriteLock c = new ReentrantReadWriteLock();

    public class a implements Runnable {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep((long) ((Math.random() * 500.0d) + 500.0d));
            } catch (InterruptedException unused) {
            }
            PreCachingAlgorithmDecorator.this.b(this.a);
        }
    }

    public PreCachingAlgorithmDecorator(Algorithm<T> algorithm) {
        this.a = algorithm;
    }

    public final void a() {
        this.b.evictAll();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void addItem(T t) {
        this.a.addItem(t);
        a();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        this.a.addItems(collection);
        a();
    }

    public final Set<? extends Cluster<T>> b(int i) {
        this.c.readLock().lock();
        Set<? extends Cluster<T>> set = (Set) this.b.get(Integer.valueOf(i));
        this.c.readLock().unlock();
        if (set == null) {
            this.c.writeLock().lock();
            set = (Set) this.b.get(Integer.valueOf(i));
            if (set == null) {
                set = this.a.getClusters((double) i);
                this.b.put(Integer.valueOf(i), set);
            }
            this.c.writeLock().unlock();
        }
        return set;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        this.a.clearItems();
        a();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(double d) {
        int i = (int) d;
        Set<? extends Cluster<T>> b2 = b(i);
        int i2 = i + 1;
        if (this.b.get(Integer.valueOf(i2)) == null) {
            new Thread(new a(i2)).start();
        }
        int i3 = i - 1;
        if (this.b.get(Integer.valueOf(i3)) == null) {
            new Thread(new a(i3)).start();
        }
        return b2;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.a.getItems();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void removeItem(T t) {
        this.a.removeItem(t);
        a();
    }
}
