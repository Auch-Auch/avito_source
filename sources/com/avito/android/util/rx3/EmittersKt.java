package com.avito.android.util.rx3;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0005\"(\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0000*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00078Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"T", "Lio/reactivex/rxjava3/core/Emitter;", "value", "", "completeWith", "(Lio/reactivex/rxjava3/core/Emitter;Ljava/lang/Object;)V", "", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "", "isNotDisposed", "(Lio/reactivex/rxjava3/core/ObservableEmitter;)Z", "rx"}, k = 2, mv = {1, 4, 2})
public final class EmittersKt {
    public static final <T> void completeWith(@NotNull Emitter<T> emitter, T t) {
        Intrinsics.checkNotNullParameter(emitter, "$this$completeWith");
        emitter.onNext(t);
        emitter.onComplete();
    }

    public static final <T> boolean isNotDisposed(@NotNull ObservableEmitter<T> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "$this$isNotDisposed");
        return !observableEmitter.isDisposed();
    }
}
