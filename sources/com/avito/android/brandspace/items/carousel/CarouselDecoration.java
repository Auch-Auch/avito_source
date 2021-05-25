package com.avito.android.brandspace.items.carousel;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "columnOffset", "", AuthSource.BOOKING_ORDER, "Z", "hasLastItemExtraSpace", "<init>", "(IZ)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final boolean b;

    public CarouselDecoration(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        if (r12 == (r0.getItemCount() - 1)) goto L_0x0027;
     */
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
            super.getItemOffsets(r9, r10, r11, r12)
            int r12 = r11.getChildAdapterPosition(r10)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r11.getAdapter()
            r1 = 0
            if (r0 == 0) goto L_0x0026
            int r0 = r0.getItemCount()
            r2 = 1
            int r0 = r0 - r2
            if (r12 != r0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            int r12 = r11.getMeasuredWidth()
            int r0 = r11.getPaddingLeft()
            int r12 = r12 - r0
            int r11 = r11.getPaddingRight()
            int r12 = r12 - r11
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            int r11 = r11.width
            if (r2 == 0) goto L_0x005c
            if (r11 < 0) goto L_0x005e
            boolean r11 = r8.b
            if (r11 == 0) goto L_0x005e
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            int r11 = r11.width
            int r12 = r12 - r11
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            int r10 = r10.width
            int r11 = r8.a
            int r10 = r10 + r11
            if (r12 <= r10) goto L_0x005a
            int r11 = r12 / r10
            int r11 = r11 * r10
            int r12 = r12 - r11
        L_0x005a:
            r1 = r12
            goto L_0x005e
        L_0x005c:
            int r1 = r8.a
        L_0x005e:
            r9.right = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.carousel.CarouselDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }
}
