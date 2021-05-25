package org.funktionale.option;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt___StringsKt;
import org.funktionale.collections.NamespaceKt;
import org.funktionale.option.Option;
import org.funktionale.utils.GetterOperation;
import org.funktionale.utils.GetterOperationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a4\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00018\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u001a¢\u0006\u0004\b\u0012\u0010\u001c\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0001*\u00020\u001d¢\u0006\u0004\b\u0012\u0010\u001f\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020!0\u0001*\u00020 ¢\u0006\u0004\b\u0012\u0010\"\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020$0\u0001*\u00020#¢\u0006\u0004\b\u0012\u0010%\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020&¢\u0006\u0004\b\u0012\u0010(\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020*0\u0001*\u00020)¢\u0006\u0004\b\u0012\u0010+\u001a#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000,¢\u0006\u0004\b\u0012\u0010-\u001a#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000.¢\u0006\u0004\b\u0012\u0010/\u001a%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u000000¢\u0006\u0004\b\u0012\u00101\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u000202¢\u0006\u0004\b\u0012\u00103\u001aC\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00112\u001c\u00106\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001504j\b\u0012\u0004\u0012\u00028\u0000`5¢\u0006\u0004\b\u0012\u00107\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00142\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u00108\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00172\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u00109\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u001a2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u0010:\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0001*\u00020\u001d2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u0010;\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020!0\u0001*\u00020 2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u0010<\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020$0\u0001*\u00020#2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u0010=\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020&2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u0010>\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020*0\u0001*\u00020)2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u0010?\u001aA\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000,2\u001c\u00106\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001504j\b\u0012\u0004\u0012\u00028\u0000`5¢\u0006\u0004\b\u0012\u0010@\u001aA\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000002\u001c\u00106\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001504j\b\u0012\u0004\u0012\u00028\u0000`5¢\u0006\u0004\b\u0012\u0010A\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u0002022\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001504H\b¢\u0006\u0004\b\u0012\u0010B\u001aI\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010.0\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010C*\b\u0012\u0004\u0012\u00028\u00000.2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000104¢\u0006\u0004\bE\u0010F\u001a/\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.0\u0001\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010.¢\u0006\u0004\bG\u0010/\u001a)\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000.\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010.¢\u0006\u0004\bH\u0010I\u001aA\u0010K\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000104\"\u0004\b\u0000\u0010J\"\u0004\b\u0001\u0010C*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104¢\u0006\u0004\bK\u0010L\"A\u0010S\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010P\"\u0004\b\u0000\u0010M\"\u0004\b\u0001\u0010N*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O8F@\u0006¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006T"}, d2 = {"T", "Lorg/funktionale/option/Option;", "Lkotlin/Function0;", "default", "getOrElse", "(Lorg/funktionale/option/Option;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "alternative", "orElse", "(Lorg/funktionale/option/Option;Lkotlin/jvm/functions/Function0;)Lorg/funktionale/option/Option;", "value", "or", "(Lorg/funktionale/option/Option;Lorg/funktionale/option/Option;)Lorg/funktionale/option/Option;", "toOption", "(Ljava/lang/Object;)Lorg/funktionale/option/Option;", SDKConstants.PARAM_A2U_BODY, "optionTry", "(Lkotlin/jvm/functions/Function0;)Lorg/funktionale/option/Option;", "", "firstOption", "([Ljava/lang/Object;)Lorg/funktionale/option/Option;", "", "", "([Z)Lorg/funktionale/option/Option;", "", "", "([B)Lorg/funktionale/option/Option;", "", "", "([C)Lorg/funktionale/option/Option;", "", "", "([D)Lorg/funktionale/option/Option;", "", "", "([F)Lorg/funktionale/option/Option;", "", "", "([I)Lorg/funktionale/option/Option;", "", "", "([J)Lorg/funktionale/option/Option;", "", "", "([S)Lorg/funktionale/option/Option;", "", "(Ljava/lang/Iterable;)Lorg/funktionale/option/Option;", "", "(Ljava/util/List;)Lorg/funktionale/option/Option;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lorg/funktionale/option/Option;", "", "(Ljava/lang/String;)Lorg/funktionale/option/Option;", "Lkotlin/Function1;", "Lorg/funktionale/utils/Predicate;", "predicate", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([ZLkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([BLkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([CLkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([DLkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([FLkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([ILkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([JLkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "([SLkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "R", "f", "optionTraverse", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "optionSequential", "flatten", "(Ljava/util/List;)Ljava/util/List;", "P1", "optionLift", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lorg/funktionale/utils/GetterOperation;", "getOption", "(Ljava/util/Map;)Lorg/funktionale/utils/GetterOperation;", "option", "funktionale-option"}, k = 2, mv = {1, 4, 0})
public final class OptionKt {

    public static final class a extends Lambda implements Function1<K, Option<? extends V>> {
        public final /* synthetic */ Map a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map) {
            super(1);
            this.a = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return OptionKt.toOption(this.a.get(obj));
        }
    }

    public static final class b extends Lambda implements Function1<Option<? extends P1>, Option<? extends R>> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkParameterIsNotNull(option, "it");
            Function1 function1 = this.a;
            if (option.isEmpty()) {
                return Option.None.INSTANCE;
            }
            return new Option.Some(function1.invoke(option.get()));
        }
    }

    public static final class c extends Lambda implements Function1<Option<? extends T>, Option<? extends T>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkParameterIsNotNull(option, "it");
            return option;
        }
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(tArr));
    }

    @NotNull
    public static final <T> List<T> flatten(@NotNull List<? extends Option<? extends T>> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        ArrayList<T> arrayList = new ArrayList();
        for (T t : list) {
            if (t.isDefined()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (T t2 : arrayList) {
            arrayList2.add(t2.get());
        }
        return arrayList2;
    }

    @NotNull
    public static final <K, V> GetterOperation<K, Option<V>> getOption(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "$receiver");
        return new GetterOperationImpl(new a(map));
    }

    public static final <T> T getOrElse(@NotNull Option<? extends T> option, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(option, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "default");
        return option.isEmpty() ? (T) function0.invoke() : (T) option.get();
    }

    @NotNull
    public static final <P1, R> Function1<Option<? extends P1>, Option<R>> optionLift(@NotNull Function1<? super P1, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        return new b(function1);
    }

    @NotNull
    public static final <T> Option<List<T>> optionSequential(@NotNull List<? extends Option<? extends T>> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return optionTraverse(list, c.a);
    }

    @NotNull
    public static final <T, R> Option<List<R>> optionTraverse(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends Option<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Option<List<R>> some = new Option.Some<>(CollectionsKt__CollectionsKt.emptyList());
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                Option option = (Option) function1.invoke((Object) listIterator.previous());
                if (option.isEmpty()) {
                    some = Option.None.INSTANCE;
                } else if (some.isEmpty()) {
                    some = Option.None.INSTANCE;
                } else {
                    some = new Option.Some(NamespaceKt.prependTo(option.get(), some.get()));
                }
            }
        }
        return some;
    }

    @NotNull
    public static final <T> Option<T> optionTry(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, SDKConstants.PARAM_A2U_BODY);
        try {
            return new Option.Some(function0.invoke());
        } catch (Exception unused) {
            return Option.None.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.funktionale.option.Option<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.funktionale.option.Option<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Option<T> or(@NotNull Option<? extends T> option, @NotNull Option<? extends T> option2) {
        Intrinsics.checkParameterIsNotNull(option, "$receiver");
        Intrinsics.checkParameterIsNotNull(option2, "value");
        return option.isEmpty() ? option2 : option;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.funktionale.option.Option<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Option<T> orElse(@NotNull Option<? extends T> option, @NotNull Function0<? extends Option<? extends T>> function0) {
        Intrinsics.checkParameterIsNotNull(option, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "alternative");
        return option.isEmpty() ? (Option) function0.invoke() : option;
    }

    @NotNull
    public static final <T> Option<T> toOption(@Nullable T t) {
        if (t != null) {
            return new Option.Some(t);
        }
        return Option.None.INSTANCE;
    }

    @NotNull
    public static final Option<Boolean> firstOption(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(zArr));
    }

    @NotNull
    public static final Option<Byte> firstOption(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(bArr));
    }

    @NotNull
    public static final Option<Character> firstOption(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(cArr));
    }

    @NotNull
    public static final Option<Double> firstOption(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(dArr));
    }

    @NotNull
    public static final Option<Float> firstOption(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(fArr));
    }

    @NotNull
    public static final Option<Integer> firstOption(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(iArr));
    }

    @NotNull
    public static final Option<Long> firstOption(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(jArr));
    }

    @NotNull
    public static final Option<Short> firstOption(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$receiver");
        return toOption(ArraysKt___ArraysKt.firstOrNull(sArr));
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return toOption(CollectionsKt___CollectionsKt.firstOrNull(iterable));
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return toOption(CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list));
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        return toOption(SequencesKt___SequencesKt.firstOrNull(sequence));
    }

    @NotNull
    public static final Option<Character> firstOption(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        return toOption(StringsKt___StringsKt.firstOrNull(str));
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        T t;
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= tArr.length) {
                t = null;
                break;
            }
            t = tArr[i];
            if (function1.invoke(t).booleanValue()) {
                break;
            }
            i++;
        }
        return toOption(t);
    }

    @NotNull
    public static final Option<Boolean> firstOption(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(zArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= zArr.length) {
                bool = null;
                break;
            }
            boolean z = zArr[i];
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                bool = Boolean.valueOf(z);
                break;
            }
            i++;
        }
        return toOption(bool);
    }

    @NotNull
    public static final Option<Byte> firstOption(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Byte b2;
        Intrinsics.checkParameterIsNotNull(bArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= bArr.length) {
                b2 = null;
                break;
            }
            byte b3 = bArr[i];
            if (function1.invoke(Byte.valueOf(b3)).booleanValue()) {
                b2 = Byte.valueOf(b3);
                break;
            }
            i++;
        }
        return toOption(b2);
    }

    @NotNull
    public static final Option<Character> firstOption(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Character ch;
        Intrinsics.checkParameterIsNotNull(cArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= cArr.length) {
                ch = null;
                break;
            }
            char c2 = cArr[i];
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                ch = Character.valueOf(c2);
                break;
            }
            i++;
        }
        return toOption(ch);
    }

    @NotNull
    public static final Option<Double> firstOption(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Double d;
        Intrinsics.checkParameterIsNotNull(dArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= dArr.length) {
                d = null;
                break;
            }
            double d2 = dArr[i];
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                d = Double.valueOf(d2);
                break;
            }
            i++;
        }
        return toOption(d);
    }

    @NotNull
    public static final Option<Float> firstOption(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Float f;
        Intrinsics.checkParameterIsNotNull(fArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= fArr.length) {
                f = null;
                break;
            }
            float f2 = fArr[i];
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                f = Float.valueOf(f2);
                break;
            }
            i++;
        }
        return toOption(f);
    }

    @NotNull
    public static final Option<Integer> firstOption(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Integer num;
        Intrinsics.checkParameterIsNotNull(iArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= iArr.length) {
                num = null;
                break;
            }
            int i2 = iArr[i];
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                num = Integer.valueOf(i2);
                break;
            }
            i++;
        }
        return toOption(num);
    }

    @NotNull
    public static final Option<Long> firstOption(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Long l;
        Intrinsics.checkParameterIsNotNull(jArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= jArr.length) {
                l = null;
                break;
            }
            long j = jArr[i];
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                l = Long.valueOf(j);
                break;
            }
            i++;
        }
        return toOption(l);
    }

    @NotNull
    public static final Option<Short> firstOption(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Short sh;
        Intrinsics.checkParameterIsNotNull(sArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= sArr.length) {
                sh = null;
                break;
            }
            short s = sArr[i];
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                sh = Short.valueOf(s);
                break;
            }
            i++;
        }
        return toOption(sh);
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (function1.invoke(obj).booleanValue()) {
                break;
            }
        }
        return toOption(obj);
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(sequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (function1.invoke(obj).booleanValue()) {
                break;
            }
        }
        return toOption(obj);
    }

    @NotNull
    public static final Option<Character> firstOption(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Character ch;
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                ch = null;
                break;
            }
            char charAt = str.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                ch = Character.valueOf(charAt);
                break;
            }
            i++;
        }
        return toOption(ch);
    }
}
