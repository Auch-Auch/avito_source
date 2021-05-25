package com.avito.android.location_picker;

import android.location.Location;
import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH&¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location_picker/LocationPickerBinder;", "", "Lio/reactivex/rxjava3/disposables/Disposable;", "bind", "()Lio/reactivex/rxjava3/disposables/Disposable;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "getCurrentState", "()Lcom/avito/android/location_picker/entities/LocationPickerState;", "Lcom/avito/android/location_picker/LocationPickerBinder$Router;", "router", "", "attachRouter", "(Lcom/avito/android/location_picker/LocationPickerBinder$Router;)V", "detachRouter", "()V", "sendScreenExitAfterCoordinatesResolve", "Router", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface LocationPickerBinder {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/location_picker/LocationPickerBinder$Router;", "", "Lio/reactivex/rxjava3/core/Single;", "Landroid/location/Location;", "findLocation", "()Lio/reactivex/rxjava3/core/Single;", "", "accessGoogleServices", "()Z", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static boolean accessGoogleServices(@NotNull Router router) {
                return true;
            }
        }

        boolean accessGoogleServices();

        @NotNull
        Single<Location> findLocation();
    }

    void attachRouter(@NotNull Router router);

    @NotNull
    Disposable bind();

    void detachRouter();

    @Nullable
    LocationPickerState getCurrentState();

    void sendScreenExitAfterCoordinatesResolve();
}
