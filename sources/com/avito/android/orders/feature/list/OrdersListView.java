package com.avito.android.orders.feature.list;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.remote.orders.model.OrdersPlaceholder;
import com.avito.konveyor.blueprint.Item;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListView;", "", "", "Lcom/avito/konveyor/blueprint/Item;", "orderItems", "", "showContent", "(Ljava/util/List;)V", "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", InternalConstsKt.PLACEHOLDER, "showEmptyState", "(Lcom/avito/android/remote/orders/model/OrdersPlaceholder;)V", "", "errorMessage", "showPartScreenError", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "getRefreshSwipes", "()Lio/reactivex/rxjava3/core/Observable;", "refreshSwipes", "Lcom/avito/android/deep_linking/links/DeepLink;", "getEmptyStateClicks", "emptyStateClicks", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "getOrderClicks", "orderClicks", "orders_release"}, k = 1, mv = {1, 4, 2})
public interface OrdersListView {
    @NotNull
    Observable<DeepLink> getEmptyStateClicks();

    @NotNull
    Observable<OrderItem> getOrderClicks();

    @NotNull
    Observable<Unit> getRefreshSwipes();

    void showContent(@NotNull List<? extends Item> list);

    void showEmptyState(@NotNull OrdersPlaceholder ordersPlaceholder);

    void showPartScreenError(@NotNull String str);
}
