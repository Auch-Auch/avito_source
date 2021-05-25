package com.avito.android.cart.summary.konveyor.header.store;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/header/store/StoreHeaderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "bindTitle", "(Ljava/lang/String;)V", "message", "bindMessage", "cart_release"}, k = 1, mv = {1, 4, 2})
public interface StoreHeaderItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull StoreHeaderItemView storeHeaderItemView) {
            ItemView.DefaultImpls.onUnbind(storeHeaderItemView);
        }
    }

    void bindMessage(@Nullable String str);

    void bindTitle(@Nullable String str);
}
