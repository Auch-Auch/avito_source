package com.avito.android.component.ads.adfox;

import a2.g.r.g;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener;
import com.yandex.mobile.ads.nativeads.NativeImageAd;
import com.yandex.mobile.ads.nativeads.NativeImageAdView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'JC\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/component/ads/adfox/AdfoxImageImpl;", "Lcom/avito/android/component/ads/adfox/AdfoxImage;", "Lcom/yandex/mobile/ads/nativeads/NativeImageAd;", "nativeAd", "", "isClosed", "showGrayBadge", "Lkotlin/Function0;", "", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeImageAd;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "moreInfoButton", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "closeButton", "c", "titleView", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageView;", "imageView", "Landroid/view/View;", g.a, "Landroid/view/View;", "badgeView", "f", InternalConstsKt.PLACEHOLDER, "Lcom/yandex/mobile/ads/nativeads/NativeImageAdView;", AuthSource.SEND_ABUSE, "Lcom/yandex/mobile/ads/nativeads/NativeImageAdView;", "adView", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdfoxImageImpl implements AdfoxImage {
    public final NativeImageAdView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final Button e;
    public final View f;
    public final View g;

    public static final class a extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ AdfoxImageImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdfoxImageImpl adfoxImageImpl) {
            super(1);
            this.a = adfoxImageImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Intrinsics.checkNotNullParameter(view, "it");
            this.a.b.performClick();
            return Unit.INSTANCE;
        }
    }

    public AdfoxImageImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.yandex_image_ad_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.yandex.mobile.ads.nativeads.NativeImageAdView");
        NativeImageAdView nativeImageAdView = (NativeImageAdView) findViewById;
        this.a = nativeImageAdView;
        View findViewById2 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById2;
        this.b = imageView;
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        this.c = textView;
        View findViewById4 = view.findViewById(R.id.more_info_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById4;
        this.d = textView2;
        Button button = (Button) view.findViewById(R.id.close_button);
        this.e = button;
        this.f = view.findViewById(R.id.placeholder);
        View findViewById5 = view.findViewById(R.id.badge);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.badge)");
        this.g = findViewById5;
        if (button != null) {
            Views.hide(button);
        }
        nativeImageAdView.setFeedbackView(button);
        nativeImageAdView.setImageView(imageView);
        a aVar = new a(this);
        for (View view2 : CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{nativeImageAdView, textView, textView2})) {
            view2.setOnClickListener(new a2.a.a.a.b.a.a(aVar));
        }
    }

    @Override // com.avito.android.component.ads.adfox.AdfoxImage
    public void bindAd(@NotNull NativeImageAd nativeImageAd, boolean z, boolean z2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(nativeImageAd, "nativeAd");
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        Intrinsics.checkNotNullParameter(function02, "openListener");
        View view = this.f;
        if (view == null || !z) {
            if (view != null) {
                view.setVisibility(8);
            }
            if (z2) {
                this.g.setBackgroundResource(com.avito.android.lib.design.R.drawable.design_background_badge_age);
            } else {
                this.g.setBackgroundResource(com.avito.android.lib.design.R.drawable.design_background_badge_advertising_single);
            }
            nativeImageAd.bindImageAd(this.a);
            nativeImageAd.loadImages();
            nativeImageAd.setAdEventListener(new ClosableNativeAdEventListener.SimpleClosableNativeAdEventListener(function0, function02) { // from class: com.avito.android.component.ads.adfox.AdfoxImageImpl$bindAd$1
                public final /* synthetic */ Function0 a;
                public final /* synthetic */ Function0 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener.SimpleClosableNativeAdEventListener, com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener
                public void closeNativeAd() {
                    this.a.invoke();
                }

                @Override // com.yandex.mobile.ads.nativeads.NativeAdEventListener.SimpleNativeAdEventListener, com.yandex.mobile.ads.nativeads.NativeAdEventListener
                public void onAdLeftApplication() {
                    this.b.invoke();
                }

                @Override // com.yandex.mobile.ads.nativeads.NativeAdEventListener.SimpleNativeAdEventListener, com.yandex.mobile.ads.nativeads.NativeAdEventListener
                public void onAdOpened() {
                    this.b.invoke();
                }
            });
            TextViews.bindText$default(this.c, nativeImageAd.getInfo(), false, 2, null);
            return;
        }
        view.setVisibility(0);
    }
}
