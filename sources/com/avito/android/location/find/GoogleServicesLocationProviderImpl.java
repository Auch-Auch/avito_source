package com.avito.android.location.find;

import android.app.Activity;
import android.location.Location;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/location/find/GoogleServicesLocationProviderImpl;", "Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "", "isAvailable", "()Z", "Landroid/app/Activity;", "activity", "", "setActivity", "(Landroid/app/Activity;)V", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "locationStream", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location/find/FusedLocationInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location/find/FusedLocationInteractor;", "fusedLocationInteractor", "<init>", "(Lcom/avito/android/location/find/FusedLocationInteractor;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class GoogleServicesLocationProviderImpl implements GoogleServicesLocationProvider {
    public FusedLocationInteractor a;

    @Inject
    public GoogleServicesLocationProviderImpl(@NotNull FusedLocationInteractor fusedLocationInteractor) {
        Intrinsics.checkNotNullParameter(fusedLocationInteractor, "fusedLocationInteractor");
        this.a = fusedLocationInteractor;
    }

    @Override // com.avito.android.location.find.LocationProvider
    public boolean isAvailable() {
        return this.a.accessGoogleServices();
    }

    @Override // com.avito.android.location.find.LocationProvider
    @NotNull
    public Observable<Location> locationStream() {
        Observable<Location> observable = this.a.requestDeviceLocation().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "fusedLocationInteractor.…          .toObservable()");
        return observable;
    }

    @Override // com.avito.android.location.find.LocationProvider
    public void setActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.setActivity(activity);
    }
}
