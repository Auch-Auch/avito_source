package com.avito.android.advert.item.shorttermrent;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentView;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.shorttermrent.StrSafedealBookingButtonEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.StrStartBookingDeepLink;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\b\u0007\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenterImpl;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter$Router;)V", "detachRouter", "()V", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;)V", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView;", "view", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentItem;", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView;Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentItem;I)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "followUri", "(Landroid/net/Uri;)V", "", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter$Router;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "f", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "e", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "advertDetailsAnalyticsInteractor", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", g.a, "Lcom/avito/android/Features;", "features", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsShortTermRentPresenterImpl implements AdvertDetailsShortTermRentPresenter {
    public AdvertDetailsShortTermRentPresenter.Router a;
    public AdvertDetailsShortTermRentView.Listener b;
    public final String c;
    public final Analytics d;
    public final AdvertDetailsAnalyticsInteractor e;
    public final DeepLinkFactory f;
    public final Features g;

    @Inject
    public AdvertDetailsShortTermRentPresenterImpl(@AdvertId @NotNull String str, @NotNull Analytics analytics, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull DeepLinkFactory deepLinkFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "advertDetailsAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = str;
        this.d = analytics;
        this.e = advertDetailsAnalyticsInteractor;
        this.f = deepLinkFactory;
        this.g = features;
    }

    @Override // com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter
    public void attachRouter(@NotNull AdvertDetailsShortTermRentPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter
    public void followUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        DeepLink createFromUri = this.f.createFromUri(uri);
        if (createFromUri instanceof StrStartBookingDeepLink) {
            StrStartBookingDeepLink strStartBookingDeepLink = (StrStartBookingDeepLink) createFromUri;
            String source = strStartBookingDeepLink.getSource();
            if (this.g.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                this.e.sendShortTermRentButtonClick(this.c, source);
            } else {
                this.d.track(new StrSafedealBookingButtonEvent(this.c, strStartBookingDeepLink.getSource()));
            }
        }
        AdvertDetailsShortTermRentPresenter.Router router = this.a;
        if (router != null) {
            router.followShortTermRentLink(createFromUri);
        }
    }

    @Override // com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter
    public void setListener(@NotNull AdvertDetailsShortTermRentView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = listener;
    }

    public void bindView(@NotNull AdvertDetailsShortTermRentView advertDetailsShortTermRentView, @NotNull AdvertDetailsShortTermRentItem advertDetailsShortTermRentItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsShortTermRentView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsShortTermRentItem, "item");
        advertDetailsShortTermRentView.showShortTermRent(advertDetailsShortTermRentItem.getShortTermRent(), this.f, this.b);
    }
}
