package com.avito.android.util;

import a2.a.a.n3.j;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.sequences.Sequence;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\f¢\u0006\u0004\b\n\u0010\u000e\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0012¢\u0006\u0004\b\n\u0010\u0014\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u0015¢\u0006\u0004\b\n\u0010\u0017\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u0018¢\u0006\u0004\b\n\u0010\u001a\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001*\u00020\u001b¢\u0006\u0004\b\n\u0010\u001d\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u001e¢\u0006\u0004\b\n\u0010\u001f\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0004\b\n\u0010!\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0004\b\n\u0010#\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000$¢\u0006\u0004\b\n\u0010%\u001a\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u0000¢\u0006\u0004\b&\u0010'\u001a\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00020(¢\u0006\u0004\b\n\u0010)\u001a=\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020*2\b\b\u0002\u0010,\u001a\u00020+2\u000e\b\u0004\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\bø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a+\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"¢\u0006\u0004\b0\u0010#\u001a+\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"¢\u0006\u0004\b1\u0010#\u001a7\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020302¢\u0006\u0004\b4\u00105\u001aC\u00107\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u00106*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$02¢\u0006\u0004\b7\u00105\u001a)\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001¢\u0006\u0004\b8\u00109\u001aX\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u00106*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010:2'\u0010>\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000:¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u000102¢\u0006\u0004\b?\u0010@\u001aX\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u00106*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010:2'\u0010A\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000:¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u000102¢\u0006\u0004\bB\u0010@\u001a*\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\n\b\u0000\u00106\u0018\u0001*\u00020**\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\bC\u00109\u001a1\u0010F\u001a\u00020E\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302¢\u0006\u0004\bF\u0010G\u001a\u0015\u0010H\u001a\u00020E*\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\bH\u0010I\u001a)\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000J0\u0001¢\u0006\u0004\bK\u00109\u001a7\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t02¢\u0006\u0004\bM\u00105\u001aG\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010N\u001a\u00020\t2\u0014\b\b\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302H\bø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001ae\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u00106*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00042\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\u001a\b\u0004\u0010A\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020TH\bø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001aO\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010W0\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00042\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\bø\u0001\u0000¢\u0006\u0004\bU\u0010X\u001a}\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00030\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u0010Y\"\u0004\b\u0003\u001062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00020\u00012 \b\u0004\u0010A\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030]H\bø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001ac\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u001062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\u001a\b\u0004\u0010>\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020TH\bø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a}\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00030\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u0010Y\"\u0004\b\u0003\u001062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00020\u00012 \b\u0004\u0010>\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030]H\bø\u0001\u0000¢\u0006\u0004\b`\u0010_\u0002\u0007\n\u0005\b20\u0001¨\u0006b"}, d2 = {"T", "Lio/reactivex/Flowable;", "emptyFlowable", "()Lio/reactivex/Flowable;", "Lkotlin/Function0;", SDKConstants.PARAM_A2U_BODY, "deferredFlowable", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/Flowable;", "", "", "toFlowable", "([Z)Lio/reactivex/Flowable;", "", "", "([B)Lio/reactivex/Flowable;", "", "", "([S)Lio/reactivex/Flowable;", "", "", "([I)Lio/reactivex/Flowable;", "", "", "([J)Lio/reactivex/Flowable;", "", "", "([F)Lio/reactivex/Flowable;", "", "", "([D)Lio/reactivex/Flowable;", "Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/IntProgression;)Lio/reactivex/Flowable;", "", "(Ljava/util/Iterator;)Lio/reactivex/Flowable;", "", "(Ljava/lang/Iterable;)Lio/reactivex/Flowable;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lio/reactivex/Flowable;", "toSingletonFlowable", "(Ljava/lang/Object;)Lio/reactivex/Flowable;", "", "(Ljava/lang/Throwable;)Lio/reactivex/Flowable;", "", "Lio/reactivex/BackpressureStrategy;", "backpressureStrategy", "block", "flowableFromCallableWithoutComplete", "(Lio/reactivex/BackpressureStrategy;Lkotlin/jvm/functions/Function0;)Lio/reactivex/Flowable;", "merge", "mergeDelayError", "Lkotlin/Function1;", "", "onError", "(Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "R", "flatMapSequence", "switchOnNext", "(Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "", "Lkotlin/ParameterName;", "name", "args", "combineFunction", "combineLatest", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "zipFunction", "zip", "cast", "onNext", "Lio/reactivex/disposables/Disposable;", "subscribeOnNext", "(Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "subscribeIgnoreResult", "(Lio/reactivex/Flowable;)Lio/reactivex/disposables/Disposable;", "Lorg/funktionale/option/Option;", "filterDefined", "predicate", "filterNot", "condition", "doOnNextIf", "(Lio/reactivex/Flowable;ZLkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "T1", "T2", "other", "Lkotlin/Function2;", "reverseZipWith", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Flowable;", "Lkotlin/Pair;", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "T3", "f1", "f2", "f3", "Lkotlin/Function3;", "flowableZip", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function3;)Lio/reactivex/Flowable;", "flowableCombineLatest", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Flowable;", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Flowables")
public final class Flowables {

