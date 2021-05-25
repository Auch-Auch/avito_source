package com.avito.android;

import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/TopLocationInteractorImpl;", "Lcom/avito/android/TopLocationInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Location;", "getTopLocation", "()Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Location;", "topLocation", "Lcom/avito/android/remote/LocationApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/LocationApi;", "locationApi", "<init>", "(Lcom/avito/android/remote/LocationApi;)V", "top-location_release"}, k = 1, mv = {1, 4, 2})
public final class TopLocationInteractorImpl implements TopLocationInteractor {
    public Location a;
    public final LocationApi b;

    public static final class a<T> implements Consumer<Location> {
        public final /* synthetic */ TopLocationInteractorImpl a;

        public a(TopLocationInteractorImpl topLocationInteractorImpl) {
            this.a = topLocationInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            this.a.a = location;
        }
    }

    public TopLocationInteractorImpl(@NotNull LocationApi locationApi) {
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        this.b = locationApi;
    }

    @Override // com.avito.android.TopLocationInteractor
    @NotNull
    public Observable<Location> getTopLocation() {
        Location location = this.a;
        if (location != null) {
            Observable<Location> just = Observable.just(location);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            if (just != null) {
                return just;
            }
        }
        Observable<Location> doOnNext = this.b.getTopLocation().doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "locationApi.getTopLocati…Next { topLocation = it }");
        return doOnNext;
    }
}
