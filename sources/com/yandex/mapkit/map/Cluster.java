package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import java.util.List;
public interface Cluster {
    void addClusterTapListener(@NonNull ClusterTapListener clusterTapListener);

    @NonNull
    PlacemarkMapObject getAppearance();

    @NonNull
    List<PlacemarkMapObject> getPlacemarks();

    int getSize();

    boolean isValid();

    void removeClusterTapListener(@NonNull ClusterTapListener clusterTapListener);
}
