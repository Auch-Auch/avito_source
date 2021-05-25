package com.google.android.play.core.ktx;

import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a7\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"T", "Lcom/google/android/play/core/tasks/Task;", "task", "Lkotlin/Function0;", "", "onCanceled", "runTask", "(Lcom/google/android/play/core/tasks/Task;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmp.9f4bIqL_release"}, k = 2, mv = {1, 4, 0})
public final class TaskUtilsKt {

    public static final class a extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0, Task task) {
            super(1);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class c<ResultT> implements OnSuccessListener<T> {
        public final /* synthetic */ CancellableContinuation a;

        public c(CancellableContinuation cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // com.google.android.play.core.tasks.OnSuccessListener
        public final void onSuccess(T t) {
            CancellableContinuation cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m242constructorimpl(t));
        }
    }

    public static final class d implements OnFailureListener {
        public final /* synthetic */ CancellableContinuation a;

        public d(CancellableContinuation cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // com.google.android.play.core.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            CancellableContinuation cancellableContinuation = this.a;
            Intrinsics.checkExpressionValueIsNotNull(exc, OkListener.KEY_EXCEPTION);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(exc)));
        }
    }

    @Nullable
    public static final <T> Object runTask(@NotNull Task<T> task, @NotNull Function0<Unit> function0, @NotNull Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new a(function0, task));
        if (!task.isComplete()) {
            task.addOnSuccessListener(new c(cancellableContinuationImpl));
            task.addOnFailureListener(new d(cancellableContinuationImpl));
        } else if (task.isSuccessful()) {
            T result = task.getResult();
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m242constructorimpl(result));
        } else {
            Exception exception = task.getException();
            if (exception == null) {
                Intrinsics.throwNpe();
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(exception)));
        }
        Object result2 = cancellableContinuationImpl.getResult();
        if (result2 == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result2;
    }

    public static /* synthetic */ Object runTask$default(Task task, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = b.a;
        }
        return runTask(task, function0, continuation);
    }
}
