package com.avito.android.util.rx3;

import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u000024\u0010\u0005\u001a0\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000 \u0003*\u0017\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u0002¢\u0006\u0002\b\u00040\u0002¢\u0006\u0002\b\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "T", "Lio/reactivex/rxjava3/core/FlowableEmitter;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "emitter", "", "subscribe", "(Lio/reactivex/rxjava3/core/FlowableEmitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class Flowables$flowableFromCallableWithoutComplete$1<T> implements FlowableOnSubscribe<T> {
    public final /* synthetic */ Function0 a;

    public Flowables$flowableFromCallableWithoutComplete$1(Function0 function0) {
        this.a = function0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.core.FlowableEmitter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<T> flowableEmitter) {
        Intrinsics.checkNotNullExpressionValue(flowableEmitter, "emitter");
        if (!flowableEmitter.isCancelled()) {
            try {
                flowableEmitter.onNext(this.a.invoke());
            } catch (Throwable th) {
                flowableEmitter.tryOnError(th);
            }
        }
    }
}
