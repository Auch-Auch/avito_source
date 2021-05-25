package io.reactivex.rxkotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\u0003\u0010\r\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000eH\u0007¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u0011H\u0007¢\u0006\u0004\b\u0003\u0010\u0013\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u0014H\u0007¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u0017H\u0007¢\u0006\u0004\b\u0003\u0010\u0019\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0007¢\u0006\u0004\b\u0003\u0010\u001d\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u001eH\u0007¢\u0006\u0004\b\u0003\u0010\u001f\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0004\b\u0003\u0010!\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\"H\u0007¢\u0006\u0004\b\u0003\u0010#\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000$¢\u0006\u0004\b\u0003\u0010%\u001a1\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"H\u0007¢\u0006\u0004\b&\u0010#\u001a1\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"H\u0007¢\u0006\u0004\b'\u0010#\u001aP\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\b\u0004\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$0)H\b¢\u0006\u0004\b+\u0010,\u001ae\u00102\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\"2)\b\u0004\u00101\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00010)H\b¢\u0006\u0004\b2\u00103\u001ae\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\"2)\b\u0004\u00104\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00010)H\b¢\u0006\u0004\b5\u00103\u001aM\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001070\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007¢\u0006\u0004\b2\u00108\u001ak\u00102\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020<0\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a\"\b\b\u0001\u0010(*\u00020\u001a\"\b\b\u0002\u00109*\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001H\u0007¢\u0006\u0004\b2\u0010=\u001aM\u0010?\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\b?\u0010@\u001aM\u0010A\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\bA\u0010@\u001aM\u0010B\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\bB\u0010@\u001a/\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001H\u0007¢\u0006\u0004\bC\u0010@\u001aÎ\u0001\u0010I\u001a\u0001\u0012D\u0012B\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001 >* \u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001\u0018\u00010H0G >*J\u0012D\u0012B\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001 >* \u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001\u0018\u00010H0G\u0018\u00010F0F\"\b\b\u0000\u0010D*\u00020\u001a\"\b\b\u0001\u0010E*\u00020\u001a*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001070\u0001H\u0007¢\u0006\u0004\bI\u0010J\u001a¿\u0002\u0010M\u001a\u0002\u0012|\u0012z\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012(\u0012&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001\u0018\u00010L0K >*<\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012(\u0012&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001\u0018\u00010L0K\u0018\u00010H0G >*\u0001\u0012|\u0012z\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012(\u0012&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001\u0018\u00010L0K >*<\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0012(\u0012&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00018\u0001\u0018\u00010L0K\u0018\u00010H0G\u0018\u00010F0F\"\b\b\u0000\u0010D*\u00020\u001a\"\b\b\u0001\u0010E*\u00020\u001a*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001070\u0001H\u0007¢\u0006\u0004\bM\u0010J\u001aM\u0010A\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000N0\"H\u0007¢\u0006\u0004\bA\u0010#¨\u0006O"}, d2 = {"", "Lio/reactivex/Flowable;", "", "toFlowable", "([Z)Lio/reactivex/Flowable;", "", "", "([B)Lio/reactivex/Flowable;", "", "", "([C)Lio/reactivex/Flowable;", "", "", "([S)Lio/reactivex/Flowable;", "", "", "([I)Lio/reactivex/Flowable;", "", "", "([J)Lio/reactivex/Flowable;", "", "", "([F)Lio/reactivex/Flowable;", "", "", "([D)Lio/reactivex/Flowable;", "", "T", "", "([Ljava/lang/Object;)Lio/reactivex/Flowable;", "Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/IntProgression;)Lio/reactivex/Flowable;", "", "(Ljava/util/Iterator;)Lio/reactivex/Flowable;", "", "(Ljava/lang/Iterable;)Lio/reactivex/Flowable;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lio/reactivex/Flowable;", "merge", "mergeDelayError", "R", "Lkotlin/Function1;", SDKConstants.PARAM_A2U_BODY, "flatMapSequence", "(Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "", "Lkotlin/ParameterName;", "name", "args", "combineFunction", "combineLatest", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "zipFunction", "zip", "flowable", "Lkotlin/Pair;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "U", "flowable1", "flowable2", "Lkotlin/Triple;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "kotlin.jvm.PlatformType", "mergeAll", "(Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "concatAll", "switchLatest", "switchOnNext", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lio/reactivex/Single;", "", "", "toMap", "(Lio/reactivex/Flowable;)Lio/reactivex/Single;", "", "", "toMultimap", "Lorg/reactivestreams/Publisher;", "rxkotlin"}, k = 2, mv = {1, 4, 0})
public final class FlowableKt {

