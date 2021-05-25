package com.avito.android.spare_parts.bottom_sheet.item;

import android.text.Spannable;
import android.view.View;
import android.widget.TextView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItemView;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "hideIcon", "()V", "", "iconResId", "setRightIconRes", "(I)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsTextItemViewImpl extends BaseViewHolder implements SparePartsTextItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SparePartsTextItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view;
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemView
    public void hideIcon() {
        TextViews.setCompoundDrawables$default(this.s, 0, 0, 0, 0, 11, (Object) null);
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemView
    public void setRightIconRes(int i) {
        TextViews.setCompoundDrawables$default(this.s, 0, 0, i, 0, 11, (Object) null);
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.s.setOnClickListener(null);
        this.s.setText(charSequence);
        if (charSequence instanceof Spannable) {
            SparePartsTextItemViewKt.dispatchClicksToClickableSpan$default(this.s, (Spannable) charSequence, 0, 2, null);
        }
    }
}
