package com.avito.android.payment.caching_interactor;

import a2.a.a.t1.a.a;
import a2.a.a.t1.a.b;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003Bc\u0012\u0006\u0010$\u001a\u00020!\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\t0\u0010\u0012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018¢\u0006\u0004\b(\u0010)J1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\t0\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/payment/caching_interactor/SealedResultCachingInteractor;", "", "T", "Lcom/avito/android/payment/caching_interactor/CachingInteractor;", "", "forceUpdate", "", "", "nativeMethods", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "load", "(ZLjava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lkotlin/Function0;", "Lcom/avito/android/remote/model/TypedResult;", "d", "Lkotlin/jvm/functions/Function0;", "remoteLoad", "c", "Lcom/avito/android/util/Kundle;", "state", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "restore", "Lkotlin/Function2;", "", "e", "Lkotlin/jvm/functions/Function2;", "save", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "result", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class SealedResultCachingInteractor<T> implements CachingInteractor<T> {
    public T a;
    public final SchedulersFactory b;
    public final Kundle c;
    public final Function0<Observable<TypedResult<T>>> d;
    public final Function2<T, Kundle, Unit> e;
    public final Function1<Kundle, T> f;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends io.reactivex.Observable<com.avito.android.remote.model.TypedResult<T>>> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super T, ? super com.avito.android.util.Kundle, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.util.Kundle, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SealedResultCachingInteractor(@NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle, @NotNull Function0<? extends Observable<TypedResult<T>>> function0, @NotNull Function2<? super T, ? super Kundle, Unit> function2, @NotNull Function1<? super Kundle, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(function0, "remoteLoad");
        Intrinsics.checkNotNullParameter(function2, "save");
        Intrinsics.checkNotNullParameter(function1, "restore");
        this.b = schedulersFactory;
        this.c = kundle;
        this.d = function0;
        this.e = function2;
        this.f = function1;
        this.a = kundle != null ? (T) function1.invoke(kundle) : null;
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Observable<LoadingState<T>> load(boolean z, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nativeMethods");
        if (z) {
            this.a = null;
        }
        T t = this.a;
        if (t != null) {
            Observable<LoadingState<T>> just = Observable.just(new LoadingState.Loaded(t));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            Objects.requireNonNull(just, "null cannot be cast to non-null type io.reactivex.Observable<com.avito.android.util.LoadingState<T>>");
            return just;
        }
        Observable<R> startWith = this.d.invoke().subscribeOn(this.b.io()).doOnNext(new a(this)).map(b.a).startWith((Observable<R>) ((R) LoadingState.Loading.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(startWith, "remoteLoad()\n           …ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        T t = this.a;
        if (t != null) {
            this.e.invoke(t, kundle);
        }
        return kundle;
    }
}
