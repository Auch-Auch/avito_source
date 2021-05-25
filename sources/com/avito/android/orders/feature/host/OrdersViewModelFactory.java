package com.avito.android.orders.feature.host;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersTabItemConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/orders/feature/host/OrdersViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/orders/feature/host/OrdersRepository;", AuthSource.SEND_ABUSE, "Lcom/avito/android/orders/feature/host/OrdersRepository;", "ordersRepository", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "d", "Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;", "ordersItemConverter", "Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "c", "Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;", "ordersTabItemConverter", "", "e", "Ljava/lang/String;", "initialTabId", "<init>", "(Lcom/avito/android/orders/feature/host/OrdersRepository;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/orders/feature/common/converter/OrdersTabItemConverter;Lcom/avito/android/orders/feature/common/converter/OrdersItemConverter;Ljava/lang/String;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersViewModelFactory implements ViewModelProvider.Factory {
    public final OrdersRepository a;
    public final TypedErrorThrowableConverter b;
    public final OrdersTabItemConverter c;
    public final OrdersItemConverter d;
    public final String e;

    @Inject
    public OrdersViewModelFactory(@NotNull OrdersRepository ordersRepository, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull OrdersTabItemConverter ordersTabItemConverter, @NotNull OrdersItemConverter ordersItemConverter, @Named("initial_tab") @Nullable String str) {
        Intrinsics.checkNotNullParameter(ordersRepository, "ordersRepository");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(ordersTabItemConverter, "ordersTabItemConverter");
        Intrinsics.checkNotNullParameter(ordersItemConverter, "ordersItemConverter");
        this.a = ordersRepository;
        this.b = typedErrorThrowableConverter;
        this.c = ordersTabItemConverter;
        this.d = ordersItemConverter;
        this.e = str;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new OrdersViewModel(this.a, this.b, this.c, this.d, this.e);
    }
}
