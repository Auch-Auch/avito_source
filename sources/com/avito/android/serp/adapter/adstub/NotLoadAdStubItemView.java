package com.avito.android.serp.adapter.adstub;

import android.view.View;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/serp/adapter/adstub/NotLoadAdStubItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class NotLoadAdStubItemView extends BaseSerpViewHolder implements ItemView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotLoadAdStubItemView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }
}
