package kotlinx.coroutines.sync;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlParams;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0006#$%&'(B\u000f\u0012\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJT\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00058@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "", UrlParams.OWNER, "", "tryLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "holdsLock", "unlock", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "isLocked", "()Z", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "locked", "<init>", "(Z)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "d", "e", "f", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    public volatile Object _state;

    public final class a extends c {
        @JvmField
        @NotNull
        public final CancellableContinuation<Unit> e;

        /* renamed from: kotlinx.coroutines.sync.MutexImpl$a$a  reason: collision with other inner class name */
        public static final class C0517a extends Lambda implements Function1<Throwable, Unit> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0517a(a aVar) {
                super(1);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                a aVar = this.a;
                MutexImpl.this.unlock(aVar.d);
                return Unit.INSTANCE;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@Nullable Object obj, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(MutexImpl.this, obj);
            this.e = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.c
        public void c(@NotNull Object obj) {
            this.e.completeResume(obj);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.c
        @Nullable
        public Object d() {
            return this.e.tryResume(Unit.INSTANCE, null, new C0517a(this));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("LockCont[");
            L.append(this.d);
            L.append(", ");
            L.append(this.e);
            L.append("] for ");
            L.append(MutexImpl.this);
            return L.toString();
        }
    }

    public final class b<R> extends c {
        @JvmField
        @NotNull
        public final SelectInstance<R> e;
        @JvmField
        @NotNull
        public final Function2<Mutex, Continuation<? super R>, Object> f;

        public static final class a extends Lambda implements Function1<Throwable, Unit> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(1);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                b bVar = this.a;
                MutexImpl.this.unlock(bVar.d);
                return Unit.INSTANCE;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.sync.Mutex, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@Nullable Object obj, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(MutexImpl.this, obj);
            this.e = selectInstance;
            this.f = function2;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.c
        public void c(@NotNull Object obj) {
            CancellableKt.startCoroutineCancellable(this.f, MutexImpl.this, this.e.getCompletion(), new a(this));
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.c
        @Nullable
        public Object d() {
            if (this.e.trySelect()) {
                return MutexKt.c;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("LockSelect[");
            L.append(this.d);
            L.append(", ");
            L.append(this.e);
            L.append("] for ");
            L.append(MutexImpl.this);
            return L.toString();
        }
    }

    public abstract class c extends LockFreeLinkedListNode implements DisposableHandle {
        @JvmField
        @Nullable
        public final Object d;

        public c(@Nullable MutexImpl mutexImpl, Object obj) {
            this.d = obj;
        }

        public abstract void c(@NotNull Object obj);

        @Nullable
        public abstract Object d();

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            remove();
        }
    }

    public static final class d extends LockFreeLinkedListHead {
        @JvmField
        @NotNull
        public Object d;

        public d(@NotNull Object obj) {
            this.d = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return a2.b.a.a.a.q(a2.b.a.a.a.L("LockedQueue["), this.d, ']');
        }
    }

    public static final class e extends AtomicDesc {
        @JvmField
        @NotNull
        public final MutexImpl a;
        @JvmField
        @Nullable
        public final Object b;

        public final class a extends OpDescriptor {
            @NotNull
            public final AtomicOp<?> a;

            public a(@NotNull e eVar, AtomicOp<?> atomicOp) {
                this.a = atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            @NotNull
            public AtomicOp<?> getAtomicOp() {
                return this.a;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            @Nullable
            public Object perform(@Nullable Object obj) {
                Object obj2;
                if (this.a.isDecided()) {
                    obj2 = MutexKt.g;
                } else {
                    obj2 = this.a;
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
                MutexImpl.a.compareAndSet((MutexImpl) obj, this, obj2);
                return null;
            }
        }

        public e(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            this.a = mutexImpl;
            this.b = obj;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public void complete(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj) {
            u6.a.m0.b bVar;
            if (obj != null) {
                bVar = MutexKt.g;
            } else {
                Object obj2 = this.b;
                bVar = obj2 == null ? MutexKt.f : new u6.a.m0.b(obj2);
            }
            MutexImpl.a.compareAndSet(this.a, atomicOp, bVar);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        @Nullable
        public Object prepare(@NotNull AtomicOp<?> atomicOp) {
            a aVar = new a(this, atomicOp);
            if (!MutexImpl.a.compareAndSet(this.a, MutexKt.g, aVar)) {
                return MutexKt.a;
            }
            aVar.perform(this.a);
            return null;
        }
    }

    public static final class f extends AtomicOp<MutexImpl> {
        @JvmField
        @NotNull
        public final d b;

        public f(@NotNull d dVar) {
            this.b = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(MutexImpl mutexImpl, Object obj) {
            MutexImpl.a.compareAndSet(mutexImpl, this, obj == null ? MutexKt.g : this.b);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object prepare(MutexImpl mutexImpl) {
            if (this.b.isEmpty()) {
                return null;
            }
            return MutexKt.b;
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.f : MutexKt.g;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @NotNull
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(@NotNull Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof u6.a.m0.b) {
            if (((u6.a.m0.b) obj2).a == obj) {
                return true;
            }
        } else if ((obj2 instanceof d) && ((d) obj2).d == obj) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof u6.a.m0.b) {
                return ((u6.a.m0.b) obj).a != MutexKt.e;
            }
            if (obj instanceof d) {
                return true;
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else {
                throw new IllegalStateException(a2.b.a.a.a.b3("Illegal state ", obj).toString());
            }
        }
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object obj = this._state;
        return (obj instanceof d) && ((d) obj).isEmpty();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @Nullable
    public Object lock(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        if (tryLock(obj)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        a aVar = new a(obj, orCreateCancellableContinuation);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof u6.a.m0.b) {
                u6.a.m0.b bVar = (u6.a.m0.b) obj2;
                if (bVar.a != MutexKt.e) {
                    a.compareAndSet(this, obj2, new d(bVar.a));
                } else {
                    if (a.compareAndSet(this, obj2, obj == null ? MutexKt.f : new u6.a.m0.b(obj))) {
                        Unit unit = Unit.INSTANCE;
                        Result.Companion companion = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m242constructorimpl(unit));
                        break;
                    }
                }
            } else if (obj2 instanceof d) {
                d dVar = (d) obj2;
                boolean z = false;
                if (dVar.d != obj) {
                    MutexImpl$lockSuspend$$inlined$suspendCancellableCoroutineReusable$lambda$1 mutexImpl$lockSuspend$$inlined$suspendCancellableCoroutineReusable$lambda$1 = new LockFreeLinkedListNode.CondAddOp(aVar, aVar, obj2, orCreateCancellableContinuation, aVar, this, obj) { // from class: kotlinx.coroutines.sync.MutexImpl$lockSuspend$$inlined$suspendCancellableCoroutineReusable$lambda$1
                        public final /* synthetic */ Object b;
                        public final /* synthetic */ CancellableContinuation c;
                        public final /* synthetic */ MutexImpl d;
                        public final /* synthetic */ Object e;

                        {
                            this.b = r3;
                            this.c = r4;
                            this.d = r6;
                            this.e = r7;
                        }

                        @Nullable
                        public Object prepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
                            if (this.d._state == this.b) {
                                return null;
                            }
                            return LockFreeLinkedListKt.getCONDITION_FALSE();
                        }
                    };
                    while (true) {
                        int tryCondAddNext = dVar.getPrevNode().tryCondAddNext(aVar, dVar, mutexImpl$lockSuspend$$inlined$suspendCancellableCoroutineReusable$lambda$1);
                        if (tryCondAddNext != 1) {
                            if (tryCondAddNext == 2) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, aVar);
                        break;
                    }
                } else {
                    throw new IllegalStateException(a2.b.a.a.a.b3("Already locked by ", obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(a2.b.a.a.a.b3("Illegal state ", obj2).toString());
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == t6.p.a.a.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, @Nullable Object obj, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            Object obj2 = this._state;
            if (obj2 instanceof u6.a.m0.b) {
                u6.a.m0.b bVar = (u6.a.m0.b) obj2;
                if (bVar.a != MutexKt.e) {
                    a.compareAndSet(this, obj2, new d(bVar.a));
                } else {
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(new e(this, obj));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
                        return;
                    } else if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                        if (!(performAtomicTrySelect == MutexKt.a || performAtomicTrySelect == AtomicKt.RETRY_ATOMIC)) {
                            throw new IllegalStateException(a2.b.a.a.a.b3("performAtomicTrySelect(TryLockDesc) returned ", performAtomicTrySelect).toString());
                        }
                    } else {
                        return;
                    }
                }
            } else if (obj2 instanceof d) {
                d dVar = (d) obj2;
                boolean z = false;
                if (dVar.d != obj) {
                    b bVar2 = new b(obj, selectInstance, function2);
                    MutexImpl$registerSelectClause2$$inlined$addLastIf$1 mutexImpl$registerSelectClause2$$inlined$addLastIf$1 = new LockFreeLinkedListNode.CondAddOp(bVar2, bVar2, this, obj2) { // from class: kotlinx.coroutines.sync.MutexImpl$registerSelectClause2$$inlined$addLastIf$1
                        public final /* synthetic */ MutexImpl b;
                        public final /* synthetic */ Object c;

                        {
                            this.b = r3;
                            this.c = r4;
                        }

                        @Nullable
                        public Object prepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
                            if (this.b._state == this.c) {
                                return null;
                            }
                            return LockFreeLinkedListKt.getCONDITION_FALSE();
                        }
                    };
                    while (true) {
                        int tryCondAddNext = dVar.getPrevNode().tryCondAddNext(bVar2, dVar, mutexImpl$registerSelectClause2$$inlined$addLastIf$1);
                        if (tryCondAddNext != 1) {
                            if (tryCondAddNext == 2) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        selectInstance.disposeOnSelect(bVar2);
                        return;
                    }
                } else {
                    throw new IllegalStateException(a2.b.a.a.a.b3("Already locked by ", obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(a2.b.a.a.a.b3("Illegal state ", obj2).toString());
            }
        }
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof u6.a.m0.b) {
                return a2.b.a.a.a.q(a2.b.a.a.a.L("Mutex["), ((u6.a.m0.b) obj).a, ']');
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else if (obj instanceof d) {
                return a2.b.a.a.a.q(a2.b.a.a.a.L("Mutex["), ((d) obj).d, ']');
            } else {
                throw new IllegalStateException(a2.b.a.a.a.b3("Illegal state ", obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof u6.a.m0.b) {
                if (((u6.a.m0.b) obj2).a != MutexKt.e) {
                    return false;
                }
                if (a.compareAndSet(this, obj2, obj == null ? MutexKt.f : new u6.a.m0.b(obj))) {
                    return true;
                }
            } else if (obj2 instanceof d) {
                if (((d) obj2).d == obj) {
                    z = false;
                }
                if (z) {
                    return false;
                }
                throw new IllegalStateException(a2.b.a.a.a.b3("Already locked by ", obj).toString());
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(a2.b.a.a.a.b3("Illegal state ", obj2).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof u6.a.m0.b) {
                if (obj == null) {
                    if (((u6.a.m0.b) obj2).a == MutexKt.e) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    u6.a.m0.b bVar = (u6.a.m0.b) obj2;
                    if (bVar.a != obj) {
                        z = false;
                    }
                    if (!z) {
                        StringBuilder L = a2.b.a.a.a.L("Mutex is locked by ");
                        L.append(bVar.a);
                        L.append(" but expected ");
                        L.append(obj);
                        throw new IllegalStateException(L.toString().toString());
                    }
                }
                if (a.compareAndSet(this, obj2, MutexKt.g)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else if (obj2 instanceof d) {
                if (obj != null) {
                    d dVar = (d) obj2;
                    if (dVar.d != obj) {
                        z = false;
                    }
                    if (!z) {
                        StringBuilder L2 = a2.b.a.a.a.L("Mutex is locked by ");
                        L2.append(dVar.d);
                        L2.append(" but expected ");
                        L2.append(obj);
                        throw new IllegalStateException(L2.toString().toString());
                    }
                }
                d dVar2 = (d) obj2;
                LockFreeLinkedListNode removeFirstOrNull = dVar2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    f fVar = new f(dVar2);
                    if (a.compareAndSet(this, obj2, fVar) && fVar.perform(this) == null) {
                        return;
                    }
                } else {
                    c cVar = (c) removeFirstOrNull;
                    Object d2 = cVar.d();
                    if (d2 != null) {
                        Object obj3 = cVar.d;
                        if (obj3 == null) {
                            obj3 = MutexKt.d;
                        }
                        dVar2.d = obj3;
                        cVar.c(d2);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(a2.b.a.a.a.b3("Illegal state ", obj2).toString());
            }
        }
    }
}
