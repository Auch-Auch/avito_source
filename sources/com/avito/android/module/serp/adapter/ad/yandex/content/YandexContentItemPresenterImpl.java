package com.avito.android.module.serp.adapter.ad.yandex.content;

import com.avito.android.ab_tests.OrangeAdBage;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.component.ads.yandex.AdYandexContentViewHolder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u000e\b\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentItemPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentItemPresenter;", "Lcom/avito/android/component/ads/yandex/AdYandexContentViewHolder;", "view", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/ads/yandex/AdYandexContentViewHolder;Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexBannerItem;I)V", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/OrangeAdBadgeTestGroup;", "c", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "orangeAdBadgeTestGroup", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexContentItemPresenterImpl implements YandexContentItemPresenter {
    public final Lazy<AdBannerEventListener> a;
    public final Analytics b;
    public final ExposedAbTestGroup<OrangeAdBadgeTestGroup> c;

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
                ((AdBannerEventListener) ((YandexContentItemPresenterImpl) this.c).a.get()).onItemClose(((YandexBannerItem) this.d).getStringId());
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((AdBannerEventListener) ((YandexContentItemPresenterImpl) this.c).a.get()).onAdBannerOpened(((YandexBannerItem) this.d).getBannerInfo(), this.b);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public YandexContentItemPresenterImpl(@NotNull Lazy<AdBannerEventListener> lazy, @NotNull Analytics analytics, @OrangeAdBage @NotNull ExposedAbTestGroup<OrangeAdBadgeTestGroup> exposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "orangeAdBadgeTestGroup");
        this.a = lazy;
        this.b = analytics;
        this.c = exposedAbTestGroup;
    }

    public void bindView(@NotNull AdYandexContentViewHolder adYandexContentViewHolder, @NotNull YandexBannerItem yandexBannerItem, int i) {
        Intrinsics.checkNotNullParameter(adYandexContentViewHolder, "view");
        Intrinsics.checkNotNullParameter(yandexBannerItem, "item");
        try {
            adYandexContentViewHolder.bindAd((NativeContentAd) yandexBannerItem.getBanner().getAd(), yandexBannerItem.isClosed(), yandexBannerItem.isRedesign() && !this.c.getTestGroup().isTest(), new a(0, i, this, yandexBannerItem), new a(1, i, this, yandexBannerItem));
        } catch (Exception e) {
            this.b.track(new NonFatalError("Failed to bind yandex content banner", e, null, 4, null));
        }
    }
}
