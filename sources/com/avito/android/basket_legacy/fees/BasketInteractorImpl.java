package com.avito.android.basket_legacy.fees;

import a2.g.r.g;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.basket_legacy.di.AdvertId;
import com.avito.android.basket_legacy.di.LfRequired;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.BasketStep;
import com.avito.android.basket_legacy.utils.PackageService;
import com.avito.android.basket_legacy.utils.VasService;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertFeesResponse;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.remote.model.SingleFee;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BM\b\u0007\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/basket_legacy/fees/BasketInteractorImpl;", "Lcom/avito/android/basket_legacy/fees/BasketInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", "observeSteps", "()Lio/reactivex/Observable;", "getFirstStep", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "f", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "", AuthSource.BOOKING_ORDER, "Z", "feesRequired", "Lcom/avito/android/basket_legacy/utils/VasType;", "c", "Lcom/avito/android/basket_legacy/utils/VasType;", "defaultVasType", "Lcom/avito/android/fees/remote/FeesApi;", "d", "Lcom/avito/android/fees/remote/FeesApi;", "feesApi", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "e", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverter;", "h", "Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/lang/String;ZLcom/avito/android/basket_legacy/utils/VasType;Lcom/avito/android/fees/remote/FeesApi;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverter;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketInteractorImpl implements BasketInteractor {
    public final String a;
    public final boolean b;
    public final VasType c;
    public final FeesApi d;
    public final PublishAnalyticsDataProvider e;
    public final BasketRepository f;
    public final SchedulersFactory g;
    public final SingleFeeServiceConverter h;

    public static final class a<T> implements Consumer<AdvertFeesResponse> {
        public final /* synthetic */ BasketInteractorImpl a;

        public a(BasketInteractorImpl basketInteractorImpl) {
            this.a = basketInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AdvertFeesResponse advertFeesResponse) {
            AdvertFeesResponse advertFeesResponse2 = advertFeesResponse;
            BasketInteractorImpl basketInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(advertFeesResponse2, "it");
            BasketInteractorImpl.access$saveSingleFeeIfExist(basketInteractorImpl, advertFeesResponse2);
        }
    }

    public static final class b<T, R> implements Function<AdvertFeesResponse, BasketStep> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public BasketStep apply(AdvertFeesResponse advertFeesResponse) {
            AdvertFeesResponse advertFeesResponse2 = advertFeesResponse;
            Intrinsics.checkNotNullParameter(advertFeesResponse2, "it");
            SingleFee singleFee = advertFeesResponse2.getSingleFee();
            Action action = advertFeesResponse2.getAction();
            if (singleFee != null && action != null) {
                return new BasketStep.LfSingleChoice(singleFee, advertFeesResponse2.getMessage(), action);
            }
            if (advertFeesResponse2.getPackages() == null) {
                return new BasketStep.Skip();
            }
            String message = advertFeesResponse2.getMessage();
            List<OwnedPackage> packages = advertFeesResponse2.getPackages();
            Intrinsics.checkNotNull(packages);
            return new BasketStep.PackageChoice(message, packages);
        }
    }

    public static final class c<T, R> implements Function<PackageService, BasketStep.VasChoice> {
        public final /* synthetic */ BasketInteractorImpl a;

        public c(BasketInteractorImpl basketInteractorImpl) {
            this.a = basketInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public BasketStep.VasChoice apply(PackageService packageService) {
            Intrinsics.checkNotNullParameter(packageService, "it");
            return new BasketStep.VasChoice(this.a.c, true);
        }
    }

    public static final class d<T, R> implements Function<List<? extends VasService>, BasketStep.Checkout> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public BasketStep.Checkout apply(List<? extends VasService> list) {
            Intrinsics.checkNotNullParameter(list, "it");
            return new BasketStep.Checkout();
        }
    }

    @Inject
    public BasketInteractorImpl(@AdvertId @NotNull String str, @LfRequired boolean z, @NotNull VasType vasType, @NotNull FeesApi feesApi, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull BasketRepository basketRepository, @NotNull SchedulersFactory schedulersFactory, @NotNull SingleFeeServiceConverter singleFeeServiceConverter) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasType, "defaultVasType");
        Intrinsics.checkNotNullParameter(feesApi, "feesApi");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(singleFeeServiceConverter, "converter");
        this.a = str;
        this.b = z;
        this.c = vasType;
        this.d = feesApi;
        this.e = publishAnalyticsDataProvider;
        this.f = basketRepository;
        this.g = schedulersFactory;
        this.h = singleFeeServiceConverter;
    }

    public static final void access$saveSingleFeeIfExist(BasketInteractorImpl basketInteractorImpl, AdvertFeesResponse advertFeesResponse) {
        Objects.requireNonNull(basketInteractorImpl);
        SingleFee singleFee = advertFeesResponse.getSingleFee();
        if (singleFee != null) {
            basketInteractorImpl.f.addSingleFee(basketInteractorImpl.h.convert(singleFee));
        }
    }

    @Override // com.avito.android.basket_legacy.fees.BasketInteractor
    @NotNull
    public Observable<BasketStep> getFirstStep() {
        if (!this.f.isEmpty()) {
            Observable<BasketStep> just = Observable.just(new BasketStep.Skip());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(BasketStep.Skip())");
            return just;
        } else if (!this.b) {
            Observable<BasketStep> just2 = Observable.just(new BasketStep.VasChoice(this.c, false, 2, null));
            Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(BasketSt…asChoice(defaultVasType))");
            return just2;
        } else {
            Observable<BasketStep> map = InteropKt.toV2(this.d.getItemFees(this.a, this.e.getSessionId())).subscribeOn(this.g.io()).doOnNext(new a(this)).map(b.a);
            Intrinsics.checkNotNullExpressionValue(map, "feesApi.getItemFees(adve…          }\n            }");
            return map;
        }
    }

    @Override // com.avito.android.basket_legacy.fees.BasketInteractor
    @NotNull
    public Observable<BasketStep> observeSteps() {
        Observable<BasketStep> throttleFirst = Observable.merge(this.f.getLfPackageObservable().map(new c(this)), this.f.getVasObservable().map(d.a)).startWith((ObservableSource) getFirstStep()).throttleFirst(100, TimeUnit.MILLISECONDS, this.g.computation());
        Intrinsics.checkNotNullExpressionValue(throttleFirst, "Observable.merge(lfChoic…ersFactory.computation())");
        return throttleFirst;
    }
}
