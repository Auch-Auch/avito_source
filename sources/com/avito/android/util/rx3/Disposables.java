package com.avito.android.util.rx3;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"$\u0010\b\u001a\u00020\u0007\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u0001*\u00028\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"$\u0010\n\u001a\u00020\u0007\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u0001*\u00028\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "", "plusAssign", "(Lio/reactivex/rxjava3/disposables/CompositeDisposable;Lio/reactivex/rxjava3/disposables/Disposable;)V", "T", "", "isActive", "(Lio/reactivex/rxjava3/disposables/Disposable;)Z", "isDisposedOrNull", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Disposables")
public final class Disposables {
    public static final <T extends Disposable> boolean isActive(T t) {
        return t != null && !t.isDisposed();
    }

    public static final <T extends Disposable> boolean isDisposedOrNull(T t) {
        return t == null || t.isDisposed();
    }

    public static final void plusAssign(@NotNull CompositeDisposable compositeDisposable, @NotNull Disposable disposable) {
        Intrinsics.checkNotNullParameter(compositeDisposable, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(disposable, "disposable");
        compositeDisposable.add(disposable);
    }
}
