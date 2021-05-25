package com.avito.android.vas_performance.ui.recycler;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/vas_performance/ui/recycler/PaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "", AuthSource.SEND_ABUSE, "I", "sidePadding", "<init>", "(Landroid/content/res/Resources;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class PaddingDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;

    public PaddingDecoration(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.a = resources.getDimensionPixelSize(R.dimen.content_horizontal_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        int i2 = this.a;
        rect.left = i2;
        rect.right = i2;
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if (childViewHolder instanceof PaidServiceHeaderView) {
            i = this.b.getDimensionPixelOffset(com.avito.android.vas_performance.R.dimen.margin_large);
        } else if (childViewHolder instanceof TabsItemView) {
            i = this.b.getDimensionPixelOffset(com.avito.android.vas_performance.R.dimen.margin_large);
        } else {
            i = this.b.getDimensionPixelOffset(com.avito.android.vas_performance.R.dimen.margin_small);
        }
        rect.bottom = i;
    }
}
