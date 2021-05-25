package com.avito.android.avito_map.clustering.algo;

import androidx.collection.LruCache;
import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class PreCachingAlgorithmDecorator<T extends ClusterItem> extends AbstractAlgorithm<T> {
    public final Algorithm<T> b;
    public final LruCache<Integer, Set<? extends Cluster<T>>> c = new LruCache<>(5);
    public final ReadWriteLock d = new ReentrantReadWriteLock();

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
            PreCachingAlgorithmDecorator.this.a(this.a);
        }
    }

    public PreCachingAlgorithmDecorator(Algorithm<T> algorithm) {
        this.b = algorithm;
    }

    public final Set<? extends Cluster<T>> a(int i) {
        this.d.readLock().lock();
        Set<? extends Cluster<T>> set = this.c.get(Integer.valueOf(i));
        this.d.readLock().unlock();
        if (set == null) {
            this.d.writeLock().lock();
            set = this.c.get(Integer.valueOf(i));
            if (set == null) {
                set = this.b.getClusters((float) i);
                this.c.put(Integer.valueOf(i), set);
            }
            this.d.writeLock().unlock();
        }
        return set;
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void addItem(T t) {
        this.b.addItem(t);
        this.c.evictAll();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        this.b.addItems(collection);
        this.c.evictAll();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void clearItems() {
        this.b.clearItems();
        this.c.evictAll();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f) {
        int i = (int) f;
        Set<? extends Cluster<T>> a3 = a(i);
        int i2 = i + 1;
        if (this.c.get(Integer.valueOf(i2)) == null) {
            new Thread(new a(i2)).start();
        }
        int i3 = i - 1;
        if (this.c.get(Integer.valueOf(i3)) == null) {
            new Thread(new a(i3)).start();
        }
        return a3;
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.b.getItems();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.b.getMaxDistanceBetweenClusteredItems();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void removeItem(T t) {
        this.b.removeItem(t);
        this.c.evictAll();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void removeItems(Collection<T> collection) {
        this.b.removeItems(collection);
        this.c.evictAll();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i) {
        this.b.setMaxDistanceBetweenClusteredItems(i);
        this.c.evictAll();
    }
}
