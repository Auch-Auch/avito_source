package com.avito.android.safedeal.delivery_type.items.subtitle;

import android.view.View;
import android.widget.TextView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleView;", "", "title", "", "setSubTitle", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "subtitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SubTitleViewImpl extends BaseViewHolder implements SubTitleView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubTitleViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view;
    }

    @Override // com.avito.android.safedeal.delivery_type.items.subtitle.SubTitleView
    public void setSubTitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
    }
}
