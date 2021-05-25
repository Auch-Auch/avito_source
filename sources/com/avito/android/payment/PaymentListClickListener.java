package com.avito.android.payment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.list.ButtonPaymentMethodItem;
import ru.avito.component.payments.method.list.CheckablePaymentMethodItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/PaymentListClickListener;", "", "Lkotlin/Function0;", "", "getSubmitButtonListener", "()Lkotlin/jvm/functions/Function0;", "submitButtonListener", "Lkotlin/Function1;", "Lru/avito/component/payments/method/list/CheckablePaymentMethodItem;", "getCheckablePaymentMethodListener", "()Lkotlin/jvm/functions/Function1;", "checkablePaymentMethodListener", "", "getOnViewClickListener", "onViewClickListener", "Lru/avito/component/payments/method/list/ButtonPaymentMethodItem;", "getButtonPaymentMethodListener", "buttonPaymentMethodListener", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentListClickListener {
    @NotNull
    Function1<ButtonPaymentMethodItem, Unit> getButtonPaymentMethodListener();

    @NotNull
    Function1<CheckablePaymentMethodItem, Unit> getCheckablePaymentMethodListener();

    @NotNull
    Function1<Integer, Unit> getOnViewClickListener();

    @NotNull
    Function0<Unit> getSubmitButtonListener();
}
