package kotlinx.coroutines.selects;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004OP=CB\u0015\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bM\u0010NJ\u0017\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u0004\u0018\u00010\u00152\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J5\u0010/\u001a\u00020\u000e*\u00020,2\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150-H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100JG\u0010/\u001a\u00020\u000e\"\u0004\b\u0001\u00101*\b\u0012\u0004\u0012\u00028\u0001022\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001503H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00104J[\u0010/\u001a\u00020\u000e\"\u0004\b\u0001\u00105\"\u0004\b\u0002\u00101*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002062\u0006\u00107\u001a\u00028\u00012\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001503H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00108J8\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u0002092\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150-H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010>R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\u001e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010 R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010H\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K\u0002\u0004\n\u0002\b\u0019¨\u0006Q"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", OkListener.KEY_EXCEPTION, "resumeSelectWithException", "(Ljava/lang/Throwable;)V", "", "getResult", "()Ljava/lang/Object;", "e", "handleBuilderException", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "block", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "timeMillis", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "c", "()V", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "isSelected", "d", "Lkotlin/coroutines/Continuation;", "uCont", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/Continuation;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    public volatile Object _parentHandle = null;
    public volatile Object _result = SelectKt.c;
    public volatile Object _state = SelectKt.getNOT_SELECTED();
    public final Continuation<R> d;

    public static final class a extends AtomicOp<Object> {
        public final long b = SelectKt.e.next();
        @JvmField
        @NotNull
        public final SelectBuilderImpl<?> c;
        @JvmField
        @NotNull
        public final AtomicDesc d;

        public a(@NotNull SelectBuilderImpl<?> selectBuilderImpl, @NotNull AtomicDesc atomicDesc) {
            this.c = selectBuilderImpl;
            this.d = atomicDesc;
            atomicDesc.setAtomicOp(this);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(@Nullable Object obj, @Nullable Object obj2) {
            boolean z = obj2 == null;
            if (SelectBuilderImpl.e.compareAndSet(this.c, this, z ? null : SelectKt.getNOT_SELECTED()) && z) {
                this.c.c();
            }
            this.d.complete(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long getOpSequence() {
            return this.b;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        @Nullable
        public Object prepare(@Nullable Object obj) {
            Object obj2;
            if (obj == null) {
                SelectBuilderImpl<?> selectBuilderImpl = this.c;
                while (true) {
                    Object obj3 = selectBuilderImpl._state;
                    obj2 = null;
                    if (obj3 != this) {
                        if (!(obj3 instanceof OpDescriptor)) {
                            if (obj3 != SelectKt.getNOT_SELECTED()) {
                                obj2 = SelectKt.getALREADY_SELECTED();
                                break;
                            }
                            if (SelectBuilderImpl.e.compareAndSet(this.c, SelectKt.getNOT_SELECTED(), this)) {
                                break;
                            }
                        } else {
                            ((OpDescriptor) obj3).perform(this.c);
                        }
                    } else {
                        break;
                    }
                }
                if (obj2 != null) {
                    return obj2;
                }
            }
            try {
                return this.d.prepare(this);
            } catch (Throwable th) {
                if (obj == null) {
                    SelectBuilderImpl.e.compareAndSet(this.c, this, SelectKt.getNOT_SELECTED());
                }
                throw th;
            }
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @NotNull
        public String toString() {
            return a2.b.a.a.a.k(a2.b.a.a.a.L("AtomicSelectOp(sequence="), this.b, ')');
        }
    }

    public static final class b extends LockFreeLinkedListNode {
        @JvmField
        @NotNull
        public final DisposableHandle d;

        public b(@NotNull DisposableHandle disposableHandle) {
            this.d = disposableHandle;
        }
    }

    public static final class c extends OpDescriptor {
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode.PrepareOp a;

        public c(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.a = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @Nullable
        public AtomicOp<?> getAtomicOp() {
            return this.a.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @Nullable
        public Object perform(@Nullable Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
            this.a.finishPrepare();
            Object decide = this.a.getAtomicOp().decide(null);
            SelectBuilderImpl.e.compareAndSet(selectBuilderImpl, this, decide == null ? this.a.desc : SelectKt.getNOT_SELECTED());
            return decide;
        }
    }

    public final class d extends JobCancellingNode<Job> {
        public d(@NotNull Job job) {
            super(job);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("SelectOnCancelling[");
            L.append(SelectBuilderImpl.this);
            L.append(']');
            return L.toString();
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void invoke(@Nullable Throwable th) {
            if (SelectBuilderImpl.this.trySelect()) {
                SelectBuilderImpl.this.resumeSelectWithException(this.job.getCancellationException());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        this.d = continuation;
    }

    public final void c() {
        DisposableHandle disposableHandle = (DisposableHandle) this._parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Object next = getNext();
        Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof b) {
                ((b) lockFreeLinkedListNode).d.dispose();
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(@NotNull DisposableHandle disposableHandle) {
        b bVar = new b(disposableHandle);
        if (!isSelected()) {
            addLast(bVar);
            if (!isSelected()) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.d;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @NotNull
    public Continuation<R> getCompletion() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.d.getContext();
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        Job job;
        if (!isSelected() && (job = (Job) getContext().get(Job.Key)) != null) {
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new d(job), 2, null);
            this._parentHandle = invokeOnCompletion$default;
            if (isSelected()) {
                invokeOnCompletion$default.dispose();
            }
        }
        Object obj = this._result;
        if (obj == SelectKt.c) {
            if (f.compareAndSet(this, SelectKt.c, t6.p.a.a.getCOROUTINE_SUSPENDED())) {
                return t6.p.a.a.getCOROUTINE_SUSPENDED();
            }
            obj = this._result;
        }
        if (obj == SelectKt.d) {
            throw new IllegalStateException("Already resumed");
        } else if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        } else {
            throw ((CompletedExceptionally) obj).cause;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @PublishedApi
    public final void handleBuilderException(@NotNull Throwable th) {
        if (trySelect()) {
            Result.Companion companion = Result.Companion;
            resumeWith(Result.m242constructorimpl(ResultKt.createFailure(th)));
        } else if (!(th instanceof CancellationException)) {
            Object result = getResult();
            if (!(result instanceof CompletedExceptionally) || ((CompletedExceptionally) result).cause != th) {
                CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.getNOT_SELECTED()) {
                return false;
            }
            if (!(obj instanceof OpDescriptor)) {
                return true;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j > 0) {
            disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(j, new Runnable(this, function1) { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
                public final /* synthetic */ SelectBuilderImpl a;
                public final /* synthetic */ Function1 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (this.a.trySelect()) {
                        CancellableKt.startCoroutineCancellable(this.b, this.a.getCompletion());
                    }
                }
            }, getContext()));
        } else if (trySelect()) {
            UndispatchedKt.startCoroutineUnintercepted(function1, getCompletion());
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @Nullable
    public Object performAtomicTrySelect(@NotNull AtomicDesc atomicDesc) {
        return new a(this, atomicDesc).perform(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(@NotNull Throwable th) {
        while (true) {
            Object obj = this._result;
            if (obj == SelectKt.c) {
                if (f.compareAndSet(this, SelectKt.c, new CompletedExceptionally(th, false, 2, null))) {
                    return;
                }
            } else if (obj != t6.p.a.a.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else if (f.compareAndSet(this, t6.p.a.a.getCOROUTINE_SUSPENDED(), SelectKt.d)) {
                Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.d);
                Result.Companion companion = Result.Companion;
                intercepted.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(th)));
                return;
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        while (true) {
            Object obj2 = this._result;
            if (obj2 == SelectKt.c) {
                if (f.compareAndSet(this, SelectKt.c, CompletionStateKt.toState$default(obj, null, 1, null))) {
                    return;
                }
            } else if (obj2 != t6.p.a.a.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else if (f.compareAndSet(this, t6.p.a.a.getCOROUTINE_SUSPENDED(), SelectKt.d)) {
                if (Result.m247isFailureimpl(obj)) {
                    Continuation<R> continuation = this.d;
                    Throwable r4 = Result.m245exceptionOrNullimpl(obj);
                    Intrinsics.checkNotNull(r4);
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(r4)));
                    return;
                }
                this.d.resumeWith(obj);
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SelectInstance(state=");
        L.append(this._state);
        L.append(", result=");
        return a2.b.a.a.a.q(L, this._result, ')');
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object trySelectOther = trySelectOther(null);
        if (trySelectOther == CancellableContinuationImplKt.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        throw new IllegalStateException(a2.b.a.a.a.b3("Unexpected trySelectIdempotent result ", trySelectOther).toString());
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @Nullable
    public Object trySelectOther(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.getNOT_SELECTED()) {
                if (prepareOp == null) {
                    if (e.compareAndSet(this, SelectKt.getNOT_SELECTED(), null)) {
                        break;
                    }
                } else {
                    c cVar = new c(prepareOp);
                    if (e.compareAndSet(this, SelectKt.getNOT_SELECTED(), cVar)) {
                        Object perform = cVar.perform(this);
                        if (perform != null) {
                            return perform;
                        }
                    }
                }
            } else if (obj instanceof OpDescriptor) {
                if (prepareOp != null) {
                    AtomicOp<?> atomicOp = prepareOp.getAtomicOp();
                    if ((atomicOp instanceof a) && ((a) atomicOp).c == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    } else if (atomicOp.isEarlierThan((OpDescriptor) obj)) {
                        return AtomicKt.RETRY_ATOMIC;
                    }
                }
                ((OpDescriptor) obj).perform(this);
            } else if (prepareOp != null && obj == prepareOp.desc) {
                return CancellableContinuationImplKt.RESUME_TOKEN;
            } else {
                return null;
            }
        }
        c();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectClause0.registerSelectClause0(this, function1);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause2.registerSelectClause2(this, p, function2);
    }
}
