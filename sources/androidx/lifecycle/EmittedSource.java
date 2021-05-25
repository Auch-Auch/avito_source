package androidx.lifecycle;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000b\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/EmittedSource;", "Lkotlinx/coroutines/DisposableHandle;", "", "disposeNow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "()V", "Landroidx/lifecycle/MediatorLiveData;", "c", "Landroidx/lifecycle/MediatorLiveData;", "mediator", "Landroidx/lifecycle/LiveData;", AuthSource.BOOKING_ORDER, "Landroidx/lifecycle/LiveData;", "source", "", AuthSource.SEND_ABUSE, "Z", "disposed", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class EmittedSource implements DisposableHandle {
    public boolean a;
    public final LiveData<?> b;
    public final MediatorLiveData<?> c;

    @DebugMetadata(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ EmittedSource b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EmittedSource emittedSource, Continuation continuation) {
            super(2, continuation);
            this.b = emittedSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.b, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            a aVar = new a(this.b, continuation2);
            Unit unit = Unit.INSTANCE;
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(unit);
            EmittedSource.access$removeSource(aVar.b);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            EmittedSource.access$removeSource(this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ EmittedSource b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EmittedSource emittedSource, Continuation continuation) {
            super(2, continuation);
            this.b = emittedSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new b(this.b, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            b bVar = new b(this.b, continuation2);
            Unit unit = Unit.INSTANCE;
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(unit);
            EmittedSource.access$removeSource(bVar.b);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            EmittedSource.access$removeSource(this.b);
            return Unit.INSTANCE;
        }
    }

    public EmittedSource(@NotNull LiveData<?> liveData, @NotNull MediatorLiveData<?> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(liveData, "source");
        Intrinsics.checkNotNullParameter(mediatorLiveData, "mediator");
        this.b = liveData;
        this.c = mediatorLiveData;
    }

    public static final void access$removeSource(EmittedSource emittedSource) {
        if (!emittedSource.a) {
            emittedSource.c.removeSource((LiveData<S>) emittedSource.b);
            emittedSource.a = true;
        }
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new a(this, null), 3, null);
    }

    @Nullable
    public final Object disposeNow(@NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new b(this, null), continuation);
        return withContext == t6.p.a.a.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
