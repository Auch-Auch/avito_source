package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.favorite_sellers.interactor.SubscribersReadInteractor;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00018B\u000f\u0012\u0006\u00100\u001a\u00020+¢\u0006\u0004\b6\u00107J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u000f2\u000e\u0010\b\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0016¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u00002\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\t8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR2\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f` 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u0010*\u001a\u00020'8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0019\u00100\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00104\u001a\u000601j\u0002`28\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u00103R\u0016\u00105\u001a\u00020\t8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001d¨\u00069"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "c", "d", "()V", "isBufferAlwaysFull", "()Z", "", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$a;", "Lkotlinx/coroutines/internal/SubscribersList;", "e", "Ljava/util/List;", SubscribersReadInteractor.TYPE, "", "[Ljava/lang/Object;", "buffer", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "", "f", "I", "getCapacity", "()I", "capacity", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "bufferLock", "isBufferFull", "<init>", "(I)V", AuthSource.SEND_ABUSE, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    public volatile long _head;
    public volatile int _size;
    public volatile long _tail;
    public final ReentrantLock c;
    public final Object[] d;
    public final List<a<E>> e;
    public final int f;

    public static final class a<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        public volatile long _subHead = 0;
        public final ReentrantLock c = new ReentrantLock();
        public final ArrayBroadcastChannel<E> d;

        public a(@NotNull ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super(null);
            this.d = arrayBroadcastChannel;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
        public boolean close(@Nullable Throwable th) {
            boolean close = super.close(th);
            if (close) {
                ArrayBroadcastChannel.e(this.d, null, this, 1);
                ReentrantLock reentrantLock = this.c;
                reentrantLock.lock();
                try {
                    this._subHead = ArrayBroadcastChannel.access$getTail$p(this.d);
                } finally {
                    reentrantLock.unlock();
                }
            }
            return close;
        }

        /* JADX INFO: finally extract failed */
        public final boolean d() {
            boolean z;
            E e;
            boolean z2 = false;
            while (true) {
                if (getClosedForReceive() == null && (!isBufferEmpty() || this.d.getClosedForReceive() != null)) {
                    z = true;
                } else {
                    z = false;
                }
                e = null;
                if (!z || !this.c.tryLock()) {
                    break;
                }
                try {
                    E e2 = (E) e();
                    if (e2 != AbstractChannelKt.POLL_FAILED) {
                        if (!(e2 instanceof Closed)) {
                            ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                            if (takeFirstReceiveOrPeekClosed == null || (takeFirstReceiveOrPeekClosed instanceof Closed)) {
                                break;
                            } else if (takeFirstReceiveOrPeekClosed.tryResumeReceive(e2, null) != null) {
                                this._subHead++;
                                this.c.unlock();
                                Intrinsics.checkNotNull(takeFirstReceiveOrPeekClosed);
                                takeFirstReceiveOrPeekClosed.completeResumeReceive(e2);
                                z2 = true;
                            }
                        } else {
                            e = e2;
                            break;
                        }
                    }
                    this.c.unlock();
                } catch (Throwable th) {
                    this.c.unlock();
                    throw th;
                }
            }
            this.c.unlock();
            if (e != null) {
                close(e.closeCause);
            }
            return z2;
        }

        public final Object e() {
            long j = this._subHead;
            Closed<?> closedForReceive = this.d.getClosedForReceive();
            if (j >= ArrayBroadcastChannel.access$getTail$p(this.d)) {
                if (closedForReceive == null) {
                    closedForReceive = getClosedForReceive();
                }
                return closedForReceive != null ? closedForReceive : AbstractChannelKt.POLL_FAILED;
            }
            Object access$elementAt = ArrayBroadcastChannel.access$elementAt(this.d, j);
            Closed<?> closedForReceive2 = getClosedForReceive();
            return closedForReceive2 != null ? closedForReceive2 : access$elementAt;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean isBufferAlwaysEmpty() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean isBufferEmpty() {
            return this._subHead >= ArrayBroadcastChannel.access$getTail$p(this.d);
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object pollInternal() {
            /*
                r8 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r8.c
                r0.lock()
                java.lang.Object r1 = r8.e()     // Catch:{ all -> 0x0042 }
                boolean r2 = r1 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x0042 }
                r3 = 1
                if (r2 == 0) goto L_0x000f
                goto L_0x0013
            L_0x000f:
                kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x0042 }
                if (r1 != r2) goto L_0x0015
            L_0x0013:
                r2 = 0
                goto L_0x001d
            L_0x0015:
                long r4 = r8._subHead     // Catch:{ all -> 0x0042 }
                r6 = 1
                long r4 = r4 + r6
                r8._subHead = r4     // Catch:{ all -> 0x0042 }
                r2 = 1
            L_0x001d:
                r0.unlock()
                boolean r0 = r1 instanceof kotlinx.coroutines.channels.Closed
                r4 = 0
                if (r0 != 0) goto L_0x0027
                r0 = r4
                goto L_0x0028
            L_0x0027:
                r0 = r1
            L_0x0028:
                kotlinx.coroutines.channels.Closed r0 = (kotlinx.coroutines.channels.Closed) r0
                if (r0 == 0) goto L_0x0031
                java.lang.Throwable r0 = r0.closeCause
                r8.close(r0)
            L_0x0031:
                boolean r0 = r8.d()
                if (r0 == 0) goto L_0x0038
                goto L_0x0039
            L_0x0038:
                r3 = r2
            L_0x0039:
                if (r3 == 0) goto L_0x0041
                kotlinx.coroutines.channels.ArrayBroadcastChannel<E> r0 = r8.d
                r2 = 3
                kotlinx.coroutines.channels.ArrayBroadcastChannel.e(r0, r4, r4, r2)
            L_0x0041:
                return r1
            L_0x0042:
                r1 = move-exception
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.a.pollInternal():java.lang.Object");
        }

        /* JADX INFO: finally extract failed */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        @Nullable
        public Object pollSelectInternal(@NotNull SelectInstance<?> selectInstance) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Object e = e();
                boolean z = false;
                boolean z2 = true;
                if (!(e instanceof Closed)) {
                    if (e != AbstractChannelKt.POLL_FAILED) {
                        if (!selectInstance.trySelect()) {
                            e = SelectKt.getALREADY_SELECTED();
                        } else {
                            this._subHead++;
                            z = true;
                        }
                    }
                }
                reentrantLock.unlock();
                Closed closed = (Closed) (!(e instanceof Closed) ? null : e);
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (!d()) {
                    z2 = z;
                }
                if (z2) {
                    ArrayBroadcastChannel.e(this.d, null, null, 3);
                }
                return e;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public ArrayBroadcastChannel(int i) {
        super(null);
        this.f = i;
        if (i < 1 ? false : true) {
            this.c = new ReentrantLock();
            this.d = new Object[i];
            this._head = 0;
            this._tail = 0;
            this._size = 0;
            this.e = ConcurrentKt.subscriberList();
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("ArrayBroadcastChannel capacity must be at least 1, but ", i, " was specified").toString());
    }

    public static final Object access$elementAt(ArrayBroadcastChannel arrayBroadcastChannel, long j) {
        return arrayBroadcastChannel.d[(int) (j % ((long) arrayBroadcastChannel.f))];
    }

    public static final long access$getTail$p(ArrayBroadcastChannel arrayBroadcastChannel) {
        return arrayBroadcastChannel._tail;
    }

    public static final void access$setTail$p(ArrayBroadcastChannel arrayBroadcastChannel, long j) {
        arrayBroadcastChannel._tail = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel$a<E>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void e(ArrayBroadcastChannel arrayBroadcastChannel, a aVar, a aVar2, int i) {
        Send takeFirstSendOrPeekClosed;
        if ((i & 1) != 0) {
            aVar = null;
        }
        if ((i & 2) != 0) {
            aVar2 = null;
        }
        while (true) {
            ReentrantLock reentrantLock = arrayBroadcastChannel.c;
            reentrantLock.lock();
            if (aVar != null) {
                try {
                    aVar._subHead = arrayBroadcastChannel._tail;
                    boolean isEmpty = arrayBroadcastChannel.e.isEmpty();
                    arrayBroadcastChannel.e.add(aVar);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (aVar2 != null) {
                arrayBroadcastChannel.e.remove(aVar2);
                if (arrayBroadcastChannel._head != aVar2._subHead) {
                    reentrantLock.unlock();
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            for (a<E> aVar3 : arrayBroadcastChannel.e) {
                j = e.coerceAtMost(j, aVar3._subHead);
            }
            long j2 = arrayBroadcastChannel._tail;
            long j3 = arrayBroadcastChannel._head;
            long coerceAtMost = e.coerceAtMost(j, j2);
            if (coerceAtMost <= j3) {
                reentrantLock.unlock();
                return;
            }
            int i2 = arrayBroadcastChannel._size;
            while (j3 < coerceAtMost) {
                Object[] objArr = arrayBroadcastChannel.d;
                int i3 = arrayBroadcastChannel.f;
                objArr[(int) (j3 % ((long) i3))] = null;
                boolean z = i2 >= i3;
                j3++;
                arrayBroadcastChannel._head = j3;
                i2--;
                arrayBroadcastChannel._size = i2;
                if (z) {
                    do {
                        takeFirstSendOrPeekClosed = arrayBroadcastChannel.takeFirstSendOrPeekClosed();
                        if (takeFirstSendOrPeekClosed != null && !(takeFirstSendOrPeekClosed instanceof Closed)) {
                            Intrinsics.checkNotNull(takeFirstSendOrPeekClosed);
                        }
                    } while (takeFirstSendOrPeekClosed.tryResumeSend(null) == null);
                    arrayBroadcastChannel.d[(int) (j2 % ((long) arrayBroadcastChannel.f))] = takeFirstSendOrPeekClosed.getPollResult();
                    arrayBroadcastChannel._size = i2 + 1;
                    arrayBroadcastChannel._tail = j2 + 1;
                    reentrantLock.unlock();
                    Intrinsics.checkNotNull(takeFirstSendOrPeekClosed);
                    takeFirstSendOrPeekClosed.completeResumeSend();
                    arrayBroadcastChannel.d();
                    aVar = null;
                    aVar2 = null;
                }
            }
            reentrantLock.unlock();
            return;
        }
    }

    /* renamed from: c */
    public final boolean cancel(Throwable th) {
        boolean close = close(th);
        for (a<E> aVar : this.e) {
            aVar.cancel(th);
        }
        return close;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable th) {
        if (!super.close(th)) {
            return false;
        }
        d();
        return true;
    }

    public final void d() {
        boolean z = false;
        boolean z2 = false;
        for (a<E> aVar : this.e) {
            if (aVar.d()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            e(this, null, null, 3);
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public String getBufferDebugString() {
        StringBuilder L = a2.b.a.a.a.L("(buffer:capacity=");
        L.append(this.d.length);
        L.append(",size=");
        return a2.b.a.a.a.i(L, this._size, ')');
    }

    public final int getCapacity() {
        return this.f;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean isBufferFull() {
        return this._size >= this.f;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public Object offerInternal(E e2) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this._size;
            if (i >= this.f) {
                Symbol symbol = AbstractChannelKt.OFFER_FAILED;
                reentrantLock.unlock();
                return symbol;
            }
            long j = this._tail;
            this.d[(int) (j % ((long) this.f))] = e2;
            this._size = i + 1;
            this._tail = j + 1;
            reentrantLock.unlock();
            d();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    public Object offerSelectInternal(E e2, @NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this._size;
            if (i >= this.f) {
                Symbol symbol = AbstractChannelKt.OFFER_FAILED;
                reentrantLock.unlock();
                return symbol;
            } else if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            } else {
                long j = this._tail;
                this.d[(int) (j % ((long) this.f))] = e2;
                this._size = i + 1;
                this._tail = j + 1;
                reentrantLock.unlock();
                d();
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        a aVar = new a(this);
        e(this, aVar, null, 2);
        return aVar;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(@Nullable CancellationException cancellationException) {
        cancel(cancellationException);
    }
}
