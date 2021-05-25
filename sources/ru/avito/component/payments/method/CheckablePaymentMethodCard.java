package ru.avito.component.payments.method;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/avito/component/payments/method/CheckablePaymentMethodCard;", "Lru/avito/component/payments/method/PaymentMethodCard;", "", "isChecked", "()Z", "setChecked", "(Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface CheckablePaymentMethodCard extends PaymentMethodCard {
    boolean isChecked();

    void setChecked(boolean z);
}
