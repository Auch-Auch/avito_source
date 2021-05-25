package arrow.syntax.collections;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.PredefKt;
import arrow.core.Some;
import arrow.legacy.Disjunction;
import arrow.legacy.DisjunctionKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t\u001aI\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\f\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0012\u0010\u0011\u001a)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0001¢\u0006\u0004\b\u0013\u0010\u0003\u001a]\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00010\u0015\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00150\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aA\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0015\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00150\u0001¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"T", "", "tail", "(Ljava/util/List;)Ljava/util/List;", "list", "prependTo", "(Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;", "Lkotlin/Pair;", "destructured", "(Ljava/util/List;)Lkotlin/Pair;", "R", "Lkotlin/Function1;", "Larrow/core/Option;", "f", "optionTraverse", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "optionSequential", "(Ljava/util/List;)Larrow/core/Option;", "firstOption", "flatten", "L", "Larrow/legacy/Disjunction;", "disjuntionTraverse", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Larrow/legacy/Disjunction;", "disjunctionSequential", "(Ljava/util/List;)Larrow/legacy/Disjunction;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class ListKt {

    public static final class a extends FunctionReference implements Function1<Disjunction<? extends L, ? extends R>, Disjunction<? extends L, ? extends R>> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "identity";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinPackage(PredefKt.class, "arrow-syntax");
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "identity(Ljava/lang/Object;)Ljava/lang/Object;";
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Disjunction disjunction = (Disjunction) obj;
            Intrinsics.checkParameterIsNotNull(disjunction, "p1");
            return (Disjunction) PredefKt.identity(disjunction);
        }
    }

    public static final class b extends Lambda implements Function2<R, List<? extends R>, List<? extends R>> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            List list = (List) obj2;
            Intrinsics.checkParameterIsNotNull(list, "tail");
            return ListKt.prependTo(obj, list);
        }
    }

    public static final class c extends FunctionReference implements Function1<Option<? extends T>, Option<? extends T>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "identity";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinPackage(PredefKt.class, "arrow-syntax");
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "identity(Ljava/lang/Object;)Ljava/lang/Object;";
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkParameterIsNotNull(option, "p1");
            return (Option) PredefKt.identity(option);
        }
    }

    @NotNull
    public static final <T> Pair<T, List<T>> destructured(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return TuplesKt.to(CollectionsKt___CollectionsKt.first((List<? extends Object>) list), tail(list));
    }

    @NotNull
    public static final <L, R> Disjunction<L, List<R>> disjunctionSequential(@NotNull List<? extends Disjunction<? extends L, ? extends R>> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return disjuntionTraverse(list, a.a);
    }

    @Deprecated(message = "arrow.data.Either is right biased. This method will be removed in future releases")
    @NotNull
    public static final <T, L, R> Disjunction<L, List<R>> disjuntionTraverse(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends Disjunction<? extends L, ? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Disjunction<L, List<R>> right = new Disjunction.Right<>(CollectionsKt__CollectionsKt.emptyList());
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                Disjunction disjunction = (Disjunction) function1.invoke((Object) listIterator.previous());
                if (disjunction instanceof Disjunction.Right) {
                    right = DisjunctionKt.map(disjunction, right, b.a);
                } else if (disjunction instanceof Disjunction.Left) {
                    right = new Disjunction.Left<>(((Disjunction.Left) disjunction).getValue());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return right;
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return OptionKt.toOption(CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list));
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
    public static final <T> Option<List<T>> optionSequential(@NotNull List<? extends Option<? extends T>> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return optionTraverse(list, c.a);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0021 */
    @NotNull
    public static final <T, R> Option<List<R>> optionTraverse(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends Option<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        Some some = new Some(CollectionsKt__CollectionsKt.emptyList());
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                Option option = (Option) function1.invoke((Object) listIterator.previous());
                if (option.isEmpty()) {
                    some = None.INSTANCE;
                } else if (some instanceof None) {
                    some = None.INSTANCE;
                } else if (some instanceof Some) {
                    some = new Some(prependTo(option.get(), (List) some.getT()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return some;
    }

    @NotNull
    public static final <T> List<T> prependTo(T t, @NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        return CollectionsKt___CollectionsKt.plus((Collection) d.listOf(t), (Iterable) list);
    }

    @NotNull
    public static final <T> List<T> tail(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return CollectionsKt___CollectionsKt.drop(list, 1);
    }
}
