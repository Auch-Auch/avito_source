package com.avito.android.messenger.map.viewing;

import a2.a.a.o1.e.d.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/map/viewing/PlatformMapInteractorImpl;", "Lcom/avito/android/messenger/map/viewing/PlatformMapInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "geoMarkersObservable", "()Lio/reactivex/rxjava3/core/Observable;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/MessengerClient;", "client", AuthSource.SEND_ABUSE, "[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "c", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "<init>", "([Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lru/avito/messenger/MessengerClient;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMapInteractorImpl implements PlatformMapInteractor {
    public final GeoMarker[] a;
    public final MessengerClient<AvitoMessengerApi> b;
    public final MarkersRequest c;

    @Inject
    public PlatformMapInteractorImpl(@NotNull GeoMarker[] geoMarkerArr, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @Nullable MarkersRequest markersRequest) {
        Intrinsics.checkNotNullParameter(geoMarkerArr, "initialGeoMarkers");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        this.a = geoMarkerArr;
        this.b = messengerClient;
        this.c = markersRequest;
    }

    @Override // com.avito.android.messenger.map.viewing.PlatformMapInteractor
    @NotNull
    public Observable<GeoMarker[]> geoMarkersObservable() {
        Observable<GeoMarker[]> just = Observable.just(this.a);
        MarkersRequest markersRequest = this.c;
        if (markersRequest != null) {
            Single<GeoMarker[]> doOnSuccess = this.b.getGeoMarkers(markersRequest).doOnSuccess(a.a);
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "client.getGeoMarkers(mar…m server: $it\")\n        }");
            just = just.concatWith(InteropKt.toV3(doOnSuccess));
        } else {
            Logs.verbose$default("PlatformMapInteractor", "markersRequest == null, using initialGeoMarkers only", null, 4, null);
        }
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(initialG…s\n            }\n        }");
        return just;
    }
}
