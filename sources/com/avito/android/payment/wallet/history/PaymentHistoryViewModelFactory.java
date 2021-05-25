package com.avito.android.payment.wallet.history;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "historyId", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "c", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "paymentHistoryInteractor", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryViewModelFactory implements ViewModelProvider.Factory {
    public final SchedulersFactory a;
    public final String b;
    public final PaymentHistoryInteractor c;

    public PaymentHistoryViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull PaymentHistoryInteractor paymentHistoryInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, "historyId");
        Intrinsics.checkNotNullParameter(paymentHistoryInteractor, "paymentHistoryInteractor");
        this.a = schedulersFactory;
        this.b = str;
        this.c = paymentHistoryInteractor;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PaymentHistoryViewModel.class)) {
            return new PaymentHistoryViewModel(this.a, this.b, this.c);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
