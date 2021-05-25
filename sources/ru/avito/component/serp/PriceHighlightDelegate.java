package ru.avito.component.serp;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lru/avito/component/serp/PriceHighlightDelegate;", "Lru/avito/component/serp/HighlightDelegate;", "", "value", "", "highlighted", "", "setText", "(Ljava/lang/String;Z)V", "", "d", "I", "highlightedTextBackgroundColor", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", g.a, "highlightedLeftMargin", "i", "Z", "isAsyncText", "e", "highlightOffset", "f", "defaultLeftMargin", "c", "highlightedTextColor", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "price", "withNegativeLeftMargin", "<init>", "(Landroid/widget/TextView;ZZ)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PriceHighlightDelegate implements HighlightDelegate {
    public final Context a;
    public final Resources b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final TextView h;
    public final boolean i;

    public PriceHighlightDelegate(@NotNull TextView textView, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(textView, "price");
        this.h = textView;
        this.i = z2;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "price.context");
        this.a = context;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.b = resources;
        this.c = Contexts.getColorByAttr(context, R.attr.constantWhite);
        this.d = Contexts.getColorByAttr(context, R.attr.blue);
        this.e = resources.getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.rich_snippet_text_highlight_offset);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
        int i2 = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
        this.f = i2;
        this.g = z ? resources.getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.rich_snippet_text_highlight_margin) : i2;
    }

    @Override // ru.avito.component.serp.HighlightDelegate
    public void setText(@Nullable String str, boolean z) {
        int i2;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (str == null) {
            this.h.setText((CharSequence) null);
            Views.hide(this.h);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        if (z) {
            i2 = this.e;
            spannableString.setSpan(new PaddingBackgroundColorSpan(this.d, i2), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(this.c), 0, str.length(), 33);
        } else {
            i2 = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.setMargins(z ? this.g : this.f, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
        }
        Views.changePadding$default(this.h, i2, 0, i2, 0, 10, null);
        this.h.setShadowLayer((float) i2, 0.0f, 0.0f, 0);
        PrecomputedTextViewKt.bindTextAsync(this.h, spannableString, this.i);
    }
}
