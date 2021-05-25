package com.avito.android.location.find;

import android.location.Location;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/location/find/DetectLocationProvider;", "", "", "showDialog", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "locationStream", "(Z)Lio/reactivex/rxjava3/core/Observable;", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface DetectLocationProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable locationStream$default(DetectLocationProvider detectLocationProvider, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return detectLocationProvider.locationStream(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: locationStream");
        }
    }

    @NotNull
    Observable<Location> locationStream(boolean z);
}
