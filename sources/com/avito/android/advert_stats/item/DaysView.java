package com.avito.android.advert_stats.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/avito/android/advert_stats/item/DaysView;", "Landroid/widget/LinearLayout;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "setDayWidth", "(I)V", VKApiConst.POSITION, "", "selected", "selectDay", "(IZ)V", "removeSelection", "()V", AuthSource.BOOKING_ORDER, "I", "selectedTextColor", "d", "selectedItemPosition", AuthSource.SEND_ABUSE, "defaultTextColor", "c", "margin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class DaysView extends LinearLayout {
    public final int a;
    public final int b;
    public final int c;
    public int d;

    @JvmOverloads
    public DaysView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public DaysView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DaysView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void removeSelection() {
        View childAt = getChildAt(this.d);
        if (childAt != null) {
            ((TextView) childAt).setTextColor(this.a);
            this.d = -1;
        }
    }

    public final void selectDay(int i, boolean z) {
        View childAt = getChildAt(this.d);
        if (childAt != null) {
            ((TextView) childAt).setTextColor(this.a);
        }
        View childAt2 = getChildAt(i);
        if (childAt2 != null) {
            ((TextView) childAt2).setTextColor(z ? this.b : this.a);
        }
        if (!z) {
            i = -1;
        }
        this.d = i;
    }

    public final void setDayWidth(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNullExpressionValue(childAt, "view");
            childAt.getLayoutParams().width = i;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DaysView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = Contexts.getColorByAttr(context, R.attr.gray48);
        this.b = Contexts.getColorByAttr(context, R.attr.black);
        this.c = getResources().getDimensionPixelSize(com.avito.android.advert_stats.R.dimen.gap_between_bars_small);
        this.d = -1;
        String[] stringArray = getResources().getStringArray(com.avito.android.advert_stats.R.array.days_of_week);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.days_of_week)");
        for (String str : stringArray) {
            TextView textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i2 = this.c;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            Unit unit = Unit.INSTANCE;
            textView.setLayoutParams(layoutParams);
            Intrinsics.checkNotNullExpressionValue(str, "title");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String upperCase = str.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
            textView.setText(upperCase);
            TextViews.setTextAppearanceCompat(textView, R.style.Design_TextAppearance_Avito_Micro);
            textView.setTextColor(this.a);
            textView.setGravity(17);
            addView(textView);
        }
    }
}
