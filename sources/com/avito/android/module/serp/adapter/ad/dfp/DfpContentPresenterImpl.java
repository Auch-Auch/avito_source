package com.avito.android.module.serp.adapter.ad.dfp;

import android.net.Uri;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdjustableSerpItemsKt;
import com.avito.android.serp.adapter.DfpContentBannerItem;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentPresenter;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentItemView;", "view", "Lcom/avito/android/serp/adapter/DfpContentBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentItemView;Lcom/avito/android/serp/adapter/DfpContentBannerItem;I)V", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "getDfpDebugPresenter", "()Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "dfpDebugPresenter", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "getListener", "()Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpContentPresenterImpl implements DfpContentPresenter {
    @NotNull
    public final Lazy<AdBannerEventListener> a;
    @Nullable
    public final DfpDebugPresenter b;

    @Inject
    public DfpContentPresenterImpl(@NotNull Lazy<AdBannerEventListener> lazy, @Nullable DfpDebugPresenter dfpDebugPresenter) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
        this.b = dfpDebugPresenter;
    }

    @Nullable
    public final DfpDebugPresenter getDfpDebugPresenter() {
        return this.b;
    }

    @NotNull
    public final Lazy<AdBannerEventListener> getListener() {
        return this.a;
    }

    public void bindView(@NotNull DfpContentItemView dfpContentItemView, @NotNull DfpContentBannerItem dfpContentBannerItem, int i) {
        DescriptionPosition descriptionPosition;
        Uri uri;
        Intrinsics.checkNotNullParameter(dfpContentItemView, "view");
        Intrinsics.checkNotNullParameter(dfpContentBannerItem, "item");
        DfpDebugPresenter dfpDebugPresenter = this.b;
        if (dfpDebugPresenter != null) {
            dfpDebugPresenter.setupDebugMenu(dfpContentBannerItem.getStringId(), dfpContentItemView);
        }
        NativeContentAd contentAd = dfpContentBannerItem.getBanner().getContentAd();
        dfpContentItemView.setNativeAd(contentAd);
        CharSequence headline = contentAd.getHeadline();
        Intrinsics.checkNotNullExpressionValue(headline, "banner.headline");
        dfpContentItemView.setTitle(headline);
        if (dfpContentBannerItem.getDisplayType().isGrid()) {
            descriptionPosition = AdjustableSerpItemsKt.getDescriptionPosition(dfpContentBannerItem);
        } else {
            descriptionPosition = new DescriptionPosition.Top();
        }
        CharSequence body = contentAd.getBody();
        Intrinsics.checkNotNullExpressionValue(body, "banner.body");
        dfpContentItemView.setDescription(body, descriptionPosition);
        List<NativeAd.Image> images = contentAd.getImages();
        Intrinsics.checkNotNullExpressionValue(images, "banner.images");
        NativeAd.Image image = (NativeAd.Image) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) images);
        if (image == null || (uri = image.getUri()) == null) {
            uri = Uri.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(uri, "banner.images.firstOrNull()?.uri ?: Uri.EMPTY");
        dfpContentItemView.setImage(uri);
        dfpContentItemView.setAdvertiser(contentAd.getAdvertiser());
        dfpContentItemView.setCallToAction(contentAd.getCallToAction());
        dfpContentBannerItem.getBanner().getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(this.a, dfpContentBannerItem.getBannerInfo(), i));
    }
}
