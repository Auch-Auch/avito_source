package com.avito.android.advert_core.gap;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_core/gap/AdvertDetailsGapViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert_core/gap/AdvertDetailsGapView;", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "setHeight", "(I)V", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "s", "I", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGapViewImpl extends BaseViewHolder implements AdvertDetailsGapView {
    public int s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsGapViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
    }

    @Override // com.avito.android.advert_core.gap.AdvertDetailsGapView
    public void setHeight(int i) {
        if (this.s != i) {
            this.s = i;
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            layoutParams.height = Views.dpToPx(this.t, i);
            this.t.setLayoutParams(layoutParams);
        }
    }
}
