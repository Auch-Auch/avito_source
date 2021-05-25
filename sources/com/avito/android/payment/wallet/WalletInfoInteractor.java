package com.avito.android.payment.wallet;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.wallet.WalletPage;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/wallet/WalletInfoInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "getWalletInfo", "()Lio/reactivex/Observable;", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WalletInfoInteractor {
    public final PaymentApi a;

    public WalletInfoInteractor(@NotNull PaymentApi paymentApi) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        this.a = paymentApi;
    }

    @NotNull
    public final Observable<TypedResult<WalletPage>> getWalletInfo() {
        return InteropKt.toV2(this.a.getWalletPage());
    }
}
