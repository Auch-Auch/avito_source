package com.avito.android.advert_stats.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_stats.R;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017¨\u0006%"}, d2 = {"Lcom/avito/android/advert_stats/recycler/WeeksDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/drawable/Drawable;", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/Drawable;", "divider", "", AuthSource.BOOKING_ORDER, "I", "sideOffset", "d", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "c", "bottomOffset", "e", "decorationSize", "Landroid/content/Context;", "context", "", "hasAccentedView", "<init>", "(Landroid/content/Context;IZ)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class WeeksDecoration extends RecyclerView.ItemDecoration {
    public final Drawable a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public WeeksDecoration(@NotNull Context context, int i, boolean z) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = i;
        if (z) {
            drawable = context.getDrawable(R.drawable.bar_empty_unselected);
        } else {
            drawable = context.getDrawable(R.drawable.bar_empty);
        }
        this.a = drawable;
        this.b = context.getResources().getDimensionPixelSize(R.dimen.gap_between_bars_small);
        this.c = context.getResources().getDimensionPixelSize(R.dimen.recycler_bottom_padding) + context.getResources().getDimensionPixelSize(R.dimen.bar_bottom_margin);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.empty_bar_height);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.right = this.e;
        }
        if (recyclerView.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            rect.left = this.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        int bottom = recyclerView.getBottom() - this.c;
        int i = bottom - this.d;
        View childAt = recyclerView.getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
        int right = childAt.getRight() + this.b;
        int i2 = this.e + right;
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(right, i, i2, bottom);
        }
        Drawable drawable2 = this.a;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        View childAt2 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        Intrinsics.checkNotNullExpressionValue(childAt2, VKApiUserFull.RelativeType.CHILD);
        int left = childAt2.getLeft() - this.b;
        int i3 = this.e;
        int i4 = left - i3;
        int i5 = i3 + i4;
        Drawable drawable3 = this.a;
        if (drawable3 != null) {
            drawable3.setBounds(i4, i, i5, bottom);
        }
        Drawable drawable4 = this.a;
        if (drawable4 != null) {
            drawable4.draw(canvas);
        }
    }
}
