package com.avito.android.payment.caching_interactor;

import a2.a.a.t1.a.c;
import a2.a.a.t1.a.d;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BG\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012$\u0010\u001c\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\t0\u0018¢\u0006\u0004\b$\u0010%J1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R4\u0010\u001c\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\t0\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/payment/caching_interactor/SingleResultCachingInteractor;", "Landroid/os/Parcelable;", "T", "Lcom/avito/android/payment/caching_interactor/CachingInteractor;", "", "forceUpdate", "", "", "nativeMethods", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "load", "(ZLjava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "e", "Ljava/lang/String;", "bundleKey", "d", "Lcom/avito/android/util/Kundle;", "state", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/TypedResult;", "f", "Lkotlin/jvm/functions/Function1;", "remoteLoad", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.SEND_ABUSE, "Landroid/os/Parcelable;", "result", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public final class SingleResultCachingInteractor<T extends Parcelable> implements CachingInteractor<T> {
    public T a;
    public Set<String> b;
    public final SchedulersFactory c;
    public final Kundle d;
    public final String e;
    public final Function1<Set<String>, Observable<TypedResult<T>>> f;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super java.util.Set<java.lang.String>, ? extends io.reactivex.Observable<com.avito.android.remote.model.TypedResult<T extends android.os.Parcelable>>> */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleResultCachingInteractor(@NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle, @NotNull String str, @NotNull Function1<? super Set<String>, ? extends Observable<TypedResult<T>>> function1) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, "bundleKey");
        Intrinsics.checkNotNullParameter(function1, "remoteLoad");
        this.c = schedulersFactory;
        this.d = kundle;
        this.e = str;
        this.f = function1;
        this.a = kundle != null ? (T) kundle.getParcelable(str) : null;
        this.b = y.emptySet();
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Observable<LoadingState<T>> load(boolean z, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nativeMethods");
        this.b = set;
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
        Observable<R> startWith = this.f.invoke(set).subscribeOn(this.c.io()).doOnNext(new c(this)).map(d.a).startWith((Observable<R>) ((R) LoadingState.Loading.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(startWith, "remoteLoad(nativeMethods…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable(this.e, this.a);
        return kundle;
    }
}
