package com.avito.android.payment;

import com.avito.android.remote.model.payment.service.PaymentSessionResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/PaymentSessionInteractor;", "", "", "", "nativeMethods", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/payment/service/PaymentSessionResult;", "createPaymentSession", "(Ljava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentSessionInteractor {
    @NotNull
    Observable<LoadingState<PaymentSessionResult>> createPaymentSession(@NotNull Set<String> set);

    @NotNull
    Kundle onSaveState();
}
