package com.avito.android.location.find;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/location/find/FindLocationPresenter;", "", "Landroid/app/Activity;", "activity", "", "showDialog", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "findLocation", "(Landroid/app/Activity;Z)Lio/reactivex/rxjava3/core/Observable;", "Landroid/content/Context;", "context", "", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface FindLocationPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable findLocation$default(FindLocationPresenter findLocationPresenter, Activity activity, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return findLocationPresenter.findLocation(activity, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findLocation");
        }
    }

    @NotNull
    Observable<Location> findLocation(@NotNull Activity activity, boolean z);

    void registerLocationReceiver(@NotNull Context context);

    void unregisterLocationReceiver(@NotNull Context context);
}
