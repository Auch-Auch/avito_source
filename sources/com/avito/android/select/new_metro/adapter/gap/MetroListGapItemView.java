package com.avito.android.select.new_metro.adapter.gap;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/gap/MetroListGapItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "gap", "", "setGapDimen", "(I)V", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "s", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroListGapItemView extends BaseViewHolder implements ItemView {
    public final Resources s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MetroListGapItemView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        this.s = a.u1(view, "view.context");
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }

    public final void setGapDimen(int i) {
        this.t.setMinimumHeight(this.s.getDimensionPixelSize(i));
    }
}
