package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKAttachments;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007IJ\u0010KLMNB)\u0012 \u0010F\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!\u0018\u00010Dj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`E¢\u0006\u0004\bG\u0010HJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u0004\u0018\u00010\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\fJ\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001a\u0010\u0006J\u0019\u0010\u001d\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001d\u001a\u00020!2\u000e\u0010\u001c\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` ¢\u0006\u0004\b\u001d\u0010\"J\u0019\u0010$\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0004\b#\u0010\u001eJ\u0017\u0010&\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0013H\u0014¢\u0006\u0004\b&\u0010'J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0002¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0004¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010.H\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020!H\u0014¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020!H\u0014¢\u0006\u0004\b3\u00102R\u0016\u00106\u001a\u00020\u00138D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u00107\u001a\u00020\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0016\u00108\u001a\u00020\u00138$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b8\u00105R\u0016\u00109\u001a\u00020\u00138D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b9\u00105R\u0016\u0010:\u001a\u00020\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b:\u00105R\"\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170;8F@\u0006ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\u00138$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b?\u00105R\u0019\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000;8F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010=R\u001b\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000;8F@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010=\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006O"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "", "pollInternal", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "", "receiveMode", "c", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "receiveOrNull", "Lkotlinx/coroutines/channels/ValueOrClosed;", "receiveOrClosed-ZYPwvRU", "receiveOrClosed", VKAttachments.TYPE_POLL, "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal$kotlinx_coroutines_core", "cancelInternal", "wasClosed", "onCancelIdempotent", "(Z)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "describeTryPoll", "()Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "onReceiveEnqueued", "()V", "onReceiveDequeued", "getHasReceiveOrClosed", "()Z", "hasReceiveOrClosed", "isEmpty", "isBufferAlwaysEmpty", "isEmptyImpl", "isClosedForReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceiveOrClosed", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "isBufferEmpty", "getOnReceive", "onReceive", "getOnReceiveOrNull", "onReceiveOrNull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "d", "e", "f", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00072\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", PublicConstantsKt.FAILURE, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "onPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "", "onRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (!(lockFreeLinkedListNode instanceof Send)) {
                return AbstractChannelKt.POLL_FAILED;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public Object onPrepare(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            LockFreeLinkedListNode lockFreeLinkedListNode = prepareOp.affected;
            Objects.requireNonNull(lockFreeLinkedListNode, "null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            Symbol tryResumeSend = ((Send) lockFreeLinkedListNode).tryResumeSend(prepareOp);
            if (tryResumeSend == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            Object obj = AtomicKt.RETRY_ATOMIC;
            if (tryResumeSend == obj) {
                return obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void onRemoved(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            Objects.requireNonNull(lockFreeLinkedListNode, "null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            ((Send) lockFreeLinkedListNode).undeliveredElement();
        }
    }

    public static final class a<E> implements ChannelIterator<E> {
        @Nullable
        public Object a = AbstractChannelKt.POLL_FAILED;
        @JvmField
        @NotNull
        public final AbstractChannel<E> b;

        public a(@NotNull AbstractChannel<E> abstractChannel) {
            this.b = abstractChannel;
        }

        public final boolean a(Object obj) {
            if (!(obj instanceof Closed)) {
                return true;
            }
            Closed closed = (Closed) obj;
            if (closed.closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> continuation) {
            Object obj = this.a;
            Symbol symbol = AbstractChannelKt.POLL_FAILED;
            if (obj != symbol) {
                return Boxing.boxBoolean(a(obj));
            }
            Object pollInternal = this.b.pollInternal();
            this.a = pollInternal;
            if (pollInternal != symbol) {
                return Boxing.boxBoolean(a(pollInternal));
            }
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            d dVar = new d(this, orCreateCancellableContinuation);
            while (true) {
                if (AbstractChannel.access$enqueueReceive(this.b, dVar)) {
                    AbstractChannel.access$removeReceiveOnCancel(this.b, orCreateCancellableContinuation, dVar);
                    break;
                }
                Object pollInternal2 = this.b.pollInternal();
                this.a = pollInternal2;
                if (pollInternal2 instanceof Closed) {
                    Closed closed = (Closed) pollInternal2;
                    if (closed.closeCause == null) {
                        Boolean boxBoolean = Boxing.boxBoolean(false);
                        Result.Companion companion = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m242constructorimpl(boxBoolean));
                    } else {
                        Throwable receiveException = closed.getReceiveException();
                        Result.Companion companion2 = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(receiveException)));
                    }
                } else if (pollInternal2 != AbstractChannelKt.POLL_FAILED) {
                    Boolean boxBoolean2 = Boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.b.onUndeliveredElement;
                    orCreateCancellableContinuation.resume(boxBoolean2, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, pollInternal2, orCreateCancellableContinuation.getContext()) : null);
                }
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @JvmName(name = "next")
        @Nullable
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(@NotNull Continuation<? super E> continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.a;
            if (!(e instanceof Closed)) {
                Symbol symbol = AbstractChannelKt.POLL_FAILED;
                if (e != symbol) {
                    this.a = symbol;
                    return e;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw StackTraceRecoveryKt.recoverStackTrace(e.getReceiveException());
        }
    }

    public static class b<E> extends Receive<E> {
        @JvmField
        @NotNull
        public final CancellableContinuation<Object> d;
        @JvmField
        public final int e;

        public b(@NotNull CancellableContinuation<Object> cancellableContinuation, int i) {
            this.d = cancellableContinuation;
            this.e = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e2) {
            this.d.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            int i = this.e;
            if (i == 1 && closed.closeCause == null) {
                CancellableContinuation<Object> cancellableContinuation = this.d;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m242constructorimpl(null));
            } else if (i == 2) {
                CancellableContinuation<Object> cancellableContinuation2 = this.d;
                ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
                ValueOrClosed r3 = ValueOrClosed.m501boximpl(ValueOrClosed.m502constructorimpl(new ValueOrClosed.Closed(closed.closeCause)));
                Result.Companion companion3 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m242constructorimpl(r3));
            } else {
                CancellableContinuation<Object> cancellableContinuation3 = this.d;
                Throwable receiveException = closed.getReceiveException();
                Result.Companion companion4 = Result.Companion;
                cancellableContinuation3.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(receiveException)));
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ReceiveElement@");
            L.append(DebugStringsKt.getHexAddress(this));
            L.append("[receiveMode=");
            return a2.b.a.a.a.i(L, this.e, ']');
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public Symbol tryResumeReceive(E e2, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            ValueOrClosed valueOrClosed;
            CancellableContinuation<Object> cancellableContinuation = this.d;
            if (this.e != 2) {
                valueOrClosed = e2;
            } else {
                ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                valueOrClosed = ValueOrClosed.m501boximpl(ValueOrClosed.m502constructorimpl(e2));
            }
            if (cancellableContinuation.tryResume(valueOrClosed, prepareOp != null ? prepareOp.desc : null, resumeOnCancellationFun(e2)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    public static final class c<E> extends b<E> {
        @JvmField
        @NotNull
        public final Function1<E, Unit> f;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super E, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull CancellableContinuation<Object> cancellableContinuation, int i, @NotNull Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.f = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e) {
            return OnUndeliveredElementKt.bindCancellationFun(this.f, e, this.d.getContext());
        }
    }

    public static class d<E> extends Receive<E> {
        @JvmField
        @NotNull
        public final a<E> d;
        @JvmField
        @NotNull
        public final CancellableContinuation<Boolean> e;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull a<E> aVar, @NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.d = aVar;
            this.e = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e2) {
            this.d.a = e2;
            this.e.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e2) {
            Function1<E, Unit> function1 = this.d.b.onUndeliveredElement;
            if (function1 != null) {
                return OnUndeliveredElementKt.bindCancellationFun(function1, e2, this.e.getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            Object obj;
            if (closed.closeCause == null) {
                obj = CancellableContinuation.DefaultImpls.tryResume$default(this.e, Boolean.FALSE, null, 2, null);
            } else {
                obj = this.e.tryResumeWithException(closed.getReceiveException());
            }
            if (obj != null) {
                this.d.a = closed;
                this.e.completeResume(obj);
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ReceiveHasNext@");
            L.append(DebugStringsKt.getHexAddress(this));
            return L.toString();
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public Symbol tryResumeReceive(E e2, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            if (this.e.tryResume(Boolean.TRUE, prepareOp != null ? prepareOp.desc : null, resumeOnCancellationFun(e2)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    public static final class e<R, E> extends Receive<E> implements DisposableHandle {
        @JvmField
        @NotNull
        public final AbstractChannel<E> d;
        @JvmField
        @NotNull
        public final SelectInstance<R> e;
        @JvmField
        @NotNull
        public final Function2<Object, Continuation<? super R>, Object> f;
        @JvmField
        public final int g;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull AbstractChannel<E> abstractChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
            this.d = abstractChannel;
            this.e = selectInstance;
            this.f = function2;
            this.g = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e2) {
            ValueOrClosed valueOrClosed;
            Function2<Object, Continuation<? super R>, Object> function2 = this.f;
            if (this.g == 2) {
                ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                valueOrClosed = ValueOrClosed.m501boximpl(ValueOrClosed.m502constructorimpl(e2));
            } else {
                valueOrClosed = e2;
            }
            CancellableKt.startCoroutineCancellable(function2, valueOrClosed, this.e.getCompletion(), resumeOnCancellationFun(e2));
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (remove()) {
                this.d.onReceiveDequeued();
            }
        }

        @Override // kotlinx.coroutines.channels.Receive
        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e2) {
            Function1<E, Unit> function1 = this.d.onUndeliveredElement;
            if (function1 != null) {
                return OnUndeliveredElementKt.bindCancellationFun(function1, e2, this.e.getCompletion().getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            if (this.e.trySelect()) {
                int i = this.g;
                if (i == 0) {
                    this.e.resumeSelectWithException(closed.getReceiveException());
                } else if (i != 1) {
                    if (i == 2) {
                        Function2<Object, Continuation<? super R>, Object> function2 = this.f;
                        ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                        CancellableKt.startCoroutineCancellable$default(function2, ValueOrClosed.m501boximpl(ValueOrClosed.m502constructorimpl(new ValueOrClosed.Closed(closed.closeCause))), this.e.getCompletion(), null, 4, null);
                    }
                } else if (closed.closeCause == null) {
                    CancellableKt.startCoroutineCancellable$default(this.f, null, this.e.getCompletion(), null, 4, null);
                } else {
                    this.e.resumeSelectWithException(closed.getReceiveException());
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ReceiveSelect@");
            L.append(DebugStringsKt.getHexAddress(this));
            L.append('[');
            L.append(this.e);
            L.append(",receiveMode=");
            return a2.b.a.a.a.i(L, this.g, ']');
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public Symbol tryResumeReceive(E e2, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.e.trySelectOther(prepareOp);
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", i = {0, 0}, l = {624}, m = "receiveOrClosed-ZYPwvRU", n = {"this", "result"}, s = {"L$0", "L$1"})
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ AbstractChannel c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(AbstractChannel abstractChannel, Continuation continuation) {
            super(continuation);
            this.c = abstractChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.mo500receiveOrClosedZYPwvRU(this);
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    public static final boolean access$enqueueReceive(AbstractChannel abstractChannel, Receive receive) {
        boolean enqueueReceiveInternal = abstractChannel.enqueueReceiveInternal(receive);
        if (enqueueReceiveInternal) {
            abstractChannel.onReceiveEnqueued();
        }
        return enqueueReceiveInternal;
    }

    public static final void access$registerSelectReceiveMode(AbstractChannel abstractChannel, SelectInstance selectInstance, int i, Function2 function2) {
        Object obj;
        Objects.requireNonNull(abstractChannel);
        while (!selectInstance.isSelected()) {
            if (abstractChannel.isEmptyImpl()) {
                e eVar = new e(abstractChannel, selectInstance, function2, i);
                boolean enqueueReceiveInternal = abstractChannel.enqueueReceiveInternal(eVar);
                if (enqueueReceiveInternal) {
                    abstractChannel.onReceiveEnqueued();
                }
                if (enqueueReceiveInternal) {
                    selectInstance.disposeOnSelect(eVar);
                }
                if (enqueueReceiveInternal) {
                    return;
                }
            } else {
                Object pollSelectInternal = abstractChannel.pollSelectInternal(selectInstance);
                if (pollSelectInternal != SelectKt.getALREADY_SELECTED()) {
                    if (!(pollSelectInternal == AbstractChannelKt.POLL_FAILED || pollSelectInternal == AtomicKt.RETRY_ATOMIC)) {
                        boolean z = pollSelectInternal instanceof Closed;
                        if (z) {
                            if (i == 0) {
                                throw StackTraceRecoveryKt.recoverStackTrace(((Closed) pollSelectInternal).getReceiveException());
                            } else if (i == 1) {
                                Closed closed = (Closed) pollSelectInternal;
                                if (closed.closeCause != null) {
                                    throw StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
                                } else if (selectInstance.trySelect()) {
                                    UndispatchedKt.startCoroutineUnintercepted(function2, null, selectInstance.getCompletion());
                                }
                            } else if (i == 2 && selectInstance.trySelect()) {
                                ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                                UndispatchedKt.startCoroutineUnintercepted(function2, ValueOrClosed.m501boximpl(ValueOrClosed.m502constructorimpl(new ValueOrClosed.Closed(((Closed) pollSelectInternal).closeCause))), selectInstance.getCompletion());
                            }
                        } else if (i == 2) {
                            ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
                            if (z) {
                                obj = ValueOrClosed.m502constructorimpl(new ValueOrClosed.Closed(((Closed) pollSelectInternal).closeCause));
                            } else {
                                obj = ValueOrClosed.m502constructorimpl(pollSelectInternal);
                            }
                            UndispatchedKt.startCoroutineUnintercepted(function2, ValueOrClosed.m501boximpl(obj), selectInstance.getCompletion());
                        } else {
                            UndispatchedKt.startCoroutineUnintercepted(function2, pollSelectInternal, selectInstance.getCompletion());
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static final void access$removeReceiveOnCancel(AbstractChannel abstractChannel, CancellableContinuation cancellableContinuation, Receive receive) {
        Objects.requireNonNull(abstractChannel);
        cancellableContinuation.invokeOnCancellation(new f(receive));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.AbstractChannel$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> java.lang.Object c(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> r6) {
        /*
            r4 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r6)
            kotlinx.coroutines.CancellableContinuationImpl r0 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r1 = r4.onUndeliveredElement
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>"
            if (r1 != 0) goto L_0x0017
            kotlinx.coroutines.channels.AbstractChannel$b r1 = new kotlinx.coroutines.channels.AbstractChannel$b
            java.util.Objects.requireNonNull(r0, r2)
            r1.<init>(r0, r5)
            goto L_0x0021
        L_0x0017:
            kotlinx.coroutines.channels.AbstractChannel$c r1 = new kotlinx.coroutines.channels.AbstractChannel$c
            java.util.Objects.requireNonNull(r0, r2)
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r2 = r4.onUndeliveredElement
            r1.<init>(r0, r5, r2)
        L_0x0021:
            boolean r5 = access$enqueueReceive(r4, r1)
            if (r5 == 0) goto L_0x002b
            access$removeReceiveOnCancel(r4, r0, r1)
            goto L_0x0055
        L_0x002b:
            java.lang.Object r5 = r4.pollInternal()
            boolean r2 = r5 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L_0x0039
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5
            r1.resumeReceiveClosed(r5)
            goto L_0x0055
        L_0x0039:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            if (r5 == r2) goto L_0x0021
            int r2 = r1.e
            r3 = 2
            if (r2 == r3) goto L_0x0044
            r2 = r5
            goto L_0x004e
        L_0x0044:
            kotlinx.coroutines.channels.ValueOrClosed$Companion r2 = kotlinx.coroutines.channels.ValueOrClosed.Companion
            java.lang.Object r2 = kotlinx.coroutines.channels.ValueOrClosed.m502constructorimpl(r5)
            kotlinx.coroutines.channels.ValueOrClosed r2 = kotlinx.coroutines.channels.ValueOrClosed.m501boximpl(r2)
        L_0x004e:
            kotlin.jvm.functions.Function1 r5 = r1.resumeOnCancellationFun(r5)
            r0.resume(r2, r5)
        L_0x0055:
            java.lang.Object r5 = r0.getResult()
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            if (r5 != r0) goto L_0x0062
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6)
        L_0x0062:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.c(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    /* renamed from: cancelInternal$kotlinx_coroutines_core */
    public final boolean cancel(@Nullable Throwable th) {
        boolean close = close(th);
        onCancelIdempotent(close);
        return close;
    }

    @NotNull
    public final TryPollDesc<E> describeTryPoll() {
        return new TryPollDesc<>(getQueue());
    }

    public boolean enqueueReceiveInternal(@NotNull Receive<? super E> receive) {
        int tryCondAddNext;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysEmpty()) {
            LockFreeLinkedListNode queue = getQueue();
            do {
                prevNode = queue.getPrevNode();
                if (!(!(prevNode instanceof Send))) {
                    return false;
                }
            } while (!prevNode.addNext(receive, queue));
        } else {
            LockFreeLinkedListNode queue2 = getQueue();
            AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 = new LockFreeLinkedListNode.CondAddOp(receive, receive, this) { // from class: kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
                public final /* synthetic */ AbstractChannel b;

                {
                    this.b = r3;
                }

                @Nullable
                public Object prepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
                    if (this.b.isBufferEmpty()) {
                        return null;
                    }
                    return LockFreeLinkedListKt.getCONDITION_FALSE();
                }
            };
            do {
                LockFreeLinkedListNode prevNode2 = queue2.getPrevNode();
                if (!(!(prevNode2 instanceof Send))) {
                    return false;
                }
                tryCondAddNext = prevNode2.tryCondAddNext(receive, queue2, abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1);
                if (tryCondAddNext != 1) {
                }
            } while (tryCondAddNext != 2);
            return false;
        }
        return true;
    }

    public final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<E> getOnReceive() {
        return new SelectClause1<E>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceive$1
            public final /* synthetic */ AbstractChannel a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
                AbstractChannel abstractChannel = this.a;
                Objects.requireNonNull(function2, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
                AbstractChannel.access$registerSelectReceiveMode(abstractChannel, selectInstance, 0, function2);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed() {
        return new SelectClause1<ValueOrClosed<? extends E>>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveOrClosed$1
            public final /* synthetic */ AbstractChannel a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super ValueOrClosed<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
                AbstractChannel abstractChannel = this.a;
                Objects.requireNonNull(function2, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
                AbstractChannel.access$registerSelectReceiveMode(abstractChannel, selectInstance, 2, function2);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<E> getOnReceiveOrNull() {
        return new SelectClause1<E>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveOrNull$1
            public final /* synthetic */ AbstractChannel a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
                AbstractChannel abstractChannel = this.a;
                Objects.requireNonNull(function2, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
                AbstractChannel.access$registerSelectReceiveMode(abstractChannel, selectInstance, 1, function2);
            }
        };
    }

    public abstract boolean isBufferAlwaysEmpty();

    public abstract boolean isBufferEmpty();

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return getClosedForReceive() != null && isBufferEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return isEmptyImpl();
    }

    public final boolean isEmptyImpl() {
        return !(getQueue().getNextNode() instanceof Send) && isBufferEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    public void onCancelIdempotent(boolean z) {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend != null) {
            Object r0 = InlineList.m521constructorimpl$default(null, 1, null);
            while (true) {
                LockFreeLinkedListNode prevNode = closedForSend.getPrevNode();
                if (prevNode instanceof LockFreeLinkedListHead) {
                    break;
                } else if (!prevNode.remove()) {
                    prevNode.helpRemove();
                } else {
                    r0 = InlineList.m526plusUZ7vuAc(r0, (Send) prevNode);
                }
            }
            if (r0 != null) {
                if (!(r0 instanceof ArrayList)) {
                    ((Send) r0).resumeSendClosed(closedForSend);
                    return;
                }
                ArrayList arrayList = (ArrayList) r0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Send) arrayList.get(size)).resumeSendClosed(closedForSend);
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot happen".toString());
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final E poll() {
        E e2 = (E) pollInternal();
        if (e2 == AbstractChannelKt.POLL_FAILED) {
            return null;
        }
        if (e2 instanceof Closed) {
            Throwable th = e2.closeCause;
            if (th == null) {
                e2 = null;
            } else {
                throw StackTraceRecoveryKt.recoverStackTrace(th);
            }
        }
        return e2;
    }

    @Nullable
    public Object pollInternal() {
        while (true) {
            Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            if (takeFirstSendOrPeekClosed.tryResumeSend(null) != null) {
                takeFirstSendOrPeekClosed.completeResumeSend();
                return takeFirstSendOrPeekClosed.getPollResult();
            }
            takeFirstSendOrPeekClosed.undeliveredElement();
        }
    }

    @Nullable
    public Object pollSelectInternal(@NotNull SelectInstance<?> selectInstance) {
        TryPollDesc<E> describeTryPoll = describeTryPoll();
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryPoll);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ((Send) describeTryPoll.getResult()).completeResumeSend();
        return ((Send) describeTryPoll.getResult()).getPollResult();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final Object receive(@NotNull Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED || (pollInternal instanceof Closed)) {
            return c(0, continuation);
        }
        return pollInternal;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.Nullable
    /* renamed from: receiveOrClosed-ZYPwvRU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object mo500receiveOrClosedZYPwvRU(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ValueOrClosed<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel.g
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$g r0 = (kotlinx.coroutines.channels.AbstractChannel.g) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.AbstractChannel$g r0 = new kotlinx.coroutines.channels.AbstractChannel$g
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.d
            kotlinx.coroutines.channels.AbstractChannel r0 = (kotlinx.coroutines.channels.AbstractChannel) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.pollInternal()
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            if (r5 == r2) goto L_0x005b
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.Closed
            if (r0 == 0) goto L_0x0054
            kotlinx.coroutines.channels.ValueOrClosed$Companion r0 = kotlinx.coroutines.channels.ValueOrClosed.Companion
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5
            java.lang.Throwable r5 = r5.closeCause
            kotlinx.coroutines.channels.ValueOrClosed$Closed r0 = new kotlinx.coroutines.channels.ValueOrClosed$Closed
            r0.<init>(r5)
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m502constructorimpl(r0)
            goto L_0x005a
        L_0x0054:
            kotlinx.coroutines.channels.ValueOrClosed$Companion r0 = kotlinx.coroutines.channels.ValueOrClosed.Companion
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m502constructorimpl(r5)
        L_0x005a:
            return r5
        L_0x005b:
            r2 = 2
            r0.d = r4
            r0.e = r5
            r0.b = r3
            java.lang.Object r5 = r4.c(r2, r0)
            if (r5 != r1) goto L_0x0069
            return r1
        L_0x0069:
            kotlinx.coroutines.channels.ValueOrClosed r5 = (kotlinx.coroutines.channels.ValueOrClosed) r5
            java.lang.Object r5 = r5.m511unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.mo500receiveOrClosedZYPwvRU(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED || (pollInternal instanceof Closed)) {
            return c(1, continuation);
        }
        return pollInternal;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @Nullable
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled");
        }
        cancel(cancellationException);
    }

    public final class f extends BeforeResumeCancelHandler {
        public final Receive<?> a;

        public f(@NotNull Receive<?> receive) {
            this.a = receive;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            if (this.a.remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
            return Unit.INSTANCE;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("RemoveReceiveOnCancel[");
            L.append(this.a);
            L.append(']');
            return L.toString();
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public void invoke(@Nullable Throwable th) {
            if (this.a.remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
        }
    }
}
