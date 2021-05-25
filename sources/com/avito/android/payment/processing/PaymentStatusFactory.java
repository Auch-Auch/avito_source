package com.avito.android.payment.processing;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/payment/processing/PaymentStatusFactory;", "", "", AnalyticFieldsName.orderId, "Lcom/avito/android/payment/processing/PaymentStatusPresenter;", "createPresenter", "(Ljava/lang/String;)Lcom/avito/android/payment/processing/PaymentStatusPresenter;", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "api", "Lcom/avito/android/util/Kundle;", "c", "Lcom/avito/android/util/Kundle;", "statusInteractorState", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusFactory {
    public final PaymentApi a;
    public final SchedulersFactory b;
    public final Kundle c;

    public PaymentStatusFactory(@NotNull PaymentApi paymentApi, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = paymentApi;
        this.b = schedulersFactory;
        this.c = kundle;
    }

    @NotNull
    public final PaymentStatusPresenter createPresenter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        return new PaymentStatusPresenterImpl(new PaymentStatusInteractorImpl(this.a, str, this.b, this.c), this.b);
    }
}
