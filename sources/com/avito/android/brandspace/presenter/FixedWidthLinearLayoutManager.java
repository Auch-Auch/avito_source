package com.avito.android.brandspace.presenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B=\b\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 B)\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u0018\u0012\u0006\u0010\"\u001a\u00020\u0018¢\u0006\u0004\b\u001f\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\n\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/avito/android/brandspace/presenter/FixedWidthLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "()Z", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "lp", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "P", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "J", "Z", "isScrollEnabled", "setScrollEnabled", "(Z)V", "", "I", "Ljava/lang/Integer;", "fixedWidth", "context", "orientation", "reverseLayout", "<init>", "(Landroid/content/Context;IZLjava/lang/Integer;Z)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class FixedWidthLinearLayoutManager extends LinearLayoutManager {
    public Integer I;
    public boolean J;

    @JvmOverloads
    public FixedWidthLinearLayoutManager(@Nullable Context context) {
        this(context, 0, false, null, false, 30, null);
    }

    @JvmOverloads
    public FixedWidthLinearLayoutManager(@Nullable Context context, int i) {
        this(context, i, false, null, false, 28, null);
    }

    @JvmOverloads
    public FixedWidthLinearLayoutManager(@Nullable Context context, int i, boolean z) {
        this(context, i, z, null, false, 24, null);
    }

    @JvmOverloads
    public FixedWidthLinearLayoutManager(@Nullable Context context, int i, boolean z, @Nullable Integer num) {
        this(context, i, z, num, false, 16, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FixedWidthLinearLayoutManager(Context context, int i, boolean z, Integer num, boolean z2, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? true : z2);
    }

    public final RecyclerView.LayoutParams P(RecyclerView.LayoutParams layoutParams) {
        if (getOrientation() == 0) {
            Integer num = this.I;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = num != null ? num.intValue() : ((ViewGroup.MarginLayoutParams) layoutParams).width;
        }
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.J && super.canScrollHorizontally();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams generateDefaultLayoutParams = super.generateDefaultLayoutParams();
        Intrinsics.checkNotNullExpressionValue(generateDefaultLayoutParams, "super.generateDefaultLayoutParams()");
        P(generateDefaultLayoutParams);
        return generateDefaultLayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateLayoutParams(@Nullable ViewGroup.LayoutParams layoutParams) {
        RecyclerView.LayoutParams generateLayoutParams = super.generateLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "super.generateLayoutParams(lp)");
        P(generateLayoutParams);
        return generateLayoutParams;
    }

    public final boolean isScrollEnabled() {
        return this.J;
    }

    public final void setScrollEnabled(boolean z) {
        this.J = z;
    }

    @JvmOverloads
    public FixedWidthLinearLayoutManager(@Nullable Context context, int i, boolean z, @Nullable Integer num, boolean z2) {
        super(context, i, z);
        this.J = true;
        this.I = num;
        this.J = z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateLayoutParams(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        RecyclerView.LayoutParams generateLayoutParams = super.generateLayoutParams(context, attributeSet);
        Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "super.generateLayoutParams(c, attrs)");
        P(generateLayoutParams);
        return generateLayoutParams;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedWidthLinearLayoutManager(@NotNull Context context, @NotNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.J = true;
    }
}
