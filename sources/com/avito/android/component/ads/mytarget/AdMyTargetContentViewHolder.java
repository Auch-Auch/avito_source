package com.avito.android.component.ads.mytarget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.serp.BaseSerpViewHolder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import io.reactivex.rxjava3.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010F\u001a\u00020\u0010¢\u0006\u0004\bG\u0010HJ\u001f\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0014\u0010\nJ\"\u0010\u0019\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001f\u0010\u001aR\u001e\u0010%\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001e\u0010/\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u001e\u0010@\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010B\u001a\u0002008\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bA\u00102R\u0016\u0010E\u001a\u00020\u001b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006I"}, d2 = {"Lcom/avito/android/component/ads/mytarget/AdMyTargetContentViewHolder;", "Lcom/avito/android/component/ads/mytarget/AdMyTargetViewHolder;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/component/ads/mytarget/AdMyTarget;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lcom/my/target/nativeads/NativeAd;", "ad", "", "supportMediaView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "bindNativeAd", "(Lcom/my/target/nativeads/NativeAd;Z)Ljava/lang/ref/WeakReference;", "createMediaViews", "disposeImageBg", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "", "bg", "setMediaViewBackground", "(I)V", "setPlaceholder", "Lcom/my/target/nativeads/views/IconAdView;", "getMtIconView", "()Lcom/my/target/nativeads/views/IconAdView;", "setMtIconView", "(Lcom/my/target/nativeads/views/IconAdView;)V", "mtIconView", "Landroid/widget/FrameLayout;", "getMyTargetIconViewContainer", "()Landroid/widget/FrameLayout;", "myTargetIconViewContainer", "Lio/reactivex/rxjava3/disposables/Disposable;", "getImageBgDisposable", "()Lio/reactivex/rxjava3/disposables/Disposable;", "setImageBgDisposable", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "imageBgDisposable", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconView", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/ViewGroup;", "getMediaViewContainer", "()Landroid/view/ViewGroup;", "mediaViewContainer", "Lcom/my/target/nativeads/views/MediaAdView;", "getMediaView", "()Lcom/my/target/nativeads/views/MediaAdView;", "setMediaView", "(Lcom/my/target/nativeads/views/MediaAdView;)V", "mediaView", "getImageView", "imageView", "getFallbackColor", "()I", "fallbackColor", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdMyTargetContentViewHolder extends BaseSerpViewHolder implements AdMyTargetViewHolder, AdMyTarget {
    public Function0<Unit> s;
    public final /* synthetic */ AdMyTargetContent t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdMyTargetContentViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new AdMyTargetContent(view);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public WeakReference<View> bindNativeAd(@NotNull NativeAd nativeAd, boolean z) {
        Intrinsics.checkNotNullParameter(nativeAd, "ad");
        return this.t.bindNativeAd(nativeAd, z);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void createMediaViews() {
        this.t.createMediaViews();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void disposeImageBg() {
        this.t.disposeImageBg();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public int getFallbackColor() {
        return this.t.getFallbackColor();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public SimpleDraweeView getIconView() {
        return this.t.getIconView();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public Disposable getImageBgDisposable() {
        return this.t.getImageBgDisposable();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @NotNull
    public SimpleDraweeView getImageView() {
        return this.t.getImageView();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public MediaAdView getMediaView() {
        return this.t.getMediaView();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public ViewGroup getMediaViewContainer() {
        return this.t.getMediaViewContainer();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public IconAdView getMtIconView() {
        return this.t.getMtIconView();
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public FrameLayout getMyTargetIconViewContainer() {
        return this.t.getMyTargetIconViewContainer();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
        this.s = null;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.t.setFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setImageBgDisposable(@Nullable Disposable disposable) {
        this.t.setImageBgDisposable(disposable);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setMediaView(@Nullable MediaAdView mediaAdView) {
        this.t.setMediaView(mediaAdView);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setMediaViewBackground(int i) {
        this.t.setMediaViewBackground(i);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setMtIconView(@Nullable IconAdView iconAdView) {
        this.t.setMtIconView(iconAdView);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.t.setPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTargetViewHolder
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }
}
