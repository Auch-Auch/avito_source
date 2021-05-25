package com.avito.android.payment.form;

import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormViewListener;", "", "Lkotlin/Function0;", "", "getSubmitButtonListener", "()Lkotlin/jvm/functions/Function0;", "submitButtonListener", "Lkotlin/Function1;", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItem;", "getPhoneInputListener", "()Lkotlin/jvm/functions/Function1;", "phoneInputListener", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentGenericFormViewListener {
    @NotNull
    Function1<PhoneInputItem, Unit> getPhoneInputListener();

    @NotNull
    Function0<Unit> getSubmitButtonListener();
}
