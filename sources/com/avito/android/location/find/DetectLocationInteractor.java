package com.avito.android.location.find;

import android.location.Location;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/location/find/DetectLocationInteractor;", "", "", "showDialog", "Lio/reactivex/Observable;", "Landroid/location/Location;", "detectLocation", "(Z)Lio/reactivex/Observable;", "LocationDisabledException", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface DetectLocationInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable detectLocation$default(DetectLocationInteractor detectLocationInteractor, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return detectLocationInteractor.detectLocation(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: detectLocation");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/location/find/DetectLocationInteractor$LocationDisabledException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "user-location_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocationDisabledException extends Exception {
    }

    @NotNull
    Observable<Location> detectLocation(boolean z);
}
