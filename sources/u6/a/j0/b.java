package u6.a.j0;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class b<T> extends ChannelFlow<T> {
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(b.class, "consumed");
    public final ReceiveChannel<T> a;
    public final boolean b;
    private volatile int consumed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ReceiveChannel receiveChannel, boolean z, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2) {
        super((i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : null, (i2 & 8) != 0 ? -3 : i, (i2 & 16) != 0 ? BufferOverflow.SUSPEND : null);
        this.a = receiveChannel;
        this.b = z;
        this.consumed = 0;
    }

    public final void a() {
        if (this.b) {
            boolean z = true;
            if (c.getAndSet(this, 1) != 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String additionalToStringProps() {
        StringBuilder L = a.L("channel=");
        L.append(this.a);
        return L.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public BroadcastChannel<T> broadcastImpl(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        a();
        return super.broadcastImpl(coroutineScope, coroutineStart);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        if (this.capacity == -3) {
            a();
            Object g0 = AppCompatDelegateImpl.i.g0(flowCollector, this.a, this.b, continuation);
            if (g0 == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
                return g0;
            }
        } else {
            Object collect = super.collect(flowCollector, continuation);
            if (collect == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
                return collect;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collectTo(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        Object g0 = AppCompatDelegateImpl.i.g0(new SendingCollector(producerScope), this.a, this.b, continuation);
        return g0 == t6.p.a.a.getCOROUTINE_SUSPENDED() ? g0 : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow<T> create(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new b(this.a, this.b, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Flow<T> dropChannelOperators() {
        return new b(this.a, this.b, null, 0, null, 28);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope coroutineScope) {
        a();
        if (this.capacity == -3) {
            return this.a;
        }
        return super.produceImpl(coroutineScope);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull ReceiveChannel<? extends T> receiveChannel, boolean z, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.a = receiveChannel;
        this.b = z;
        this.consumed = 0;
    }
}
