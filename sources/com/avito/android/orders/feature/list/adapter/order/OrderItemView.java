package com.avito.android.orders.feature.list.adapter.order;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.orders.model.OrderStatus;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001:\u0001#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0018\u0010\u0016J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001fH&¢\u0006\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", Sort.DATE, "setDate", "price", "setPrice", "Lcom/avito/android/remote/orders/model/OrderStatus;", "status", "setStatus", "(Lcom/avito/android/remote/orders/model/OrderStatus;)V", "", "items", "setItems", "(Ljava/util/List;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPictureOne", "(Lcom/avito/android/image_loader/Picture;)V", "setPictureTwo", "setPictureThree", "Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView$ItemsConstraint;", "constraint", "", "margin", "setItemsConstraint", "(Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView$ItemsConstraint;I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "ItemsConstraint", "orders_release"}, k = 1, mv = {1, 4, 2})
public interface OrderItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull OrderItemView orderItemView) {
            ItemView.DefaultImpls.onUnbind(orderItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView$ItemsConstraint;", "", "<init>", "(Ljava/lang/String;I)V", "END", "IMAGE_ONE", "IMAGE_TWO", "IMAGE_THREE", "orders_release"}, k = 1, mv = {1, 4, 2})
    public enum ItemsConstraint {
        END,
        IMAGE_ONE,
        IMAGE_TWO,
        IMAGE_THREE
    }

    void setClickListener(@NotNull Function0<Unit> function0);

    void setDate(@NotNull AttributedText attributedText);

    void setItems(@NotNull List<AttributedText> list);

    void setItemsConstraint(@NotNull ItemsConstraint itemsConstraint, int i);

    void setPictureOne(@Nullable Picture picture);

    void setPictureThree(@Nullable Picture picture);

    void setPictureTwo(@Nullable Picture picture);

    void setPrice(@NotNull AttributedText attributedText);

    void setStatus(@NotNull OrderStatus orderStatus);

    void setTitle(@NotNull AttributedText attributedText);
}
