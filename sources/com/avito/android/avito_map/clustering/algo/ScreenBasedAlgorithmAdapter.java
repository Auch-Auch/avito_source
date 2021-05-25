package com.avito.android.avito_map.clustering.algo;

import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
public class ScreenBasedAlgorithmAdapter<T extends ClusterItem> extends AbstractAlgorithm<T> implements ScreenBasedAlgorithm<T> {
    public Algorithm<T> b;

    public ScreenBasedAlgorithmAdapter(Algorithm<T> algorithm) {
        this.b = algorithm;
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void addItem(T t) {
        this.b.addItem(t);
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void addItems(Collection<T> collection) {
        this.b.addItems(collection);
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void clearItems() {
        this.b.clearItems();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f) {
        return this.b.getClusters(f);
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.b.getItems();
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.b.getMaxDistanceBetweenClusteredItems();
    }

    @Override // com.avito.android.avito_map.clustering.algo.ScreenBasedAlgorithm
    public void onCameraChange(AvitoMapCameraPosition avitoMapCameraPosition) {
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void removeItem(T t) {
        this.b.removeItem(t);
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void removeItems(Collection<T> collection) {
        this.b.removeItems(collection);
    }

    @Override // com.avito.android.avito_map.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i) {
        this.b.setMaxDistanceBetweenClusteredItems(i);
    }

    @Override // com.avito.android.avito_map.clustering.algo.ScreenBasedAlgorithm
    public boolean shouldReClusterOnMapMovement() {
        return false;
    }
}
