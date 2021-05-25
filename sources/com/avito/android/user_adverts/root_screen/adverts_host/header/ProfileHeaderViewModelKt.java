package com.avito.android.user_adverts.root_screen.adverts_host.header;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.OrdersInfo;
import com.avito.android.user_adverts.ProfileConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001c\u0010\u0005\u001a\u00020\u00008\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u000b\u001a\u00020\u00068\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/user_adverts/ProfileConfig;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/ProfileConfig;", "getDEFAULT_BOOT_CONFIG", "()Lcom/avito/android/user_adverts/ProfileConfig;", "DEFAULT_BOOT_CONFIG", "Lcom/avito/android/remote/model/OrdersInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/OrdersInfo;", "getDEFAULT_ORDERS_INFO", "()Lcom/avito/android/remote/model/OrdersInfo;", "DEFAULT_ORDERS_INFO", "user-adverts_release"}, k = 2, mv = {1, 4, 2})
public final class ProfileHeaderViewModelKt {
    @NotNull
    public static final OrdersInfo a = new OrdersInfo("Заказы", null, null, null, 14, null);
    @NotNull
    public static final ProfileConfig b = new ProfileConfig(false, null);

    @NotNull
    public static final ProfileConfig getDEFAULT_BOOT_CONFIG() {
        return b;
    }

    @NotNull
    public static final OrdersInfo getDEFAULT_ORDERS_INFO() {
        return a;
    }
}
