package com.avito.android.avito_map.clustering.algo;

import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
public interface Algorithm<T extends ClusterItem> {
    void addItem(T t);

    void addItems(Collection<T> collection);

    void clearItems();

    Set<? extends Cluster<T>> getClusters(float f);

    Collection<T> getItems();

    int getMaxDistanceBetweenClusteredItems();

    void lock();

    void removeItem(T t);

    void removeItems(Collection<T> collection);

    void setMaxDistanceBetweenClusteredItems(int i);

    void unlock();
}
