package com.avito.android.util.rx3;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\f¢\u0006\u0004\b\n\u0010\u000e\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0012¢\u0006\u0004\b\n\u0010\u0014\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u0015¢\u0006\u0004\b\n\u0010\u0017\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u0018¢\u0006\u0004\b\n\u0010\u001a\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001*\u00020\u001b¢\u0006\u0004\b\n\u0010\u001d\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u001e¢\u0006\u0004\b\n\u0010\u001f\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0004\b\n\u0010!\u001a&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\"H\b¢\u0006\u0004\b\n\u0010#\u001a&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000$H\b¢\u0006\u0004\b\n\u0010%\u001a \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u0000H\b¢\u0006\u0004\b&\u0010'\u001a \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00020(H\b¢\u0006\u0004\b\n\u0010)\u001a=\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020*2\b\b\u0002\u0010,\u001a\u00020+2\u000e\b\u0004\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\bø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a+\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"¢\u0006\u0004\b0\u0010#\u001a+\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\"¢\u0006\u0004\b1\u0010#\u001a7\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020302¢\u0006\u0004\b4\u00105\u001aC\u00107\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u00106*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010$02¢\u0006\u0004\b7\u00105\u001a)\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001¢\u0006\u0004\b8\u00109\u001aX\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u00106*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010:2'\u0010>\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000:¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u000102¢\u0006\u0004\b?\u0010@\u001aX\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u00106*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010:2'\u0010A\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000:¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u000102¢\u0006\u0004\bB\u0010@\u001a*\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\n\b\u0000\u00106\u0018\u0001*\u00020**\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\bC\u00109\u001a1\u0010F\u001a\u00020E\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302¢\u0006\u0004\bF\u0010G\u001a\u0015\u0010H\u001a\u00020E*\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\bH\u0010I\u001a)\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000J0\u0001¢\u0006\u0004\bK\u00109\u001a7\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t02¢\u0006\u0004\bM\u00105\u001aG\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010N\u001a\u00020\t2\u0014\b\b\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302H\bø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001ae\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u00106*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00042\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\u001a\b\u0004\u0010A\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020TH\bø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001aO\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010W0\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00042\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\bø\u0001\u0000¢\u0006\u0004\bU\u0010X\u001a}\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00030\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u0010Y\"\u0004\b\u0003\u001062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00020\u00012 \b\u0004\u0010A\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030]H\bø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001ac\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u001062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\u001a\b\u0004\u0010>\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020TH\bø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a}\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00030\u0001\"\u0004\b\u0000\u0010Q\"\u0004\b\u0001\u0010R\"\u0004\b\u0002\u0010Y\"\u0004\b\u0003\u001062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00020\u00012 \b\u0004\u0010>\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030]H\bø\u0001\u0000¢\u0006\u0004\b`\u0010_\u0002\u0007\n\u0005\b20\u0001¨\u0006b"}, d2 = {"T", "Lio/reactivex/rxjava3/core/Flowable;", "emptyFlowable", "()Lio/reactivex/rxjava3/core/Flowable;", "Lkotlin/Function0;", SDKConstants.PARAM_A2U_BODY, "deferredFlowable", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Flowable;", "", "", "toFlowable", "([Z)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([B)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([S)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([I)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([J)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([F)Lio/reactivex/rxjava3/core/Flowable;", "", "", "([D)Lio/reactivex/rxjava3/core/Flowable;", "Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/IntProgression;)Lio/reactivex/rxjava3/core/Flowable;", "", "(Ljava/util/Iterator;)Lio/reactivex/rxjava3/core/Flowable;", "", "(Ljava/lang/Iterable;)Lio/reactivex/rxjava3/core/Flowable;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lio/reactivex/rxjava3/core/Flowable;", "toSingletonFlowable", "(Ljava/lang/Object;)Lio/reactivex/rxjava3/core/Flowable;", "", "(Ljava/lang/Throwable;)Lio/reactivex/rxjava3/core/Flowable;", "", "Lio/reactivex/rxjava3/core/BackpressureStrategy;", "backpressureStrategy", "block", "flowableFromCallableWithoutComplete", "(Lio/reactivex/rxjava3/core/BackpressureStrategy;Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Flowable;", "merge", "mergeDelayError", "Lkotlin/Function1;", "", "onError", "(Lio/reactivex/rxjava3/core/Flowable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Flowable;", "R", "flatMapSequence", "switchOnNext", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "", "Lkotlin/ParameterName;", "name", "args", "combineFunction", "combineLatest", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Flowable;", "zipFunction", "zip", "cast", "onNext", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscribeOnNext", "(Lio/reactivex/rxjava3/core/Flowable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/disposables/Disposable;", "subscribeIgnoreResult", "(Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/disposables/Disposable;", "Lorg/funktionale/option/Option;", "filterDefined", "predicate", "filterNot", "condition", "doOnNextIf", "(Lio/reactivex/rxjava3/core/Flowable;ZLkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Flowable;", "T1", "T2", "other", "Lkotlin/Function2;", "reverseZipWith", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/rxjava3/core/Flowable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Flowable;", "Lkotlin/Pair;", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/rxjava3/core/Flowable;)Lio/reactivex/rxjava3/core/Flowable;", "T3", "f1", "f2", "f3", "Lkotlin/Function3;", "flowableZip", "(Lio/reactivex/rxjava3/core/Flowable;Lio/reactivex/rxjava3/core/Flowable;Lio/reactivex/rxjava3/core/Flowable;Lkotlin/jvm/functions/Function3;)Lio/reactivex/rxjava3/core/Flowable;", "flowableCombineLatest", "(Lio/reactivex/rxjava3/core/Flowable;Lio/reactivex/rxjava3/core/Flowable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Flowable;", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Flowables")
public final class Flowables {

