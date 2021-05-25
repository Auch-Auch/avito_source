package com.avito.android.component.ads.mytarget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.component.ads.AdViewUtils;
import com.avito.android.ui.RoundOutlineProviderKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.my.target.R;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.factories.NativeViewsFactory;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import io.reactivex.rxjava3.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0013R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010$\u001a\u0004\u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001e\u0010.\u001a\u0004\u0018\u00010)8&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u00104¨\u0006<"}, d2 = {"Lcom/avito/android/component/ads/mytarget/AdMyTarget;", "", "Lcom/my/target/nativeads/NativeAd;", "ad", "", "supportMediaView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "bindNativeAd", "(Lcom/my/target/nativeads/NativeAd;Z)Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "createMediaViews", "()V", "", "bg", "setMediaViewBackground", "(I)V", "disposeImageBg", "Lio/reactivex/rxjava3/disposables/Disposable;", "getImageBgDisposable", "()Lio/reactivex/rxjava3/disposables/Disposable;", "setImageBgDisposable", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "imageBgDisposable", "Lcom/my/target/nativeads/views/MediaAdView;", "getMediaView", "()Lcom/my/target/nativeads/views/MediaAdView;", "setMediaView", "(Lcom/my/target/nativeads/views/MediaAdView;)V", "mediaView", "Landroid/widget/FrameLayout;", "getMyTargetIconViewContainer", "()Landroid/widget/FrameLayout;", "myTargetIconViewContainer", "Lcom/my/target/nativeads/views/IconAdView;", "getMtIconView", "()Lcom/my/target/nativeads/views/IconAdView;", "setMtIconView", "(Lcom/my/target/nativeads/views/IconAdView;)V", "mtIconView", "getFallbackColor", "()I", "fallbackColor", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/ViewGroup;", "getMediaViewContainer", "()Landroid/view/ViewGroup;", "mediaViewContainer", "getIconView", "iconView", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdMyTarget {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void createMediaViews(@NotNull AdMyTarget adMyTarget) {
            Context context;
            ViewGroup mediaViewContainer = adMyTarget.getMediaViewContainer();
            if (mediaViewContainer != null && (context = mediaViewContainer.getContext()) != null) {
                MediaAdView mediaAdView = NativeViewsFactory.getMediaAdView(context);
                mediaAdView.setId(R.id.nativeads_media_view);
                mediaAdView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Unit unit = Unit.INSTANCE;
                adMyTarget.setMediaView(mediaAdView);
                ViewGroup mediaViewContainer2 = adMyTarget.getMediaViewContainer();
                if (mediaViewContainer2 != null) {
                    mediaViewContainer2.setVisibility(0);
                }
                ViewGroup mediaViewContainer3 = adMyTarget.getMediaViewContainer();
                if (mediaViewContainer3 != null) {
                    mediaViewContainer3.addView(adMyTarget.getMediaView());
                }
                ViewGroup mediaViewContainer4 = adMyTarget.getMediaViewContainer();
                if (mediaViewContainer4 != null) {
                    RoundOutlineProviderKt.setCornerRadius(mediaViewContainer4, AdViewUtils.INSTANCE.resolveCornerRadius(adMyTarget.getImageView()));
                }
                IconAdView iconAdView = NativeViewsFactory.getIconAdView(context);
                iconAdView.setId(R.id.nativeads_icon);
                iconAdView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adMyTarget.setMtIconView(iconAdView);
                FrameLayout myTargetIconViewContainer = adMyTarget.getMyTargetIconViewContainer();
                if (myTargetIconViewContainer != null) {
                    myTargetIconViewContainer.setVisibility(0);
                }
                FrameLayout myTargetIconViewContainer2 = adMyTarget.getMyTargetIconViewContainer();
                if (myTargetIconViewContainer2 != null) {
                    myTargetIconViewContainer2.addView(adMyTarget.getMtIconView());
                }
                FrameLayout myTargetIconViewContainer3 = adMyTarget.getMyTargetIconViewContainer();
                if (myTargetIconViewContainer3 != null) {
                    RoundOutlineProviderKt.setCornerRadius(myTargetIconViewContainer3, AdViewUtils.INSTANCE.resolveCornerRadius(adMyTarget.getIconView()));
                }
            }
        }

        public static void disposeImageBg(@NotNull AdMyTarget adMyTarget) {
            Disposable imageBgDisposable = adMyTarget.getImageBgDisposable();
            if (imageBgDisposable != null) {
                imageBgDisposable.dispose();
            }
            adMyTarget.setImageBgDisposable(null);
        }

        public static void setMediaViewBackground(@NotNull AdMyTarget adMyTarget, int i) {
            if (i == -1) {
                i = adMyTarget.getFallbackColor();
            }
            MediaAdView mediaView = adMyTarget.getMediaView();
            if (mediaView != null) {
                mediaView.setBackgroundColor(0);
            }
            ViewGroup mediaViewContainer = adMyTarget.getMediaViewContainer();
            if (mediaViewContainer != null) {
                mediaViewContainer.setBackgroundColor(i);
            }
        }
    }

    @Nullable
    WeakReference<View> bindNativeAd(@NotNull NativeAd nativeAd, boolean z);

    void createMediaViews();

    void disposeImageBg();

    int getFallbackColor();

    @Nullable
    SimpleDraweeView getIconView();

    @Nullable
    Disposable getImageBgDisposable();

    @NotNull
    SimpleDraweeView getImageView();

    @Nullable
    MediaAdView getMediaView();

    @Nullable
    ViewGroup getMediaViewContainer();

    @Nullable
    IconAdView getMtIconView();

    @Nullable
    FrameLayout getMyTargetIconViewContainer();

    void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setImageBgDisposable(@Nullable Disposable disposable);

    void setMediaView(@Nullable MediaAdView mediaAdView);

    void setMediaViewBackground(int i);

    void setMtIconView(@Nullable IconAdView iconAdView);

    void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);
}
