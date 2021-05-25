package com.avito.android.cart_fab;

import com.avito.android.lib.design.notification_badge.NotificationBadge;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/cart_fab/CartFabQuantityVisibilityHandler;", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "Lcom/avito/android/cart_fab/CartFloatingActionButton;", "view", "", "size", "", "onSizeChanged", "(Lcom/avito/android/cart_fab/CartFloatingActionButton;Ljava/lang/Integer;)V", "<init>", "()V", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFabQuantityVisibilityHandler implements CartQuantityChangesHandler {
    @Override // com.avito.android.cart_fab.CartQuantityChangesHandler
    public void onSizeChanged(@NotNull CartFloatingActionButton cartFloatingActionButton, @Nullable Integer num) {
        String str;
        Intrinsics.checkNotNullParameter(cartFloatingActionButton, "view");
        boolean z = true;
        Views.setVisible(cartFloatingActionButton.getBadge(), num != null);
        NotificationBadge badge = cartFloatingActionButton.getBadge();
        if (num == null || (str = String.valueOf(num.intValue())) == null) {
            str = "0";
        }
        badge.setText(str);
        if (num != null && num.intValue() <= 0) {
            z = false;
        }
        Views.setVisible(cartFloatingActionButton, z);
    }
}
