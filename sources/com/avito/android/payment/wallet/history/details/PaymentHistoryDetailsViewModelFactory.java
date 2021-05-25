package com.avito.android.payment.wallet.history.details;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", "getPaymentHistoryDetailsInteractor", "()Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", "paymentHistoryDetailsInteractor", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryDetailsViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public final SchedulersFactory a;
    @NotNull
    public final PaymentHistoryDetailsInteractor b;

    public PaymentHistoryDetailsViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull PaymentHistoryDetailsInteractor paymentHistoryDetailsInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(paymentHistoryDetailsInteractor, "paymentHistoryDetailsInteractor");
        this.a = schedulersFactory;
        this.b = paymentHistoryDetailsInteractor;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PaymentHistoryDetailsViewModel.class)) {
            return new PaymentHistoryDetailsViewModel(this.a, this.b);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

    @NotNull
    public final PaymentHistoryDetailsInteractor getPaymentHistoryDetailsInteractor() {
        return this.b;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        return this.a;
    }
}
