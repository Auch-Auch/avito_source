package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.component.ads.yandex.AdYandexAppInstallViewHolder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdjustableSerpItemsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAd;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenter;", "Lcom/avito/android/component/ads/yandex/AdYandexAppInstallViewHolder;", "view", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/ads/yandex/AdYandexAppInstallViewHolder;Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallBannerItem;I)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAppInstallItemPresenterImpl implements YandexAppInstallItemPresenter {
    public final Lazy<AdBannerEventListener> a;
    public final Analytics b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((AdBannerEventListener) ((YandexAppInstallItemPresenterImpl) this.c).a.get()).onItemClose(((YandexAppInstallBannerItem) this.d).getStringId());
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((AdBannerEventListener) ((YandexAppInstallItemPresenterImpl) this.c).a.get()).onAdBannerOpened(((YandexAppInstallBannerItem) this.d).getBannerInfo(), this.b);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public YandexAppInstallItemPresenterImpl(@NotNull Lazy<AdBannerEventListener> lazy, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = lazy;
        this.b = analytics;
    }

    public void bindView(@NotNull AdYandexAppInstallViewHolder adYandexAppInstallViewHolder, @NotNull YandexAppInstallBannerItem yandexAppInstallBannerItem, int i) {
        Intrinsics.checkNotNullParameter(adYandexAppInstallViewHolder, "view");
        Intrinsics.checkNotNullParameter(yandexAppInstallBannerItem, "item");
        adYandexAppInstallViewHolder.bindBody(AdjustableSerpItemsKt.getDescriptionPosition(yandexAppInstallBannerItem));
        try {
            adYandexAppInstallViewHolder.bindAd((NativeAppInstallAd) yandexAppInstallBannerItem.getBanner().getAd(), yandexAppInstallBannerItem.isClosed(), new a(0, i, this, yandexAppInstallBannerItem), new a(1, i, this, yandexAppInstallBannerItem));
        } catch (Exception e) {
            this.b.track(new NonFatalError("Failed to bind yandex app install banner", e, null, 4, null));
        }
    }
}
