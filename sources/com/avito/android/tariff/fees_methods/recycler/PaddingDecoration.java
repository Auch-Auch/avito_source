package com.avito.android.tariff.fees_methods.recycler;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/tariff/fees_methods/recycler/PaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "sidePadding", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProvider;", "c", "Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProvider;", "viewTypeProvider", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProvider;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PaddingDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;
    public final FeeMethodsViewTypeProvider c;

    @Inject
    public PaddingDecoration(@NotNull Resources resources, @NotNull FeeMethodsViewTypeProvider feeMethodsViewTypeProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(feeMethodsViewTypeProvider, "viewTypeProvider");
        this.b = resources;
        this.c = feeMethodsViewTypeProvider;
        this.a = resources.getDimensionPixelSize(R.dimen.container_horizontal_padding);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getItemOffsets(@org.jetbrains.annotations.NotNull android.graphics.Rect r9, @org.jetbrains.annotations.NotNull android.view.View r10, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r11, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State r12) {
        /*
            r8 = this;
            java.lang.String r1 = "outRect"
            java.lang.String r3 = "view"
            java.lang.String r5 = "parent"
            java.lang.String r7 = "state"
            r0 = r9
            r2 = r10
            r4 = r11
            r6 = r12
            a2.b.a.a.a.F0(r0, r1, r2, r3, r4, r5, r6, r7)
            int r0 = r8.a
            r9.left = r0
            r9.right = r0
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r11.getChildViewHolder(r10)
            boolean r1 = r0 instanceof com.avito.android.tariff.fees_methods.items.bar.BarItemView
            java.lang.String r2 = "adapter ?: return RecyclerView.INVALID_TYPE"
            r3 = 0
            r4 = -1
            if (r1 == 0) goto L_0x002a
            android.content.res.Resources r0 = r8.b
            int r1 = com.avito.android.tariff.R.dimen.margin_default
            int r0 = r0.getDimensionPixelOffset(r1)
            goto L_0x0069
        L_0x002a:
            boolean r1 = r0 instanceof com.avito.android.publish_limits_info.item.LimitsInfoItemView
            if (r1 == 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            boolean r1 = r0 instanceof com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItemView
            if (r1 == 0) goto L_0x003c
        L_0x0033:
            android.content.res.Resources r0 = r8.b
            int r1 = com.avito.android.tariff.R.dimen.margin_header_description
            int r0 = r0.getDimensionPixelOffset(r1)
            goto L_0x0069
        L_0x003c:
            boolean r0 = r0 instanceof com.avito.android.tariff.fees_methods.items.FeeMethodItemView
            if (r0 == 0) goto L_0x0068
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r11.getAdapter()
            if (r0 == 0) goto L_0x0055
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r1 = r11.getChildAdapterPosition(r10)
            if (r1 == 0) goto L_0x0055
            int r1 = r1 + r4
            int r0 = r0.getItemViewType(r1)
            goto L_0x0056
        L_0x0055:
            r0 = -1
        L_0x0056:
            com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider r1 = r8.c
            int r1 = r1.getFeeMethodViewType()
            if (r0 != r1) goto L_0x005f
            goto L_0x0068
        L_0x005f:
            android.content.res.Resources r0 = r8.b
            int r1 = com.avito.android.tariff.R.dimen.margin_large
            int r0 = r0.getDimensionPixelOffset(r1)
            goto L_0x0069
        L_0x0068:
            r0 = 0
        L_0x0069:
            r9.top = r0
            int r0 = r11.getChildAdapterPosition(r10)
            int r12 = r12.getItemCount()
            int r12 = r12 + r4
            if (r0 != r12) goto L_0x007f
            android.content.res.Resources r10 = r8.b
            int r11 = com.avito.android.tariff.R.dimen.margin_large
            int r3 = r10.getDimensionPixelOffset(r11)
            goto L_0x00bb
        L_0x007f:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r12 = r11.getChildViewHolder(r10)
            boolean r12 = r12 instanceof com.avito.android.tariff.fees_methods.items.FeeMethodItemView
            if (r12 == 0) goto L_0x00bb
            androidx.recyclerview.widget.RecyclerView$Adapter r12 = r11.getAdapter()
            if (r12 == 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            int r10 = r11.getChildAdapterPosition(r10)
            int r11 = r12.getItemCount()
            int r11 = r11 + r4
            if (r10 != r11) goto L_0x009c
            goto L_0x00a2
        L_0x009c:
            int r10 = r10 + 1
            int r4 = r12.getItemViewType(r10)
        L_0x00a2:
            com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider r10 = r8.c
            int r10 = r10.getHighDemandViewType()
            if (r4 != r10) goto L_0x00b3
            android.content.res.Resources r10 = r8.b
            int r11 = com.avito.android.tariff.R.dimen.margin_packages
            int r3 = r10.getDimensionPixelOffset(r11)
            goto L_0x00bb
        L_0x00b3:
            android.content.res.Resources r10 = r8.b
            int r11 = com.avito.android.tariff.R.dimen.margin_default
            int r3 = r10.getDimensionPixelOffset(r11)
        L_0x00bb:
            r9.bottom = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.tariff.fees_methods.recycler.PaddingDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }
}
