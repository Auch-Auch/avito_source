package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;J)Landroidx/lifecycle/LiveData;", "asFlow", "(Landroidx/lifecycle/LiveData;)Lkotlinx/coroutines/flow/Flow;", "Ljava/time/Duration;", "timeout", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;Ljava/time/Duration;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "FlowLiveDataConversions")
public final class FlowLiveDataConversions {

    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {96, 100, 101}, m = "invokeSuspend", n = {"$this$flow", "channel", "observer", "$this$flow", "observer", "$this$flow", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ LiveData f;

        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$a$a  reason: collision with other inner class name */
        public static final class C0113a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ a b;
            public final /* synthetic */ Observer c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0113a(a aVar, Observer observer, Continuation continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                return new C0113a(this.b, this.c, continuation);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                Continuation<? super Unit> continuation2 = continuation;
                Intrinsics.checkNotNullParameter(continuation2, "completion");
                C0113a aVar = new C0113a(this.b, this.c, continuation2);
                Unit unit = Unit.INSTANCE;
                t6.p.a.a.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(unit);
                aVar.b.f.observeForever(aVar.c);
                return unit;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                t6.p.a.a.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.b.f.observeForever(this.c);
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ a b;
            public final /* synthetic */ Observer c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(a aVar, Observer observer, Continuation continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                return new b(this.b, this.c, continuation);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                Continuation<? super Unit> continuation2 = continuation;
                Intrinsics.checkNotNullParameter(continuation2, "completion");
                b bVar = new b(this.b, this.c, continuation2);
                Unit unit = Unit.INSTANCE;
                t6.p.a.a.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(unit);
                bVar.b.f.removeObserver(bVar.c);
                return unit;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                t6.p.a.a.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.b.f.removeObserver(this.c);
                return Unit.INSTANCE;
            }
        }

        public static final class c<T> implements Observer<T> {
            public final /* synthetic */ Channel a;

            public c(Channel channel) {
                this.a = channel;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                this.a.offer(t);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.f = liveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.f, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            a aVar = new a(this.f, continuation2);
            aVar.b = obj;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa A[Catch:{ all -> 0x00db }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
            // Method dump skipped, instructions count: 253
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull LiveData<T> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "$this$asFlow");
        return FlowKt.flow(new a(liveData, null));
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow) {
        return asLiveData$default(flow, (CoroutineContext) null, 0, 3, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return asLiveData$default(flow, coroutineContext, 0, 2, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, long j) {
        Intrinsics.checkNotNullParameter(flow, "$this$asLiveData");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return CoroutineLiveDataKt.liveData(coroutineContext, j, new FlowLiveDataConversions$asLiveData$1(flow, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, @NotNull Duration duration) {
        Intrinsics.checkNotNullParameter(flow, "$this$asLiveData");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(duration, "timeout");
        return asLiveData(flow, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, coroutineContext, duration);
    }
}
