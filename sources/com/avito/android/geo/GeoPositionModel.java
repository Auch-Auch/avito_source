package com.avito.android.geo;

import android.location.Location;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.version_conflict.ConfigStorage;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/geo/GeoPositionModel;", "", "Landroid/location/Location;", "location", "", "onLocationUpdated", "(Landroid/location/Location;)V", "", "isLocationExpired", "()Z", "Lcom/avito/android/version_conflict/ConfigStorage;", "c", "Lcom/avito/android/version_conflict/ConfigStorage;", "configStorage", "getLocation", "()Landroid/location/Location;", "Lcom/avito/android/server_time/TimeSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/geo/GeoStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/geo/GeoStorage;Lcom/avito/android/version_conflict/ConfigStorage;)V", "geo_release"}, k = 1, mv = {1, 4, 2})
public class GeoPositionModel {
    public final TimeSource a;
    public final GeoStorage b;
    public final ConfigStorage c;

    @Inject
    public GeoPositionModel(@NotNull TimeSource timeSource, @NotNull GeoStorage geoStorage, @NotNull ConfigStorage configStorage) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        Intrinsics.checkNotNullParameter(configStorage, "configStorage");
        this.a = timeSource;
        this.b = geoStorage;
        this.c = configStorage;
    }

    @Nullable
    public final Location getLocation() {
        return this.b.getLocation();
    }

    public boolean isLocationExpired() {
        long geoReportTimeout = this.c.getGeoReportTimeout();
        if (geoReportTimeout == 0) {
            return false;
        }
        if (1 <= geoReportTimeout && GeoPositionModelKt.MIN_GEO_REPORT_TIMEOUT > geoReportTimeout) {
            geoReportTimeout = 600000;
        }
        if (this.b.getLastUpdateTimestamp() + geoReportTimeout < this.a.now()) {
            return true;
        }
        return false;
    }

    public final void onLocationUpdated(@Nullable Location location) {
        if (location != null) {
            this.b.saveLocation(location);
        }
        this.b.setLastUpdateTimestamp(this.a.now());
    }
}
