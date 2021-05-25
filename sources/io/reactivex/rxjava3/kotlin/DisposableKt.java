package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "", "plusAssign", "(Lio/reactivex/rxjava3/disposables/CompositeDisposable;Lio/reactivex/rxjava3/disposables/Disposable;)V", "compositeDisposable", "addTo", "(Lio/reactivex/rxjava3/disposables/Disposable;Lio/reactivex/rxjava3/disposables/CompositeDisposable;)Lio/reactivex/rxjava3/disposables/Disposable;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class DisposableKt {
    @NotNull
    public static final Disposable addTo(@NotNull Disposable disposable, @NotNull CompositeDisposable compositeDisposable) {
        Intrinsics.checkParameterIsNotNull(disposable, "$this$addTo");
        Intrinsics.checkParameterIsNotNull(compositeDisposable, "compositeDisposable");
        compositeDisposable.add(disposable);
        return disposable;
    }

    public static final void plusAssign(@NotNull CompositeDisposable compositeDisposable, @NotNull Disposable disposable) {
        Intrinsics.checkParameterIsNotNull(compositeDisposable, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(disposable, "disposable");
        compositeDisposable.add(disposable);
    }
}
