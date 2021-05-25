package io.reactivex.rxjava3.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
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
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\u0003\u0010\r\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000eH\u0007¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u0011H\u0007¢\u0006\u0004\b\u0003\u0010\u0013\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u0014H\u0007¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u0017H\u0007¢\u0006\u0004\b\u0003\u0010\u0019\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0007¢\u0006\u0004\b\u0003\u0010\u001d\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u001eH\u0007¢\u0006\u0004\b\u0003\u0010\u001f\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000 H\u0007¢\u0006\u0004\b\u0003\u0010!\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\"H\u0007¢\u0006\u0004\b\u0003\u0010#\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000$H\u0007¢\u0006\u0004\b\u0003\u0010%\u001a1\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"H\u0007¢\u0006\u0004\b&\u0010#\u001a1\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"H\u0007¢\u0006\u0004\b'\u0010#\u001a1\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\"0\u0001H\u0007¢\u0006\u0004\b(\u0010)\u001a1\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\"0\u0001H\u0007¢\u0006\u0004\b*\u0010)\u001aP\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010+*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\b\u0004\u0010-\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$0,H\b¢\u0006\u0004\b.\u0010/\u001ae\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010+*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\"2)\b\u0004\u00104\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000000¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00028\u00010,H\b¢\u0006\u0004\b5\u00106\u001ae\u00108\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010+*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\"2)\b\u0004\u00107\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000000¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00028\u00010,H\b¢\u0006\u0004\b8\u00106\u001a*\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\n\b\u0000\u0010+\u0018\u0001*\u00020\u001a*\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\b9\u0010)\u001a*\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\n\b\u0000\u0010+\u0018\u0001*\u00020\u001a*\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\b:\u0010)\u001a/\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\b;\u0010)\u001a/\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\b<\u0010)\u001a/\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\b=\u0010)\u001a/\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\b>\u0010)\u001aK\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0B\"\b\b\u0000\u0010?*\u00020\u001a\"\b\b\u0001\u0010@*\u00020\u001a*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A0\u0001H\u0007¢\u0006\u0004\bD\u0010E\u001aQ\u0010G\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010F0C0B\"\b\b\u0000\u0010?*\u00020\u001a\"\b\b\u0001\u0010@*\u00020\u001a*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A0\u0001H\u0007¢\u0006\u0004\bG\u0010E\u001a/\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000H0\"H\u0007¢\u0006\u0004\b<\u0010#¨\u0006I"}, d2 = {"", "Lio/reactivex/rxjava3/core/Observable;", "", "toObservable", "([Z)Lio/reactivex/rxjava3/core/Observable;", "", "", "([B)Lio/reactivex/rxjava3/core/Observable;", "", "", "([C)Lio/reactivex/rxjava3/core/Observable;", "", "", "([S)Lio/reactivex/rxjava3/core/Observable;", "", "", "([I)Lio/reactivex/rxjava3/core/Observable;", "", "", "([J)Lio/reactivex/rxjava3/core/Observable;", "", "", "([F)Lio/reactivex/rxjava3/core/Observable;", "", "", "([D)Lio/reactivex/rxjava3/core/Observable;", "", "T", "", "([Ljava/lang/Object;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/IntProgression;)Lio/reactivex/rxjava3/core/Observable;", "", "(Ljava/util/Iterator;)Lio/reactivex/rxjava3/core/Observable;", "", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lio/reactivex/rxjava3/core/Observable;", "merge", "mergeDelayError", "flatMapIterable", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "concatMapIterable", "R", "Lkotlin/Function1;", SDKConstants.PARAM_A2U_BODY, "flatMapSequence", "(Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Observable;", "", "Lkotlin/ParameterName;", "name", "args", "combineFunction", "combineLatest", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Observable;", "zipFunction", "zip", "cast", "ofType", "mergeAll", "concatAll", "switchLatest", "switchOnNext", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lkotlin/Pair;", "Lio/reactivex/rxjava3/core/Single;", "", "toMap", "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Single;", "", "toMultimap", "Lio/reactivex/rxjava3/core/ObservableSource;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class ObservableKt {

    public static final class a<T, R> implements Function<T, ObservableSource<? extends R>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Observable) obj;
        }
    }

    public static final class b<T, R> implements Function<T, Iterable<? extends U>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Iterable) obj;
        }
    }

    public static final class c<T, R> implements Function<T, Iterable<? extends U>> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Iterable) obj;
        }
    }

    public static final class d<T, R> implements Function<T, ObservableSource<? extends R>> {
        public static final d a = new d();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Observable) obj;
        }
    }

    public static final class e<T, R> implements Function<T, ObservableSource<? extends R>> {
        public static final e a = new e();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return (Observable) obj;
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

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<U>, java.lang.Object, io.reactivex.rxjava3.core.Observable<R> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Observable<R> cast(@NotNull Observable<?> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable observable2 = (Observable<U>) observable.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "cast(R::class.java)");
        return observable2;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Observable<R> combineLatest(@NotNull Iterable<? extends Observable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(function1, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(iterable, new Function<Object[], R>(function1) { // from class: io.reactivex.rxjava3.kotlin.ObservableKt$combineLatest$1
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
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…List().map { it as T }) }");
        return combineLatest;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<R>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> concatAll(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$concatAll");
        Observable observable2 = (Observable<R>) observable.concatMap(a.a);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "concatMap { it }");
        return observable2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<U>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> concatMapIterable(@NotNull Observable<? extends Iterable<? extends T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$concatMapIterable");
        Observable observable2 = (Observable<U>) observable.concatMapIterable(b.a);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "concatMapIterable { it }");
        return observable2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<U>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> flatMapIterable(@NotNull Observable<? extends Iterable<? extends T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$flatMapIterable");
        Observable observable2 = (Observable<U>) observable.flatMapIterable(c.a);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "flatMapIterable { it }");
        return observable2;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Observable<R> flatMapSequence(@NotNull Observable<T> observable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$flatMapSequence");
        Intrinsics.checkParameterIsNotNull(function1, SDKConstants.PARAM_A2U_BODY);
        Observable<R> flatMap = observable.flatMap(new Function<T, ObservableSource<? extends R>>(function1) { // from class: io.reactivex.rxjava3.kotlin.ObservableKt$flatMapSequence$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function
            @NotNull
            public final Observable<R> apply(T t) {
                Function1 function12 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t, "it");
                return ObservableKt.toObservable((Sequence) function12.invoke(t));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "flatMap { body(it).toObservable() }");
        return flatMap;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> merge(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$merge");
        Observable<T> merge = Observable.merge(toObservable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(merge, "Observable.merge(this.toObservable())");
        return merge;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<R>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeAll(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAll");
        Observable observable2 = (Observable<R>) observable.flatMap(d.a);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "flatMap { it }");
        return observable2;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeDelayError(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$mergeDelayError");
        Observable<T> mergeDelayError = Observable.mergeDelayError(toObservable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(mergeDelayError, "Observable.mergeDelayError(this.toObservable())");
        return mergeDelayError;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<U>, java.lang.Object, io.reactivex.rxjava3.core.Observable<R> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Observable<R> ofType(@NotNull Observable<?> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable observable2 = (Observable<U>) observable.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "ofType(R::class.java)");
        return observable2;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observable<R>, java.lang.Object, io.reactivex.rxjava3.core.Observable<T> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> switchLatest(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$switchLatest");
        Observable observable2 = (Observable<R>) observable.switchMap(e.a);
        Intrinsics.checkExpressionValueIsNotNull(observable2, "switchMap { it }");
        return observable2;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> switchOnNext(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$switchOnNext");
        Observable<T> switchOnNext = Observable.switchOnNext(observable);
        Intrinsics.checkExpressionValueIsNotNull(switchOnNext, "Observable.switchOnNext(this)");
        return switchOnNext;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Single<java.util.Map<K, V>>, java.lang.Object, io.reactivex.rxjava3.core.Single<java.util.Map<A, B>> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, B>> toMap(@NotNull Observable<Pair<A, B>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$toMap");
        Single single = (Single<Map<K, V>>) observable.toMap(f.a, g.a);
        Intrinsics.checkExpressionValueIsNotNull(single, "toMap({ it.first }, { it.second })");
        return single;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Single<java.util.Map<K, java.util.Collection<V>>>, java.lang.Object, io.reactivex.rxjava3.core.Single<java.util.Map<A, java.util.Collection<B>>> */
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, Collection<B>>> toMultimap(@NotNull Observable<Pair<A, B>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$toMultimap");
        Single single = (Single<Map<K, Collection<V>>>) observable.toMultimap(h.a, i.a);
        Intrinsics.checkExpressionValueIsNotNull(single, "toMultimap({ it.first }, { it.second })");
        return single;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Boolean> toObservable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(zArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Observable<R> zip(@NotNull Iterable<? extends Observable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$zip");
        Intrinsics.checkParameterIsNotNull(function1, "zipFunction");
        Observable<R> zip = Observable.zip(iterable, new Function<Object[], R>(function1) { // from class: io.reactivex.rxjava3.kotlin.ObservableKt$zip$1
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
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(this) { z…List().map { it as T }) }");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> concatAll(@NotNull Iterable<? extends ObservableSource<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Observable<T> concat = Observable.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Observable.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Byte> toObservable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(bArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Character> toObservable(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(cArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Short> toObservable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(sArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Integer> toObservable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(iArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Long> toObservable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(jArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Float> toObservable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(fArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Double> toObservable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(dArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$this$toObservable");
        Observable<T> fromArray = Observable.fromArray(Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(fromArray, "Observable.fromArray(*this)");
        return fromArray;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Integer> toObservable(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "$this$toObservable");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            Observable<Integer> fromIterable = Observable.fromIterable(intProgression);
            Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Observable.fromIterable(this)");
            return fromIterable;
        }
        Observable<Integer> range = Observable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(range, "Observable.range(first, …max(0, last - first + 1))");
        return range;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$toObservable");
        Observable<T> fromIterable = Observable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Observable.fromIterable(this)");
        return fromIterable;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$this$toObservable");
        return toObservable(SequencesKt___SequencesKt.asIterable(sequence));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "$this$toObservable");
        return toObservable(new Object(it) { // from class: io.reactivex.rxjava3.kotlin.ObservableKt$toIterable$1
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
