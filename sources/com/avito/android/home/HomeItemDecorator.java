package com.avito.android.home;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.home.tabs_item.SectionTabsItemView;
import com.avito.android.home.tabs_item.skeleton.SkeletonSectionTabsView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.stories.adapter.StoriesItemView;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/home/HomeItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "verticalPadding", AuthSource.BOOKING_ORDER, "horizontalPadding", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeItemDecorator extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public HomeItemDecorator(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources.getDimensionPixelSize(R.dimen.serp_vertical_padding);
        this.b = resources.getDimensionPixelSize(R.dimen.serp_horizontal_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if ((childViewHolder instanceof SectionTabsItemView) || (childViewHolder instanceof SkeletonSectionTabsView)) {
            rect.top = this.a;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            boolean z = false;
            if (childAdapterPosition != -1) {
                int i = childAdapterPosition + 1;
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    Intrinsics.checkNotNullExpressionValue(adapter, "parent.adapter ?: return false");
                    if (adapter.getItemCount() > i && adapter.getItemViewType(childAdapterPosition) != adapter.getItemViewType(i)) {
                        z = true;
                    }
                }
            }
            if (z) {
                rect.bottom = this.a;
            }
            int i2 = this.b;
            rect.left = -i2;
            rect.right = -i2;
        }
        if (childViewHolder instanceof StoriesItemView) {
            int i3 = this.b;
            rect.left = -i3;
            rect.right = -i3;
            rect.top = this.a;
        }
    }
}
