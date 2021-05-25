package com.avito.android.messenger.channels.mvi.view.banneritems;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.ads.mytarget.AdMyTarget;
import com.avito.android.component.ads.mytarget.AdMyTargetAppInstall;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterKt;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.MyTargetBanner;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import io.reactivex.rxjava3.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00011B/\u0012\u0006\u0010,\u001a\u00020\u0014\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/MyTargetAppInstallChannelListAdBannerItem;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "getLayoutRes", "()I", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindAd", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;ILjava/util/List;)V", "unbindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;I)V", "copy", "()Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "toString", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/MyTargetAppInstallChannelListAdBannerItem$ViewHolder;", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/banneritems/MyTargetAppInstallChannelListAdBannerItem$ViewHolder;", "Lkotlin/Function0;", g.a, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;", "h", "Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;", "banner", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "i", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "bgColorProvider", "", "j", "Z", "supportsMediaView", "id", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "<init>", "(Ljava/lang/String;Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/ad/MyTargetImageBgProvider;Z)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MyTargetAppInstallChannelListAdBannerItem extends ChannelListAdBannerItem {
    public Function0<Unit> g;
    public final MyTargetBanner.MyTargetAppInstallBanner h;
    public final MyTargetImageBgProvider i;
    public final boolean j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010E\u001a\u00020\b\u0012\n\u0010G\u001a\u0006\u0012\u0002\b\u00030F¢\u0006\u0004\bH\u0010IJ(\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\rJ\"\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0019\u0010\u0014R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00158\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u00102\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00108\u001a\u0004\u0018\u0001038\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010>\u001a\u0004\u0018\u0001098\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020?8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bC\u0010A¨\u0006J"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/MyTargetAppInstallChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/component/ads/mytarget/AdMyTarget;", "Lcom/my/target/nativeads/NativeAd;", "ad", "", "supportMediaView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "bindNativeAd", "(Lcom/my/target/nativeads/NativeAd;Z)Ljava/lang/ref/WeakReference;", "", "createMediaViews", "()V", "disposeImageBg", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "", "bg", "setMediaViewBackground", "(I)V", "setPlaceholder", "Lkotlin/Function0;", "B", "Lkotlin/jvm/functions/Function0;", "getOnCloseListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseListener", "(Lkotlin/jvm/functions/Function0;)V", "onCloseListener", "getFallbackColor", "()I", "fallbackColor", "Landroid/view/ViewGroup;", "getMediaViewContainer", "()Landroid/view/ViewGroup;", "mediaViewContainer", "Landroid/widget/FrameLayout;", "getMyTargetIconViewContainer", "()Landroid/widget/FrameLayout;", "myTargetIconViewContainer", "Lcom/my/target/nativeads/views/IconAdView;", "getMtIconView", "()Lcom/my/target/nativeads/views/IconAdView;", "setMtIconView", "(Lcom/my/target/nativeads/views/IconAdView;)V", "mtIconView", "Lcom/my/target/nativeads/views/MediaAdView;", "getMediaView", "()Lcom/my/target/nativeads/views/MediaAdView;", "setMediaView", "(Lcom/my/target/nativeads/views/MediaAdView;)V", "mediaView", "Lio/reactivex/rxjava3/disposables/Disposable;", "getImageBgDisposable", "()Lio/reactivex/rxjava3/disposables/Disposable;", "setImageBgDisposable", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "imageBgDisposable", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconView", "getImageView", "imageView", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends ChannelListAdBannerItem.ViewHolder implements AdMyTarget {
        @Nullable
        public Function0<Unit> B;
        public final /* synthetic */ AdMyTargetAppInstall C;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0<Unit> onCloseListener = this.a.getOnCloseListener();
                if (onCloseListener != null) {
                    onCloseListener.invoke();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(ChannelListAdBannerItem.Companion.createSwipableContainer(view), flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
            this.C = new AdMyTargetAppInstall(view);
            getCloseButton().setOnClickListener(new a(this));
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @Nullable
        public WeakReference<View> bindNativeAd(@NotNull NativeAd nativeAd, boolean z) {
            Intrinsics.checkNotNullParameter(nativeAd, "ad");
            return this.C.bindNativeAd(nativeAd, z);
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void createMediaViews() {
            this.C.createMediaViews();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void disposeImageBg() {
            this.C.disposeImageBg();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public int getFallbackColor() {
            return this.C.getFallbackColor();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @Nullable
        public SimpleDraweeView getIconView() {
            return this.C.getIconView();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @Nullable
        public Disposable getImageBgDisposable() {
            return this.C.getImageBgDisposable();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @NotNull
        public SimpleDraweeView getImageView() {
            return this.C.getImageView();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @Nullable
        public MediaAdView getMediaView() {
            return this.C.getMediaView();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @Nullable
        public ViewGroup getMediaViewContainer() {
            return this.C.getMediaViewContainer();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @Nullable
        public IconAdView getMtIconView() {
            return this.C.getMtIconView();
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        @Nullable
        public FrameLayout getMyTargetIconViewContainer() {
            return this.C.getMyTargetIconViewContainer();
        }

        @Nullable
        public final Function0<Unit> getOnCloseListener() {
            return this.B;
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setFailureDrawable(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void setImageBgDisposable(@Nullable Disposable disposable) {
            this.C.setImageBgDisposable(disposable);
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void setMediaView(@Nullable MediaAdView mediaAdView) {
            this.C.setMediaView(mediaAdView);
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void setMediaViewBackground(int i) {
            this.C.setMediaViewBackground(i);
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void setMtIconView(@Nullable IconAdView iconAdView) {
            this.C.setMtIconView(iconAdView);
        }

        public final void setOnCloseListener(@Nullable Function0<Unit> function0) {
            this.B = function0;
        }

        @Override // com.avito.android.component.ads.mytarget.AdMyTarget
        public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setPlaceholder(drawable, scaleType);
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MyTargetAppInstallChannelListAdBannerItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MyTargetAppInstallChannelListAdBannerItem myTargetAppInstallChannelListAdBannerItem) {
            super(0);
            this.a = myTargetAppInstallChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onAdClosed();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MyTargetAppInstallChannelListAdBannerItem a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ ChannelListAdBannerItem.ViewHolder c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MyTargetAppInstallChannelListAdBannerItem myTargetAppInstallChannelListAdBannerItem, WeakReference weakReference, ChannelListAdBannerItem.ViewHolder viewHolder) {
            super(0);
            this.a = myTargetAppInstallChannelListAdBannerItem;
            this.b = weakReference;
            this.c = viewHolder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.h.unregisterView(this.b);
            ((ViewHolder) this.c).disposeImageBg();
            this.a.g = null;
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Lazy<AdBannerEventListener> {
        public final /* synthetic */ MyTargetAppInstallChannelListAdBannerItem a;

        public c(MyTargetAppInstallChannelListAdBannerItem myTargetAppInstallChannelListAdBannerItem) {
            this.a = myTargetAppInstallChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // dagger.Lazy
        public AdBannerEventListener get() {
            return new MyTargetAppInstallChannelListAdBannerItem$bindAd$3$1(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyTargetAppInstallChannelListAdBannerItem(@NotNull String str, @NotNull MyTargetBanner.MyTargetAppInstallBanner myTargetAppInstallBanner, @NotNull BannerInfo bannerInfo, @NotNull MyTargetImageBgProvider myTargetImageBgProvider, boolean z) {
        super(str, bannerInfo);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(myTargetAppInstallBanner, "banner");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(myTargetImageBgProvider, "bgColorProvider");
        this.h = myTargetAppInstallBanner;
        this.i = myTargetImageBgProvider;
        this.j = z;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    public void bindAd(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ChannelListAdBannerItem.ViewHolder viewHolder, int i2, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (viewHolder instanceof ViewHolder) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            Context context = view.getContext();
            NativeAd ad = this.h.getAd();
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            int i3 = R.drawable.img_item_placeholder_48_40;
            Drawable drawable = context.getDrawable(i3);
            ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
            viewHolder2.setPlaceholder(drawable, scaleType);
            Drawable drawable2 = context.getDrawable(i3);
            Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
            viewHolder2.setFailureDrawable(drawable2, scaleType);
            WeakReference<View> bindNativeAd = viewHolder2.bindNativeAd(ad, this.j);
            this.h.registerView(bindNativeAd);
            if (this.j) {
                MyTargetContentPresenterKt.bindMedia((AdMyTarget) viewHolder, this.h, this.i);
            }
            viewHolder2.setOnCloseListener(new a(this));
            this.g = new b(this, bindNativeAd, viewHolder);
            this.h.getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(new c(this), getBannerInfo(), i2));
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    @NotNull
    public ChannelListAdBannerItem copy() {
        return new MyTargetAppInstallChannelListAdBannerItem(this.id, this.h, getBannerInfo(), this.i, this.j);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_mytarget_app_install_item;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("MyTargetAppInstallChannelListAdBannerItem(\n            |   banner = ");
        NativePromoBanner banner = this.h.getAd().getBanner();
        return f.trimMargin$default(a2.b.a.a.a.t(L, banner != null ? banner.getTitle() : null, "\n            |)"), null, 1, null);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void unbindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i2) {
        unbindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ChannelListAdBannerItem.ViewHolder) viewHolder, i2);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }

    public void unbindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ChannelListAdBannerItem.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.unbindViewHolder(flexibleAdapter, (FlexibleAdapter<?>) viewHolder, i2);
        Function0<Unit> function0 = this.g;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
