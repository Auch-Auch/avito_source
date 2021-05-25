package com.avito.android.payment.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.history.HistoryPageKeyedDataSource;
import com.avito.android.payment.wallet.history.PaymentHistoryInteractor;
import com.avito.android.payment.wallet.history.PaymentHistoryViewModelFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/di/module/PaymentHistoryModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "paymentHistoryInteractor", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModelFactory;", "providePaymentHistoryViewModelFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;)Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModelFactory;", "Lcom/avito/android/payment/wallet/history/HistoryPageKeyedDataSource;", "provideHistoryPageKeyedDataSource", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;)Lcom/avito/android/payment/wallet/history/HistoryPageKeyedDataSource;", "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "providePaymentHistoryInteractor", "(Lcom/avito/android/payment/remote/PaymentApi;)Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "historyId", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PaymentHistoryModule {
    public final String a;

    public PaymentHistoryModule(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "historyId");
        this.a = str;
    }

    @Provides
    @PerFragment
    @NotNull
    public final HistoryPageKeyedDataSource provideHistoryPageKeyedDataSource(@NotNull SchedulersFactory schedulersFactory, @NotNull PaymentHistoryInteractor paymentHistoryInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(paymentHistoryInteractor, "paymentHistoryInteractor");
        return new HistoryPageKeyedDataSource(schedulersFactory, this.a, paymentHistoryInteractor);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaymentHistoryInteractor providePaymentHistoryInteractor(@NotNull PaymentApi paymentApi) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        return new PaymentHistoryInteractor(paymentApi);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaymentHistoryViewModelFactory providePaymentHistoryViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull PaymentHistoryInteractor paymentHistoryInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(paymentHistoryInteractor, "paymentHistoryInteractor");
        return new PaymentHistoryViewModelFactory(schedulersFactory, this.a, paymentHistoryInteractor);
    }
}
