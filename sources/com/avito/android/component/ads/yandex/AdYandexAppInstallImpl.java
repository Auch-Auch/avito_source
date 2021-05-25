package com.avito.android.component.ads.yandex;

import a2.g.r.g;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.design.widget.YandexRatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAd;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAdView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010:\u001a\u000202¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0012R\u0018\u0010'\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001cR\u0018\u0010)\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0012R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0012R\u0018\u00101\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0012R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0012R\u0016\u00109\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0016¨\u0006="}, d2 = {"Lcom/avito/android/component/ads/yandex/AdYandexAppInstallImpl;", "Lcom/avito/android/component/ads/yandex/AdYandexAppInstall;", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "", "bindBody", "(Lcom/avito/android/app/DescriptionPosition;)V", "Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;", "nativeAd", "", "isClose", "Lkotlin/Function0;", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "titleView", "Landroid/widget/ImageView;", g.a, "Landroid/widget/ImageView;", "iconView", AuthSource.BOOKING_ORDER, "ageView", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "callToActionView", "d", "bodyTopView", "Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAdView;", AuthSource.SEND_ABUSE, "Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAdView;", "adView", "j", "sponsoredView", "n", "closeButton", "c", "bodyBottomView", "Lcom/avito/android/design/widget/YandexRatingBar;", "i", "Lcom/avito/android/design/widget/YandexRatingBar;", "ratingView", AuthSource.OPEN_CHANNEL_LIST, "domainView", "e", "descriptionView", "Landroid/view/View;", "o", "Landroid/view/View;", InternalConstsKt.PLACEHOLDER, "l", "disclaimerView", "h", "imageView", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdYandexAppInstallImpl implements AdYandexAppInstall {
    public final NativeAppInstallAdView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final Button f;
    public final ImageView g;
    public final ImageView h;
    public final YandexRatingBar i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final Button n;
    public final View o;

    public AdYandexAppInstallImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.ad_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.yandex.mobile.ads.nativeads.NativeAppInstallAdView");
        NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) findViewById;
        this.a = nativeAppInstallAdView;
        View findViewById2 = view.findViewById(R.id.age);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        this.b = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.body_bottom);
        this.c = textView2;
        TextView textView3 = (TextView) view.findViewById(R.id.body_top);
        this.d = textView3;
        TextView textView4 = (TextView) view.findViewById(R.id.description);
        this.e = textView4;
        View findViewById3 = view.findViewById(R.id.call_to_action);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById3;
        this.f = button;
        View findViewById4 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById4;
        this.g = imageView;
        View findViewById5 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView2 = (ImageView) findViewById5;
        this.h = imageView2;
        YandexRatingBar yandexRatingBar = (YandexRatingBar) view.findViewById(R.id.rating);
        this.i = yandexRatingBar;
        View findViewById6 = view.findViewById(R.id.sponsored);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView5 = (TextView) findViewById6;
        this.j = textView5;
        View findViewById7 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView6 = (TextView) findViewById7;
        this.k = textView6;
        View findViewById8 = view.findViewById(R.id.disclaimer);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView7 = (TextView) findViewById8;
        this.l = textView7;
        TextView textView8 = (TextView) view.findViewById(R.id.domain);
        this.m = textView8;
        Button button2 = (Button) view.findViewById(R.id.close_button);
        this.n = button2;
        this.o = view.findViewById(R.id.placeholder);
        boolean z = true;
        if (!((textView3 == null) ^ (textView2 == null))) {
            if (!((textView3 != null ? false : z) ^ (textView4 != null))) {
                if (button2 != null) {
                    Views.hide(button2);
                }
                nativeAppInstallAdView.setAgeView(textView);
                nativeAppInstallAdView.setCallToActionView(button);
                nativeAppInstallAdView.setIconView(imageView);
                nativeAppInstallAdView.setImageView(imageView2);
                nativeAppInstallAdView.setRatingView(yandexRatingBar);
                nativeAppInstallAdView.setSponsoredView(textView5);
                nativeAppInstallAdView.setTitleView(textView6);
                nativeAppInstallAdView.setWarningView(textView7);
                nativeAppInstallAdView.setBodyView(textView4);
                nativeAppInstallAdView.setDomainView(textView8);
                return;
            }
            throw new IllegalStateException("Must be present either description or body_top and body_bottom");
        }
        throw new IllegalStateException("body_top and body_bottom must be present or absent at the same time");
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexAppInstall
    public void bindAd(@NotNull NativeAppInstallAd nativeAppInstallAd, boolean z, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(nativeAppInstallAd, "nativeAd");
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        Intrinsics.checkNotNullParameter(function02, "openListener");
        View view = this.o;
        if (view == null || !z) {
            if (view != null) {
                view.setVisibility(8);
            }
            nativeAppInstallAd.bindAppInstallAd(this.a);
            nativeAppInstallAd.setAdEventListener(new ClosableNativeAdEventListener.SimpleClosableNativeAdEventListener(function0, function02) { // from class: com.avito.android.component.ads.yandex.AdYandexAppInstallImpl$bindAd$1
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
            nativeAppInstallAd.loadImages();
            return;
        }
        view.setVisibility(0);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexAppInstall
    public void bindBody(@NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        if (descriptionPosition instanceof DescriptionPosition.Bottom) {
            Views.show(this.c);
            Views.hide(this.d);
            TextView textView = this.c;
            if (textView != null) {
                this.a.setBodyView(textView);
            }
        } else if (descriptionPosition instanceof DescriptionPosition.Top) {
            Views.hide(this.c);
            Views.show(this.d);
            TextView textView2 = this.d;
            if (textView2 != null) {
                this.a.setBodyView(textView2);
            }
        }
    }
}
