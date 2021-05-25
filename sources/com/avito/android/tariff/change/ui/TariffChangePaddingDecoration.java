package com.avito.android.tariff.change.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.tariff.R;
import com.avito.android.tariff.change.item.benefit.BenefitItemView;
import com.avito.android.tariff.change.item.button.ButtonItemView;
import com.avito.android.tariff.change.item.title.TitleItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/tariff/change/ui/TariffChangePaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffChangePaddingDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        int i2 = 0;
        if (childViewHolder instanceof BenefitItemView) {
            i = view.getResources().getDimensionPixelOffset(R.dimen.margin_radio_items);
        } else if (childViewHolder instanceof TitleItemView) {
            i = view.getResources().getDimensionPixelOffset(R.dimen.margin_large);
        } else {
            i = childViewHolder instanceof ButtonItemView ? view.getResources().getDimensionPixelOffset(R.dimen.margin_package_title) : 0;
        }
        rect.top = i;
        boolean z = true;
        if (recyclerView.getChildAdapterPosition(view) != state.getItemCount() - 1) {
            z = false;
        }
        if (z) {
            i2 = view.getResources().getDimensionPixelOffset(R.dimen.margin_default);
        }
        rect.bottom = i2;
        Resources resources = view.getResources();
        int i3 = com.avito.android.ui_components.R.dimen.container_horizontal_padding;
        rect.left = resources.getDimensionPixelOffset(i3);
        rect.right = view.getResources().getDimensionPixelOffset(i3);
    }
}
