package com.avito.android.location.find;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/location/find/FindDetectLocationPresenterImpl;", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "Landroid/app/Activity;", "activity", "", "showDialog", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/location/Location;", "findLocation", "(Landroid/app/Activity;Z)Lio/reactivex/rxjava3/core/Observable;", "Landroid/content/Context;", "context", "", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "Lcom/avito/android/location/find/DetectLocationProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location/find/DetectLocationProvider;", "detectLocationProvider", "Lcom/avito/android/location/find/DefaultLocationProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location/find/DefaultLocationProvider;", "defaultLocationProvider", "<init>", "(Lcom/avito/android/location/find/DefaultLocationProvider;Lcom/avito/android/location/find/DetectLocationProvider;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class FindDetectLocationPresenterImpl implements FindDetectLocationPresenter {
    public final DefaultLocationProvider a;
    public final DetectLocationProvider b;

    @Inject
    public FindDetectLocationPresenterImpl(@NotNull DefaultLocationProvider defaultLocationProvider, @NotNull DetectLocationProvider detectLocationProvider) {
        Intrinsics.checkNotNullParameter(defaultLocationProvider, "defaultLocationProvider");
        Intrinsics.checkNotNullParameter(detectLocationProvider, "detectLocationProvider");
        this.a = defaultLocationProvider;
        this.b = detectLocationProvider;
    }

    @Override // com.avito.android.location.find.FindLocationPresenter
    @NotNull
    public Observable<Location> findLocation(@NotNull Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a.setActivity(activity);
        if (this.a.isAvailable()) {
            return this.a.locationStream();
        }
        return this.b.locationStream(z);
    }

    @Override // com.avito.android.location.find.FindLocationPresenter
    public void registerLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a.registerLocationReceiver(context);
    }

    @Override // com.avito.android.location.find.FindLocationPresenter
    public void unregisterLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a.unregisterLocationReceiver(context);
    }
}
