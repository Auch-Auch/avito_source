package com.avito.android.payment.lib;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethod;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.avito.android.remote.model.payment.service.PaymentSessionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import ru.avito.component.payments.method.PaymentLabel;
import ru.avito.component.payments.method.list.MaterialPaymentMethodItem;
import t6.n.e;
import t6.n.h;
import t6.n.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"", "Lru/avito/component/payments/method/PaymentLabel;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lru/avito/component/payments/method/PaymentLabel;", "asPaymentLabel", "payment-lib_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentMethodsViewModelKt {
    public static final PaymentLabel a(String str) {
        switch (str.hashCode()) {
            case -1890579396:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_QIWI_WALLET)) {
                    return PaymentLabel.QIWI_WALLET;
                }
                break;
            case -1659384968:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_SBERBANK)) {
                    return PaymentLabel.SBERBANK;
                }
                break;
            case -1352291591:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT)) {
                    return PaymentLabel.CREDIT;
                }
                break;
            case -795192327:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_WALLET)) {
                    return PaymentLabel.WALLET;
                }
                break;
            case 108118:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_MIR)) {
                    return PaymentLabel.MIR;
                }
                break;
            case 114009:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_SMS)) {
                    return PaymentLabel.SMS;
                }
                break;
            case 3046160:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CARD)) {
                    return PaymentLabel.CARD;
                }
                break;
            case 3046195:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CASH)) {
                    return PaymentLabel.CASH;
                }
                break;
            case 3619905:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_VISA)) {
                    return PaymentLabel.VISA;
                }
                break;
            case 178883556:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_YANDEX_MONEY)) {
                    return PaymentLabel.YANDEX_MONEY;
                }
                break;
            case 1174445979:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_MASTERCARD)) {
                    return PaymentLabel.MASTERCARD;
                }
                break;
            case 1640813068:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_YOO_MONEY)) {
                    return PaymentLabel.YOO_MONEY;
                }
                break;
            case 1827356236:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_SBERBANK_APP)) {
                    return PaymentLabel.SBERBANK_APP;
                }
                break;
        }
        return PaymentLabel.UNKNOWN;
    }

    public static final PaymentMethod.GooglePay access$getGooglePayPaymentMethod(PaymentSessionResult paymentSessionResult) {
        Object obj;
        Iterator it = e.flatten(paymentSessionResult.getPaymentMethods()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (obj instanceof PaymentMethod.GooglePay) {
                break;
            }
        }
        return (PaymentMethod.GooglePay) obj;
    }

    public static final List access$getPaymentMethodsList(PaymentSessionResult paymentSessionResult) {
        Sequence filter = SequencesKt___SequencesKt.filter(SequencesKt__SequencesKt.flattenSequenceOfIterable(CollectionsKt___CollectionsKt.asSequence(paymentSessionResult.getPaymentMethods())), PaymentMethodsViewModelKt$getPaymentMethodsList$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return SequencesKt___SequencesKt.toList(filter);
    }

    public static final List access$getPaymentMethodsWithoutGooglePayGroup(PaymentSessionResult paymentSessionResult) {
        List<List<PaymentMethod>> paymentMethods = paymentSessionResult.getPaymentMethods();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(paymentMethods, 10));
        Iterator<T> it = paymentMethods.iterator();
        while (it.hasNext()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : it.next()) {
                if (!(((PaymentMethod) obj) instanceof PaymentMethod.GooglePay)) {
                    arrayList2.add(obj);
                }
            }
            arrayList.add(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (!((List) next).isEmpty()) {
                arrayList3.add(next);
            }
        }
        return arrayList3;
    }

    public static final List access$toKonveyorItems(List list, String str) {
        PaymentLabel paymentLabel;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List<PaymentMethod.SelectableMethod> filterIsInstance = j.filterIsInstance((List) it.next(), PaymentMethod.SelectableMethod.class);
            String label = filterIsInstance.isEmpty() ^ true ? ((PaymentMethod.SelectableMethod) CollectionsKt___CollectionsKt.first((List<? extends Object>) filterIsInstance)).getLabel() : null;
            if (CollectionsKt___CollectionsKt.contains(CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_MASTERCARD, PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_VISA, PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_MIR, PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT}), label)) {
                label = PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CARD;
            }
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(filterIsInstance, 10));
            for (PaymentMethod.SelectableMethod selectableMethod : filterIsInstance) {
                StringBuilder L = a.L("PaymentMethod ");
                L.append(selectableMethod.getSignature());
                String sb = L.toString();
                String title = selectableMethod.getTitle();
                DeepLink deepLink = selectableMethod.getDeepLink();
                String description = selectableMethod.getDescription();
                String str2 = description != null ? description : "";
                String label2 = selectableMethod.getLabel();
                if (label2 == null || (paymentLabel = a(label2)) == null) {
                    paymentLabel = label != null ? a(label) : null;
                }
                if (paymentLabel == null) {
                    paymentLabel = PaymentLabel.UNKNOWN;
                }
                String signature = selectableMethod.getSignature();
                boolean areEqual = Intrinsics.areEqual(selectableMethod.getSignature(), str);
                String information = selectableMethod.getInformation();
                if (information == null) {
                    information = "";
                }
                arrayList2.add(new MaterialPaymentMethodItem(sb, true, title, deepLink, str2, paymentLabel, signature, areEqual, information));
                it = it;
            }
            h.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }
}
