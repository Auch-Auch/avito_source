package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
public interface MapObjectCollectionListener {
    void onMapObjectAdded(@NonNull MapObject mapObject);

    void onMapObjectRemoved(@NonNull MapObject mapObject);

    void onMapObjectUpdated(@NonNull MapObject mapObject);
}
