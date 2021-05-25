package com.avito.android.payment;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethod;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.payments.method.PaymentLabel;
import ru.avito.component.payments.method.list.MaterialPaymentMethodItem;
import ru.avito.component.payments.method.list.PaymentMethodItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\b*\u00020\u00078B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/MaterialPaymentMethodItemConverter;", "Lcom/avito/android/payment/PaymentMethodItemConverter;", "Lcom/avito/android/remote/model/payment/PaymentMethod;", "paymentMethod", "Lru/avito/component/payments/method/list/PaymentMethodItem;", "convert", "(Lcom/avito/android/remote/model/payment/PaymentMethod;)Lru/avito/component/payments/method/list/PaymentMethodItem;", "", "Lru/avito/component/payments/method/PaymentLabel;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lru/avito/component/payments/method/PaymentLabel;", "asPaymentLabel", "Ljava/lang/String;", "checkedMethodSignature", AuthSource.BOOKING_ORDER, "buttonItemLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class MaterialPaymentMethodItemConverter implements PaymentMethodItemConverter {
    public final String a;
    public String b;

    public MaterialPaymentMethodItemConverter(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "checkedMethodSignature");
        this.a = str;
        this.b = str2;
    }

    public final PaymentLabel a(String str) {
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

    @Override // com.avito.android.payment.PaymentMethodItemConverter
    @Nullable
    public PaymentMethodItem convert(@NotNull PaymentMethod paymentMethod) {
        PaymentLabel paymentLabel;
        String str;
        PaymentLabel paymentLabel2;
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        if (paymentMethod instanceof PaymentMethod.ButtonMethod) {
            StringBuilder L = a.L("PaymentMethod ");
            L.append(paymentMethod.getSignature());
            String sb = L.toString();
            String title = paymentMethod.getTitle();
            DeepLink deepLink = paymentMethod.getDeepLink();
            String str2 = this.b;
            if (str2 == null || (paymentLabel2 = a(str2)) == null) {
                paymentLabel2 = PaymentLabel.UNKNOWN;
            }
            return new MaterialPaymentMethodItem(sb, true, title, deepLink, "", paymentLabel2, paymentMethod.getSignature(), Intrinsics.areEqual(paymentMethod.getSignature(), this.a), "");
        } else if (paymentMethod instanceof PaymentMethod.SelectableMethod) {
            StringBuilder L2 = a.L("PaymentMethod ");
            L2.append(paymentMethod.getSignature());
            String sb2 = L2.toString();
            String title2 = paymentMethod.getTitle();
            DeepLink deepLink2 = paymentMethod.getDeepLink();
            PaymentMethod.SelectableMethod selectableMethod = (PaymentMethod.SelectableMethod) paymentMethod;
            String description = selectableMethod.getDescription();
            String str3 = description != null ? description : "";
            String label = selectableMethod.getLabel();
            if (label == null || (paymentLabel = a(label)) == null) {
                paymentLabel = PaymentLabel.UNKNOWN;
            }
            String signature = paymentMethod.getSignature();
            boolean areEqual = Intrinsics.areEqual(paymentMethod.getSignature(), this.a);
            String information = selectableMethod.getInformation();
            if (information != null) {
                str = information;
            } else {
                str = "";
            }
            return new MaterialPaymentMethodItem(sb2, true, title2, deepLink2, str3, paymentLabel, signature, areEqual, str);
        } else if (paymentMethod instanceof PaymentMethod.GooglePay) {
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
