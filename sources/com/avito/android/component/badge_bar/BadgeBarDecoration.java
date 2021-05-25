package com.avito.android.component.badge_bar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\r\u0012\b\b\u0002\u00100\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b1\u00102J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\"\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u000fR\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u000fR\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u000fR\"\u0010*\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d¨\u00063"}, d2 = {"Lcom/avito/android/component/badge_bar/BadgeBarDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "d", "I", "expandButtonBottomMargin", AuthSource.BOOKING_ORDER, "verticalMargin", g.a, "verticalBadgeExtraPadding", "k", "expandItemViewType", "c", "expandButtonTopMargin", "i", "getOrientation", "()I", "setOrientation", "(I)V", "orientation", AuthSource.SEND_ABUSE, "horizontalMargin", "h", "spanCount", "e", "leftOffset", "f", "rightOffset", "j", "getColumnCount", "setColumnCount", "columnCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;III)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeBarDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public int i;
    public int j;
    public final int k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgeBarDecoration(Context context, AttributeSet attributeSet, int i2, int i3, int i4, int i5, j jVar) {
        this(context, (i5 & 2) != 0 ? null : attributeSet, (i5 & 4) != 0 ? R.attr.advertBadgeBar : i2, (i5 & 8) != 0 ? R.style.Widget_Avito_AdvertBadgeBar : i3, (i5 & 16) != 0 ? -1 : i4);
    }

    public final int getColumnCount() {
        return this.j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Integer num = null;
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemViewType(childAdapterPosition)) : null;
        int i2 = this.k;
        if (valueOf != null && valueOf.intValue() == i2) {
            rect.top = this.c;
            rect.bottom = this.d;
            rect.left = this.e;
            rect.right = this.f;
            return;
        }
        boolean z = true;
        int i3 = 0;
        if (this.i == 0) {
            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
            Object valueOf2 = adapter2 != null ? Integer.valueOf(adapter2.getItemCount() - 1) : Boolean.FALSE;
            boolean z2 = (valueOf2 instanceof Integer) && childAdapterPosition == ((Integer) valueOf2).intValue();
            Integer valueOf3 = Integer.valueOf(this.a);
            valueOf3.intValue();
            if (childAdapterPosition <= 0) {
                z = false;
            }
            if (!z) {
                valueOf3 = null;
            }
            rect.left = valueOf3 != null ? valueOf3.intValue() : this.e;
            Integer valueOf4 = Integer.valueOf(this.f);
            valueOf4.intValue();
            if (z2) {
                num = valueOf4;
            }
            if (num != null) {
                i3 = num.intValue();
            }
            rect.right = i3;
            return;
        }
        int i4 = this.h;
        int i5 = childAdapterPosition / i4;
        int i6 = childAdapterPosition % i4;
        int i7 = this.e;
        int i8 = this.g;
        int i9 = i7 + i8;
        int i10 = this.f + i8;
        Integer valueOf5 = Integer.valueOf(this.a);
        valueOf5.intValue();
        if (!(i6 > 0)) {
            valueOf5 = null;
        }
        if (valueOf5 != null) {
            i9 = valueOf5.intValue();
        }
        rect.left = i9;
        Integer valueOf6 = Integer.valueOf(i10);
        valueOf6.intValue();
        if (!(i6 == this.h - 1)) {
            valueOf6 = null;
        }
        rect.right = valueOf6 != null ? valueOf6.intValue() : 0;
        Integer valueOf7 = Integer.valueOf(this.b);
        valueOf7.intValue();
        if (i5 <= 0) {
            z = false;
        }
        if (z) {
            num = valueOf7;
        }
        if (num != null) {
            i3 = num.intValue();
        }
        rect.top = i3;
    }

    public final int getOrientation() {
        return this.i;
    }

    public final void setColumnCount(int i2) {
        this.j = i2;
    }

    public final void setOrientation(int i2) {
        this.i = i2;
    }

    public BadgeBarDecoration(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.k = i4;
        this.j = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdvertBadgeBar, i2, i3);
        this.a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdvertBadgeBar_horizontalMargin, 0);
        this.b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdvertBadgeBar_verticalMargin, 0);
        this.e = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdvertBadgeBar_leftOffset, 0);
        this.f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdvertBadgeBar_rightOffset, 0);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdvertBadgeBar_verticalBadgeExtraPadding, 0);
        this.c = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdvertBadgeBar_expandButtonTopMargin, 0);
        this.d = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdvertBadgeBar_expandButtonBottomMargin, 0);
        this.h = obtainStyledAttributes.getInteger(R.styleable.AdvertBadgeBar_spanCount, this.j);
        obtainStyledAttributes.recycle();
    }
}
