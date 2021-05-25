package u6.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class b<T> {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(b.class, "notCompletedCount");
    public final Deferred<T>[] a;
    public volatile int notCompletedCount;

    public final class a extends JobNode<Job> {
        public volatile Object _disposer = null;
        @NotNull
        public DisposableHandle d;
        public final CancellableContinuation<List<? extends T>> e;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super java.util.List<? extends T>> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull CancellableContinuation<? super List<? extends T>> cancellableContinuation, @NotNull Job job) {
            super(job);
            this.e = cancellableContinuation;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void invoke(@Nullable Throwable th) {
            if (th != null) {
                Object tryResumeWithException = this.e.tryResumeWithException(th);
                if (tryResumeWithException != null) {
                    this.e.completeResume(tryResumeWithException);
                    C0687b bVar = (C0687b) this._disposer;
                    if (bVar != null) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                return;
            }
            if (b.b.decrementAndGet(b.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.e;
                Deferred<T>[] deferredArr = b.this.a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred<T> deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m242constructorimpl(arrayList));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.Deferred<? extends T>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Deferred<? extends T>[] deferredArr) {
        this.a = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    @Nullable
    public final Object a(@NotNull Continuation<? super List<? extends T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.a.length;
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            Deferred<T> deferred = this.a[Boxing.boxInt(i).intValue()];
            deferred.start();
            a aVar = new a(cancellableContinuationImpl, deferred);
            aVar.d = deferred.invokeOnCompletion(aVar);
            aVarArr[i] = aVar;
        }
        C0687b bVar = new C0687b(this, aVarArr);
        for (int i2 = 0; i2 < length; i2++) {
            aVarArr[i2]._disposer = bVar;
        }
        if (cancellableContinuationImpl.isCompleted()) {
            bVar.a();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(bVar);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* renamed from: u6.a.b$b  reason: collision with other inner class name */
    public final class C0687b extends CancelHandler {
        public final b<T>.a[] a;

        public C0687b(@NotNull b bVar, b<T>.a[] aVarArr) {
            this.a = aVarArr;
        }

        public final void a() {
            for (b<T>.a aVar : this.a) {
                DisposableHandle disposableHandle = aVar.d;
                if (disposableHandle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("handle");
                }
                disposableHandle.dispose();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            a();
            return Unit.INSTANCE;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("DisposeHandlersOnCancel[");
            L.append(this.a);
            L.append(']');
            return L.toString();
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public void invoke(@Nullable Throwable th) {
            a();
        }
    }
}
