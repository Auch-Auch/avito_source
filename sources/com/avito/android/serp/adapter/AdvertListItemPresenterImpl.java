package com.avito.android.serp.adapter;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b \u0010!J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/serp/adapter/AdvertListItemPresenterImpl;", "Lcom/avito/android/serp/adapter/AdvertListItemPresenter;", "Lcom/avito/android/serp/adapter/AdvertListItemView;", "view", "Lcom/avito/android/serp/adapter/AdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/AdvertListItemView;Lcom/avito/android/serp/adapter/AdvertItem;I)V", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/image_loader/Picture;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/serp/adapter/AdvertItem;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/image_loader/Picture;", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "d", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertListItemPresenterImpl implements AdvertListItemPresenter {
    public final Lazy<? extends AdvertItemListener> a;
    public final Analytics b;
    public final Features c;
    public final SerpOnboardingHandler d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            DeepLink deepLink;
            int i = this.a;
            if (i == 0) {
                AdvertItem advertItem = (AdvertItem) this.e;
                ((AdvertItemListener) ((AdvertListItemPresenterImpl) this.d).a.get()).onAdvertClicked(advertItem, this.b, AdvertListItemPresenterImpl.access$createImage((AdvertListItemPresenterImpl) this.d, (AdvertListItemView) this.f, advertItem));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((AdvertItemListener) ((AdvertListItemPresenterImpl) this.d).a.get()).onFavoriteButtonClicked((AdvertItem) this.e);
                return Unit.INSTANCE;
            } else if (i == 2) {
                AdvertItemListener advertItemListener = (AdvertItemListener) ((AdvertListItemPresenterImpl) this.d).a.get();
                Action additionalAction = ((AdvertItem) this.e).getAdditionalAction();
                if (additionalAction == null || (deepLink = additionalAction.getDeepLink()) == null) {
                    deepLink = new NoMatchLink();
                }
                advertItemListener.onAdditionalActionClicked(deepLink);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public AdvertListItemPresenterImpl(@NotNull Lazy<? extends AdvertItemListener> lazy, @NotNull Analytics analytics, @NotNull Features features, @Nullable SerpOnboardingHandler serpOnboardingHandler) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = lazy;
        this.b = analytics;
        this.c = features;
        this.d = serpOnboardingHandler;
    }

    public static final Image access$createImage(AdvertListItemPresenterImpl advertListItemPresenterImpl, AdvertListItemView advertListItemView, AdvertItem advertItem) {
        Objects.requireNonNull(advertListItemPresenterImpl);
        return ImageKt.toSingleImage(advertListItemView.getPictureUri(advertListItemPresenterImpl.a(advertItem, advertItem.getViewType())));
    }

    public final Picture a(AdvertItem advertItem, SerpViewType serpViewType) {
        ForegroundImage infoImage = advertItem.getInfoImage();
        if (infoImage != null) {
            Picture pictureOf$default = AvitoPictureKt.pictureOf$default(serpViewType == SerpViewType.BIG, 0.0f, 0.0f, infoImage, 6, null);
            if (pictureOf$default != null) {
                return pictureOf$default;
            }
        }
        return AvitoPictureKt.pictureOf$default(advertItem.getImage(), serpViewType == SerpViewType.BIG, 0.0f, 0.0f, null, 28, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.AdvertListItemView r10, @org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.AdvertItem r11, int r12) {
        /*
        // Method dump skipped, instructions count: 433
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.AdvertListItemPresenterImpl.bindView(com.avito.android.serp.adapter.AdvertListItemView, com.avito.android.serp.adapter.AdvertItem, int):void");
    }
}
