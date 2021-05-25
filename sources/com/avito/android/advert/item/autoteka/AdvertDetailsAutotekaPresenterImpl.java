package com.avito.android.advert.item.autoteka;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.autoteka.AdvertDetailsAutotekaClickEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010!\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00105\u001a\u000202¢\u0006\u0004\b@\u0010AJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u0004\u0018\u00010\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenterImpl;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView;", "view", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView;Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaItem;I)V", "attachView", "(Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView;)V", "detachView", "()V", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter$Router;)V", "detachRouter", "loadAutoteka", "onClickGetAutotekaReport", "", "isRequestDisposed", "()Z", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "state", AuthSource.SEND_ABUSE, "(Lcom/avito/android/util/LoadingState;)Lkotlin/Unit;", "", "e", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaView;", "d", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "cachedResponse", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "f", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "interactor", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "i", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "advertDetailsAnalyticsInteractor", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "j", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "h", "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter$Router;", "Lio/reactivex/rxjava3/disposables/Disposable;", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "<init>", "(Ljava/lang/String;Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutotekaPresenterImpl implements AdvertDetailsAutotekaPresenter {
    public AdvertDetailsAutotekaView a;
    public AdvertDetailsAutotekaPresenter.Router b;
    public Disposable c;
    public AutotekaDetailsResponse d;
    public final String e;
    public final AutotekaDetailsInteractor f;
    public final SchedulersFactory3 g;
    public final Analytics h;
    public final AdvertDetailsAnalyticsInteractor i;
    public final Features j;

    public static final class a<T> implements Consumer<LoadingState<? super AutotekaDetailsResponse>> {
        public final /* synthetic */ AdvertDetailsAutotekaPresenterImpl a;

        public a(AdvertDetailsAutotekaPresenterImpl advertDetailsAutotekaPresenterImpl) {
            this.a = advertDetailsAutotekaPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super AutotekaDetailsResponse> loadingState) {
            LoadingState<? super AutotekaDetailsResponse> loadingState2 = loadingState;
            AdvertDetailsAutotekaPresenterImpl advertDetailsAutotekaPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            advertDetailsAutotekaPresenterImpl.a(loadingState2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    @Inject
    public AdvertDetailsAutotekaPresenterImpl(@AdvertId @NotNull String str, @NotNull AutotekaDetailsInteractor autotekaDetailsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(autotekaDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "advertDetailsAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        this.e = str;
        this.f = autotekaDetailsInteractor;
        this.g = schedulersFactory3;
        this.h = analytics;
        this.i = advertDetailsAnalyticsInteractor;
        this.j = features;
    }

    public final Unit a(LoadingState<? super AutotekaDetailsResponse> loadingState) {
        if (loadingState instanceof LoadingState.Loading) {
            return Unit.INSTANCE;
        }
        if (loadingState instanceof LoadingState.Loaded) {
            if (this.d == null) {
                this.d = (AutotekaDetailsResponse) ((LoadingState.Loaded) loadingState).getData();
            }
            AdvertDetailsAutotekaView advertDetailsAutotekaView = this.a;
            if (advertDetailsAutotekaView == null) {
                return null;
            }
            advertDetailsAutotekaView.showData(((AutotekaDetailsResponse) ((LoadingState.Loaded) loadingState).getData()).getVin());
            return Unit.INSTANCE;
        } else if (loadingState instanceof LoadingState.Error) {
            return Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter
    public void attachRouter(@NotNull AdvertDetailsAutotekaPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter
    public void attachView(@NotNull AdvertDetailsAutotekaView advertDetailsAutotekaView) {
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaView, "view");
        this.a = advertDetailsAutotekaView;
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter
    public void detachView() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = null;
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter
    public boolean isRequestDisposed() {
        Disposable disposable = this.c;
        return disposable == null || disposable.isDisposed();
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter
    public void loadAutoteka() {
        AutotekaDetailsResponse autotekaDetailsResponse = this.d;
        if (autotekaDetailsResponse != null) {
            a(new LoadingState.Loaded(autotekaDetailsResponse));
        } else {
            this.c = InteropKt.toV3(this.f.getAutotekaItem()).observeOn(this.g.mainThread()).subscribe(new a(this), b.a);
        }
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaView.Listener
    public void onClickGetAutotekaReport() {
        if (this.j.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
            this.i.sendAutotekaButtonClick(this.e);
        } else {
            this.h.track(new AdvertDetailsAutotekaClickEvent(this.e));
        }
        AdvertDetailsAutotekaPresenter.Router router = this.b;
        if (router != null) {
            router.showAutoteka(this.f.getAutotekaDetails());
        }
    }

    public void bindView(@NotNull AdvertDetailsAutotekaView advertDetailsAutotekaView, @NotNull AdvertDetailsAutotekaItem advertDetailsAutotekaItem, int i2) {
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaItem, "item");
        advertDetailsAutotekaView.setAutotekaListener(this);
        attachView(advertDetailsAutotekaView);
        advertDetailsAutotekaView.setNeedToShowTopDivider(advertDetailsAutotekaItem.getNeedToShowTopDivider());
        loadAutoteka();
    }
}
