package com.avito.android.tariff.region.recycler;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.region.item.RegionItemView;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/avito/android/tariff/region/recycler/RegionDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)I", "I", "sidePadding", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "c", "bottomViewHeight", "<init>", "(Landroid/content/res/Resources;I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class RegionDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;
    public final int c;

    public RegionDecoration(@NotNull Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.c = i;
        this.a = resources.getDimensionPixelSize(R.dimen.container_horizontal_padding);
    }

    public final int a(View view, RecyclerView recyclerView) {
        if (recyclerView.getChildViewHolder(view) instanceof PaidServiceHeaderView) {
            return this.a;
        }
        return view.getResources().getDimensionPixelSize(com.avito.android.tariff.R.dimen.container_horizontal_ripple_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        rect.left = a(view, recyclerView);
        rect.right = a(view, recyclerView);
        recyclerView.getChildViewHolder(view);
        int i = 0;
        rect.top = 0;
        if (recyclerView.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            i = this.c;
        } else if (recyclerView.getChildViewHolder(view) instanceof PaidServiceHeaderView) {
            i = this.b.getDimensionPixelOffset(com.avito.android.tariff.R.dimen.margin_large);
        } else if (recyclerView.getChildViewHolder(view) instanceof RegionItemView) {
            i = this.b.getDimensionPixelOffset(com.avito.android.tariff.R.dimen.margin_radio_items);
        }
        rect.bottom = i;
    }
}
