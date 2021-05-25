package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    public final Comparator<? super T> a;

    public SorterFunction(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
        return apply((List) ((List) obj));
    }

    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.a);
        return list;
    }
}
