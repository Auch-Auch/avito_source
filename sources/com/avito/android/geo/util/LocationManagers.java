package com.avito.android.geo.util;

import android.location.LocationListener;
import android.location.LocationManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/location/LocationManager;", "Landroid/location/LocationListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "safeRemoveUpdates", "(Landroid/location/LocationManager;Landroid/location/LocationListener;)V", "geo_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "LocationManagers")
public final class LocationManagers {
    public static final void safeRemoveUpdates(@NotNull LocationManager locationManager, @NotNull LocationListener locationListener) {
        Intrinsics.checkNotNullParameter(locationManager, "$this$safeRemoveUpdates");
        Intrinsics.checkNotNullParameter(locationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable unused) {
        }
    }
}
