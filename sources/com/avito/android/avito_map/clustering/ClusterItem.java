package com.avito.android.avito_map.clustering;

import com.avito.android.avito_map.AvitoMapPoint;
public interface ClusterItem {
    AvitoMapPoint getPosition();

    String getSnippet();

    String getTitle();
}
