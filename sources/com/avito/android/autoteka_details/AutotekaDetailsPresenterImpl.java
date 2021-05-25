package com.avito.android.autoteka_details;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.AutotekaDetailsExampleReportClickEvent;
import com.avito.android.analytics.event.AutotekaDetailsOpenScreenEvent;
import com.avito.android.autoteka_details.AutotekaDetailsNavigation;
import com.avito.android.autoteka_details.AutotekaDetailsPresenter;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.core.analytics.event.AutotekaDetailsGetReportClickEvent;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.autoteka_details.di.IsRestored;
import com.avito.android.autoteka_details.di.UtmQuery;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.remote.model.AutotekaTeaserItemResponseKt;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\b\u0007\u0012\b\b\u0001\u0010#\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010'\u001a\u00020$\u0012\b\b\u0001\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsPresenterImpl;", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;", "Lcom/avito/android/autoteka_details/AutotekaDetailsView;", "view", "", "attachView", "(Lcom/avito/android/autoteka_details/AutotekaDetailsView;)V", "detachView", "()V", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter$Router;)V", "detachRouter", AuthSource.SEND_ABUSE, "Lcom/avito/android/autoteka_details/AutotekaDetailsConverter;", g.a, "Lcom/avito/android/autoteka_details/AutotekaDetailsConverter;", "autotekaDetailsConverter", "c", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter$Router;", "", "e", "Ljava/lang/String;", "utmQuery", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "f", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", AuthSource.BOOKING_ORDER, "Lcom/avito/android/autoteka_details/AutotekaDetailsView;", "d", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "isRestored", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;Lcom/avito/android/autoteka_details/AutotekaDetailsConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Z)V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsPresenterImpl implements AutotekaDetailsPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public AutotekaDetailsView b;
    public AutotekaDetailsPresenter.Router c;
    public final String d;
    public final String e;
    public final AutotekaDetailsInteractor f;
    public final AutotekaDetailsConverter g;
    public final SchedulersFactory h;
    public final Analytics i;

    public static final class a extends Lambda implements Function1<AutotekaDetailsNavigation, Unit> {
        public final /* synthetic */ AutotekaDetailsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl) {
            super(1);
            this.a = autotekaDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AutotekaDetailsNavigation autotekaDetailsNavigation) {
            AutotekaDetailsNavigation autotekaDetailsNavigation2 = autotekaDetailsNavigation;
            if (autotekaDetailsNavigation2 instanceof AutotekaDetailsNavigation.Back) {
                AutotekaDetailsPresenter.Router router = this.a.c;
                if (router != null) {
                    router.onBackClicked();
                }
            } else if (autotekaDetailsNavigation2 instanceof AutotekaDetailsNavigation.ExampleReport) {
                AutotekaDetailsPresenterImpl.access$exampleReportButtonClicked(this.a, (AutotekaDetailsNavigation.ExampleReport) autotekaDetailsNavigation2);
            } else if (autotekaDetailsNavigation2 instanceof AutotekaDetailsNavigation.GetReport) {
                AutotekaDetailsPresenterImpl.access$receiveReportButtonClicked(this.a, (AutotekaDetailsNavigation.GetReport) autotekaDetailsNavigation2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ AutotekaDetailsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl) {
            super(1);
            this.a = autotekaDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Unit unit) {
            this.a.a();
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super AutotekaDetailsResponse>> {
        public final /* synthetic */ AutotekaDetailsPresenterImpl a;

        public c(AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl) {
            this.a = autotekaDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super AutotekaDetailsResponse> loadingState) {
            LoadingState<? super AutotekaDetailsResponse> loadingState2 = loadingState;
            AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            AutotekaDetailsPresenterImpl.access$onGetDetailsSubscriptionStateChanged(autotekaDetailsPresenterImpl, loadingState2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ AutotekaDetailsPresenterImpl a;

        public d(AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl) {
            this.a = autotekaDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            AutotekaDetailsView autotekaDetailsView = this.a.b;
            if (autotekaDetailsView != null) {
                autotekaDetailsView.showError();
            }
        }
    }

    @Inject
    public AutotekaDetailsPresenterImpl(@AdvertId @NotNull String str, @UtmQuery @Nullable String str2, @NotNull AutotekaDetailsInteractor autotekaDetailsInteractor, @NotNull AutotekaDetailsConverter autotekaDetailsConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @IsRestored boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(autotekaDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(autotekaDetailsConverter, "autotekaDetailsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.d = str;
        this.e = str2;
        this.f = autotekaDetailsInteractor;
        this.g = autotekaDetailsConverter;
        this.h = schedulersFactory;
        this.i = analytics;
        if (!z) {
            analytics.track(new AutotekaDetailsOpenScreenEvent(str));
        }
    }

    public static final void access$exampleReportButtonClicked(AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl, AutotekaDetailsNavigation.ExampleReport exampleReport) {
        AutotekaDetailsPresenter.Router router = autotekaDetailsPresenterImpl.c;
        if (router != null) {
            router.reportExampleClicked(exampleReport.getUrl());
        }
        Analytics analytics = autotekaDetailsPresenterImpl.i;
        String str = autotekaDetailsPresenterImpl.d;
        String uri = exampleReport.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "it.url.toString()");
        analytics.track(new AutotekaDetailsExampleReportClickEvent(str, uri));
    }

    public static final Unit access$onGetDetailsSubscriptionStateChanged(AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(autotekaDetailsPresenterImpl);
        if (loadingState instanceof LoadingState.Loading) {
            AutotekaDetailsView autotekaDetailsView = autotekaDetailsPresenterImpl.b;
            if (autotekaDetailsView == null) {
                return null;
            }
            autotekaDetailsView.startLoad();
            return Unit.INSTANCE;
        } else if (loadingState instanceof LoadingState.Loaded) {
            AutotekaDetails convert = autotekaDetailsPresenterImpl.g.convert((AutotekaDetailsResponse) ((LoadingState.Loaded) loadingState).getData());
            AutotekaDetailsView autotekaDetailsView2 = autotekaDetailsPresenterImpl.b;
            if (autotekaDetailsView2 != null) {
                autotekaDetailsView2.showData(convert);
            }
            return Unit.INSTANCE;
        } else if (loadingState instanceof LoadingState.Error) {
            AutotekaDetailsView autotekaDetailsView3 = autotekaDetailsPresenterImpl.b;
            if (autotekaDetailsView3 == null) {
                return null;
            }
            autotekaDetailsView3.showError();
            return Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void access$receiveReportButtonClicked(AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl, AutotekaDetailsNavigation.GetReport getReport) {
        String str = autotekaDetailsPresenterImpl.e;
        if (str != null) {
            if (!(str.length() == 0)) {
                AutotekaDetailsPresenter.Router router = autotekaDetailsPresenterImpl.c;
                if (router != null) {
                    router.receiveReportClicked(autotekaDetailsPresenterImpl.d, autotekaDetailsPresenterImpl.e);
                }
                Analytics analytics = autotekaDetailsPresenterImpl.i;
                String str2 = autotekaDetailsPresenterImpl.d;
                String uri = getReport.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "navigation.url.toString()");
                analytics.track(new AutotekaDetailsGetReportClickEvent(str2, uri, FromBlock.OLD_TEASER));
            }
        }
        AutotekaDetailsPresenter.Router router2 = autotekaDetailsPresenterImpl.c;
        if (router2 != null) {
            router2.receiveReportClicked(AutotekaTeaserItemResponseKt.appendAutotekaUtmQueryParams(getReport.getUrl()));
        }
        Analytics analytics = autotekaDetailsPresenterImpl.i;
        String str2 = autotekaDetailsPresenterImpl.d;
        String uri = getReport.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "navigation.url.toString()");
        analytics.track(new AutotekaDetailsGetReportClickEvent(str2, uri, FromBlock.OLD_TEASER));
    }

    public final void a() {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.f.getAutotekaItem().observeOn(this.h.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getAutotekaIt…}, { view?.showError() })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter
    public void attachRouter(@NotNull AutotekaDetailsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter
    public void attachView(@NotNull AutotekaDetailsView autotekaDetailsView) {
        Intrinsics.checkNotNullParameter(autotekaDetailsView, "view");
        this.b = autotekaDetailsView;
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, autotekaDetailsView.getNavigationClick(), "view.navigationClick\n   …(schedulers.mainThread())"), new a(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, autotekaDetailsView.getRefreshClick(), "view.refreshClick\n      …(schedulers.mainThread())"), new b(this)));
        a();
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsPresenter
    public void detachView() {
        this.a.clear();
        this.b = null;
    }
}
