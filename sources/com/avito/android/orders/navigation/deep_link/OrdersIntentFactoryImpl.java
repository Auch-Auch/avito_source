package com.avito.android.orders.navigation.deep_link;

import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.OrdersIntentFactory;
import com.avito.android.orders.navigation.OrdersFragmentData;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/orders/navigation/deep_link/OrdersIntentFactoryImpl;", "Lcom/avito/android/OrdersIntentFactory;", "", "tab", "ordersToPrefetch", "Landroid/content/Intent;", "ordersIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Lcom/avito/android/CoreActivityIntentFactory;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersIntentFactoryImpl implements OrdersIntentFactory {
    public final CoreActivityIntentFactory a;

    @Inject
    public OrdersIntentFactoryImpl(@NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = coreActivityIntentFactory;
    }

    @Override // com.avito.android.OrdersIntentFactory
    @NotNull
    public Intent ordersIntent(@Nullable String str, @Nullable String str2) {
        return this.a.mainScreenWithTab(new OrdersFragmentData(str, str2));
    }
}
