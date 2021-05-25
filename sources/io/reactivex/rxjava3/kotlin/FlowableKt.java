package io.reactivex.rxjava3.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\u0003\u0010\r\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000eH\u0007¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u0011H\u0007¢\u0006\u0004\b\u0003\u0010\u0013\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u0014H\u0007¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u0017H\u0007¢\u0006\u0004\b\u0003\u0010\u0019\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0007¢\u0006\u0004\b\u0003\u0010\u001d\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u001eH\u0007¢\u0006\u0004\b\u0003\u0010\u001f\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0004\b\u0003\u0010!\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\"H\u0007¢\u0006\u0004\b\u0003\u0010#\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000$¢\u0006\u0004\b\u0003\u0010%\u001a1\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"H\u0007¢\u0006\u0004\b&\u0010#\u001a1\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"H\u0007¢\u0006\u0004\b'\u0010#\u001aP\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\b\u0004\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$0)H\b¢\u0006\u0004\b+\u0010,\u001ae\u00102\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\"2)\b\u0004\u00101\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00010)H\b¢\u0006\u0004\b2\u00103\u001ae\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\"2)\b\u0004\u00104\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00010)H\b¢\u0006\u0004\b5\u00103\u001a*\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\n\b\u0000\u0010(\u0018\u0001*\u00020\u001a*\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\b6\u00107\u001a*\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\n\b\u0000\u0010(\u0018\u0001*\u00020\u001a*\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\b8\u00107\u001aM\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:0\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007¢\u0006\u0004\b2\u0010;\u001ak\u00102\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?0\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a\"\b\b\u0002\u0010<*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001H\u0007¢\u0006\u0004\b2\u0010@\u001a/\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\bA\u00107\u001a/\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\bB\u00107\u001a/\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\bC\u00107\u001a/\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\bD\u00107\u001aK\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010H0G\"\b\b\u0000\u0010E*\u00020\u001a\"\b\b\u0001\u0010F*\u00020\u001a*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:0\u0001H\u0007¢\u0006\u0004\bI\u0010J\u001aQ\u0010L\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010K0H0G\"\b\b\u0000\u0010E*\u00020\u001a\"\b\b\u0001\u0010F*\u00020\u001a*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:0\u0001H\u0007¢\u0006\u0004\bL\u0010J\u001a/\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000M0\"H\u0007¢\u0006\u0004\bB\u0010#¨\u0006N"}, d2 = {"", "Lio/reactivex/rxjava3/core/Flowable;", "", "toFlowable", "([Z)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([B)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([C)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([S)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([I)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([J)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([F)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([D)Lio/reactivex/rxjava3/core/Flowable;", "", "T", "", "([Ljava/lang/Object;)Lio/reactivex/rxjava3/core/Flowable;", "Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/IntProgression;)Lio/reactivex/rxjava3/core/Flowable;", "", "(Ljava/util/Iterator;)Lio/reactivex/rxjava3/core/Flowable;", "", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Flowable;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lio/reactivex/rxjava3/core/Flowable;", "merge", "mergeDelayError", "R", "Lkotlin/Function1;", SDKConstants.PARAM_A2U_BODY, "flatMapSequence", "(Lio/reactivex/rxjava3/core/Flowable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Flowable;", "", "Lkotlin/ParameterName;", "name", "args", "combineFunction", "combineLatest", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Flowable;", "zipFunction", "zip", "cast", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "ofType", "flowable", "Lkotlin/Pair;", "(Lio/reactivex/rxjava3/core/Flowable;Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "U", "flowable1", "flowable2", "Lkotlin/Triple;", "(Lio/reactivex/rxjava3/core/Flowable;Lio/reactivex/rxjava3/core/Flowable;Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "mergeAll", "concatAll", "switchLatest", "switchOnNext", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lio/reactivex/rxjava3/core/Single;", "", "toMap", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Single;", "", "toMultimap", "Lorg/reactivestreams/Publisher;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class FlowableKt {

    public static final class c<T, R> implements Function<T, Publisher<? extends R>> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Flowable) obj;
        }
    }

    public static final class d<T, R> implements Function<T, Publisher<? extends R>> {
        public static final d a = new d();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Flowable) obj;
        }
    }

    public static final class e<T, R> implements Function<T, Publisher<? extends R>> {
        public static final e a = new e();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Flowable) obj;
        }
    }

    public static final class f<T, R> implements Function<T, K> {
        public static final f a = new f();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return ((Pair) obj).getFirst();
        }
    }

    public static final class g<T, R> implements Function<T, V> {
        public static final g a = new g();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return ((Pair) obj).getSecond();
        }
    }

    public static final class h<T, R> implements Function<T, K> {
        public static final h a = new h();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return ((Pair) obj).getFirst();
        }
    }

    public static final class i<T, R> implements Function<T, V> {
        public static final i a = new i();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return ((Pair) obj).getSecond();
        }
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<U>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<R> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Flowable<R> cast(@NotNull Flowable<?> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Flowable flowable2 = (Flowable<U>) flowable.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(flowable2, "cast(R::class.java)");
        return flowable2;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T, R> Flowable<R> combineLatest(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(function1, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(iterable, new Function<Object[], R>(function1) { // from class: io.reactivex.rxjava3.kotlin.FlowableKt$combineLatest$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @NotNull
            public final R apply(Object[] objArr) {
                Function1 function12 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(objArr, "it");
                List asList = ArraysKt___ArraysJvmKt.asList(objArr);
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(asList, 10));
                for (T t : asList) {
                    if (t != null) {
                        arrayList.add(t);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type T");
                    }
                }
                return (R) function12.invoke(arrayList);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Flowable.combineLatest(t…List().map { it as T }) }");
        return combineLatest;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<R>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<T> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$concatAll");
        Flowable flowable2 = (Flowable<R>) flowable.concatMap(c.a);
        Intrinsics.checkExpressionValueIsNotNull(flowable2, "concatMap { it }");
        return flowable2;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T, R> Flowable<R> flatMapSequence(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$flatMapSequence");
        Intrinsics.checkParameterIsNotNull(function1, SDKConstants.PARAM_A2U_BODY);
        Flowable<R> flatMap = flowable.flatMap(new Function<T, Publisher<? extends R>>(function1) { // from class: io.reactivex.rxjava3.kotlin.FlowableKt$flatMapSequence$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function
            @NotNull
            public final Flowable<R> apply(T t) {
                Function1 function12 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t, "it");
                return FlowableKt.toFlowable((Sequence) function12.invoke(t));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "flatMap { body(it).toFlowable() }");
        return flatMap;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> merge(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$merge");
        Flowable<T> merge = Flowable.merge(toFlowable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(merge, "Flowable.merge(this.toFlowable())");
        return merge;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<R>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<T> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAll");
        Flowable flowable2 = (Flowable<R>) flowable.flatMap(d.a);
        Intrinsics.checkExpressionValueIsNotNull(flowable2, "flatMap { it }");
        return flowable2;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeDelayError(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$mergeDelayError");
        Flowable<T> mergeDelayError = Flowable.mergeDelayError(toFlowable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(mergeDelayError, "Flowable.mergeDelayError(this.toFlowable())");
        return mergeDelayError;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<U>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<R> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Flowable<R> ofType(@NotNull Flowable<?> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Flowable flowable2 = (Flowable<U>) flowable.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(flowable2, "ofType(R::class.java)");
        return flowable2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<R>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<T> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> switchLatest(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$switchLatest");
        Flowable flowable2 = (Flowable<R>) flowable.switchMap(e.a);
        Intrinsics.checkExpressionValueIsNotNull(flowable2, "switchMap { it }");
        return flowable2;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> switchOnNext(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$switchOnNext");
        Flowable<T> switchOnNext = Flowable.switchOnNext(flowable);
        Intrinsics.checkExpressionValueIsNotNull(switchOnNext, "Flowable.switchOnNext(this)");
        return switchOnNext;
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Boolean> toFlowable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(zArr));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Single<java.util.Map<K, V>>, java.lang.Object, io.reactivex.rxjava3.core.Single<java.util.Map<A, B>> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, B>> toMap(@NotNull Flowable<Pair<A, B>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$toMap");
        Single single = (Single<Map<K, V>>) flowable.toMap(f.a, g.a);
        Intrinsics.checkExpressionValueIsNotNull(single, "toMap({ it.first }, { it.second })");
        return single;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Single<java.util.Map<K, java.util.Collection<V>>>, java.lang.Object, io.reactivex.rxjava3.core.Single<java.util.Map<A, java.util.Collection<B>>> */
    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, Collection<B>>> toMultimap(@NotNull Flowable<Pair<A, B>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$toMultimap");
        Single single = (Single<Map<K, Collection<V>>>) flowable.toMultimap(h.a, i.a);
        Intrinsics.checkExpressionValueIsNotNull(single, "toMultimap({ it.first }, { it.second })");
        return single;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T, R> Flowable<R> zip(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$zip");
        Intrinsics.checkParameterIsNotNull(function1, "zipFunction");
        Flowable<R> zip = Flowable.zip(iterable, new Function<Object[], R>(function1) { // from class: io.reactivex.rxjava3.kotlin.FlowableKt$zip$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @NotNull
            public final R apply(Object[] objArr) {
                Function1 function12 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(objArr, "it");
                List asList = ArraysKt___ArraysJvmKt.asList(objArr);
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(asList, 10));
                for (T t : asList) {
                    if (t != null) {
                        arrayList.add(t);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type T");
                    }
                }
                return (R) function12.invoke(arrayList);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Flowable.zip(this) { zip…List().map { it as T }) }");
        return zip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [s6.a.e.e.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.rxjava3.annotations.CheckReturnValue
    @org.jetbrains.annotations.NotNull
    @io.reactivex.rxjava3.annotations.BackpressureSupport(io.reactivex.rxjava3.annotations.BackpressureKind.FULL)
    @io.reactivex.rxjava3.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R> io.reactivex.rxjava3.core.Flowable<kotlin.Pair<T, R>> combineLatest(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Flowable<T> r2, @org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Flowable<R> r3) {
        /*
            java.lang.String r0 = "$this$combineLatest"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "flowable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            io.reactivex.rxjava3.kotlin.FlowableKt$a r0 = io.reactivex.rxjava3.kotlin.FlowableKt.a.a
            if (r0 == 0) goto L_0x0014
            s6.a.e.e.b r1 = new s6.a.e.e.b
            r1.<init>(r0)
            r0 = r1
        L_0x0014:
            io.reactivex.rxjava3.functions.BiFunction r0 = (io.reactivex.rxjava3.functions.BiFunction) r0
            io.reactivex.rxjava3.core.Flowable r2 = io.reactivex.rxjava3.core.Flowable.combineLatest(r2, r3, r0)
            java.lang.String r3 = "Flowable.combineLatest(t…able, BiFunction(::Pair))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.kotlin.FlowableKt.combineLatest(io.reactivex.rxjava3.core.Flowable, io.reactivex.rxjava3.core.Flowable):io.reactivex.rxjava3.core.Flowable");
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends Publisher<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Flowable<T> concat = Flowable.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Flowable.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Byte> toFlowable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(bArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [s6.a.e.e.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.rxjava3.annotations.CheckReturnValue
    @org.jetbrains.annotations.NotNull
    @io.reactivex.rxjava3.annotations.BackpressureSupport(io.reactivex.rxjava3.annotations.BackpressureKind.FULL)
    @io.reactivex.rxjava3.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R, U> io.reactivex.rxjava3.core.Flowable<kotlin.Triple<T, R, U>> combineLatest(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Flowable<T> r2, @org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Flowable<R> r3, @org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Flowable<U> r4) {
        /*
            java.lang.String r0 = "$this$combineLatest"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "flowable1"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "flowable2"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            io.reactivex.rxjava3.kotlin.FlowableKt$b r0 = io.reactivex.rxjava3.kotlin.FlowableKt.b.a
            if (r0 == 0) goto L_0x0019
            s6.a.e.e.c r1 = new s6.a.e.e.c
            r1.<init>(r0)
            r0 = r1
        L_0x0019:
            io.reactivex.rxjava3.functions.Function3 r0 = (io.reactivex.rxjava3.functions.Function3) r0
            io.reactivex.rxjava3.core.Flowable r2 = io.reactivex.rxjava3.core.Flowable.combineLatest(r2, r3, r4, r0)
            java.lang.String r3 = "Flowable.combineLatest(t…le2, Function3(::Triple))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.kotlin.FlowableKt.combineLatest(io.reactivex.rxjava3.core.Flowable, io.reactivex.rxjava3.core.Flowable, io.reactivex.rxjava3.core.Flowable):io.reactivex.rxjava3.core.Flowable");
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Character> toFlowable(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(cArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Short> toFlowable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(sArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(iArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Long> toFlowable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(jArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Float> toFlowable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(fArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Double> toFlowable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(dArr));
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> toFlowable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$this$toFlowable");
        Flowable<T> fromArray = Flowable.fromArray(Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(fromArray, "Flowable.fromArray(*this)");
        return fromArray;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final Flowable<Integer> toFlowable(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "$this$toFlowable");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            Flowable<Integer> fromIterable = Flowable.fromIterable(intProgression);
            Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Flowable.fromIterable(this)");
            return fromIterable;
        }
        Flowable<Integer> range = Flowable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(range, "Flowable.range(first, Ma…max(0, last - first + 1))");
        return range;
    }

    @CheckReturnValue
    @NotNull
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static final <T> Flowable<T> toFlowable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$toFlowable");
        Flowable<T> fromIterable = Flowable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$this$toFlowable");
        return toFlowable(SequencesKt___SequencesKt.asIterable(sequence));
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "$this$toFlowable");
        return toFlowable(new Object(it) { // from class: io.reactivex.rxjava3.kotlin.FlowableKt$toIterable$1
            public final /* synthetic */ Iterator a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<T> iterator() {
                return this.a;
            }
        });
    }
}
