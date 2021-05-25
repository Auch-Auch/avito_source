package kotlinx.coroutines.channels;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010<\u001a\u00020\u001c\u0012\u0006\u00106\u001a\u000203\u0012 \u0010A\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0019\u0018\u00010?j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`@¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00158D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00158D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0016\u0010)\u001a\u00020&8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010$R\u001a\u0010/\u001a\u00060+j\u0002`,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u00100R\u0016\u00102\u001a\u00020\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010$R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u00020\u00158D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b7\u0010$R\u001e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u00109R\u0016\u0010<\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u00100R\u0016\u0010=\u001a\u00020\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b=\u0010$R\u0016\u0010>\u001a\u00020\u00158D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b>\u0010$¨\u0006D"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Send;", "send", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "wasClosed", "", "onCancelIdempotent", "(Z)V", "", "currentSize", "Lkotlinx/coroutines/internal/Symbol;", "e", "(I)Lkotlinx/coroutines/internal/Symbol;", "d", "(ILjava/lang/Object;)V", "isBufferEmpty", "()Z", "isBufferAlwaysFull", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "I", "head", "isFull", "Lkotlinx/coroutines/channels/BufferOverflow;", g.a, "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "isBufferAlwaysEmpty", "", "[Ljava/lang/Object;", "buffer", "f", "capacity", "isClosedForReceive", "isBufferFull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class ArrayChannel<E> extends AbstractChannel<E> {
    public final ReentrantLock c;
    public Object[] d;
    public int e;
    public final int f;
    public final BufferOverflow g;
    public volatile int size;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BufferOverflow.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
            iArr[1] = 3;
        }
    }

    public ArrayChannel(int i, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.f = i;
        this.g = bufferOverflow;
        if (i < 1 ? false : true) {
            this.c = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i, 8)];
            ArraysKt___ArraysJvmKt.fill$default(objArr, AbstractChannelKt.EMPTY, 0, 0, 6, (Object) null);
            this.d = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(a.Q2("ArrayChannel capacity must be at least 1, but ", i, " was specified").toString());
    }

    public final void d(int i, E e2) {
        int i2 = this.f;
        if (i < i2) {
            Object[] objArr = this.d;
            if (i >= objArr.length) {
                int min = Math.min(objArr.length * 2, i2);
                Object[] objArr2 = new Object[min];
                for (int i3 = 0; i3 < i; i3++) {
                    Object[] objArr3 = this.d;
                    objArr2[i3] = objArr3[(this.e + i3) % objArr3.length];
                }
                ArraysKt___ArraysJvmKt.fill((Symbol[]) objArr2, AbstractChannelKt.EMPTY, i, min);
                this.d = objArr2;
                this.e = 0;
            }
            Object[] objArr4 = this.d;
            objArr4[(this.e + i) % objArr4.length] = e2;
            return;
        }
        Object[] objArr5 = this.d;
        int i4 = this.e;
        objArr5[i4 % objArr5.length] = null;
        objArr5[(i + i4) % objArr5.length] = e2;
        this.e = (i4 + 1) % objArr5.length;
    }

    public final Symbol e(int i) {
        if (i < this.f) {
            this.size = i + 1;
            return null;
        }
        int ordinal = this.g.ordinal();
        if (ordinal == 0) {
            return AbstractChannelKt.OFFER_FAILED;
        }
        if (ordinal == 1) {
            return null;
        }
        if (ordinal == 2) {
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        throw new NoWhenBranchMatchedException();
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
    @Nullable
    public Object enqueueSend(@NotNull Send send) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public String getBufferDebugString() {
        StringBuilder L = a.L("(buffer:capacity=");
        L.append(this.f);
        L.append(",size=");
        return a.i(L, this.size, ')');
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
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        return this.size == this.f && this.g == BufferOverflow.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
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

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            return isFullImpl();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public Object offerInternal(E e2) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            Symbol e3 = e(i);
            if (e3 != null) {
                reentrantLock.unlock();
                return e3;
            }
            if (i == 0) {
                do {
                    takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (takeFirstReceiveOrPeekClosed != null) {
                        if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                            this.size = i;
                            Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                            reentrantLock.unlock();
                            return takeFirstReceiveOrPeekClosed;
                        }
                        Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                    }
                } while (takeFirstReceiveOrPeekClosed.tryResumeReceive(e2, null) == null);
                this.size = i;
                reentrantLock.unlock();
                Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                takeFirstReceiveOrPeekClosed.completeResumeReceive(e2);
                Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                return takeFirstReceiveOrPeekClosed.getOfferResult();
            }
            d(i, e2);
            Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
            reentrantLock.unlock();
            return symbol;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public Object offerSelectInternal(E e2, @NotNull SelectInstance<?> selectInstance) {
        Object performAtomicTrySelect;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            Symbol e3 = e(i);
            if (e3 != null) {
                reentrantLock.unlock();
                return e3;
            }
            if (i == 0) {
                do {
                    AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(e2);
                    performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
                        this.size = i;
                        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) describeTryOffer.getResult();
                        reentrantLock.unlock();
                        Intrinsics.checkNotNull(receiveOrClosed);
                        receiveOrClosed.completeResumeReceive(e2);
                        Intrinsics.checkNotNull(receiveOrClosed);
                        return receiveOrClosed.getOfferResult();
                    } else if (performAtomicTrySelect == AbstractChannelKt.OFFER_FAILED) {
                    }
                } while (performAtomicTrySelect == AtomicKt.RETRY_ATOMIC);
                if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED() || (performAtomicTrySelect instanceof Closed)) {
                    this.size = i;
                    reentrantLock.unlock();
                    return performAtomicTrySelect;
                }
                throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
            }
            if (!selectInstance.trySelect()) {
                this.size = i;
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            }
            d(i, e2);
            Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
            reentrantLock.unlock();
            return symbol;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void onCancelIdempotent(boolean z) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.d[this.e];
                if (!(function1 == null || obj == AbstractChannelKt.EMPTY)) {
                    undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.d;
                int i3 = this.e;
                objArr[i3] = AbstractChannelKt.EMPTY;
                this.e = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
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
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.d;
            int i2 = this.e;
            Object obj = objArr[i2];
            Send send = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            boolean z = false;
            if (i == this.f) {
                Send send2 = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        send = send2;
                        break;
                    }
                    Intrinsics.checkNotNull(takeFirstSendOrPeekClosed);
                    if (takeFirstSendOrPeekClosed.tryResumeSend(null) != null) {
                        Intrinsics.checkNotNull(takeFirstSendOrPeekClosed);
                        obj2 = takeFirstSendOrPeekClosed.getPollResult();
                        send = takeFirstSendOrPeekClosed;
                        z = true;
                        break;
                    }
                    Intrinsics.checkNotNull(takeFirstSendOrPeekClosed);
                    takeFirstSendOrPeekClosed.undeliveredElement();
                    send2 = takeFirstSendOrPeekClosed;
                }
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i;
                Object[] objArr2 = this.d;
                objArr2[(this.e + i) % objArr2.length] = obj2;
            }
            this.e = (this.e + 1) % this.d.length;
            reentrantLock.unlock();
            if (z) {
                Intrinsics.checkNotNull(send);
                send.completeResumeSend();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object pollSelectInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.c
            r0.lock()
            int r1 = r8.size     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x0016
            kotlinx.coroutines.channels.Closed r9 = r8.getClosedForSend()     // Catch:{ all -> 0x00c4 }
            if (r9 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00c4 }
        L_0x0012:
            r0.unlock()
            return r9
        L_0x0016:
            java.lang.Object[] r2 = r8.d
            int r3 = r8.e
            r4 = r2[r3]
            r5 = 0
            r2[r3] = r5
            int r2 = r1 + -1
            r8.size = r2
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            int r3 = r8.f
            r6 = 1
            if (r1 != r3) goto L_0x0084
        L_0x002a:
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r3 = r8.describeTryPoll()
            java.lang.Object r7 = r9.performAtomicTrySelect(r3)
            if (r7 != 0) goto L_0x0044
            java.lang.Object r2 = r3.getResult()
            r5 = r2
            kotlinx.coroutines.channels.Send r5 = (kotlinx.coroutines.channels.Send) r5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Object r2 = r5.getPollResult()
        L_0x0042:
            r3 = 1
            goto L_0x0085
        L_0x0044:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            if (r7 != r3) goto L_0x0049
            goto L_0x0084
        L_0x0049:
            java.lang.Object r3 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC
            if (r7 != r3) goto L_0x004e
            goto L_0x002a
        L_0x004e:
            java.lang.Object r2 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()
            if (r7 != r2) goto L_0x0060
            r8.size = r1
            java.lang.Object[] r9 = r8.d
            int r1 = r8.e
            r9[r1] = r4
            r0.unlock()
            return r7
        L_0x0060:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L_0x0069
            r5 = r7
            kotlinx.coroutines.channels.Send r5 = (kotlinx.coroutines.channels.Send) r5
            r2 = r7
            goto L_0x0042
        L_0x0069:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "performAtomicTrySelect(describeTryOffer) returned "
            r9.append(r1)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r9 = r9.toString()
            r1.<init>(r9)
            throw r1
        L_0x0084:
            r3 = 0
        L_0x0085:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            if (r2 == r7) goto L_0x0099
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.Closed
            if (r7 != 0) goto L_0x0099
            r8.size = r1
            java.lang.Object[] r9 = r8.d
            int r7 = r8.e
            int r7 = r7 + r1
            int r1 = r9.length
            int r7 = r7 % r1
            r9[r7] = r2
            goto L_0x00af
        L_0x0099:
            boolean r9 = r9.trySelect()
            if (r9 != 0) goto L_0x00af
            r8.size = r1
            java.lang.Object[] r9 = r8.d
            int r1 = r8.e
            r9[r1] = r4
            java.lang.Object r9 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()
            r0.unlock()
            return r9
        L_0x00af:
            int r9 = r8.e
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.d
            int r1 = r1.length
            int r9 = r9 % r1
            r8.e = r9
            r0.unlock()
            if (r3 == 0) goto L_0x00c3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r5.completeResumeSend()
        L_0x00c3:
            return r4
        L_0x00c4:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.pollSelectInternal(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }
}
