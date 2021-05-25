package a2.a.a.o1.b.b.a.c;

import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeReadWriteLock;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class c implements Action {
    public final /* synthetic */ RxFairCompositeReadWriteLock.f a;
    public final /* synthetic */ RxFairCompositeReadWriteLock.b b;

    public c(RxFairCompositeReadWriteLock.f fVar, RxFairCompositeReadWriteLock.b bVar) {
        this.a = fVar;
        this.b = bVar;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        RxFairCompositeReadWriteLock rxFairCompositeReadWriteLock = this.a.a;
        RxFairCompositeReadWriteLock.b bVar = this.b;
        Intrinsics.checkNotNullExpressionValue(bVar, "operation");
        RxFairCompositeReadWriteLock.access$finishOperation(rxFairCompositeReadWriteLock, bVar);
    }
}
