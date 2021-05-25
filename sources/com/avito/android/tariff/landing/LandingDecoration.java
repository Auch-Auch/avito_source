package com.avito.android.tariff.landing;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.landing.item.text.TextItemView;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/tariff/landing/LandingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "c", "I", "bottomViewHeight", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", AuthSource.SEND_ABUSE, "sidePadding", "<init>", "(Landroid/content/res/Resources;I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class LandingDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;
    public final int c;

    public LandingDecoration(@NotNull Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.c = i;
        this.a = resources.getDimensionPixelSize(R.dimen.container_horizontal_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        int i = this.a;
        rect.left = i;
        rect.right = i;
        int i2 = 0;
        rect.top = recyclerView.getChildViewHolder(view) instanceof TextItemView ? this.b.getDimensionPixelOffset(com.avito.android.tariff.R.dimen.margin_large) : 0;
        if (recyclerView.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            i2 = this.b.getDimensionPixelOffset(com.avito.android.tariff.R.dimen.margin_large) + this.c;
        } else if (recyclerView.getChildViewHolder(view) instanceof PaidServiceHeaderView) {
            i2 = this.b.getDimensionPixelOffset(com.avito.android.tariff.R.dimen.margin_landing_header);
        }
        rect.bottom = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LandingDecoration(Resources resources, int i, int i2, j jVar) {
        this(resources, (i2 & 2) != 0 ? 0 : i);
    }
}
