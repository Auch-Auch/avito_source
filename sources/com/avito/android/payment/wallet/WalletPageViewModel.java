package com.avito.android.payment.wallet;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.wallet.WalletPage;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010&R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012R\u001f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012¨\u00064"}, d2 = {"Lcom/avito/android/payment/wallet/WalletPageViewModel;", "Landroidx/lifecycle/ViewModel;", "", "refresh", "", "getWalletInfo", "(Z)V", "onCleared", "()V", "Lcom/avito/android/payment/wallet/WalletInfoInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/payment/wallet/WalletInfoInteractor;", "walletInfoInteractor", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "k", "Landroidx/lifecycle/LiveData;", "getWalletPage", "()Landroidx/lifecycle/LiveData;", "walletPage", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "mutableIsRefreshing", "Lcom/avito/android/remote/error/ErrorResult;", "j", "getError", "error", g.a, "getMutableWalletPage", "()Landroidx/lifecycle/MutableLiveData;", "mutableWalletPage", "e", "mutableInitialLoading", "f", "getMutableError", "mutableError", "h", "isRefreshing", "i", "getInitialLoading", "initialLoading", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/wallet/WalletInfoInteractor;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WalletPageViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public final MutableLiveData<Boolean> d;
    public final MutableLiveData<Unit> e;
    @NotNull
    public final MutableLiveData<ErrorResult> f;
    @NotNull
    public final MutableLiveData<WalletPage> g;
    @NotNull
    public final LiveData<Boolean> h;
    @NotNull
    public final LiveData<Unit> i;
    @NotNull
    public final LiveData<ErrorResult> j;
    @NotNull
    public final LiveData<WalletPage> k;
    public final SchedulersFactory l;
    public final WalletInfoInteractor m;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ WalletPageViewModel a;
        public final /* synthetic */ boolean b;

        public a(WalletPageViewModel walletPageViewModel, boolean z) {
            this.a = walletPageViewModel;
            this.b = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            if (!this.b) {
                this.a.e.setValue(Unit.INSTANCE);
            }
        }
    }

    public static final class b<T> implements Consumer<TypedResult<WalletPage>> {
        public final /* synthetic */ WalletPageViewModel a;

        public b(WalletPageViewModel walletPageViewModel) {
            this.a = walletPageViewModel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v9, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Consumer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(com.avito.android.remote.model.TypedResult<com.avito.android.remote.model.payment.wallet.WalletPage> r3) {
            /*
                r2 = this;
                com.avito.android.remote.model.TypedResult r3 = (com.avito.android.remote.model.TypedResult) r3
                java.lang.String r0 = "typedResult"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                boolean r0 = r3 instanceof com.avito.android.remote.model.TypedResult.OfResult
                r1 = 0
                if (r0 == 0) goto L_0x0039
                com.avito.android.payment.wallet.WalletPageViewModel r0 = r2.a
                androidx.lifecycle.MutableLiveData r0 = r0.getMutableWalletPage()
                com.avito.android.remote.model.TypedResult$OfResult r3 = (com.avito.android.remote.model.TypedResult.OfResult) r3
                java.lang.Object r3 = r3.getResult()
                r0.setValue(r3)
                com.avito.android.payment.wallet.WalletPageViewModel r3 = r2.a
                androidx.lifecycle.MutableLiveData r3 = r3.getMutableError()
                r3.setValue(r1)
                com.avito.android.payment.wallet.WalletPageViewModel r3 = r2.a
                androidx.lifecycle.MutableLiveData r3 = com.avito.android.payment.wallet.WalletPageViewModel.access$getMutableInitialLoading$p(r3)
                r3.setValue(r1)
                com.avito.android.payment.wallet.WalletPageViewModel r3 = r2.a
                androidx.lifecycle.MutableLiveData r3 = com.avito.android.payment.wallet.WalletPageViewModel.access$getMutableIsRefreshing$p(r3)
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                r3.setValue(r0)
                goto L_0x0069
            L_0x0039:
                boolean r0 = r3 instanceof com.avito.android.remote.model.TypedResult.OfError
                if (r0 == 0) goto L_0x0069
                com.avito.android.payment.wallet.WalletPageViewModel r0 = r2.a
                androidx.lifecycle.MutableLiveData r0 = r0.getMutableError()
                com.avito.android.remote.model.TypedResult$OfError r3 = (com.avito.android.remote.model.TypedResult.OfError) r3
                com.avito.android.remote.error.ErrorResult r3 = r3.getError()
                r0.setValue(r3)
                com.avito.android.payment.wallet.WalletPageViewModel r3 = r2.a
                androidx.lifecycle.MutableLiveData r3 = r3.getMutableWalletPage()
                r3.setValue(r1)
                com.avito.android.payment.wallet.WalletPageViewModel r3 = r2.a
                androidx.lifecycle.MutableLiveData r3 = com.avito.android.payment.wallet.WalletPageViewModel.access$getMutableInitialLoading$p(r3)
                r3.setValue(r1)
                com.avito.android.payment.wallet.WalletPageViewModel r3 = r2.a
                androidx.lifecycle.MutableLiveData r3 = com.avito.android.payment.wallet.WalletPageViewModel.access$getMutableIsRefreshing$p(r3)
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                r3.setValue(r0)
            L_0x0069:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.payment.wallet.WalletPageViewModel.b.accept(java.lang.Object):void");
        }
    }

    public WalletPageViewModel(@NotNull SchedulersFactory schedulersFactory, @NotNull WalletInfoInteractor walletInfoInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(walletInfoInteractor, "walletInfoInteractor");
        this.l = schedulersFactory;
        this.m = walletInfoInteractor;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<Unit> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<ErrorResult> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        MutableLiveData<WalletPage> mutableLiveData4 = new MutableLiveData<>();
        this.g = mutableLiveData4;
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
        this.j = mutableLiveData3;
        this.k = mutableLiveData4;
    }

    public static /* synthetic */ void getWalletInfo$default(WalletPageViewModel walletPageViewModel, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        walletPageViewModel.getWalletInfo(z);
    }

    @NotNull
    public final LiveData<ErrorResult> getError() {
        return this.j;
    }

    @NotNull
    public final LiveData<Unit> getInitialLoading() {
        return this.i;
    }

    @NotNull
    public final MutableLiveData<ErrorResult> getMutableError() {
        return this.f;
    }

    @NotNull
    public final MutableLiveData<WalletPage> getMutableWalletPage() {
        return this.g;
    }

    public final void getWalletInfo(boolean z) {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.m.getWalletInfo().subscribeOn(this.l.io()).observeOn(this.l.mainThread()).doOnSubscribe(new a(this, z)).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "walletInfoInteractor.get…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<WalletPage> getWalletPage() {
        return this.k;
    }

    @NotNull
    public final LiveData<Boolean> isRefreshing() {
        return this.h;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.dispose();
    }
}
