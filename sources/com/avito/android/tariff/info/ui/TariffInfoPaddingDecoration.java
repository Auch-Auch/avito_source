package com.avito.android.tariff.info.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItemView;
import com.avito.android.tariff.info.item.info.InfoItemView;
import com.avito.android.tariff.info.item.package_info.PackageInfoItemView;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\r*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/tariff/info/ui/TariffInfoPaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)I", "dimensionId", AuthSource.SEND_ABUSE, "(Landroid/view/View;I)I", "Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "viewTypeProvider", "I", "bottomViewHeight", "<init>", "(Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffInfoPaddingDecoration extends RecyclerView.ItemDecoration {
    public final TariffInfoViewTypeProvider a;
    public final int b;

    public TariffInfoPaddingDecoration(@NotNull TariffInfoViewTypeProvider tariffInfoViewTypeProvider, int i) {
        Intrinsics.checkNotNullParameter(tariffInfoViewTypeProvider, "viewTypeProvider");
        this.a = tariffInfoViewTypeProvider;
        this.b = i;
    }

    public final int a(View view, int i) {
        return view.getResources().getDimensionPixelOffset(i);
    }

    public final int b(RecyclerView recyclerView, View view) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return -1;
        }
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter ?: return RecyclerView.INVALID_TYPE");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == adapter.getItemCount() - 1) {
            return -1;
        }
        return adapter.getItemViewType(childAdapterPosition + 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        int i2 = 0;
        if (childViewHolder instanceof PackageTitleItemView) {
            i = a(view, R.dimen.margin_package_title);
        } else {
            i = childViewHolder instanceof DisclaimerItemView ? a(view, R.dimen.margin_default) : 0;
        }
        rect.top = i;
        RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(view);
        int b2 = b(recyclerView, view);
        if (recyclerView.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            i2 = a(view, R.dimen.margin_large) + this.b;
        } else if (childViewHolder2 instanceof PaidServiceHeaderView) {
            i2 = a(view, R.dimen.margin_large);
        } else if (childViewHolder2 instanceof PackageTitleItemView) {
            i2 = a(view, R.dimen.margin_default);
        } else if ((childViewHolder2 instanceof PackageInfoItemView) && b2 != this.a.getPackageViewType()) {
            i2 = a(view, R.dimen.margin_packages);
        } else if ((childViewHolder2 instanceof InfoItemView) && b(recyclerView, view) == this.a.getInfoViewType()) {
            i2 = a(view, R.dimen.margin_info_item);
        }
        rect.bottom = i2;
        Resources resources = view.getResources();
        int i3 = com.avito.android.ui_components.R.dimen.container_horizontal_padding;
        rect.left = resources.getDimensionPixelOffset(i3);
        rect.right = view.getResources().getDimensionPixelOffset(i3);
    }
}
