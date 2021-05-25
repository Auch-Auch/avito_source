package com.avito.android.avito_map.clustering.view;

import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterItem;
import com.avito.android.avito_map.clustering.ClusterManager;
import java.util.Set;
public interface ClusterRenderer<T extends ClusterItem> {
    void onAdd();

    void onClustersChanged(Set<? extends Cluster<T>> set);

    void onRemove();

    void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener);

    void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener);
}
