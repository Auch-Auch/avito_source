package com.avito.android.vas_discount.ui.items;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.user_advert.UserAdvertItemView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.vas_discount.R;
import com.avito.android.vas_discount.ui.items.button.ButtonItemView;
import com.avito.android.vas_discount.ui.items.description.DescriptionItemView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\r*\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/vas_discount/ui/items/PaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$State;)Z", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "", "I", "defaultPadding", "<init>", "(Landroid/content/res/Resources;)V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class PaddingDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;

    public PaddingDecoration(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.a = resources.getDimensionPixelSize(R.dimen.item_list_padding);
    }

    public final boolean a(View view, RecyclerView.State state) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        return ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() == state.getItemCount() - 1;
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
        int i4 = 0;
        if (recyclerView.getChildViewHolder(view) instanceof UserAdvertItemView) {
            i = 0;
        } else {
            i = this.a;
        }
        rect.left = i;
        if (recyclerView.getChildViewHolder(view) instanceof UserAdvertItemView) {
            i2 = 0;
        } else {
            i2 = this.a;
        }
        rect.right = i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        if (((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() == 0) {
            i4 = this.a;
        } else if (a(view, state) && (recyclerView.getChildViewHolder(view) instanceof ButtonItemView)) {
            i4 = this.b.getDimensionPixelOffset(R.dimen.button_extra_padding);
        }
        rect.top = i4;
        if (a(view, state)) {
            i3 = this.a;
        } else if (recyclerView.getChildViewHolder(view) instanceof UserAdvertItemView) {
            i3 = this.b.getDimensionPixelOffset(R.dimen.adverts_list_padding);
        } else if (recyclerView.getChildViewHolder(view) instanceof DescriptionItemView) {
            i3 = this.b.getDimensionPixelOffset(R.dimen.description_padding);
        } else {
            i3 = this.a;
        }
        rect.bottom = i3;
    }
}
