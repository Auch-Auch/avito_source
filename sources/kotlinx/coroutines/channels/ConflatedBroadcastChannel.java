package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003\u001b./B\u0007¢\u0006\u0004\b,\u0010%B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00028\u0000¢\u0006\u0004\b,\u0010-J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\f2\u0018\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\u0011\u0010\nJ\u001f\u0010\u0011\u001a\u00020\f2\u000e\u0010\u0007\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0019\u0010&\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b#\u0010\u001eR(\u0010+\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BaseAnalyticKt.ANALYTIC_MODULE_OFFER, "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$a;", AuthSource.SEND_ABUSE, "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$a;", "getValueOrNull", "()Ljava/lang/Object;", "valueOrNull", "isFull", "()Z", "isClosedForSend", "getValue", "getValue$annotations", "()V", "value", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "<init>", "(Ljava/lang/Object;)V", AuthSource.BOOKING_ORDER, "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@ExperimentalCoroutinesApi
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
    public static final a d = new a(null);
    public static final Symbol e;
    public static final b<Object> f;
    private volatile Object _state;
    private volatile int _updating;
    private volatile Object onCloseHandler;

    public static final class a {
        @JvmField
        @Nullable
        public final Throwable a;

        public a(@Nullable Throwable th) {
            this.a = th;
        }

        @NotNull
        public final Throwable a() {
            Throwable th = this.a;
            return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
    }

    public static final class b<E> {
        @JvmField
        @Nullable
        public final Object a;
        @JvmField
        @Nullable
        public final c<E>[] b;

        public b(@Nullable Object obj, @Nullable c<E>[] cVarArr) {
            this.a = obj;
            this.b = cVarArr;
        }
    }

    public static final class c<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        public final ConflatedBroadcastChannel<E> e;

        public c(@NotNull ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            super(null);
            this.e = conflatedBroadcastChannel;
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractSendChannel
        @NotNull
        public Object offerInternal(E e2) {
            return super.offerInternal(e2);
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        public void onCancelIdempotent(boolean z) {
            if (z) {
                ConflatedBroadcastChannel.access$closeSubscriber(this.e, this);
            }
        }
    }

    static {
        Symbol symbol = new Symbol("UNDEFINED");
        e = symbol;
        f = new b<>(symbol, null);
    }

    public ConflatedBroadcastChannel() {
        this._state = f;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    public static final void access$closeSubscriber(ConflatedBroadcastChannel conflatedBroadcastChannel, c cVar) {
        Object obj;
        Object obj2;
        c[] cVarArr;
        do {
            obj = conflatedBroadcastChannel._state;
            if (!(obj instanceof a)) {
                if (obj instanceof b) {
                    obj2 = ((b) obj).a;
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                    c<E>[] cVarArr2 = ((b) obj).b;
                    Intrinsics.checkNotNull(cVarArr2);
                    int length = cVarArr2.length;
                    int indexOf = ArraysKt___ArraysKt.indexOf(cVarArr2, cVar);
                    if (length == 1) {
                        cVarArr = null;
                    } else {
                        c[] cVarArr3 = new c[(length - 1)];
                        ArraysKt___ArraysJvmKt.copyInto$default(cVarArr2, cVarArr3, 0, 0, indexOf, 6, (Object) null);
                        ArraysKt___ArraysJvmKt.copyInto$default(cVarArr2, cVarArr3, indexOf, indexOf + 1, 0, 8, (Object) null);
                        cVarArr = cVarArr3;
                    }
                } else {
                    throw new IllegalStateException(a2.b.a.a.a.b3("Invalid state ", obj).toString());
                }
            } else {
                return;
            }
        } while (!a.compareAndSet(conflatedBroadcastChannel, obj, new b(obj2, cVarArr)));
    }

    public static final void access$registerSelectSend(ConflatedBroadcastChannel conflatedBroadcastChannel, SelectInstance selectInstance, Object obj, Function2 function2) {
        Objects.requireNonNull(conflatedBroadcastChannel);
        if (selectInstance.trySelect()) {
            a a3 = conflatedBroadcastChannel.a(obj);
            if (a3 != null) {
                selectInstance.resumeSelectWithException(a3.a());
            } else {
                UndispatchedKt.startCoroutineUnintercepted(function2, conflatedBroadcastChannel, selectInstance.getCompletion());
            }
        }
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public final a a(E e2) {
        Object obj;
        int i = 0;
        if (!b.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    this._updating = 0;
                    return aVar;
                } else if (!(obj instanceof b)) {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                } else if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } finally {
                this._updating = i;
            }
        } while (!a.compareAndSet(this, obj, new b(e2, ((b) obj).b)));
        c<E>[] cVarArr = ((b) obj).b;
        if (cVarArr != null) {
            for (c<E> cVar : cVarArr) {
                cVar.offerInternal(e2);
            }
        }
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean cancel(@Nullable Throwable th) {
        Object obj;
        int i;
        Symbol symbol;
        do {
            obj = this._state;
            if (obj instanceof a) {
                return false;
            }
            if (!(obj instanceof b)) {
                throw new IllegalStateException(a2.b.a.a.a.b3("Invalid state ", obj).toString());
            }
        } while (!a.compareAndSet(this, obj, th == null ? d : new a(th)));
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
        c<E>[] cVarArr = ((b) obj).b;
        if (cVarArr != null) {
            for (c<E> cVar : cVarArr) {
                cVar.close(th);
            }
        }
        Object obj2 = this.onCloseHandler;
        if (!(obj2 == null || obj2 == (symbol = AbstractChannelKt.HANDLER_INVOKED) || !c.compareAndSet(this, obj2, symbol))) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 1)).invoke(th);
        }
        return true;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return new SelectClause2<E, SendChannel<? super E>>(this) { // from class: kotlinx.coroutines.channels.ConflatedBroadcastChannel$onSend$1
            public final /* synthetic */ ConflatedBroadcastChannel a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // kotlinx.coroutines.selects.SelectClause2
            public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, E e2, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
                ConflatedBroadcastChannel.access$registerSelectSend(this.a, selectInstance, e2, function2);
            }
        };
    }

    public final E getValue() {
        Object obj = this._state;
        if (obj instanceof a) {
            Throwable th = ((a) obj).a;
            if (th != null) {
                throw th;
            }
            throw new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        } else if (obj instanceof b) {
            E e2 = (E) ((b) obj).a;
            if (e2 != e) {
                return e2;
            }
            throw new IllegalStateException("No value");
        } else {
            throw new IllegalStateException(a2.b.a.a.a.b3("Invalid state ", obj).toString());
        }
    }

    @Nullable
    public final E getValueOrNull() {
        Object obj = this._state;
        if (obj instanceof a) {
            return null;
        }
        if (obj instanceof b) {
            Symbol symbol = e;
            E e2 = (E) ((b) obj).a;
            if (e2 == symbol) {
                return null;
            }
            return e2;
        }
        throw new IllegalStateException(a2.b.a.a.a.b3("Invalid state ", obj).toString());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException(a2.b.a.a.a.b3("Another handler was already registered: ", obj));
        }
        Object obj2 = this._state;
        if ((obj2 instanceof a) && atomicReferenceFieldUpdater.compareAndSet(this, function1, AbstractChannelKt.HANDLER_INVOKED)) {
            function1.invoke(((a) obj2).a);
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._state instanceof a;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e2) {
        a a3 = a(e2);
        if (a3 == null) {
            return true;
        }
        throw a3.a();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0045 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.channels.ConflatedBroadcastChannel$c */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlinx.coroutines.channels.ConflatedBroadcastChannel$c[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: kotlinx.coroutines.channels.ConflatedBroadcastChannel$c[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: kotlinx.coroutines.channels.ConflatedBroadcastChannel$c[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        Object obj;
        Object obj2;
        c[] cVarArr;
        c cVar = new c(this);
        do {
            obj = this._state;
            if (obj instanceof a) {
                cVar.close(((a) obj).a);
                return cVar;
            } else if (obj instanceof b) {
                b bVar = (b) obj;
                Object obj3 = bVar.a;
                if (obj3 != e) {
                    cVar.offerInternal(obj3);
                }
                obj2 = bVar.a;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                c<E>[] cVarArr2 = ((b) obj).b;
                if (cVarArr2 == null) {
                    cVarArr = new c[1];
                    for (int i = 0; i < 1; i++) {
                        cVarArr[i] = cVar;
                    }
                } else {
                    cVarArr = (c[]) ArraysKt___ArraysJvmKt.plus(cVarArr2, cVar);
                }
            } else {
                throw new IllegalStateException(a2.b.a.a.a.b3("Invalid state ", obj).toString());
            }
        } while (!a.compareAndSet(this, obj, new b(obj2, cVarArr)));
        return cVar;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e2, @NotNull Continuation<? super Unit> continuation) {
        a a3 = a(e2);
        if (a3 != null) {
            throw a3.a();
        } else if (a3 == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            return a3;
        } else {
            return Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(@Nullable CancellationException cancellationException) {
        cancel(cancellationException);
    }

    public ConflatedBroadcastChannel(E e2) {
        this();
        a.lazySet(this, new b(e2, null));
    }
}
