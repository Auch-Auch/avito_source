package com.avito.android.design.widget.recycler;

import a2.b.a.a.a;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b \u0010!J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/design/widget/recycler/BackgroundDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lkotlin/ranges/IntRange;", "c", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "setRange", "(Lkotlin/ranges/IntRange;)V", "range", AuthSource.SEND_ABUSE, "Landroid/graphics/Rect;", "backgroundPadding", "Landroid/graphics/drawable/Drawable;", AuthSource.BOOKING_ORDER, "Landroid/graphics/drawable/Drawable;", "background", "<init>", "(Landroid/graphics/drawable/Drawable;Lkotlin/ranges/IntRange;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BackgroundDecoration extends RecyclerView.ItemDecoration {
    public final Rect a;
    public final Drawable b;
    @NotNull
    public IntRange c;

    public BackgroundDecoration(@NotNull Drawable drawable, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(drawable, "background");
        Intrinsics.checkNotNullParameter(intRange, "range");
        this.b = drawable;
        this.c = intRange;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        Unit unit = Unit.INSTANCE;
        this.a = rect;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == this.c.getFirst()) {
            rect.top = this.a.top;
        }
        if (childAdapterPosition == this.c.getLast()) {
            rect.bottom = this.a.bottom;
        }
    }

    @NotNull
    public final IntRange getRange() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft() - this.a.left;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) + this.a.right;
        int childCount = recyclerView.getChildCount() - 1;
        if (childCount >= 0) {
            int i3 = 0;
            i2 = Integer.MIN_VALUE;
            i = Integer.MIN_VALUE;
            while (true) {
                View childAt = recyclerView.getChildAt(i3);
                if (this.c.contains(recyclerView.getChildAdapterPosition(childAt))) {
                    if (i2 == Integer.MIN_VALUE) {
                        Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
                        i2 = childAt.getTop();
                    }
                    Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
                    i = childAt.getBottom();
                }
                if (i3 == childCount) {
                    break;
                }
                i3++;
            }
        } else {
            i2 = Integer.MIN_VALUE;
            i = Integer.MIN_VALUE;
        }
        if (i2 != Integer.MIN_VALUE && i != Integer.MIN_VALUE) {
            Rect rect = this.a;
            this.b.setBounds(paddingLeft, i2 - rect.top, width, i + rect.bottom);
            this.b.draw(canvas);
        }
    }

    public final void setRange(@NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<set-?>");
        this.c = intRange;
    }
}
