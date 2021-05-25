package com.yandex.mapkit.tiles;

import androidx.annotation.NonNull;
import com.yandex.mapkit.RawTile;
import com.yandex.mapkit.TileId;
import com.yandex.mapkit.Version;
public interface TileProvider {
    @NonNull
    RawTile load(@NonNull TileId tileId, @NonNull Version version, @NonNull String str);
}
