package com.avito.android.location.find;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/location/find/WeakCallback;", "Lcom/google/android/gms/location/LocationCallback;", "Lcom/google/android/gms/location/LocationResult;", "results", "", "onLocationResult", "(Lcom/google/android/gms/location/LocationResult;)V", "Lcom/google/android/gms/location/LocationAvailability;", "locationAvailability", "onLocationAvailability", "(Lcom/google/android/gms/location/LocationAvailability;)V", "Ljava/lang/ref/WeakReference;", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "weakRef", "callback", "<init>", "(Lcom/google/android/gms/location/LocationCallback;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class WeakCallback extends LocationCallback {
    public final WeakReference<LocationCallback> a;

    public WeakCallback(@NotNull LocationCallback locationCallback) {
        Intrinsics.checkNotNullParameter(locationCallback, "callback");
        this.a = new WeakReference<>(locationCallback);
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationAvailability(@Nullable LocationAvailability locationAvailability) {
        LocationCallback locationCallback = this.a.get();
        if (locationCallback != null) {
            locationCallback.onLocationAvailability(locationAvailability);
        }
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(@NotNull LocationResult locationResult) {
        Intrinsics.checkNotNullParameter(locationResult, "results");
        LocationCallback locationCallback = this.a.get();
        if (locationCallback != null) {
            locationCallback.onLocationResult(locationResult);
        }
    }
}
