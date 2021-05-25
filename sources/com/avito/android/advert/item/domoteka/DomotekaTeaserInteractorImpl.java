package com.avito.android.advert.item.domoteka;

import com.avito.android.Features;
import com.avito.android.domteka.DomotekaApi;
import com.avito.android.remote.ApartmentNumberRequestResponse;
import com.avito.android.remote.DomotekaTeaserResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001f\u0010 J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractorImpl;", "Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/DomotekaTeaserResponse;", "getDomotekaTeaser", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/ApartmentNumberRequestResponse;", "getApartmentNumberRequestLink", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Ljava/util/concurrent/atomic/AtomicReference;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/atomic/AtomicReference;", "domotekaTeaser", "Lcom/avito/android/domteka/DomotekaApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/domteka/DomotekaApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "state", "<init>", "(Lcom/avito/android/domteka/DomotekaApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Lcom/avito/android/util/Kundle;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class DomotekaTeaserInteractorImpl implements DomotekaTeaserInteractor {
    public final AtomicReference<DomotekaTeaserResponse> a;
    public final DomotekaApi b;
    public final SchedulersFactory3 c;
    public final Features d;

    public static final class a<T, R> implements Function<DomotekaTeaserResponse, LoadingState<? super DomotekaTeaserResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DomotekaTeaserResponse> apply(DomotekaTeaserResponse domotekaTeaserResponse) {
            return new LoadingState.Loaded(domotekaTeaserResponse);
        }
    }

    @Inject
    public DomotekaTeaserInteractorImpl(@NotNull DomotekaApi domotekaApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @DomotekaTeaserInteractorState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(domotekaApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = domotekaApi;
        this.c = schedulersFactory3;
        this.d = features;
        this.a = new AtomicReference<>(kundle != null ? (DomotekaTeaserResponse) kundle.getParcelable("domoteka_teaser_key") : null);
    }

    @Override // com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor
    @NotNull
    public Observable<ApartmentNumberRequestResponse> getApartmentNumberRequestLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return a2.b.a.a.a.a2(this.c, this.b.getApartmentNumberRequestLink(str), "api.getApartmentNumberRe…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor
    @NotNull
    public Observable<LoadingState<DomotekaTeaserResponse>> getDomotekaTeaser(@NotNull String str) {
        Observable observable;
        Observable<DomotekaTeaserResponse> observable2;
        Intrinsics.checkNotNullParameter(str, "itemId");
        DomotekaTeaserResponse domotekaTeaserResponse = this.a.get();
        if (domotekaTeaserResponse == null) {
            observable = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.empty()");
        } else {
            observable = Observable.just(domotekaTeaserResponse);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(teaser)");
        }
        if (this.d.getDomotekaTeaserV2WithStub().invoke().booleanValue()) {
            observable2 = this.b.getDomotekaDynamicTeaserV2(str);
        } else {
            observable2 = this.b.getDomotekaDynamicTeaser(str);
        }
        Observable<DomotekaTeaserResponse> subscribeOn = observable2.doOnNext(new a2.a.a.f.x.u.a(this)).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "if (features.domotekaTea…scribeOn(schedulers.io())");
        Observable<LoadingState<DomotekaTeaserResponse>> startWith = observable.switchIfEmpty(subscribeOn).map(a.a).startWith(Observable.just(LoadingState.Loading.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(startWith, "buildDomotekaTeaserObser…st(LoadingState.Loading))");
        return startWith;
    }

    @Override // com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("domoteka_teaser_key", this.a.get());
        return kundle;
    }
}
