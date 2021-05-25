package com.avito.android.util.rx;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\"$\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000*\u00028\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"$\u0010\u0005\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000*\u00028\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/reactivex/disposables/Disposable;", "T", "", "isDisposedOrNull", "(Lio/reactivex/disposables/Disposable;)Z", "isActive", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Disposables")
public final class Disposables {
    public static final <T extends Disposable> boolean isActive(T t) {
        return t != null && !t.isDisposed();
    }

    public static final <T extends Disposable> boolean isDisposedOrNull(T t) {
        return t == null || t.isDisposed();
    }
}
