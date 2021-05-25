package com.avito.android.location.find;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/location/find/FindLocationPresenterImpl;", "Lcom/avito/android/location/find/FindLocationPresenter;", "Landroid/app/Activity;", "activity", "", "showDialog", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "findLocation", "(Landroid/app/Activity;Z)Lio/reactivex/rxjava3/core/Observable;", "Landroid/content/Context;", "context", "", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "", "Lcom/avito/android/location/find/LocationProvider;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "providers", "Lcom/avito/android/location/find/DefaultLocationProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location/find/DefaultLocationProvider;", "defaultLocationProvider", "Lcom/avito/android/location/find/GoogleServicesLocationProvider;", "googleServicesLocationProvider", "<init>", "(Lcom/avito/android/location/find/DefaultLocationProvider;Lcom/avito/android/location/find/GoogleServicesLocationProvider;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class FindLocationPresenterImpl implements FindLocationPresenter {
    public final List<LocationProvider> a;
    public final DefaultLocationProvider b;

    @Inject
    public FindLocationPresenterImpl(@NotNull DefaultLocationProvider defaultLocationProvider, @NotNull GoogleServicesLocationProvider googleServicesLocationProvider) {
        Intrinsics.checkNotNullParameter(defaultLocationProvider, "defaultLocationProvider");
        Intrinsics.checkNotNullParameter(googleServicesLocationProvider, "googleServicesLocationProvider");
        this.b = defaultLocationProvider;
        this.a = CollectionsKt__CollectionsKt.mutableListOf(defaultLocationProvider, googleServicesLocationProvider);
    }

    @Override // com.avito.android.location.find.FindLocationPresenter
    @NotNull
    public Observable<Location> findLocation(@NotNull Activity activity, boolean z) {
        T t;
        Observable<Location> locationStream;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setActivity(activity);
        }
        Iterator<T> it2 = this.a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.isAvailable()) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null && (locationStream = t2.locationStream()) != null) {
            return locationStream;
        }
        Observable<Location> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    @Override // com.avito.android.location.find.FindLocationPresenter
    public void registerLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b.registerLocationReceiver(context);
    }

    @Override // com.avito.android.location.find.FindLocationPresenter
    public void unregisterLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b.unregisterLocationReceiver(context);
    }
}