    public static final class a<T, R> implements Function<Object[], R> {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Intrinsics.checkNotNullParameter(objArr2, "it");
            Function1 function1 = this.a;
            List asList = ArraysKt___ArraysJvmKt.asList(objArr2);
            Objects.requireNonNull(asList, "null cannot be cast to non-null type kotlin.collections.List<T>");
            return function1.invoke(asList);
        }
    }

    public static final class b<T> implements Predicate<Option<? extends T>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "it");
            return option.isDefined();
        }
    }

    public static final class c<T, R> implements Function<Option<? extends T>, T> {
        public static final c a = new c();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "it");
            return option.get();
        }
    }

    public static final class d<T> implements Predicate<T> {
        public final /* synthetic */ Function1 a;

        public d(Function1 function1) {
            this.a = function1;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T t) {
            return !((Boolean) this.a.invoke(t)).booleanValue();
        }
    }

    public static final class e<T, R> implements Function<T, Publisher<? extends R>> {
        public final /* synthetic */ Function1 a;

        public e(Function1 function1) {
            this.a = function1;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return Flowables.toFlowable((Sequence) this.a.invoke(obj));
        }
    }

    public static final class f<T> implements Consumer<Object> {
        public static final f a = new f();

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object obj) {
        }
    }

    public static final class i<T, R> implements Function<Object[], R> {
        public final /* synthetic */ Function1 a;

        public i(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Intrinsics.checkNotNullParameter(objArr2, "it");
            Function1 function1 = this.a;
            List asList = ArraysKt___ArraysJvmKt.asList(objArr2);
            Objects.requireNonNull(asList, "null cannot be cast to non-null type kotlin.collections.List<T>");
            return function1.invoke(asList);
        }
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.Flowable<U>, java.lang.Object, io.reactivex.Flowable<R> */
    public static final /* synthetic */ <R> Flowable<R> cast(Flowable<?> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Flowable flowable2 = (Flowable<U>) flowable.cast(Object.class);
        Intrinsics.checkNotNullExpressionValue(flowable2, "cast(R::class.java)");
        return flowable2;
    }

    @NotNull
    public static final <T, R> Flowable<R> combineLatest(@NotNull List<? extends Flowable<T>> list, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$combineLatest");
        Intrinsics.checkNotNullParameter(function1, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(list, new a(function1));
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Flowable.combineLatest(t…it.asList() as List<T>) }");
        return combineLatest;
    }

    @NotNull
    public static final <T> Flowable<T> deferredFlowable(@NotNull Function0<? extends Flowable<T>> function0) {
        Intrinsics.checkNotNullParameter(function0, SDKConstants.PARAM_A2U_BODY);
        Flowable<T> defer = Flowable.defer(new j(function0));
        Intrinsics.checkNotNullExpressionValue(defer, "Flowable.defer(body)");
        return defer;
    }

    @NotNull
    public static final <T> Flowable<T> doOnNextIf(@NotNull Flowable<T> flowable, boolean z, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(flowable, "$this$doOnNextIf");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!z) {
            return flowable;
        }
        Flowable<T> doOnNext = flowable.doOnNext(new Consumer() { // from class: com.avito.android.util.Flowables$sam$i$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "doOnNext(block)");
        return doOnNext;
    }

    @NotNull
    public static final <T> Flowable<T> emptyFlowable() {
        Flowable<T> empty = Flowable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Flowable.empty()");
        return empty;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: io.reactivex.Flowable<R>, java.lang.Object, io.reactivex.Flowable<T> */
    @NotNull
    public static final <T> Flowable<T> filterDefined(@NotNull Flowable<Option<T>> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "$this$filterDefined");
        Flowable flowable2 = (Flowable<R>) flowable.filter(b.a).map(c.a);
        Intrinsics.checkNotNullExpressionValue(flowable2, "this\n    .filter { it.is…) }\n    .map { it.get() }");
        return flowable2;
    }

    @NotNull
    public static final <T> Flowable<T> filterNot(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(flowable, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Flowable<T> filter = flowable.filter(new d(function1));
        Intrinsics.checkNotNullExpressionValue(filter, "this\n    .filter { !predicate(it) }");
        return filter;
    }

    @NotNull
    public static final <T, R> Flowable<R> flatMapSequence(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(flowable, "$this$flatMapSequence");
        Intrinsics.checkNotNullParameter(function1, SDKConstants.PARAM_A2U_BODY);
        Flowable<R> flatMap = flowable.flatMap(new e(function1));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { body(it).toFlowable() }");
        return flatMap;
    }

    @NotNull
    public static final <T1, T2, R> Flowable<R> flowableCombineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(flowable, "f1");
        Intrinsics.checkNotNullParameter(flowable2, "f2");
        Intrinsics.checkNotNullParameter(function2, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, new BiFunction<T1, T2, R>(function2) { // from class: com.avito.android.util.Flowables$flowableCombineLatest$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Flowable.combineLatest(\n…eFunction(t1, t2) }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final <T> Flowable<T> flowableFromCallableWithoutComplete(@NotNull BackpressureStrategy backpressureStrategy, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(function0, "block");
        Flowable<T> create = Flowable.create(new Flowables$flowableFromCallableWithoutComplete$1(function0), backpressureStrategy);
        Intrinsics.checkNotNullExpressionValue(create, "Flowable.create({ emitte… }, backpressureStrategy)");
        return create;
    }

    public static /* synthetic */ Flowable flowableFromCallableWithoutComplete$default(BackpressureStrategy backpressureStrategy, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            backpressureStrategy = BackpressureStrategy.BUFFER;
        }
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(function0, "block");
        Flowable create = Flowable.create(new Flowables$flowableFromCallableWithoutComplete$1(function0), backpressureStrategy);
        Intrinsics.checkNotNullExpressionValue(create, "Flowable.create({ emitte… }, backpressureStrategy)");
        return create;
    }

    @NotNull
    public static final <T1, T2, T3, R> Flowable<R> flowableZip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(flowable, "f1");
        Intrinsics.checkNotNullParameter(flowable2, "f2");
        Intrinsics.checkNotNullParameter(flowable3, "f3");
        Intrinsics.checkNotNullParameter(function3, "zipFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, new io.reactivex.functions.Function3<T1, T2, T3, R>(function3) { // from class: com.avito.android.util.Flowables$flowableZip$1
            public final /* synthetic */ Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "Flowable.zip(\n        f1…ction(t1, t2, t3) }\n    )");
        return zip;
    }

    @NotNull
    public static final <T> Flowable<T> merge(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$merge");
        Flowable<T> merge = Flowable.merge(toFlowable(iterable));
        Intrinsics.checkNotNullExpressionValue(merge, "Flowable.merge(this.toFlowable())");
        return merge;
    }

    @NotNull
    public static final <T> Flowable<T> mergeDelayError(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mergeDelayError");
        Flowable<T> mergeDelayError = Flowable.mergeDelayError(toFlowable(iterable));
        Intrinsics.checkNotNullExpressionValue(mergeDelayError, "Flowable.mergeDelayError(this.toFlowable())");
        return mergeDelayError;
    }

    @NotNull
    public static final <T> Flowable<T> onError(@NotNull Flowable<T> flowable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(flowable, "$this$onError");
        Intrinsics.checkNotNullParameter(function1, "block");
        Flowable<T> doOnError = flowable.doOnError(new a2.a.a.n3.i(function1));
        Intrinsics.checkNotNullExpressionValue(doOnError, "doOnError(block)");
        return doOnError;
    }

    @NotNull
    public static final <T1, T2, R> Flowable<R> reverseZipWith(@NotNull Function0<? extends Flowable<T1>> function0, @NotNull Flowable<T2> flowable, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function0, "$this$reverseZipWith");
        Intrinsics.checkNotNullParameter(flowable, "other");
        Intrinsics.checkNotNullParameter(function2, "zipFunction");
        Flowable<R> zip = Flowable.zip(flowable, (Publisher) function0.invoke(), new BiFunction<T2, T1, R>(function2) { // from class: com.avito.android.util.Flowables$reverseZipWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T2 t2, T1 t1) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "Flowable.zip(\n        ot…pFunction(t1, t2) }\n    )");
        return zip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.n3.i] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.disposables.Disposable subscribeIgnoreResult(@org.jetbrains.annotations.NotNull io.reactivex.Flowable<?> r3) {
        /*
            java.lang.String r0 = "$this$subscribeIgnoreResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.util.Flowables$f r0 = com.avito.android.util.Flowables.f.a
            com.avito.android.util.Flowables$g r1 = com.avito.android.util.Flowables.g.a
            if (r1 == 0) goto L_0x0011
            a2.a.a.n3.i r2 = new a2.a.a.n3.i
            r2.<init>(r1)
            r1 = r2
        L_0x0011:
            io.reactivex.functions.Consumer r1 = (io.reactivex.functions.Consumer) r1
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r0, r1)
            java.lang.String r0 = "subscribe({}, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.Flowables.subscribeIgnoreResult(io.reactivex.Flowable):io.reactivex.disposables.Disposable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.a.a.n3.i] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> io.reactivex.disposables.Disposable subscribeOnNext(@org.jetbrains.annotations.NotNull io.reactivex.Flowable<T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$subscribeOnNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            a2.a.a.n3.i r0 = new a2.a.a.n3.i
            r0.<init>(r3)
            com.avito.android.util.Flowables$h r3 = com.avito.android.util.Flowables.h.a
            if (r3 == 0) goto L_0x0019
            a2.a.a.n3.i r1 = new a2.a.a.n3.i
            r1.<init>(r3)
            r3 = r1
        L_0x0019:
            io.reactivex.functions.Consumer r3 = (io.reactivex.functions.Consumer) r3
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r0, r3)
            java.lang.String r3 = "subscribe(onNext, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.Flowables.subscribeOnNext(io.reactivex.Flowable, kotlin.jvm.functions.Function1):io.reactivex.disposables.Disposable");
    }

    @NotNull
    public static final <T> Flowable<T> switchOnNext(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "$this$switchOnNext");
        Flowable<T> switchOnNext = Flowable.switchOnNext(flowable);
        Intrinsics.checkNotNullExpressionValue(switchOnNext, "Flowable.switchOnNext(this)");
        return switchOnNext;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "$this$toFlowable");
        return toFlowable(new Object(it) { // from class: com.avito.android.util.Flowables$toIterable$1
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

    @NotNull
    public static final <T> Flowable<T> toSingletonFlowable(T t) {
        Flowable<T> just = Flowable.just(t);
        Intrinsics.checkNotNullExpressionValue(just, "Flowable.just(this)");
        return just;
    }

    @NotNull
    public static final <T, R> Flowable<R> zip(@NotNull List<? extends Flowable<T>> list, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$zip");
        Intrinsics.checkNotNullParameter(function1, "zipFunction");
        Flowable<R> zip = Flowable.zip(list, new i(function1));
        Intrinsics.checkNotNullExpressionValue(zip, "Flowable.zip(this) { zip…it.asList() as List<T>) }");
        return zip;
    }

    @NotNull
    public static final <T1, T2, T3, R> Flowable<R> flowableCombineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(flowable, "f1");
        Intrinsics.checkNotNullParameter(flowable2, "f2");
        Intrinsics.checkNotNullParameter(flowable3, "f3");
        Intrinsics.checkNotNullParameter(function3, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, new io.reactivex.functions.Function3<T1, T2, T3, R>(function3) { // from class: com.avito.android.util.Flowables$flowableCombineLatest$2
            public final /* synthetic */ Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Flowable.combineLatest(\n…ction(t1, t2, t3) }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final Flowable<Boolean> toFlowable(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.toList(zArr));
    }

    @NotNull
    public static final <T1, T2> Flowable<Pair<T1, T2>> reverseZipWith(@NotNull Function0<? extends Flowable<T1>> function0, @NotNull Flowable<T2> flowable) {
        Intrinsics.checkNotNullParameter(function0, "$this$reverseZipWith");
        Intrinsics.checkNotNullParameter(flowable, "other");
        Flowable<Pair<T1, T2>> zip = Flowable.zip(flowable, (Publisher) function0.invoke(), Flowables$reverseZipWith$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(zip, "Flowable.zip(\n        ot…2, t1 -> t1 to t2 }\n    )");
        return zip;
    }

    @NotNull
    public static final Flowable<Byte> toFlowable(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.toList(bArr));
    }

    @NotNull
    public static final Flowable<Short> toFlowable(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.toList(sArr));
    }

    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.toList(iArr));
    }

    @NotNull
    public static final Flowable<Long> toFlowable(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.toList(jArr));
    }

    @NotNull
    public static final Flowable<Float> toFlowable(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.toList(fArr));
    }

    @NotNull
    public static final Flowable<Double> toFlowable(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.toList(dArr));
    }

    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "$this$toFlowable");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            Flowable<Integer> fromIterable = Flowable.fromIterable(intProgression);
            Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
            return fromIterable;
        }
        Flowable<Integer> range = Flowable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkNotNullExpressionValue(range, "Flowable.range(first, Ma…max(0, last - first + 1))");
        return range;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toFlowable");
        Flowable<T> fromIterable = Flowable.fromIterable(iterable);
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toFlowable");
        Flowable<T> fromIterable = Flowable.fromIterable(new Object(sequence) { // from class: com.avito.android.util.Flowables$toFlowable$1
            public final /* synthetic */ Sequence a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<T> iterator() {
                return this.a.iterator();
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(ob…@toFlowable.iterator()\n})");
        return fromIterable;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$toFlowable");
        Flowable<T> error = Flowable.error(th);
        Intrinsics.checkNotNullExpressionValue(error, "Flowable.error(this)");
        return error;
    }
}
