package com.avito.android.orders.feature.list.adapter.order;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.orders.feature.list.adapter.order.OrderItemView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00030\u000bj\u0002`\f¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00030\u000bj\u0002`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/orders/feature/list/adapter/order/OrderItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView;", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView;Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/orders/feature/list/adapter/OrderItemClicksConsumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrderItemPresenter implements ItemPresenter<OrderItemView, OrderItem> {
    public final Consumer<OrderItem> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ OrderItemPresenter a;
        public final /* synthetic */ OrderItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(OrderItemPresenter orderItemPresenter, OrderItem orderItem) {
            super(0);
            this.a = orderItemPresenter;
            this.b = orderItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public OrderItemPresenter(@NotNull Consumer<OrderItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull OrderItemView orderItemView, @NotNull OrderItem orderItem, int i) {
        Intrinsics.checkNotNullParameter(orderItemView, "view");
        Intrinsics.checkNotNullParameter(orderItem, "item");
        orderItemView.setTitle(orderItem.getTitle());
        orderItemView.setDate(orderItem.getDate());
        orderItemView.setPrice(orderItem.getPrice());
        orderItemView.setStatus(orderItem.getStatus());
        orderItemView.setItems(orderItem.getItems());
        int size = orderItem.getImages().size();
        if (size >= 3) {
            orderItemView.setPictureThree(AvitoPictureKt.pictureOf$default(orderItem.getImages().get(0), true, 0.0f, 0.0f, null, 28, null));
            orderItemView.setPictureTwo(AvitoPictureKt.pictureOf$default(orderItem.getImages().get(1), true, 0.0f, 0.0f, null, 28, null));
            orderItemView.setPictureOne(AvitoPictureKt.pictureOf$default(orderItem.getImages().get(2), true, 0.0f, 0.0f, null, 28, null));
            orderItemView.setItemsConstraint(OrderItemView.ItemsConstraint.IMAGE_THREE, 16);
        } else if (size == 2) {
            orderItemView.setPictureTwo(AvitoPictureKt.pictureOf$default(orderItem.getImages().get(0), true, 0.0f, 0.0f, null, 28, null));
            orderItemView.setPictureOne(AvitoPictureKt.pictureOf$default(orderItem.getImages().get(1), true, 0.0f, 0.0f, null, 28, null));
            orderItemView.setPictureThree(null);
            orderItemView.setItemsConstraint(OrderItemView.ItemsConstraint.IMAGE_TWO, 16);
        } else if (size == 1) {
            orderItemView.setPictureOne(AvitoPictureKt.pictureOf$default(orderItem.getImages().get(0), true, 0.0f, 0.0f, null, 28, null));
            orderItemView.setPictureTwo(null);
            orderItemView.setPictureThree(null);
            orderItemView.setItemsConstraint(OrderItemView.ItemsConstraint.IMAGE_ONE, 16);
        } else {
            orderItemView.setPictureOne(null);
            orderItemView.setPictureTwo(null);
            orderItemView.setPictureThree(null);
            orderItemView.setItemsConstraint(OrderItemView.ItemsConstraint.END, 0);
        }
        orderItemView.setClickListener(new a(this, orderItem));
    }
}
