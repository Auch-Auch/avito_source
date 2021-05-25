package com.avito.android.geo;

import android.location.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/geo/GeoStorage;", "", "Landroid/location/Location;", "location", "", "saveLocation", "(Landroid/location/Location;)V", "", "getFormattedLocation", "()Ljava/lang/String;", "getLocation", "()Landroid/location/Location;", "", "getLastUpdateTimestamp", "()J", "setLastUpdateTimestamp", "(J)V", "lastUpdateTimestamp", "core_release"}, k = 1, mv = {1, 4, 2})
public interface GeoStorage {
    @Nullable
    String getFormattedLocation();

    long getLastUpdateTimestamp();

    @Nullable
    Location getLocation();

    void saveLocation(@NotNull Location location);

    void setLastUpdateTimestamp(long j);
}
