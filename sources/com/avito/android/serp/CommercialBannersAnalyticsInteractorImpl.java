package com.avito.android.serp;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.analytics.BannerEvent;
import com.avito.android.serp.analytics.BannerLoadedEvent;
import com.avito.android.serp.analytics.BannerOpenEvent;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.serp.analytics.BannerPassbackEvent;
import com.avito.android.serp.analytics.BannerRenderEvent;
import com.avito.android.serp.analytics.BannerRequestEvent;
import com.avito.android.serp.analytics.BannerViewEvent;
import com.avito.android.serp.analytics.OpenAdInfo;
import com.avito.android.serp.analytics.ReturnAfterShowBannerEvent;
import com.vk.sdk.api.VKApiConst;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u00102\u001a\u00020/\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b7\u00108J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJE\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017JQ\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\bR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/serp/CommercialBannersAnalyticsInteractorImpl;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "bannerType", "", "sendBannerRequested", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "sendBannerPassback", "", VKApiConst.POSITION, "", "categoryId", "locationId", BookingInfoActivity.EXTRA_ITEM_ID, "sendBannerOpened", "(Lcom/avito/android/serp/ad/BannerInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "returnToScreen", "()V", "", "samplingEnabled", "sendBannerLoaded", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/serp/analytics/BannerEvent$Type;)V", "", "throwable", CommonKt.TAG_ERROR_CODE, "sendBannerLoadingFailed", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/serp/analytics/BannerEvent$Type;)V", "sendBannerView", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "e", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Ljavax/inject/Provider;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "d", "Ljavax/inject/Provider;", "parentProvider", "Lcom/avito/android/serp/CommercialBannerTimeProvider;", "f", "Lcom/avito/android/serp/CommercialBannerTimeProvider;", "timeProvider", "Lcom/avito/android/serp/analytics/OpenAdInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/analytics/OpenAdInfo;", "openAdInfo", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/serp/analytics/BannerPageSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/analytics/BannerPageSource;", "source", "<init>", "(Lcom/avito/android/serp/analytics/BannerPageSource;Lcom/avito/android/analytics/Analytics;Ljavax/inject/Provider;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/serp/CommercialBannerTimeProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class CommercialBannersAnalyticsInteractorImpl implements CommercialBannersAnalyticsInteractor {
    public OpenAdInfo a;
    public final BannerPageSource b;
    public final Analytics c;
    public final Provider<TreeClickStreamParent> d;
    public final TreeStateIdGenerator e;
    public final CommercialBannerTimeProvider f;

    @Inject
    public CommercialBannersAnalyticsInteractorImpl(@NotNull BannerPageSource bannerPageSource, @NotNull Analytics analytics, @Nullable Provider<TreeClickStreamParent> provider, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull CommercialBannerTimeProvider commercialBannerTimeProvider) {
        Intrinsics.checkNotNullParameter(bannerPageSource, "source");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(commercialBannerTimeProvider, "timeProvider");
        this.b = bannerPageSource;
        this.c = analytics;
        this.d = provider;
        this.e = treeStateIdGenerator;
        this.f = commercialBannerTimeProvider;
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void returnToScreen() {
        OpenAdInfo openAdInfo = this.a;
        if (openAdInfo != null) {
            this.c.track(new ReturnAfterShowBannerEvent(System.currentTimeMillis() - openAdInfo.getTimestamp(), openAdInfo.getClickId()));
            this.a = null;
        }
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerLoaded(@NotNull BannerInfo bannerInfo, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        Analytics analytics = this.c;
        BannerPageSource bannerPageSource = this.b;
        long nextStateId = this.e.nextStateId();
        long timestamp = this.f.getTimestamp();
        Provider<TreeClickStreamParent> provider = this.d;
        analytics.track(new BannerLoadedEvent(bannerInfo, bannerPageSource, type, str, str2, str3, nextStateId, timestamp, provider != null ? provider.get() : null));
        if (z && bannerInfo.hasAlidAndBannerCode()) {
            Analytics analytics2 = this.c;
            BannerPageSource bannerPageSource2 = this.b;
            long nextStateId2 = this.e.nextStateId();
            long timestamp2 = this.f.getTimestamp();
            Provider<TreeClickStreamParent> provider2 = this.d;
            analytics2.track(new BannerRenderEvent(bannerInfo, bannerPageSource2, type, nextStateId2, timestamp2, provider2 != null ? provider2.get() : null));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0050  */
    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendBannerLoadingFailed(@org.jetbrains.annotations.NotNull com.avito.android.serp.ad.BannerInfo r17, @org.jetbrains.annotations.Nullable java.lang.String r18, @org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.Nullable java.lang.Throwable r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.Nullable java.lang.Integer r22, @org.jetbrains.annotations.NotNull com.avito.android.serp.analytics.BannerEvent.Type r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r20
            java.lang.String r2 = "bannerInfo"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.String r2 = "bannerType"
            r6 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            boolean r2 = r1 instanceof com.avito.android.serp.ad.YandexBannerLoader.YandexBannerLoadingException
            if (r2 == 0) goto L_0x0022
            com.avito.android.serp.ad.YandexBannerLoader$YandexBannerLoadingException r1 = (com.avito.android.serp.ad.YandexBannerLoader.YandexBannerLoadingException) r1
            int r1 = r1.getCode()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0020:
            r10 = r1
            goto L_0x0033
        L_0x0022:
            boolean r2 = r1 instanceof com.avito.android.serp.ad.DfpBannerLoader.DfpBannerLoadingException
            if (r2 == 0) goto L_0x0031
            com.avito.android.serp.ad.DfpBannerLoader$DfpBannerLoadingException r1 = (com.avito.android.serp.ad.DfpBannerLoader.DfpBannerLoadingException) r1
            int r1 = r1.getErrorCode()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0020
        L_0x0031:
            r10 = r22
        L_0x0033:
            com.avito.android.analytics.Analytics r1 = r0.c
            com.avito.android.serp.analytics.BannerLoadingFailedEvent r2 = new com.avito.android.serp.analytics.BannerLoadingFailedEvent
            com.avito.android.serp.analytics.BannerPageSource r5 = r0.b
            com.avito.android.analytics.provider.TreeStateIdGenerator r3 = r0.e
            long r11 = r3.nextStateId()
            com.avito.android.serp.CommercialBannerTimeProvider r3 = r0.f
            long r13 = r3.getTimestamp()
            javax.inject.Provider<com.avito.android.analytics.provider.clickstream.TreeClickStreamParent> r3 = r0.d
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r3.get()
            com.avito.android.analytics.provider.clickstream.TreeClickStreamParent r3 = (com.avito.android.analytics.provider.clickstream.TreeClickStreamParent) r3
            goto L_0x0051
        L_0x0050:
            r3 = 0
        L_0x0051:
            r15 = r3
            r3 = r2
            r4 = r17
            r6 = r23
            r7 = r18
            r8 = r19
            r9 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r13, r15)
            r1.track(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl.sendBannerLoadingFailed(com.avito.android.serp.ad.BannerInfo, java.lang.String, java.lang.String, java.lang.Throwable, java.lang.String, java.lang.Integer, com.avito.android.serp.analytics.BannerEvent$Type):void");
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerOpened(@NotNull BannerInfo bannerInfo, int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        if (!bannerInfo.getWasOpened()) {
            bannerInfo.setWasOpened(true);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
            Analytics analytics = this.c;
            BannerPageSource bannerPageSource = this.b;
            long nextStateId = this.e.nextStateId();
            long timestamp = this.f.getTimestamp();
            Provider<TreeClickStreamParent> provider = this.d;
            analytics.track(new BannerOpenEvent(bannerInfo, bannerPageSource, type, str, str2, str3, i, uuid, nextStateId, timestamp, provider != null ? provider.get() : null));
            this.a = new OpenAdInfo(System.currentTimeMillis(), uuid);
        }
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerPassback(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        if (bannerInfo.hasAlidAndBannerCode()) {
            Analytics analytics = this.c;
            BannerPageSource bannerPageSource = this.b;
            long nextStateId = this.e.nextStateId();
            long timestamp = this.f.getTimestamp();
            Provider<TreeClickStreamParent> provider = this.d;
            analytics.track(new BannerPassbackEvent(bannerInfo, bannerPageSource, type, nextStateId, timestamp, provider != null ? provider.get() : null));
        }
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerRequested(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        if (bannerInfo.hasAlidAndBannerCode()) {
            Analytics analytics = this.c;
            BannerPageSource bannerPageSource = this.b;
            long nextStateId = this.e.nextStateId();
            long timestamp = this.f.getTimestamp();
            Provider<TreeClickStreamParent> provider = this.d;
            analytics.track(new BannerRequestEvent(bannerInfo, bannerPageSource, type, nextStateId, timestamp, provider != null ? provider.get() : null));
        }
    }

    @Override // com.avito.android.serp.CommercialBannersAnalyticsInteractor
    public void sendBannerView(@NotNull BannerInfo bannerInfo, @NotNull BannerEvent.Type type) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(type, "bannerType");
        if (bannerInfo.getSamplingEnabled() && bannerInfo.hasAlidAndBannerCode()) {
            Analytics analytics = this.c;
            BannerPageSource bannerPageSource = this.b;
            long nextStateId = this.e.nextStateId();
            long timestamp = this.f.getTimestamp();
            Provider<TreeClickStreamParent> provider = this.d;
            analytics.track(new BannerViewEvent(bannerInfo, bannerPageSource, type, nextStateId, timestamp, provider != null ? provider.get() : null));
        }
    }
}
