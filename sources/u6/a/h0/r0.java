package u6.a.h0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.jetbrains.annotations.NotNull;
public final class r0<E> extends b<E> {
    public final Continuation<Unit> d;

    public r0(@NotNull CoroutineContext coroutineContext, @NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, broadcastChannel, false);
        this.d = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onStart() {
        CancellableKt.startCoroutineCancellable(this.d, this);
    }

    @Override // u6.a.h0.b, kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        ReceiveChannel<E> openSubscription = this.c.openSubscription();
        start();
        return openSubscription;
    }
}
