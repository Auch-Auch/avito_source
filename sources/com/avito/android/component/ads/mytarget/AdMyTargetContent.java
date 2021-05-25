package com.avito.android.component.ads.mytarget;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.component.ads.mytarget.AdMyTarget;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import io.reactivex.rxjava3.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010:\u001a\u00020\u0007¢\u0006\u0004\bX\u0010YJ'\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\"R$\u0010/\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\"R\u001c\u00107\u001a\u0002028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R$\u0010B\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010H\u001a\u0004\u0018\u00010C8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001e\u0010N\u001a\u0004\u0018\u00010I8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010\"R\u0016\u0010R\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010\"R\u001c\u0010U\u001a\u00020I8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bS\u0010K\u001a\u0004\bT\u0010MR\u0016\u0010W\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010\"¨\u0006Z"}, d2 = {"Lcom/avito/android/component/ads/mytarget/AdMyTargetContent;", "Lcom/avito/android/component/ads/mytarget/AdMyTarget;", "Lcom/my/target/nativeads/NativeAd;", "ad", "", "supportMediaView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "bindNativeAd", "(Lcom/my/target/nativeads/NativeAd;Z)Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "Lcom/my/target/nativeads/views/MediaAdView;", "d", "Lcom/my/target/nativeads/views/MediaAdView;", "getMediaView", "()Lcom/my/target/nativeads/views/MediaAdView;", "setMediaView", "(Lcom/my/target/nativeads/views/MediaAdView;)V", "mediaView", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "getMediaViewContainer", "()Landroid/view/ViewGroup;", "mediaViewContainer", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "titleView", "j", "description", "k", "ageRestriction", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/Disposable;", "getImageBgDisposable", "()Lio/reactivex/rxjava3/disposables/Disposable;", "setImageBgDisposable", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "imageBgDisposable", "n", "disclaimer", "", "o", "I", "getFallbackColor", "()I", "fallbackColor", "p", "Landroid/view/View;", "view", "Lcom/my/target/nativeads/views/IconAdView;", g.a, "Lcom/my/target/nativeads/views/IconAdView;", "getMtIconView", "()Lcom/my/target/nativeads/views/IconAdView;", "setMtIconView", "(Lcom/my/target/nativeads/views/IconAdView;)V", "mtIconView", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "getMyTargetIconViewContainer", "()Landroid/widget/FrameLayout;", "myTargetIconViewContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconView", "i", "actionButton", "l", "adLabel", AuthSource.BOOKING_ORDER, "getImageView", "imageView", AuthSource.OPEN_CHANNEL_LIST, "domain", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdMyTargetContent implements AdMyTarget {
    @Nullable
    public Disposable a;
    @NotNull
    public final SimpleDraweeView b;
    @Nullable
    public final ViewGroup c;
    @Nullable
    public MediaAdView d;
    @Nullable
    public final SimpleDraweeView e;
    @Nullable
    public final FrameLayout f;
    @Nullable
    public IconAdView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final int o;
    public final View p;

    public AdMyTargetContent(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.p = view;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById;
        this.c = (ViewGroup) view.findViewById(R.id.media_view_container);
        this.e = (SimpleDraweeView) view.findViewById(R.id.icon);
        this.f = (FrameLayout) view.findViewById(R.id.mt_icon_container);
        View findViewById2 = view.findViewById(R.id.nativeads_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById2;
        this.i = (TextView) view.findViewById(R.id.nativeads_call_to_action);
        this.j = (TextView) view.findViewById(R.id.nativeads_description);
        View findViewById3 = view.findViewById(R.id.nativeads_age_restrictions);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.k = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.nativeads_advertising);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.nativeads_domain);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.m = (TextView) findViewById5;
        this.n = (TextView) view.findViewById(R.id.nativeads_disclaimer);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.o = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray8);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public WeakReference<View> bindNativeAd(@NotNull NativeAd nativeAd, boolean z) {
        ImageRequest.Builder requestBuilder;
        ImageRequest.Builder uri;
        Intrinsics.checkNotNullParameter(nativeAd, "ad");
        NativePromoBanner banner = nativeAd.getBanner();
        if (banner == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(banner, "ad.banner ?: return null");
        if (z) {
            if (getMediaView() == null) {
                createMediaViews();
            }
            MediaAdView mediaView = getMediaView();
            if (mediaView != null) {
                mediaView.setBackgroundColor(0);
            }
            ViewGroup mediaViewContainer = getMediaViewContainer();
            if (mediaViewContainer != null) {
                mediaViewContainer.setBackgroundColor(0);
            }
        } else {
            SimpleDraweeViewsKt.getRequestBuilder(getImageView()).uri(ImageDatasKt.getImageUri(banner.getImage())).dominantColorEdge(getFallbackColor()).load();
            Uri imageUri = ImageDatasKt.getImageUri(banner.getIcon());
            SimpleDraweeView iconView = getIconView();
            if (!(iconView == null || (requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(iconView)) == null || (uri = requestBuilder.uri(imageUri)) == null)) {
                uri.load();
            }
        }
        TextViews.bindText$default(this.h, banner.getTitle(), false, 2, null);
        TextView textView = this.i;
        if (textView != null) {
            TextViews.bindText$default(textView, banner.getCtaText(), false, 2, null);
        }
        TextViews.bindText$default(this.k, banner.getAgeRestrictions(), false, 2, null);
        TextView textView2 = this.l;
        String advertisingLabel = banner.getAdvertisingLabel();
        if (advertisingLabel == null || advertisingLabel.length() == 0) {
            advertisingLabel = this.p.getResources().getString(com.avito.android.lib.design.R.string.advertising_title);
            Intrinsics.checkNotNullExpressionValue(advertisingLabel, "view.resources.getString…string.advertising_title)");
        }
        TextViews.bindText$default(textView2, advertisingLabel, false, 2, null);
        TextView textView3 = this.j;
        if (textView3 != null) {
            TextViews.bindText$default(textView3, banner.getDescription(), false, 2, null);
        }
        TextViews.bindText$default(this.m, banner.getDomain(), false, 2, null);
        TextView textView4 = this.n;
        if (textView4 != null) {
            TextViews.bindText$default(textView4, banner.getDisclaimer(), false, 2, null);
        }
        return new WeakReference<>(this.p);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void createMediaViews() {
        AdMyTarget.DefaultImpls.createMediaViews(this);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void disposeImageBg() {
        AdMyTarget.DefaultImpls.disposeImageBg(this);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public int getFallbackColor() {
        return this.o;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public SimpleDraweeView getIconView() {
        return this.e;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public Disposable getImageBgDisposable() {
        return this.a;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @NotNull
    public SimpleDraweeView getImageView() {
        return this.b;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public MediaAdView getMediaView() {
        return this.d;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public ViewGroup getMediaViewContainer() {
        return this.c;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public IconAdView getMtIconView() {
        return this.g;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    @Nullable
    public FrameLayout getMyTargetIconViewContainer() {
        return this.f;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        ((GenericDraweeHierarchy) getImageView().getHierarchy()).setFailureImage(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setImageBgDisposable(@Nullable Disposable disposable) {
        this.a = disposable;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setMediaView(@Nullable MediaAdView mediaAdView) {
        this.d = mediaAdView;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setMediaViewBackground(int i2) {
        AdMyTarget.DefaultImpls.setMediaViewBackground(this, i2);
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setMtIconView(@Nullable IconAdView iconAdView) {
        this.g = iconAdView;
    }

    @Override // com.avito.android.component.ads.mytarget.AdMyTarget
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        ((GenericDraweeHierarchy) getImageView().getHierarchy()).setPlaceholderImage(drawable, scaleType);
    }
}
