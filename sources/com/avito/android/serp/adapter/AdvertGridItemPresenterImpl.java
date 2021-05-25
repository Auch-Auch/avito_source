package com.avito.android.serp.adapter;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
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
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\u0010$\u001a\u0004\u0018\u00010!¢\u0006\u0004\b%\u0010&J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/serp/adapter/AdvertGridItemPresenterImpl;", "Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;", "Lcom/avito/android/serp/adapter/AdvertGridItemView;", "view", "Lcom/avito/android/serp/adapter/AdvertItem;", "item", "", VKApiConst.POSITION, "", "", "payloads", "", "bindView", "(Lcom/avito/android/serp/adapter/AdvertGridItemView;Lcom/avito/android/serp/adapter/AdvertItem;ILjava/util/List;)V", "(Lcom/avito/android/serp/adapter/AdvertGridItemView;Lcom/avito/android/serp/adapter/AdvertItem;I)V", "advertItem", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/image_loader/Picture;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/serp/adapter/AdvertItem;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/image_loader/Picture;", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "d", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertGridItemPresenterImpl implements AdvertGridItemPresenter {
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
        public final /* synthetic */ Object g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
            this.g = obj5;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            DeepLink deepLink;
            int i = this.a;
            if (i == 0) {
                AdvertItem advertItem = (AdvertItem) this.e;
                ((AdvertItemListener) ((AdvertGridItemPresenterImpl) this.d).a.get()).onAdvertClicked(advertItem, this.b, AdvertGridItemPresenterImpl.access$createImage((AdvertGridItemPresenterImpl) this.d, (AdvertGridItemView) this.f, advertItem));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((AdvertItemListener) ((AdvertGridItemPresenterImpl) this.d).a.get()).onFavoriteButtonClicked((AdvertItem) this.e);
                return Unit.INSTANCE;
            } else if (i == 2) {
                Action additionalAction = ((AdvertItem) this.e).getAdditionalAction();
                if (!(additionalAction == null || (deepLink = additionalAction.getDeepLink()) == null)) {
                    ((AdvertItemListener) ((AdvertGridItemPresenterImpl) this.d).a.get()).onAdditionalActionClicked(deepLink);
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertItem a;
        public final /* synthetic */ AdvertGridItemView b;
        public final /* synthetic */ AdvertGridItemPresenterImpl c;
        public final /* synthetic */ AdvertGridItemView d;
        public final /* synthetic */ List e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertItem advertItem, AdvertGridItemView advertGridItemView, AdvertGridItemPresenterImpl advertGridItemPresenterImpl, AdvertItem advertItem2, int i, AdvertGridItemView advertGridItemView2, List list) {
            super(0);
            this.a = advertItem;
            this.b = advertGridItemView;
            this.c = advertGridItemPresenterImpl;
            this.d = advertGridItemView2;
            this.e = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((AdvertItemListener) this.c.a.get()).onMoreActionsClicked(this.a.getStringId());
            return Unit.INSTANCE;
        }
    }

    public AdvertGridItemPresenterImpl(@NotNull Lazy<? extends AdvertItemListener> lazy, @NotNull Analytics analytics, @NotNull Features features, @Nullable SerpOnboardingHandler serpOnboardingHandler) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = lazy;
        this.b = analytics;
        this.c = features;
        this.d = serpOnboardingHandler;
    }

    public static final Image access$createImage(AdvertGridItemPresenterImpl advertGridItemPresenterImpl, AdvertGridItemView advertGridItemView, AdvertItem advertItem) {
        Objects.requireNonNull(advertGridItemPresenterImpl);
        return ImageKt.toSingleImage(advertGridItemView.getPictureUri(advertGridItemPresenterImpl.a(advertItem, advertItem.getViewType())));
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(AdvertGridItemView advertGridItemView, AdvertItem advertItem, int i, List list) {
        bindView(advertGridItemView, advertItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull AdvertGridItemView advertGridItemView, @NotNull AdvertItem advertItem, int i) {
        Intrinsics.checkNotNullParameter(advertGridItemView, "view");
        Intrinsics.checkNotNullParameter(advertItem, "item");
        bindView(advertGridItemView, advertItem, i, AdvertGridItemPresenterKt.access$getEMPTY_PAYLOADS$p());
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.AdvertGridItemView r16, @org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.AdvertItem r17, int r18, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> r19) {
        /*
        // Method dump skipped, instructions count: 518
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.AdvertGridItemPresenterImpl.bindView(com.avito.android.serp.adapter.AdvertGridItemView, com.avito.android.serp.adapter.AdvertItem, int, java.util.List):void");
    }
}
