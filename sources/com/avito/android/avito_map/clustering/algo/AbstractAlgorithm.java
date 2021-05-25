package com.avito.android.avito_map.clustering.algo;

import com.avito.android.avito_map.clustering.ClusterItem;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public abstract class AbstractAlgorithm<T extends ClusterItem> implements Algorithm<T> {
    public final ReadWriteLock a = new ReentrantReadWriteLock();

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void lock() {
        this.a.writeLock().lock();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void unlock() {
        this.a.writeLock().unlock();
    }
}
