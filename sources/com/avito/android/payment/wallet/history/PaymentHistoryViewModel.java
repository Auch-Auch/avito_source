package com.avito.android.payment.wallet.history;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.LiveDatasKt;
import com.avito.android.util.concurrent.UiThreadExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001,B\u001f\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0004R%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\fR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R'\u0010)\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010\u00120\u00120\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b(\u0010\f¨\u0006-"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "", "refresh", "()Lkotlin/Unit;", "retry", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "d", "Landroidx/lifecycle/LiveData;", "getPaymentHistory", "()Landroidx/lifecycle/LiveData;", "paymentHistory", "", "i", "Ljava/lang/String;", "historyId", "Lcom/avito/android/payment/wallet/history/HistoryLoadingState;", "f", "getPageLoadingState", "pageLoadingState", "Lcom/avito/android/payment/wallet/history/PaymentHistoryDataSourceFactory;", "c", "Lcom/avito/android/payment/wallet/history/PaymentHistoryDataSourceFactory;", "paymentHistoryDataSourceFactory", "", g.a, "getListIsEmpty", "listIsEmpty", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "j", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "paymentHistoryInteractor", "kotlin.jvm.PlatformType", "e", "getLoadingState", "loadingState", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;)V", "ScreenState", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryViewModel extends ViewModel {
    public final PaymentHistoryDataSourceFactory c;
    @NotNull
    public final LiveData<PagedList<PaymentHistoryListElement>> d;
    @NotNull
    public final LiveData<HistoryLoadingState> e;
    @NotNull
    public final LiveData<HistoryLoadingState> f;
    @NotNull
    public final LiveData<Boolean> g;
    public final SchedulersFactory h;
    public final String i;
    public final PaymentHistoryInteractor j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState;", "", "<init>", "()V", "Error", "List", "Loading", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState$Loading;", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState$List;", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState$Error;", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ScreenState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState$Error;", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState;", "Lcom/avito/android/remote/error/ErrorResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/ErrorResult;", "getErrorResult", "()Lcom/avito/android/remote/error/ErrorResult;", "errorResult", "<init>", "(Lcom/avito/android/remote/error/ErrorResult;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ScreenState {
            @NotNull
            public final ErrorResult a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull ErrorResult errorResult) {
                super(null);
                Intrinsics.checkNotNullParameter(errorResult, "errorResult");
                this.a = errorResult;
            }

            @NotNull
            public final ErrorResult getErrorResult() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState$List;", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState;", "Landroidx/paging/PagedList;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", AuthSource.SEND_ABUSE, "Landroidx/paging/PagedList;", "getPagedList", "()Landroidx/paging/PagedList;", "pagedList", "<init>", "(Landroidx/paging/PagedList;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class List extends ScreenState {
            @NotNull
            public final PagedList<PaymentHistoryListElement> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public List(@NotNull PagedList<PaymentHistoryListElement> pagedList) {
                super(null);
                Intrinsics.checkNotNullParameter(pagedList, "pagedList");
                this.a = pagedList;
            }

            @NotNull
            public final PagedList<PaymentHistoryListElement> getPagedList() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState$Loading;", "Lcom/avito/android/payment/wallet/history/PaymentHistoryViewModel$ScreenState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ScreenState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public ScreenState() {
        }

        public ScreenState(j jVar) {
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<HistoryPageKeyedDataSource, LiveData<HistoryLoadingState>> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final LiveData<HistoryLoadingState> invoke(HistoryPageKeyedDataSource historyPageKeyedDataSource) {
            int i = this.a;
            if (i == 0) {
                return historyPageKeyedDataSource.getFirstPageLoadingState();
            }
            if (i == 1) {
                return historyPageKeyedDataSource.getSubsequentPageLoadingState();
            }
            throw null;
        }
    }

    public static final class b extends Lambda implements Function1<HistoryPageKeyedDataSource, LiveData<Boolean>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LiveData<Boolean> invoke(HistoryPageKeyedDataSource historyPageKeyedDataSource) {
            return historyPageKeyedDataSource.getListIsEmpty();
        }
    }

    public PaymentHistoryViewModel(@NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull PaymentHistoryInteractor paymentHistoryInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, "historyId");
        Intrinsics.checkNotNullParameter(paymentHistoryInteractor, "paymentHistoryInteractor");
        this.h = schedulersFactory;
        this.i = str;
        this.j = paymentHistoryInteractor;
        PaymentHistoryDataSourceFactory paymentHistoryDataSourceFactory = new PaymentHistoryDataSourceFactory(schedulersFactory, str, paymentHistoryInteractor);
        this.c = paymentHistoryDataSourceFactory;
        LiveData<PagedList<PaymentHistoryListElement>> build = new LivePagedListBuilder(paymentHistoryDataSourceFactory, new PagedList.Config.Builder().setPageSize(10).setEnablePlaceholders(false).build()).setFetchExecutor(new UiThreadExecutor()).build();
        Intrinsics.checkNotNullExpressionValue(build, "LivePagedListBuilder(\n  …cutor())\n        .build()");
        this.d = build;
        this.e = LiveDatasKt.switchMap(paymentHistoryDataSourceFactory.getHistoryDataSourceLiveData(), a.b);
        this.f = LiveDatasKt.switchMap(paymentHistoryDataSourceFactory.getHistoryDataSourceLiveData(), a.c);
        this.g = LiveDatasKt.switchMap(paymentHistoryDataSourceFactory.getHistoryDataSourceLiveData(), b.a);
    }

    @NotNull
    public final LiveData<Boolean> getListIsEmpty() {
        return this.g;
    }

    @NotNull
    public final LiveData<HistoryLoadingState> getLoadingState() {
        return this.e;
    }

    @NotNull
    public final LiveData<HistoryLoadingState> getPageLoadingState() {
        return this.f;
    }

    @NotNull
    public final LiveData<PagedList<PaymentHistoryListElement>> getPaymentHistory() {
        return this.d;
    }

    @Nullable
    public final Unit refresh() {
        HistoryPageKeyedDataSource value = this.c.getHistoryDataSourceLiveData().getValue();
        if (value == null) {
            return null;
        }
        value.refresh();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Unit retry() {
        HistoryPageKeyedDataSource value = this.c.getHistoryDataSourceLiveData().getValue();
        if (value == null) {
            return null;
        }
        value.retry();
        return Unit.INSTANCE;
    }
}
