package com.avito.android.advert.item.autoteka.teaser;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractor;
import com.avito.android.autoteka_details.core.analytics.event.AutotekaDetailsGetReportClickEvent;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AutotekaCpoTeaser;
import com.avito.android.remote.model.AutotekaTeaserItemResponseKt;
import com.avito.android.remote.model.AutotekaTeaserResponse;
import com.avito.android.remote.model.AutotekaTeaserResponseKt;
import com.avito.android.remote.model.AutotekaTeaserResult;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.remote.model.CpoReportLink;
import com.avito.android.remote.model.teaser.ReportLink;
import com.avito.android.remote.model.teaser.TeaserError;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\b\b\u0001\u0010+\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010C\u001a\u00020@\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020706¢\u0006\u0004\bD\u0010EJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\fJ#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000207068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010?R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenterImpl;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView;", "view", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView;Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserItem;I)V", "detachView", "()V", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter$Router;)V", "detachRouter", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "loadAutotekaTeaser", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "onClickGetReport", "Lcom/avito/android/remote/model/CpoDescription;", "description", "onClickShowCpoProgram", "(Lcom/avito/android/remote/model/CpoDescription;)V", CommonKt.EXTRA_RESPONSE, AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/AutotekaTeaserResponse;)V", "Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "d", "Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "j", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "teaserTestGroup", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", g.a, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "advertDetailsAnalyticsInteractor", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserView;", "Lcom/avito/android/advert_core/teaser/TeaserObserver;", "i", "Lcom/avito/android/advert_core/teaser/TeaserObserver;", "teaserObserver", "<init>", "(Ljava/lang/String;Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/Features;Lcom/avito/android/advert_core/teaser/TeaserObserver;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutotekaTeaserPresenterImpl implements AdvertDetailsAutotekaTeaserPresenter {
    public AdvertDetailsAutotekaTeaserView a;
    public AdvertDetailsAutotekaTeaserPresenter.Router b;
    public final String c;
    public final AutotekaTeaserInteractor d;
    public final SchedulersFactory3 e;
    public final Analytics f;
    public final AdvertDetailsAnalyticsInteractor g;
    public final Features h;
    public final TeaserObserver i;
    public final ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> j;

    public static final class a<T> implements Consumer<LoadingState<? super AutotekaTeaserResponse>> {
        public final /* synthetic */ AdvertDetailsAutotekaTeaserPresenterImpl a;

        public a(AdvertDetailsAutotekaTeaserPresenterImpl advertDetailsAutotekaTeaserPresenterImpl) {
            this.a = advertDetailsAutotekaTeaserPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super AutotekaTeaserResponse> loadingState) {
            AdvertDetailsAutotekaTeaserView advertDetailsAutotekaTeaserView;
            AutotekaTeaserResult result;
            LoadingState<? super AutotekaTeaserResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                AdvertDetailsAutotekaTeaserView advertDetailsAutotekaTeaserView2 = this.a.a;
                if (advertDetailsAutotekaTeaserView2 != null) {
                    advertDetailsAutotekaTeaserView2.showLoading();
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.a((AutotekaTeaserResponse) loaded.getData());
                if (((AdvertAutotekaTeaserInGalleryTestGroup) this.a.j.getTestGroup()).isTest() && (result = ((AutotekaTeaserResponse) loaded.getData()).getResult()) != null) {
                    this.a.i.pushData(AutotekaTeaserResponseKt.toAutotekaTeaserGalleryModel(result));
                }
            } else if ((loadingState2 instanceof LoadingState.Error) && (advertDetailsAutotekaTeaserView = this.a.a) != null) {
                advertDetailsAutotekaTeaserView.hide();
            }
        }
    }

    @Inject
    public AdvertDetailsAutotekaTeaserPresenterImpl(@AdvertId @NotNull String str, @NotNull AutotekaTeaserInteractor autotekaTeaserInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull Features features, @NotNull TeaserObserver teaserObserver, @NotNull ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(autotekaTeaserInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "advertDetailsAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(teaserObserver, "teaserObserver");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "teaserTestGroup");
        this.c = str;
        this.d = autotekaTeaserInteractor;
        this.e = schedulersFactory3;
        this.f = analytics;
        this.g = advertDetailsAnalyticsInteractor;
        this.h = features;
        this.i = teaserObserver;
        this.j = manuallyExposedAbTestGroup;
    }

    public final void a(AutotekaTeaserResponse autotekaTeaserResponse) {
        AdvertDetailsAutotekaTeaserView advertDetailsAutotekaTeaserView;
        AdvertDetailsAutotekaTeaserView advertDetailsAutotekaTeaserView2;
        AutotekaTeaserResult result = autotekaTeaserResponse.getResult();
        if (!(result == null || (advertDetailsAutotekaTeaserView2 = this.a) == null)) {
            AutotekaCpoTeaser cpo = result.getCpo();
            if (cpo == null) {
                AdvertDetailsAutotekaTeaserView advertDetailsAutotekaTeaserView3 = this.a;
                if (advertDetailsAutotekaTeaserView3 != null) {
                    advertDetailsAutotekaTeaserView3.showTitle(result.getTitle());
                    advertDetailsAutotekaTeaserView3.showSubtitle(result.getSubTitle());
                    advertDetailsAutotekaTeaserView3.showInsights(result.getInsights());
                    advertDetailsAutotekaTeaserView3.showReportLink(result.getReportLink());
                }
            } else {
                advertDetailsAutotekaTeaserView2.bindCpoTeaserData(cpo);
            }
            advertDetailsAutotekaTeaserView2.showResult();
        }
        TeaserError error = autotekaTeaserResponse.getError();
        if (error != null && (advertDetailsAutotekaTeaserView = this.a) != null) {
            advertDetailsAutotekaTeaserView.showError(error);
        }
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter
    public void attachRouter(@NotNull AdvertDetailsAutotekaTeaserPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter
    public void detachView() {
        this.a = null;
        this.i.reset();
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter
    @NotNull
    public Observable<LoadingState<AutotekaTeaserResponse>> loadAutotekaTeaser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Observable<LoadingState<AutotekaTeaserResponse>> doOnNext = InteropKt.toV3(this.d.getAutotekaTeaser(str)).observeOn(this.e.mainThread()).doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "interactor.getAutotekaTe…          }\n            }");
        return doOnNext;
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView.Listener
    public void onClickDialogButton() {
        AdvertDetailsAutotekaTeaserPresenter.DefaultImpls.onClickDialogButton(this);
    }

    @Override // com.avito.android.advert.item.teaser.AdvertDetailsTeaserView.Listener
    public void onClickGetReport() {
        ReportLink reportLink;
        AutotekaCpoTeaser cpo;
        CpoReportLink reportLink2;
        Uri url;
        AutotekaTeaserResponse response = this.d.getResponse();
        Uri uri = null;
        AutotekaTeaserResult result = response != null ? response.getResult() : null;
        if (result != null && (cpo = result.getCpo()) != null && (reportLink2 = cpo.getReportLink()) != null && (url = reportLink2.getUrl()) != null) {
            uri = url;
        } else if (!(result == null || (reportLink = result.getReportLink()) == null)) {
            uri = reportLink.getUrl();
        }
        if (uri != null) {
            if (this.h.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor = this.g;
                String str = this.c;
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                advertDetailsAnalyticsInteractor.sendAutotekaTeaserButtonClick(str, uri2);
            } else {
                Analytics analytics = this.f;
                String str2 = this.c;
                String uri3 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "uri.toString()");
                analytics.track(new AutotekaDetailsGetReportClickEvent(str2, uri3, FromBlock.OLD_TEASER));
            }
            AdvertDetailsAutotekaTeaserPresenter.Router router = this.b;
            if (router != null) {
                router.openAutotekaTeaser(AutotekaTeaserItemResponseKt.appendAutotekaUtmQueryParams(uri));
            }
        }
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserView.Listener
    public void onClickShowCpoProgram(@NotNull CpoDescription cpoDescription) {
        Intrinsics.checkNotNullParameter(cpoDescription, "description");
        AdvertDetailsAutotekaTeaserPresenter.Router router = this.b;
        if (router != null) {
            router.openAutotekaCpoProgramScreen(cpoDescription);
        }
    }

    public void bindView(@NotNull AdvertDetailsAutotekaTeaserView advertDetailsAutotekaTeaserView, @NotNull AdvertDetailsAutotekaTeaserItem advertDetailsAutotekaTeaserItem, int i2) {
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaTeaserView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaTeaserItem, "item");
        this.a = advertDetailsAutotekaTeaserView;
        advertDetailsAutotekaTeaserView.showDivider(advertDetailsAutotekaTeaserItem.getNeedToShowTopDivider());
        AutotekaTeaserResponse response = this.d.getResponse();
        if (response != null) {
            a(response);
        }
    }
}
