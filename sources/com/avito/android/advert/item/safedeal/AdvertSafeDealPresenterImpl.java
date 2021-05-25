package com.avito.android.advert.item.safedeal;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.advert.AdvertFeedbackView;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.delivery.SafeDealBuyButtonClickEvent;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.contactbar.feedback.analytics.FeedbackCloseEvent;
import com.avito.android.advert_core.contactbar.feedback.analytics.FeedbackShowEvent;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import io.reactivex.rxjava3.kotlin.SubscribersKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001Be\b\u0007\u0012\b\b\u0001\u0010D\u001a\u00020\u000e\u0012\n\b\u0001\u0010m\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010[\u001a\u00020X\u0012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\¢\u0006\u0004\bn\u0010oJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010\u001bJ!\u0010!\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b!\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\bJ\u0019\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b/\u00100R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u00102R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u00102R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u00104R\u0018\u0010m\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u00102¨\u0006p"}, d2 = {"Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter$Router;)V", "detachRouter", "()V", "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "view", "attachCoreView", "(Lcom/avito/android/advert_core/advert/AdvertCoreView;)V", "detachView", "", "categoryId", "setCategoryId", "(Ljava/lang/String;)V", "userHashId", "setUserHashId", "", "isMarketplace", "setIsMarketplace", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followInfoDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "orderTypes", "followLegacyButtonDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "followButtonDeepLink", "followLabelDeepLink", "followTrustFactorsDeepLink", "followServicesDeepLink", "showNoPurchaseFeedbackIfNeeded", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "source", "onFeedbackClose", "(Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "feedback", "onFeedbackSend", "(Ljava/lang/String;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "d", "Z", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", VKApiConst.Q, "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "csLinkHandler", "e", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter$Router;", "j", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/account/AccountStateProvider;", "l", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/Features;", "p", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "n", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "feedbackInteractor", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "coreView", "Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "r", "Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "feedbackPreferences", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", "s", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "marketplaceNoPurchaseFeedbackTestGroup", "c", "", g.a, "J", "startTimeOfPurchaseButtonClick", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "h", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "noPurchaseFeedbackState", "i", "feedbackDialogShouldShown", "k", "context", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/deep_linking/ClickStreamLinkHandler;Lcom/avito/android/advert_core/feedback/FeedbackPreferences;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSafeDealPresenterImpl implements AdvertSafeDealPresenter {
    public AdvertCoreView a;
    public String b;
    public String c;
    public boolean d;
    public AdvertSafeDealPresenter.Router e;
    public final CompositeDisposable f = new CompositeDisposable();
    public long g;
    public FeedbackDialog.State h;
    public boolean i;
    public final String j;
    public final String k;
    public final AccountStateProvider l;
    public final AdvertDetailsAnalyticsInteractor m;
    public final FeedbackInteractor n;
    public final Analytics o;
    public final Features p;
    public final ClickStreamLinkHandler q;
    public final FeedbackPreferences r;
    public final ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> s;

    @Inject
    public AdvertSafeDealPresenterImpl(@AdvertId @NotNull String str, @AdvertFragmentModule.SearchContext @Nullable String str2, @NotNull AccountStateProvider accountStateProvider, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull FeedbackInteractor feedbackInteractor, @NotNull Analytics analytics, @NotNull Features features, @NotNull ClickStreamLinkHandler clickStreamLinkHandler, @NotNull FeedbackPreferences feedbackPreferences, @NotNull ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> manuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(feedbackInteractor, "feedbackInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(clickStreamLinkHandler, "csLinkHandler");
        Intrinsics.checkNotNullParameter(feedbackPreferences, "feedbackPreferences");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "marketplaceNoPurchaseFeedbackTestGroup");
        this.j = str;
        this.k = str2;
        this.l = accountStateProvider;
        this.m = advertDetailsAnalyticsInteractor;
        this.n = feedbackInteractor;
        this.o = analytics;
        this.p = features;
        this.q = clickStreamLinkHandler;
        this.r = feedbackPreferences;
        this.s = manuallyExposedAbTestGroup;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void attachCoreView(@Nullable AdvertCoreView advertCoreView) {
        this.a = advertCoreView;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void attachRouter(@NotNull AdvertSafeDealPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void detachRouter() {
        this.e = null;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void detachView() {
        this.a = null;
    }

    @Override // com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonView.Router
    public void followButtonDeepLink(@NotNull DeepLink deepLink, @Nullable String str) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.g = System.currentTimeMillis();
        if (deepLink instanceof ClickStreamLink) {
            this.q.handleDeepLink((ClickStreamLink) deepLink, new Function1<DeepLink, Unit>(this) { // from class: com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl$followButtonDeepLink$$inlined$followDeepLink$1
                public final /* synthetic */ AdvertSafeDealPresenterImpl a;

                {
                    this.a = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DeepLink deepLink2) {
                    invoke(deepLink2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull DeepLink deepLink2) {
                    Intrinsics.checkNotNullParameter(deepLink2, "redirect");
                    AdvertSafeDealPresenter.Router router = this.a.e;
                    if (router != null) {
                        router.followSafeDealDeepLink(deepLink2);
                    }
                }
            });
        } else {
            AdvertSafeDealPresenter.Router router = this.e;
            if (router != null) {
                router.followSafeDealDeepLink(deepLink);
            }
        }
        String currentUserId = this.l.getCurrentUserId();
        String str2 = this.b;
        boolean isAuthorized = this.l.isAuthorized();
        if (currentUserId != null && str2 != null) {
            if (this.p.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                this.m.sendSafeDealBuyButtonClick(this.j, currentUserId, str2, "item", isAuthorized, str, this.k);
                return;
            }
            this.o.track(new SafeDealBuyButtonClickEvent(this.j, currentUserId, str2, "item", isAuthorized, str, this.k, false, 128, null));
        }
    }

    @Override // com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoView.Router
    public void followInfoDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ClickStreamLink) {
            this.q.handleDeepLink((ClickStreamLink) deepLink, new Function1<DeepLink, Unit>(this) { // from class: com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl$followInfoDeepLink$$inlined$followDeepLink$1
                public final /* synthetic */ AdvertSafeDealPresenterImpl a;

                {
                    this.a = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DeepLink deepLink2) {
                    invoke(deepLink2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull DeepLink deepLink2) {
                    Intrinsics.checkNotNullParameter(deepLink2, "redirect");
                    AdvertSafeDealPresenter.Router router = this.a.e;
                    if (router != null) {
                        router.followSafeDealDeepLink(deepLink2);
                    }
                }
            });
            return;
        }
        AdvertSafeDealPresenter.Router router = this.e;
        if (router != null) {
            router.followSafeDealDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelView.Router
    public void followLabelDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ClickStreamLink) {
            this.q.handleDeepLink((ClickStreamLink) deepLink, new Function1<DeepLink, Unit>(this) { // from class: com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl$followLabelDeepLink$$inlined$followDeepLink$1
                public final /* synthetic */ AdvertSafeDealPresenterImpl a;

                {
                    this.a = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DeepLink deepLink2) {
                    invoke(deepLink2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull DeepLink deepLink2) {
                    Intrinsics.checkNotNullParameter(deepLink2, "redirect");
                    AdvertSafeDealPresenter.Router router = this.a.e;
                    if (router != null) {
                        router.followSafeDealDeepLink(deepLink2);
                    }
                }
            });
        } else {
            AdvertSafeDealPresenter.Router router = this.e;
            if (router != null) {
                router.followSafeDealDeepLink(deepLink);
            }
        }
        this.m.sendDeliveryInfoClick(this.j, this.b);
    }

    @Override // com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonView.Router
    public void followLegacyButtonDeepLink(@NotNull DeepLink deepLink, @Nullable String str) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        followButtonDeepLink(deepLink, str);
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView.Router
    public void followServicesDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ClickStreamLink) {
            this.q.handleDeepLink((ClickStreamLink) deepLink, new Function1<DeepLink, Unit>(this) { // from class: com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl$followServicesDeepLink$$inlined$followDeepLink$1
                public final /* synthetic */ AdvertSafeDealPresenterImpl a;

                {
                    this.a = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DeepLink deepLink2) {
                    invoke(deepLink2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull DeepLink deepLink2) {
                    Intrinsics.checkNotNullParameter(deepLink2, "redirect");
                    AdvertSafeDealPresenter.Router router = this.a.e;
                    if (router != null) {
                        router.followSafeDealDeepLink(deepLink2);
                    }
                }
            });
            return;
        }
        AdvertSafeDealPresenter.Router router = this.e;
        if (router != null) {
            router.followSafeDealDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsView.Router
    public void followTrustFactorsDeepLink(@NotNull DeepLink deepLink, @Nullable String str) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ClickStreamLink) {
            this.q.handleDeepLink((ClickStreamLink) deepLink, new Function1<DeepLink, Unit>(this) { // from class: com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl$followTrustFactorsDeepLink$$inlined$followDeepLink$1
                public final /* synthetic */ AdvertSafeDealPresenterImpl a;

                {
                    this.a = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DeepLink deepLink2) {
                    invoke(deepLink2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull DeepLink deepLink2) {
                    Intrinsics.checkNotNullParameter(deepLink2, "redirect");
                    AdvertSafeDealPresenter.Router router = this.a.e;
                    if (router != null) {
                        router.followSafeDealDeepLink(deepLink2);
                    }
                }
            });
            return;
        }
        AdvertSafeDealPresenter.Router router = this.e;
        if (router != null) {
            router.followSafeDealDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.feedback.FeedbackDialog.Listener
    public void onFeedbackClose(@Nullable FeedbackDialog.Source source) {
        this.o.track(new FeedbackCloseEvent(this.b, null, this.j, null, 10, null));
        AdvertCoreView advertCoreView = this.a;
        if (advertCoreView != null) {
            AdvertFeedbackView.DefaultImpls.clearFeedbackState$default(advertCoreView, false, 1, null);
        }
        this.h = null;
        this.i = false;
    }

    @Override // com.avito.android.advert_core.contactbar.feedback.FeedbackDialog.Listener
    public void onFeedbackSend(@NotNull String str, @Nullable FeedbackDialog.Source source) {
        Intrinsics.checkNotNullParameter(str, "feedback");
        DisposableKt.plusAssign(this.f, SubscribersKt.subscribeBy$default(this.n.sendFeedback(str, this.j, this.c, this.b, source), new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }, (Function0) null, (Function1) null, 6, (Object) null));
        AdvertCoreView advertCoreView = this.a;
        if (advertCoreView != null) {
            advertCoreView.clearFeedbackState(true);
        }
        this.h = null;
        this.i = false;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void restoreState(@Nullable Bundle bundle) {
        this.g = bundle != null ? bundle.getLong("c2ckeyStartTimeOfPurchaseButtonClick") : 0;
        this.h = bundle != null ? (FeedbackDialog.State) bundle.getParcelable("c2cfeedbackDialogState") : null;
        this.i = bundle != null ? bundle.getBoolean("c2cfeedbackDialogShouldBeShown") : false;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putLong("c2ckeyStartTimeOfPurchaseButtonClick", this.g);
        AdvertCoreView advertCoreView = this.a;
        bundle.putParcelable("c2cfeedbackDialogState", advertCoreView != null ? advertCoreView.getFeedbackState() : null);
        bundle.putBoolean("c2cfeedbackDialogShouldBeShown", this.i);
        return bundle;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void setCategoryId(@Nullable String str) {
        this.b = str;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void setIsMarketplace(boolean z) {
        this.d = z;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void setUserHashId(@Nullable String str) {
        this.c = str;
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter
    public void showNoPurchaseFeedbackIfNeeded() {
        if (this.p.getMarketplaceNoPurchaseFeedback().invoke().booleanValue()) {
            FeedbackDialog.State state = this.h;
            if (state != null && this.i) {
                AdvertCoreView advertCoreView = this.a;
                if (advertCoreView != null) {
                    Intrinsics.checkNotNull(state);
                    advertCoreView.showFeedback(state, this);
                }
            } else if (!this.r.wasFeedbackShown() && this.d) {
                if (System.currentTimeMillis() - this.g < 15000) {
                    this.s.expose();
                    if (this.s.getTestGroup().isTest()) {
                        this.r.setFeedbackWasShown();
                        AdvertCoreView advertCoreView2 = this.a;
                        if (advertCoreView2 != null) {
                            advertCoreView2.showFeedback(new FeedbackDialog.State(R.string.marketplace_no_purchase_feedback_title, Integer.valueOf(R.string.feedback_title_secondary), "", R.string.feedback_input_hint, R.string.feedback_send, null, 32, null), this);
                        }
                        this.o.track(new FeedbackShowEvent(null, this.b, null, this.j, null, 21, null));
                        this.i = true;
                    }
                }
            } else {
                return;
            }
            this.g = 0;
        }
    }
}
