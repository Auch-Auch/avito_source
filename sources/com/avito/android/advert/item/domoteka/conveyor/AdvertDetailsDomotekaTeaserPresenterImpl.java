package com.avito.android.advert.item.domoteka.conveyor;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.remote.DomotekaTeaser;
import com.avito.android.remote.DomotekaTeaserResponse;
import com.avito.android.remote.DomotekaTeaserType;
import com.avito.android.remote.ReportLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.ConstantsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R$\u0010'\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenterImpl;", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter;", "", "detachView", "()V", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "view", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserItem;", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserItem;I)V", "showFlatNumberRequestDialog", "Lcom/avito/android/account/AccountStateProvider;", g.a, "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "f", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/Disposable;", "teaserSubscription", "Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "e", "Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "interactor", "c", "flatNumberRequestSubscription", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;", "getRouter", "()Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;", "setRouter", "(Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;)V", "router", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "scheduler", "d", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "teaserView", "<init>", "(Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDomotekaTeaserPresenterImpl implements AdvertDetailsDomotekaTeaserPresenter {
    @Nullable
    public AdvertDetailsDomotekaTeaserPresenter.Router a;
    public Disposable b;
    public Disposable c;
    public AdvertDetailsTeaserView d;
    public final DomotekaTeaserInteractor e;
    public final AdvertDetailsAnalyticsInteractor f;
    public final AccountStateProvider g;
    public final SchedulersFactory3 h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DomotekaTeaserType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a<T> implements Consumer<LoadingState<? super DomotekaTeaserResponse>> {
        public final /* synthetic */ AdvertDetailsDomotekaTeaserPresenterImpl a;
        public final /* synthetic */ AdvertDetailsTeaserView b;
        public final /* synthetic */ AdvertDetailsDomotekaTeaserItem c;

        public a(AdvertDetailsDomotekaTeaserPresenterImpl advertDetailsDomotekaTeaserPresenterImpl, AdvertDetailsTeaserView advertDetailsTeaserView, AdvertDetailsDomotekaTeaserItem advertDetailsDomotekaTeaserItem) {
            this.a = advertDetailsDomotekaTeaserPresenterImpl;
            this.b = advertDetailsTeaserView;
            this.c = advertDetailsDomotekaTeaserItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DomotekaTeaserResponse> loadingState) {
            ReportLink reportLink;
            LoadingState<? super DomotekaTeaserResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.b.hide();
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                DomotekaTeaser result = ((DomotekaTeaserResponse) ((LoadingState.Loaded) loadingState2).getData()).getResult();
                if (result != null && (reportLink = result.getReportLink()) != null) {
                    DomotekaTeaserType type = result.getType();
                    String title = result.getTitle();
                    String subtitle = result.getSubtitle();
                    String title2 = reportLink.getTitle();
                    StringBuilder L = a2.b.a.a.a.L(ConstantsKt.DEFAULT_ORIGIN);
                    L.append(reportLink.getUrl());
                    Uri parse = Uri.parse(L.toString());
                    Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(\"https://www.a…o.ru${domotekaLink.url}\")");
                    com.avito.android.remote.model.teaser.ReportLink reportLink2 = new com.avito.android.remote.model.teaser.ReportLink(title2, parse);
                    List<TeaserInsight> insights = result.getInsights();
                    if (insights == null) {
                        insights = CollectionsKt__CollectionsKt.emptyList();
                    }
                    AdvertDetailsTeaserView advertDetailsTeaserView = this.b;
                    if (title != null) {
                        advertDetailsTeaserView.showTitle(title);
                    }
                    if (subtitle != null) {
                        advertDetailsTeaserView.showSubtitle(subtitle);
                    }
                    advertDetailsTeaserView.showInsights(insights);
                    advertDetailsTeaserView.showReportLink(reportLink2);
                    advertDetailsTeaserView.showResult();
                    advertDetailsTeaserView.showDivider(this.c.getShowDivider());
                    advertDetailsTeaserView.setListener(new AdvertDetailsDomotekaTeaserPresenterImpl$bindView$1$$special$$inlined$with$lambda$1(this, title, subtitle, insights, reportLink2, type));
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.b.hide();
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ AdvertDetailsTeaserView a;

        public b(AdvertDetailsTeaserView advertDetailsTeaserView) {
            this.a = advertDetailsTeaserView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.hide();
            Logs.error("Error when try get domoteka teaser", th);
        }
    }

    @Inject
    public AdvertDetailsDomotekaTeaserPresenterImpl(@NotNull DomotekaTeaserInteractor domotekaTeaserInteractor, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(domotekaTeaserInteractor, "interactor");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "scheduler");
        this.e = domotekaTeaserInteractor;
        this.f = advertDetailsAnalyticsInteractor;
        this.g = accountStateProvider;
        this.h = schedulersFactory3;
        Disposable a3 = s6.a.e.c.b.a();
        Intrinsics.checkNotNullExpressionValue(a3, "Disposable.empty()");
        this.b = a3;
        Disposable a4 = s6.a.e.c.b.a();
        Intrinsics.checkNotNullExpressionValue(a4, "Disposable.empty()");
        this.c = a4;
    }

    public static final void access$requestFlatNumber(AdvertDetailsDomotekaTeaserPresenterImpl advertDetailsDomotekaTeaserPresenterImpl, String str) {
        Disposable subscribe = advertDetailsDomotekaTeaserPresenterImpl.e.getApartmentNumberRequestLink(str).observeOn(advertDetailsDomotekaTeaserPresenterImpl.h.mainThread()).subscribe(new a2.a.a.f.x.u.b.a(advertDetailsDomotekaTeaserPresenterImpl), a2.a.a.f.x.u.b.b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getApartmentN…t number\")\n            })");
        advertDetailsDomotekaTeaserPresenterImpl.c = subscribe;
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter
    public void detachView() {
        this.b.dispose();
        this.c.dispose();
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter
    @Nullable
    public AdvertDetailsDomotekaTeaserPresenter.Router getRouter() {
        return this.a;
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter
    public void setRouter(@Nullable AdvertDetailsDomotekaTeaserPresenter.Router router) {
        this.a = router;
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter
    public void showFlatNumberRequestDialog() {
        this.f.sendDomotekaStubButtonClick();
        AdvertDetailsTeaserView advertDetailsTeaserView = this.d;
        if (advertDetailsTeaserView != null) {
            advertDetailsTeaserView.showDialog();
        }
    }

    public void bindView(@NotNull AdvertDetailsTeaserView advertDetailsTeaserView, @NotNull AdvertDetailsDomotekaTeaserItem advertDetailsDomotekaTeaserItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsTeaserView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsDomotekaTeaserItem, "item");
        this.d = advertDetailsTeaserView;
        this.b.dispose();
        Disposable subscribe = this.e.getDomotekaTeaser(advertDetailsDomotekaTeaserItem.getAdvertId()).observeOn(this.h.mainThread()).subscribe(new a(this, advertDetailsTeaserView, advertDetailsDomotekaTeaserItem), new b(advertDetailsTeaserView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…aser\", it)\n            })");
        this.b = subscribe;
    }
}
