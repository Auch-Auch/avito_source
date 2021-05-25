package com.avito.android.theme_settings.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.settings.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/theme_settings/ui/ThemeSettingsPaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "paddingHorizontal", "c", "spacingVertical", AuthSource.BOOKING_ORDER, "spacingHorizontal", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeSettingsPaddingDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public int b;
    public int c;

    public ThemeSettingsPaddingDecoration(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context.getResources().getDimensionPixelSize(R.dimen.list_padding);
        this.b = context.getResources().getDimensionPixelSize(R.dimen.list_spacing_horizontal);
        this.c = context.getResources().getDimensionPixelSize(R.dimen.list_spacing_vertical);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
        if (!(layoutManager2 instanceof GridLayoutManager)) {
            layoutManager2 = null;
        }
        GridLayoutManager gridLayoutManager2 = (GridLayoutManager) layoutManager2;
        gridLayoutManager.getSpanSizeLookup().getSpanGroupIndex(state.getItemCount() - 1, gridLayoutManager2 != null ? gridLayoutManager2.getSpanCount() : 1);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
        int i = this.b / 2;
        int i2 = this.c / 2;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        if (((GridLayoutManager.LayoutParams) layoutParams2).getSpanSize() != 2) {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            rect.left = ((GridLayoutManager.LayoutParams) layoutParams3).getSpanIndex() % 2 == 0 ? this.a : i;
            ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
            Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            if (((GridLayoutManager.LayoutParams) layoutParams4).getSpanIndex() % 2 == 1) {
                i = this.a;
            }
            rect.right = i;
            rect.top = i2;
            rect.bottom = i2;
        }
    }
}
