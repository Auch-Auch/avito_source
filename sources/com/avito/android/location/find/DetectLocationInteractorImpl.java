package com.avito.android.location.find;

import android.location.Location;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/location/find/DetectLocationInteractorImpl;", "Lcom/avito/android/location/find/DetectLocationInteractor;", "", "showDialog", "Lio/reactivex/Observable;", "Landroid/location/Location;", "detectLocation", "(Z)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/location/find/util/DetectLocationHelper;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location/find/util/DetectLocationHelper;", "locationHelper", "", AuthSource.BOOKING_ORDER, "I", "timeoutMs", "Lcom/avito/android/geo/GeoStorage;", "d", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "<init>", "(Lcom/avito/android/location/find/util/DetectLocationHelper;ILcom/avito/android/util/SchedulersFactory;Lcom/avito/android/geo/GeoStorage;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class DetectLocationInteractorImpl implements DetectLocationInteractor {
    public final DetectLocationHelper a;
    public final int b;
    public final SchedulersFactory c;
    public final GeoStorage d;

    public DetectLocationInteractorImpl(@NotNull DetectLocationHelper detectLocationHelper, int i, @NotNull SchedulersFactory schedulersFactory, @NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(detectLocationHelper, "locationHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        this.a = detectLocationHelper;
        this.b = i;
        this.c = schedulersFactory;
        this.d = geoStorage;
    }

    @Override // com.avito.android.location.find.DetectLocationInteractor
    @NotNull
    public Observable<Location> detectLocation(boolean z) {
        Observable<Location> subscribeOn = Observable.create(new DetectLocationInteractorImpl$detectLocation$1(this, z)).subscribeOn(this.c.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable.create<Locati…(schedulers.mainThread())");
        return subscribeOn;
    }
}
