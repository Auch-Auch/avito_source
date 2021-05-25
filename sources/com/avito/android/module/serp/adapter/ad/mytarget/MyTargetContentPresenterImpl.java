package com.avito.android.module.serp.adapter.ad.mytarget;

import android.view.View;
import com.avito.android.Features;
import com.avito.android.component.ads.mytarget.AdMyTargetViewHolder;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentPresenter;", "Lcom/avito/android/component/ads/mytarget/AdMyTargetViewHolder;", "view", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/ads/mytarget/AdMyTargetViewHolder;Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentBannerItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "getListener", "()Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "getBgProvider", "()Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "bgProvider", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "features", "<init>", "(Ldagger/Lazy;Lcom/avito/android/serp/ad/MyTargetImageBgProvider;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyTargetContentPresenterImpl implements MyTargetContentPresenter {
    @NotNull
    public final Lazy<AdBannerEventListener> a;
    @NotNull
    public final MyTargetImageBgProvider b;
    @NotNull
    public final Features c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MyTargetContentBannerItem a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ AdMyTargetViewHolder c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MyTargetContentBannerItem myTargetContentBannerItem, WeakReference weakReference, AdMyTargetViewHolder adMyTargetViewHolder) {
            super(0);
            this.a = myTargetContentBannerItem;
            this.b = weakReference;
            this.c = adMyTargetViewHolder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getBanner().unregisterView(this.b);
            this.c.disposeImageBg();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public MyTargetContentPresenterImpl(@NotNull Lazy<AdBannerEventListener> lazy, @NotNull MyTargetImageBgProvider myTargetImageBgProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(myTargetImageBgProvider, "bgProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = lazy;
        this.b = myTargetImageBgProvider;
        this.c = features;
    }

    @NotNull
    public final MyTargetImageBgProvider getBgProvider() {
        return this.b;
    }

    @NotNull
    public final Features getFeatures() {
        return this.c;
    }

    @NotNull
    public final Lazy<AdBannerEventListener> getListener() {
        return this.a;
    }

    public void bindView(@NotNull AdMyTargetViewHolder adMyTargetViewHolder, @NotNull MyTargetContentBannerItem myTargetContentBannerItem, int i) {
        Intrinsics.checkNotNullParameter(adMyTargetViewHolder, "view");
        Intrinsics.checkNotNullParameter(myTargetContentBannerItem, "item");
        boolean booleanValue = this.c.getMyTargetMediaView().invoke().booleanValue();
        WeakReference<View> bindNativeAd = adMyTargetViewHolder.bindNativeAd(myTargetContentBannerItem.getBanner().getAd(), booleanValue);
        myTargetContentBannerItem.getBanner().registerView(bindNativeAd);
        if (booleanValue) {
            MyTargetContentPresenterKt.bindMedia(adMyTargetViewHolder, myTargetContentBannerItem.getBanner(), this.b);
        }
        adMyTargetViewHolder.setUnbindListener(new a(myTargetContentBannerItem, bindNativeAd, adMyTargetViewHolder));
        myTargetContentBannerItem.getBanner().getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(this.a, myTargetContentBannerItem.getBannerInfo(), i));
    }
}
