package ru.avito.component.payments.method;

import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
/* JADX WARN: Init of enum SBERBANK can be incorrect */
/* JADX WARN: Init of enum SBERBANK_APP can be incorrect */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lru/avito/component/payments/method/PaymentLabel;", "", "", AuthSource.SEND_ABUSE, "I", "getImageRes", "()I", "imageRes", "<init>", "(Ljava/lang/String;II)V", "MASTERCARD", "VISA", "CARD", "CASH", "CREDIT", "SBERBANK", "SBERBANK_APP", "SMS", "WALLET", "MIR", "YANDEX_MONEY", "YOO_MONEY", "QIWI_WALLET", "UNKNOWN", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public enum PaymentLabel {
    MASTERCARD(R.drawable.ic_payment_mastercard),
    VISA(R.drawable.ic_payment_visa),
    CARD(R.drawable.ic_payment_card),
    CASH(R.drawable.ic_cash),
    CREDIT(R.drawable.ic_credit),
    SBERBANK(r2),
    SBERBANK_APP(r2),
    SMS(R.drawable.ic_payment_sms),
    WALLET(R.drawable.ic_payment_wallet),
    MIR(R.drawable.ic_payment_mir),
    YANDEX_MONEY(R.drawable.ic_payment_yandex_money),
    YOO_MONEY(R.drawable.ic_payment_yoo_money),
    QIWI_WALLET(R.drawable.ic_payment_qiwi),
    UNKNOWN(com.avito.android.lib.design.avito.R.color.avito_transparent_black);
    
    public final int a;

    /* access modifiers changed from: public */
    static {
        int i = R.drawable.ic_payment_sberbank;
    }

    /* access modifiers changed from: public */
    PaymentLabel(@DrawableRes int i) {
        this.a = i;
    }

    public final int getImageRes() {
        return this.a;
    }
}
