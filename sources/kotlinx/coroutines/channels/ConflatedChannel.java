package kotlinx.coroutines.channels;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010.\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`-¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00060\u001bj\u0002`\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u000f8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u000f8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0016\u0010&\u001a\u00020#8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u000f8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!R\u0016\u0010(\u001a\u00020\u000f8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010!R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010)R\u0016\u0010+\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010!¨\u00061"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "", "wasClosed", "", "onCancelIdempotent", "(Z)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "d", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "isBufferAlwaysEmpty", "()Z", "isBufferFull", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "isBufferAlwaysFull", "isBufferEmpty", "Ljava/lang/Object;", "value", "isEmpty", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class ConflatedChannel<E> extends AbstractChannel<E> {
    public final ReentrantLock c = new ReentrantLock();
    public Object d = AbstractChannelKt.EMPTY;

    public ConflatedChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    public final UndeliveredElementException d(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.d;
        UndeliveredElementException undeliveredElementException = null;
        if (!(obj2 == AbstractChannelKt.EMPTY || (function1 = this.onUndeliveredElement) == null)) {
            undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj2, null, 2, null);
        }
        this.d = obj;
        return undeliveredElementException;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean enqueueReceiveInternal(@NotNull Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public String getBufferDebugString() {
        return a.q(a.L("(value="), this.d, ')');
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferEmpty() {
        return this.d == AbstractChannelKt.EMPTY;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            return isEmptyImpl();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public Object offerInternal(E e) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.d == AbstractChannelKt.EMPTY) {
                do {
                    takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (takeFirstReceiveOrPeekClosed != null) {
                        if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                            Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                            reentrantLock.unlock();
                            return takeFirstReceiveOrPeekClosed;
                        }
                        Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                    }
                } while (takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null) == null);
                reentrantLock.unlock();
                Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                takeFirstReceiveOrPeekClosed.completeResumeReceive(e);
                Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                return takeFirstReceiveOrPeekClosed.getOfferResult();
            }
            UndeliveredElementException d2 = d(e);
            if (d2 == null) {
                Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
                reentrantLock.unlock();
                return symbol;
            }
            throw d2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public Object offerSelectInternal(E e, @NotNull SelectInstance<?> selectInstance) {
        Object performAtomicTrySelect;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.d == AbstractChannelKt.EMPTY) {
                do {
                    AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(e);
                    performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
                        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) describeTryOffer.getResult();
                        reentrantLock.unlock();
                        Intrinsics.checkNotNull(receiveOrClosed);
                        receiveOrClosed.completeResumeReceive(e);
                        Intrinsics.checkNotNull(receiveOrClosed);
                        return receiveOrClosed.getOfferResult();
                    } else if (performAtomicTrySelect == AbstractChannelKt.OFFER_FAILED) {
                    }
                } while (performAtomicTrySelect == AtomicKt.RETRY_ATOMIC);
                if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED() || (performAtomicTrySelect instanceof Closed)) {
                    reentrantLock.unlock();
                    return performAtomicTrySelect;
                }
                throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
            }
            if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            }
            UndeliveredElementException d2 = d(e);
            if (d2 == null) {
                Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
                reentrantLock.unlock();
                return symbol;
            }
            throw d2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onCancelIdempotent(boolean z) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            UndeliveredElementException d2 = d(AbstractChannelKt.EMPTY);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(z);
            if (d2 != null) {
                throw d2;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object pollInternal() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Object obj = this.d;
            Symbol symbol = AbstractChannelKt.EMPTY;
            if (obj == symbol) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            this.d = symbol;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    public Object pollSelectInternal(@NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Object obj = this.d;
            Symbol symbol = AbstractChannelKt.EMPTY;
            if (obj == symbol) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            } else if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            } else {
                Object obj2 = this.d;
                this.d = symbol;
                reentrantLock.unlock();
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
