package com.avito.android.lib.design.chips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017¨\u0006!"}, d2 = {"Lcom/avito/android/lib/design/chips/FixedChipsLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "generateLayoutParams", "(Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "lp", "(Landroid/view/ViewGroup$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "", "checkLayoutParams", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Z", "", "P", "()I", "layoutParams", "Q", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "I", "spaceBetweenItems", "K", "Z", "fixedLayout", "J", "minChildWidth", "context", "<init>", "(Landroid/content/Context;IIZ)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class FixedChipsLinearLayoutManager extends LinearLayoutManager {
    public final int I;
    public final int J;
    public final boolean K;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedChipsLinearLayoutManager(@NotNull Context context, int i, int i2, boolean z) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
        this.I = i;
        this.J = i2;
        this.K = z;
    }

    public final int P() {
        int max = Math.max((((getWidth() - getPaddingRight()) - getPaddingLeft()) - ((getItemCount() - 1) * this.I)) / getItemCount(), 0);
        if (!this.K || max < this.J) {
            return -2;
        }
        return max;
    }

    public final RecyclerView.LayoutParams Q(RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = P();
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(@Nullable RecyclerView.LayoutParams layoutParams) {
        return layoutParams != null && ((ViewGroup.MarginLayoutParams) layoutParams).width == P();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams generateDefaultLayoutParams = super.generateDefaultLayoutParams();
        Intrinsics.checkNotNullExpressionValue(generateDefaultLayoutParams, "super.generateDefaultLayoutParams()");
        Q(generateDefaultLayoutParams);
        return generateDefaultLayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateLayoutParams(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "c");
        RecyclerView.LayoutParams generateLayoutParams = super.generateLayoutParams(context, attributeSet);
        Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "super.generateLayoutParams(c, attrs)");
        Q(generateLayoutParams);
        return generateLayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "lp");
        RecyclerView.LayoutParams generateLayoutParams = super.generateLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(generateLayoutParams, "super.generateLayoutParams(lp)");
        Q(generateLayoutParams);
        return generateLayoutParams;
    }
}
