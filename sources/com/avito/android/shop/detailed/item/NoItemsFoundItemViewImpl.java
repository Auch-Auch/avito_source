package com.avito.android.shop.detailed.item;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/shop/detailed/item/NoItemsFoundItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/shop/detailed/item/NoItemsFoundItemView;", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "setHeightPx", "(I)V", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class NoItemsFoundItemViewImpl extends BaseViewHolder implements NoItemsFoundItemView {
    public final View s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoItemsFoundItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = view;
    }

    @Override // com.avito.android.shop.detailed.item.NoItemsFoundItemView
    public void setHeightPx(int i) {
        this.s.getLayoutParams().height = i;
    }
}
