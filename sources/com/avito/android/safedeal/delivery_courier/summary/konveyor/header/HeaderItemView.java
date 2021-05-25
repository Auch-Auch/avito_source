package com.avito.android.safedeal.delivery_courier.summary.konveyor.header;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/header/HeaderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "", ProductAction.ACTION_ADD, "addTopMargin", "(Z)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface HeaderItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull HeaderItemView headerItemView) {
            ItemView.DefaultImpls.onUnbind(headerItemView);
        }
    }

    void addTopMargin(boolean z);

    void setText(@NotNull CharSequence charSequence);
}
