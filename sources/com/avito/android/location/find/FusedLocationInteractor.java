package com.avito.android.location.find;

import android.app.Activity;
import android.location.Location;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/location/find/FusedLocationInteractor;", "", "Lio/reactivex/rxjava3/core/Single;", "Landroid/location/Location;", "requestDeviceLocation", "()Lio/reactivex/rxjava3/core/Single;", "", "showLocationEnableDialog", "isDeviceLocationEnabled", "(Z)Lio/reactivex/rxjava3/core/Single;", "accessGoogleServices", "()Z", "Landroid/app/Activity;", "activity", "", "setActivity", "(Landroid/app/Activity;)V", "", "getEnableLocationRequestCode", "()I", "enableLocationRequestCode", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface FusedLocationInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static int getEnableLocationRequestCode(@NotNull FusedLocationInteractor fusedLocationInteractor) {
            return 69;
        }

        public static /* synthetic */ Single isDeviceLocationEnabled$default(FusedLocationInteractor fusedLocationInteractor, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return fusedLocationInteractor.isDeviceLocationEnabled(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isDeviceLocationEnabled");
        }
    }

    boolean accessGoogleServices();

    int getEnableLocationRequestCode();

    @NotNull
    Single<Boolean> isDeviceLocationEnabled(boolean z);

    @NotNull
    Single<Location> requestDeviceLocation();

    void setActivity(@NotNull Activity activity);
}
