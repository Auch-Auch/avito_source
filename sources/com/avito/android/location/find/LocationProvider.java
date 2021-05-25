package com.avito.android.location.find;

import android.app.Activity;
import android.location.Location;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location/find/LocationProvider;", "", "", "isAvailable", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "locationStream", "()Lio/reactivex/rxjava3/core/Observable;", "Landroid/app/Activity;", "activity", "", "setActivity", "(Landroid/app/Activity;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface LocationProvider {
    boolean isAvailable();

    @NotNull
    Observable<Location> locationStream();

    void setActivity(@NotNull Activity activity);
}
