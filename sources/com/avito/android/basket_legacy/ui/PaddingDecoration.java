package com.avito.android.basket_legacy.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.basket.R;
import com.avito.android.basket_legacy.item.header.HeaderItemViewImpl;
import com.avito.android.basket_legacy.item.total.TotalItemViewImpl;
import com.avito.android.component.disclaimer.DisclaimerViewHolderImpl;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/basket_legacy/ui/PaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "c", "I", "bottomExtraPadding", AuthSource.SEND_ABUSE, "sideMargin", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;I)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PaddingDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;
    public final int c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaddingDecoration(Resources resources, int i, int i2, j jVar) {
        this(resources, (i2 & 2) != 0 ? 0 : i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if (childViewHolder instanceof HeaderItemViewImpl) {
            i = this.b.getDimensionPixelOffset(R.dimen.padding_basket_title_top);
        } else if (childViewHolder instanceof TotalItemViewImpl) {
            i = this.b.getDimensionPixelOffset(R.dimen.padding_basket_title_top);
        } else if (childViewHolder instanceof DisclaimerViewHolderImpl) {
            i = this.b.getDimensionPixelOffset(R.dimen.padding_basket_disclaimer_top);
        } else {
            i = this.b.getDimensionPixelOffset(R.dimen.padding_basket_list);
        }
        rect.top = i;
        rect.bottom = recyclerView.getChildAdapterPosition(view) == state.getItemCount() + -1 ? this.c : 0;
        int i2 = this.a;
        rect.left = i2;
        rect.right = i2;
    }

    public PaddingDecoration(@NotNull Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.c = i;
        this.a = resources.getDimensionPixelSize(com.avito.android.ui_components.R.dimen.content_horizontal_padding);
    }
}
