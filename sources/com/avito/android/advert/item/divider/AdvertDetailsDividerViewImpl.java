package com.avito.android.advert.item.divider;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.advert_details.R;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/divider/AdvertDetailsDividerViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/divider/AdvertDetailsDividerView;", "", "top", "bottom", "horizontalMargins", "", "setMargins", "(IILjava/lang/Integer;)V", "Landroid/view/View;", "s", "Landroid/view/View;", "divider", "t", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDividerViewImpl extends BaseViewHolder implements AdvertDetailsDividerView {
    public final View s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsDividerViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        View findViewById = view.findViewById(R.id.advert_details_divider_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.a…ert_details_divider_view)");
        this.s = findViewById;
    }

    @Override // com.avito.android.advert.item.divider.AdvertDetailsDividerView
    public void setMargins(int i, int i2, @Nullable Integer num) {
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = Views.dpToPx(this.t, i);
            layoutParams2.bottomMargin = Views.dpToPx(this.t, i2);
            if (num != null) {
                int dp = ViewSizeKt.getDp(num.intValue());
                layoutParams2.leftMargin = dp;
                layoutParams2.rightMargin = dp;
            }
        }
        this.s.setLayoutParams(layoutParams);
    }
}
