package com.yandex.mapkit.tiles;

import androidx.annotation.NonNull;
import com.yandex.mapkit.TileId;
import com.yandex.mapkit.Version;
public interface UrlProvider {
    @NonNull
    String formatUrl(@NonNull TileId tileId, @NonNull Version version);
}
