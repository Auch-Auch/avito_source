package com.avito.android.geo;

import android.content.SharedPreferences;
import android.location.Location;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.preferences.Preferences;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/geo/PrefGeoStorage;", "Lcom/avito/android/geo/GeoStorage;", "Landroid/location/Location;", "location", "", "saveLocation", "(Landroid/location/Location;)V", "", "getFormattedLocation", "()Ljava/lang/String;", "", "timestamp", "getLastUpdateTimestamp", "()J", "setLastUpdateTimestamp", "(J)V", "lastUpdateTimestamp", "getLocation", "()Landroid/location/Location;", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PrefGeoStorage implements GeoStorage {
    public final Preferences a;

    public PrefGeoStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0015: INVOKE  (r4v0 double) = (r0v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double), (';' char), (wrap: double : 0x0021: INVOKE  (r5v0 double) = (r0v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double), (';' char), (wrap: double : 0x002f: CAST (r5v1 double) = (double) (wrap: float : 0x002b: INVOKE  (r0v2 float) = (r0v0 android.location.Location) type: VIRTUAL call: android.location.Location.getAccuracy():float)), (';' char), (r1v1 long)] */
    @Override // com.avito.android.geo.GeoStorage
    @Nullable
    public String getFormattedLocation() {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(location.getTime());
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        sb.append(';');
        sb.append(location.getLongitude());
        sb.append(';');
        sb.append((double) location.getAccuracy());
        sb.append(';');
        sb.append(seconds);
        return sb.toString();
    }

    @Override // com.avito.android.geo.GeoStorage
    public long getLastUpdateTimestamp() {
        return this.a.getLong(GeoContract.LAST_UPDATE_TIMESTAMP, 0);
    }

    @Override // com.avito.android.geo.GeoStorage
    @Nullable
    public Location getLocation() {
        Location location;
        synchronized (PrefGeoStorageKt.access$getLocationLock$p()) {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences();
            float f = sharedPreferences.getFloat(GeoContract.LATITUDE, -90.0f);
            float f2 = sharedPreferences.getFloat(GeoContract.LONGITUDE, -180.0f);
            float f3 = sharedPreferences.getFloat(GeoContract.ACCURACY, -1.0f);
            long j = sharedPreferences.getLong("time", -1);
            if (f > -90.0f && f2 > -180.0f && f3 > ((float) 0)) {
                if (j > 0) {
                    location = new Location(sharedPreferences.getString(GeoContract.PROVIDER, "unknown"));
                    location.setLatitude((double) f);
                    location.setLongitude((double) f2);
                    location.setAccuracy(f3);
                    location.setTime(j);
                }
            }
            location = null;
        }
        return location;
    }

    @Override // com.avito.android.geo.GeoStorage
    public void saveLocation(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        synchronized (PrefGeoStorageKt.access$getLocationLock$p()) {
            this.a.getSharedPreferences().edit().putString(GeoContract.PROVIDER, location.getProvider()).putFloat(GeoContract.LATITUDE, (float) location.getLatitude()).putFloat(GeoContract.LONGITUDE, (float) location.getLongitude()).putFloat(GeoContract.ACCURACY, location.getAccuracy()).putLong("time", location.getTime()).apply();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.geo.GeoStorage
    public void setLastUpdateTimestamp(long j) {
        this.a.putLong(GeoContract.LAST_UPDATE_TIMESTAMP, j);
    }
}
