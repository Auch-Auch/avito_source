package com.avito.android.shop.detailed.item;

import android.view.View;
import android.widget.TextView;
import com.avito.android.shop.detailed.item.AdvertsCountCaptionItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/avito/android/shop/detailed/item/AdvertsCountCaptionItemViewImpl;", "Lcom/avito/android/shop/detailed/item/AdvertsCountCaptionItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertsCountCaptionItemViewImpl extends BaseViewHolder implements AdvertsCountCaptionItemView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertsCountCaptionItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdvertsCountCaptionItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.shop.detailed.item.AdvertsCountCaptionItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        View view = this.itemView;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText(str);
    }
}
