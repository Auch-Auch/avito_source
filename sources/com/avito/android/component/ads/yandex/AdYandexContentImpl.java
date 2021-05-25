package com.avito.android.component.ads.yandex;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import com.yandex.mobile.ads.nativeads.NativeContentAdView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020)¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010#R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010#R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010#R\u0018\u00109\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010#R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010#¨\u0006B"}, d2 = {"Lcom/avito/android/component/ads/yandex/AdYandexContentImpl;", "Lcom/avito/android/component/ads/yandex/AdYandexContent;", "Landroid/widget/Button;", "view", "", "setFeedbackView", "(Landroid/widget/Button;)V", "", "clipToOutline", "setImageClipToOutline", "(Z)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "hasImage", "()Z", "Lcom/yandex/mobile/ads/nativeads/NativeContentAd;", "nativeAd", "isClose", "isRedesign", "Lkotlin/Function0;", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeContentAd;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "j", "Landroid/widget/Button;", "closeButton", "", AuthSource.OPEN_CHANNEL_LIST, "I", "initialDescriptionColor", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "badgeView", "i", "moreInfoButton", "c", "descriptionView", "Landroid/view/View;", "k", "Landroid/view/View;", InternalConstsKt.PLACEHOLDER, "h", "disclaimerView", "l", "Landroid/graphics/drawable/Drawable;", "initialBadgeBackground", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageView;", "imageView", "f", "ageView", g.a, "domainView", "Lcom/yandex/mobile/ads/nativeads/NativeContentAdView;", AuthSource.SEND_ABUSE, "Lcom/yandex/mobile/ads/nativeads/NativeContentAdView;", "adView", "d", "titleView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdYandexContentImpl implements AdYandexContent {
    public final NativeContentAdView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final Button i;
    public final Button j;
    public final View k;
    public final Drawable l;
    public final int m;

    public AdYandexContentImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.yandex_content_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.yandex.mobile.ads.nativeads.NativeContentAdView");
        NativeContentAdView nativeContentAdView = (NativeContentAdView) findViewById;
        this.a = nativeContentAdView;
        View findViewById2 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById2;
        this.b = imageView;
        View findViewById3 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        this.c = textView;
        View findViewById4 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById4;
        this.d = textView2;
        View findViewById5 = view.findViewById(R.id.badge);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById5;
        this.e = textView3;
        View findViewById6 = view.findViewById(R.id.age);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) findViewById6;
        this.f = textView4;
        TextView textView5 = (TextView) view.findViewById(R.id.domain);
        this.g = textView5;
        TextView textView6 = (TextView) view.findViewById(R.id.disclaimer);
        this.h = textView6;
        Button button = (Button) view.findViewById(R.id.more_info_button);
        this.i = button;
        Button button2 = (Button) view.findViewById(R.id.close_button);
        this.j = button2;
        this.k = view.findViewById(R.id.placeholder);
        Drawable background = textView3.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "badgeView.background");
        this.l = background;
        this.m = textView.getCurrentTextColor();
        if (button2 != null) {
            Views.hide(button2);
        }
        nativeContentAdView.setTitleView(textView2);
        nativeContentAdView.setImageView(imageView);
        nativeContentAdView.setAgeView(textView4);
        nativeContentAdView.setSponsoredView(textView3);
        nativeContentAdView.setBodyView(textView);
        nativeContentAdView.setWarningView(textView6);
        nativeContentAdView.setDomainView(textView5);
        nativeContentAdView.setCallToActionView(button);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void bindAd(@NotNull NativeContentAd nativeContentAd, boolean z, boolean z2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(nativeContentAd, "nativeAd");
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        Intrinsics.checkNotNullParameter(function02, "openListener");
        View view = this.k;
        if (view == null || !z) {
            if (view != null) {
                view.setVisibility(8);
            }
            if (z2) {
                TextView textView = this.g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                this.a.setDomainView(null);
                this.e.setBackgroundResource(com.avito.android.lib.design.R.drawable.design_background_badge_age);
                TextView textView2 = this.c;
                Context context = textView2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "descriptionView.context");
                textView2.setTextColor(Contexts.getColorCompat(context, com.avito.android.lib.design.avitomaterial.R.color.design_gray_700));
            } else {
                TextView textView3 = this.g;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                this.a.setDomainView(this.g);
                this.e.setBackground(this.l);
                this.c.setTextColor(this.m);
            }
            nativeContentAd.bindContentAd(this.a);
            nativeContentAd.setAdEventListener(new SoftAdListener(function0, function02));
            nativeContentAd.loadImages();
            return;
        }
        view.setVisibility(0);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public boolean hasImage() {
        return this.b.getDrawable() != null;
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void setFeedbackView(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "view");
        this.a.setFeedbackView(button);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void setImage(@Nullable Drawable drawable) {
        this.b.setImageDrawable(drawable);
    }

    @Override // com.avito.android.component.ads.yandex.AdYandexContent
    public void setImageClipToOutline(boolean z) {
        this.b.setClipToOutline(z);
    }
}
