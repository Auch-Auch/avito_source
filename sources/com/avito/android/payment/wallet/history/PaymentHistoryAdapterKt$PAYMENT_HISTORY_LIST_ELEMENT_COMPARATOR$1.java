package com.avito.android.payment.wallet.history;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"com/avito/android/payment/wallet/history/PaymentHistoryAdapterKt$PAYMENT_HISTORY_LIST_ELEMENT_COMPARATOR$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;)Z", "areContentsTheSame", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryAdapterKt$PAYMENT_HISTORY_LIST_ELEMENT_COMPARATOR$1 extends DiffUtil.ItemCallback<PaymentHistoryListElement> {
    public boolean areContentsTheSame(@NotNull PaymentHistoryListElement paymentHistoryListElement, @NotNull PaymentHistoryListElement paymentHistoryListElement2) {
        Intrinsics.checkNotNullParameter(paymentHistoryListElement, "oldItem");
        Intrinsics.checkNotNullParameter(paymentHistoryListElement2, "newItem");
        if (!Intrinsics.areEqual(paymentHistoryListElement.getClass(), paymentHistoryListElement2.getClass())) {
            return false;
        }
        if ((paymentHistoryListElement instanceof PaymentHistoryListElement.Header) && (paymentHistoryListElement2 instanceof PaymentHistoryListElement.Header)) {
            return Intrinsics.areEqual(((PaymentHistoryListElement.Header) paymentHistoryListElement).getTitle(), ((PaymentHistoryListElement.Header) paymentHistoryListElement2).getTitle());
        }
        if (!(paymentHistoryListElement instanceof PaymentHistoryListElement.Order) || !(paymentHistoryListElement2 instanceof PaymentHistoryListElement.Order)) {
            return false;
        }
        PaymentHistoryListElement.Order order = (PaymentHistoryListElement.Order) paymentHistoryListElement;
        PaymentHistoryListElement.Order order2 = (PaymentHistoryListElement.Order) paymentHistoryListElement2;
        if (!Intrinsics.areEqual(order.getTitle(), order2.getTitle()) || !Intrinsics.areEqual(order.getDescription(), order2.getDescription()) || !Intrinsics.areEqual(order.getDate(), order2.getDate()) || !Intrinsics.areEqual(order2.getAmount(), order.getAmount()) || order2.getStatus() != order2.getStatus()) {
            return false;
        }
        return true;
    }

    public boolean areItemsTheSame(@NotNull PaymentHistoryListElement paymentHistoryListElement, @NotNull PaymentHistoryListElement paymentHistoryListElement2) {
        Intrinsics.checkNotNullParameter(paymentHistoryListElement, "oldItem");
        Intrinsics.checkNotNullParameter(paymentHistoryListElement2, "newItem");
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(paymentHistoryListElement.getClass()), Reflection.getOrCreateKotlinClass(paymentHistoryListElement2.getClass()))) {
            return false;
        }
        if ((paymentHistoryListElement instanceof PaymentHistoryListElement.Header) && (paymentHistoryListElement2 instanceof PaymentHistoryListElement.Header)) {
            return Intrinsics.areEqual(((PaymentHistoryListElement.Header) paymentHistoryListElement).getTitle(), ((PaymentHistoryListElement.Header) paymentHistoryListElement2).getTitle());
        }
        if (!(paymentHistoryListElement instanceof PaymentHistoryListElement.Order) || !(paymentHistoryListElement2 instanceof PaymentHistoryListElement.Order)) {
            return false;
        }
        PaymentHistoryListElement.Order order = (PaymentHistoryListElement.Order) paymentHistoryListElement;
        PaymentHistoryListElement.Order order2 = (PaymentHistoryListElement.Order) paymentHistoryListElement2;
        if (!Intrinsics.areEqual(order.getTitle(), order2.getTitle()) || !Intrinsics.areEqual(order.getDescription(), order2.getDescription()) || !Intrinsics.areEqual(order.getDate(), order2.getDate()) || !Intrinsics.areEqual(order2.getAmount(), order.getAmount())) {
            return false;
        }
        return true;
    }
}
