package com.avito.android.avito_map.clustering;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.clustering.ClusterItem;
import java.util.Collection;
public interface Cluster<T extends ClusterItem> {
    Collection<T> getItems();

    AvitoMapPoint getPosition();

    int getSize();
}
