package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    public final Comparator<? super T> a;

    public SorterFunction(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) throws Throwable {
        return apply((List) ((List) obj));
    }

    public List<T> apply(List<T> list) {
        Collections.sort(list, this.a);
        return list;
    }
}
