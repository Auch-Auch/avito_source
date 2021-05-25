package com.avito.android.geo;

import android.location.Location;
import androidx.annotation.Nullable;
public interface GeoProvider {

    public interface GeoListener {
        void onLocationImproved(@Nullable Location location);

        void onUpdateFinished(@Nullable Location location);
    }

    void dismissUpdate();

    void startUpdate(Location location, long j, int i);
}
