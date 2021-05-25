package com.avito.android.bundles.vas_union.item;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemView;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemView;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemView;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/PaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)I", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class PaddingDecoration extends RecyclerView.ItemDecoration {
    public final Resources a;

    public PaddingDecoration(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    public final int a(View view, RecyclerView recyclerView) {
        if (recyclerView.getChildViewHolder(view) instanceof TabsItemView) {
            return 0;
        }
        return this.a.getDimensionPixelSize(R.dimen.content_horizontal_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        rect.top = recyclerView.getChildViewHolder(view) instanceof BundleSkipButtonItemView ? this.a.getDimensionPixelSize(com.avito.android.bundles.R.dimen.vas_bundle_skip_button_item_top_margin) : 0;
        rect.left = a(view, recyclerView);
        rect.right = a(view, recyclerView);
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if (childViewHolder instanceof PaidServiceHeaderView) {
            i = this.a.getDimensionPixelOffset(com.avito.android.bundles.R.dimen.margin_large);
        } else if (childViewHolder instanceof TabsItemView) {
            i = this.a.getDimensionPixelOffset(R.dimen.standard_padding);
        } else if (childViewHolder instanceof VasBundleItemView) {
            i = this.a.getDimensionPixelSize(com.avito.android.bundles.R.dimen.margin_large);
        } else if (childViewHolder instanceof BundleSkipButtonItemView) {
            i = this.a.getDimensionPixelSize(com.avito.android.bundles.R.dimen.margin_large);
        } else if (childViewHolder instanceof PerformanceTabsItemView) {
            i = this.a.getDimensionPixelSize(R.dimen.standard_padding);
        } else {
            i = this.a.getDimensionPixelOffset(com.avito.android.bundles.R.dimen.margin_small);
        }
        rect.bottom = i;
    }
}
