package ru.avito.component.serp;

import a2.b.a.a.a;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.ui_components.R;
import com.avito.android.util.StringUtils;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.preferences.Names;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a'\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroid/text/SpannableString;", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "applyRadiusInfoSpan", "(Landroid/text/SpannableString;Lcom/avito/android/remote/model/RadiusInfo;)Landroid/text/SpannableString;", "", Names.GEO, "formatGeoAddress", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)Ljava/lang/String;", "Landroid/widget/TextView;", FirebaseAnalytics.Param.DISCOUNT, "price", "oldPrice", "", "async", "withTopInset", "", "applyClassifiedDiscountToViews", "(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/String;ZZ)V", "discountPercentage", "newPriceValue", "discountPercentageValue", "applyMarketplaceDiscountToViews", "(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Z)V", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "title", "lowerDownTitle", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/View;)V", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class SerpAdvertTileCardKt {
    public static final void applyClassifiedDiscountToViews(@NotNull TextView textView, @NotNull TextView textView2, @Nullable String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(textView, FirebaseAnalytics.Param.DISCOUNT);
        Intrinsics.checkNotNullParameter(textView2, "price");
        if (str == null || str.length() == 0) {
            TextViews.setCompoundDrawables$default(textView2, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 11, (Object) null);
            textView.setText("");
            Views.hide(textView);
            return;
        }
        Drawable drawable = ContextCompat.getDrawable(textView.getContext(), R.drawable.markdown);
        if (drawable != null) {
            Intrinsics.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…wable.markdown) ?: return");
            TextViews.setCompoundDrawables$default(textView2, (Drawable) null, (Drawable) null, z2 ? new InsetDrawable(drawable, 0, Views.dpToPx(textView, 5), 0, 0) : drawable, (Drawable) null, 11, (Object) null);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new StrikethroughSpan(), 0, str.length(), 33);
            PrecomputedTextViewKt.bindTextAsync(textView, spannableString, z);
            Views.show(textView);
        }
    }

    public static /* synthetic */ void applyClassifiedDiscountToViews$default(TextView textView, TextView textView2, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 16) != 0) {
            z2 = false;
        }
        applyClassifiedDiscountToViews(textView, textView2, str, z, z2);
    }

    public static final void applyMarketplaceDiscountToViews(@NotNull TextView textView, @NotNull TextView textView2, @Nullable String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(textView, FirebaseAnalytics.Param.DISCOUNT);
        Intrinsics.checkNotNullParameter(textView2, "discountPercentage");
        boolean z2 = true;
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                z2 = false;
            }
            if (!z2) {
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new StrikethroughSpan(), 0, str.length(), 33);
                PrecomputedTextViewKt.bindTextAsync(textView, spannableString, z);
                Views.show(textView);
                PrecomputedTextViewKt.bindTextAsync(textView2, str2, z);
                Views.show(textView2);
                return;
            }
        }
        textView.setText("");
        Views.hide(textView);
        textView2.setText("");
        Views.hide(textView2);
    }

    @NotNull
    public static final SpannableString applyRadiusInfoSpan(@NotNull SpannableString spannableString, @NotNull RadiusInfo radiusInfo) {
        Integer parseColorOrNull;
        Intrinsics.checkNotNullParameter(spannableString, "$this$applyRadiusInfoSpan");
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        String color = radiusInfo.getColor();
        if (!(color == null || (parseColorOrNull = StringUtils.parseColorOrNull(color)) == null)) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(parseColorOrNull.intValue());
            String distance = radiusInfo.getDistance();
            if (distance != null) {
                spannableString.setSpan(foregroundColorSpan, 0, distance.length(), 17);
            }
        }
        return spannableString;
    }

    @NotNull
    public static final String formatGeoAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
        Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
        if (str == null || str.length() == 0) {
            return a.H(new Object[]{radiusInfo.getDistance()}, 1, "%s", "java.lang.String.format(format, *args)");
        }
        return a.H(new Object[]{radiusInfo.getDistance(), radiusInfo.getDelimiter(), str}, 3, "%s%s%s", "java.lang.String.format(format, *args)");
    }

    public static final void lowerDownTitle(@NotNull ViewGroup viewGroup, @NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(view, "title");
        Intrinsics.checkNotNullParameter(view2, FirebaseAnalytics.Param.DISCOUNT);
        viewGroup.removeView(view);
        int indexOfChild = viewGroup.indexOfChild(view2) + 1;
        if (indexOfChild > 0) {
            viewGroup.addView(view, indexOfChild);
        }
    }
}
