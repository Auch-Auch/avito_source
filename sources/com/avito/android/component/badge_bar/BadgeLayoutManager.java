package com.avito.android.component.badge_bar;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B1\b\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dB)\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/avito/android/component/badge_bar/BadgeLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "lp", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroid/content/Context;", "c", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "", "checkLayoutParams", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Z", "layoutParams", "P", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "", "I", "F", "ratio", "context", "", "orientation", "reverseLayout", "<init>", "(Landroid/content/Context;IZF)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeLayoutManager extends LinearLayoutManager {
    public float I;

    @JvmOverloads
    public BadgeLayoutManager(@Nullable Context context) {
        this(context, 0, false, 0.0f, 14, null);
    }

    @JvmOverloads
    public BadgeLayoutManager(@Nullable Context context, int i) {
        this(context, i, false, 0.0f, 12, null);
    }

    @JvmOverloads
    public BadgeLayoutManager(@Nullable Context context, int i, boolean z) {
        this(context, i, z, 0.0f, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgeLayoutManager(Context context, int i, boolean z, float f, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 1.0f : f);
    }

    public final RecyclerView.LayoutParams P(RecyclerView.LayoutParams layoutParams) {
        if (getOrientation() == 0 && getItemCount() > 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (((float) ((getWidth() - getPaddingStart()) - getPaddingEnd())) * this.I);
        }
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(@Nullable RecyclerView.LayoutParams layoutParams) {
        return (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).width == 0) ? false : true;
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

    @JvmOverloads
    public BadgeLayoutManager(@Nullable Context context, int i, boolean z, float f) {
        super(context, i, z);
        this.I = 1.0f;
        this.I = f;
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
    public BadgeLayoutManager(@NotNull Context context, @NotNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.I = 1.0f;
    }
}
