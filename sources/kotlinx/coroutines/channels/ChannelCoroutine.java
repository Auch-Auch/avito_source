package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.api.model.VKAttachments;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B%\u0012\u0006\u0010A\u001a\u00020@\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010B\u001a\u00020\t¢\u0006\u0004\bC\u0010DJ\u000f\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\nJ\u001d\u0010\u0005\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0010\u0010\nJ5\u0010\u0015\u001a\u00020\u00032#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000!HAø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010 J\u0015\u0010$\u001a\u0004\u0018\u00018\u0000HAø\u0001\u0000¢\u0006\u0004\b$\u0010 J\u001b\u0010%\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u0019\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000*8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\t8\u0016@\u0017X\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R%\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0*8\u0016@\u0017X\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b0\u0010,R\u0016\u00102\u001a\u00020\t8\u0016@\u0017X\u0005¢\u0006\u0006\u001a\u0004\b2\u0010/R\u0016\u00103\u001a\u00020\t8\u0016@\u0017X\u0005¢\u0006\u0006\u001a\u0004\b3\u0010/R\u001e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000*8\u0016@\u0017X\u0005¢\u0006\u0006\u001a\u0004\b4\u0010,R\"\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010(R\u0016\u0010:\u001a\u00020\t8\u0016@\u0017X\u0005¢\u0006\u0006\u001a\u0004\b:\u0010/R(\u0010?\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<0;8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b=\u0010>\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006E"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "cancel", "()V", "", "cause", "", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "(Ljava/lang/Throwable;)V", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "element", BaseAnalyticKt.ANALYTIC_MODULE_OFFER, "(Ljava/lang/Object;)Z", VKAttachments.TYPE_POLL, "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ValueOrClosed;", "receiveOrClosed-ZYPwvRU", "receiveOrClosed", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "isEmpty", "()Z", "getOnReceiveOrClosed", "onReceiveOrClosed", "isClosedForSend", "isClosedForReceive", "getOnReceiveOrNull", "onReceiveOrNull", "c", "Lkotlinx/coroutines/channels/Channel;", "get_channel", "_channel", "isFull", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    @NotNull
    public final Channel<E> c;

    public ChannelCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, boolean z) {
        super(coroutineContext, z);
        this.c = channel;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(@NotNull Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, null, 1, null);
        this.c.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable th) {
        return this.c.close(th);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    @NotNull
    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceive() {
        return this.c.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed() {
        return this.c.getOnReceiveOrClosed();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return this.c.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this.c.getOnSend();
    }

    @NotNull
    public final Channel<E> get_channel() {
        return this.c;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @ExperimentalCoroutinesApi
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1) {
        this.c.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.c.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.c.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return this.c.isFull();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return this.c.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        return this.c.offer(e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public E poll() {
        return this.c.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation<? super E> continuation) {
        return this.c.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @InternalCoroutinesApi
    @Nullable
    /* renamed from: receiveOrClosed-ZYPwvRU */
    public Object mo500receiveOrClosedZYPwvRU(@NotNull Continuation<? super ValueOrClosed<? extends E>> continuation) {
        return this.c.mo500receiveOrClosedZYPwvRU(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @ObsoleteCoroutinesApi
    @Nullable
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return this.c.receiveOrNull(continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        return this.c.send(e, continuation);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(@Nullable Throwable th) {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }
}
