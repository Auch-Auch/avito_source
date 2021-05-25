package com.avito.android.advert.item.delivery;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.delivery.DeliveryButtonItemClickEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeliveryStartOrderingDeepLink;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenterImpl;", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter$Router;)V", "detachRouter", "()V", "", "categoryId", "setCategoryId", "(Ljava/lang/String;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "isDeliveryButtonClicked", "followUri", "(Landroid/net/Uri;Z)V", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "h", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", g.a, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "d", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/account/AccountStateProvider;", "f", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/Features;", "i", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryStorage;", "e", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryStorage;", "storage", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/advert/item/delivery/AdvertDeliveryStorage;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDeliveryPresenterImpl implements AdvertDeliveryPresenter {
    public String a;
    public AdvertDeliveryPresenter.Router b;
    public final String c;
    public final DeepLinkFactory d;
    public final AdvertDeliveryStorage e;
    public final AccountStateProvider f;
    public final AdvertDetailsAnalyticsInteractor g;
    public final Analytics h;
    public final Features i;

    @Inject
    public AdvertDeliveryPresenterImpl(@AdvertId @NotNull String str, @NotNull DeepLinkFactory deepLinkFactory, @NotNull AdvertDeliveryStorage advertDeliveryStorage, @NotNull AccountStateProvider accountStateProvider, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(advertDeliveryStorage, "storage");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = str;
        this.d = deepLinkFactory;
        this.e = advertDeliveryStorage;
        this.f = accountStateProvider;
        this.g = advertDetailsAnalyticsInteractor;
        this.h = analytics;
        this.i = features;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDeliveryPresenter
    public void attachRouter(@NotNull AdvertDeliveryPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDeliveryPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsView.Router
    public void followUri(@NotNull Uri uri, boolean z) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        DeepLink createFromUri = this.d.createFromUri(uri);
        this.e.setCreateOrderWasClicked();
        boolean z2 = false;
        if (createFromUri.getPath().length() == 0) {
            AdvertDeliveryPresenter.Router router = this.b;
            if (router != null) {
                router.followDeliveryExternalLink(uri);
                return;
            }
            return;
        }
        AdvertDeliveryPresenter.Router router2 = this.b;
        if (Intrinsics.areEqual(router2 != null ? Boolean.valueOf(router2.followDeliveryDeepLink(createFromUri)) : null, Boolean.TRUE)) {
            String currentUserId = this.f.getCurrentUserId();
            String str = this.a;
            boolean isAuthorized = this.f.isAuthorized();
            if (z && (createFromUri instanceof DeliveryStartOrderingDeepLink)) {
                z2 = true;
            }
            if (!z2 || currentUserId == null || str == null) {
                if (!z) {
                    this.g.sendDeliveryInfoClick(this.c, str);
                }
            } else if (this.i.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                this.g.sendDeliveryButtonClick(this.c, currentUserId, str, "item", isAuthorized);
            } else {
                this.h.track(new DeliveryButtonItemClickEvent(this.c, currentUserId, str, "item", isAuthorized));
            }
        }
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDeliveryPresenter
    public void setCategoryId(@Nullable String str) {
        this.a = str;
    }
}
