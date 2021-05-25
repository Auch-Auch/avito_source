package arrow.syntax.collections;

import androidx.exifinterface.media.ExifInterface;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.PartialFunction;
import arrow.core.PartialFunctionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aA\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007¢\u0006\u0004\b\u0003\u0010\t\u001aY\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\u000b*\u00020\n\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012*\u0010\u000f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "", "Larrow/core/Option;", "firstOption", "(Ljava/lang/Iterable;)Larrow/core/Option;", "Lkotlin/Function1;", "", "Larrow/core/Predicate;", "predicate", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Larrow/core/Option;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "", "Larrow/core/PartialFunction;", "cases", "", "collect", "(Ljava/lang/Iterable;[Larrow/core/PartialFunction;)Ljava/util/List;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class IterableKt {
    @NotNull
    public static final <A, B> List<B> collect(@NotNull Iterable<? extends A> iterable, @NotNull PartialFunction<? super A, ? extends B>... partialFunctionArr) {
        List list;
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(partialFunctionArr, "cases");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends A> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i = 1;
            if (!(partialFunctionArr.length == 0)) {
                PartialFunction<? super A, ? extends B> partialFunction = partialFunctionArr[0];
                int lastIndex = ArraysKt___ArraysKt.getLastIndex(partialFunctionArr);
                if (1 <= lastIndex) {
                    while (true) {
                        partialFunction = PartialFunctionKt.orElse(partialFunction, partialFunctionArr[i]);
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
                if (partialFunction.isDefinedAt(obj)) {
                    list = d.listOf(partialFunction.invoke(obj));
                } else {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                h.addAll(arrayList, list);
            } else {
                throw new UnsupportedOperationException("Empty array can't be reduced.");
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Option<T> firstOption(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        return OptionKt.toOption(CollectionsKt___CollectionsKt.firstOrNull(iterable));
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
        return OptionKt.toOption(obj);
    }
}
