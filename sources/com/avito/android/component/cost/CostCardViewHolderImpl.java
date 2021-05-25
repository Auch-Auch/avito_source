package com.avito.android.component.cost;

import android.view.View;
import com.avito.android.component.cost.CostCardViewHolder;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/cost/CostCardViewHolderImpl;", "Lcom/avito/android/component/cost/CostCardViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/cost/CostCard;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "value", "setValue", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CostCardViewHolderImpl extends BaseViewHolder implements CostCardViewHolder, CostCard {
    public final View s;
    public final /* synthetic */ CostCardImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CostCardViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new CostCardImpl(view);
        this.s = view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CostCardViewHolder.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.cost.CostCard
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.t.setTitle(charSequence);
    }

    @Override // com.avito.android.component.cost.CostCard
    public void setValue(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.t.setValue(charSequence);
    }
}
