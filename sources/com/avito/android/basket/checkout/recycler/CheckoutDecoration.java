package com.avito.android.basket.checkout.recycler;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.basket.checkout.item.price.PriceItemView;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemView;
import com.avito.android.component.disclaimer.DisclaimerViewHolder;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/basket/checkout/recycler/CheckoutDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/content/res/Resources;", "c", "Landroid/content/res/Resources;", "resources", "", AuthSource.SEND_ABUSE, "I", "sidePadding", AuthSource.BOOKING_ORDER, "rippleSidePadding", "<init>", "(Landroid/content/res/Resources;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final Resources c;

    public CheckoutDecoration(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.c = resources;
        this.a = resources.getDimensionPixelSize(R.dimen.container_horizontal_padding);
        this.b = resources.getDimensionPixelSize(com.avito.android.tariff.R.dimen.container_horizontal_ripple_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (recyclerView.getChildViewHolder(view) instanceof ProlongationItemView) {
            i = this.b;
        } else {
            i = this.a;
        }
        rect.left = i;
        if (recyclerView.getChildViewHolder(view) instanceof ProlongationItemView) {
            i2 = this.b;
        } else {
            i2 = this.a;
        }
        rect.right = i2;
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        int i4 = 0;
        if (childViewHolder instanceof DisclaimerViewHolder) {
            i3 = this.c.getDimensionPixelOffset(com.avito.android.basket.R.dimen.padding_checkout_disclaimer);
        } else {
            i3 = childViewHolder instanceof PriceItemView ? this.c.getDimensionPixelOffset(com.avito.android.basket.R.dimen.padding_checkout_price) : 0;
        }
        rect.top = i3;
        if (recyclerView.getChildViewHolder(view) instanceof PaidServiceHeaderView) {
            i4 = this.c.getDimensionPixelOffset(com.avito.android.basket.R.dimen.padding_checkout_header);
        }
        rect.bottom = i4;
    }
}
