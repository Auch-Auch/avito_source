package a2.a.a.o1.b.b.a.c;

import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class d implements Action {
    public final /* synthetic */ RxFairCompositeWriteLock.f a;
    public final /* synthetic */ RxFairCompositeWriteLock.b b;

    public d(RxFairCompositeWriteLock.f fVar, RxFairCompositeWriteLock.b bVar) {
        this.a = fVar;
        this.b = bVar;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        RxFairCompositeWriteLock rxFairCompositeWriteLock = this.a.a;
        RxFairCompositeWriteLock.b bVar = this.b;
        Intrinsics.checkNotNullExpressionValue(bVar, "operation");
        RxFairCompositeWriteLock.access$finishOperation(rxFairCompositeWriteLock, bVar);
    }
}
