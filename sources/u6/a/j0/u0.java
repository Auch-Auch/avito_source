package u6.a.j0;

import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
public final class u0<T> extends AbstractSharedFlow<v0> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public volatile Object _state;
    public int e;

    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {330, 388, 347}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "oldState", "newState", "this", "collector", "slot", "collectorJob", "oldState", "newState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ u0 c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(u0 u0Var, Continuation continuation) {
            super(continuation);
            this.c = u0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.collect(null, this);
        }
    }

    public u0(@NotNull Object obj) {
        this._state = obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(Object obj, Object obj2) {
        int i;
        v0[] v0VarArr;
        int i2;
        v0[] v0VarArr2;
        v0[] v0VarArr3 = (v0[]) getSlots();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && (!Intrinsics.areEqual(obj3, obj))) {
                return false;
            }
            if (Intrinsics.areEqual(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i3 = this.e;
            if ((i3 & 1) == 0) {
                i = i3 + 1;
                this.e = i;
                v0VarArr = (v0[]) getSlots();
            } else {
                this.e = i3 + 2;
                return true;
            }
        }
        while (true) {
            if (v0VarArr != null) {
                for (v0 v0Var : v0VarArr) {
                    if (v0Var != null) {
                        while (true) {
                            Object obj4 = v0Var._state;
                            if (obj4 == null || obj4 == StateFlowKt.b) {
                                break;
                            } else if (obj4 == StateFlowKt.a) {
                                if (v0.a.compareAndSet(v0Var, obj4, StateFlowKt.b)) {
                                    break;
                                }
                            } else if (v0.a.compareAndSet(v0Var, obj4, StateFlowKt.a)) {
                                Unit unit = Unit.INSTANCE;
                                Result.Companion companion = Result.Companion;
                                ((CancellableContinuationImpl) obj4).resumeWith(Result.m242constructorimpl(unit));
                                break;
                            }
                        }
                    }
                }
            }
            synchronized (this) {
                i2 = this.e;
                if (i2 == i) {
                    this.e = i + 1;
                    return true;
                }
                v0VarArr2 = (v0[]) getSlots();
            }
            v0VarArr = v0VarArr2;
            i = i2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00ed */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlinx.coroutines.flow.FlowCollector */
    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: kotlinx.coroutines.flow.FlowCollector */
    /* JADX DEBUG: Multi-variable search result rejected for r8v11, resolved type: kotlinx.coroutines.flow.FlowCollector */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r14, r15)) != false) goto L_0x00b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.j0.u0.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        if (t2 == null) {
            t2 = (T) NullSurrogateKt.NULL;
        }
        return a(t, t2);
    }

    /* Return type fixed from 'kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot' to match base method */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public v0 createSlot() {
        return new v0();
    }

    /* Return type fixed from 'kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[]' to match base method */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public v0[] createSlotArray(int i) {
        return new v0[i];
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        return d.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        a(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }
}
