package com.avito.android.location.find;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/location/find/DefaultLocationProviderImpl;", "Lcom/avito/android/location/find/DefaultLocationProvider;", "Landroid/content/Context;", "context", "", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "", "isAvailable", "()Z", "Landroid/app/Activity;", "activity", "setActivity", "(Landroid/app/Activity;)V", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "locationStream", "()Lio/reactivex/rxjava3/core/Observable;", "", AuthSource.SEND_ABUSE, "J", "timeoutMs", "Lcom/avito/android/location/find/DefaultLocationInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location/find/DefaultLocationInteractor;", "defaultLocationInteractor", "<init>", "(JLcom/avito/android/location/find/DefaultLocationInteractor;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultLocationProviderImpl implements DefaultLocationProvider {
    public final long a;
    public DefaultLocationInteractor b;

    public DefaultLocationProviderImpl(long j, @NotNull DefaultLocationInteractor defaultLocationInteractor) {
        Intrinsics.checkNotNullParameter(defaultLocationInteractor, "defaultLocationInteractor");
        this.a = j;
        this.b = defaultLocationInteractor;
    }

    @Override // com.avito.android.location.find.LocationProvider
    public boolean isAvailable() {
        return !this.b.accessGoogleServices();
    }

    @Override // com.avito.android.location.find.LocationProvider
    @NotNull
    public Observable<Location> locationStream() {
        Observable<Location> throttleFirst = this.b.findLocation().toObservable().throttleFirst(this.a, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleFirst, "defaultLocationInteracto…s, TimeUnit.MILLISECONDS)");
        return throttleFirst;
    }

    @Override // com.avito.android.location.find.DefaultLocationProvider
    public void registerLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b.registerLocationReceiver(context);
    }

    @Override // com.avito.android.location.find.LocationProvider
    public void setActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b.setActivity(activity);
    }

    @Override // com.avito.android.location.find.DefaultLocationProvider
    public void unregisterLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b.unregisterLocationReceiver(context);
    }
}
