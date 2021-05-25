package com.avito.android.tariff.edit_info.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemView;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemView;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\r*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/edit_info/ui/EditInfoPaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)I", "dimensionId", AuthSource.SEND_ABUSE, "(Landroid/view/View;I)I", "Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;", "Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;", "viewTypeProvider", "<init>", "(Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoPaddingDecoration extends RecyclerView.ItemDecoration {
    public final EditInfoViewTypeProvider a;

    @Inject
    public EditInfoPaddingDecoration(@NotNull EditInfoViewTypeProvider editInfoViewTypeProvider) {
        Intrinsics.checkNotNullParameter(editInfoViewTypeProvider, "viewTypeProvider");
        this.a = editInfoViewTypeProvider;
    }

    public final int a(View view, int i) {
        return view.getResources().getDimensionPixelOffset(i);
    }

    public final int b(View view, RecyclerView recyclerView) {
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if (childViewHolder instanceof TabsItemView) {
            return view.getResources().getDimensionPixelSize(R.dimen.container_horizontal_ripple_padding);
        }
        if (childViewHolder instanceof TariffProlongationItemView) {
            return view.getResources().getDimensionPixelSize(R.dimen.container_horizontal_ripple_padding);
        }
        return view.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.container_horizontal_padding);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0038  */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getItemOffsets(@org.jetbrains.annotations.NotNull android.graphics.Rect r6, @org.jetbrains.annotations.NotNull android.view.View r7, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r8, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State r9) {
        /*
            r5 = this;
            java.lang.String r0 = "outRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r8.getAdapter()
            r1 = -1
            if (r0 == 0) goto L_0x002e
            java.lang.String r2 = "adapter ?: return RecyclerView.INVALID_TYPE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r8.getChildAdapterPosition(r7)
            if (r2 == r1) goto L_0x002e
            if (r2 == 0) goto L_0x002e
            int r2 = r2 + r1
            int r0 = r0.getItemViewType(r2)
            goto L_0x002f
        L_0x002e:
            r0 = -1
        L_0x002f:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r8.getChildViewHolder(r7)
            boolean r3 = r2 instanceof com.avito.android.tariff.edit_info.item.tabs.TabsItemView
            r4 = 0
            if (r3 == 0) goto L_0x003f
            int r0 = com.avito.android.tariff.R.dimen.margin_default
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x003f:
            boolean r3 = r2 instanceof com.avito.android.tariff.info.item.package_title.PackageTitleItemView
            if (r3 == 0) goto L_0x004a
            int r0 = com.avito.android.tariff.R.dimen.margin_package_title
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x004a:
            boolean r3 = r2 instanceof com.avito.android.tariff.edit_info.item.button.ButtonItemView
            if (r3 == 0) goto L_0x0055
            int r0 = com.avito.android.tariff.R.dimen.margin_default
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x0055:
            boolean r3 = r2 instanceof com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemView
            if (r3 == 0) goto L_0x0060
            int r0 = com.avito.android.tariff.R.dimen.margin_default
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x0060:
            boolean r3 = r2 instanceof com.avito.android.tariff.edit_info.item.manager_call.ManagerCallItemView
            if (r3 == 0) goto L_0x006b
            int r0 = com.avito.android.tariff.R.dimen.margin_default
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x006b:
            boolean r3 = r2 instanceof com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
            if (r3 == 0) goto L_0x0085
            com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider r2 = r5.a
            int r2 = r2.getEditPackageViewType()
            if (r0 != r2) goto L_0x007e
            int r0 = com.avito.android.tariff.R.dimen.margin_default
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x007e:
            int r0 = com.avito.android.tariff.R.dimen.margin_large
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x0085:
            boolean r2 = r2 instanceof com.avito.android.tariff.info.item.info.InfoItemView
            if (r2 == 0) goto L_0x009f
            com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider r2 = r5.a
            int r2 = r2.getInfoViewType()
            if (r0 != r2) goto L_0x0098
            int r0 = com.avito.android.tariff.R.dimen.margin_packages
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x0098:
            int r0 = com.avito.android.tariff.R.dimen.margin_large
            int r0 = r5.a(r7, r0)
            goto L_0x00a0
        L_0x009f:
            r0 = 0
        L_0x00a0:
            r6.top = r0
            int r0 = r8.getChildAdapterPosition(r7)
            int r9 = r9.getItemCount()
            int r9 = r9 + r1
            if (r0 != r9) goto L_0x00b3
            int r9 = com.avito.android.tariff.R.dimen.margin_large
            int r4 = r5.a(r7, r9)
        L_0x00b3:
            r6.bottom = r4
            int r9 = r5.b(r7, r8)
            r6.left = r9
            int r7 = r5.b(r7, r8)
            r6.right = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.tariff.edit_info.ui.EditInfoPaddingDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }
}
