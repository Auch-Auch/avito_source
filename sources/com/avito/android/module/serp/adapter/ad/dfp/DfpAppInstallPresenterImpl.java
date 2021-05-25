package com.avito.android.module.serp.adapter.ad.dfp;

import android.net.Uri;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.NativeAppInstallAdUtils;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdjustableSerpItemsKt;
import com.avito.android.serp.adapter.DfpAppInstallBannerItem;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallPresenter;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallItemView;", "view", "Lcom/avito/android/serp/adapter/DfpAppInstallBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallItemView;Lcom/avito/android/serp/adapter/DfpAppInstallBannerItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "getListener", "()Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "getDfpDebugPresenter", "()Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "dfpDebugPresenter", "<init>", "(Ldagger/Lazy;Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpAppInstallPresenterImpl implements DfpAppInstallPresenter {
    @NotNull
    public final Lazy<AdBannerEventListener> a;
    @NotNull
    public final DfpDebugPresenter b;

    @Inject
    public DfpAppInstallPresenterImpl(@NotNull Lazy<AdBannerEventListener> lazy, @NotNull DfpDebugPresenter dfpDebugPresenter) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(dfpDebugPresenter, "dfpDebugPresenter");
        this.a = lazy;
        this.b = dfpDebugPresenter;
    }

    @NotNull
    public final DfpDebugPresenter getDfpDebugPresenter() {
        return this.b;
    }

    @NotNull
    public final Lazy<AdBannerEventListener> getListener() {
        return this.a;
    }

    public void bindView(@NotNull DfpAppInstallItemView dfpAppInstallItemView, @NotNull DfpAppInstallBannerItem dfpAppInstallBannerItem, int i) {
        Uri uri;
        Intrinsics.checkNotNullParameter(dfpAppInstallItemView, "view");
        Intrinsics.checkNotNullParameter(dfpAppInstallBannerItem, "item");
        this.b.setupDebugMenu(dfpAppInstallBannerItem.getStringId(), dfpAppInstallItemView);
        NativeAppInstallAd appInstallAd = dfpAppInstallBannerItem.getAppInstallBanner().getAppInstallAd();
        dfpAppInstallItemView.setNativeAd(appInstallAd);
        dfpAppInstallItemView.setTitle(appInstallAd.getHeadline());
        dfpAppInstallItemView.setDescription(appInstallAd.getBody(), AdjustableSerpItemsKt.getDescriptionPosition(dfpAppInstallBannerItem));
        NativeAd.Image icon = appInstallAd.getIcon();
        if (icon == null || (uri = icon.getUri()) == null) {
            uri = Uri.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(uri, "banner.icon?.uri ?: Uri.EMPTY");
        dfpAppInstallItemView.setIcon(uri);
        Uri imageUrl = NativeAppInstallAdUtils.getImageUrl(appInstallAd);
        if (imageUrl == null) {
            imageUrl = Uri.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(imageUrl, "banner.getImageUri()");
        dfpAppInstallItemView.setImage(imageUrl);
        CharSequence callToAction = appInstallAd.getCallToAction();
        Intrinsics.checkNotNullExpressionValue(callToAction, "banner.callToAction");
        dfpAppInstallItemView.setCallToAction(callToAction);
        float doubleValue = (float) appInstallAd.getStarRating().doubleValue();
        if (doubleValue == 0.0f) {
            dfpAppInstallItemView.hideRating();
        } else {
            dfpAppInstallItemView.showRating(doubleValue);
        }
        dfpAppInstallBannerItem.getAppInstallBanner().getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(this.a, dfpAppInstallBannerItem.getBannerInfo(), i));
    }
}
