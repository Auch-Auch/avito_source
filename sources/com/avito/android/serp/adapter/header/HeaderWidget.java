package com.avito.android.serp.adapter.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp_core.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/avito/android/serp/adapter/header/HeaderWidget;", "Landroid/widget/LinearLayout;", "", "title", "", "texts", "", "setData", "(Ljava/lang/String;Ljava/util/List;)V", "", "c", "I", "textAppearanceId", AuthSource.BOOKING_ORDER, "bottomMarginText", "d", "titleTextAppearanceId", AuthSource.SEND_ABUSE, "bottomMarginTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderWidget extends LinearLayout {
    public int a;
    public int b;
    public int c;
    public int d;

    @JvmOverloads
    public HeaderWidget(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public HeaderWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public HeaderWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderWidget(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.headerWidget : i, (i3 & 8) != 0 ? R.style.Widget_HeaderWidget : i2);
    }

    public final void setData(@Nullable String str, @Nullable List<String> list) {
        removeAllViews();
        if (str != null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            TextViews.setTextAppearanceCompat(appCompatTextView, this.d);
            appCompatTextView.setText(str);
            addView(appCompatTextView);
            if (list != null && (!list.isEmpty())) {
                ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = this.a;
            }
        }
        if (list != null) {
            Iterator<T> it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext());
                TextViews.setTextAppearanceCompat(appCompatTextView2, this.c);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) it.next());
                int i2 = 0;
                int i3 = 0;
                while (i2 < spannableStringBuilder.length()) {
                    int i4 = i3 + 1;
                    if (spannableStringBuilder.charAt(i2) == 183) {
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28)), i3, i4, 17);
                    }
                    i2++;
                    i3 = i4;
                }
                appCompatTextView2.setText(spannableStringBuilder);
                addView(appCompatTextView2);
                if (i != CollectionsKt__CollectionsKt.getLastIndex(list)) {
                    ViewGroup.LayoutParams layoutParams2 = appCompatTextView2.getLayoutParams();
                    Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    ((LinearLayout.LayoutParams) layoutParams2).bottomMargin = this.b;
                }
                i++;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeaderWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HeaderWidget, i, i2);
        int i3 = R.styleable.HeaderWidget_headerWidget_titleTextAppearance;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.d = obtainStyledAttributes.getResourceId(i3, 0);
        }
        int i4 = R.styleable.HeaderWidget_headerWidget_textAppearance;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.c = obtainStyledAttributes.getResourceId(i4, 0);
        }
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.HeaderWidget_headerWidget_textBottomMargin, this.b);
        this.a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.HeaderWidget_headerWidget_titleBottomMargin, this.a);
        obtainStyledAttributes.recycle();
    }
}
