package hu.akarnokd.rxjava2.util;

import io.reactivex.functions.BiFunction;
public enum BiFunctionSecondIdentity implements BiFunction<Object, Object, Object> {
    INSTANCE;

    public static <T, U> BiFunction<T, U, U> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.BiFunction
    public Object apply(Object obj, Object obj2) throws Exception {
        return obj2;
    }
}
