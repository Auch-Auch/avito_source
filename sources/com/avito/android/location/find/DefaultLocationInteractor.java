package com.avito.android.location.find;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/location/find/DefaultLocationInteractor;", "", "Lio/reactivex/rxjava3/core/Single;", "Landroid/location/Location;", "findLocation", "()Lio/reactivex/rxjava3/core/Single;", "Landroid/content/Context;", "context", "", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "", "accessGoogleServices", "()Z", "Landroid/app/Activity;", "activity", "setActivity", "(Landroid/app/Activity;)V", "Lio/reactivex/rxjava3/core/SingleEmitter;", "getActiveLocation", "()Lio/reactivex/rxjava3/core/SingleEmitter;", "activeLocation", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface DefaultLocationInteractor {
    boolean accessGoogleServices();

    @NotNull
    Single<Location> findLocation();

    @Nullable
    SingleEmitter<Location> getActiveLocation();

    void registerLocationReceiver(@NotNull Context context);

    void setActivity(@NotNull Activity activity);

    void unregisterLocationReceiver(@NotNull Context context);
}
