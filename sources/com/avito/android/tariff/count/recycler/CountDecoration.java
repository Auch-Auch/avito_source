package com.avito.android.tariff.count.recycler;

import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/tariff/count/recycler/CountDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)I", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "I", "sidePadding", "c", "bottomViewHeight", "<init>", "(Landroid/content/res/Resources;I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class CountDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Resources b;
    public final int c;

    public CountDecoration(@NotNull Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
        this.c = i;
        this.a = resources.getDimensionPixelSize(R.dimen.container_horizontal_padding);
    }

    public final int a(View view, RecyclerView recyclerView) {
        if (recyclerView.getChildViewHolder(view) instanceof PaidServiceHeaderView) {
            return this.a;
        }
        return view.getResources().getDimensionPixelSize(com.avito.android.tariff.R.dimen.container_horizontal_ripple_padding);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004a, code lost:
        if (r6.getChildAdapterPosition(r5) == (r7.getItemCount() - 1)) goto L_0x004e;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getItemOffsets(@org.jetbrains.annotations.NotNull android.graphics.Rect r4, @org.jetbrains.annotations.NotNull android.view.View r5, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r6, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State r7) {
        /*
            r3 = this;
            java.lang.String r0 = "outRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r7 = r3.a(r5, r6)
            r4.left = r7
            int r7 = r3.a(r5, r6)
            r4.right = r7
            androidx.recyclerview.widget.RecyclerView$ViewHolder r7 = r6.getChildViewHolder(r5)
            boolean r7 = r7 instanceof com.avito.android.tariff.count.item.CountItemView
            r0 = 0
            if (r7 == 0) goto L_0x0032
            android.content.res.Resources r7 = r3.b
            int r1 = com.avito.android.tariff.R.dimen.margin_count_item
            int r7 = r7.getDimensionPixelOffset(r1)
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r4.top = r7
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = r6.getLayoutManager()
            r1 = 1
            if (r7 == 0) goto L_0x004d
            java.lang.String r2 = "parent.layoutManager ?: return false"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            int r2 = r6.getChildAdapterPosition(r5)
            int r7 = r7.getItemCount()
            int r7 = r7 - r1
            if (r2 != r7) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            if (r1 == 0) goto L_0x005d
            int r5 = r3.c
            android.content.res.Resources r6 = r3.b
            int r7 = com.avito.android.tariff.R.dimen.margin_button_top
            int r6 = r6.getDimensionPixelOffset(r7)
            int r0 = r6 + r5
            goto L_0x0077
        L_0x005d:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r5 = r6.getChildViewHolder(r5)
            boolean r5 = r5 instanceof com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView
            if (r5 == 0) goto L_0x0077
            android.content.res.Resources r5 = r3.b
            int r6 = com.avito.android.tariff.R.dimen.margin_large
            int r5 = r5.getDimensionPixelOffset(r6)
            android.content.res.Resources r6 = r3.b
            int r7 = com.avito.android.tariff.R.dimen.margin_count_item
            int r6 = r6.getDimensionPixelOffset(r7)
            int r0 = r5 - r6
        L_0x0077:
            r4.bottom = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.tariff.count.recycler.CountDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }
}
