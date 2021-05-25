package com.avito.android.cart.summary.konveyor.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.cart.summary.konveyor.header.HeaderItem;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import com.avito.konveyor.ItemBinder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/decoration/HeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lcom/avito/konveyor/ItemBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Lcom/avito/konveyor/ItemBinder;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemDecoration extends RecyclerView.ItemDecoration {
    public final ItemBinder a;

    @Inject
    public HeaderItemDecoration(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.a = itemBinder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        HeaderItem headerItem = new HeaderItem("", "");
        StoreHeaderItem storeHeaderItem = new StoreHeaderItem("", "", null, 4, null);
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        Intrinsics.checkNotNullExpressionValue(childViewHolder, "parent.getChildViewHolder(view)");
        int itemViewType = childViewHolder.getItemViewType();
        boolean z = true;
        int i = 0;
        boolean z2 = itemViewType == this.a.getItemViewType(headerItem);
        boolean z3 = itemViewType == this.a.getItemViewType(storeHeaderItem);
        if (z2 || z3) {
            if (recyclerView.getChildAdapterPosition(view) != 0) {
                z = false;
            }
            if (!z) {
                i = ViewSizeKt.getDp(24);
            }
            rect.top = i;
        }
    }
}