    public static final class a extends FunctionReference implements Function2<T, R, Pair<? extends T, ? extends R>> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(Pair.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/Object;Ljava/lang/Object;)V";
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            Intrinsics.checkParameterIsNotNull(obj, "p1");
            Intrinsics.checkParameterIsNotNull(obj2, "p2");
            return new Pair(obj, obj2);
        }
    }

    public static final class b extends FunctionReference implements Function3<T, R, U, Triple<? extends T, ? extends R, ? extends U>> {
        public static final b a = new b();

        public b() {
            super(3);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(Triple.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V";
        }

        @Override // kotlin.jvm.functions.Function3
        public Object invoke(Object obj, Object obj2, Object obj3) {
            Intrinsics.checkParameterIsNotNull(obj, "p1");
            Intrinsics.checkParameterIsNotNull(obj2, "p2");
            Intrinsics.checkParameterIsNotNull(obj3, "p3");
            return new Triple(obj, obj2, obj3);
        }
    }

    public static final class c<T, R> implements Function<T, Publisher<? extends R>> {
        public static final c a = new c();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Flowable flowable = (Flowable) obj;
            Intrinsics.checkParameterIsNotNull(flowable, "it");
            return flowable;
        }
    }

    public static final class d<T, R> implements Function<T, Publisher<? extends R>> {
        public static final d a = new d();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Flowable flowable = (Flowable) obj;
            Intrinsics.checkParameterIsNotNull(flowable, "it");
            return flowable;
        }
    }

    public static final class e<T, R> implements Function<T, Publisher<? extends R>> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Flowable flowable = (Flowable) obj;
            Intrinsics.checkParameterIsNotNull(flowable, "it");
            return flowable;
        }
    }

    public static final class f<T, R> implements Function<T, K> {
        public static final f a = new f();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkParameterIsNotNull(pair, "it");
            return pair.getFirst();
        }
    }

    public static final class g<T, R> implements Function<T, V> {
        public static final g a = new g();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkParameterIsNotNull(pair, "it");
            return pair.getSecond();
        }
    }

    public static final class h<T, R> implements Function<T, K> {
        public static final h a = new h();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkParameterIsNotNull(pair, "it");
            return pair.getFirst();
        }
    }

    public static final class i<T, R> implements Function<T, V> {
        public static final i a = new i();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkParameterIsNotNull(pair, "it");
            return pair.getSecond();
        }
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R> Flowable<R> combineLatest(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(iterable, new Function<Object[], R>(function1) { // from class: io.reactivex.rxkotlin.FlowableKt$combineLatest$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @NotNull
            public final R apply(@NotNull Object[] objArr) {
                Intrinsics.checkParameterIsNotNull(objArr, "it");
                Function1 function12 = this.a;
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

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Flowable<R>, io.reactivex.Flowable<T> */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> concatAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return (Flowable<R>) flowable.concatMap(c.a);
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R> Flowable<R> flatMapSequence(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, SDKConstants.PARAM_A2U_BODY);
        Flowable<R> flatMap = flowable.flatMap(new Function<T, Publisher<? extends R>>(function1) { // from class: io.reactivex.rxkotlin.FlowableKt$flatMapSequence$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function
            @NotNull
            public final Flowable<R> apply(@NotNull T t) {
                Intrinsics.checkParameterIsNotNull(t, "it");
                return FlowableKt.toFlowable((Sequence) this.a.invoke(t));
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "flatMap { body(it).toFlowable() }");
        return flatMap;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> merge(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Flowable<T> merge = Flowable.merge(toFlowable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(merge, "Flowable.merge(this.toFlowable())");
        return merge;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Flowable<R>, io.reactivex.Flowable<T> */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> mergeAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return (Flowable<R>) flowable.flatMap(d.a);
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> mergeDelayError(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Flowable<T> mergeDelayError = Flowable.mergeDelayError(toFlowable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(mergeDelayError, "Flowable.mergeDelayError(this.toFlowable())");
        return mergeDelayError;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Flowable<R>, io.reactivex.Flowable<T> */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> switchLatest(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return (Flowable<R>) flowable.switchMap(e.a);
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> switchOnNext(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Flowable<T> switchOnNext = Flowable.switchOnNext(flowable);
        Intrinsics.checkExpressionValueIsNotNull(switchOnNext, "Flowable.switchOnNext(this)");
        return switchOnNext;
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Boolean> toFlowable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(zArr));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.Single<java.util.Map<K, V>>, io.reactivex.Single<java.util.Map<A, B>> */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <A, B> Single<Map<A, B>> toMap(@NotNull Flowable<Pair<A, B>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return (Single<Map<K, V>>) flowable.toMap(f.a, g.a);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>>, io.reactivex.Single<java.util.Map<A, java.util.Collection<B>>> */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static final <A, B> Single<Map<A, Collection<B>>> toMultimap(@NotNull Flowable<Pair<A, B>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return (Single<Map<K, Collection<V>>>) flowable.toMultimap(h.a, i.a);
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T, R> Flowable<R> zip(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "zipFunction");
        Flowable<R> zip = Flowable.zip(iterable, new Function<Object[], R>(function1) { // from class: io.reactivex.rxkotlin.FlowableKt$zip$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @NotNull
            public final R apply(@NotNull Object[] objArr) {
                Intrinsics.checkParameterIsNotNull(objArr, "it");
                Function1 function12 = this.a;
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
    /* JADX WARN: Type inference failed for: r1v0, types: [s6.a.f.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R> io.reactivex.Flowable<kotlin.Pair<T, R>> combineLatest(@org.jetbrains.annotations.NotNull io.reactivex.Flowable<T> r2, @org.jetbrains.annotations.NotNull io.reactivex.Flowable<R> r3) {
        /*
            java.lang.String r0 = "$receiver"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "flowable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            io.reactivex.rxkotlin.FlowableKt$a r0 = io.reactivex.rxkotlin.FlowableKt.a.a
            if (r0 == 0) goto L_0x0014
            s6.a.f.b r1 = new s6.a.f.b
            r1.<init>(r0)
            r0 = r1
        L_0x0014:
            io.reactivex.functions.BiFunction r0 = (io.reactivex.functions.BiFunction) r0
            io.reactivex.Flowable r2 = io.reactivex.Flowable.combineLatest(r2, r3, r0)
            java.lang.String r3 = "Flowable.combineLatest(t…able, BiFunction(::Pair))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.FlowableKt.combineLatest(io.reactivex.Flowable, io.reactivex.Flowable):io.reactivex.Flowable");
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends Publisher<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return Flowable.concat(iterable);
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Byte> toFlowable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(bArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [s6.a.f.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R, U> io.reactivex.Flowable<kotlin.Triple<T, R, U>> combineLatest(@org.jetbrains.annotations.NotNull io.reactivex.Flowable<T> r2, @org.jetbrains.annotations.NotNull io.reactivex.Flowable<R> r3, @org.jetbrains.annotations.NotNull io.reactivex.Flowable<U> r4) {
        /*
            java.lang.String r0 = "$receiver"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "flowable1"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "flowable2"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            io.reactivex.rxkotlin.FlowableKt$b r0 = io.reactivex.rxkotlin.FlowableKt.b.a
            if (r0 == 0) goto L_0x0019
            s6.a.f.c r1 = new s6.a.f.c
            r1.<init>(r0)
            r0 = r1
        L_0x0019:
            io.reactivex.functions.Function3 r0 = (io.reactivex.functions.Function3) r0
            io.reactivex.Flowable r2 = io.reactivex.Flowable.combineLatest(r2, r3, r4, r0)
            java.lang.String r3 = "Flowable.combineLatest(t…le2, Function3(::Triple))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.FlowableKt.combineLatest(io.reactivex.Flowable, io.reactivex.Flowable, io.reactivex.Flowable):io.reactivex.Flowable");
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Character> toFlowable(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(cArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Short> toFlowable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(sArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(iArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Long> toFlowable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(jArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Float> toFlowable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(fArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Double> toFlowable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$receiver");
        return toFlowable(ArraysKt___ArraysKt.asIterable(dArr));
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> toFlowable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Flowable<T> fromArray = Flowable.fromArray(Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(fromArray, "Flowable.fromArray(*this)");
        return fromArray;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final Flowable<Integer> toFlowable(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "$receiver");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            Flowable<Integer> fromIterable = Flowable.fromIterable(intProgression);
            Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Flowable.fromIterable(this)");
            return fromIterable;
        }
        Flowable<Integer> range = Flowable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(range, "Flowable.range(first, Ma…max(0, last - first + 1))");
        return range;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static final <T> Flowable<T> toFlowable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Flowable<T> fromIterable = Flowable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        return toFlowable(SequencesKt___SequencesKt.asIterable(sequence));
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "$receiver");
        return toFlowable(new Object(it) { // from class: io.reactivex.rxkotlin.FlowableKt$toIterable$1
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