    public static final class a<T, R> implements Function<Object[], R> {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(objArr2, "it");
            List asList = ArraysKt___ArraysJvmKt.asList(objArr2);
            Objects.requireNonNull(asList, "null cannot be cast to non-null type kotlin.collections.List<T>");
            return function1.invoke(asList);
        }
    }

    public static final class b<T> implements Predicate<Option<? extends T>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            return ((Option) obj).isDefined();
        }
    }

    public static final class c<T, R> implements Function<Option<? extends T>, T> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return ((Option) obj).get();
        }
    }

    public static final class d<T> implements Predicate<T> {
        public final /* synthetic */ Function1 a;

        public d(Function1 function1) {
            this.a = function1;
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public final boolean test(T t) {
            return !((Boolean) this.a.invoke(t)).booleanValue();
        }
    }

    public static final class e<T, R> implements Function<T, Publisher<? extends R>> {
        public final /* synthetic */ Function1 a;

        public e(Function1 function1) {
            this.a = function1;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            Flowable fromIterable = Flowable.fromIterable(new Flowables$toFlowable$1((Sequence) this.a.invoke(obj)));
            Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(ob…@toFlowable.iterator()\n})");
            return fromIterable;
        }
    }

    public static final class f<T> implements Consumer<Object> {
        public static final f a = new f();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
        }
    }

    public static final class i<T, R> implements Function<Object[], R> {
        public final /* synthetic */ Function1 a;

        public i(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(objArr2, "it");
            List asList = ArraysKt___ArraysJvmKt.asList(objArr2);
            Objects.requireNonNull(asList, "null cannot be cast to non-null type kotlin.collections.List<T>");
            return function1.invoke(asList);
        }
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<U>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<R> */
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
        Flowable<T> defer = Flowable.defer(new a2.a.a.n3.z.d(function0));
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
        Flowable<T> doOnNext = flowable.doOnNext(new Consumer() { // from class: com.avito.android.util.rx3.Flowables$sam$i$io_reactivex_rxjava3_functions_Consumer$0
            @Override // io.reactivex.rxjava3.functions.Consumer
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

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: io.reactivex.rxjava3.core.Flowable<R>, java.lang.Object, io.reactivex.rxjava3.core.Flowable<T> */
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
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, new BiFunction<T1, T2, R>(function2) { // from class: com.avito.android.util.rx3.Flowables$flowableCombineLatest$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
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
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, new io.reactivex.rxjava3.functions.Function3<T1, T2, T3, R>(function3) { // from class: com.avito.android.util.rx3.Flowables$flowableZip$1
            public final /* synthetic */ Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function3
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
        Flowable fromIterable = Flowable.fromIterable(iterable);
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        Flowable<T> merge = Flowable.merge(fromIterable);
        Intrinsics.checkNotNullExpressionValue(merge, "Flowable.merge(this.toFlowable())");
        return merge;
    }

    @NotNull
    public static final <T> Flowable<T> mergeDelayError(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mergeDelayError");
        Flowable fromIterable = Flowable.fromIterable(iterable);
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        Flowable<T> mergeDelayError = Flowable.mergeDelayError(fromIterable);
        Intrinsics.checkNotNullExpressionValue(mergeDelayError, "Flowable.mergeDelayError(this.toFlowable())");
        return mergeDelayError;
    }

    @NotNull
    public static final <T> Flowable<T> onError(@NotNull Flowable<T> flowable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(flowable, "$this$onError");
        Intrinsics.checkNotNullParameter(function1, "block");
        Flowable<T> doOnError = flowable.doOnError(new a2.a.a.n3.z.c(function1));
        Intrinsics.checkNotNullExpressionValue(doOnError, "doOnError(block)");
        return doOnError;
    }

    @NotNull
    public static final <T1, T2, R> Flowable<R> reverseZipWith(@NotNull Function0<? extends Flowable<T1>> function0, @NotNull Flowable<T2> flowable, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function0, "$this$reverseZipWith");
        Intrinsics.checkNotNullParameter(flowable, "other");
        Intrinsics.checkNotNullParameter(function2, "zipFunction");
        Flowable<R> zip = Flowable.zip(flowable, (Publisher) function0.invoke(), new BiFunction<T2, T1, R>(function2) { // from class: com.avito.android.util.rx3.Flowables$reverseZipWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
            public final R apply(T2 t2, T1 t1) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "Flowable.zip(\n        ot…pFunction(t1, t2) }\n    )");
        return zip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.n3.z.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.rxjava3.disposables.Disposable subscribeIgnoreResult(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Flowable<?> r3) {
        /*
            java.lang.String r0 = "$this$subscribeIgnoreResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.util.rx3.Flowables$f r0 = com.avito.android.util.rx3.Flowables.f.a
            com.avito.android.util.rx3.Flowables$g r1 = com.avito.android.util.rx3.Flowables.g.a
            if (r1 == 0) goto L_0x0011
            a2.a.a.n3.z.c r2 = new a2.a.a.n3.z.c
            r2.<init>(r1)
            r1 = r2
        L_0x0011:
            io.reactivex.rxjava3.functions.Consumer r1 = (io.reactivex.rxjava3.functions.Consumer) r1
            io.reactivex.rxjava3.disposables.Disposable r3 = r3.subscribe(r0, r1)
            java.lang.String r0 = "subscribe({}, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx3.Flowables.subscribeIgnoreResult(io.reactivex.rxjava3.core.Flowable):io.reactivex.rxjava3.disposables.Disposable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.a.a.n3.z.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> io.reactivex.rxjava3.disposables.Disposable subscribeOnNext(@org.jetbrains.annotations.NotNull io.reactivex.rxjava3.core.Flowable<T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$subscribeOnNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            a2.a.a.n3.z.c r0 = new a2.a.a.n3.z.c
            r0.<init>(r3)
            com.avito.android.util.rx3.Flowables$h r3 = com.avito.android.util.rx3.Flowables.h.a
            if (r3 == 0) goto L_0x0019
            a2.a.a.n3.z.c r1 = new a2.a.a.n3.z.c
            r1.<init>(r3)
            r3 = r1
        L_0x0019:
            io.reactivex.rxjava3.functions.Consumer r3 = (io.reactivex.rxjava3.functions.Consumer) r3
            io.reactivex.rxjava3.disposables.Disposable r2 = r2.subscribe(r0, r3)
            java.lang.String r3 = "subscribe(onNext, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.rx3.Flowables.subscribeOnNext(io.reactivex.rxjava3.core.Flowable, kotlin.jvm.functions.Function1):io.reactivex.rxjava3.disposables.Disposable");
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
        Flowable<T> fromIterable = Flowable.fromIterable(new Object(it) { // from class: com.avito.android.util.rx3.Flowables$toIterable$1
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
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
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
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, new io.reactivex.rxjava3.functions.Function3<T1, T2, T3, R>(function3) { // from class: com.avito.android.util.rx3.Flowables$flowableCombineLatest$2
            public final /* synthetic */ Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function3
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
        Flowable<Boolean> fromIterable = Flowable.fromIterable(ArraysKt___ArraysKt.toList(zArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
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
        Flowable<Byte> fromIterable = Flowable.fromIterable(ArraysKt___ArraysKt.toList(bArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final Flowable<Short> toFlowable(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toFlowable");
        Flowable<Short> fromIterable = Flowable.fromIterable(ArraysKt___ArraysKt.toList(sArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toFlowable");
        Flowable<Integer> fromIterable = Flowable.fromIterable(ArraysKt___ArraysKt.toList(iArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final Flowable<Long> toFlowable(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toFlowable");
        Flowable<Long> fromIterable = Flowable.fromIterable(ArraysKt___ArraysKt.toList(jArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final Flowable<Float> toFlowable(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toFlowable");
        Flowable<Float> fromIterable = Flowable.fromIterable(ArraysKt___ArraysKt.toList(fArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final Flowable<Double> toFlowable(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toFlowable");
        Flowable<Double> fromIterable = Flowable.fromIterable(ArraysKt___ArraysKt.toList(dArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
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
        Flowable<T> fromIterable = Flowable.fromIterable(new Flowables$toFlowable$1(sequence));
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
