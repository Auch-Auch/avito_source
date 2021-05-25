package com.avito.android.lib.design.list_item.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewGroupsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001d\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB%\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006 "}, d2 = {"Lcom/avito/android/lib/design/list_item/layout/PaddingLinearLayout;", "Landroid/widget/LinearLayout;", "", "minHeight", "", "setMinimumHeight", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", AuthSource.SEND_ABUSE, "I", "totalHeight", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PaddingLinearLayout extends LinearLayout {
    public int a;
    public int b;

    public static final class a extends Lambda implements Function1<View, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return Boolean.valueOf(view2.getVisibility() != 8);
        }
    }

    public static final class b extends Lambda implements Function1<View, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return Boolean.valueOf(view2.getVisibility() != 8);
        }
    }

    public static final class c extends Lambda implements Function1<View, Integer> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return Integer.valueOf(view2.getMeasuredHeight());
        }
    }

    public PaddingLinearLayout(@Nullable Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.b < getMeasuredHeight()) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int i5 = ((i4 - i2) - this.a) / 2;
        for (View view : SequencesKt___SequencesKt.filter(SequencesKt__SequencesKt.asSequence(ViewGroupsKt.getChildren(this)), a.a)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i6 = 0;
            int i7 = i5 + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0);
            int paddingLeft = getPaddingLeft() + (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
            int paddingRight = getPaddingRight() + view.getMeasuredWidth() + paddingLeft + (marginLayoutParams != null ? marginLayoutParams.rightMargin : 0);
            int measuredHeight = view.getMeasuredHeight() + i7;
            view.layout(paddingLeft, i7, paddingRight, measuredHeight);
            if (marginLayoutParams != null) {
                i6 = marginLayoutParams.bottomMargin;
            }
            i5 = measuredHeight + i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.a = SequencesKt___SequencesKt.sumOfInt(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(SequencesKt__SequencesKt.asSequence(ViewGroupsKt.getChildren(this)), b.a), c.a));
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.b = i;
        super.setMinimumHeight(i);
    }

    public PaddingLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PaddingLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
