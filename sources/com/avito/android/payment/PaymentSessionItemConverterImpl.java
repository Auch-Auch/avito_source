package com.avito.android.payment;

import com.avito.android.remote.model.payment.PaymentMethod;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.avito.android.remote.model.payment.service.PaymentSessionResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.list.PaymentMethodItem;
import t6.n.h;
import t6.n.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/payment/PaymentSessionItemConverterImpl;", "Lcom/avito/android/payment/PaymentSessionItemConverter;", "Lcom/avito/android/remote/model/payment/service/PaymentSessionResult;", "sessionResult", "", "checkedMethodSignature", "Lcom/avito/android/payment/DecoratedItems;", "convert", "(Lcom/avito/android/remote/model/payment/service/PaymentSessionResult;Ljava/lang/String;)Lcom/avito/android/payment/DecoratedItems;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentSessionItemConverterImpl implements PaymentSessionItemConverter {
    @Override // com.avito.android.payment.PaymentSessionItemConverter
    @NotNull
    public DecoratedItems convert(@NotNull PaymentSessionResult paymentSessionResult, @NotNull String str) {
        Intrinsics.checkNotNullParameter(paymentSessionResult, "sessionResult");
        Intrinsics.checkNotNullParameter(str, "checkedMethodSignature");
        List<List<PaymentMethod>> paymentMethods = paymentSessionResult.getPaymentMethods();
        ArrayList arrayList = new ArrayList();
        for (T<PaymentMethod> t : paymentMethods) {
            List filterIsInstance = j.filterIsInstance(t, PaymentMethod.SelectableMethod.class);
            String label = filterIsInstance.isEmpty() ^ true ? ((PaymentMethod.SelectableMethod) CollectionsKt___CollectionsKt.first((List<? extends Object>) filterIsInstance)).getLabel() : null;
            if (CollectionsKt___CollectionsKt.contains(CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_MASTERCARD, PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_VISA, PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_MIR, PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT}), label)) {
                label = PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CARD;
            }
            MaterialPaymentMethodItemConverter materialPaymentMethodItemConverter = new MaterialPaymentMethodItemConverter(str, label);
            ArrayList arrayList2 = new ArrayList();
            for (PaymentMethod paymentMethod : t) {
                PaymentMethodItem convert = materialPaymentMethodItemConverter.convert(paymentMethod);
                if (convert != null) {
                    arrayList2.add(convert);
                }
            }
            h.addAll(arrayList, arrayList2);
        }
        return new DecoratedItems(arrayList, CollectionsKt__CollectionsKt.emptyList());
    }
}
