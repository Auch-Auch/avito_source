package kotlin.sequences;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
public class SequencesKt__SequencesKt extends t6.x.d {

    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0"})
    public static final class a extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public int d;
        public int e;
        public final /* synthetic */ Sequence f;
        public final /* synthetic */ Function2 g;
        public final /* synthetic */ Function1 h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Sequence sequence, Function2 function2, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f = sequence;
            this.g = function2;
            this.h = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.f, this.g, this.h, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            a aVar = new a(this.f, this.g, this.h, continuation2);
            aVar.b = obj;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            SequenceScope sequenceScope;
            Iterator it;
            int i;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i2 = this.e;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                it = this.f.iterator();
                sequenceScope = (SequenceScope) this.b;
            } else if (i2 == 1) {
                i = this.d;
                it = (Iterator) this.c;
                sequenceScope = (SequenceScope) this.b;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                Object next = it.next();
                Function2 function2 = this.g;
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Object invoke = function2.invoke(Boxing.boxInt(i), next);
                this.b = sequenceScope;
                this.c = it;
                this.d = i3;
                this.e = 1;
                if (sequenceScope.yieldAll((Iterator) this.h.invoke(invoke), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i3;
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Sequence<? extends T>, Iterator<? extends T>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Sequence sequence = (Sequence) obj;
            Intrinsics.checkNotNullParameter(sequence, "it");
            return sequence.iterator();
        }
    }

    public static final class c extends Lambda implements Function1<Iterable<? extends T>, Iterator<? extends T>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Iterable iterable = (Iterable) obj;
            Intrinsics.checkNotNullParameter(iterable, "it");
            return iterable.iterator();
        }
    }

    public static final class d extends Lambda implements Function1<T, T> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(1);
            this.a = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final T invoke(@NotNull T t) {
            Intrinsics.checkNotNullParameter(t, "it");
            return (T) this.a.invoke();
        }
    }

    public static final class e extends Lambda implements Function0<T> {
        public final /* synthetic */ Object a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Object obj) {
            super(0);
            this.a = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final T invoke() {
            return (T) this.a;
        }
    }

    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public int c;
        public final /* synthetic */ Sequence d;
        public final /* synthetic */ Function0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Sequence sequence, Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.d = sequence;
            this.e = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            f fVar = new f(this.d, this.e, continuation);
            fVar.b = obj;
            return fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            f fVar = new f(this.d, this.e, continuation2);
            fVar.b = obj;
            return fVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SequenceScope sequenceScope = (SequenceScope) this.b;
                Iterator it = this.d.iterator();
                if (it.hasNext()) {
                    this.c = 1;
                    if (sequenceScope.yieldAll(it, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.c = 2;
                    if (sequenceScope.yieldAll((Sequence) this.e.invoke(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1 || i == 2) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    public static final class g extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public int d;
        public final /* synthetic */ Sequence e;
        public final /* synthetic */ Random f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Sequence sequence, Random random, Continuation continuation) {
            super(2, continuation);
            this.e = sequence;
            this.f = random;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            g gVar = new g(this.e, this.f, continuation);
            gVar.b = obj;
            return gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            g gVar = new g(this.e, this.f, continuation2);
            gVar.b = obj;
            return gVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            SequenceScope sequenceScope;
            List list;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                list = SequencesKt___SequencesKt.toMutableList(this.e);
                sequenceScope = (SequenceScope) this.b;
            } else if (i == 1) {
                list = (List) this.c;
                sequenceScope = (SequenceScope) this.b;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (!list.isEmpty()) {
                int nextInt = this.f.nextInt(list.size());
                Object removeLast = h.removeLast(list);
                if (nextInt < list.size()) {
                    removeLast = list.set(nextInt, removeLast);
                }
                this.b = sequenceScope;
                this.c = list;
                this.d = 1;
                if (sequenceScope.yield(removeLast, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "$this$asSequence");
        return constrainOnce(new Sequence<T>(it) { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            public final /* synthetic */ Iterator a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return this.a;
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Sequence<T> constrainOnce(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$constrainOnce");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    @NotNull
    public static final <T> Sequence<T> emptySequence() {
        return t6.x.b.a;
    }

    @NotNull
    public static final <T, C, R> Sequence<R> flatMapIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends C> function2, @NotNull Function1<? super C, ? extends Iterator<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "source");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Intrinsics.checkNotNullParameter(function1, "iterator");
        return SequencesKt__SequenceBuilderKt.sequence(new a(sequence, function2, function1, null));
    }

    @NotNull
    public static final <T> Sequence<T> flatten(@NotNull Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatten");
        b bVar = b.a;
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(bVar);
        }
        return new FlatteningSequence(sequence, t6.x.e.a, bVar);
    }

    @JvmName(name = "flattenSequenceOfIterable")
    @NotNull
    public static final <T> Sequence<T> flattenSequenceOfIterable(@NotNull Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatten");
        c cVar = c.a;
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(cVar);
        }
        return new FlatteningSequence(sequence, t6.x.e.a, cVar);
    }

    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "nextFunction");
        return constrainOnce(new GeneratorSequence(function0, new d(function0)));
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Sequence<T> ifEmpty(@NotNull Sequence<? extends T> sequence, @NotNull Function0<? extends Sequence<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(sequence, "$this$ifEmpty");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence(new f(sequence, function0, null));
    }

    @NotNull
    public static final <T> Sequence<T> sequenceOf(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? emptySequence() : ArraysKt___ArraysKt.asSequence(tArr);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$shuffled");
        return shuffled(sequence, Random.Default);
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends Pair<? extends T, ? extends R>> it = sequence.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static final <T> Sequence<T> generateSequence(@Nullable T t, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        if (t == null) {
            return t6.x.b.a;
        }
        return new GeneratorSequence(new e(t), function1);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull Sequence<? extends T> sequence, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sequence, "$this$shuffled");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt__SequenceBuilderKt.sequence(new g(sequence, random, null));
    }

    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function0, "seedFunction");
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        return new GeneratorSequence(function0, function1);
    }
}
