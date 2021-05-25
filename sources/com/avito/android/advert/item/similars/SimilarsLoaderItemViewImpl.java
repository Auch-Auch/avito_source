package com.avito.android.advert.item.similars;

import android.view.View;
import com.avito.android.advert.item.similars.SimilarsLoaderItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/similars/SimilarsLoaderItemViewImpl;", "Lcom/avito/android/advert/item/similars/SimilarsLoaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarsLoaderItemViewImpl extends BaseViewHolder implements SimilarsLoaderItemView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimilarsLoaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SimilarsLoaderItemView.DefaultImpls.onUnbind(this);
    }
}
