package com.avito.android.vas_performance.ui.recycler;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitleItemView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.vas_performance.R;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItemView;
import com.avito.android.vas_performance.ui.items.button.ButtonItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/vas_performance/ui/recycler/AppliedServicesDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "defaultMargin", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class AppliedServicesDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;

    public AppliedServicesDecoration(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.a = resources.getDimensionPixelSize(R.dimen.margin_default);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        int i2;
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        int i3 = this.a;
        rect.left = i3;
        rect.right = i3;
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        int i4 = 0;
        if (childViewHolder instanceof TitleItemView) {
            i = this.b.getDimensionPixelOffset(R.dimen.margin_small);
        } else if (childViewHolder instanceof VasBundleBannerItemView) {
            i = this.b.getDimensionPixelOffset(R.dimen.margin_smallest);
        } else {
            i = childViewHolder instanceof ButtonItemView ? this.b.getDimensionPixelOffset(R.dimen.margin_large) : 0;
        }
        rect.top = i;
        if (recyclerView.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            i2 = this.a;
        } else {
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(view);
            if (childViewHolder2 instanceof TitleItemView) {
                i4 = this.a;
            } else if (childViewHolder2 instanceof VasBundleBannerItemView) {
                i4 = this.b.getDimensionPixelOffset(R.dimen.margin_tiny);
            }
            i2 = i4;
        }
        rect.bottom = i2;
    }
}
