package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemView;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "horizontalPadding", AuthSource.BOOKING_ORDER, "topOffset", "c", "bottomOfset", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterItemDecorator extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public VerticalFilterItemDecorator(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources.getDimensionPixelSize(R.dimen.serp_horizontal_padding);
        int i = com.avito.android.serp_core.R.dimen.vertical_search_filter_column_offset;
        this.b = resources.getDimensionPixelSize(i);
        this.c = resources.getDimensionPixelSize(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildViewHolder(view) instanceof VerticalFilterItemView) {
            int i = this.a;
            rect.left = -i;
            rect.right = -i;
            rect.top = this.b;
            rect.bottom = this.c;
        }
    }
}
