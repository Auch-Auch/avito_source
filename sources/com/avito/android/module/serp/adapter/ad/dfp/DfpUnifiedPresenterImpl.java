package com.avito.android.module.serp.adapter.ad.dfp;

import android.net.Uri;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.DfpBannerKt;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdjustableSerpItemsKt;
import com.avito.android.serp.adapter.DfpUnifiedBannerItem;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedPresenter;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedItemView;", "view", "Lcom/avito/android/serp/adapter/DfpUnifiedBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedItemView;Lcom/avito/android/serp/adapter/DfpUnifiedBannerItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "getListener", "()Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "c", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "getDfpDebugPresenter", "()Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "dfpDebugPresenter", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "getScheduler", "()Lcom/avito/android/util/SchedulersFactory3;", "scheduler", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl;", "dfpImageLoader", "<init>", "(Ldagger/Lazy;Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;Lcom/avito/android/util/SchedulersFactory3;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpUnifiedPresenterImpl implements DfpUnifiedPresenter {
    public final DfpImageLoaderImpl a;
    @NotNull
    public final Lazy<AdBannerEventListener> b;
    @Nullable
    public final DfpDebugPresenter c;
    @NotNull
    public final SchedulersFactory3 d;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DfpUnifiedPresenterImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ UnifiedNativeAd c;
        public final /* synthetic */ DfpUnifiedItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DfpUnifiedPresenterImpl dfpUnifiedPresenterImpl, int i, UnifiedNativeAd unifiedNativeAd, DfpUnifiedItemView dfpUnifiedItemView) {
            super(0);
            this.a = dfpUnifiedPresenterImpl;
            this.b = i;
            this.c = unifiedNativeAd;
            this.d = dfpUnifiedItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.cancel(this.b);
            MediaContent mediaContent = this.c.getMediaContent();
            Intrinsics.checkNotNullExpressionValue(mediaContent, "ad.mediaContent");
            mediaContent.setMainImage(null);
            this.d.clearImageData();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DfpUnifiedPresenterImpl(@NotNull Lazy<AdBannerEventListener> lazy, @Nullable DfpDebugPresenter dfpDebugPresenter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(schedulersFactory3, "scheduler");
        this.b = lazy;
        this.c = dfpDebugPresenter;
        this.d = schedulersFactory3;
        this.a = new DfpImageLoaderImpl(schedulersFactory3);
    }

    @Nullable
    public final DfpDebugPresenter getDfpDebugPresenter() {
        return this.c;
    }

    @NotNull
    public final Lazy<AdBannerEventListener> getListener() {
        return this.b;
    }

    @NotNull
    public final SchedulersFactory3 getScheduler() {
        return this.d;
    }

    public void bindView(@NotNull DfpUnifiedItemView dfpUnifiedItemView, @NotNull DfpUnifiedBannerItem dfpUnifiedBannerItem, int i) {
        DescriptionPosition descriptionPosition;
        Uri uri;
        Intrinsics.checkNotNullParameter(dfpUnifiedItemView, "view");
        Intrinsics.checkNotNullParameter(dfpUnifiedBannerItem, "item");
        DfpDebugPresenter dfpDebugPresenter = this.c;
        if (dfpDebugPresenter != null) {
            dfpDebugPresenter.setupDebugMenu(dfpUnifiedBannerItem.getStringId(), dfpUnifiedItemView);
        }
        UnifiedNativeAd ad = dfpUnifiedBannerItem.getBanner().getAd();
        boolean isApplicationAd = DfpBannerKt.isApplicationAd(ad);
        dfpUnifiedItemView.setIsApplication(isApplicationAd);
        dfpUnifiedItemView.setTitle(ad.getHeadline());
        if (dfpUnifiedBannerItem.getDisplayType().isGrid() || isApplicationAd) {
            descriptionPosition = AdjustableSerpItemsKt.getDescriptionPosition(dfpUnifiedBannerItem);
        } else {
            descriptionPosition = new DescriptionPosition.Top();
        }
        dfpUnifiedItemView.setDescription(ad.getBody(), descriptionPosition);
        NativeAd.Image icon = ad.getIcon();
        if (icon == null || (uri = icon.getUri()) == null) {
            uri = Uri.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(uri, "ad.icon?.uri ?: Uri.EMPTY");
        dfpUnifiedItemView.setIcon(uri);
        dfpUnifiedItemView.setAdvertiser(ad.getAdvertiser());
        String callToAction = ad.getCallToAction();
        Intrinsics.checkNotNullExpressionValue(callToAction, "ad.callToAction");
        dfpUnifiedItemView.setCallToAction(callToAction);
        dfpUnifiedBannerItem.getBanner().getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(this.b, dfpUnifiedBannerItem.getBannerInfo(), i));
        if (isApplicationAd) {
            Double starRating = ad.getStarRating();
            dfpUnifiedItemView.showRating(starRating != null ? (float) starRating.doubleValue() : 0.0f);
        } else {
            dfpUnifiedItemView.hideRating();
        }
        dfpUnifiedItemView.setUnbindListener(new a(this, DfpUnifiedPresenterKt.bindMedia(this.a, ad, dfpUnifiedItemView), ad, dfpUnifiedItemView));
        dfpUnifiedItemView.setNativeAd(ad);
    }
}
