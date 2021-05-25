package com.avito.android.payment.wallet.history;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.avito.android.payment.wallet.history.HistoryLoadingState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import com.avito.android.remote.model.payment.history.PaymentHistoryPage;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b4\u00105J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J1\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0010\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0012\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/payment/wallet/history/HistoryPageKeyedDataSource;", "Landroidx/paging/PageKeyedDataSource;", "", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "", "retry", "()V", "refresh", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "params", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "callback", "loadInitial", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadAfter", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "loadBefore", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/payment/wallet/history/HistoryLoadingState;", g.a, "Landroidx/lifecycle/MutableLiveData;", "getFirstPageLoadingState", "()Landroidx/lifecycle/MutableLiveData;", "firstPageLoadingState", "", "i", "getListIsEmpty", "listIsEmpty", "Lcom/avito/android/util/SchedulersFactory;", "k", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "l", "Ljava/lang/String;", "historyId", "h", "getSubsequentPageLoadingState", "subsequentPageLoadingState", "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;", "paymentHistoryInteractor", "Lkotlin/Function0;", "j", "Lkotlin/jvm/functions/Function0;", "retryCall", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/payment/wallet/history/PaymentHistoryInteractor;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class HistoryPageKeyedDataSource extends PageKeyedDataSource<String, PaymentHistoryListElement> {
    public final CompositeDisposable f = new CompositeDisposable();
    @NotNull
    public final MutableLiveData<HistoryLoadingState> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<HistoryLoadingState> h = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> i = new MutableLiveData<>();
    public Function0<Unit> j;
    public final SchedulersFactory k;
    public final String l;
    public final PaymentHistoryInteractor m;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ HistoryPageKeyedDataSource a;

        public a(HistoryPageKeyedDataSource historyPageKeyedDataSource) {
            this.a = historyPageKeyedDataSource;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.getSubsequentPageLoadingState().setValue(HistoryLoadingState.Loading.INSTANCE);
        }
    }

    public static final class b<T> implements Consumer<TypedResult<PaymentHistoryPage>> {
        public final /* synthetic */ HistoryPageKeyedDataSource a;
        public final /* synthetic */ PageKeyedDataSource.LoadCallback b;
        public final /* synthetic */ PageKeyedDataSource.LoadParams c;

        public b(HistoryPageKeyedDataSource historyPageKeyedDataSource, PageKeyedDataSource.LoadCallback loadCallback, PageKeyedDataSource.LoadParams loadParams) {
            this.a = historyPageKeyedDataSource;
            this.b = loadCallback;
            this.c = loadParams;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<PaymentHistoryPage> typedResult) {
            TypedResult<PaymentHistoryPage> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                this.b.onResult(((PaymentHistoryPage) ofResult.getResult()).getHistory(), ((PaymentHistoryPage) ofResult.getResult()).getNextPageToken());
                this.a.getSubsequentPageLoadingState().setValue(HistoryLoadingState.Loaded.INSTANCE);
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.getSubsequentPageLoadingState().setValue(new HistoryLoadingState.Error(((TypedResult.OfError) typedResult2).getError()));
                this.a.j = new a2.a.a.t1.f.c.a(this);
            }
        }
    }

    public static final class c<T> implements Consumer<Disposable> {
        public final /* synthetic */ HistoryPageKeyedDataSource a;

        public c(HistoryPageKeyedDataSource historyPageKeyedDataSource) {
            this.a = historyPageKeyedDataSource;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.getFirstPageLoadingState().setValue(HistoryLoadingState.Loading.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer<TypedResult<PaymentHistoryPage>> {
        public final /* synthetic */ HistoryPageKeyedDataSource a;
        public final /* synthetic */ PageKeyedDataSource.LoadInitialCallback b;

        public d(HistoryPageKeyedDataSource historyPageKeyedDataSource, PageKeyedDataSource.LoadInitialCallback loadInitialCallback) {
            this.a = historyPageKeyedDataSource;
            this.b = loadInitialCallback;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<PaymentHistoryPage> typedResult) {
            TypedResult<PaymentHistoryPage> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                this.b.onResult(((PaymentHistoryPage) ofResult.getResult()).getHistory(), null, ((PaymentHistoryPage) ofResult.getResult()).getNextPageToken());
                this.a.getListIsEmpty().setValue(Boolean.valueOf(((PaymentHistoryPage) ofResult.getResult()).getHistory().isEmpty()));
                this.a.getFirstPageLoadingState().setValue(HistoryLoadingState.Loaded.INSTANCE);
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.getFirstPageLoadingState().setValue(new HistoryLoadingState.Error(((TypedResult.OfError) typedResult2).getError()));
            }
        }
    }

    public HistoryPageKeyedDataSource(@NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull PaymentHistoryInteractor paymentHistoryInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, "historyId");
        Intrinsics.checkNotNullParameter(paymentHistoryInteractor, "paymentHistoryInteractor");
        this.k = schedulersFactory;
        this.l = str;
        this.m = paymentHistoryInteractor;
    }

    @NotNull
    public final MutableLiveData<HistoryLoadingState> getFirstPageLoadingState() {
        return this.g;
    }

    @NotNull
    public final MutableLiveData<Boolean> getListIsEmpty() {
        return this.i;
    }

    @NotNull
    public final MutableLiveData<HistoryLoadingState> getSubsequentPageLoadingState() {
        return this.h;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(@NotNull PageKeyedDataSource.LoadParams<String> loadParams, @NotNull PageKeyedDataSource.LoadCallback<String, PaymentHistoryListElement> loadCallback) {
        Intrinsics.checkNotNullParameter(loadParams, "params");
        Intrinsics.checkNotNullParameter(loadCallback, "callback");
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = this.m.getPaymentHistory(this.l, loadParams.key).subscribeOn(this.k.io()).observeOn(this.k.mainThread()).doOnSubscribe(new a(this)).subscribe(new b(this, loadCallback, loadParams));
        Intrinsics.checkNotNullExpressionValue(subscribe, "paymentHistoryInteractor…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(@NotNull PageKeyedDataSource.LoadParams<String> loadParams, @NotNull PageKeyedDataSource.LoadCallback<String, PaymentHistoryListElement> loadCallback) {
        Intrinsics.checkNotNullParameter(loadParams, "params");
        Intrinsics.checkNotNullParameter(loadCallback, "callback");
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(@NotNull PageKeyedDataSource.LoadInitialParams<String> loadInitialParams, @NotNull PageKeyedDataSource.LoadInitialCallback<String, PaymentHistoryListElement> loadInitialCallback) {
        Intrinsics.checkNotNullParameter(loadInitialParams, "params");
        Intrinsics.checkNotNullParameter(loadInitialCallback, "callback");
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = PaymentHistoryInteractor.getPaymentHistory$default(this.m, this.l, null, 2, null).subscribeOn(this.k.io()).observeOn(this.k.mainThread()).doOnSubscribe(new c(this)).subscribe(new d(this, loadInitialCallback));
        Intrinsics.checkNotNullExpressionValue(subscribe, "paymentHistoryInteractor…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void refresh() {
        invalidate();
    }

    public final void retry() {
        Function0<Unit> function0 = this.j;
        this.j = null;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
