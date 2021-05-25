package com.avito.android.payment.wallet.history;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "Landroidx/paging/DataSource;", "create", "()Landroidx/paging/DataSource;", "c", "Ljava/lang/String;", "historyId", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/payment/wallet/history/HistoryPageKeyedDataSource;", AuthSource.SEND_ABUSE, "Landroidx/lifecycle/MutableLiveData;", "getHistoryDataSourceLiveData", "()Landroidx/lifecycle/MutableLiveData;", "historyDataSourceLiveData", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "d", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "paymentHistoryInteractor", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryDataSourceFactory extends DataSource.Factory<String, PaymentHistoryListElement> {
    @NotNull
    public final MutableLiveData<HistoryPageKeyedDataSource> a = new MutableLiveData<>();
    public final SchedulersFactory b;
    public final String c;
    public final PaymentHistoryInteractor d;

    public PaymentHistoryDataSourceFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull PaymentHistoryInteractor paymentHistoryInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, "historyId");
        Intrinsics.checkNotNullParameter(paymentHistoryInteractor, "paymentHistoryInteractor");
        this.b = schedulersFactory;
        this.c = str;
        this.d = paymentHistoryInteractor;
    }

    @Override // androidx.paging.DataSource.Factory
    @NotNull
    public DataSource<String, PaymentHistoryListElement> create() {
        HistoryPageKeyedDataSource historyPageKeyedDataSource = new HistoryPageKeyedDataSource(this.b, this.c, this.d);
        this.a.setValue(historyPageKeyedDataSource);
        return historyPageKeyedDataSource;
    }

    @NotNull
    public final MutableLiveData<HistoryPageKeyedDataSource> getHistoryDataSourceLiveData() {
        return this.a;
    }
}
