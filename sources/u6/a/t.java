package u6.a;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.jetbrains.annotations.NotNull;
public final class t extends a0 {
    public final Continuation<Unit> c;

    public t(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.c = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onStart() {
        CancellableKt.startCoroutineCancellable(this.c, this);
    }
}
