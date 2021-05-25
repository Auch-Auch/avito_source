package com.avito.android.util;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "Lio/reactivex/FlowableEmitter;", "kotlin.jvm.PlatformType", "emitter", "", "subscribe", "(Lio/reactivex/FlowableEmitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class Flowables$flowableFromCallableWithoutComplete$1<T> implements FlowableOnSubscribe<T> {
    public final /* synthetic */ Function0 a;

    public Flowables$flowableFromCallableWithoutComplete$1(Function0 function0) {
        this.a = function0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.FlowableEmitter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(@NotNull FlowableEmitter<T> flowableEmitter) {
        Intrinsics.checkNotNullParameter(flowableEmitter, "emitter");
        if (!flowableEmitter.isCancelled()) {
            try {
                flowableEmitter.onNext(this.a.invoke());
            } catch (Throwable th) {
                flowableEmitter.tryOnError(th);
            }
        }
    }
}
